<%@page import="com.ipartek.formacion.canciones.pojo.Cancion"%>
<%@page import="java.util.ArrayList"%>


<%
	//gestion de los mensajes para el Usuario
	String mensaje = (String) request.getAttribute("mensaje");
	if(mensaje!=null){
		
		out.print("<p>"+mensaje+"</p>");
		
	}
%>

<h1>Listado Canciones</h1>

<ol>
	<%
		//recorrer el ArrayList

		ArrayList<Cancion> canciones = (ArrayList<Cancion>) request.getAttribute("listado");
		for (Cancion c : canciones) {
	%>

	<li><%=c.getNombre()%> - <%=c.getArtista()%> - <b> <%=c.getDuracion()%></b></li>

	<%
		}
	%>

</ol>

<h2>Crear Cancion</h2>

<form action="crear" method="post">

	<input type="text" name="nombre" placeholder="Escribe nombre cancion"
		required>
		 <br>
		  <input type="text" name="artista"
		placeholder="Escribe nombre artista" required>
		 <br> 
		 <input
		type="text" name="duracion" placeholder="Escribe duracion cancion"
		required> 
		<br>
		 <br> 
		 <input type="submit"
		value="Crear cancion nueva">


</form>
