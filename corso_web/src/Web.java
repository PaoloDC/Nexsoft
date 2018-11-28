
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Web
 */
@WebServlet("/Web")
public class Web extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Web() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// PrintWriter pw = response.getWriter();
		// request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,
		// response);
		// request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request,
		// response);
		// request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").forward(request,
		// response);

		System.out.println(request.getAttribute("log"));
		List<String> carrello = (List<String>) request.getSession().getAttribute("carrello");
		if (null == carrello) {
			carrello = new ArrayList<>();
			request.getSession().setAttribute("carrello", carrello);
		}
		System.out.println(carrello);
		String articolo = request.getParameter("articolo");
		System.out.println(articolo);
		
		if (null != articolo && !articolo.trim().equals(""))
			carrello.add(articolo);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
