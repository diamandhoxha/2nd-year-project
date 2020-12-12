package models.products;


import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

// Product entity managed by Ebean
@Entity
public class Category3 extends Model {

   // Fields
   // Annotate id as primary key
   @Id
   private Long id;

   @Constraints.Required
   private String name;

   // Category contains many products
   @OneToMany
   private List<MerchandiseOnSale> merchandise;

   // Default constructor
   public  Category3() {
   }
			    
   public  Category3(Long id, String name, List<MerchandiseOnSale> merchandise) {
      this.id = id;
      this.name = name;
      this.merchandise = merchandise;
   }
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

public List<MerchandiseOnSale> getMerchandise() {
    return merchandise;
}

public void setMerchandise (List<MerchandiseOnSale> merchandise) {
    this.merchandise = merchandise;
}
   //Generic query helper for entity Computer with id Long
public static Finder<Long,Category3> find = new Finder<Long,Category3>(Category3.class);

//Find all Products in the database
public static List<Category3> findAll() {
   return Category3.find.query().where().orderBy("name asc").findList();
}

public static Map<String,String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap();
 
    // Get all the categories from the database and add them to the options hash map
    for (Category3 c: Category3.findAll()) {
       options.put(c.getId().toString(), c.getName());
    }
    return options;
 }
}