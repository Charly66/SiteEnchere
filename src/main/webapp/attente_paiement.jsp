<%-- 
    Document   : panier
    Created on : 10 mars 2016, 16:45:38
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="_CSS.jsp"></c:import>
            <title>Enchères pas chères</title>
        </head>
        <body>
        <c:import url="_TITRE.jsp"></c:import>
        <c:import url="_MENU.jsp"> </c:import>
            <div class="contenu">
                <h3>Paiement en attente de validation par le site concerné</h3>
                <form action="paiement_ok" method="post">
                    <input type="hidden" name="id" value="${article.id}">
                <input type="submit" value="Valider">
                </form>
                
            </div>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>