<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, modelo.Contato"%>
    
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
<title>Lista de contatos</title>
</head>
<body>
	<h1>Lista de contatos:</h1>
    
        <%
            ArrayList<Contato> contatos = (ArrayList<Contato>) request.getAttribute("contatos");
        	if(contatos != null && !contatos.isEmpty()) {
            	for (Contato contato : contatos) {
        %>
	        <ul>
		        <li>Nome: <%= contato.getNome() %></li>
		        <li>Telefone celular: <%= contato.getTelefoneCelular() %></li>
		        <li>Telefone residencial: <%= contato.getTelefoneResidencial() %></li>
		        <li>Email: <%= contato.getEmail() %></li>
		        <li>Data de nascimento: <%= contato.getDataNascimento() %></li>
		        <hr> 
		    </ul>
        <%
            	}
       	   } else {
       		%>
       		 	<p>Ainda não existem contatos cadastrados no sistema!</p>
       		<%
       	   }
        %>
 	<input type="button" onclick="voltar()" value="Voltar">    
 	<input type="button" onclick="menu()" value="Menu">
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
<%
    }
%>