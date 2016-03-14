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
                <h3>Choix du mode de paiement</h3>
                <div>Montant total à payer : ${article.prixActuel} €</div>
            <br>
            <div>
                    <form action="attente_paiement" method="post">
                        <input type="hidden" name="id" value="${article.id}">
                        <div>
                            <label>Nom : </label>
                            <input type="text" name="nom" value="${acheteur.nom}">
                        </div>
                        <div>
                            <label>Prénom : </label>
                            <input type="text" name="prenom" value="${acheteur.prenom}">
                        </div>
                        <div>
                            <label>Adresse : </label>
                            <input type="text" name="adresse" value="${acheteur.adresse}">
                        </div>
                        <div>
                            <label>Code postal : </label>
                            <input type="number" name="codePostal" value="${acheteur.codePostal}">
                        </div>
                        <div>
                            <label>Ville : </label>
                            <input type="text" name="ville" value="${acheteur.ville}">
                        </div>
                        <div>
                            <label>Mode de paiement : </label>
                            <select type="radio" name="modePaiement">
                                <option>Visa</option>
                                <option>Paypal</option>
                            </select>
                    </div>
                            <div><input type="submit" value="Valider"></div>
                </form>
            </div>
            </div>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>