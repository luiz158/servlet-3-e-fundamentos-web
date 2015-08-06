package br.com.alura.gerenciador;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {


	public Cookie getUsuario (HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")){
				return cookie;
			}
		}
		return null;
	}
}
