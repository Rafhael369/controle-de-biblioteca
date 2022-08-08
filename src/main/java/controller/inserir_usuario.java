package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import model.User;

@WebServlet("/inserir_usuario")
public class inserir_usuario extends HttpServlet{
	DaoUser daoUser = new DaoUser();
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if (action.equals("inserir")) {
			req.setAttribute("type", "adm");
			req.getRequestDispatcher("./WEB-INF/inserir_usuario.jsp").forward(req, resp);
		}else {
			User user = new User();
			try {
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				String password = req.getParameter("password");
				String type = req.getParameter("type");
				
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setType(type);
				
				boolean resultado = daoUser.inserir(user);
				
				if (resultado == true) {
					req.setAttribute("type", "adm");
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
