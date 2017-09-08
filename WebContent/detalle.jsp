<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.canciones.pojo.Cancion"%>
<h1>Detalle Canciones</h1>

<%
	//recoger atributos

	String msg = (String) request.getAttribute("mensaje");
	Cancion c = (Cancion) request.getAttribute("cancion");
%>

<p style="color: green;"><%=msg%></p>

<br>

<b>Nombre:<%=" "+c.getNombre()%></b>

<br>

<b>Artista:<%=" "+c.getArtista()%></b>

<br>

<b>Duracion:<%=" "+c.getDuracion()%></b>

<br>

