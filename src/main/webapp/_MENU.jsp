<%-- 
    Document   : _MENU
    Created on : 7 mars 2016, 13:53:10
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="menu">
    <table>
        <tr>
            <c:if test="${sessionScope.login != null}">
                <td>Bonjour ${sessionScope.login}</td>
                <td><a href="mes_articles"><button>Mes articles</button></a></td>
                <td><a href="mes_encheres"><button>Mes enchères en cours</button></a></td>
                <td><a href="panier"><button>Mon panier</button></a></td>
                <td><a href="ajout_article"><button>Ajouter un article</button></a></td>
                <td><a href="ajout_categorie?combobox=false"><button>Ajouter une catégorie</button></a></td>
                <td><a href="login?value=false"><button>Se déconnecter</button></a></td>
            </c:if>
            <c:if test="${sessionScope.login == null}">
            <td><a href="login.jsp"><button>Se connecter</button></a></td>
            </c:if>
            <td><a href="lister_articles"><button>Enchères disponibles</button></a></td>
<!--            <td>
                <form action="CookieServlet" method="get">
                Choix du style
                <input type="radio" name="css" value="style1" checked="true">Grave cool
                <input type="radio" name="css" value="style2"> Dla balle
                <input type="submit" value="Valider">
            </form>
            </td>-->
        </tr>
    </table>
</div>
