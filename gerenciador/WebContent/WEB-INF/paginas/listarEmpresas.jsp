<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Listar</title>
	</head>
	<body>
		<p>Lista de empresas</p>
		<table style="width:100%">
		<c:forEach var="empresa" items="${empresas}">
			<tr>
			  <td>${empresa.id}</td>
			  <td>${empresa.nome}</td> 
			</tr>
		</c:forEach>
		</table>
	</body>
</html>