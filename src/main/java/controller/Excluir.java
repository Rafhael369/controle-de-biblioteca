package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoBook;

@WebServlet("/excluir")
public class Excluir extends HttpServlet{
	DaoBook daoBook = new DaoBook();
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		int idBook = Integer.parseInt(req.getParameter("id"));
		int linhas = daoBook.excluir(idBook);
		if (linhas != 0) {
			req.getRequestDispatcher("/dashboard").forward(req, resp); 
		}else {
			req.setAttribute("excluir", "erro");
			req.getRequestDispatcher("/dashboard").forward(req, resp); 
		}	
	}
}
