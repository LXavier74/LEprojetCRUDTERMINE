<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title><spring:message code="titre.listeeleves"/></title>
</head>
<body>
<table border="1">
<thead>
<tr>
<th><spring:message code="colonne.identifiant"/></th>
<th><spring:message code="colonne.libelle"/></th>
<th><spring:message code="colonne.quantite"/></th>
</tr>
</thead>
<tbody>
<c:forEach items="${listeEleves}" var="course">
<tr>
<td><c:out value="${eleve.id}"/></td>
<td><c:out value="${eleve.nom}"/></td>
<td><c:out value="${eleve.prenom}"/></td>
</tr>


</c:forEach>
</tbody>
</table>
</body>
</html>