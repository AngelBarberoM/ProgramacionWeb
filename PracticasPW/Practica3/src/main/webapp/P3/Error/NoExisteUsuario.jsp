<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
  <title>No existe usuario</title>
  <style type="text/css">

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
      font-size: 6.5rem;
      position:absolute;
      left: 15%;
      top: 15%;
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
      <div class="msg">Error. El correo con el que ha intentado iniciar sesión no está en nuestra base de datos.<p>Pulse para volver al <a href=<%= request.getContextPath() + "/index.jsp" %>>inicio</a> e intentelo de nuevo.</p></div>
        </div>
  </body>
</html>