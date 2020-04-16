package com.umitcelebi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.KitapDao;
import com.umitcelebi.model.Kitap;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class KitapDaoImpl  implements KitapDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Kitap> kitapListele() {
		
		try {
			Query<Kitap>query=getSession().createQuery("from Kitap");
			List<Kitap>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}
	}


	@Override
	public List<Kitap> kitapAdAra(String kitapAdi) {
		
		try {
			getSession().beginTransaction();
			Query<Kitap>query=getSession().createQuery("SELECT k FROM Kitap k WHERE k.kitapAdi LIKE '%:kitapAd%'");
			query.setParameter("kitapAd",kitapAdi);
			List<Kitap>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}finally {
			getSession().close();
		}
	}

	@Override
	public List<Kitap> kitapYazarAra(String yazarAdi) {
		try {
			getSession().beginTransaction();
			Query<Kitap> query=getSession().createQuery("SELECT kitapId,kitapAdi,kitapAltAdi,seriAdi,isbnNo,acikama FROM Kitap k left JOIN Yazar y on k.yazarId=y.yazarId where y.yazarAdi=:yazarAdi");
			query.setParameter("yazarAdi", yazarAdi);
			List<Kitap>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}finally {
			getSession().close();
		}
	}

	@Override
	public Kitap kitapISBNAra(String ISBN) {
		
		try {
			Query<Kitap> query=getSession().createQuery("FROM Kitap where isbnNo like :isbn");
			query.setParameter("isbn", ISBN);
			Kitap kitap=query.getSingleResult();
			
			return kitap;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}
	}

	@Override
	public Kitap kitapAra(int id) {
		try {
			Query<Kitap> query=getSession().createQuery("FROM Kitap where kitapId=:id");
			query.setParameter("id", id);
			Kitap kitap=query.getSingleResult();
			
			return kitap;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}
	}

	@Override
	public List<Kitap> kitapAraByName(String name) {
		try {
			Query<Kitap>query=getSession().createQuery("from Kitap k WHERE k.kitapAdi LIKE :kitapAd");
			query.setParameter("kitapAd","%"+ name+"%");
			List<Kitap>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}
	}
	
	@Override
	public List<Kitap> kitapSeriAdiAra(String seriAdi) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Kitap kitapDuzenle(Kitap kitap) {
		try {
			getSession().update(kitap);
			return kitap;
		} catch (Exception e) {
			System.out.println("Güncllenirken Hata Olustu..."+e);
			return null;
		}
	}

	@Override
	public String kitapSil(int id) {
		
		try {
			Query<Kitap>query=getSession().createQuery("delete from Kitap where id=:kitapId");
			query.setParameter("kitapId", id);
			int durum=query.executeUpdate();
			if(durum==1) {
				return "silmeBasarili";
			}else {
				return "silmeBasarisiz";
			}
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return "silmeBasarisiz";
		}
	}


	@Override
	public boolean kitapGir(Kitap kitap) {
		try {
			getSession().save(kitap);
			return true;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return false;
		}
	}

	@Override
	public List<Kitap> kitapListelebyBookName() {
		try {
			Query<Kitap>query=getSession().createQuery("from Kitap order by kitapAdi ASC");
			List<Kitap>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}
	}

	@Override
	public List<Kitap> orderById() {
		try {
			Query<Kitap>query=getSession().createQuery("from Kitap order by kitapId ASC");
			List<Kitap>list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			System.out.println("HATA: "+e);
			return null;
		}
	}

	

	
	
}
