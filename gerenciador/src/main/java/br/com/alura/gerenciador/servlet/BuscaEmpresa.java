package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa{


	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("empresa");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(nomeEmpresa);	
		request.setAttribute("empresas", empresas);		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
