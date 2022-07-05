<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link href="style/theme1.css" rel="stylesheet">
</head>
<body>
<h1>Inscription</h1>
<form:form modelAttribute="joueur" action="inscription" method="post">
	<form:label path="pseudo">Pseudo</form:label>
	<form:input path="pseudo" />
	<form:errors path="pseudo" cssClass="erreur" /><br>
	<form:label path="email">Email</form:label>
	<form:input path="email" />
	<form:errors path="email" cssClass="erreur" /><br>
	<form:label path="motDePasse">Mot de passe</form:label>
	<form:password path="motDePasse" />
	<form:errors path="motDePasse" cssClass="erreur" /><br>
	<form:label path="dateDeNaissance">Date de naissance</form:label>
	<form:input type="date" path="dateDeNaissance" />
	<form:errors path="dateDeNaissance" cssClass="erreur" /><br>
	<form:button>Inscription</form:button>
</form:form>
</body>
</html>