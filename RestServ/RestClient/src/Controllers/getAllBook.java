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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Entites.Biblio;
import Entites.Book;





@WebServlet("/getAllBook")
public class getAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getAllBook() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Livres
		Client client = javax.ws.rs.client.ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getBook");
		String str = target.request(MediaType.APPLICATION_JSON).get(String.class);
	
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		if(!str.equals("")) {
			List<Book> listbook = Arrays.asList(objectMapper.readValue(str, Book[].class));
		    request.setAttribute("listbook",listbook);
	    }
	    else {
	    	request.getSession().setAttribute("listbook",new ArrayList<Book>());
	    }
	    
	    
	    // Categories
	    WebTarget target1 = client.target("http://localhost:8080/RestServ/Operations/getCategorie");
	    String str1 = target1.request(MediaType.APPLICATION_JSON).get(String.class);
	    

	    if(!str1.equals("")) {
	        List<Biblio> listcat = (List<Biblio>) objectMapper.readValue(str1, new TypeReference<List<Biblio>>(){});
	        request.getSession().setAttribute("listcat",listcat);
	    }
	    else {
	    	request.getSession().setAttribute("listcat",new ArrayList<Biblio>());
	    }
	    
	 request.getRequestDispatcher("/Accueil.jsp").forward(request,response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
