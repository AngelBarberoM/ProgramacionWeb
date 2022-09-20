<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="customerJavaBean" scope="session" class="JavaBeans.CustomerJavaBean"></jsp:useBean>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registro</title>
	</head>
	<body>
	<%
		String PaginaSiguiente = "../Controlador/ControladorRegistro.jsp";
		String MensajePagSig = request.getParameter("message");
		if (MensajePagSig == null) MensajePagSig = "";

		if (customerJavaBean != null && !customerJavaBean.getCorreo().equals("")) {
			
			PaginaSiguiente = "../../index.jsp";
		} else {
			%>
			<h3>Registro Usuario</h3>
			<form method="post" action="../Controlador/ControladorRegistro.jsp">
				<label for="Nombre">Nombre: </label>
				<input type="text" name="Nombre" value=""><br/>
				
				<label for="Correo">Correo: </label>
				<input type="text" name="Correo" value=""><br/>
				
				<label for="NombreUsuario">NombreUsuario: </label>
				<input type="text" name="NombreUsuario" value=""><br/>
				
				<label for="Contrasena">Contrasena: </label>
				<input type="password" name="Contrasena" value=""><br/>
				
				<label for="TipoUsuario">Tipo de Usuario: </label><br/>
				<select name="TipoUsuario">
					<option value="Administrador">Administrador</option>
					<option value="Usuario">Usuario</option>
				</select>
				
				<br/>
				<input type="submit" value="Registrar Usuario">
			</form>
			<%
		}
	%>
	</body>
</html>