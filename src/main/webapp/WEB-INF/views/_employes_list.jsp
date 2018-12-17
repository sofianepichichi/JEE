<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="PreparationCommande.com.model.Employee" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String ctxPath = request.getContextPath(); 
	java.util.List<Employee> jsList = new java.util.ArrayList<>(); 
	jsList = (java.util.ArrayList<Employee>) request.getAttribute("employes");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Liste des employés</title>
	</head>
	<body>
		<c:if test="${employes != null}">
		    <c:choose>
		        <c:when test="${employes.isEmpty()}">
		            Pas d'employés dans le Drive, c'est quand même dommage. 
		        </c:when>
		        <c:otherwise>
		            <ul>
		                <c:forEach items="${employes}" var="userItem">
		                    <li>
		                    	<!-- <a href="employee/${userItem.id}.html"> -->
		                        	<c:out value="${userItem.name}"/>
		                        <!-- </a>-->
		                    </li>
		                </c:forEach>
		            </ul>
		        </c:otherwise>
		    </c:choose>
		</c:if>
	</body>
</html>