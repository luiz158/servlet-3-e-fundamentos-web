package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(req.getParameter("usuario"), req.getParameter("senha"));
		HttpSession session = req.getSession();
		
		if (usuario != null) {
			req.setAttribute("usuario", usuario);
			dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/loginSuccess.jsp");
			session.setAttribute("usuarioLogado", usuario);
			session.setMaxInactiveInterval(60);
		} else {
			req.setAttribute("msgErro", "Usuario ou senha Inválidos");
			dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/login.jsp");
		}
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/login.jsp");
		dispatcher.forward(req, resp);
	}
}
