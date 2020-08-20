<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="Entites.*" %>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>

<%
  
	if(request.getAttribute("listbookcat") == null)
		{
		    response.sendRedirect("getBookCat");
		}
	
	if(request.getSession().getAttribute("listcat") == null)
		{
		    response.sendRedirect("getAllBook");
		}

	List<Book> listbook = (List<Book>) request.getAttribute("listbookcat");
	List<Biblio> listcat = (List<Biblio>) request.getSession().getAttribute("listcat");   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=listbook.get(0).getNomB() %></title>
<link rel='stylesheet' type='text/css' href='FichierCss/Accueil.css'>
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
		     <li><a href="getLogin?op=out">Logout</a></li>
		    </ul>
		  </li>
		  
		<li class="list2"><a href="getPanier">Panier</a></li>
		  
		  <li class="list2"> Contact moi
		     <ul>
		       <li>Email :abdennacer@gmail.com</li>
		       <li>Télé  :0621547589</li>
		     </ul>
		   </li>
		 
		 </ul>
	</div>
	
	<div class="tab-books">

		

			<%
			    for(int j=0;j<listbook.size();j++) {
				int i= 1;
			%>
			<table>
			 <tr>
			  <%while(i<5 && j<listbook.size()){%>
			  
				 <th width="150px"    >
				 <a href="getBookid?idbook=<%=listbook.get(j).getIdBk() %>" > <img src="<%=listbook.get(j).getPath()%>"  onMouseOut="id='ns'" onMouseOver="id='img'" >
				 <br>
		          <%=listbook.get(j).getNomBk() %></a> <br> 
		          <div class="divi"> <button onclick="window.location.href = 'getBookid?idbook=<%=listbook.get(j).getIdBk() %>';" class="btni">watch</button>
		           <button onclick="window.location.href = 'AddAuPanier?op=plus2&id=<%=listbook.get(j).getIdBk() %>';" class="btni2">add</button> </div>
				 </th>
				   
				<%
				 
				 i++; j++;
			     }
				%>
					
			</tr>
			</table>
			<br><br>
			<% } %>

		
						
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
		
  <div class="panier" id="panier">
	    <ul>
         <li> <a href="Accueil.jsp">Accueil</a></li>
         <%
         for(Biblio bb:listcat){
         %>
        <li> <a href="getBookCat?idbiblio=<%=bb.getIdb()%>"><%=bb.getNomB() %></a></li>
        <%}%>
		
     </ul>
	</div>
</body>
</html>