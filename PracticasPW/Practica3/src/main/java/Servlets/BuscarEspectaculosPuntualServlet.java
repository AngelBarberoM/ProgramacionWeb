package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="BuscarEspectaculosPuntualServlet", urlPatterns="/BuscarEspectaculosPuntualServlet")

public class BuscarEspectaculosPuntualServlet extends HttpServlet{

	private static final long serialVersionUID = -5527328440534251523L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
		
		ArrayList<EspectaculoPuntualDTO> espPunt = espDAO.SolicitarEspectaculoPuntualInfo();
		ArrayList<EspectaculoPuntualDTO> foundPunt = new ArrayList<EspectaculoPuntualDTO>();
		
		for(EspectaculoPuntualDTO e : espPunt)
		{
			foundPunt.add(e);
		}

		HttpSession session = request.getSession();
		TodosEspectaculosJavaBean allEspsBean = new TodosEspectaculosJavaBean();
			
		allEspsBean.setAllPunt(foundPunt);
		allEspsBean.setNumPunt(foundPunt.size());	
			
		session.setAttribute("allEspsBean", allEspsBean);
		espDAO.desEspectaculoDAO();
		response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/TodosEspectaculosVista.jsp"); 
	}
}
