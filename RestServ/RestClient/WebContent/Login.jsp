<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel='stylesheet' type='text/css' href='FichierCss/Login.css'>
</head>
<body>

<div class='container-box'>
		
		<%
		String Erreur="";
		if(request.getAttribute("erreur")!=null)
			Erreur=(String)request.getAttribute("erreur");
		%>

		<form method='post' action='getLogin?op=in'>
			
			
			<p class="cnx">Connexion</p><br><br>
			

			<div class='name'>
				 <label for='Email_l'>Email :</label>
				 <input class='input3' name='Email_l' id='Email_l' type='Email' placeholder='Email' required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" /><br>
			</div>
			 
			 <br>

			<div class='name'>
				 <label for='passl'>Password :</label>
				 <input class='input3' name='passl' id='passl' type='password' placeholder='Password' required="required" pattern="[A-Za-z0-9]{4,}" />
				 <p style="color:red;font-family:sans-serif;font-size: small;margin-left: 20px;margin-top:25px; "><%=Erreur %></p>
			</div>
			
			<br><br>
			<div class='name'>
				 <input class='input2' name='submit' type='submit' value='Log in' />
			</div>
			<div>
			<a href="Signin.jsp" class="alog">Créer un compte</a>
			</div>
		</form>
		
	</div>
	
	<div class='login'>
			<p class='p1'>Log in</p>
	</div>
	

</body></html>