<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title><spring:message code="titre.modification.elementprofs"/></title>
</head>
<body>
<form:form method="post" modelAttribute="modificationProf" action="modifierModificationListeProfs">
<table border="1">
<thead>
<tr>
<th><spring:message code="colonne.identifiant" /></th>
				<th><spring:message code="colonne.nom" /></th>
				<th><spring:message code="colonne.prenom" /></th>
				<th><spring:message code="colonne.date_naissance" /></th>
								<th><spring:message code="colonne.adresse" /></th>
												<th><spring:message code="colonne.sexe" /></th>
</tr>
</thead>
<tbody>
<c:forEach items="${modification.listeProfs}" var="prof" varStatus="status">
<tr>
<td>
<c:out value="${prof.id}"/>
<input type="hidden" name="listeProfs[${status.index}].id" value="${prof.id}"/>
</td>
<td>

<c:out value="${prof.nom}"/>
<input name="listeProfs[${status.index}].nom" value="${prof.nom}"/>
</td>
<td>
<c:out value="${prof.prenom}"/>

<input  name="listeProfs[${status.index}].prenom" value="${prof.prenom}"/><br/>
</td>

<td>
<c:out value="${prof.date_naissance}"/>

<input name="listeProfs[${status.index}].date_naissance" value="${prof.date_naissance}"/><br/>
<!--  <b><i><form:errors path="listeProfs[${status.index}].prenom" /></i></b>-->
</td>
<td>
<c:out value="${prof.adresse}"/>

<input  name="listeProfs[${status.index}].adresse" value="${prof.adresse}"/><br/>
</td>
<td>
<c:out value="${prof.sexe}"/>

<input  name="listeProfs[${status.index}].sexe" value="${prof.sexe}"/><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<input type="submit"/>
</form:form>
</body>
</html>