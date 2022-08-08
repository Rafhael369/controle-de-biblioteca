package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAuthor;
import dao.DaoBook;
import model.Book;

@WebServlet("/alterar")
public class Alterar extends HttpServlet{
	DaoBook daoBook = new DaoBook();
	DaoAuthor daoAuthor = new DaoAuthor();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		if (status == null) {
			int idBook = Integer.parseInt(req.getParameter("id"));
			Book book = daoBook.consultar(idBook);
			
			req.setAttribute("book", book);
			req.getRequestDispatcher("./WEB-INF/alterar.jsp").forward(req, resp); 
		}
		else {
			int idBook = Integer.parseInt(req.getParameter("id"));
			int linhas = daoBook.alterar(idBook, status);
			if (linhas != 0) {
				req.getRequestDispatcher("/dashboard").forward(req, resp); 
			}else {
				req.setAttribute("alterar", "erro");
				req.getRequestDispatcher("/dashboard").forward(req, resp); 
			}
		}
	}
}
