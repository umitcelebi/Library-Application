package com.umitcelebi.servis;

import java.util.List;

import com.umitcelebi.model.Kitap;

public interface KitapServis {
	List<Kitap>kitapListele();
	List<Kitap>kitapAdAra(String kitapAdi);
	List<Kitap>kitapYazarAra(String yazarAdi);
	Kitap kitapISBNAra(String ISBN);
	Kitap kitapAra(int id);
	List<Kitap> kitapAraByName(String name);
	List<Kitap>kitapSeriAdiAra(String seriAdi);
	
	List<Kitap>kitapListelebyBookName();
	List<Kitap>orderById();
	
	boolean kitapGir(Kitap kitap);
	Kitap kitapDuzenle(Kitap kitap);
	String kitapSil(int id);
}
