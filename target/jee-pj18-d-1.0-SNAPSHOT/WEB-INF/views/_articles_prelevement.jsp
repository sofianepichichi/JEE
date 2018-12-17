<%--
  Created by IntelliJ IDEA.
  User: Fianso
  Date: 15/12/2018
  Time: 04:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="PreparationCommande.com.model.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%
    String ctxPath = request.getContextPath();
    java.util.List<Article> jsList = new java.util.ArrayList<>();
    jsList = (java.util.ArrayList<Article>) request.getAttribute("listarticle");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List des articles</title>
    <link href="<%=ctxPath%>/css/bootstrap.min.css" rel="stylesheet" />
    <script src="<%=ctxPath%>/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<!--
<div class="row" style="width: 15%">
    <form class="from-inline">
        <div class="form-group">
            <%--@declare id="flane"--%><label for="flane">Allée</label>
            <select class="form-control" id="flane" name="lane">

                <c:forEach items="${articles}" var="lane">
                    <option>${lane}</option>
                </c:forEach>
            </select>
        </div>

<button type="submit" class="btn-btn-default">
    <span class="glyphicon glyphicon-search" aria-hidden="true"  ></span>
     Filter
</button>

        <input class="btn btn-primary" type="submit" value="filter par allée"
               onclick="window.location='article/lane.html';" />
    </form>
</div>
-->

<div class="container spacer">
<form action="/article/lane.html" method="get">
  <div class="form-group">
      <label>Allée</label>
      <input type="text" name="motCle"/>
      <button type="submit">Chercher</button>
    </div>
</form>
</div>
</center>

<div class="container">
    <h1 class="text-center">Liste des Articles dans L'allée</h1>
<c:if test="${listarticle != null}">
<c:choose>
        <c:when test="${listarticle.isEmpty()}">
            allée article vide
        </c:when>
        <c:otherwise>
            <table class="table table-striped" id="myTable">

                    <thead>
                    <tr>
                        <th scope="col">Allé</th>
                        <th scope="col">Produit</th>
                        <th scope="col">Place</th>
                        <th scope="col">Réference</th>
                        <th scope="col">Conservation</th>
                        <th scope="col">Prix</th>
                    </tr>
                    </thead>

                    <c:forEach items="${listarticle}" var="article">

                            <tbody>
                            <tr>
                           <!--     <a href="employee/${article.id}.html"> -->
                                <td scope="row"><c:out value="${article.lane}"/></td>
                                <td scope="row"><c:out value="${article.name}"/></td>
                                <td scope="row"><c:out value="${article.place}"/></td>
                                <td scope="row"><c:out value="${article.ref}"/></td>
                                <td scope="row"><c:out value="${article.preservation}"/></td>
                                <td scope="row"><c:out value="${article.price}"/></td>
                            <!--    <td scope="row"><button class="btn btn-danger" data-toggle="mode1" data-target="#delete">Récupérer</button></td>-->
                                <td scope="row" ><input type="button" class="btn-danger" value="Recuperé"
                                       onclick="document.getElementById('myTable').deleteRow(1)">
                            </tr>
                            </tbody>
                        </c:forEach>
                       </table>

        </c:otherwise>
    </c:choose>
</c:if>

<!--
    <form>
        <input type="button" value="Retour" onclick="history.go(-1)">
        <input type="button" value="Suivant" onclick="history.go(+1)">
    </form>

-->


</div>
<nav aria-label="navigation">
    <ul class="pager">
        <li><a href="javascript:history.go(-1)" title="Precedent">allée-Précédent</a></li>
        <li><a href="javascript:history.go(+1)" title="Suivant">allée-Suivant</a></li>
    </ul>
</nav>

<!--
<div class
-->
</div>
</body>
</html>
