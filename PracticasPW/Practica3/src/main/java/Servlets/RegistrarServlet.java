package Servlets;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import GeneralDTO.UsuarioDTO;
import GeneralDAO.UsuarioDAO;
import JavaBeans.CustomerBean;

@WebServlet(name="RegistrarServlet", urlPatterns="/RegistrarServlet")

public class RegistrarServlet extends HttpServlet{

	private static final long serialVersionUID = 2712014577923922790L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String ruta = request.getContextPath() + "/index.jsp";
		String mail = request.getParameter("Mail");
		if (mail != null) {
			ServletContext app = getServletContext();
			String passBD = app.getInitParameter("password");
			String urlBD = app.getInitParameter("url");
			String userBD = app.getInitParameter("user");
			
			String pass = request.getParameter("Password");
			String rol = request.getParameter("rol");
			String username = request.getParameter("Username");
			String name = request.getParameter("Name");
			LocalDateTime regTime = LocalDateTime.now();
			UsuarioDAO UsuarioDAO = new UsuarioDAO(urlBD,userBD,passBD);

			ArrayList<UsuarioDTO> users = UsuarioDAO.SolicitarTodosUsuarios();
			
			for(UsuarioDTO u : users){
				if(u.getCorreo().equals(mail)){
					ruta = request.getContextPath() + "/P3/Error/ExisteUsuario.jsp";
				}
			}
			UsuarioDTO newUser = new UsuarioDTO(name, mail, username, pass, rol, regTime);
			UsuarioDAO.CrearUsuario(newUser);
			HttpSession session = request.getSession();
			CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
			customerBean.setUsername(username); 
			customerBean.setRol(rol); 
			customerBean.setRegisterTime(regTime);
			UsuarioDAO.desUsuarioDAO();
		}
		response.sendRedirect(ruta);
	}
}
