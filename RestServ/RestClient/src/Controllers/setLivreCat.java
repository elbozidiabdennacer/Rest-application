package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entites.Biblio;
import Entites.Book;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;


@WebServlet("/setLivreCat")
public class setLivreCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public setLivreCat() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		
		if(op.equals("livre")) {
			
			  Book b = new Book();
			
			  b.setNomBk(request.getParameter("nombk"));
			  b.setAuteurBk(request.getParameter("Auteur"));
			  b.setDate_edition(request.getParameter("date_edition"));
			  b.setPrixBx(Double.parseDouble(request.getParameter("prix")));
			  b.setIdB(Integer.parseInt(request.getParameter("beblio")));
			  b.setPath(request.getParameter("path"));
			  
			  Jsonb jsonb = JsonbBuilder.create();
			  String book=jsonb.toJson(b, Book.class);
			  
			  try {
					URL url = new URL("http://localhost:8080/RestServ/Operations/addBook");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setDoOutput(true);
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json");
  	           
					OutputStream os = con.getOutputStream();
					os.write(book.getBytes());
					os.close();
					os.flush();
					
					BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
					String output;
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}

					con.disconnect();
				} catch (Exception e) {

				}
		}
		
		else {
			
			Biblio bi = new Biblio();
			bi.setIdb(Integer.parseInt(request.getParameter("idbb")));
			bi.setNomB(request.getParameter("nombb"));
			
			 Jsonb jsonb = JsonbBuilder.create();
			 String cat=jsonb.toJson(bi, Biblio.class);
			 
			 try {
					URL url = new URL("http://localhost:8080/RestServ/Operations/addBook");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setDoOutput(true);
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json");
	           
					OutputStream os = con.getOutputStream();
					os.write(cat.getBytes());
					os.close();
					os.flush();
					
					BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
					String output;
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}

					con.disconnect();
				} catch (Exception e) {

				}
		}
		
		 response.sendRedirect("/Add_bk_bb.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
