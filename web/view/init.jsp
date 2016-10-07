<%@ page import="entity.Category" %>
<%@ page import="java.util.List" %>

    <head>
        <meta http-equiv="Expires" CONTENT="0">
        <meta http-equiv="Cache-Control" CONTENT="no-cache">
        <meta http-equiv="Pragma" CONTENT="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>eCommerce Sample</title>
    </head>
    
    <body>

        <h2>Welcome to the online home of the Affable Bean Green Grocer <img src="img/fruit-clip-art-niEdaKMiA.png" alt="" height="50" width="50"/>
                  </h2>

        <h3> Our unique home delivery service brings you fresh organic produce,
            dairy, meats, breads and other delicious and healthy items direct
        to your doorstep. 
                
        </h3>


    <table width="50%" border="1" bordercolordark="#006400" bordercolorlight="#FFFAF0" cellpadding="3" cellspacing="0">

        <tr> <font size="2" face="Verdana">

        <%
        List<Category> categories = (List<Category>)request.getAttribute("categories");

        for(Category category : categories){

        %>

        <td width="14%" valign="center" align="middle">
            <a href="category.do?categoryid=<%=category.getId()%>">
                <img src="img/categories/<%=category.getName()%>.jpg"
                     alt="<%=category.getName()%>" >
                <%=category.getName()%>
            </a>
        </td>
 
       <% } %>

        </font> </tr>

    </table>


            <div id="footer">
                <br>
                <hr id="footerDivider">
                <p id="footerText" class="reallySmallText">
                    <a href="#">Contact C/Muntaner 100, Barcelona</a>
                    &nbsp;&nbsp;&copy;&nbsp;&nbsp;
                    2015 The Affable bean</p>
            </div>

    </body>