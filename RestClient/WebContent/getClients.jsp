<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="Entites.*" %>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<% 
        if(request.getSession().getAttribute("client") == null)
        {
            response.sendRedirect("/Login.jsp");
        }

		List<Client> listcli = (List<Client>) request.getAttribute("listclients");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel='stylesheet' type='text/css' href='FichierCss/AdminAccueil.css'>
<style type="text/css">

a{
text-decoration:none;
}
</style>

<script src="javascript.js"></script>
</head>
<body>


   <%
    String Nom="",Prenom="";
   if(request.getSession().getAttribute("client") !=null){
	   Client cl = (Client) request.getSession().getAttribute("client");
	   Nom =(String) cl.getNomC();
	   Prenom = (String) cl.getPrenomC();
	   
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
		     <li><a href="Logout">Logout</a></li>
		    </ul>
		  </li>
		  
		 <li class="list2"><a href="Panier.jsp">Panier</a></li>
		  
		  <li class="list2"> Contact moi
		     <ul>
		       <li>Email :abdennacer@gmail.com</li>
		       <li>Télé  :0621547589</li>
		     </ul>
		   </li>
		 
		 </ul>
		 
	</div>

	<div class="tab-books">
	<table border="1">
		 <tr style="color:black;">
		 <th>Nom Prenom</th>
		 <th>Addresse</th>
		 <th>Email </th>
		 </tr>
	   <%
	   for(Client cl:listcli){
	   %>
	   <tr>
	   <td><%=cl.getIdC() %>. <%=cl.getNomC() %> <%=cl.getPrenomC() %></td>
	   <td><%=cl.getAddresseC() %></td>
	   <td><%=cl.getEmail() %></td>
	   </tr>

       <%} %>
       
     </table>
       
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

	</div>
		
</body>
</html>