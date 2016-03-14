<%-- 
    Document   : ajout_utilisateur
    Created on : 10 mars 2016, 16:42:14
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
                <h3>Nouvelle catégorie</h3>
                <div>
                    <form action="ajout_categorie" method="post">
                        <label>Nom : </label>
                        <input type="text" name="nom">
                        <input type="submit" value="Valider">
                    </form>
                </div>
                <div>${retour}</div>
            <br>
            <table>
                    <thead>
                    <th>Liste des catégories</th>
                    </thead>
                <c:forEach items="${categories}" var="categorie">
                    <tr>
                        <td>${categorie.nom}</td>
                    </tr>
                </c:forEach>
            </table>
            </div>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>