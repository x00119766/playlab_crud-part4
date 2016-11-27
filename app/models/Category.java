package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

// Category Entity managed by the ORM
@Entity
public class Category extends Model {

    // Properties
    // Annotate id as the primary key
    @Id
    private Long id;

    // Other fields marked as being required (for validation purposes)
    @Constraints.Required
    private String name;

   @OneToMany
   private List<Product> products;

    // Default constructor
    public  Category() {
    }

    // Constructor to initialise object
    public  Category(Long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
       this.products = products;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Category> find = new Finder<Long,Category>(Category.class);

    // Find all Products in the database
    // Filter product name 
    public static List<Category> findAll() {
        return Category.find.all();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static Map<String,String> options(){
        LinkedHashMap<String,String> options = new LinkedHashMap<>();

        for(Category c: Category.findAll()){
            options.put(c.getId().toString(), c.getName());
        }
        return options;
    }
}