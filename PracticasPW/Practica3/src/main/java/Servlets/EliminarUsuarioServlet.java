package Servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import JavaBeans.CustomerBean;
import GeneralDAO.UsuarioDAO;

@WebServlet(name="EliminarUsuarioServlet", urlPatterns="/EliminarUsuarioServlet")

public class EliminarUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 7025674605892363927L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
		
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		HttpSession session = request.getSession();
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");

		String mail = customerBean.getEmailUser();
		UsuarioDAO userDAO = new UsuarioDAO(urlBD, userBD, passBD);
		userDAO.EliminarUsuario(mail);
	
		session.setAttribute("customerBean", null);
		String ruta = request.getContextPath() + "/index.jsp";
		userDAO.desUsuarioDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Su usuario ha sido eliminado.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
	
}
