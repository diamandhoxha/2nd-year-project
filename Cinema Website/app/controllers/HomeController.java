package controllers;

import play.mvc.*;

import views.html.*;

import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import models.*;
import models.users.*;
import models.products.*;

import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.FilePart;
import java.io.File;

import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;
import org.imgscalr.*;

public class HomeController extends Controller {

    private FormFactory formFactory;

    private Environment e;

    @Inject
    public HomeController(FormFactory f,Environment env) {
        this.e = env;
        this.formFactory = f;
}

    public Result Movies(Long cat) {
        List<Movie> itemList = null;
        List<Category> categoryList = Category.findAll();
        
        if(cat ==0){
            itemList = Movie.findAll();
        }else {
            itemList = Category.find.ref(cat).getItems();
            
        }


        return ok(Movies.render(itemList, categoryList,User.getUserById(session().get("email")),e));

     }

    public Result showings(Long cat) {
        List<Showing> showingList = null;
        Movie movie = Movie.find.byId(cat);
        if (cat.equals(null)) {
            return redirect(controllers.routes.HomeController.index(0));
        } else {
            showingList = movie.getShow();
        }
        return ok(showings.render(showingList,movie,User.getUserById(session().get("email"))));

     }

      public Result Merchandise(Long cat) {
        List<MerchandiseOnSale> itemList = null;
        List<Category3> categoryList = Category3.findAll();

        if(cat ==0){
            itemList = MerchandiseOnSale.findAll();
        }else {
           itemList = Category3.find.ref(cat).getMerchandise();
        }
        return ok(Merchandise.render(itemList, categoryList,User.getUserById(session().get("email"))));

     }

    public Result index(Long cat) {
        List<Movie> itemList = null;
        List<Category> categoryList = Category.findAll();
        List<Movie> smallList = new ArrayList<>();

        if(cat ==0){
            itemList = Movie.findAll();
        }else {
            itemList = Category.find.ref(cat).getItems();
        }
        for(int i=0;i<12;i++){
            smallList.add(itemList.get(i));
        }
        return ok(index.render(itemList, categoryList,smallList,User.getUserById(session().get("email")),e));
    }
    
    public Result food(Long cat) {
            List<Food> FoodList = new ArrayList<Food>();
            List<Category2> category2List = Category2.findAll();

            if(cat ==0){
                FoodList = Food.findAll();
            }else {
                FoodList = Category2.find.ref(cat).getItems();
            }
            return ok(food.render(FoodList, category2List,User.getUserById(session().get("email")),e));

        }


    public Result info(Long id) {
        
        Movie item = Movie.find.ref(id);

        return ok(info.render(item,User.getUserById(session().get("email")),e));
    }
    public Result infoComingSoon(Long id) {
        
        ComingSoonMovie item = ComingSoonMovie.find.ref(id);

        return ok(infoComingSoon.render(item,User.getUserById(session().get("email")),e));
    }


    public Result nearby() {
        

        return ok(nearby.render());
    }
    
    public Result ComingSoon(Long cat) {
        List<ComingSoonMovie> itemList = null;
        List<Category1> categoryList = Category1.findAll();
        
        if(cat ==0){
            itemList = ComingSoonMovie.findAll();
        }else {
            itemList = Category1.find.ref(cat).getItems();
            
        }


        return ok(ComingSoon.render(itemList, categoryList,User.getUserById(session().get("email")),e));

     }
    public Result showComingSoon(Long cat) {
        List<ComingSoonMovie> itemList = null;
        List<Category1> categoryList = Category1.findAll();
        
        if(cat ==0){
            itemList = ComingSoonMovie.findAll();
        }else {
            itemList = Category1.find.ref(cat).getItems();
            
        }


        return ok(showComingSoon.render(itemList, categoryList,User.getUserById(session().get("email")),e));

     }

