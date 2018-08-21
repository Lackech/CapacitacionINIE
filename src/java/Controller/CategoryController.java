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
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

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

    private List<Category> categories;
    
    private HttpSession sesionHttp;
    
   
    
    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
        
        CategoryModel modeloCategoria = new CategoryModel();
        
        this.setCategories(modeloCategoria.getListCategories()); 
        
        sesionHttp = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        
        
        
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
        
        CategoryModel modeloCategoria = new CategoryModel();
        
        modeloCategoria.insertCategory(id, title, desc);
        
    }
    
    public void removeCategory(int id){
        
        CategoryModel modeloCategoria = new CategoryModel();
        
        modeloCategoria.deleteCategory(id);
    
        System.out.println("Works");
    
    }
    
    public String editCategory(){
        CategoryModel modeloCategoria = new CategoryModel();
        Category category = new Category(id,title,desc);
        modeloCategoria.updateCategory(category);
        return "tableCategory.xhtml";
    }
    
    
    public String showCategoryInfo(Category category){
        
        CategoryModel modeloCategoria = new CategoryModel();
        
        sesionHttp.setAttribute("CATEGORY_SELECT", category);
        
       
        return "dataCategory.xhtml";
    }
    
    public String updateCategoryInfo(Category category){
        
        CategoryModel modeloCategoria = new CategoryModel();
        
        sesionHttp.setAttribute("CATEGORY_SELECT", category);
        
        return "updateCategory.xhtml";
        
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
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
   
    
    
    
}
