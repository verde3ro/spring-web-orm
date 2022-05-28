<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ciudades</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Ciudad</th>
			<th>Id Pa&#237;s</th>
			<th>Fecha Actualizaci&#243;n</th>
		</tr>
		<c:forEach var="ciudad" items="${ciudades}">
		<tr>
			<td>${ciudad.cityId}</td>
			<td>${ciudad.city}</td>
			<td>${ciudad.country.countryId}</td>
			<td>${ciudad.lastUpdate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>