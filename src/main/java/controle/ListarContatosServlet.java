package controle;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.BancoContato;
import modelo.Contato;

@WebServlet("/listarContatosServlet")
public class ListarContatosServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao == null || sessao.getAttribute("usuario") == null) {
			response.sendRedirect("acessoRestrito.jsp");
		} else {
			BancoContato bancoContato = BancoContato.getInstance();
			
			ArrayList<Contato> contatos = bancoContato.getContatos();
			
			request.setAttribute("contatos", contatos);
			
			request.getRequestDispatcher("listarContatos.jsp").forward(request, response);
		}
	}
}
