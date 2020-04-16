package com.umitcelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Kitap;
import com.umitcelebi.model.Yayinevi;
import com.umitcelebi.model.Yazar;
import com.umitcelebi.servis.KitapServis;
import com.umitcelebi.servis.YayineviServis;
import com.umitcelebi.servis.YazarServis;

@Controller
public class AnasayfaController {
	
	@Autowired
	private KitapServis kitapServis;
	
	@Autowired
	private YazarServis yazarServis;
	
	@Autowired
	private YayineviServis yayineviServis;
	
	@RequestMapping(value = "kitaplar",method = RequestMethod.GET)
	public ModelAndView kitaplar(@ModelAttribute Kitap kitap) {
		List<Kitap> kitap2=kitapServis.kitapListele();

		return new ModelAndView("anasayfa","kitaplar",kitap2);
	}
	
	
	@RequestMapping(value = "kitapbyId", method =  RequestMethod.GET)
	public ModelAndView kitapbyId(@RequestParam String ISBN) {
		Kitap kitap=kitapServis.kitapISBNAra(ISBN);
		
		return new ModelAndView("anasayfa","kitapbyId",kitap);
	}
	
	@RequestMapping(value = "deletebook")
	public ModelAndView deletebookById(@RequestParam int id) {
		
		kitapServis.kitapSil(id);
		
		return new ModelAndView("redirect:kitaplar");
	}
	
	@RequestMapping(value = "bykitapadi",method = RequestMethod.GET)
	public ModelAndView kitaplarOrderBy() {
		
		List<Kitap> kitap=kitapServis.kitapListelebyBookName();

		return new ModelAndView("anasayfa","kitaplar",kitap);
	}
	@RequestMapping(value = "searchbyname",method = RequestMethod.GET)
	public ModelAndView kitapArabyName(@RequestParam String kitapAdi,@ModelAttribute Kitap kitap) {
		
		List<Kitap> kitap2=kitapServis.kitapAraByName(kitapAdi);

		return new ModelAndView("anasayfa","kitaplar",kitap2);
	}
	@RequestMapping(value = "orderbyid",method = RequestMethod.GET)
	public ModelAndView kitaplarOrderId() {
		
		List<Kitap> kitap=kitapServis.orderById();

		return new ModelAndView("anasayfa","kitaplar",kitap);
	}
	
	@RequestMapping(value = "kitapduzenle",method = RequestMethod.GET)
	public ModelAndView kitapDuzenle(@RequestParam int id,@ModelAttribute Kitap kitap) {
		Kitap kitap2=kitapServis.kitapAra(id);
		
		ModelAndView modelAndView=new ModelAndView("kitapEkle");
		
		List<Yazar> yazarlar=yazarServis.yazarListele();
		
		List<Yayinevi> yayinevleri=yayineviServis.yayinevleri();
		
		modelAndView.addObject("yazarlar", yazarlar);
		modelAndView.addObject("yayinevleri", yayinevleri);
		modelAndView.addObject("upKitap",kitap2);
		return modelAndView;
	}
}
