package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import model.User;

@WebServlet("/login")
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private boolean login;
	DaoUser daoUser = new DaoUser();
	
	private User buscarUser(String email, String password){
        User user = daoUser.consultar(email, password);
        return user;
    }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		Boolean session = false;
		User user = new User();
		
		user = buscarUser(email, password);
		
		if (user.getName() != null) { 
			session = true;
			req.setAttribute("session", session);
			req.setAttribute("type", user.getType());
			req.getRequestDispatcher("/dashboard?login=true").forward(req, resp); 

		}else {
			session = false; 
			req.setAttribute("erro", "erro");
			req.setAttribute("session", session);
			req.getRequestDispatcher("./WEB-INF/index.jsp").forward(req, resp); 
		}
		
	}
}
