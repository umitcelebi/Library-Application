package com.umitcelebi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Kitap implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kitapId;
	private String kitapAdi;
	private String kitapAltAdi;
	private String seriAdi;
	private String isbnNo;
	private String acikama;
	
	@ManyToOne
	@JoinColumn(name = "yazarId", updatable = true)
	private Yazar yazar;
	
	@ManyToOne
	@JoinColumn(name = "yayineviId", updatable = true)
	private Yayinevi yayinevi;
	
	//------------------------------------------

	public Yazar getYazar() {
		return yazar;
	}
	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}
	public Yayinevi getYayinevi() {
		return yayinevi;
	}
	public void setYayinevi(Yayinevi yayinevi) {
		this.yayinevi = yayinevi;
	}
	//------------------------------------------
	public int getKitapId() {
		return kitapId;
	}
	public void setKitapId(int kitapId) {
		this.kitapId = kitapId;
	}
	public String getKitapAdi() {
		return kitapAdi;
	}
	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}
	//------------------------------------------
	public String getKitapAltAdi() {
		return kitapAltAdi;
	}
	public void setKitapAltAdi(String kitapAltAdi) {
		this.kitapAltAdi = kitapAltAdi;
	}
	//------------------------------------------
	public String getSeriAdi() {
		return seriAdi;
	}
	public void setSeriAdi(String seriAdi) {
		this.seriAdi = seriAdi;
	}
	//------------------------------------------
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	//------------------------------------------
	public String getAcikama() {
		return acikama;
	}
	public void setAcikama(String acikama) {
		this.acikama = acikama;
	}
	//------------------------------------------
	
}
