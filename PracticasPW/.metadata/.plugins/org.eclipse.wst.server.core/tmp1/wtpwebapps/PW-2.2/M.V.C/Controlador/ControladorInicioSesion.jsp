<%@page import="JavaBeans.CustomerJavaBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="GeneralDTO.UsuarioDTO,GeneralDAO.UsuarioDAO,java.time.LocalDateTime,java.util.ArrayList" %>
<jsp:useBean  id="customerJavaBean" scope="session" class="JavaBeans.CustomerJavaBean"></jsp:useBean>
<%

String PaginaSiguiente = "../../index.jsp";
String mensajePagSig = "";
if (customerJavaBean == null || customerJavaBean.getCorreo().equals("")) {
	
	String Correo = request.getParameter("Correo");
	String Contrasena = request.getParameter("Contrasena");

	if (Correo != null) {
		
		String url = application.getInitParameter("url");
		String usuario = application.getInitParameter("user");
		String contrasena = application.getInitParameter("password");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(url,usuario,contrasena);
		
		String contra = usuarioDAO.SolicitarDatosSesion(Correo);
		ArrayList<UsuarioDTO> usuariosInfo = usuarioDAO.SolicitarTodosUsuarios();
		
		for(UsuarioDTO i : usuariosInfo){
			
			if(i.getCorreo().equals(Correo)){
			
				if (Contrasena.equals(contra)){
				
					if(i.getTipoUsuario().equals("Usuario")){
						
						String nombreUsuario = i.getNombreUsuario();
						LocalDateTime horaReg = i.getHoraRegistro();
						String tipoUsuario = i.getTipoUsuario();
						customerJavaBean.setCorreo(Correo); 
						customerJavaBean.setNombreUsuario(nombreUsuario); 
						customerJavaBean.setTipoUsuario(tipoUsuario); 
						customerJavaBean.setHoraRegistro(horaReg); 
					}
					else{
						
						String nombreUsuario = i.getNombreUsuario();
						LocalDateTime horaReg = i.getHoraRegistro();
						String tipoUsuario = i.getTipoUsuario();
						customerJavaBean.setCorreo(Correo); 
						customerJavaBean.setNombreUsuario(nombreUsuario); 
						customerJavaBean.setTipoUsuario(tipoUsuario); 
						customerJavaBean.setHoraRegistro(horaReg); 
					}
				}
				else{
					
					PaginaSiguiente = "../../Usuario/ErrorContrasena.jsp";
					mensajePagSig = "Contrasena Incorrecta";
				}
			}
			
		}
	} else {
		PaginaSiguiente = "../Vista/MenuInicioSesion.jsp";
		mensajePagSig = "Usuario no registrado en el sistema";
		}
	} else {
		PaginaSiguiente = "../Vista/MenuInicioSesion.jsp";		
	}

%>
<jsp:forward page="<%=PaginaSiguiente%>">
	<jsp:param value="<%=mensajePagSig%>" name="message"/>
</jsp:forward>