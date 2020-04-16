package com.umitcelebi.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.KullaniciDao;
import com.umitcelebi.model.Kullanici;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class KullaniciDaoImpl implements KullaniciDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean kullaniciEkle(Kullanici kullanici) {
		
		try {
			Kullanici kullanici2=findbyUsername(kullanici.getKulAdi());
			if(kullanici2==null) {
				getSession().save(kullanici);
				return true;
			}
			return false;
		} catch (Exception e) {
			
			System.out.println("HATA OLUÞTU..."+e);
			return false;
		}
	}

	
	@Override
	public Kullanici girisYap(String kulAdi, String parola) {
		try {
			Query<Kullanici>query=getSession().createQuery("from Kullanici where kulAdi=:kuladi and parola=:parola");
			query.setParameter("kuladi", kulAdi);
			query.setParameter("parola", parola);
			Kullanici kullanici=query.getSingleResult();
			if(kullanici==null) {
				return null;
			}else {
				return kullanici;
			}
		} catch (Exception e) {
			System.out.println("GÝRÝÞ YAPILIRKEN HATA OLUÞTU."+e);
			return null;
		}
	}

	@Override
	public Kullanici findbyUsername(String kullaniciAdi) {
		try {
			Query<Kullanici>query=getSession().createQuery("from Kullanici where kulAdi=:kullaniciAdi");
			query.setParameter("kullaniciAdi", kullaniciAdi);
			Kullanici kullanici=query.getSingleResult();
			if(kullanici==null) {
				return null;
			}else {
				return kullanici;
			}
		} catch (Exception e) {
			System.out.println("GÝRÝÞ YAPILIRKEN HATA OLUÞTU."+e);
			return null;
		}
	}

}
