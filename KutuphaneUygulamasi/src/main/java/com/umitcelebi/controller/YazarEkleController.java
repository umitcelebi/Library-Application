package com.umitcelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Yazar;
import com.umitcelebi.servis.YazarServis;

@Controller
public class YazarEkleController {
	
	@Autowired
	private YazarServis yazarServis;
	
	@RequestMapping(value = "yazarlar" ,method = RequestMethod.GET)
	public ModelAndView yazarEkle(@ModelAttribute Yazar yazar) {
		
		List<Yazar> yazarlar=yazarServis.yazarListele();
		
		return new ModelAndView("yazarEkle","yazarlar",yazarlar);
	}
	
	@RequestMapping(value = "yazarekle",method = RequestMethod.POST)
	public ModelAndView yazarKaydet(@ModelAttribute Yazar yazar) {
		
		if(yazar.getYazarId()==0) {
			yazarServis.yazarEkle(yazar);
		}else {
			yazarServis.yazarGuncelle(yazar);
		}
		return new ModelAndView("redirect:yazarlar");
	}
	
	@RequestMapping(value = "yazarsil",method = RequestMethod.GET)
	public ModelAndView yazarSil(@ModelAttribute Yazar yazar,@RequestParam int id) {
		
		yazarServis.yazarSil(id);
		
		return new ModelAndView("redirect:yazarlar");
	}
	
	@RequestMapping(value = "yazarlist",method = RequestMethod.GET)
	public ModelAndView yazarList() {
		List<Yazar> yazarlar=yazarServis.yazarListele();
		
		return new ModelAndView("yazarEkle","yazarList",yazarlar);
	}
	
	@RequestMapping(value = "yazarupdate",method =  RequestMethod.GET)
	public ModelAndView yazarGuncelle(@RequestParam int id,@ModelAttribute Yazar yazar) {
		Yazar yazar2=yazarServis.yazarAra(id);
		
		return new ModelAndView("yazarEkle","upYazar",yazar2);
	}
	
	@RequestMapping(value = "yazarbyname",method = RequestMethod.GET)
	public ModelAndView yazarAra(@RequestParam("yazarAdi") String name) {
		
		List<Yazar> yazar=yazarServis.yazarbyName(name);
		
		return new ModelAndView("yazarEkle","yazarList",yazar);
	}
	
	
}
