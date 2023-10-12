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

@WebServlet("/verDetalhesServlet")
public class VerDetalhesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		
		String nome = request.getParameter("nome");
		
		if (sessao == null || sessao.getAttribute("usuario") == null) {
			response.sendRedirect("acessoRestrito.jsp");
		} else {
			BancoContato bancoContato = BancoContato.getInstance();
			Contato contato = bancoContato.buscarContato(nome);
			
			if(contato != null) {
				request.setAttribute("contato", contato);
				request.getRequestDispatcher("verDetalhesContato.jsp").forward(request, response);
			} else {
				response.sendRedirect("verDetalhesContato.jsp");
			}
		}
	}
}
