<%-- 
    Document   : lister_articles
    Created on : 10 mars 2016, 16:13:06
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
                <div>Mes enchères</div>
                <table>
                    <thead>
                    <th>Nom article</th><th>Description</th><th>Prix de vente</th><th>Fin de vente</th><th>Action</th>
                    </thead>
                <c:forEach items="${articles}" var="article">
                    <tr>
                        <td>${article.nom}</td>
                        <td>${article.description}</td>
                        <td>${article.prixActuel}</td>
                        <td>${article.dateVente}</td>
                        <td><a href="encherir?id=${article.id}&enchere=true"><button>Enchérir</button></a></td>
                        <td>${erreur}</td>
                    </tr>
                </c:forEach>
            </table>
            <div>${erreur}</div>
            <div><c:if test="${enchereError != null}">Erreur : ${enchereError}</c:if></div>
            </div>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>