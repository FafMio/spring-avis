<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="GeneratedTable">
		<thead>
			<tr>
				<th>Nom joueur</th>
				<th>Nom jeu</th>
				<th>Avis</th>
				<th>Note</th>
				<th>Date avis</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageDAvis.content}" var="avis">
				<tr>
					<td>${avis.joueur.pseudo}</td>
					<td>${avis.jeu.nom}</td>
					<td>${avis.description}</td>
					<td>${avis.note}</td>
					<td>${avis.dateEnvoi}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

<p>Avis de ${pageDAvis.totalElements == 0 ? 0 : pageDAvis.size * pageDAvis.number+1} à ${pageDAvis.numberOfElements + (pageDAvis.size * pageDAvis.number)} sur ${pageDAvis.totalElements} Avis
</p>

	<a href="index">Retour à l'acceuil</a>
</body>
</html>