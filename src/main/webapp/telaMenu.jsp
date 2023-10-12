<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    HttpSession sessao = request.getSession(false);
    if (sessao == null || sessao.getAttribute("usuario") == null) {
        response.sendRedirect("acessoRestrito.jsp");
    } else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Menu:</h1>
	<a href="cadastrarContato.jsp">Cadastrar novo contato</a>
	</br>
	<a href="listarContatosServlet">Listar contatos salvos</a>
	</br>
	<a href="verDetalhes.jsp">Ver detalhes do contato</a>
	</br>
	<a href="excluirContato.jsp">Excluir um contato</a>

</body>
</html>
<%
    }
%>