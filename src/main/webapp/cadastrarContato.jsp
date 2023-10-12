<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<h1>Cadastro:</h1>
	<form action="cadastroServlet" method="post">
		<label for="nome">Nome:</label>
	    <input type="text" id="nome" name="nome" required>
	    <br>
	    <label for="telefoneCelular">Telefone celular:</label>
	    <input type="text" id="telefoneCelular" name="telefoneCelular" required>
	    <br>
	    <label for="telefoneResidencial">Telefone residencial:</label>
	    <input type="text" id="telefoneResidencial" name="telefoneResidencial" required>
	    <br>
	    <label for="email">Email:</label>
	    <input type="text" id="email" name="email" required>
	    <br>
	    <label for="dataNascimento">Data de nascimento:</label>
	    <input type="text" id="dataNascimento" name="dataNascimento" required>
	    <br>
		</br>
		<input type="submit" value="Enviar">
		<input type="reset" value="Limpar">
		<input type="button" onclick="voltar()" value="Voltar">  
		<input type="button" onclick="menu()" value="Menu">       
	</form>
	<script>
		function voltar() {
		    window.history.back();
		}
		function menu() {
	        window.location.href = "telaMenu.jsp";
	    }
	</script>
</body>
</html>