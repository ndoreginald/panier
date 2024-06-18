
<%@ page language="java" import ="java.util.ArrayList,java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 	
	String login = (String) session.getAttribute("login");
	String password = (String) session.getAttribute("password");
	
	//tester l'existence des attributs dans la session
	if ((login==null) || (password==null))
	{
		//retourner à la page d'authentification
		request.getRequestDispatcher("connexion.jsp").forward(request, response);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Votre panier</title>
<link rel ="stylesheet" type ="text/css" href="<%=request.getContextPath()%>/css/liste.css"/>
	<style>
        .button-container {
            display: flex;
            justify-content: space-around;          
        }
    </style>
</head>

<body>
<h3 style="text-align: right;">profil : <%=login %></h3>
<h1>Contenu de votre panier</h1>

<br>
 

	<br>
	 <ul>
        <% 

            // Récupérer le panier depuis la session
            ArrayList<String> panier = (ArrayList<String>) session.getAttribute("panier");
        	
     		// Calculer le nombre total de produits
        	int totalProduits = (panier != null) ? panier.size() : 0;

     		// Afficher les produits dans le panier
	        if (panier != null && !panier.isEmpty()) {
	            for (int i = 0; i < panier.size(); i++) {
	                String product = panier.get(i);
	    %>
	            <li><%= i + 1 + ". " + product %></li>
	    <%
	                }
	            } else {
	        %>
	                <li>Aucun produit dans le panier</li>
	        <%
	            }
	        %>
		    </ul>
		    <b style="color:green;">
	 	<% 
		String message = (String) request.getAttribute("message");
		if ((message != null))
			{
				out.print(message);
			}
	    %> 
    </b>
		<br><br><br>
		<h3>Nombre total de produits dans le panier : <%= totalProduits %></h3>

<hr>
	<div class="button-container">
	<form action="ListeProduits.jsp" method="get">
        <input type="submit" value="Retourner à la liste des produits"> 
    </form>
    
    <form action="Deconnexion.jsp" method="get">
        <input type="submit" value="Se déconnecter"> 
    </form>  
  	</div>
</body>
</html>