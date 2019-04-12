package co.simplon.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		if (login == null)	login = "";
		if (password == null)	password = "";

		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);

		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");

		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);

		if (login.equals("Sreyneang") && password.equals("999")) {
			session.setAttribute("isConnectet", true);
			request.getRequestDispatcher("/comptes.html").forward(request, response);
		} else {
			session.setAttribute("isConnectet", false);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
