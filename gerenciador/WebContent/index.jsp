<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<p>Bem vindo ao nosso gerenciador de empresas!</p>
	<c:if test="${not empty usuarioLogado}">
		<p>Logado como: ${usuarioLogado.email}</p>
	</c:if>
	<br>
	<form action="cadastro" method="POST">
		Nome da Empresa: <input type="text" name="nome"> 
		<input type="submit" value="Adicionar">
	</form>
	
	<form action="login" method="GET">
		<input type="submit" value="Area de Login">
	</form>
	
	<form action="logout" method="POST">
		<input type="submit" value="Deslogar">
	</form>
</body>
</html>