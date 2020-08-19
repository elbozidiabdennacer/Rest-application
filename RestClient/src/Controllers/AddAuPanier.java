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

import Entites.Panier;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

@WebServlet("/AddAuPanier")
public class AddAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddAuPanier() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("client") == null) {

			request.getRequestDispatcher("/Login.jsp").forward(request, response);

		} else {

			try {
				int idb = Integer.parseInt(request.getParameter("id"));
				Entites.Client cl = (Entites.Client) request.getSession().getAttribute("client");
				int idc = cl.getIdC();
				
				System.out.println(idb +" "+idc);

				Panier p = new Panier(idc, idb, 1);
				Jsonb jsonb = JsonbBuilder.create();
				String panier=jsonb.toJson(p, Panier.class);

				String op = (String) request.getParameter("op");

				if (op.equals("plus") || op.equals("plus2")) {

					

					

					try {
						URL url = new URL("http://localhost:8080/RestServ/Operations/addArticle");
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setDoOutput(true);
						con.setRequestMethod("POST");
						con.setRequestProperty("Content-Type", "application/json");
        	           // con.setRequestProperty("Accept", "application/json");
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

					if (op.contentEquals("plus"))
						request.getRequestDispatcher("/Panier.jsp").forward(request, response);
					else
						request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
					

				}

				else if (op.equals("sous")) {
					
					URL url = new URL("http://localhost:8080/RestServ/Operations/sArticle");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setDoOutput(true);
					con.setRequestMethod("DELETE");
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
					request.getRequestDispatcher("/Panier.jsp").forward(request, response);
					

				}

				else if (op.equals("elim")) {

					URL url = new URL("http://localhost:8080/RestServ/Operations/rmArticle");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setDoOutput(true);
					con.setRequestMethod("DELETE");
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
					request.getRequestDispatcher("/Panier.jsp").forward(request, response);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
