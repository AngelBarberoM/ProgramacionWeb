package Servlets;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import JavaBeans.CustomerBean;


@WebFilter("/AdminAutenticacionServlet")

public class AdminAutenticacionServlet implements Filter{

	@Override
    public void destroy(){
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        String requestPath = request.getRequestURI();
   		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
   		boolean isStaticResource = request.getRequestURI().contains("/css/") || request.getRequestURI().contains("/js/") 
   				|| request.getRequestURI().contains("/Error/") || request.getRequestURI().contains("sql.properties") 
   				|| request.getRequestURI().contains("web.xml") || request.getRequestURI().contains("index.jsp") 
   				|| request.getRequestURI().contains("/Imagenes/");
        if (isStaticResource) { 
            chain.doFilter(request, response);
        }
        else {
         	Boolean customerNull = (customerBean == null);
         	Boolean gotoIndex = requestPath.contains("InicioSesionServlet") || requestPath.contains("RegistrarServlet")  || request.getRequestURI().contains("RegistrarVista.jsp");
         	if(gotoIndex) {
        		chain.doFilter(req, res);
         	}
         	else {
         		if(customerNull || customerBean.getEmailUser().equals("")) {
                	response.sendRedirect(request.getContextPath() + "/index.jsp");
            	}
                else {
                		Boolean isAdmin = customerBean.getRol().equals("Admin");
                    	if (needsAuthAdmin(requestPath) && !isAdmin) {
                        	response.sendRedirect(request.getContextPath() + "/P3/Error/NoAutenticacion.jsp"); // No permission
                    	} else {
                    		chain.doFilter(req, res); // Logged-in user is admin, so just continue request.
                    	} 
                	}
                }
         	}
        }
	
	public boolean needsAuthAdmin(String url) {
        String[] validNonAuthenticationUrls = { "RegistrarVista.jsp","Home.jsp","index.jsp", "CabeceraNavegacion.jsp", "HomeUsuario.jsp", 
        		"HomeDatosUsuario.jsp", "HomeEspectaculosUsuario.jsp", "TodosEspectaculosVista.jsp", "TodasCriticasVista.jsp", "NuevaCritica.jsp", "MostarCriticasEspectaculos.jsp", 
        		"EliminarCriticaServlet", "EliminarUsuarioServlet", "DislikeCriticaServlet", "GetTodosEspectaculos", "GetTodosEspectaculosRealizadosServlet",
        		"LikeCriticaServlet", "InicioSesionServlet", "CerrarSesionServlet", "ModificarDatosUsuarioServlet", "NuevaCriticaServlet", 
        		"RegistrarServlet", "BuscarCriticaServlet", "BuscarEspectaculosServlet", "BuscarEspectaculosPaseMultipleServlet","BuscarEspectaculosTemporadaServlet",
        		"BuscarEspectaculosPuntualServlet", "DatosUsuarioServlet", "ModificarUsuario.jsp", "EliminarUsuario.jsp", "RegistrarVista.jsp", "EliminarUsuario",
        		"GetTodasCriticasServlet", "RegistrarServlet"};
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.contains(validUrl)) {
                return false;
            }
        }
        return true;
    }
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
