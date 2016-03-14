<%-- 
    Document   : _CSS
    Created on : 8 mars 2016, 10:10:24
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${cookie.Style.value == null}">
    <link href="CSS/style1.css" rel="stylesheet" type="text/css"/>
</c:if>
<link href="CSS/${cookie.Style.value}.css" rel="stylesheet" type="text/css"/>