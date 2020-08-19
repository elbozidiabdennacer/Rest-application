<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter livre ou categorie</title>
<style type="text/css">

label{
  display:block;
  float:left;
  width:150px;
  
  font-size:15px;
  font-weight:bold;
}
input{
      
      width:400px;
      height:30px;
      border:2px solid #00bfff;
      border-radius:5px;
      box-shadow:1px 1px 1px #9779ce;
      font-size:15px;
    
}
.add{
    width:70px;
    height:30px;
}

#add_book{
   
   float:left;
   margin:0px 30px;
}
#add_beblio {
	margin-top: 70px;

}
#path{
      
      background:none;
}
.Your_Book{Color:#ffffff; 
           Background:#2d9bd7;
           height:60px;
           width:100%;
           position:fixed;
           left:0%;top:0%;
           }
.p1{
		margin-left: 40px;
		margin-top:5px;
		font-size: 200%;
	

}         

</style>
</head>
<body>
 
 <%
 if(request.getSession().getAttribute("client") == null){
	 response.sendRedirect("Accuiel.jsp");
 }
 %>

   <div class='Your_Book'>
			<p class='p1'>Ajouter un livre ou un categorie</p>
	</div>

<form method="post" action="setLivreCat?op=livre" id="add_book">
<label>Nom : </label><br><input type ="text" name="nombk" ><br><br>
<label>Auteur : </label><br><input type ="text" name="Auteur" ><br><br>
<label>Date_edition : </label><br><input type ="date" name="date_edition" ><br><br>
<label>Prix : </label><br><input type ="number" name="prix" ><br><br>
<label>Beblio : </label><br><input type ="number" name="beblio" ><br><br>
<label>image : </label><br><input type="file" name="path" id="path"><br><br>
<br><br>
<input type="submit" value="add" class="add">
</form>

<form method="post" action="setLivreCat?op=biblio" id="add_beblio">
<label>Nom beblio : </label><br><input type ="text" name="nombb" ><br><br>
<label>Id beblio: </label><br><input type ="number" name="idbb"><br><br><br>
<input type="submit" value="add" class="add">
</form>

</body>
</html>