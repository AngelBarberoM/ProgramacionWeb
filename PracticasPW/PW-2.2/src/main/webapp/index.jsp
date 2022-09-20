<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="customerJavaBean" scope="session" class="JavaBeans.CustomerJavaBean"></jsp:useBean>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Práctica 2 Ejercicio 2</title>
	</head>
	<body>
		<% 
		if (request.getParameter("reset") != null) {
		
			%>
			<jsp:setProperty property="CorreoUsuario" value="" name="customerJavaBean"/>
			<jsp:setProperty property="NombreUsuario" value="" name="customerJavaBean"/>
			<%
		}
		if (customerJavaBean == null || customerJavaBean.getCorreo().equals("")){
			%>
			<h2>Bienvenido, ¿Que desea hacer?</h2>
			
			<a href="/PW-2.2/M.V.C/Controlador/ControladorInicioSesion.jsp">Iniciar Sesion</a>
			<a href="/PW-2.2/M.V.C/Controlador/ControladorRegistro.jsp">Registrarse</a>
			<% 	
		} 
		else{ 

			if(customerJavaBean.getTipoUsuario().equals("Usuario")) {
				
				String usuario = customerJavaBean.getNombreUsuario();
				%>
				¡¡Hola <%=customerJavaBean.getNombreUsuario()%>!!<br>
				Hoy es <%= (new java.util.Date()).toString()%> <br>
				Te has registrado el dia <%=customerJavaBean.getHoraRegistro()%><br>
				<% 
			}
			else{
			
				String usuario = customerJavaBean.getNombreUsuario();
				%>
				¡¡Hola <%=customerJavaBean.getNombreUsuario()%>!!<br>
				Hoy es <%= (new java.util.Date()).toString()%> <br>
				Te has registrado el dia <%=customerJavaBean.getHoraRegistro()%><br>
				<%
			}
		} 
		%>
	
	</body>
</html>