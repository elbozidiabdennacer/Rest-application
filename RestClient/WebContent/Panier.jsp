<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="javax.swing.ImageIcon" %>
<%@page import="Entites.*"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%
  
   if(request.getSession().getAttribute("client")==null)  response.sendRedirect("Login.jsp");
    
    List<Book> panie = (List<Book>) request.getAttribute("panier"); 
    List<Biblio> listcat = (List<Biblio>) request.getSession().getAttribute("listcat");
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier</title>
<link rel='stylesheet' type='text/css' href='FichierCss/panie.css'>
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

    <div class="ligneP">
    
   <%
   Double prixT=0.0;
   if(panie !=null){
   for(Book bk : panie){
	  // System.out.println(lp.getBook().getPath());
    %>
    <ul class="trP">
       <li><img class="imgP" src="<%=bk.getPath()%>" alt="None"></li>
       <li class="nomP"><%=bk.getNomBk() %></li><li></li>
       <li class="prix"><%=bk.getPrixBx() %> Dhs</li>
       <li class="moin">unité: <%=bk.getQnt() %></li>
       <li class="moin"><a href="AddAuPanier?op=plus&id=<%=bk.getIdBk()%>">+</a> | <a href="AddAuPanier?op=sous&id=<%=bk.getIdBk()%>">-</a> | <a href="AddAuPanier?op=elim&id=<%=bk.getIdBk()%>">x</a></li>
    </ul>
    <hr>
    <%
    
    prixT +=bk.getQnt()*bk.getPrixBx();
    }
   }
    %> 
    <ul class="trP2">
    <li class="nomP">Prix Total</li><li></li><li></li>
    <li class="prix"><b><%=prixT %> Dhs</b></li><li></li>
    </ul>
    
    <%if(panie !=null){ %>
    <div class="divbtn">
			<form method='post' action="traitCommande?op=post" >
			
			 <input type="submit" name="btne" value="Buy" class="btn" />
			  
			</form>
   </div>
    <%} %>
    </div>
    			


	
	<div class='Your_Book'>
		<p class='p1'>Yourbook</p>
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
		
  <div class="panier" id="panier">
  <ul>
         <li> <a href="Accueil.jsp">Accueil</a></li>
         <%
         for(Biblio bb:listcat){
         %>
        <li> <a href="Categorie.jsp?idbiblio=<%=bb.getIdb()%>"><%=bb.getNomB() %></a></li>
        <%}%>
		
     </ul>
	</div>




</body>
</html>