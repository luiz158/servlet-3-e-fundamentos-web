package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa{

	public String executa(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		if(session.getAttribute("usuario.logado") != null){
			session.removeAttribute("usuarioLogado");
		}
		return "/WEB-INF/paginas/logout.html";
	}
}
