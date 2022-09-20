package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="BuscarEspectaculosPaseMultipleServlet", urlPatterns="/BuscarEspectaculosPaseMultipleServlet")

public class BuscarEspectaculosPaseMultipleServlet extends HttpServlet{

	private static final long serialVersionUID = 6659878034720266309L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
		
		ArrayList<EspectaculoPaseMultipleDTO> espMult = espDAO.SolicitarEspectaculoPaseMultipleInfo();
		ArrayList<EspectaculoPaseMultipleDTO> foundMult = new ArrayList<EspectaculoPaseMultipleDTO>();
		
		for(EspectaculoPaseMultipleDTO e : espMult)
		{
			foundMult.add(e);
		}

		HttpSession session = request.getSession();
		TodosEspectaculosJavaBean allEspsBean = new TodosEspectaculosJavaBean();
			
		allEspsBean.setAllMult(foundMult);
		allEspsBean.setNumMult(foundMult.size());	
			
		session.setAttribute("allEspsBean", allEspsBean);
		espDAO.desEspectaculoDAO();
		response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/TodosEspectaculosVista.jsp"); 
	}
}
