package controle;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.BancoContato;

@WebServlet("/excluirContatoServlet")
public class ExcluirContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		
		String nome = request.getParameter("nome");
		
		if(sessao != null) {
			BancoContato bancoContato = BancoContato.getInstance();
			Boolean sucesso = bancoContato.excluirContato(nome);
			
			if(sucesso) {
				request.setAttribute("resultado", true);
				request.getRequestDispatcher("resultadoExclusao.jsp").forward(request, response);
			} else {
				request.removeAttribute("resultado");
				request.getRequestDispatcher("resultadoExclusao.jsp").forward(request, response);
			}
			
		} else {
			response.sendRedirect("acessoRestrito.jsp");
		}
	}
}
