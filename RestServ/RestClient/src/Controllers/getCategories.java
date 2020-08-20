package Controllers;


import java.io.IOException;
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




@WebServlet("/getCategories")
public class getCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getCategories() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    Client client = javax.ws.rs.client.ClientBuilder.newClient();
		    WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getCategorie");
		    String str = target.request(MediaType.APPLICATION_JSON).get(String.class);
		    
		    ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		   
		    System.out.println(str);

		    List<Biblio> listcat = (List<Biblio>) objectMapper.readValue(str, new TypeReference<List<Biblio>>(){});
		   
		    
		    for (Biblio b:listcat) {
		    	System.out.println(b.getIdb());
		    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
