package models.products;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

// Product entity managed by Ebean
@Entity
public class Category2 extends Model {

   // Fields
   // Annotate id as primary key
   @Id
   private Long id;

   @Constraints.Required
   private String name;

   // Category contains many products
   @OneToMany(cascade = CascadeType.ALL)
   private List<Food> items;

   // Default constructor
   public  Category2() {
   }
			    
   public  Category2(Long id, String name, List<Food> items) {
      this.id = id;
      this.name = name;
      this.items = items;
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

public List<Food> getItems() {
    return this.items;
}

public void setItems (List<Food> items) {
    this.items = items;
}
   //Generic query helper for entity Computer with id Long
public static Finder<Long,Category2> find = new Finder<Long,Category2>(Category2.class);

//Find all Products in the database
public static List<Category2> findAll() {
   return Category2.find.query().where().orderBy("name asc").findList();
}

public static Map<String,String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap();
 
    // Get all the categories from the database and add them to the options hash map
    for (Category2 c: Category2.findAll()) {
       options.put(c.getId().toString(), c.getName());
    }
    return options;
 }



}