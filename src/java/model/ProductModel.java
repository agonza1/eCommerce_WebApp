/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author juanluis
 */
public class ProductModel {

    UserTransaction utx;
    EntityManager em;

    public ProductModel(EntityManager em, UserTransaction utx) {
        this.utx = utx;
        this.em = em;
    }

    public List<Product> retrieveAll() {
        Query q = em.createQuery("select o from Product as o");
        return q.getResultList();
    }

    public List<Product> retrieveFromCategory(int categoryid) {
        Query q = em.createQuery("select o from Product as o where o.categoryid=:categoryid");
        q.setParameter("categoryid", categoryid);
        return q.getResultList();
    }
    
    public Product retrieveProduct(int productid) {
        Query q = em.createQuery("select o from Product as o where o.id=:productid");
        q.setParameter("productid", productid);
        return (Product)q.getSingleResult();
    }

}
