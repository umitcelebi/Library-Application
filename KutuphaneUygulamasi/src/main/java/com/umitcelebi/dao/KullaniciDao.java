package com.umitcelebi.dao;

import com.umitcelebi.model.Kullanici;

public interface KullaniciDao {
	boolean kullaniciEkle(Kullanici kullanici);
	Kullanici girisYap(String kulAdi,String parola);
	Kullanici findbyUsername(String kullaniciAdi);
}
