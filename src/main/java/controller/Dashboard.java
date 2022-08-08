package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoBook;
import model.Book;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet{
	
	DaoBook daoBook = new DaoBook();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Book> books = daoBook.listarTodos();
		req.setAttribute("book", books);
		req.getRequestDispatcher("./WEB-INF/dashboard.jsp").forward(req, resp);
		 
	}
}
