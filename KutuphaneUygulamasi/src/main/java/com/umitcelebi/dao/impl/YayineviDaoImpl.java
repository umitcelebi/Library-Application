package com.umitcelebi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.YayineviDao;
import com.umitcelebi.model.Yayinevi;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class YayineviDaoImpl implements YayineviDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String yayineviEkle(Yayinevi yayinevi) {
		try {
			getSession().save(yayinevi);
			
			return "yayineviKaydiBasarili";
		} catch (Exception e) {
			System.out.println("HATA OLUÞTU... "+e);
			return "yayineviKaydiBasarisiz";
		}
	}

	@Override
	public List<Yayinevi> yayinevleri() {
		try {
			Query<Yayinevi>query=getSession().createQuery("from Yayinevi");
			List<Yayinevi> list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA OLUÞTU... "+e);
			return null;
		}
	}

	@Override
	public String yayineviSil(int id) {
		try {
			Query<Yayinevi> query=getSession().createQuery("DELETE Yayinevi where yayineviId=:id");
			query.setParameter("id", id);
			int durum=query.executeUpdate();
			
			if(durum==1) {
				return "silmeBasarili";
			}else {
				return "silmeBasarisiz";
			}
		} catch (Exception e) {
			System.out.println("HATA OLUÞTU... "+e);
			return "yayineviKaydiBasarisiz";
		}
	}

	@Override
	public Yayinevi yayineviAra(int id) {
		try {
			
			Query<Yayinevi> query=getSession().createQuery("from Yayinevi where yayineviId=:id");
			query.setParameter("id", id);
			Yayinevi yayinevi=query.getSingleResult();
			
			return yayinevi;
		} catch (Exception e) {
			System.out.println("YAYINEVÝ ARARKEN HATA OLUÞTU... "+e);
			return null;
		}
	}

	@Override
	public boolean yayineviGuncelle(Yayinevi yayinevi) {
		try {
			getSession().update(yayinevi);
			return true;
		} catch (Exception e) {
			System.out.println("YAYINEVÝ GUNCELLENIRKEN HATA OLUSTU..."+e);
			
			return false;
		}
	}

	@Override
	public List<Yayinevi> yayinevleribyName(String name) {
		try {
			
			Query<Yayinevi> query=getSession().createQuery("from Yayinevi where adi=:adi");
			query.setParameter("adi", name);
			List<Yayinevi> yayinevi=query.getResultList();
			
			return yayinevi;
		} catch (Exception e) {
			System.out.println("YAYINEVÝ ARARKEN HATA OLUÞTU... "+e);
			return null;
		}
	}

}
