package entidades;
// Generated Aug 8, 2018 3:30:00 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private int id;
     private String title;
     private String description;
     private Set links = new HashSet(0);

    public Category() {
    }

	
    public Category(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Category(int id, String title, String description, Set links) {
       this.id = id;
       this.title = title;
       this.description = description;
       this.links = links;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getLinks() {
        return this.links;
    }
    
    public void setLinks(Set links) {
        this.links = links;
    }




}


