<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
  <title>No Autorizado</title>
  <style type="text/css">
  @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
  body {
    background-color: #95c2de;
  }

  .mainbox {
    background-color: #95c2de;
    margin: auto;
    height: 600px;
    width: 600px;
    position: relative;
  }

    .err {
      color: #ffffff;
      font-family: 'Roboto', sans-serif;
      font-size: 7rem;
      position:absolute;
      left: 15%;
      top: 10%;
    }

  .far {
    position: absolute;
    font-size: 8.5rem;
    left: 42%;
    top: 15%;
    color: #ffffff;
  }
  .msg {
      text-align: center;
      font-family: 'Roboto', sans-serif;
      font-size: 1.6rem;
      position:absolute;
      left: 16%;
      top: 45%;
      width: 75%;
    }

  a {
    text-decoration: none;
    color: white;
  }

  a:hover {
    text-decoration: underline;
  }
  </style>
  </head>
  <body>
    <div class="mainbox">
      <div class="err">E R R O R</div>
      <div class="msg">No tienes permiso para acceder a esa página.<p>Pulse para volver al <a href=<%= request.getContextPath() + "/P3/Vistas/Home.jsp" %>>home</a> e intentelo de nuevo.</p></div>
        </div>
  </body>
</html>