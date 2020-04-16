package com.umitcelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Yayinevi;
import com.umitcelebi.servis.YayineviServis;

@Controller
public class YayineviEkleController {
	
	@Autowired
	private YayineviServis yayineviServis;
	
	@RequestMapping(value = "yayinevleri" ,method = RequestMethod.GET)
	public ModelAndView yayineviEkle(@ModelAttribute Yayinevi yayinevi) {
		
		List<Yayinevi> yayineviList=yayineviServis.yayinevleri();
		
		return new ModelAndView("yayineviEkle","yayineviList",yayineviList);
	}
	
	@RequestMapping(value = "yayineviekle",method = RequestMethod.POST)
	public ModelAndView yazarKaydet(@ModelAttribute Yayinevi yayinevi) {
		
		if(yayinevi.getYayineviId()==0) {
			yayineviServis.yayineviEkle(yayinevi);
		}else {
			yayineviServis.yayineviGuncelle(yayinevi);
		}
		return new ModelAndView("redirect:yayinevleri");
	}
	
	@RequestMapping(value = "yayinevisil",method = RequestMethod.GET)
	public ModelAndView yayineviSil(@RequestParam int id) {
		
		yayineviServis.yayineviSil(id);
		
		return new ModelAndView("redirect:yayinevleri");
	}
	
	@RequestMapping(value = "yayinevilist",method = RequestMethod.GET)
	public ModelAndView yayineviList() {
		List<Yayinevi> yayineviList=yayineviServis.yayinevleri();
		
		return new ModelAndView("yayineviEkle","yayineviList",yayineviList);
	}
	
	@RequestMapping(value = "yayineviupdate",method =  RequestMethod.GET)
	public ModelAndView yazarGuncelle(@RequestParam int id,@ModelAttribute Yayinevi yayinevi) {
		
		Yayinevi yayinevi2=yayineviServis.yayineviAra(id);
		
		return new ModelAndView("yayineviEkle","upYayinevi",yayinevi2);
	}
	
	@RequestMapping(value = "yayinevibyname",method = RequestMethod.GET)
	public ModelAndView yayineviAra(@RequestParam("yayineviAdi") String name) {
		
		List<Yayinevi> yayinevi=yayineviServis.yayinevleribyName(name);
		
		return new ModelAndView("yayineviEkle","yayineviList",yayinevi);
	}
}
