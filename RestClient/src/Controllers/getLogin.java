package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/getLogin")
public class getLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getLogin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		
		if(op.equals("out")) {
			request.getSession().invalidate();
			request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
		}
		
		else {
		
		String email = request.getParameter("Email_l");
		String pass  = request.getParameter("passl"); 
		System.out.println(email +" "+pass);
		
		Client client = javax.ws.rs.client.ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/RestServ/Operations/login/"+email+"/"+pass);
		
		String str = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		System.out.println("Voila client"+str);
		
		
		
		if(str.equals("")) {
			
			request.setAttribute("erreur", "Mot de passe ou email incorrect. Réessayez !");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		else {
			Entites.Client cl = objectMapper.readValue(str, Entites.Client.class);
			request.getSession().setAttribute("client", cl);
			WebTarget target1 = client.target("http://localhost:8080/RestServ/Operations/estAdmin/"+cl.getEmail()+"/"+cl.getPassword());
			String str1 = target1.request(MediaType.TEXT_PLAIN).get(String.class);
			
			if(str1.equals("true")) {
				request.getRequestDispatcher("/AccueilAdmin.jsp").forward(request, response);
			}else

			request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
			
		 }
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
