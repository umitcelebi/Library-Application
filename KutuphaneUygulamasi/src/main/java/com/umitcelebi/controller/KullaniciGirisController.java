package com.umitcelebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Kullanici;
import com.umitcelebi.servis.KullaniciServis;

@Controller
public class KullaniciGirisController {
	
	@Autowired
	private KullaniciServis kullaniciServis;
	
	
	@RequestMapping(value = "/ekle",method = RequestMethod.GET)
	public ModelAndView ekle(@ModelAttribute Kullanici kullanici) {
		
		return new ModelAndView("kayitEkle");
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView giris(@ModelAttribute Kullanici kullanici) {
		
		return new ModelAndView("kullaniciGirisi");
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView saveKullanici(@ModelAttribute Kullanici kullanici) {
		
		if(kullaniciServis.kullaniciEkle(kullanici)) {
			kullaniciServis.kullaniciEkle(kullanici);
			return new ModelAndView("kullaniciGirisi");
		}
		return new ModelAndView("kayitEkle");
	}
	
	@RequestMapping(value = "/giris")
	public ModelAndView kulaniciGiris(@ModelAttribute Kullanici kullanici) {
		
		kullanici=kullaniciServis.girisYap(kullanici.getKulAdi(), kullanici.getParola());
		
		if(kullanici==null) {
			return new ModelAndView("kullaniciGirisi");
		}
		return new ModelAndView("redirect:kitaplar");
	}
	
}
