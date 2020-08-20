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

import Entites.Book;


@WebServlet("/getBookid")
public class getBookid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getBookid() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client client = javax.ws.rs.client.ClientBuilder.newClient();
		
		 if(request.getParameter("idbook")==null) {
			 
			 request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
		 }
		 else {
		 
		 
		 int id=Integer.parseInt(request.getParameter("idbook"));
		 request.setAttribute("idbo", id);
		
		WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getBookById/"+id);
		String str = target.request(MediaType.APPLICATION_JSON).get(String.class);
	
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		System.out.println(str);
	    Book book = objectMapper.readValue(str, Book.class);
	    request.setAttribute("book",book);
	    
	    request.getRequestDispatcher("/Vente.jsp").forward(request,response);
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
