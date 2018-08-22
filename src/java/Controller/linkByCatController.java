/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.CategoryModel;
import Models.LinkModel;
import entidades.Category;
import entidades.Link;
import java.io.Serializable;
import java.util.List;
import static java.util.Spliterators.iterator;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author alro9
 */
@Named(value = "linkByCatController")
@ViewScoped
public class linkByCatController implements Serializable {

    
    private CategoryModel modeloCategoria;
    private LinkModel modeloLink;
    private List<String> catNames;
    
    
    

    /**
     * Creates a new instance of linkByCatController
     */
    public linkByCatController() {
        
        modeloCategoria = new CategoryModel();
        modeloLink = new LinkModel();
        
    }
    
    public List<Category> getListCategories(){
        return modeloCategoria.getListCategories();
    }
    
    public List<Link> getListLinks(){
        return modeloLink.getListLinks();
    }
    
    public void getListLinkByCat(){
        
    }
    
    
    public void onCatChange(Category category){
       
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @return the catNames
     */
    public List<String> getCatNames() {
        
        return catNames;
    }

    /**
     * @param catNames the catNames to set
     */
    public void setCatNames(List<String> catNames) {
        this.catNames = catNames;
    }
    
    
}
