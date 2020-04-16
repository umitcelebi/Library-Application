package com.umitcelebi.servis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.KullaniciDao;
import com.umitcelebi.model.Kullanici;
import com.umitcelebi.servis.KullaniciServis;

@Service
@Transactional(rollbackFor =Exception.class)
public class KullaniciServisImpl implements KullaniciServis{
	
	@Autowired
	private KullaniciDao kullaniciDao;
	
	@Override
	public boolean kullaniciEkle(Kullanici kullanici) {
		
		return kullaniciDao.kullaniciEkle(kullanici);
	}

	@Override
	public Kullanici girisYap(String kulAdi, String parola) {
		
		return kullaniciDao.girisYap(kulAdi, parola);
	}

}
