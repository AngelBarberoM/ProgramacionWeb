<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="GeneralDTO.UsuarioDTO,GeneralDAO.UsuarioDAO, java.time.LocalDateTime, java.util.ArrayList" %>
<jsp:useBean  id="customerJavaBean" scope="session" class="JavaBeans.CustomerJavaBean"></jsp:useBean>
<%

String PaginaSiguiente = "../../index.jsp";
String mensajePagSig = "";
if (customerJavaBean == null || customerJavaBean.getCorreo().equals("")) {
	
	String Correo = request.getParameter("Correo");
	String Contrasena = request.getParameter("Contrasena");
	String NombreUsuario = request.getParameter("NombreUsuario");
	String Nombre = request.getParameter("Nombre");
	String TipoUsuario = request.getParameter("TipoUsuario");
	LocalDateTime HoraRegistro = LocalDateTime.now();
	
	if (Correo != null) {

		String url = application.getInitParameter("url");
		String usuario = application.getInitParameter("user");
		String contrasena = application.getInitParameter("password");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(url,usuario,contrasena);
		ArrayList<UsuarioDTO> usuariosInfo = usuarioDAO.SolicitarTodosUsuarios();
		
		Boolean Error = false;
		
		for(UsuarioDTO i : usuariosInfo){
			
			if(i.getCorreo().equals(Correo)){
			
				PaginaSiguiente = "../../Usuario/ErrorExisteUsuario.jsp";
				Error = true;
			}
		}
		if(!Error){
			
			UsuarioDTO nuevoUsuario = new UsuarioDTO(Nombre, Correo, NombreUsuario, Contrasena, TipoUsuario, HoraRegistro);
			usuarioDAO.CrearUsuario(nuevoUsuario);
			customerJavaBean.setNombreUsuario(NombreUsuario); 
			customerJavaBean.setTipoUsuario(TipoUsuario); 
			customerJavaBean.setHoraRegistro(HoraRegistro); 
		}
		else {
			
			PaginaSiguiente = "../Vista/MenuRegistro.jsp";
			mensajePagSig = "Error en el proceso de registro";
		}
	}
	else {
		
		PaginaSiguiente = "../Vista/MenuRegistro.jsp";		
	}
}
%>
<jsp:forward page="<%=PaginaSiguiente%>">
	<jsp:param value="<%=mensajePagSig%>" name="message"/>
</jsp:forward>