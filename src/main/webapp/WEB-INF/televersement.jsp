<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="televersement?ID=${jeu.id}" method="post" enctype="multipart/form-data">
    				<input type="file" name="FICHIER" accept="image/png, image/jpeg" />
    				<input type="submit" value="Envoyer" />
</form>
</body>
</html>