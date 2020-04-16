package com.umitcelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Kitap;
import com.umitcelebi.model.Yayinevi;
import com.umitcelebi.model.Yazar;
import com.umitcelebi.servis.KitapServis;
import com.umitcelebi.servis.YayineviServis;
import com.umitcelebi.servis.YazarServis;

@Controller
public class KitapEkleController {

	@Autowired
	private YazarServis yazarServis;
	
	@Autowired
	private YayineviServis yayineviServis;
	
	@Autowired
	private KitapServis kitapServis;
	
	@RequestMapping(value = "kitapekle", method = RequestMethod.GET)
	public ModelAndView ekle(@ModelAttribute Kitap kitap,@ModelAttribute Yazar yazar,@ModelAttribute Yayinevi yayinevi) {
		
		ModelAndView modelAndView=new ModelAndView("kitapEkle");
		
		List<Yazar> yazarlar=yazarServis.yazarListele();
		
		List<Yayinevi> yayinevleri=yayineviServis.yayinevleri();
		
		modelAndView.addObject("yazarlar", yazarlar);
		modelAndView.addObject("yayinevleri", yayinevleri);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "kaydet",method = RequestMethod.POST)
	public ModelAndView kitapEkle(@ModelAttribute Kitap kitap) {
		
		if(kitap.getKitapId()==0) {
			kitapServis.kitapGir(kitap);
		}else {
			kitapServis.kitapDuzenle(kitap);
		}
		
		return new ModelAndView("redirect:kitaplar");
	}
	
	
}
