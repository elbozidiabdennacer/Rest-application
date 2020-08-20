package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import Entites.Book;

@WebServlet("/getPanier")
public class getPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public getPanier() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession().getAttribute("client") == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			
		Entites.Client	clt = (Entites.Client)request.getSession().getAttribute("client");
		
		
		Client client = javax.ws.rs.client.ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getPanier/"+clt.getIdC());
		String str = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		if(!str.equals("")) {
			List<Book> panier = Arrays.asList(objectMapper.readValue(str, Book[].class));
			request.getSession().setAttribute("panier", panier);
			request.setAttribute("panier", panier);
		}
		else {
			
			request.getSession().setAttribute("panier", new ArrayList<Book>());
			request.setAttribute("panier",new ArrayList<Book>());
		}
		
		request.getRequestDispatcher("Panier.jsp").forward(request, response);
		
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
