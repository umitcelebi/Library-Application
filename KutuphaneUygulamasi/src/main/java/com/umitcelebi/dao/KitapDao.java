package com.umitcelebi.dao;

import java.util.List;

import com.umitcelebi.model.Kitap;

public interface KitapDao {
	
	List<Kitap>kitapListele();
	List<Kitap>kitapAdAra(String kitapAdi);
	List<Kitap>kitapYazarAra(String yazarAdi);
	Kitap kitapISBNAra(String ISBN);
	Kitap kitapAra(int id);
	List<Kitap> kitapAraByName(String name);
	List<Kitap>kitapSeriAdiAra(String seriAdi);
	
	List<Kitap>kitapListelebyBookName();
	List<Kitap>orderById();
	
	//boolean kitapGir(Kitap kitap,int yazarID,int yayineviID);
	//String kitapEkle(Kitap kitap,Yazar yazar,Yayinevi yayinevi);
	boolean kitapGir(Kitap kitap);
	Kitap kitapDuzenle(Kitap kitap);
	String kitapSil(int id);
}
