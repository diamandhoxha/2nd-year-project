package controllers;

import play.mvc.*;

import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import models.users.*;
import models.users.UserPassword2;

import views.html.*;

public class LoginController extends Controller {
    private FormFactory formFactory;
 
    @Inject
    public LoginController(FormFactory f) {
        this.formFactory = f;
    }
    
    public Result login() {
        Form<Login> loginForm = formFactory.form(Login.class);
        return ok(login.render(loginForm,User.getUserById(session().get("email"))));
}
public Result loginSubmit() {
    Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();

    if (loginForm.hasErrors()) {
        return badRequest(login.render(loginForm,User.getUserById(session().get("email"))));
    } else {

        session().clear();

        // Store the logged-in email in a cookie i.e. start a new session
        session("email", loginForm.get().getEmail());

        return redirect(controllers.routes.HomeController.index(0));
    }
}
public Result logout() {
    // To log the user out, we just delete the current session
    session().clear();
    flash("success", "You have been logged out");
    return redirect(routes.LoginController.login());
}

// public Result registerUser() {
//     Form<UserPassword2> regForm = formFactory.form(UserPassword2.class);
//     return ok(registerUser.render(regForm,User.getUserById(session().get("email"))));
// }

// public Result registerUserSubmit() {

//     Form<User> newUserForm = formFactory.form(User.class).bindFromRequest();
//     Form<UserPassword2> newUserForm2 = formFactory.form(UserPassword2.class).bindFromRequest();

//     if (newUserForm.hasErrors()) {

//         return badRequest(registerUser.render(newUserForm2,User.getUserById(session().get("email"))));
//     } else {

//         User  newUser = newUserForm.get();
//         UserPassword2 newUser2 = newUserForm2.get();


//         if(!newUser2.getPassword2().equals(newUser2.getPassword())){
//             flash("error", "Passwords must match "); 
//             return redirect(controllers.routes.LoginController.registerUser());
            
//         } 
    
//         if(User.getUserById(newUser.getEmail())==null){
//             newUser.save();
//         }else{
//             newUser.update();
//         }

//     flash("success", "User " + newUser.getName() + " was registered.");

//     return redirect(controllers.routes.LoginController.login()); 
//     }
// }



}