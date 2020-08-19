package Entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	
	 private int idBk;
	 private int idB;
	 private int qnt ;
	 private String date_edition;
	 private String nomBk;
	 private String auteurBk;
	 private String path;
	 private String nomB;
	 private Double prixBx;
	 
	 //constructeur
	 public Book() {}
	 
	 public Book(int IdBk,String NomBk,String AuteurBk,String Date_edition,Double PrixBk,String path,int IdB) {
		 
		 this.idBk=IdBk;
		 this.nomBk=NomBk;
		 this.auteurBk=AuteurBk;
		 this.date_edition=Date_edition;
		 this.prixBx=PrixBk;
		 this.path=path;
		 this.idB=IdB;
		 
		 
	 }
	 
	 
	 public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getIdBk() {
		return idBk;
	}

	public void setIdBk(int idBk) {
		this.idBk = idBk;
	}

	
     
	 public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	


	public int getIdB() {
		return idB;
	}

	public void setIdB(int idB) {
		this.idB = idB;
	}

	public String getNomBk() {
		return nomBk;
	}

	public void setNomBk(String nomBk) {
		this.nomBk = nomBk;
	}

	public String getAuteurBk() {
		return auteurBk;
	}

	public void setAuteurBk(String auteurBk) {
		this.auteurBk = auteurBk;
	}

	public String getDate_edition() {
		return date_edition;
	}

	public void setDate_edition(String date_edition) {
		this.date_edition = date_edition;
	}

	public Double getPrixBx() {
		return prixBx;
	}

	public void setPrixBx(Double prixBx) {
		this.prixBx = prixBx;
	}

	public String getNomB() {
		return nomB;
	}

	public void setNomB(String nomB) {
		this.nomB = nomB;
	}
	
	
}
