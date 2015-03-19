<%-- 
    Document   : prova.jsp
    Created on : 19-mar-2015, 12.21.34
    Author     : sflesca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <H2>JSP Expressions</H2>
<UL>
<% 
java.util.List professori = (java.util.List) request.getAttribute("professori");
java.util.Iterator it = professori.iterator();
while (it.hasNext()) {
    entity.Professore p = (entity.Professore) it.next();
%>
<LI>Prof: <%= p.getId() %>, <%= p.getCognome() %>, <%= p.getNome() %>
<% } %>
</UL>

    </body>
</html>
