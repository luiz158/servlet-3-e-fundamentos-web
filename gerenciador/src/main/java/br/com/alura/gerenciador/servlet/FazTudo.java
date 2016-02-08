package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/*")
public class FazTudo extends HttpServlet {
       
    public FazTudo() {
        super();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	String tarefa = request.getParameter("tarefa");
    	String nomeDaClasse  = "br.com.alura.gerenciador.servlet" + tarefa;
    	
    	try {
    		
			Class<?> tipoDaClasse = Class.forName(nomeDaClasse);
			Tarefa instanciaDaTarefa = (Tarefa )tipoDaClasse.newInstance();
			instanciaDaTarefa.executa(request, response);
		} catch (ClassNotFoundException  | InstantiationException  | IllegalAccessException e ) {
			throw new ServletException();
		}
    }
}
