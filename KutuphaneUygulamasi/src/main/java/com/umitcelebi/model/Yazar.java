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
public class Yazar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int yazarId;
	private String yazarAdi;
	private String aciklama;
	
	@OneToMany
	private List<Kitap> kitaplar=new ArrayList<Kitap>();
	//-----------------------------------------
	public int getYazarId() {
		return yazarId;
	}
	public void setYazarId(int yazarId) {
		this.yazarId = yazarId;
	}
	//-----------------------------------------
	public String getYazarAdi() {
		return yazarAdi;
	}
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	//-----------------------------------------
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	//-----------------------------------------
	public List<Kitap> getKitaplar() {
		return kitaplar;
	}
	public void setKitaplar(List<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}
	
}
