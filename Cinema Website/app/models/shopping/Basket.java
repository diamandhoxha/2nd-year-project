package models.shopping;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import models.products.*;
import models.users.*;


// Product entity managed by Ebean
@Entity
public class Basket extends Model {

    @Id
    private Long id;
    
    // Default constructor
    public  Basket() {
    }
    
	
   //Generic query helper
    public static Finder<Long,Basket> find = new Finder<Long,Basket>(Basket.class);

    //Find all Products in the database
    public static List<Basket> findAll() {
        return Basket.find.all();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     @OneToMany(mappedBy = "basket", cascade = CascadeType.PERSIST)
    private List<OrderItem> basketItems;
    
    @OneToOne
    private Customer customer;


    public List<OrderItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<OrderItem> basketItems) {
        this.basketItems = basketItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addShowing(Showing item) {
        
        boolean itemFound = false;
        for (OrderItem oi : basketItems) {
            if (oi.getItem().getId() == item.getId()) {
                oi.increaseQty();
                itemFound = true;
                break;
            }
        }
        if (itemFound == false) {

            OrderItem newItem = new OrderItem(item);

            basketItems.add(newItem);
        }
    }

    public double getBasketTotal() {
        
        double total = 0;
        
        for (OrderItem i: basketItems) {
            total += i.getItemTotal();
        }
        return total;
    }

    public void removeItem(OrderItem item, Showing ios) {

        for (Iterator<OrderItem> iter = basketItems.iterator(); iter.hasNext();) {
            OrderItem i = iter.next();
            if (i.getId().equals(item.getId()))
            {

                if (i.getQuantity() > 1 ) {
                    i.decreaseQty();
                    ios.incrementTickets();
                    ios.update();
                }

                else {

                    i.delete();
                                        ios.incrementTickets();
                    ios.update();
                    // remove object from list
                    iter.remove();
                    break;
                }             
            }
       }
    }


    public void removeAllItems() {
        for(OrderItem i: this.basketItems) {
            Showing ios = Showing.find.byId(i.getItem().getId());
            if(ios.getId() == i.getItem().getId()){
                int quantity = i.getQuantity();
                ios.incrementTickets(quantity);
                ios.update();
            }
            i.delete();
        }
        this.basketItems = null;
    }

}
