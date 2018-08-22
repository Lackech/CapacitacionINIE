/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import entidades.Category;
import entidades.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author alro9
 */



public class CategoryModel {
    
    public List<Category> getListCategories() {
        List<Category> listaCategorias = new ArrayList<>();
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q = sesionHibernate.createQuery("from Category");

            listaCategorias = q.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            if (sesionHibernate.isOpen()) {
                sesionHibernate.close();
            }
        }
        return listaCategorias;
    }
    
    public void insertCategory(int id,String title,String desc){
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccionHibernate = sesionHibernate.beginTransaction();
        
        try{
            Category category = new Category(id,title,desc);
            sesionHibernate.save(category);
            transaccionHibernate.commit();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            if(sesionHibernate.isOpen()){
                sesionHibernate.close();
            }
        }        
    }
    
    public void deleteCategory(int id){
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccionHibernate = sesionHibernate.beginTransaction();
        
        try{
            Category category = new Category(id,null,null);
            sesionHibernate.delete(category);
            transaccionHibernate.commit();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            if(sesionHibernate.isOpen()){
                sesionHibernate.close();
            }
        }
        
    }
    
    public void updateCategory(Category category){
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccionHibernate = sesionHibernate.beginTransaction();
        
        try{
            Category cat= (Category) sesionHibernate.get(Category.class, category.getId());
            cat.setId(category.getId());
            cat.setTitle(category.getTitle());
            cat.setDescription(category.getDescription());
            sesionHibernate.update(cat);           
            
            transaccionHibernate.commit();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            if(sesionHibernate.isOpen()){
                sesionHibernate.close();
            }
        }        
    }
    
    public List<String> getListCatNames(){
        List<String> listaCategorias = new ArrayList<>();
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q = sesionHibernate.createQuery("select title from Category");

            listaCategorias = q.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            if (sesionHibernate.isOpen()) {
                sesionHibernate.close();
            }
        }
        return listaCategorias;
    }
    
    
    
    
    
    
}
