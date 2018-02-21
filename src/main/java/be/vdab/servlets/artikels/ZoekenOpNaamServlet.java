package be.vdab.servlets.artikels;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class ZoekenOpNaamServlet
 */
@WebServlet("/artikels/zoekenopnaam.htm")
public class ZoekenOpNaamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/zoekenopnaam.jsp";
	private final transient ArtikelService artikelService = new ArtikelService();
	private static final int AANTAL_RIJEN = 20;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null) {
			Map<String, String> fouten = new HashMap<>();
			String naam = request.getParameter("naam");
			if (naam.trim().isEmpty() || naam == null) {
				fouten.put("naam", "verplicht");
			}
			int vanafRij = request.getParameter("vanafRij") 
					== null ? 0 : Integer.parseInt(request.getParameter("vanafRij"));
			request.setAttribute("vanafRij", vanafRij);
			request.setAttribute("aantalRijen", AANTAL_RIJEN);
			List<Artikel> artikels = artikelService.findByNaamContains(naam, vanafRij, AANTAL_RIJEN + 1);
			if (artikels.size() <= AANTAL_RIJEN) {
				request.setAttribute("laatstePagina", true);
			} else {
				artikels.remove(AANTAL_RIJEN);
			}
			if (fouten.isEmpty()) {
				request.setAttribute("artikels", artikels);
			} else {
				request.setAttribute("fouten", fouten);
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
