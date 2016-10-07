/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;

/**
 *
 * @author USer
 */
public class ShoppingCartItem {
    Product product;
    Integer quantity;
    double contador;
    
    public ShoppingCartItem(Product product){
        this.product=product;
        quantity=0;
        contador=0;
    }
    
public Product getProduct(){
    return product;
}

public int getQuantity(){
    return quantity;
}

public void setQuantity(int quantity){
    this.quantity=quantity;
}

public double getTotal(){
    
    contador=(product.getPrice().doubleValue()*quantity);
    return contador;
}
    
}
