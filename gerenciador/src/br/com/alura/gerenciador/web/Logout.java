package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.utils.Utils;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookies cookies = new Cookies(req.getCookies());
		Cookie cookie = cookies.getUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		writer.println(Utils.INIT);
		if(cookie != null){
			cookie.setMaxAge(0);		
			resp.addCookie(cookie);
	        writer.println("<h4>Usuario: "+ cookies.getEmailUsuarioLogado() +" Deslogado com Sucesso!</h4>");
		}else{
			writer.println("<h4>Quer deslogar quem meu parça? n tem ning logado</h4>");
		}
		writer.println(Utils.END);
		
	}
}
