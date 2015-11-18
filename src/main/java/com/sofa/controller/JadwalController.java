package com.sofa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sofa.model.stimb2.ListJadwalPerkuliahan;
import com.sofa.service.JadwalService;
import com.sofa.service.KelasService;


@Controller
public class JadwalController 
{
	//programStudiview.jsp
	@Autowired
	private JadwalService jadwalService;
	
	@Autowired
	private KelasService kelasService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/jadwal", "/JADWAL"})
	public String setupForm(Map<String, Object> map)
	{
		ListJadwalPerkuliahan listJadwalPerkuliahan = new ListJadwalPerkuliahan();
		map.put("jadwal", listJadwalPerkuliahan);
		map.put("jadwalList", jadwalService.getAllListJadwalPerkuliahan());
		map.put("kelasList", kelasService.getAllKelasPerkuliahan());
		
		return "jadwalview";
	}
	
	@RequestMapping(value="/updateJadwal", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("jadwalviewEdit");
		//List<ListPrequisiteMatakuliah> listPrequisiteMatakuliah = listPrequisiteService.find(listPrequisiteMatakuliahId);
		map.put("kelasList", kelasService.getAllKelasPerkuliahan());
		mav.addObject("jadwalviewEdit", jadwalService.find(id));
		return mav;
	}
	
	@RequestMapping(value="/updateJadwal", method=RequestMethod.POST)
	public String update(@ModelAttribute("jadwalviewEdit") ListJadwalPerkuliahan listJadwalPerkuliahan, BindingResult result, SessionStatus status)
	{
		jadwalService.edit(listJadwalPerkuliahan);
		status.setComplete();
		return "redirect:jadwal";
	}
	
	
	@RequestMapping(value="/jadwal.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ListJadwalPerkuliahan listJadwalPerkuliahan, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ListJadwalPerkuliahan listJadwalPerkuliahanResult = new ListJadwalPerkuliahan();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					jadwalService.add(listJadwalPerkuliahan);
					status.setComplete();
					listJadwalPerkuliahanResult = listJadwalPerkuliahan;
					model.addAttribute("jadwal",new ListJadwalPerkuliahan());
					break;
				case "tambah":
					jadwalService.add(listJadwalPerkuliahan);
					status.setComplete();
					listJadwalPerkuliahanResult = listJadwalPerkuliahan;
					model.addAttribute("jadwal",new ListJadwalPerkuliahan());
					break;
		}
		return "redirect:jadwal";
	}
	
	
	@RequestMapping("deleteJadwal")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		jadwalService.delete(id);
		return "redirect:jadwal"; 
	}
	
}
