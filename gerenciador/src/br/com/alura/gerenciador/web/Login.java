package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;
import br.com.alura.gerenciador.utils.Utils;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(req.getParameter("usuario"), req.getParameter("senha"));

		if (usuario != null) {
			writer.println(Utils.INIT);
			writer.println("<h3>Usuario Logado com sucesso!!</h3>");
			writer.println(Utils.END);
			Cookie cookie = new Cookie("usuario.logado", usuario.getEmail());
			resp.addCookie(cookie);
		} else {
			writer.println(Utils.INIT);
			writer.println("<h1>ERRRRRRROU!!</h1>");
			writer.println(Utils.END);
		}

	}
}