    public Result showMovies(Long cat, String filter) {
        List<Movie> itemList = null;
        List<Category> categoryList = Category.findAll();
        
        if(cat ==0){
            itemList = Movie.findAll(filter);
        }else {
            itemList = Movie.findFilter(cat,filter);
            
        }


        return ok(showMovies.render(itemList, categoryList,cat,filter,User.getUserById(session().get("email")),e));

     }
@Security.Authenticated(Secured.class)
public Result addMovie() {
        Form<Movie> itemForm = formFactory.form(Movie.class);
        return ok(addMovie.render(itemForm,User.getUserById(session().get("email"))));
    }

@Security.Authenticated(Secured.class)
@Transactional
public Result addMovieSubmit() {

    Form<Movie> newItemForm = formFactory.form(Movie.class).bindFromRequest();
 
    if (newItemForm.hasErrors()) {

        return badRequest(addMovie.render(newItemForm,User.getUserById(session().get("email"))));
    } else {
        Movie newItem = newItemForm.get();

        List<Category> newCats = new ArrayList<Category>();
        for (Long cat : newItem.getCatSelect()) {
            newCats.add(Category.find.byId(cat));
        }
        newItem.setCategories (newCats);
        
        if(newItem.getId()==null){
        newItem.save();
        }else{
            newItem.update();
        }

        MultipartFormData<File> data = request().body().asMultipartFormData();
 
        FilePart<File> image = data.getFile("upload");

        String saveImageMessage = saveFile(newItem.getId(), image);

        flash("success", "Item " + newItem.getTitle() + " was added/updated.");

        return redirect(controllers.routes.HomeController.Movies(0));
    }
}


    @Security.Authenticated(Secured.class)
    public Result addFood() {
            Form<Food> FoodForm = formFactory.form(Food.class);
            return ok(addFood.render(FoodForm,User.getUserById(session().get("email"))));
        }

    @Security.Authenticated(Secured.class)
    @Transactional
    public Result addFoodSubmit() {

        Form<Food> newFoodForm = formFactory.form(Food.class).bindFromRequest();
    
        if (newFoodForm.hasErrors()) {

            return badRequest(addFood.render(newFoodForm,User.getUserById(session().get("email"))));
        } else {
            Food newFood = newFoodForm.get();

                        
            if(newFood.getId()==null){
            newFood.save();
            }else{
                newFood.update();
            }

            MultipartFormData<File> data = request().body().asMultipartFormData();
    
            FilePart<File> image = data.getFile("upload");

            String saveImageMessage = saveFile(newFood.getId(), image);

            flash("success", "Item " + newFood.getName() + " was added/updated.");

            return redirect(controllers.routes.HomeController.food(0));
        }
    }

    @Security.Authenticated(Secured.class)
    @Transactional
    @With(AuthAdmin.class)
    public Result deleteFood(Long id) {

        Food.find.ref(id).delete();

        
        flash("success", "Item has been deleted.");
        
        return redirect(controllers.routes.HomeController.food(0));
    }

    @Security.Authenticated(Secured.class)
    public Result updateFood(Long id) {
        Food i;
        Form<Food> FoodForm;

        try {
        
            i = Food.find.byId(id);

    
            FoodForm = formFactory.form(Food.class).fill(i);
        } catch (Exception ex) {
            return badRequest("error");
        }

    
        return ok(addFood.render(FoodForm,User.getUserById(session().get("email"))));
    }





@Security.Authenticated(Secured.class)
@Transactional
@With(AuthAdmin.class)
public Result deleteMovie(Long id) {

    Movie.find.ref(id).delete();

    
    flash("success", "Item has been deleted.");
    
    return redirect(controllers.routes.HomeController.Movies(0));
}

@Security.Authenticated(Secured.class)
public Result updateMovie(Long id) {
    Movie i;
    Form<Movie> itemForm;

    try {
    
        i = Movie.find.byId(id);

  
        itemForm = formFactory.form(Movie.class).fill(i);
    } catch (Exception ex) {
        return badRequest("error");
    }

  
    return ok(addMovie.render(itemForm,User.getUserById(session().get("email"))));
}

