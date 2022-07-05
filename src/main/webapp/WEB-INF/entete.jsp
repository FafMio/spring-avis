<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${sessionScope.utilisateur eq null }">
		<a href="connexion">Connexion</a>
		<a href="inscription">Inscription</a>
	</c:when>
	<c:when test="${sessionScope.utilisateur ne null }">
	<a href="/">Liste des jeux</a>
		<a href="deconnexion">Deconnexion</a>
		<br>
		Bonjour ${sessionScope.utilisateur.pseudo} !
		<br>
	</c:when>
</c:choose>
		<br>