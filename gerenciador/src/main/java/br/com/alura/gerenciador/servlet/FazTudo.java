package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fazTudo")
public class FazTudo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FazTudo() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Primeiro "+ response.isCommitted());
		String nomeDaTarefa = request.getParameter("tarefa");
		
		if (nomeDaTarefa == null){
			throw new IllegalArgumentException("tarefa invalida");			
		}
		
		String nomeDaClasse ="br.com.alura.gerenciador.servlet."+nomeDaTarefa;
		
		try {
	
			Class<?> tipo = Class.forName(nomeDaClasse);
			Tarefa tarefa = (Tarefa) tipo.newInstance();
			
			System.out.println("Segundo "+response.isCommitted());
			String pagina= tarefa.executa(request, response);
			System.out.println("Terceiro "+response.isCommitted());
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		} catch (InstantiationException | IllegalAccessException  |ClassNotFoundException e) {
			throw new ServletException(e.getMessage());		
		}	
	}
}		
