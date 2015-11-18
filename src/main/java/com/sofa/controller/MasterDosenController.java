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
import com.sofa.model.stimb2.MasterDosen;
import com.sofa.service.MasterDosenService;


@Controller
public class MasterDosenController 
{
	@Autowired
	private MasterDosenService masterDosenService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/dosen", "/lecturers"})
	public String setupForm(Map<String, Object> map)
	{
		MasterDosen dosen= new MasterDosen();
		map.put("dosen", dosen);
		map.put("dosenList", masterDosenService.getAllMasterDosen());
		return "dosenview";
	}
	
	
	@RequestMapping(value="/updateDosen", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("dosenviewEdit");
		MasterDosen masterDosen = masterDosenService.getMasterDosen(id);
		mav.addObject("dosenviewEdit", masterDosen);
		return mav;
	}
	
	
	@RequestMapping(value="/updateDosen", method=RequestMethod.POST)
	public String update(@ModelAttribute("lecturerviewEdit") MasterDosen masterDosen, BindingResult result, SessionStatus status)
	{
		masterDosenService.edit(masterDosen);
		status.setComplete();
		return "redirect:dosen";
	}
	
	
	@RequestMapping(value="/dosen.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute MasterDosen masterDosen, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		MasterDosen masterDosenResult = new MasterDosen();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":		
					masterDosenService.add(masterDosen);
					status.setComplete();
					masterDosenResult = masterDosen;
					model.addAttribute("dosen",new MasterDosen());
					break;
				case "tambah":
					masterDosenService.add(masterDosen);
					status.setComplete();
					masterDosenResult = masterDosen;
					model.addAttribute("dosen",new MasterDosen());
					break;
				case "edit":
					masterDosenService.edit(masterDosen);
					masterDosenResult = masterDosen;
					model.addAttribute("dosen",new MasterDosen());
					break;
				case "delete":
					masterDosenService.delete(Integer.parseInt(String.valueOf(masterDosen.getId())));
					masterDosenResult = new MasterDosen();
					break;
				case "search":
					MasterDosen searchedmasterDosen = masterDosenService.getMasterDosen(Integer.parseInt(String.valueOf(masterDosen.getId())));
					masterDosenResult = searchedmasterDosen!=null ? searchedmasterDosen: new MasterDosen();
					break;
				case "back":
					model.addAttribute("dosen",new MasterDosen());
					break;
		}
		map.put("dosenview", masterDosenResult);
		map.put("dosenList", masterDosenService.getAllMasterDosen());
		return "dosenview";
	}
	
	
	@RequestMapping("deleteDosen")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		MasterDosen masterDosenResult = new MasterDosen();
		masterDosenService.delete(id);
		masterDosenResult = new MasterDosen();
		map.put("dosen", masterDosenResult);
		map.put("dosenList", masterDosenService.getAllMasterDosen());
		return "redirect:dosen"; 
	}	
	
}
