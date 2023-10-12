package controle;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/telaLoginServlet")
public class TelaLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(usuario.equals("admin") && senha.equals("admin")) {
			HttpSession sessao = request.getSession();
			
			sessao.setAttribute("usuario", usuario);
			
			sessao.setMaxInactiveInterval(60);
			
			response.sendRedirect("telaMenu.jsp");
		} else {
			response.sendRedirect("Index.jsp");
		}
		
	}
}
