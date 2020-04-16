package com.umitcelebi.dao;

import java.util.List;

import com.umitcelebi.model.Yayinevi;

public interface YayineviDao {
	String yayineviEkle(Yayinevi yayinevi);
	List<Yayinevi> yayinevleri();
	String yayineviSil(int id);
	Yayinevi yayineviAra(int id);
	boolean yayineviGuncelle(Yayinevi yayinevi);
	List<Yayinevi> yayinevleribyName(String name);
}
