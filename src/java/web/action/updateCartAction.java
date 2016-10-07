/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;
import cart.ShoppingCart;
import entity.Product;
import static java.lang.Integer.parseInt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author 
 */
public class updateCartAction extends Action{
    //CategoryModel categoryModel;
    ProductModel productModel;
    ShoppingCart cart;
    int numCartItems;

    public updateCartAction(ProductModel productModel){
        this.productModel = productModel;
        numCartItems=0;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {

        Product product=null;
        int categoryid = parseInt(req.getParameter("categoryid"));
        String quantity = (String) req.getParameter("itemQuantity");
        String productUp = req.getParameter("productid");
        
        cart = (ShoppingCart)req.getSession().getAttribute("cartSession"); /*Si no exisitia previamente creo una */
        if(cart==null){
            
            cart = new ShoppingCart();
            req.getSession().setAttribute("cartSession", cart);
        }
        if(productUp!= null){
            for(Product productbuscar : productModel.retrieveFromCategory(categoryid) ){
                if(productbuscar.getId()==parseInt(productUp))
                     product = productbuscar;
                
            }
            
            cart.update(product, quantity);
        }
        
        numCartItems = cart.getNumberOfItems();
        
        req.getSession().setAttribute("numCartItems", numCartItems);
        req.getSession().setAttribute("subTotal", cart.getTotal());
        req.getSession().setAttribute("cartItems", cart.getItems());
      

      req.setAttribute("products", productModel.retrieveProduct(product.getId()));
      ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }
}
