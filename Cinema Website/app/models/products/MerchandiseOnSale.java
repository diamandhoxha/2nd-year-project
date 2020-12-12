package models.products;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class MerchandiseOnSale extends Model {

    // Properties
    @Id
    private Long id;
    @Constraints.Required
    private String name;
    @Constraints.Required
    private int stock;
    @Constraints.Required
    private double price;

    @ManyToOne
    private Category3 category3;

    // Default Constructor
    public MerchandiseOnSale() {
    }

    // Constructor to initialise object
    public MerchandiseOnSale(Long id, String name,  int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public static final Finder<Long, MerchandiseOnSale> find = new Finder<>(MerchandiseOnSale.class);
			    
public static final List<MerchandiseOnSale> findAll() {
   return MerchandiseOnSale.find.all();
}

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
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
}

public Category3 getCategory3() {
    return category3;
}
public void setCategory3(Category3 category3) {
    this.category3 = category3;
}
}