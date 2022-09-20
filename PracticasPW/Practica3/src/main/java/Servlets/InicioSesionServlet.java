package Servlets;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import GeneralDTO.UsuarioDTO;
import GeneralDAO.UsuarioDAO;
import JavaBeans.CustomerBean;

@WebServlet(name="InicioSesionServlet", urlPatterns="/InicioSesionServlet")

public class InicioSesionServlet extends HttpServlet{

	private static final long serialVersionUID = 4261016544681578021L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String mail = request.getParameter("Mail");
		String pass = request.getParameter("Password");
		ServletContext app = getServletContext();
		String ruta = request.getContextPath() + "/index.jsp";
			if (mail != null) {
				String passBD = app.getInitParameter("password");
				String urlBD = app.getInitParameter("url");
				String userBD = app.getInitParameter("user");

				UsuarioDAO UsuarioDAO = new UsuarioDAO(urlBD,userBD,passBD);
				String password = UsuarioDAO.SolicitarDatosSesion(mail);
				ArrayList<UsuarioDTO> users = UsuarioDAO.SolicitarTodosUsuarios();		
				int flag=0;
				for(UsuarioDTO u : users){
					if(u.getCorreo().equals(mail))
					{
						if (password.equals(pass)){
							String username = u.getNombreUsuario();
							String rol = u.getTipoUsuario();
							HttpSession session = request.getSession();
							CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
							customerBean.setEmailUser(mail); 
							customerBean.setName(u.getNombre());
							customerBean.setUsername(username); 
							customerBean.setRol(rol);
							
							LocalDateTime fecha = LocalDateTime.now();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							String fechaLog = fecha.format(formatter);
							UsuarioDAO.ActualizarLog(u, fechaLog);
							customerBean.setLastLogged(fecha);
							customerBean.setRegisterTime(u.getHoraRegistro());
							
							flag=1;
							if(rol.equals("Admin"))
								ruta = request.getContextPath() + "/P3/Vistas/HomeAdmin.jsp";
							else
								ruta = request.getContextPath() + "/P3/Vistas/Home.jsp";
						}
						else {
							flag=2;
							ruta = request.getContextPath() + "/P3/Error/ContrasenaIncorrecta.jsp";
						}
					}
				}
				UsuarioDAO.desUsuarioDAO();
				if(flag==0)
					ruta = request.getContextPath() + "/P3/Error/NoExisteUsuario.jsp";
			}
			else
				ruta = request.getContextPath() + "/index.jsp";
		response.sendRedirect(ruta);	
	}
}
