<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú de Espectaculos</title>
</head>
<body>
<jsp:include page="../CabeceraNavegacionAdmin.jsp"></jsp:include>
    	
    <div class="cont">
	<div class="add">
	  <a href=./CrearEspectaculoAdmin.jsp><img class="foto" src="/Practica3/P3/Imagenes/Anadir.png" alt="dar de alta espectaculo" style="width:100%"></a>
	  <div class="container">
	<p>Dar de alta</p>
	  </div>
	</div>
	<div class="mod">
	  <a href=../../../GetTodosEspectaculos><img class="foto" src="/Practica3/P3/Imagenes/Modificar.png" alt="modificar sesiones" style="width:100%"></a>
	  <div class="container">
	  <p>Modificar sesiones</p>
	  </div>
	</div>
	<div class="cancelEsp">
	  <a href=../../../GetTodoParaEliminar><img class="foto" src="/Practica3/P3/Imagenes/Papelera.png" alt="cancelar espectaculo" style="width:100%"></a>
	<div class="container">
	  <p>Cancelar espectaculos</p>
	  </div>
	</div>
	<div class="addSes">
	  <a href=../../../GetMultiplesTemporadaServlet><img class="foto" src="/Practica3/P3/Imagenes/AnadirSesion.png" alt="añadir sesiones" style="width:100%"></a>
	<div class="container">
	  <p>Añadir sesiones</p>
	  </div>
	</div>
	<div class="cancel">
	  <a href=../../../GetMultiplesTemporadaEliminarServlet><img class="foto" src="/Practica3/P3/Imagenes/CancelarSesion.png" alt="cancelar sesiones" style="width:100%"></a>
	<div class="container">
	  <p>Cancelar sesiones</p>
	  </div>
	</div>
	</div>

</body>
</html>