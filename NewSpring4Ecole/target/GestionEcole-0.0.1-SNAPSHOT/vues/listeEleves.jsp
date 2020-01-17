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
				<th><spring:message code="colonne.identifiant" /></th>
				<th><spring:message code="colonne.nom" /></th>
				<th><spring:message code="colonne.prenom" /></th>
								<th><spring:message code="colonne.classe" /></th>
				<th><spring:message code="colonne.date_naissance" /></th>
								<th><spring:message code="colonne.adresse" /></th>
												<th><spring:message code="colonne.sexe" /></th>
				
			</tr>
</thead>
		<tbody>
			<c:forEach items="${listeEleves}" var="eleve">
				<tr>
					<td><c:out value="${eleve.id}" /></td>
					<td><c:out value="${eleve.nom}" /></td>
					<td><c:out value="${eleve.prenom}" /></td>
										<td><c:out value="${eleve.classe}" /></td>
					
										<td><c:out value="${eleve.date_naissance}" /></td>
															<td><c:out value="${eleve.adresse}" /></td>
															<td><c:out value="${eleve.sexe}" /></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>


</html>