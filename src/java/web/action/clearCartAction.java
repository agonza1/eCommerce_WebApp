/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import web.ViewManager;

/**
 *
 * @author 
 */
public class clearCartAction extends Action {
        
        ShoppingCart cart;
        int numCartItems;
    public clearCartAction(){
        
        numCartItems=0;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) { 
        cart=(ShoppingCart)req.getSession().getAttribute("cartSession");
        if(cart==null){ 
            System.out.println("Cart Lost, creating NEW CART");
            cart = new ShoppingCart();
            req.getSession().setAttribute("cartSession", cart);
        }
        cart.clear();
        numCartItems = cart.getNumberOfItems();
       
        
        req.getSession().setAttribute("numCartItems", numCartItems);
        req.getSession().setAttribute("subTotal", cart.getTotal());
        req.getSession().setAttribute("cartItems", cart.getItems());
        
        
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
}
}