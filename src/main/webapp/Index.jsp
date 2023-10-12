<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="telaLoginServlet" method="post">
		<label>Usuário: </label>
		<input type="text" name="usuario" placeholder="usuario">
		<br>
		<label>Senha: </label>
		<input type="password" name="senha" placeholder="senha">
		<br>
		<input type="submit" value="Entrar">
	</form>
</body>
</html>