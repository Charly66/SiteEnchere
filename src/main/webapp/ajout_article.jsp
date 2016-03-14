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
                <h3>Nouvel article</h3>
                <div>
                    <form action="ajout_article" method="post">
                        <div>
                            <label>Titre : </label>
                            <input type="text" name="titre">
                        </div>
                        <div>
                            <label>Description : </label>
                            <textarea name="description"></textarea>
                        </div>
                        <div>
                            <label>Prix : </label>
                            <input type="number" name="prixDepart" min="1">
                        </div>
                        <div>
                            <label>Durée de l'enchère (en jour) : </label>
                            <input type="number" name="dureeEnchere" min="1" max="10">
                        </div>
                        <div>
                            <label>Catégorie : </label>
                            <select name="categorie">
                            <c:import url="ajout_categorie?combobox=true"></c:import>
                            <c:forEach items="${categories}" var="categorie">
                                <option>${categorie.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                            <div><input type="submit" value="Valider"></div>
                </form>
            </div>
        </div>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>