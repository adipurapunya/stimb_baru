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

import com.sofa.model.stimb2.ListPrequisiteMatakuliah;
import com.sofa.service.ListPrequisiteService;
import com.sofa.service.MasterMatkulService;


@Controller
public class PrequisiteController 
{
	//programStudiview.jsp
	@Autowired
	private ListPrequisiteService listPrequisiteService;
	
	@Autowired
	private MasterMatkulService MasterMatkulService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/prequisite", "/prequisit"})
	public String setupForm(Map<String, Object> map)
	{
		ListPrequisiteMatakuliah listPrequisiteMatakuliah = new ListPrequisiteMatakuliah();
		map.put("prequisite", listPrequisiteMatakuliah);
		map.put("prequisiteList", listPrequisiteService.getAllListPrequisiteMatakuliah());
		map.put("matkulList", MasterMatkulService.getAllMasterMatakuliah());
		
		return "prequisiteview";
	}
	
	@RequestMapping(value="/updatePrequisite", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("prequisiteviewEdit");
		//List<ListPrequisiteMatakuliah> listPrequisiteMatakuliah = listPrequisiteService.find(listPrequisiteMatakuliahId);
		map.put("matkulList", MasterMatkulService.getAllMasterMatakuliah());
		mav.addObject("prequisiteviewEdit", listPrequisiteService.find(id));
		return mav;
	}
	
	@RequestMapping(value="/updatePrequisite", method=RequestMethod.POST)
	public String update(@ModelAttribute("prequisiteviewEdit") ListPrequisiteMatakuliah listPrequisiteMatakuliah, BindingResult result, SessionStatus status)
	{
		listPrequisiteService.edit(listPrequisiteMatakuliah);
		status.setComplete();
		return "redirect:prequisite";
	}
	
	@RequestMapping(value="/prequisite.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ListPrequisiteMatakuliah listPrequisiteMatakuliah, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ListPrequisiteMatakuliah listResult = new ListPrequisiteMatakuliah();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					listPrequisiteService.add(listPrequisiteMatakuliah);
					status.setComplete();
					listResult = listPrequisiteMatakuliah;
					model.addAttribute("prequisite",new ListPrequisiteMatakuliah());
					break;
				case "tambah":
					listPrequisiteService.add(listPrequisiteMatakuliah);
					status.setComplete();
					listResult = listPrequisiteMatakuliah;
					model.addAttribute("prequisite",new ListPrequisiteMatakuliah());
					break;
				case "edit":
					listPrequisiteService.edit(listPrequisiteMatakuliah);
					listResult = listPrequisiteMatakuliah;
					model.addAttribute("prequisite",new ListPrequisiteMatakuliah());
					break;
				case "delete":
					listPrequisiteService.delete(Integer.parseInt(String.valueOf(listPrequisiteMatakuliah.getId())));
					listResult = new ListPrequisiteMatakuliah();
					break;
				case "search":
					List<ListPrequisiteMatakuliah> searchedlistPrequisiteMatakuliah = listPrequisiteService.getAllListPrequisiteMatakuliahById(Integer.parseInt(String.valueOf(listPrequisiteMatakuliah.getId())));
					//listResult = searchedlistPrequisiteMatakuliah!=null ? searchedlistPrequisiteMatakuliah: new ListPrequisiteMatakuliah();
					break;
				case "back":
					model.addAttribute("prequisite",new ListPrequisiteMatakuliah());
					break;
		}
		map.put("prequisite", listResult);
		map.put("prequisiteList", listPrequisiteService.getAllListPrequisiteMatakuliah());
		return "prequisiteview";
	}
	
	
	@RequestMapping("deletePrequisite")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ListPrequisiteMatakuliah listResult = new ListPrequisiteMatakuliah();
		listPrequisiteService.delete(id);
		listResult = new ListPrequisiteMatakuliah();
		map.put("prodiview", listResult);
		map.put("prequisiteList", listPrequisiteService.getAllListPrequisiteMatakuliah());
		return "redirect:prequisite"; 
	}
}
