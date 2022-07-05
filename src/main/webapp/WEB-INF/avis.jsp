<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rédiger un avis</title>
</head>
<body>

<section id="redigerAvis">

<h1>Rédiger un avis</h1>
<form action="envoyerAvis" method="post">
<div class ="dropdown">
<select name="ID_JEU" id="jeux" class="dropdown-select">
    <option value="">--Selectionnez un jeu-</option>

<c:forEach items="${jeux}" var="jeu">
         <option value="${jeu.id}">${jeu.nom}</option>
</c:forEach>
</select>
</div>

<div class ="dropdown">
<select name="NOTE" id="notes" class="dropdown-select">
    <option value="">--Notez ce jeu-</option>
    <c:forEach var="i" begin="0" end="10" step="1">
     <option value="${i}">${i}</option>
    </c:forEach>
</select>
</div>
<div>
<label for="description">Description :</label>
<textarea name="DESCRIPTION" rows="" cols=""></textarea>
</div>

  <input type="submit" value="Envoyer" />
</form>
</section>
<a href="/index">Retour index</a>
</body>
</html>