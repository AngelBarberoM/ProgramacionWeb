package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import JavaBeans.CustomerBean;
import GeneralDTO.UsuarioDTO;

@WebServlet(name="DatosUsuarioServlet", urlPatterns="/DatosUsuarioServlet")

public class DatosUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = -2457476533071596746L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session = request.getSession();
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
		String mail = customerBean.getEmailUser();

		ArrayList<UsuarioDTO> users = new ArrayList<UsuarioDTO>();
		
		for(UsuarioDTO u : users)
		{
			if(u.getCorreo() == mail)
			{
				customerBean.setEmailUser(u.getCorreo());
				customerBean.setLastLogged(u.getUltimaConex());
				customerBean.setRegisterTime(u.getHoraRegistro());
				customerBean.setRol(u.getTipoUsuario());
				customerBean.setUsername(u.getNombreUsuario());
				customerBean.setName(u.getNombre());
			}
		}
		session.setAttribute("custormerBean", customerBean);
		response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuHomeDatos/InfoUsuarioVista.jsp");
	}
}
