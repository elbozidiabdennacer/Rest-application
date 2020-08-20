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

%>
<%

    List<Commande> listcmd =(List<Commande>) request.getAttribute("listcmds");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commandes</title>
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
	   <tr>
	   <th>Nom client</th>  <th>Email client</th>  <th> Addresse</th>  <th> Telefone</th> 
	   
	   <th>Livre</th>  <th> Quantite</th>  <th>Date </th> 
	
	   </tr>
	   <%
	   for(Commande cmd : listcmd){
	   %>
	   <tr>
	   <td><%=cmd.getNomC()%> <%=cmd.getPrenomC() %></td>
	   <td><%=cmd.getEmailC() %></td>
	   <td><%=cmd.getAddresseC() %></td>
	   <td><%=cmd.getTeleC() %></td>
	   <td><%=cmd.getIdBk() %> <br> <%=cmd.getNomBk() %></td>
	   <td><%=cmd.getQnt() %></td>
	   <td><%=cmd.getDate() %></td>
	   
	   </tr>

       <% } %>
       
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