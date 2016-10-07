/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import cart.ShoppingCart;
import javax.servlet.http.*;
import model.CategoryModel;
import web.ViewManager;
/**
 *
 * @author
 */
public class checkoutAction extends Action{
   CategoryModel categoryModel;
    ShoppingCart cart;
    Integer numCartItems;

    public checkoutAction (){
        
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) { 
        
        cart = (ShoppingCart)req.getSession().getAttribute("cartSession");
        if(cart==null){
            cart = new ShoppingCart();
            req.getSession().setAttribute("cartSession", cart);
        }
        
        /*...*/

    }
    
}
