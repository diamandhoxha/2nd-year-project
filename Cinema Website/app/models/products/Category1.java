package models.products;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

// Product entity managed by Ebean
@Entity
public class Category1 extends Model {

   // Fields
   // Annotate id as primary key
   @Id
   private Long id;

   @Constraints.Required
   private String title;

   // Category contains many products
   @ManyToMany(cascade = CascadeType.ALL)
   private List<ComingSoonMovie> items;

   // Default constructor
   public  Category1() {
   }
			    
   public  Category1(Long id, String title, List<ComingSoonMovie> items) {
      this.id = id;
      this.title = title;
      this.items = items;
   }
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

public List<ComingSoonMovie> getItems() {
    return items;
}

public void setItems (List<ComingSoonMovie> items) {
    this.items = items;
}
   //Generic query helper for entity Computer with id Long
public static Finder<Long,Category1> find = new Finder<Long,Category1>(Category1.class);

//Find all Products in the database
public static List<Category1> findAll() {
   return Category1.find.query().where().orderBy("title asc").findList();
}

public static Map<String,String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap();
 
    // Get all the categories from the database and add them to the options hash map
    for (Category1 c: Category1.findAll()) {
       options.put(c.getId().toString(), c.getTitle());
    }
    return options;
 }

public static boolean inCategory1(Long category, Long item) {
    return find.query().where().eq("items.id", item)
                       .eq("id", category)
                       .findList().size() > 0;
}

}