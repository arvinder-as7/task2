<%-- 
    Document   : index
    Created on : 18 May, 2017, 10:10:35 PM
    Author     : gurleen
--%>

<%@page import="jugnoo.JugnooApp" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="test" class="jugnoo.JugnooApp" />
  <%
   JugnooApp tc = new JugnooApp();
   tc.main(new String[]{});
  %>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
