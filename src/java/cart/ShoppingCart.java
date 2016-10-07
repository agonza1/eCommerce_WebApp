/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;
import entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USer
 */
public class ShoppingCart {
    
    List<ShoppingCartItem> itemsList;
    List<Product> lista_productos;
    ShoppingCartItem item;
    BigDecimal precio;
    
    public ShoppingCart(){
        itemsList = new ArrayList<ShoppingCartItem>();
        lista_productos = new ArrayList<Product>();
        precio=new BigDecimal(0);
    }
    
public synchronized void addItem(Product product){
    if(lista_productos.contains(product)){
        for(ShoppingCartItem buscarItem : itemsList){
            if(product.equals(buscarItem.getProduct()))
                item=buscarItem;
        }
        
        item.setQuantity(item.getQuantity()+1);        
    }else{
        lista_productos.add(product);
        item = new ShoppingCartItem(product);
        item.setQuantity(1);
        itemsList.add(item);
    }
}
    
public synchronized void update(Product product, String quantity){
    int cantidad = Integer.parseInt(quantity);
    if(cantidad>0){
            if(lista_productos.contains(product)){
                for(ShoppingCartItem buscarItem : itemsList){
                    if(product.equals(buscarItem.getProduct()))
                        item=buscarItem;
                }
        
                item.setQuantity(cantidad);        
            }else{
                lista_productos.add(product);
                item = new ShoppingCartItem(product);
                item.setQuantity(cantidad);
                itemsList.add(item);
            }        
    }else{
            if(lista_productos.contains(product)){
                for(ShoppingCartItem buscaritem : itemsList){
                    if(product.equals(buscaritem.getProduct()))         
                        item=buscaritem;
                }
                itemsList.remove(item);
            }            
        }
}

public synchronized List<ShoppingCartItem> getItems(){
    return itemsList;
}

public synchronized int getNumberOfItems(){
    if(itemsList.isEmpty()){
            return 0;
    }else{
        int i=0;
        for(ShoppingCartItem ContarItems : itemsList )
            i = i + ContarItems.getQuantity();
        return i;
    }
}

public synchronized double getTotal(){
     if(itemsList.isEmpty()){
            return 0;
        }else{
            Double cuenta=0.00;
            
            for(ShoppingCartItem contaritems : itemsList )
                cuenta=cuenta + contaritems.getTotal();
                                      
            return Math.round(cuenta*Math.pow(10,2))/Math.pow(10,2);
            
        }
}

public synchronized void clear(){
    if(!itemsList.isEmpty()){
            itemsList.clear();
            lista_productos.clear();
        }
}
    
}
