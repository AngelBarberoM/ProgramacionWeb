package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneralDTO.EspectaculoPaseMultipleDTO;
import GeneralDTO.FechaDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="EliminarFechaEspectaculoPaseMultiple", urlPatterns="/EliminarFechaEspectaculoPaseMultiple")

public class EliminarFechaEspectaculoPaseMultiple extends HttpServlet{

	private static final long serialVersionUID = 1281705201806865442L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoPaseMultipleDTO> multiples= multDAO.SolicitarEspectaculoPaseMultipleInfo();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		int idFecha = Integer.parseInt(request.getParameter("idFecha"));
		ArrayList<FechaDTO> fechasUpdate = new ArrayList<FechaDTO>();
		
		for(EspectaculoPaseMultipleDTO e : multiples)
		{
			if(id == e.getId())
			{
				fechasUpdate = e.getFecha();
			}
		}

		for(FechaDTO f : fechasUpdate)
		{
			if(idFecha == f.getId())
			{
				multDAO.EliminarFecha(f);
			}
		}
		
		String ruta = request.getContextPath() + "/GetMultiplesTemporadaEliminarServlet";
		multDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Fecha eliminada correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
