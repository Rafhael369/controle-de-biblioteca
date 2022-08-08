package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoBook;
import model.Author;
import model.Book;
import model.BookStatus;

@WebServlet("/inserir")
public class Inserir extends HttpServlet{
	DaoBook daoBook = new DaoBook();
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equals("inserir")) {
			req.getRequestDispatcher("./WEB-INF/inserir.jsp").forward(req, resp);
		}else {
			Book book = new Book();
			Author author = new Author();
			BookStatus status;
			try {
				String name = req.getParameter("name");
				String name_author = req.getParameter("name_author");
					
				if (req.getParameter("status").equals("DISPONIVEL")) {
	        		status = BookStatus.DISPONIVEL;
	        	}else if (req.getParameter("status").equals("INDISPONIVEL")) {
	        		status = BookStatus.INDISPONIVEL;
	        	}else {
	        		status = BookStatus.EMPRESTADO;
	        	}
				
				book.setBookStatus(status);
				book.setName(name);
				
				Date date=Date.valueOf(req.getParameter("date"));
				book.setDate(date);
				
				author.setName(name_author);
				book.setAuthor(author);
				
				boolean resultado = daoBook.inserir(book);
				
				if (resultado == true) {
					req.getRequestDispatcher("/dashboard").forward(req, resp); 
				}else {
					req.setAttribute("inserir", "erro");
					req.getRequestDispatcher("/dashboard").forward(req, resp); 
				}
			}catch(Exception e) {
				req.setAttribute("erro", "erro");
				req.getRequestDispatcher("/inserir?action=inserir").forward(req, resp); 
			}
		}
		 
	}
}
