package models.products;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Showing extends Model {
    @Id
    private Long id;
   
    @Constraints.Required
    @Temporal(TemporalType.DATE)
    private Date date;

    @Constraints.Required
    private double time;

    @Constraints.Required
    private int tickets;

    @Constraints.Required
    private double price;
    @ManyToOne
    private Movie movie;
    public Showing() {

    }

    public Showing(Long id,Date date,double time, int tickets, double price) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.tickets = tickets;
        this.price = price;
    }
    public static final Finder<Long, Showing> find = new Finder<>(Showing.class);
			    
    public static final List<Showing> findAll() {
        return Showing.find.all();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }
    public String getDateString() {
        return String.format("%1$td %1$tB %1$tY", date);
      }
    public void setDate(Date date) {
        this.date = date;
    }

public void decrementTickets(){
    tickets-=1;
}

public void incrementTickets(){
    tickets+=1;
}
public void incrementTickets(int q){
    tickets+=q;
}
}