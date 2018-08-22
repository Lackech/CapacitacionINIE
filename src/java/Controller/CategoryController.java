/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.CategoryModel;
import entidades.Category;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

/**
 *
 * @author alro9
 */
@Named(value = "categoryController")
@ViewScoped
public class CategoryController implements Serializable {

   

    
    
    
    
    private int id;
    
    private String title;
    
    private String desc;

    private CategoryModel modeloCategoria;
    
    private HttpSession sesionHttp;
    
    private String message;
    
   
    
    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
                
        sesionHttp = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        
        modeloCategoria = new CategoryModel();

    }
    
    public String goInsert(){
        return "category.xhtml";
    }
    
    public String goDelete(){
        return "eraseCategory.xhtml";
    }
    
    public String goBack(){
        return "tableCategory.xhtml";
    }
    
    
    public void saveCategory(){      
        
        modeloCategoria.insertCategory(id, title, desc);
        
    }
    
    public void removeCategory(Category category){
               
        modeloCategoria.deleteCategory(category.getId());
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your row has been deleted") );
        
        PrimeFaces.current().ajax().update("form1:growl");
        
    }
    
    public String editCategory(){
        
        Category category = new Category(id,title,desc);
        modeloCategoria.updateCategory(category);
        return "tableCategory.xhtml";
    }
    
    
    public String showCategoryInfo(Category category){
               
        sesionHttp.setAttribute("CATEGORY_SELECT", category);
               
        return "dataCategory.xhtml";
    }
    
    public String updateCategoryInfo(Category category){
               
        sesionHttp.setAttribute("CATEGORY_SELECT", category);
        
        return "updateCategory.xhtml";
        
    }
    
    /*
    Metodo para el growl
    */
    public void showMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your row has been deleted") );
        context.addMessage(null, new FacesMessage("Update the webpage"));
    }
    
    
    
    
    
    
    
     /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }    
    

    /**
     * @return the id
     */
    public int getId() {
        if(sesionHttp.getAttribute("CATEGORY_SELECT") != null){
            id = ((Category) sesionHttp.getAttribute("CATEGORY_SELECT")).getId();
        }
        
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        if(sesionHttp.getAttribute("CATEGORY_SELECT") != null){
            title = ((Category) sesionHttp.getAttribute("CATEGORY_SELECT")).getTitle();
        }
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        if(sesionHttp.getAttribute("CATEGORY_SELECT") != null){
            desc = ((Category) sesionHttp.getAttribute("CATEGORY_SELECT")).getDescription();
        }
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    /**
     * @return the categories
     */
    public List<Category> getCategories() {     
        
        return modeloCategoria.getListCategories();
    }
    
    
    
    
    
   
    
    
    
}
