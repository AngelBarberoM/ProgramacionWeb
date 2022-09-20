package Servlets;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import GeneralDTO.UsuarioDTO;
import GeneralDAO.UsuarioDAO;
import JavaBeans.TodosUsuariosJavaBean;

@WebServlet(name="AdminControlUsuarios", urlPatterns="/AdminControlUsuarios")

public class AdminControlUsuarios extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		UsuarioDAO userDAO = new UsuarioDAO(urlBD,userBD,passBD);		
		ArrayList<UsuarioDTO> allUsers = userDAO.SolicitarTodosUsuarios();
		
		HttpSession session = request.getSession();
		TodosUsuariosJavaBean allUsersBean = new TodosUsuariosJavaBean();
		
		allUsersBean.setAllUsers(allUsers);
		allUsersBean.setNumUsers(allUsers.size());
		session.setAttribute("TodosUsuariosJavaBean", allUsersBean);
		userDAO.desUsuarioDAO();
		response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuHomeDatos/HomeUsuariosAdmin.jsp"); 
		
	}
}
