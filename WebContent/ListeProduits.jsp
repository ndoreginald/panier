<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Accueil</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/liste.css">

<style>
   
  </style>
</head>

<body>

<h1>Veuillez choisir un produit :</h1>
  
 <form action='Panier' method='post'>

    <div>
      
      <input type="radio" name="produit" value="PC Portable">
      <label for="PC Portable">PC Portable</label>
    </div>

    <div>
      
      <input type="radio" name="produit" value="Imprimante">
      <label for="Imprimante">Imprimante</label>
    </div>

    <div>
      
      <input type="radio" name="produit" value="Scanner">
      <label for="Scanner">Scanner</label>
    </div>
    <br><br><br>

    <button type="submit" value="Ajouter au panier ">Ajouter au panier</button>

  </form>
  <br>
 	<b style="color:red;">
	 	<% 
		String message = (String) request.getAttribute("message");
		if ((message != null))
			{
				out.print(message);
			}
	    %> 
    </b>
 
 
</div>

</body>
</html>