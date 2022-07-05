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
<jsp:include page="entete.jsp" />
<h1>Les éditeurs</h1>
	<h2>Voici la liste des éditeurs :</h2>
	<c:forEach items="${editeurs}" var="editeur">
        ${editeur.nom}<br>
    </c:forEach>
</body>
</html>