<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title><spring:message code="titre.suppression.elementprofs"/></title>
</head>
<body>
<table border="1">
<thead>
<tr>
				<th><spring:message code="colonne.identifiant" /></th>
				<th><spring:message code="colonne.nom" /></th>
				<th><spring:message code="colonne.prenom" /></th>
				<th><spring:message code="colonne.date_naissance" /></th>
								<th><spring:message code="colonne.adresse" /></th>
												<th><spring:message code="colonne.sexe" /></th>
<th>&nbsp;</th>
</tr>
</thead>
<tbody>
<c:forEach items="${listeProfs}" var="prof">
<tr>
<td><c:out value="${prof.id}" /></td>
					<td><c:out value="${prof.nom}" /></td>
					<td><c:out value="${prof.prenom}" /></td>
										<td><c:out value="${prof.date_naissance}" /></td>
															<td><c:out value="${prof.adresse}" /></td>
															<td><c:out value="${prof.sexe}" /></td>
<td>
<c:url value="/supprimerSuppressionListeProfs" var="url">
<c:param name="id" value="${prof.id}"/>
</c:url>
<a href="${url}">
<spring:message code="suppression.supprimer.libelle" />
</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>