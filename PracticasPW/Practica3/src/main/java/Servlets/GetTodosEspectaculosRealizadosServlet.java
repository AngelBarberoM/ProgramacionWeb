package Servlets;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="GetTodosEspectaculosRealizadosServlet", urlPatterns="/GetTodosEspectaculosRealizadosServlet")

public class GetTodosEspectaculosRealizadosServlet extends HttpServlet{

	private static final long serialVersionUID = 3708894964874779929L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

			EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
			ArrayList<EspectaculoPuntualDTO> espPunt = espDAO.SolicitarEspectaculoPuntualInfo();
			ArrayList<EspectaculoPaseMultipleDTO> espMult = espDAO.SolicitarEspectaculoPaseMultipleInfo();
			ArrayList<EspectaculoTemporadaDTO> espTemp = espDAO.SolicitarEspectaculoTemporadaInfo();
	
			ArrayList<EspectaculoPuntualDTO> foundPunt = new ArrayList<EspectaculoPuntualDTO>();
			ArrayList<EspectaculoPaseMultipleDTO> foundMult = new ArrayList<EspectaculoPaseMultipleDTO>();
			ArrayList<EspectaculoTemporadaDTO> foundTemp = new ArrayList<EspectaculoTemporadaDTO>();
				
			for(EspectaculoPuntualDTO e : espPunt)
			{
				if(e.getFecha().isBefore(LocalDateTime.now()))
				{
					foundPunt.add(e);
				}
			}
				
			for(EspectaculoPaseMultipleDTO e : espMult)
			{
				Boolean flag = false;
				ArrayList<FechaDTO> fechas = e.getFecha();
				for(FechaDTO fecha : fechas)
				{
					if(fecha.getFecha().isBefore(LocalDateTime.now()))
					{
						flag = true;
					}
				}
				if(flag == true)
				{
					foundMult.add(e);
				}
			}
				
			for(EspectaculoTemporadaDTO e : espTemp)
			{
				Boolean flag = false;
				ArrayList<PaseDTO> pases = e.getPase();
				for(PaseDTO pase : pases)
				{
					if(pase.getInicioFecha().isBefore(LocalDateTime.now()))
					{
						flag = true;
					}
				}
				if(flag == true)
				{
					foundTemp.add(e);
				}
			}

			HttpSession session = request.getSession();
			TodosEspectaculosJavaBean allEspsBean = new TodosEspectaculosJavaBean();
			
			allEspsBean.setAllPunt(foundPunt);
			allEspsBean.setNumPunt(foundPunt.size());
			
			allEspsBean.setAllMult(foundMult);
			allEspsBean.setNumMult(foundMult.size());
			
			allEspsBean.setAllTemp(foundTemp);
			allEspsBean.setNumTemp(foundTemp.size());
			
			session.setAttribute("allEspsBean", allEspsBean);

			String opc1 = request.getContextPath() + "/P3/Vistas/MenuCriticas/TodasCriticasVista.jsp";
			espDAO.desEspectaculoDAO();
			response.sendRedirect(opc1); 

	}
}
