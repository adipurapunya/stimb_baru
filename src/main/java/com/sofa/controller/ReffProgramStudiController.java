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
import com.sofa.model.stimb2.ReffProgramStudi;
import com.sofa.service.ReffProgramStudiService;


@Controller
public class ReffProgramStudiController 
{
	//programStudiview.jsp
	@Autowired
	private ReffProgramStudiService reffProgramStudiService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/prodi", "/jenjang"})
	public String setupForm(Map<String, Object> map)
	{
		ReffProgramStudi prodi = new ReffProgramStudi();
		map.put("prodi", prodi);
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		return "prodiview";
	}
	
	@RequestMapping(value="/updateProdi", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("prodiviewEdit");
		ReffProgramStudi prodi = reffProgramStudiService.getReffProgramStudi(id);
		mav.addObject("prodiviewEdit", prodi);
		return mav;
	}
	
	@RequestMapping(value="/updateProdi", method=RequestMethod.POST)
	public String update(@ModelAttribute("prodiviewEdit") ReffProgramStudi prodi, BindingResult result, SessionStatus status)
	{
		reffProgramStudiService.edit(prodi);
		status.setComplete();
		return "redirect:prodi";
	}
	
	@RequestMapping(value="/prodi.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ReffProgramStudi prodi, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ReffProgramStudi prodiResult = new ReffProgramStudi();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					reffProgramStudiService.add(prodi);
					status.setComplete();
					prodiResult = prodi;
					model.addAttribute("prodi",new ReffProgramStudi());
					break;
				case "tambah":
					reffProgramStudiService.add(prodi);
					status.setComplete();
					prodiResult = prodi;
					model.addAttribute("prodi",new ReffProgramStudi());
					break;
				case "edit":
					reffProgramStudiService.edit(prodi);
					prodiResult = prodi;
					model.addAttribute("prodi",new ReffProgramStudi());
					break;
				case "delete":
					reffProgramStudiService.delete(Integer.parseInt(String.valueOf(prodi.getId())));
					prodiResult = new ReffProgramStudi();
					break;
				case "search":
					ReffProgramStudi searchedReffProgramStudi = reffProgramStudiService.getReffProgramStudi(Integer.parseInt(String.valueOf(prodi.getId())));
					prodiResult = searchedReffProgramStudi!=null ? searchedReffProgramStudi: new ReffProgramStudi();
					break;
				case "back":
					model.addAttribute("prodi",new ReffProgramStudi());
					break;
		}
		map.put("prodiview", prodiResult);
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		return "prodiview";
	}
	
	
	@RequestMapping("deleteProdi")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ReffProgramStudi prodiResult = new ReffProgramStudi();
		reffProgramStudiService.delete(id);
		prodiResult = new ReffProgramStudi();
		map.put("prodiview", prodiResult);
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		return "redirect:prodi"; 
	}
}
