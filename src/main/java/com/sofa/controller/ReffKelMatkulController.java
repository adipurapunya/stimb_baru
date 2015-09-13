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
import com.sofa.model.kurikulum.ReffMayor;
import com.sofa.service.ReffMayorService;


@Controller
public class ReffKelMatkulController 
{
	//programStudiview.jsp
	@Autowired
	private ReffMayorService reffMayorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/mayor", "/major"})
	public String setupForm(Map<String, Object> map)
	{
		ReffMayor mayor = new ReffMayor();
		map.put("mayor", mayor);
		map.put("mayorList", reffMayorService.getAllReffMayor());
		return "mayorview";
	}
	
	@RequestMapping(value="/updateMayor", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("mayorviewEdit");
		ReffMayor mayor = reffMayorService.getReffMayor(id);
		mav.addObject("mayorviewEdit", mayor);
		return mav;
	}
	
	@RequestMapping(value="/updateMayor", method=RequestMethod.POST)
	public String update(@ModelAttribute("prodiviewEdit") ReffMayor mayor, BindingResult result, SessionStatus status)
	{
		reffMayorService.edit(mayor);
		status.setComplete();
		return "redirect:mayor";
	}
	
	@RequestMapping(value="/mayor.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ReffMayor mayor, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ReffMayor mayorResult = new ReffMayor();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					reffMayorService.add(mayor);
					status.setComplete();
					mayorResult = mayor;
					model.addAttribute("mayor",new ReffMayor());
					break;
				case "tambah":
					reffMayorService.add(mayor);
					status.setComplete();
					mayorResult = mayor;
					model.addAttribute("mayor",new ReffMayor());
					break;
				case "edit":
					reffMayorService.edit(mayor);
					mayorResult = mayor;
					model.addAttribute("mayor",new ReffMayor());
					break;
				case "delete":
					reffMayorService.delete(Integer.parseInt(String.valueOf(mayor.getId())));
					mayorResult = new ReffMayor();
					break;
				case "search":
					ReffMayor searchedReffMayor = reffMayorService.getReffMayor(Integer.parseInt(String.valueOf(mayor.getId())));
					mayorResult = searchedReffMayor!=null ? searchedReffMayor: new ReffMayor();
					break;
				case "back":
					model.addAttribute("mayor",new ReffMayor());
					break;
		}
		map.put("mayorview", mayorResult);
		map.put("mayorList", reffMayorService.getAllReffMayor());
		return "mayorview";
	}
	
	
	@RequestMapping("deleteMayor")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ReffMayor mayorResult = new ReffMayor();
		reffMayorService.delete(id);
		mayorResult = new ReffMayor();
		map.put("mayorview", mayorResult);
		map.put("mayorList", reffMayorService.getAllReffMayor());
		return "redirect:mayor"; 
	}
}
