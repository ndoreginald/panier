<%@ page language="java" import ="java.util.ArrayList, java.util.Iterator"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <% String login = (String) request.getAttribute("login");
String password = (String) request.getAttribute("password");
ArrayList<String> err = (ArrayList<String>) request.getAttribute("tab_err");
if (login==null) login="";
if (password==null) password="";

%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D�connexion</title>
</head>
<link rel ="stylesheet" type ="text/css"
href="<%=request.getContextPath()%>/css/liste.css"/>

<body>
	 <%
        // D�truire la session
        session.invalidate();
    %>

	<div>
		<h1>Merci pour votre visite.</h1>
		<p>� la prochaine.</p>
		<br><br><br><br><br><br><br>
		<hr>
		<a href="ListeProduits.jsp">Retour � la liste des produits</a> 
	</div>

</body>
</html>