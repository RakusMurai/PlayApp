package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.NotNull;

/**
 * Article
 */
@Entity
public class Event extends Model {
    @Id
    public Integer id;
    @NotNull
    public String name;
    @NotNull
    public String message;
    
    public Finder<Long, Event> finder = new Finder<>(Event.class);

    public String toString() {
        return "Parent [id=" + id + ", name=" + name + ", message=" + message + "]";
    }
}