package models.products;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class ItemOnSale extends Model {

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

    // Default Constructor
    public ItemOnSale() {
    }

    // Constructor to initialise object
    public ItemOnSale(Long id, String title, String description,int screen, int seats, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.screen = screen;
        this.seats = seats;
        this.price = price;
    }

    public static final Finder<Long, ItemOnSale> find = new Finder<>(ItemOnSale.class);
			    
public static final List<ItemOnSale> findAll() {
   return ItemOnSale.find.all();
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
public void setCategories(List<Category> categories) {
    this.categories = categories;
}
public List<Long> getCatSelect() {
    return catSelect;
}
public void setCatSelect(List<Long> catSelect) {
    this.catSelect = catSelect;
}
}