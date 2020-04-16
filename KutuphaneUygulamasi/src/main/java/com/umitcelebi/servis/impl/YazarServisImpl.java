package com.umitcelebi.servis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.YazarDao;
import com.umitcelebi.model.Yazar;
import com.umitcelebi.servis.YazarServis;

@Service
@Transactional
public class YazarServisImpl implements YazarServis{
	
	@Autowired
	private YazarDao yazarDao;
	
	@Override
	public String yazarEkle(Yazar yazar) {
		
		return yazarDao.yazarEkle(yazar);
	}

	@Override
	public List<Yazar> yazarListele() {
		
		return yazarDao.yazarListele();
	}

	@Override
	public String yazarSil(int id) {
		
		return yazarDao.yazarSil(id);
	}

	@Override
	public Yazar yazarAra(int id) {
		
		return yazarDao.yazarAra(id);
	}

	@Override
	public boolean yazarGuncelle(Yazar yazar) {
		
		return yazarDao.yazarGuncelle(yazar);
	}

	@Override
	public List<Yazar> yazarbyName(String name) {
		
		return yazarDao.yazarbyName(name);
	}

}
