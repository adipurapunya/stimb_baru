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
import com.sofa.model.stimb2.ReffInstrumentMayor;
import com.sofa.service.ReffInstrumentMayorService;


@Controller
public class ReffInstrumentMayorController 
{
	//programStudiview.jsp
	@Autowired
	private ReffInstrumentMayorService reffMayorService;
	
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
		ReffInstrumentMayor mayor = new ReffInstrumentMayor();
		map.put("instrumentmayor", mayor);
		map.put("instrumentmayorList", reffMayorService.getAllReffMayor());
		return "instrumentmayorview";
	}
	
	@RequestMapping(value="/updateMayor", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("instrumentmayorviewEdit");
		ReffInstrumentMayor mayor = reffMayorService.getReffMayor(id);
		mav.addObject("instrumentmayorviewEdit", mayor);
		return mav;
	}
	
	@RequestMapping(value="/updateMayor", method=RequestMethod.POST)
	public String update(@ModelAttribute("instrumentmayorviewEdit") ReffInstrumentMayor mayor, BindingResult result, SessionStatus status)
	{
		reffMayorService.edit(mayor);
		status.setComplete();
		return "redirect:mayor";
	}
	
	@RequestMapping(value="/mayor.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ReffInstrumentMayor mayor, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ReffInstrumentMayor mayorResult = new ReffInstrumentMayor();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					reffMayorService.add(mayor);
					status.setComplete();
					mayorResult = mayor;
					model.addAttribute("instrumentmayor",new ReffInstrumentMayor());
					break;
				case "tambah":
					reffMayorService.add(mayor);
					status.setComplete();
					mayorResult = mayor;
					model.addAttribute("instrumentmayor",new ReffInstrumentMayor());
					break;
				case "edit":
					reffMayorService.edit(mayor);
					mayorResult = mayor;
					model.addAttribute("instrumentmayor",new ReffInstrumentMayor());
					break;
				case "delete":
					reffMayorService.delete(Integer.parseInt(String.valueOf(mayor.getId())));
					mayorResult = new ReffInstrumentMayor();
					break;
				case "search":
					ReffInstrumentMayor searchedReffMayor = reffMayorService.getReffMayor(Integer.parseInt(String.valueOf(mayor.getId())));
					mayorResult = searchedReffMayor!=null ? searchedReffMayor: new ReffInstrumentMayor();
					break;
				case "back":
					model.addAttribute("instrumentmayor",new ReffInstrumentMayor());
					break;
		}
		map.put("instrumentmayorview", mayorResult);
		map.put("instrumentmayorList", reffMayorService.getAllReffMayor());
		return "instrumentmayorview";
	}
	
	
	@RequestMapping("deleteMayor")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ReffInstrumentMayor mayorResult = new ReffInstrumentMayor();
		reffMayorService.delete(id);
		mayorResult = new ReffInstrumentMayor();
		map.put("instrumentmayorview", mayorResult);
		map.put("instrumentmayorList", reffMayorService.getAllReffMayor());
		return "redirect:mayor"; 
	}
}
