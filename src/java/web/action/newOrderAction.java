/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Category;
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
public class newOrderAction extends Action {
       
    CategoryModel categoryModel;
    ProductModel productModel;
    ShoppingCart cart;
    Category category;
    Product product;
    int numCartItems;
    
        public newOrderAction(CategoryModel categoryModel, ProductModel productModel){
        this.categoryModel = categoryModel;
        this.productModel = productModel;
        numCartItems=0;
       
        }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        
        cart = (ShoppingCart)req.getSession().getAttribute("cartSession");
        if(cart== null){
            cart = new ShoppingCart();
        }
        
        int categoryid = parseInt (req.getParameter("categoryid"));
        for(Category icategory : categoryModel.retrieveAll() ){
            if(icategory.getId().equals(categoryid)){
                category=icategory;
            }
        }
        
        int productid = parseInt(req.getParameter("productid")); 
        
        if(productid != 0){
        for(Product iproduct : productModel.retrieveFromCategory(categoryid) ){
                if(iproduct.getId()==productid){
                    product = iproduct;
                }
        }
        
        cart.addItem(product);
        numCartItems = cart.getNumberOfItems();
        }
       
        req.getSession().setAttribute("numCartItems", numCartItems);
        req.getSession().setAttribute("subTotal", cart.getTotal());
        req.getSession().setAttribute("cartItems", cart.getItems());
        req.getSession().setAttribute("categoryName", category.getName());
        req.getSession().setAttribute("cartSession", cart);
        
        req.setAttribute("category", categoryModel.retrieve(categoryid));
        req.setAttribute("categories", categoryModel.retrieveAll());
        req.setAttribute("products", productModel.retrieveProduct(product.getCategoryid()));
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }
}
