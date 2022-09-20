package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.UsuarioDTO;
import GeneralDAO.UsuarioDAO;
import JavaBeans.CustomerBean;

@WebServlet(name="ModificarDatosUsuarioServlet", urlPatterns="/ModificarDatosUsuarioServlet")

public class ModificarDatosUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 2712014577923922790L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
		String mail = customerBean.getEmailUser();
		String name = request.getParameter("name");
		String userName = request.getParameter("username");
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		String password = request.getParameter("passw");
		LocalDateTime reg = LocalDateTime.now();
		UsuarioDAO userDAO = new UsuarioDAO(urlBD, userBD, passBD);
		
		for(UsuarioDTO u : userDAO.SolicitarTodosUsuarios())
		{
			if(u.getCorreo().equals(mail))
			{
				if(name.equals(""))
				{
					name  = u.getNombre();
				}
				else if(userName.equals(""))
				{
					userName = u.getNombreUsuario();
				}
				else if(password.equals(""))
				{
					password = u.getContrasena();
				}
				
				reg = u.getHoraRegistro();
			}
		}
		
		CustomerBean customersBean = new CustomerBean();
		
		customersBean.setEmailUser(mail);
		customersBean.setName(name);
		customersBean.setRol("User");
		customersBean.setUsername(userName);
		customersBean.setLastLogged(LocalDateTime.now());
		customersBean.setRegisterTime(reg);

		session.setAttribute("customerBean", customersBean);
		
		UsuarioDTO userDTO = new UsuarioDTO(name, mail, userName, password, "User");
		
		userDAO.ActualizarUsuario(userDTO);
			
		String ruta = request.getContextPath() + "/P3/Vistas/Home.jsp";
		userDAO.desUsuarioDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Datos de usuario editados correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
