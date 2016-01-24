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

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuscaEmpresaServlet() {
		System.out.println("Instanciando uma servlet BuscaEmpresa " + this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Iniciando uma servlet BuscaEmpresa");
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servlet muahauhs ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("empresa");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(nomeEmpresa);		
		request.setAttribute("empresas", empresas);		
		request.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp").forward(request,response );
		
	}

}
