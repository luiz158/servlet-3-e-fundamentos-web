package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {

	public Login() {
		super();

	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException{
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		PrintWriter writer = response.getWriter();
		
		if (usuario == null) {
			writer.print("<html><body>Usuario não encontrado</body></html>");
		} else {
			HttpSession session = request.getSession();
			
			session.setAttribute("usuarioLogado", usuario);
		}
		
		return "/index.jsp";
	}

}
