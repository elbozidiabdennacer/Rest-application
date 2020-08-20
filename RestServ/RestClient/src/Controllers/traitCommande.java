package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

import Entites.Commande;
import Entites.Panier;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

@WebServlet("/traitCommandes")
public class traitCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public traitCommande() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("client") == null) {

			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {

			String op = request.getParameter("op");
			Entites.Client clt = (Entites.Client) request.getSession().getAttribute("client");

			if (op.equals("get")) {
				
				Client client = javax.ws.rs.client.ClientBuilder.newClient();
				WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getCommandes/"
						+ clt.getEmail() + "/" + clt.getPassword());
				String str = target.request(MediaType.APPLICATION_JSON).get(String.class);

				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				if(!str.equals("")) {
					List<Commande> listcmds = Arrays.asList(objectMapper.readValue(str, Commande[].class));
					request.setAttribute("listcmds", listcmds);
				}
				else {
					request.setAttribute("listcmds", new ArrayList<Commande>());
				}
				
				request.getRequestDispatcher("getCommandes.jsp").forward(request, response);
				
				
				
			}if(op.equals("post")) {
				
				Client client = javax.ws.rs.client.ClientBuilder.newClient();
				WebTarget target = client.target("http://localhost:8080/RestServ/Operations/getPanie/"+clt.getIdC());
				String str = target.request(MediaType.APPLICATION_JSON).get(String.class);

				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				
				if(!str.equals("")) {
				List<Panier> panie = Arrays.asList(objectMapper.readValue(str, Panier[].class));
				
				Jsonb jsonb = JsonbBuilder.create();
				String panier=jsonb.toJson(panie, Panier[].class);
				
				try {
					URL url = new URL("http://localhost:8080/RestServ/Operations/addCommande");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setDoOutput(true);
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json");
					OutputStream os = con.getOutputStream();
					os.write(panier.getBytes());
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
				request.getRequestDispatcher("Saved.jsp").forward(request, response);
			}
		   }
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
