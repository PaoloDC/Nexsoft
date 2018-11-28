package it.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Test() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		System.out.println(nome);
		System.out.println(cognome);
		
		PrintWriter pw = response.getWriter();

		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>CIAO!</title></head>");
		pw.println("<body><h1>Ciao " + nome + " " + cognome + "</h1></body>");
		pw.println("</html>");
	}

	private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println();
		response.getWriter().println("Inizio Test");
		String agent = request.getHeader("User-agent");
		response.getWriter().println(agent);

		// Enumeration<String> en = request.getHeaderNames();
		// while(en.hasMoreElements()) {
		// response.getWriter().println(en.nextElement());
		// }

		response.getWriter().println("QS: " + request.getQueryString());
		response.getWriter().println("QS action: " + request.getParameter("action"));
		// response.sendError(404);
		// response.sendRedirect("https://www.google.it");
		response.addCookie(new Cookie("Prova", "Prova"));
		response.getWriter().println("Fine Test");
	}

}
