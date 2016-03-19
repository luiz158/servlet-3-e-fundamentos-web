<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<p>Bem vindo ao nosso gerenciador de empresas!</p>
	<c:if test="${not empty usuarioLogado}">
		<p>Logado como: ${usuarioLogado.email}</p>
	</c:if>
	<br>
	<form action="do?command=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome" /><br /> <input type="submit"
			value="Enviar" />
	</form>

	<form action="login" method="GET">
		<input type="submit" value="Area de Login">
	</form>

	<form action="do?command=Logout" method="GET">
		<!--  <form action="do" method="POST">
		<input type="hidden" name="command" value="Logout"> -->
		<input type="submit" value="Deslogar">
	</form>
</body>
</html>