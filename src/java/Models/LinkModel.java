/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import entidades.Category;
import entidades.HibernateUtil;
import entidades.Link;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alro9
 */
public class LinkModel {
    
    public List<Link> getListLinks() {
        List<Link> listaLinks = new ArrayList<>();
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q = sesionHibernate.createQuery("from Link");

            listaLinks = q.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            if (sesionHibernate.isOpen()) {
                sesionHibernate.close();
            }
        }
        return listaLinks;
    }
    
    public List<String> getListLinkNames() {
        List<String> listaLinks = new ArrayList<>();
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q = sesionHibernate.createQuery("select title from Link");

            listaLinks = q.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            if (sesionHibernate.isOpen()) {
                sesionHibernate.close();
            }
        }
        return listaLinks;
    }
    
    public List<Link> getListLinksByCat(Category category) {
        List<Link> listaLinks = new ArrayList<>();
        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q = sesionHibernate.createQuery("from Link where catid = :code ");
            q.setParameter("code", category.getId());
            listaLinks = q.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            if (sesionHibernate.isOpen()) {
                sesionHibernate.close();
            }
        }
        return listaLinks;
    }
    
    
    
    
    
}