    public Result addShowing() {
        Form<Showing> showingForm = formFactory.form(Showing.class);
        return ok(addShowing.render(showingForm,User.getUserById(session().get("email"))));
}
public Result addShowingSubmit() {
    Form<Showing> newShowingForm = formFactory.form(Showing.class).bindFromRequest();

    if (newShowingForm.hasErrors()) {
        return badRequest(addShowing.render(newShowingForm,User.getUserById(session().get("email"))));
    } else {
        Showing newShowing = newShowingForm.get();
        if(newShowing.getId()==null){
        newShowing.save();
        }else{
            newShowing.update();
        }
        flash("success", "Showing was added/updated.");

        return redirect(controllers.routes.HomeController.Movies(0));
    }
}

public Result deleteShowing(Long id) {
    Showing.find.ref(id).delete();
    flash("success", "Showing has been deleted.");
    return redirect(controllers.routes.HomeController.Movies(0));
}

public Result updateShowing(Long id) {
    Showing s;
    Form<Showing> showingForm;

    try {
        s = Showing.find.byId(id);
        showingForm = formFactory.form(Showing.class).fill(s);
    } catch (Exception ex) {
        return badRequest("error");
    }

    return ok(addShowing.render(showingForm,User.getUserById(session().get("email"))));
}

@Security.Authenticated(Secured.class)
public Result addMovieComingSoon() {
        Form<ComingSoonMovie> itemForm = formFactory.form(ComingSoonMovie.class);
        return ok(addMovieComingSoon.render(itemForm,User.getUserById(session().get("email"))));
    }

@Security.Authenticated(Secured.class)
@Transactional
public Result addMovieComingSoonSubmit() {

    Form<ComingSoonMovie> newItemForm = formFactory.form(ComingSoonMovie.class).bindFromRequest();
 
    if (newItemForm.hasErrors()) {

        return badRequest(addMovieComingSoon.render(newItemForm,User.getUserById(session().get("email"))));
    } else {
        ComingSoonMovie newItem = newItemForm.get();

        List<Category1> newCats = new ArrayList<Category1>();
        for (Long cat : newItem.getCatSelect()) {
            newCats.add(Category1.find.byId(cat));
        }
        newItem.setCategories (newCats);
        
        if(newItem.getId()==null){
        newItem.save();
        }else{
            newItem.update();
        }

        MultipartFormData<File> data = request().body().asMultipartFormData();
 
        FilePart<File> image = data.getFile("upload");

        String saveImageMessage = saveFile(newItem.getId(), image);

        flash("success", "Item " + newItem.getTitle() + " was added/updated.");

        return redirect(controllers.routes.HomeController.ComingSoon(0));
    }
}

@Security.Authenticated(Secured.class)
@Transactional
@With(AuthAdmin.class)
public Result deleteMovieComingSoon(Long id) {

    ComingSoonMovie.find.ref(id).delete();

    
    flash("success", "Item has been deleted.");
    
    return redirect(controllers.routes.HomeController.ComingSoon(0));
}

@Security.Authenticated(Secured.class)
public Result updateMovieComingSoon(Long id) {
    ComingSoonMovie i;
    Form<ComingSoonMovie> itemForm;

    try {
    
        i = ComingSoonMovie.find.byId(id);

  
        itemForm = formFactory.form(ComingSoonMovie.class).fill(i);
    } catch (Exception ex) {
        return badRequest("error");
    }

  
    return ok(addMovieComingSoon.render(itemForm,User.getUserById(session().get("email"))));
}

@Security.Authenticated(Secured.class)
    public Result addMerchandise() {
        Form<MerchandiseOnSale> mForm = formFactory.form(MerchandiseOnSale.class);
        return ok(addMerchandise.render(mForm,User.getUserById(session().get("email"))));
}

@Security.Authenticated(Secured.class)
@Transactional
public Result addMerchandiseSubmit() {
    Form<MerchandiseOnSale> newItemForm = formFactory.form(MerchandiseOnSale.class).bindFromRequest();
    if (newItemForm.hasErrors()) {
        return badRequest(addMerchandise.render(newItemForm,User.getUserById(session().get("email"))));
    } else {
        MerchandiseOnSale newItem = newItemForm.get();
        
        if(newItem.getId()==null){
        newItem.save();
        }else{
            newItem.update();
        }
        flash("success", "Item " + newItem.getName() + " was added/updated.");
        return redirect(controllers.routes.HomeController.Merchandise(0));
    }
}

@Security.Authenticated(Secured.class)
@Transactional
@With(AuthAdmin.class)
public Result deleteMerchandise(Long id) {

    MerchandiseOnSale.find.ref(id).delete();

    flash("success", "Item has been deleted.");
    return redirect(controllers.routes.HomeController.Merchandise(0));
}

@Security.Authenticated(Secured.class)
public Result updateMerchandise(Long id) {
    MerchandiseOnSale i;
    Form<MerchandiseOnSale> itemForm;

    try {
        i = MerchandiseOnSale.find.byId(id);

        itemForm = formFactory.form(MerchandiseOnSale.class).fill(i);
    } catch (Exception ex) {
        return badRequest("error");
    }

    return ok(addMerchandise.render(itemForm,User.getUserById(session().get("email"))));
}



@Security.Authenticated(Secured.class)
@Transactional
@With(AuthAdmin.class)
public Result deleteAdmin(String email) {

    // The following line of code finds the item object by id, then calls the delete() method
    // on it to have it removed from the database.

        Administrator u = (Administrator)User.getUserById(email);
        u.delete();

    // Now write to the flash scope, as we did for the successful item creation.
    flash("success", "User has been deleted.");
    // And redirect to the onsale page
    return redirect(controllers.routes.HomeController.usersAdmin());
}

public Result updateAdmin(String email) {
    Administrator u;
    Form<Administrator> userForm;

    try {
        // Find the item by email
        u = (Administrator)User.getUserById(email);
        u.update();
        // Populate the form object with data from the user found in the database
        userForm = formFactory.form(Administrator.class).fill(u);
    } catch (Exception ex) {
        return badRequest("error");
    }
    // Display the "add item" page, to allow the user to update the item
    return ok(addAdmin.render(userForm,User.getUserById(session().get("email"))));
}

@Security.Authenticated(Secured.class)
public Result addAdmin() {
    Form<Administrator> userForm = formFactory.form(Administrator.class);
    return ok(addAdmin.render(userForm,User.getUserById(session().get("email"))));
}

public Result addAdminSubmit() {
Form<Administrator> userForm = formFactory.form(Administrator.class).bindFromRequest();

if (userForm.hasErrors()) {
    return badRequest(addAdmin.render(userForm,User.getUserById(session().get("email"))));
} else {

    Administrator newUser = userForm.get();
    
    if(User.getUserById(newUser.getEmail())==null){
        newUser.save();
    }else{
        newUser.update();
    }

    flash("success", "User " + newUser.getName() + " was added/updated.");

    return redirect(controllers.routes.HomeController.usersAdmin()); 
    }
}

public Result usersAdmin() {
    List<Administrator> userList = null;
    userList = Administrator.findAll();
    return ok(admin.render(userList,User.getUserById(session().get("email"))));

 }
 @Security.Authenticated(Secured.class)
 public Result usersCustomer() {
    List<Customer> cList = null;
    cList = Customer.findAll();
    return ok(customers.render(cList,User.getUserById(session().get("email"))));

 }
@Security.Authenticated(Secured.class)
public Result addCustomer() {
    Form<Customer> cForm = formFactory.form(Customer.class);
    return ok(addCustomer.render(cForm,User.getUserById(session().get("email"))));
}


public Result registerUser() {
    Form<Customer> userForm = formFactory.form(Customer.class);
    return ok(registerUser.render(userForm,User.getUserById(session().get("email"))));
}


@Transactional
public Result registerUserSubmit() {
Form<Customer> userForm = formFactory.form(Customer.class).bindFromRequest();
if (userForm.hasErrors()) {
    
    return badRequest(registerUser.render(userForm,User.getUserById(session().get("email"))));
} else {
    Customer newUser = userForm.get();
    
    newUser.save();
    
    flash("Successful register");
    return redirect(controllers.routes.HomeController.index(0)); 
    }
}

@Security.Authenticated(Secured.class)
@Transactional
public Result addCustomerSubmit() {
Form<Customer> userForm = formFactory.form(Customer.class).bindFromRequest();
if (userForm.hasErrors()) {
    
    return badRequest(addCustomer.render(userForm,User.getUserById(session().get("email"))));
} else {
    Customer newUser = userForm.get();
    
    if(User.getUserById(newUser.getEmail())==null){
        newUser.save();
    }else{
        newUser.update();
    }
    flash("success", "User " + newUser.getName() + " was added/updated.");
    return redirect(controllers.routes.HomeController.usersCustomer()); 
    }
}

@Security.Authenticated(Secured.class)
@Transactional
@With(AuthAdmin.class)
public Result deleteCustomer(String email) {

    // The following line of code finds the item object by id, then calls the delete() method
    // on it to have it removed from the database.

    Customer u = (Customer) User.getUserById(email);
    u.delete();

    // Now write to the flash scope, as we did for the successful item creation.
    flash("success", "User has been deleted.");
    // And redirect to the onsale page
    return redirect(controllers.routes.HomeController.usersCustomer());
}
@Security.Authenticated(Secured.class)
public Result updateCustomer(String email) {
    Customer u;
    Form<Customer> userForm;

    try {
        // Find the item by email
        u = (Customer) User.getUserById(email);
        u.update();

        // Populate the form object with data from the user found in the database
        userForm = formFactory.form(Customer.class).fill(u);
    } catch (Exception ex) {
        return badRequest("error");
    }

    // Display the "add item" page, to allow the user to update the item
    return ok(addCustomer.render(userForm,User.getUserById(session().get("email"))));
}

public String saveFileOld(Long id, FilePart<File> uploaded) {
    // Make sure that the file exists.
    if (uploaded != null) {
        // Make sure that the content is actually an image.
        String mimeType = uploaded.getContentType();
        if (mimeType.startsWith("image/")) {
            // Get the file name.
            String fileName = uploaded.getFilename();
            // Extract the extension from the file name.
            String extension = "";
            int i = fileName.lastIndexOf('.');
            if (i >= 0) {
                extension = fileName.substring(i + 1);
            }

            File file = uploaded.getFile();

            File dir = new File("public/images/productImages");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File newFile = new File("public/images/productImages/", id + "." + extension);
            if (file.renameTo(newFile)) {
                return "/ file uploaded.";
            } else {
                return "/ file upload failed.";
            }

        }
    }
    return "/ no image file.";
}

public String saveFile(Long id, FilePart<File> uploaded) {
    // Make sure that the file exists.
    if (uploaded != null) {
        // Make sure that the content is actually an image.
        String mimeType = uploaded.getContentType();
        if (mimeType.startsWith("image/")) {
            // Get the file name.
            String fileName = uploaded.getFilename();
            // Extract the extension from the file name.
            String extension = "";
            int i = fileName.lastIndexOf('.');
            if (i >= 0) {
                extension = fileName.substring(i + 1);
            }

            File file = uploaded.getFile();

            File dir = new File("public/images/productImages");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 3) Actually save the file.
            File newFile = new File("public/images/productImages/", id + "." + extension);
            if (file.renameTo(newFile)) {
                try {
                    BufferedImage img = ImageIO.read(newFile); 
                    BufferedImage scaledImg = Scalr.resize(img, 90);
                    
                    if (ImageIO.write(scaledImg, extension, new File("public/images/productImages/", id + "thumb.jpg"))) {
                        return "/ file uploaded and thumbnail created.";
                    } else {
                        return "/ file uploaded but thumbnail creation failed.";
                    }
                } catch (IOException e) {
                    return "/ file uploaded but thumbnail creation failed.";
                }
            } else {
                return "/ file upload failed.";
            }

        }
    }
    return "/ no image file.";
}
}
