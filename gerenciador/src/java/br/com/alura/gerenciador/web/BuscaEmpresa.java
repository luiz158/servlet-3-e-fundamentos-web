package java.br.com.alura.gerenciador.web;

import java.br.com.alura.gerenciador.Empresa;
import java.br.com.alura.gerenciador.dao.EmpresaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		String html = "<ul>\n";
		for(Empresa empresa : empresas) {
			html += "<li>" + empresa.getId() + ":" + empresa.getNome() + "</li>\n";
		}
		html += "</ul>";
		
		writer.println("<html>");
        writer.println("<body>");
        writer.println("Resultado da busca:<br/>");
        writer.println(html);
        writer.println("</body>");
        writer.println("</html>");
	}
}	