package models.products;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Food extends Model {

    // Properties
    @Id
    private Long id;
    @Constraints.Required
    private String name;
    @Constraints.Required
    private String size;
    @Constraints.Required
    private double price;

    @ManyToOne
	private Category2 category2;

    // Default Constructor
    public Food() {
    }

    // Constructor to initialise object
    public Food(Long id, String name, String size, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public static final Finder<Long, Food> find = new Finder<>(Food.class);
			    
public static final List<Food> findAll() {
   return Food.find.all();
}

        private List<Long> catSelect = new ArrayList<Long>();


    // Accessor methods
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
}



public Category2 getCategory2() {
    return category2;
}
public void setCategory2(Category2 category2) {
    this.category2 = category2;
}
}