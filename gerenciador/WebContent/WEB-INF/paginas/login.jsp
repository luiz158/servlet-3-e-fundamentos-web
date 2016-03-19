<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<c:if test="${not empty msgErro}">
			<p style="color: red">${msgErro}</p>
		</c:if>
		<form action="login" method="POST">
			Usuario: <input type="text" name="usuario"> Senha: <input
				type="password" name="senha"> <input type="submit"
				value="Acessar">
		</form>
	</body>
</html>