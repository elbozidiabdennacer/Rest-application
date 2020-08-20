package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;



@WebServlet("/traitClients")
public class traitClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public traitClients() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opr = request.getParameter("opr");
		
		if(opr.equals("get")) {
			if (request.getSession().getAttribute("client") == null) {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}else {
			
			
			Entites.Client clt = (Entites.Client) request.getSession().getAttribute("client");

			Client client = javax.ws.rs.client.ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getClients/"
					+ clt.getEmail() + "/" + clt.getPassword());
			String str = target.request(MediaType.APPLICATION_JSON).get(String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			List<Entites.Client> listclients = Arrays.asList(objectMapper.readValue(str, Entites.Client[].class));
			
			request.setAttribute("listclients", listclients);
			request.getRequestDispatcher("getClients.jsp").forward(request, response);
			}
			}
			
			if(opr.equals("post")){
				
				String nom = (String) request.getParameter("nom");
				String prenom = (String) request.getParameter("Prenom");
				String Email = (String) request.getParameter("Email");
				String Adresse = (String) request.getParameter("Adresse");
				String Tele = (String) request.getParameter("Tele");
				String pass = (String) request.getParameter("pass");

				if (nom.equals("") || prenom.equals("") || Email.equals("") || Adresse.equals("") || Tele.equals("")
						|| pass.equals("")) {
					request.setAttribute("erreurs", "Remplir tous les champs, pour bien sing in !");
					request.getRequestDispatcher("/Signin.jsp").forward(request, response);
				} else {
					

					Entites.Client cl = new Entites.Client();
					cl.setNomC(nom);
					cl.setPrenomC(prenom);
					cl.setEmail(Email);
					cl.setAddresseC(Adresse);
					cl.setTeleC(Tele);
					cl.setPassword(pass);
					
					Jsonb jsonb = JsonbBuilder.create();
					  String clt=jsonb.toJson(cl, Entites.Client.class);
					
					try {
						URL url = new URL("http://localhost:8080/RestServ/Operations/addClient");
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setDoOutput(true);
						con.setRequestMethod("POST");
						con.setRequestProperty("Content-Type", "application/json");
	  	           
						OutputStream os = con.getOutputStream();
						os.write(clt.getBytes());
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
					request.getRequestDispatcher("/getLogin?op=in&Email_l="+Email+"&passl="+pass).forward(request, response);
				}
				
								
			}
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
