Prácticas desarrolladas por:
- Ángel Barbero Mellado
- Jose Miguel Gómez Castro

En esta carpeta se pueden encontrar las 3 prácticas divididas de la siguiente manera:

- Práctica 1:
	· PW-1.1
	· PW-1.2

- Práctica 2:
	· PW-2.1
	· PW-2.2

- Práctica 3:
	· Practica3

En nuestros correspondientes dispositivos, las prácticas funcionan correctamente, sin fallos.

Importante utilizar OpenVPN para conectarse a la red de la UCO si no se encuentra dentro de ella, ya que si no el sistema no podrá acceder a la Base de Datos de la UCO, y por tanto dará fallo.

En cuanto se abren en otro dispositivo se debe eliminar del Build Path, ubicado en las propiedades del proyecto, el conector de MySQL, debido a que coge la ruta total, y hay que volverlo a añadir, este se encuentra en la carperta lib de cada práctica, hay 4, y de esos 4 hay que escoger el mismo que estaba, mysql-connector-java-5.1.49, ya que el resto no se si da errores.

Importante leer los informes de prácticas, para la práctica 2.2 y 3 debido a que se tiene que cambiar la ruta de unos archivos para que funcione correctamente, de todas maneras a continuación os lo voy a volver a dejar detallado por si se tiene alguna duda:

Instrucciones para el sistema

- Práctica 2.2:
	
	Para que la práctica 2.2 funcione correctamente, se debe hacer lo siguiente:
	Encontrar el fichero UsuarioDAO.java, ubicado en la carpeta GeneralDAO.
	Abrir el fichero UsuarioDAO.java.
	Una vez abierto, modificar la variable denominada RutaSQL cuyo valor por defecto es el siguiente: 
	private String RutaSQL ="C:\\Users\\Ángel Barbero\\eclipse-workspace\\PW-2.2\\src\\main\\webapp\\WEB-INF\\sql.properties";
	Se debe reemplazar la ruta  que aparece entre comillas por otra, esta es donde se encuentre el archivo sql.properties, una vez descomprimida la carpeta, la ruta total, debido a que al menos a mi no me ha funcionado correctamente si indicaba una ruta relativa.
	Con ese cambio la conexión con la base de datos no debería fallar.

	Por otro lado, como se ha comentado anteriormente en las dificultades que se han encontrado, se ha utilizado Apache Tomcat 8.5, concretamente la versión apache-tomcat-8.5.82 la misma utilizada para la práctica 3, sabemos que en el enunciado de la práctica se nombraba que se tenía que utilizar Apache Tomcat 7.0 de la uco, la cual nunca encontré, me descargué la 7.0 general pero me daba fallos al utilizar el archivo web.xml donde se encuentran los datos de conexión con la base de datos, y tenía también instalado el servidor para la práctica 3, que era el 8.5, y con ese me no daba fallos, y por falta de tiempo tuve que seguir con Apache Tomcat 8.5.

- Práctica 3
	
	Para que la práctica 3 funcione correctamente, se debe hacer lo siguiente:
	Encontrar los ficheros UsuarioDAO.java, CriticasDAO.java, EspectaculosDAO.java, ubicados en la carpeta GeneralDAO.
	Abrir los ficheros UsuarioDAO.java, CriticasDAO.java, EspectaculosDAO.java.
	Una vez abierto, modificar la variable denominada RutaSQL, en los 3 ficheros, cuyo valor por defecto es el siguiente: 
	private String RutaSQL ="C:\\Users\\Ángel Barbero\\eclipse-workspace\\Practica3\\src\\main\\webapp\\WEB-INF\\sql.properties";
	Se debe reemplazar la ruta  que aparece entre comillas por otra, esta es donde se encuentre el archivo sql.properties, una vez descomprimida la carpeta, la ruta total, debido a que al menos a mi no me ha funcionado correctamente si indicaba una ruta relativa.
	Con ese cambio la conexión con la base de datos no debería fallar.

	Por otro lado, se ha utilizado Apache Tomcat 8.5, concretamente la versión apache-tomcat-8.5.82, en el enunciado de la práctica se nombraba que se tenía que utilizar Apache Tomcat 8.5 de la uco, la cual nunca encontré, me descargué la 8.5 general por que no sabíamos cual teníamos que elegir.


Aclarar que tanto en la práctica 2.2, como en la práctica 3 se ha utilizado el servidor Apache Tomcat 8.5, como se comenta anteriormente, mas concretamente la versión apache-tomcat-8.5.82, ya que para la práctica 2.2, la version 7.0 nos daba problemas y no sabíamos el por que. 

Tanto en el enunciado de la práctica 2 como el de la práctica 3 se comenta lo siguiente:
Tomcat standalone (7.0) instalado en la UCO.
Tomcat standalone (versión 8.5) dispuesto en la UCO.

No sabíamos a que se quería referir, y no encontramos ninguno de los dos, por lo que cogimos las versiones directamente des de Apache Tomcar, que posteriormente la versión 7.0 fallaría con el fichero web.xml, y tuvimos que elegir la version 8.5 para los dos proyectos.

Por último decir que hemos tenido 1 mes y medio para el desarrollo de las 3 prácticas, las cuales se han intentado dejar lo mejor posible, partíamos de una base nula, tanto con Eclipse como con el lenguaje de programación Java, por tanto a medida que hacíamos las prácticas teníamos que ir aprendiendo como se hacía.