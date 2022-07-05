<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeu</title>
<link href="style/theme1.css" rel="stylesheet">
</head>
<body>
	<h1>Jeu</h1>

	<form:form action="jeu" method="post" modelAttribute="jeu">

		<form:hidden path="id" value="${id}" />

		<form:label path="nom">Nom</form:label>
		<form:input path="nom" />
		<form:errors path="nom" cssClass="erreur" />
		<br>

		<form:label path="description">Description</form:label>
		<form:textarea path="description" rows="5" cols="30" />
		<form:errors path="description" cssClass="erreur" />
		<br>

		<form:label path="editeur">Editeur</form:label>
		<form:select path="editeur">
			<form:option value="">Merci de choisir un éditeur</form:option>
			<form:options items="${editeurs}" itemValue="id" itemLabel="nom"></form:options>
		</form:select>
		<form:errors path="editeur" cssClass="erreur" />
		<br>

		<form:label path="dateSortie">Date de sortie</form:label>
		<form:input type="date" path="dateSortie" />
		<form:errors path="dateSortie" cssClass="erreur" />
		<br>

		<form:label path="modeleEconomique">Modèle economique</form:label>
		<form:select path="modeleEconomique">
			<form:option value="">Merci de choisir un modèle économique</form:option>
			<form:options items="${modeleEconomiques}" itemValue="id"
				itemLabel="nom"></form:options>
		</form:select>
		<form:errors path="modeleEconomique" cssClass="erreur" />
		<br>

		<form:label path="classification">Classification</form:label>
		<form:select path="classification">
			<form:option value="">Merci de choisir une classification</form:option>
			<form:options items="${classifications}" itemValue="id"
				itemLabel="nom"></form:options>
		</form:select>
		<form:errors path="classification" cssClass="erreur" />
		<br>

		<form:label path="genre">Genre</form:label>
		<form:select path="genre">
			<form:option value="">Merci de choisir un genre</form:option>
			<form:options items="${genres}" itemValue="id" itemLabel="nom"></form:options>
		</form:select>
		<form:errors path="genre" cssClass="erreur" />
		<br>

		<form:label path="plateformes">Plateformes</form:label>
		<form:select path="plateformes" multiple="multiple">
			<form:option value="">Merci de choisir une ou plusieurs plateformes</form:option>
			<form:options items="${plateformes}" itemValue="id" itemLabel="nom"></form:options>
		</form:select>
		<form:errors path="plateformes" cssClass="erreur" />
		<br>

		<form:button>Enregistrer</form:button>
	</form:form>
	<br>
	<a href="index">Retour à l'acceuil</a>
</body>
</html>