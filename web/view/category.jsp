<%@page import="java.lang.String"%>
<%@ page import="entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <title> <%=request.getSession().getAttribute("category") %></title>
    
</head>

<p>

<h2>Products and Categories

   
</h2>

<a href="viewcart.do">

<h3>View Cart</h3>
</a>
    
<h3> <img src="img/cart.gif"  > 
</h3>

<span class="horizontalMargin">
                      
                        
                        <%=request.getSession().getAttribute("numCartItems")%> items
                        
                      
                    </span>

<table width="100%" border="3" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">   
    <td>
        <table  border="9" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">

            <tr> <font size="2" face="Calabri">

                    <%
                        List<Category> categories = (List<Category>) request.getAttribute("categories");

                        for (Category category : categories) {

                    %>

                    <tr>

                        <td width="14%" valign="center" align="middle">
                            <a href="category.do?categoryid=<%=category.getId()%>">
                                <%=category.getName()%>
                            </a>
                        </td>
                   </tr>
                    <% }%>
               </table>

            </td>

            <td>
                <table width="50%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
                    <%
                        List<Product> products = (List<Product>) request.getAttribute("products");

                        for (Product product : products) {

                    %>      <tr>
                        <td> 
                            <img src="img/products/<%=product.getName()%>.png"
                                 alt="<%=product.getName()%>" >
                        </td>
                        <td><center> <b><%=product.getName()%></b><br> <%=product.getDescription()%></center></td>
            <td> <%=product.getPrice()%>€</td>
            <td> 
                
              

                    <form action="neworder.do?add" method="post">
                        
                        <input type="hidden"
                               name="productid"                               
                               value="<%=product.getId()%>">
                        <input type="hidden" 
                               name="categoryid" 
                               value="<%=product.getCategoryid()%>">
                        
                        <input type="submit"
                            name="submit"
                            value="Add to cart">
                    </form>
                
            </td>
        </tr>
        <% }%>

    </table>   

</td>

</tr>

</table>

</body>
</html>
