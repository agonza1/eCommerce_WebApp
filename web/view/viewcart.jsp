<%@page import="java.util.List"%>
<%@page import="cart.ShoppingCartItem"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category" %>
<%@page import="cart.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>
<html>

             <h2>Your shopping cart contains <%=request.getSession().getAttribute("numCartItems")%> items</h2>
        
        
        <table BGCOLOR="#FFFFFF" width="100%" border="2" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
        <font size="2" face="Verdana">                
        <tr valign="center" align="middle">
            <td width="25%" valign="center" align="middle">
                <span>Product</span>                 
            </td>

           <td width="25%" valign="center" align="middle">
                <span>Info</span>                 
            </td>


            <td width="25%" valign="center" align="middle">
                <span>Price</span>                 
            </td>


            <td width="25%" valign="center" align="middle">
                <span>Quantity</span>                 
            </td>            
        </tr>
        <%
        List<ShoppingCartItem> items = (List<ShoppingCartItem>)request.getSession().getAttribute("cartItems");
        for(ShoppingCartItem item : items){
            Product product = item.getProduct();
        %>
        <tr valign="center" align="middle">
            <td width="25%" valign="center" align="middle">
                <img src="img/products/<%=product.getName()%>.png" alt="<%=product.getName()%>" >                 
            </td>

            <td width="25%">
                <p>
                    <%=product.getName()%>
                </p>                        
                <p>
                    <%=product.getDescription()%>
                </p>                        
            </td>
            <td width="25%">      
                <%=product.getPrice()%> €/u                    
            </td>
            <td width="25%">   
                <form action="updatecart.do" method="post">
                    <input type="number" min="0" name="itemQuantity" value="<%=item.getQuantity()%>">
                    <input type="hidden" name="productid" value="<%=product.getId()%>">
                    <input type="hidden" name="categoryid" value="<%=product.getCategoryid()%>">
                    <input type="submit" name="submit" value="Actualizar Cantidad">
                </form>
            </td>
        </tr>
        <% } %>
        </font> 
    

    </table>
        <p ALIGN=left><a style="color:#FFFF" href="clearcart.do">UNDO</p>
        <p ALIGN=left><a style="color:#FFFF" href="init.do">RETURN</a></p>
        <h3 align="right">PRICE: <%=request.getSession().getAttribute("subTotal") %> €</h3> 
    </body>
</html>
