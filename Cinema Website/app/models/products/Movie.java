package models.products;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Movie extends Model {

    // Properties
    @Id
    private Long id;
    @Constraints.Required
    private String title;
    @Constraints.Required
    private String description;
    @Constraints.Required
    private int screen;
    @Constraints.Required
    private int seats;
    @Constraints.Required
    private double price;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "items")
    private List<Category> categories;
    @OneToMany
    private List<Showing> show;
    // Default Constructor
    public Movie() {
    }

    // Constructor to initialise object
    public Movie(Long id, String title, String description,int screen, int seats, double price,List<Showing> show) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.screen = screen;
        this.seats = seats;
        this.price = price;
        this.show = show;
    }

    public static final Finder<Long, Movie> find = new Finder<>(Movie.class);
			    
public static final List<Movie> findAll() {
   return Movie.find.all();
}

    private List<Long> catSelect = new ArrayList<Long>();


    // Accessor methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getScreen() {
        return screen;
    }
    public void setScreen(int screen) {
        this.screen = screen;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

public List<Category> getCategories() {
    return categories;
}
public void setCategories(List <Category> categories) {
    this.categories = categories;
}
public List<Long> getCatSelect() {
    return catSelect;
}
public void setCatSelect(List<Long> catSelect) {
    this.catSelect = catSelect;
}
public List<Showing> getShow() {
    return show;
}

public void setShowings (List<Showing> show) {
    this.show = show;
}
public static Map<String,String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap();
 
    // Get all the categories from the database and add them to the options hash map
    for (Movie m: Movie.findAll()) {
       options.put(m.getId().toString(), m.getTitle());
    }
    return options;
 }

 public static List<Movie> findAll(String filter) {
     return Movie.find.query().where()
     .ilike("title", "%" + filter + "%")
     .orderBy("title asc")
     .findList();
 }

  public static List<Movie> findFilter(Long catID, String filter) {
     return Movie.find.query().where()

     .eq("categories.id", catID)
     .ilike("title", "%" + filter + "%")
     .orderBy("title asc")
     .findList();
 }
 
}