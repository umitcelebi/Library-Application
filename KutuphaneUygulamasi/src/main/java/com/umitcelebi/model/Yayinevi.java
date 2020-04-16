package com.umitcelebi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Yayinevi implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int yayineviId;
	private String adi;
	private String aciklama;
	
	@OneToMany
	private List<Kitap>kitaplar=new ArrayList<Kitap>();
	//------------------------------------
	public int getYayineviId() {
		return yayineviId;
	}
	public void setYayineviId(int yayineviId) {
		this.yayineviId = yayineviId;
	}
	//------------------------------------
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	//------------------------------------
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	//------------------------------------
	public List<Kitap> getKitaplar() {
		return kitaplar;
	}
	public void setKitaplar(List<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}
	
}
