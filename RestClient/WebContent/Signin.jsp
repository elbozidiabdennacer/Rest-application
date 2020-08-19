<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signin</title>
<link rel='stylesheet' type='text/css' href='FichierCss/Singin.css'>
</head>
<body>
 	   <%
		String Erreur="";
		if(request.getAttribute("erreurs")!=null)
			Erreur=(String)request.getAttribute("erreurs");
		%>
	
	<div class='container-box'>
		
		<form method='post' action='traitClients?opr=post'>
			
		
			<div class='name'>
				 <label for='nom'>Nom :</label> 
				 <input class='input3' name='nom' id='nom' type='text' placeholder='Nom' required="required" pattern="[A-Za-z]{3,}" /><br>
			</div>
			
			<div class='name'>
				 <label for='Prenom'>Prenom :</label> 
				 <input class='input3' name='Prenom' id='Prenom' type='text' placeholder='Prenom' required="required" pattern="[A-Za-z]{3,}" /><br>
			</div>
			
			<div class='name'>
				 <label for='Email'>Email :</label> 
				 <input class='input3' name='Email' id='Email' type='Email' placeholder='Email' required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" /><br>
			</div>
			
			<div class='name'> 
				 <label for='Adresse'>Adresse :</label> 
				 <input class='input3' name='Adresse' id='Adresse' type='text' placeholder='Adresse' required="required" pattern="[A-Za-z]{4,}"/><br>
			</div>
			
			<div class='name'>
				 <label for='Tele'>Tele :</label> 
				 <input class='input3' name='Tele' id='Tele' type='tel' placeholder='Tele' pattern="[0-9]{9,}"/><br>
			</div>
			
			<div class='name'>
				 <label for='pass'>Mot de passe :</label> 
				 <input class='input3' name='pass' id='pass' type='password' placeholder='Password' required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" /><br>
				 <p style="color:red;font-family:sans-serif;font-size: small;margin-left: 20px;margin-top:25px; "><%=Erreur %></p>
			</div>
			
			
			
			<br><br>
			<div class='name'>
				 <input class='input2' name='submit' type='submit' value='Sign in' />
			</div>
			<a  href="Login.jsp" class="alog">vous avez déja un compte ?</a>
		</form>
		  
		
	</div>
	
	<div class='login'>
		<p class='p1'>Sign in</p>
	</div>
	
<br><br><br><br>
</body>
</html>