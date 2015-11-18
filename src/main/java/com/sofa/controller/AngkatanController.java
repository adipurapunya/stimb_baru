package com.sofa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.sofa.model.stimb2.Angkatan;
import com.sofa.model.stimb2.MasterDosen;
import com.sofa.service.AngkatanService;
import com.sofa.service.MasterDosenService;


@Controller
public class AngkatanController 
{
	//programStudiview.jsp
	@Autowired
	private AngkatanService angkatanService;
	
	@Autowired
	private MasterDosenService MasterDosenService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/angkatan", "/angk"})
	public String setupForm(Map<String, Object> map)
	{
		Angkatan angkatan = new Angkatan();
		map.put("angkatan", angkatan);
		map.put("angkatanList", angkatanService.getAllAngkatan());
		map.put("dosenList", MasterDosenService.getAllMasterDosen());
		return "angkatanview";
	}
	
	@RequestMapping(value="/updateAngkatan", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("angkatanviewEdit");
		Angkatan angkatan = angkatanService.getAngkatan(id);
		mav.addObject("angkatanviewEdit", angkatan);
		map.put("dosenList", MasterDosenService.getAllMasterDosen());
		return mav;
	}
	
	@RequestMapping(value="/updateAngkatan", method=RequestMethod.POST)
	public String update(@ModelAttribute("angkatanviewEdit") Angkatan angkatan, BindingResult result, SessionStatus status)
	{
		angkatanService.edit(angkatan);
		status.setComplete();
		return "redirect:angkatan";
	}
	
	@RequestMapping(value="/angkatan.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Angkatan angkatan, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		Angkatan angkatanResult = new Angkatan();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					angkatanService.add(angkatan);
					//System.out.println(angkatan.getNama()+" "+angkatan.getTahun());
					status.setComplete();
					angkatanResult = angkatan;
					model.addAttribute("angkatann",new Angkatan());
					break;
				case "tambah":
					angkatanService.add(angkatan);
					status.setComplete();
					angkatanResult = angkatan;
					model.addAttribute("angkatan",new Angkatan());
					break;
				case "edit":
					angkatanService.edit(angkatan);
					angkatanResult = angkatan;
					model.addAttribute("angkatan",new Angkatan());
					break;
				case "delete":
					angkatanService.delete(Integer.parseInt(String.valueOf(angkatan.getId())));
					angkatanResult = new Angkatan();
					break;
				case "search":
					Angkatan searchedAngkatan = angkatanService.getAngkatan(Integer.parseInt(String.valueOf(angkatan.getId())));
					angkatanResult = searchedAngkatan!=null ? searchedAngkatan: new Angkatan();
					break;
				case "back":
					model.addAttribute("angkatan",new Angkatan());
					break;
		}
		//map.put("angkatan", angkatanResult);
		//map.put("dosenList", MasterDosenService.getAllMasterDosen());
		return "redirect:angkatan";
	}
	
	
	@RequestMapping("deleteAngkatan")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		angkatanService.delete(id);
		return "redirect:angkatan"; 
	}
	
}
