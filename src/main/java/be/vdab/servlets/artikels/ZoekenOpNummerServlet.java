package be.vdab.servlets.artikels;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;
import be.vdab.util.StringUtils;

/**
 * Servlet implementation class ZoekenOpNummerServlet
 */
@WebServlet("/artikels/zoekenopnummer.htm")
public class ZoekenOpNummerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/zoekenopnummer.jsp";
	private final transient ArtikelService artikelService = new ArtikelService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null) {
			String id = request.getParameter("id");
			if (StringUtils.isLong(id)) {
				artikelService.read(Long.parseLong(id)).ifPresent(artikel -> request.setAttribute("artikel", artikel));
			} else {
				request.setAttribute("fouten", Collections.singletonMap("id", "tik een getal"));
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
