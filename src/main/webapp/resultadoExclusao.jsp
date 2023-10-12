<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
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
<title>Resultado exclusão</title>
</head>
<body>
	<h1>Resultado exclusão:</h1>
		<%
            Boolean sucesso = (Boolean) request.getAttribute("resultado");
        	if(sucesso != null) {
        %>
        	<p>Contato excluído com sucesso!</p>
        <%
       	   } else {
       		%>
     		 <p>Falha ao excluir contato!</p>
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
