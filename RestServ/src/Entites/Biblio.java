package Entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Biblio {

	private int idb;
	private String nomB;

	public Biblio() {
	}

	public Biblio(int Idb, String NomB) {

		this.idb = Idb;
		this.nomB = NomB;
	}

	public int getIdb() {
		return idb;
	}

	public void setIdb(int idb) {
		this.idb = idb;
	}

	public String getNomB() {
		return nomB;
	}

	public void setNomB(String nomB) {
		this.nomB = nomB;
	}

}
