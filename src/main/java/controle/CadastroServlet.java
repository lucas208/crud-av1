package controle;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.BancoContato;
import modelo.Contato;

@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao == null || sessao.getAttribute("usuario") == null) {
	        response.sendRedirect("acessoRestrito.jsp");
	    } else {
	    	String nome = request.getParameter("nome");
			String telefoneCelular = request.getParameter("telefoneCelular");
			String telefoneResidencial = request.getParameter("telefoneResidencial");
			String email = request.getParameter("email");
			String dataNascimento = request.getParameter("dataNascimento");
			Boolean erro = false;
			try {
				Contato contato = new Contato(nome, telefoneCelular, telefoneResidencial, email, dataNascimento);	
				BancoContato bancoContato = BancoContato.getInstance();
				bancoContato.getContatos().add(contato);
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				response.sendRedirect("erroCadastro.jsp");
				erro = true;
			} 
			if(!erro) {
				response.sendRedirect("listarContatosServlet");
			}
	    }
	}
}
