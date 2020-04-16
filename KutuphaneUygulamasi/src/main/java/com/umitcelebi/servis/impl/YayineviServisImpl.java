package com.umitcelebi.servis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.YayineviDao;
import com.umitcelebi.model.Yayinevi;
import com.umitcelebi.servis.YayineviServis;

@Service
@Transactional
public class YayineviServisImpl implements YayineviServis{
	
	@Autowired
	private YayineviDao yayineviDao;
	
	@Override
	public String yayineviEkle(Yayinevi yayinevi) {

		return yayineviDao.yayineviEkle(yayinevi);
	}

	@Override
	public List<Yayinevi> yayinevleri() {

		return yayineviDao.yayinevleri();
	}

	@Override
	public String yayineviSil(int id) {
		
		return yayineviDao.yayineviSil(id);
	}

	@Override
	public Yayinevi yayineviAra(int id) {
		
		return yayineviDao.yayineviAra(id);
	}

	@Override
	public boolean yayineviGuncelle(Yayinevi yayinevi) {
		
		return yayineviDao.yayineviGuncelle(yayinevi);
	}

	@Override
	public List<Yayinevi> yayinevleribyName(String name) {
		
		return yayineviDao.yayinevleribyName(name);
	}

}
