<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% 
        if(request.getSession().getAttribute("client") == null)
        {
            response.sendRedirect("Login.jsp");
        }
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel='stylesheet' type='text/css' href='FichierCss/AdminAccueil.css'>
<style type="text/css">

a{
text-decoration:none;
}

</style>

<script src="scripts/javascript.js"></script>
</head>

<body>


   <%
    String Nom="",Prenom="";
   if(session.getAttribute("NomC")!=null){
	   Nom =(String) session.getAttribute("NomC");
	   Prenom = (String) session.getAttribute("PrenomC");
	   
   }
	   
   %>
   
    <div class="info">
    
	     <div class="slid">
	       <img src="Image/Slide/livre1.jpg" alt="" id="slide" class="slide">
		 </div>
		 
		 <ul class="list">
		   
		  <li class="list2"> Connexion
		    <ul>
		     <li><a href="Login.jsp">Login</a></li>
		     <li><a href="Signin.jsp">Signin</a></li>
		     <li><a href="getLogin?op=out">Logout</a></li>
		    </ul>
		  </li>
		  
		 
		  
		  <li class="list2"> Contact moi
		     <ul>
		       <li>Email :abdennacer@gmail.com</li>
		       <li>Télé  :0621547589</li>
		     </ul>
		   </li>
		 
		 </ul>
		 
	</div>


	<div class="tab-books">

       <ul>
       <li><a href="Add_bk_bb.jsp">Ajouter des livres ou categorie</a></li>
       <li><a href="traitCommandes?op=get">Voir les commandes</a></li>
       <li><a href="traitClients?opr=get">Voir les clients</a></li>
       </ul>

	</div>

	<div class='Your_Book'>
		<p class='p1'>yourbook</p>
		<div class='span'>
		<span class="welcome" id="welcome"><%=Nom %> <%=Prenom %></span>
		
		</div>

		<div class='bien'>

			<div class='menu' id="menu" onclick="myclick2()" >
				<div class='carre'></div>
				<div class='carre'></div>
				<div class='carre'></div>
			</div>

		</div>

	</div>
		
</body>
</html>