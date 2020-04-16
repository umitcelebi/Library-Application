package com.umitcelebi.servis;

import com.umitcelebi.model.Kullanici;

public interface KullaniciServis {
	boolean kullaniciEkle(Kullanici kullanici);
	Kullanici girisYap(String kulAdi,String parola);
}
