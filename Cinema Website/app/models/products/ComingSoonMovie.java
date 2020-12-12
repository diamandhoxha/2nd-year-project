package models.products;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class ComingSoonMovie extends Model {

    // Properties
    @Id
    private Long id;
    @Constraints.Required
    private String title;
    @Constraints.Required
    private String description;
   
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "items")
    private List<Category1> categories;

    // Default Constructor
    public ComingSoonMovie() {
    }

    // Constructor to initialise object
    public ComingSoonMovie(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static final Finder<Long, ComingSoonMovie> find = new Finder<>(ComingSoonMovie.class);
			    
public static final List<ComingSoonMovie> findAll() {
   return ComingSoonMovie.find.all();
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
    

public List<Category1> getCategories() {
    return categories;
}
public void setCategories(List<Category1> categories) {
    this.categories = categories;
}
public List<Long> getCatSelect() {
    return catSelect;
}
public void setCatSelect(List<Long> catSelect) {
    this.catSelect = catSelect;
}
}