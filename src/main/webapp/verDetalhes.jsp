<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes</title>
</head>
<body>
	<h1>Detalhes:</h1>
	<form action="verDetalhesServlet" method="post">
		<label for="nome">Nome:</label>
	    <input type="text" id="nome" name="nome" required>
	    </br>
	    </br>
		<input type="submit" value="Buscar">
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