package Entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Commande {
	
	private int idC,idBk,qnt;
	private String date,nomC,prenomC,teleC,addresseC,nomBk,emailC;
	
	
	
	public Commande(int idC, int idBk, int qnt, String date, String nomC, String prenomC, String teleC,
			String addresseC, String nomBk, String emailC) {
		super();
		this.idC = idC;
		this.idBk = idBk;
		this.qnt = qnt;
		this.date = date;
		this.nomC = nomC;
		this.prenomC = prenomC;
		this.teleC = teleC;
		this.addresseC = addresseC;
		this.nomBk = nomBk;
		this.emailC = emailC;
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

	public String getTeleC() {
		return teleC;
	}

	public void setTeleC(String teleC) {
		this.teleC = teleC;
	}

	public String getAddresseC() {
		return addresseC;
	}

	public void setAddresseC(String addresseC) {
		this.addresseC = addresseC;
	}

	public String getNomBk() {
		return nomBk;
	}

	public void setNomBk(String nomBk) {
		this.nomBk = nomBk;
	}

	public String getEmailC() {
		return emailC;
	}

	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}

	public Commande() {}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public int getIdBk() {
		return idBk;
	}

	public void setIdBk(int idBk) {
		this.idBk = idBk;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	

}
