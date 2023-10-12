<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="modelo.Contato"%>
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
<title>Detalhes do contato</title>
</head>
<body>
	<h1>Detalhes do contato:</h1>
        <%
            Contato contato = (Contato) request.getAttribute("contato");
        	if(contato != null) {
        %>
        <ul>
	        <li>Nome: <%= contato.getNome() %></li>
	        <li>Telefone celular: <%= contato.getTelefoneCelular() %></li>
	        <li>Telefone residencial: <%= contato.getTelefoneResidencial() %></li>
	        <li>Email: <%= contato.getEmail() %></li>
	        <li>Data de nascimento: <%= contato.getDataNascimento() %></li>
	    </ul>
        <%
       	   } else {
       		%>
     		 <p>Contato não encontrado!</p>
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