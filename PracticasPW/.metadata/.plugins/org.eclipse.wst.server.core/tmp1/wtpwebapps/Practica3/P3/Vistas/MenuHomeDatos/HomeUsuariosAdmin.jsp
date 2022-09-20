<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean  id="allUsersBean" scope="session" class="JavaBeans.TodosUsuariosJavaBean"></jsp:useBean>
<%@ page import="JavaBeans.TodosUsuariosJavaBean"%>
<%@ page import="GeneralDTO.UsuarioDTO"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<title>Panel de Administrador</title>
</head>
<body>
	<jsp:include page="../CabeceraNavegacionAdmin.jsp"></jsp:include>
<% 
request.getSession().getAttribute("allUsersBean");
if (allUsersBean != null) {
%>
<section>
  <h1>Usuarios de la web</h1>
  <div class="tbl-header">
    <table>
      <thead>
        <tr>
          <th>Usuario</th>
          <th>Rol</th>
          <th>Fecha de Registro</th>
          <th>Ultima conexion</th>
        </tr>
      </thead>
    </table>
  </div>
<%

	for (UsuarioDTO user : allUsersBean.getAllUsers()){
%>
  <div class="tbl-content">
   <table>
    <tbody>
    <tr>
	<td><%= user.getNombreUsuario()%></td>
	<td><%= user.getTipoUsuario()%></td>
	<td> <%= user.getRegistroToString() %></td>
	<td><%= user.getConexionToString()%></td>
	
</tr>
<%
}
%>
</tbody>
    </table>
  </div>
</section>
<%
	}
%>
<script src="../../JavaScript/ScrollTablaModificarFechas.js"></script>
</body>
</html>