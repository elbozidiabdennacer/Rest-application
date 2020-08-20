package Entites;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

	private int idC;
	private String nomC,prenomC,email,addresseC,teleC,password;
	
	public Client(String nomC, String prenomC, String email, String addresseC, String teleC, String password) {
		super();
		this.nomC = nomC;
		this.prenomC = prenomC;
		this.email = email;
		this.addresseC = addresseC;
		this.teleC = teleC;
		this.password = password;
	}
	
	public Client() {}
	
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getPrenomC() {
		return prenomC;
	}
	public void setPrenomC(String prenomC) {
		this.prenomC = prenomC;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddresseC() {
		return addresseC;
	}
	public void setAddresseC(String addresseC) {
		this.addresseC = addresseC;
	}
	public String getTeleC() {
		return teleC;
	}
	public void setTeleC(String teleC) {
		this.teleC = teleC;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
