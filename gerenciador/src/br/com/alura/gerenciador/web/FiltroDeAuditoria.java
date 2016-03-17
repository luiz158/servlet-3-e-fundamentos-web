package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String usuario = getUsuarioLogado(req);
		System.out.println(
				"Usuario: " + usuario + " | 	Acessando: " + req.getRequestURI() + " | " + req.getRequestURL());
		chain.doFilter(request, response);

	}

	private String getUsuarioLogado(HttpServletRequest req) {
		String usuario = "<deslogado>";
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			return usuario;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie.getValue();
			}
		}
		return usuario;
	}
}
