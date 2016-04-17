package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/executa")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaTarefa = request.getParameter("tarefa");
		
		System.out.println("Nome da Tarefa: " + nomeDaTarefa);
		
		if (nomeDaTarefa == null){
			throw new IllegalArgumentException("tarefa invalida");			
		}
		
		String nomeDaClasse ="br.com.alura.gerenciador.servlet."+nomeDaTarefa;
		System.out.println(nomeDaClasse);
		
		try {
	
			Class<?> tipo = Class.forName(nomeDaClasse);
			Tarefa tarefa = (Tarefa) tipo.newInstance();
			
			String pagina= tarefa.executa(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		} catch (InstantiationException | IllegalAccessException  |ClassNotFoundException e) {
			throw new ServletException(e.getMessage());		
		}	
	}
}		
