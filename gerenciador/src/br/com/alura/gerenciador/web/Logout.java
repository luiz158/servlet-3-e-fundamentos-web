package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("usuario.logado") != null){
			session.removeAttribute("usuario.logado");
		}
//		Desta forma o mostro paginas que fica no web-inf que o cliente não possui acesso
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
		
//		assim mostro para o cliente a pagina
//		resp.sendRedirect("index.html");
		
	}
}
