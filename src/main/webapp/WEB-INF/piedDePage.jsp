<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p><a href="/h2-console">Console H2</a></p>
<p><a href="/swagger-ui/index.html">Swagger UI</a></p>
<jsp:useBean id="dateFin" class="java.util.Date"/>
<c:set var="msFin" value="${dateFin.getTime()}" scope="page" />
<p>Page générée en ${msFin - msDepart} ms</p>