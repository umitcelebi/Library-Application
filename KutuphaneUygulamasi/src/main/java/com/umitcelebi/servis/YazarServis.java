package com.umitcelebi.servis;

import java.util.List;

import com.umitcelebi.model.Yazar;

public interface YazarServis {
	String yazarEkle(Yazar yazar);
	List<Yazar> yazarListele();
	String yazarSil(int id);
	Yazar yazarAra(int id);
	boolean yazarGuncelle(Yazar yazar);
	List<Yazar> yazarbyName(String name);
}
