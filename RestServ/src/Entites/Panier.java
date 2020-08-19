package Entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Panier {

	private int idc;
	private int idb;
	private int qnt;
	
	public Panier() {}
	
	public Panier(int idc, int idb, int qnt) {
		super();
		this.idc = idc;
		this.idb = idb;
		this.qnt = qnt;
	}
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public int getIdb() {
		return idb;
	}
	public void setIdb(int idb) {
		this.idb = idb;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	
}
