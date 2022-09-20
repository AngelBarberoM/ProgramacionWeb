<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerJavaBean" scope="session" class="JavaBeans.CustomerJavaBean"></jsp:useBean>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inicio Sesion</title>
	</head>
	<body>
	<%
		String PaginaSiguiente = "../Controlador/ControladorInicioSesion.jsp";
		String MensajePagSig = request.getParameter("message");

		if (MensajePagSig == null) {
			
			MensajePagSig = "";
		}

		if (customerJavaBean != null && !customerJavaBean.getCorreo().equals("")) {
			
			PaginaSiguiente = "../../index.jsp";
		} 
		else {
			%>
			<h3>Inicio Sesion</h3>
			<form method="post" action="../Controlador/ControladorInicioSesion.jsp">
				<fieldset>
					<legend>Inicio Sesion</legend>
						Correo:<br>
						<input type="email" name="Correo"> <br>
				
						Contrasena:<br>
						<input type="password" name="Contrasena"> <br><br>
						
						<input type="submit" value="Inicio Sesion">
				</fieldset>
			</form>
			<br>
			<%
			String myPage = "../Controlador/ControladorRegistro.jsp";
			%>
				<fieldset>
				<h3>Para poder registrarte, pincha en el siguiente botón: </h3>
				<input type="button" value="Registrarse" onClick="javascript:window.location='<%= myPage %>';">
				</fieldset>
			<%
		}
	%>
	</body>
</html>