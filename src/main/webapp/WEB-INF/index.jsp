<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des jeux</title>
</head>
<body>
	<jsp:include page="entete.jsp" />
	<div>
		<h1>Bienvenue ${joueur.pseudo}</h1>
		<h2>Voici la liste des jeux :</h2>
	</div>

	<table width="100%">
		<thead>
			<tr>
				<td>Image</td>
				<td>Nom <a href="index?sort=nom">trier</a></td>
				<td>Genre <a href="index?sort=genre">trier</a></td>
				<td>Plateforme</td>
				<td>Date de sortie <a href="index?sort=dateSortie">trier</a></td>
				<td>Editeur <a href="index?sort=editeur">trier</a></td>
				<td>Modele Economique <a href="index?sort=modeleEconomique">trier</a></td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageDeJeux.content}" var="jeu">
				<tr>
					<td><img src="images/${jeu.image}" width="80px"></td>
					<td>${jeu.nom}</td>
					<td>${jeu.genre.nom}</td>
					<td><c:forEach items="${jeu.plateformes}" var="plateforme">
                      ${plateforme.nom}<br>
						</c:forEach></td>
					<td>${jeu.dateSortie}</td>
					<td>${jeu.editeur.nom}</td>
					<td>${jeu.modeleEconomique.nom}</td>
					<td><a href="/lesAvis?ID=${jeu.id}">Voir les avis</a></td>
					<td><a href="/jeu?ID=${jeu.id}">Modifier</a></td>
					<td><a href="/televersement?ID=${jeu.id}">Ajouter une image</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<c:if test="${!pageDeJeux.first}">
		<a href="?page=0&sort=${pageDeJeux.sort.iterator().next().property},${pageDeJeux.sort.iterator().next().direction}">&#x23EE;</a>
		<a href="?page=${pageDeJeux.number-1}&sort=${pageDeJeux.sort.iterator().next().property},${pageDeJeux.sort.iterator().next().direction}">&#x23EA;</a>
	</c:if>
	Page ${pageDeJeux.getNumber()+1} : 
	Jeux de ${pageDeJeux.totalElements == 0 ? 0 : pageDeJeux.size * pageDeJeux.number+1} à ${pageDeJeux.numberOfElements + (pageDeJeux.size * pageDeJeux.number)} sur ${pageDeJeux.totalElements} Jeu(x)
	<c:if test="${!pageDeJeux.last}">
		<a href="?page=${pageDeJeux.number+1}&sort=${pageDeJeux.sort.iterator().next().property},${pageDeJeux.sort.iterator().next().direction}">&#x23E9;</a>
		<a href="?page=${pageDeJeux.totalPages - 1}&sort=${pageDeJeux.sort.iterator().next().property},${pageDeJeux.sort.iterator().next().direction}">&#x23ED;</a>
	</c:if>
	
	<br>
	<a href="/jeu">Ajouter un jeu</a>
	<br>
	<a href="/editeurs">Liste des éditeurs</a>
	<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>