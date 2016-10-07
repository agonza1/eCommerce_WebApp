/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author Alberto
 */
public class categoryAction extends Action {

    private CategoryModel categoryModel;
    private ProductModel productModel;

    public categoryAction(CategoryModel categoryModel, ProductModel productModel) {
        this.categoryModel = categoryModel;
        this.productModel = productModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        
        String categoryId_str = req.getParameter("categoryid");
        int category_id = Integer.parseInt(categoryId_str);        
        
        req.setAttribute("categories", categoryModel.retrieveAll());
        req.setAttribute("category", categoryModel.retrieve(category_id));
        req.setAttribute("products", productModel.retrieveFromCategory(category_id));
        ViewManager.nextView(req, resp, "/view/category.jsp");
        //we enter into the category view where will see the choosen category "Attribute"
    }
}