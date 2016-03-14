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
            <h3>Nouvel utilisateur</h3>
            <div>
                <form action="ajout_utilisateur" method="post">
                    <label>Pseudo : </label>
                    <input type="text" name="login">
                    <label>Mot de passe : </label>
                    <input type="password" name="password">
                    <input type="submit" value="Valider">
                </form>
            </div>
        </div>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>