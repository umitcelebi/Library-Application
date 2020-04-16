package com.umitcelebi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.YazarDao;
import com.umitcelebi.model.Yazar;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class YazarDaoImpl implements YazarDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String yazarEkle(Yazar yazar) {
		
		try {
			getSession().save(yazar);			
			return "yazarEklemeBasarili";
		} catch (Exception e) {
			System.out.println("YAZAR EKELNÝRKEN HATA OLUÞTU... "+e);
			return "yazarEklemeBasarisiz";
		}
	}

	@Override
	public List<Yazar> yazarListele() {
		
		try {
			Query<Yazar>query=getSession().createQuery("from Yazar");
			List<Yazar>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("YAZARLAR LÝSTELENÝRKEN HATA OLUÞTU... "+e);
			return null;
		}
	}

	@Override
	public Yazar yazarAra(int id) {
		
		try {
			Query<Yazar>query=getSession().createQuery("from Yazar where yazarId=:id");
			query.setParameter("id", id);
			Yazar yazar=query.getSingleResult();
			
			return yazar;
		} catch (Exception e) {
			System.out.println("YAZAR ARARKEN HATA OLUÞTU... "+e);
			return null;
		}
	}
	@Override
	public String yazarSil(int id) {
		
		try {
			Query<Yazar>query=getSession().createQuery("DELETE Yazar where yazarId=:id");
			query.setParameter("id", id);
			int durum=query.executeUpdate();
			
			if(durum==1) {
				return "yazarSilindi";
			}else {
				return "yazarSilinmedi";
			}
		} catch (Exception e) {
			System.out.println("YAZAR SÝLÝNÝRKEN HATA OLUÞTU... "+e);
			return "yazarSilinmedi";
		}
	}

	@Override
	public boolean yazarGuncelle(Yazar yazar) {
		
		try {
			getSession().update(yazar);
			return true;
		} catch (Exception e) {
			System.out.println("YAZAR GÜNCELLERKEN HATA OLUÞTU..."+e);
			return false;
		}
	}

	@Override
	public List<Yazar> yazarbyName(String name) {
		try {
			Query<Yazar>query=getSession().createQuery("from Yazar where yazarAdi=:ad");
			query.setParameter("ad", name);
			List<Yazar> yazarlar=query.getResultList();
			
			return yazarlar;
		} catch (Exception e) {
			System.out.println("YAZAR ARARKEN HATA OLUÞTU... "+e);
			return null;
		}
	}

}
