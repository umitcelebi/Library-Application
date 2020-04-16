package com.umitcelebi.servis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.KitapDao;
import com.umitcelebi.model.Kitap;
import com.umitcelebi.servis.KitapServis;

@Service
@Transactional
public class KitapServisImpl implements KitapServis{
	
	@Autowired
	private KitapDao kitapDao;
	
	@Override
	public List<Kitap> kitapListele() {
		
		return kitapDao.kitapListele();
	}

	@Override
	public List<Kitap> kitapAdAra(String kitapAdi) {
		
		return kitapDao.kitapAdAra(kitapAdi);
	}

	@Override
	public List<Kitap> kitapYazarAra(String yazarAdi) {
		
		return kitapDao.kitapYazarAra(yazarAdi);
	}

	@Override
	public Kitap kitapISBNAra(String ISBN) {
		
		return kitapDao.kitapISBNAra(ISBN);
	}

	@Override
	public Kitap kitapAra(int id) {
		
		return kitapDao.kitapAra(id);
	}
	
	@Override
	public List<Kitap> kitapAraByName(String name) {
		
		return kitapDao.kitapAraByName(name);
	}
	
	@Override
	public List<Kitap> kitapSeriAdiAra(String seriAdi) {
		
		return kitapDao.kitapSeriAdiAra(seriAdi);
	}


	@Override
	public Kitap kitapDuzenle(Kitap kitap) {
		
		return kitapDao.kitapDuzenle(kitap);
	}

	@Override
	public String kitapSil(int id) {
		
		return kitapDao.kitapSil(id);
	}


	@Override
	public boolean kitapGir(Kitap kitap) {
		
		return kitapDao.kitapGir(kitap);
	}

	@Override
	public List<Kitap> kitapListelebyBookName() {
		
		return kitapDao.kitapListelebyBookName();
	}

	@Override
	public List<Kitap> orderById() {
		
		return kitapDao.orderById();
	}


	

	

}
