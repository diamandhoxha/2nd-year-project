package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.Inject;

import views.html.*;
import play.db.ebean.Transactional;
import play.api.Environment;

// Import models
import models.users.*;
import models.products.*;
import models.shopping.*;
import java.text.SimpleDateFormat;

import java.util.Calendar;

@Security.Authenticated(Secured.class)
// Authorise user (check if user is a customer)
@With(CheckIfCustomer.class)

public class ShoppingCtrl extends Controller {

    private FormFactory formFactory;
    private Environment env;

    @Inject
    public ShoppingCtrl(Environment e, FormFactory f) {
        this.env = e;
        this.formFactory = f;
    }
    // View an individual order
    @Transactional
    public Result viewOrder(long id) {
        ShopOrder order = ShopOrder.find.byId(id);
        return ok(orderConfirmed.render((Customer)User.getUserById(session().get("email")), order));
    }
    
    // Add item to customer basket
    @Transactional
    public Result addToBasket(Long id) {
        
        // Find the item on sale
        Showing item = Showing.find.byId(id);
        
        // Get basket for logged in customer
        Customer customer = (Customer)User.getUserById(session().get("email"));
        
        // Check if item in basket
        if (customer.getBasket() == null) {
            // If no basket, create one
            customer.setBasket(new Basket());
            customer.getBasket().setCustomer(customer);
            customer.update();
        }
        
        // Add product to the basket and save
        customer.getBasket().addShowing(item);
        customer.update();
        //Update stock
        item.decrementTickets();
        item.update();   
        // Show the basket contents     
        return ok(basket.render(customer));
    }
    @Transactional
    public Result emptyBasket() {
        
        Customer c = (Customer)User.getUserById(session().get("email"));
        c.getBasket().removeAllItems();
        c.getBasket().update();
        
        return ok(basket.render(c));
    }
    
    @Transactional
    public Result placeOrder() {
        Customer c = (Customer)User.getUserById(session().get("email"));
        
        // Create an order instance
        ShopOrder order = new ShopOrder();
        
        // Associate order with customer
        order.setCustomer(c);
        
        // Copy basket to order
        order.setItems(c.getBasket().getBasketItems());
        
        // Save the order now to generate a new id for this order
        order.save();
       
       // Move items from basket to order
        for (OrderItem i: order.getItems()) {
            // Associate with order
            i.setOrder(order);
            // Remove from basket
            i.setBasket(null);
            // update item
            i.update();
        }
        
        // Update the order
        order.update();
        
        // Clear and update the shopping basket
        c.getBasket().setBasketItems(null);
        c.getBasket().update();
        
        // Show order confirmed view
        return ok(orderConfirmed.render(c, order));
    }
    @Transactional
    public Result showBasket() {
        return ok(basket.render((Customer)User.getUserById(session().get("email"))));
    }
    // Add an item to the basket
    @Transactional
    public Result addOne(Long itemId, Long pid) {
        
        // Get the order item
        OrderItem item = OrderItem.find.byId(itemId);

        Showing ios = Showing.find.byId(pid);

        if(ios.getTickets()>0){
        // Increment quantity
        item.increaseQty();
        // Save
        item.update();
        ios.decrementTickets();
        ios.update();
        }else{
            flash("error","Sorry, no more of these items left");
        }
        // Show updated basket
        return redirect(routes.ShoppingCtrl.showBasket());
    }

    @Transactional
    public Result removeOne(Long itemId, Long pid) {
        
        // Get the order item
        OrderItem item = OrderItem.find.byId(itemId);

        Showing ios = Showing.find.byId(pid);
        // Get user
        Customer c = (Customer)User.getUserById(session().get("email"));
        // Call basket remove item method
        c.getBasket().removeItem(item,ios);
        c.getBasket().update();
        // back to basket
        return ok(basket.render(c));
    }
    @Transactional
    public Result ViewShowingOrders() {       
        return ok(ViewShowingOrders.render((Customer)User.getUserById(session().get("email"))));
    }
    @Transactional
    public Result cancelOrder(Long orderId){
        ShopOrder order = ShopOrder.find.byId(orderId);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        
        c1=order.getOrderDate();
        if(compareDates(c1,c2)){
           // order.removeAllItems(orderId);
           order.adjustTickets();
           order.delete();
           
            flash("success", "Your order has been cancelled");
        }else {
            flash("success", "Sorry, it is too late to cancel this order");
        }
        return ok(ViewShowingOrders.render((Customer)User.getUserById(session().get("email"))));
    }

    public boolean compareDates(Calendar c1, Calendar c2){
        boolean allowed = true;
        long miliSecondForDate1 = c1.getTimeInMillis();
        long miliSecondForDate2 = c2.getTimeInMillis();
        // Calculate the difference in millisecond between two dates
        long diffInMilis = miliSecondForDate2 - miliSecondForDate1;

        long diffInMinutes = diffInMilis / (60 * 1000);
        if(diffInMinutes >60){
            allowed=false;
        }
        return allowed;
    }

}