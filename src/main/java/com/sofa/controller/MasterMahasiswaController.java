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

import com.sofa.model.stimb2.MasterMahasiswa;
import com.sofa.service.MasterMahasiswaService;
import com.sofa.service.ReffInstrumentMayorService;
import com.sofa.service.ReffProgramStudiService;
import com.sofa.service.AngkatanService;

@Controller
public class MasterMahasiswaController 
{
	@Autowired
	private MasterMahasiswaService masterMahasiswaService;
	
	@Autowired
	private ReffProgramStudiService ReffProgramStudiService;
	
	@Autowired
	private ReffInstrumentMayorService ReffInstrumentMayorService;

	@Autowired
	private AngkatanService angkatanService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/mahasiswa"})
	public String setupForm(Map<String, Object> map)
	{
		MasterMahasiswa mahasiswa= new MasterMahasiswa();
		map.put("mahasiswa", mahasiswa);
		map.put("mahasiswaList", masterMahasiswaService.getAllMasterMahasiswa());
		map.put("prodiList",ReffProgramStudiService.getAllReffProgramStudi());
		map.put("mayorList",ReffInstrumentMayorService.getAllReffMayor());
		map.put("angkatanList",angkatanService.getAllAngkatan());
		return "mahasiswaview";
	}
	
	
	@RequestMapping(value="/updateMahasiswa", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("mahasiswaviewEdit");
		MasterMahasiswa masterMahasiswa = masterMahasiswaService.getMasterMahasiswa(id);
		mav.addObject("mahasiswaviewEdit", masterMahasiswa);
		map.put("prodiList",ReffProgramStudiService.getAllReffProgramStudi());
		map.put("mayorList",ReffInstrumentMayorService.getAllReffMayor());
		map.put("angkatanList",angkatanService.getAllAngkatan());
		return mav;
	}
	
	
	@RequestMapping(value="/updateMahasiswa", method=RequestMethod.POST)
	public String update(@ModelAttribute("mahasiswaviewEdit") MasterMahasiswa masterMahasiswa, BindingResult result, SessionStatus status)
	{
		masterMahasiswaService.edit(masterMahasiswa);
		status.setComplete();
		return "redirect:mahasiswa";
	}
	
	
	@RequestMapping(value="/mahasiswa.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute MasterMahasiswa masterMahasiswa, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		MasterMahasiswa masterMahasiswaResult = new MasterMahasiswa();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":		
					masterMahasiswaService.add(masterMahasiswa);
					status.setComplete();
					masterMahasiswaResult = masterMahasiswa;
					model.addAttribute("mahasiswa",new MasterMahasiswa());
					break;
				case "tambah":
					masterMahasiswaService.add(masterMahasiswa);
					status.setComplete();
					masterMahasiswaResult = masterMahasiswa;
					model.addAttribute("mahasiswa",new MasterMahasiswa());
					break;
				case "edit":
					masterMahasiswaService.edit(masterMahasiswa);
					masterMahasiswaResult = masterMahasiswa;
					model.addAttribute("mahasiswa",new MasterMahasiswa());
					break;
				case "delete":
					masterMahasiswaService.delete(Integer.parseInt(String.valueOf(masterMahasiswa.getId())));
					masterMahasiswaResult = new MasterMahasiswa();
					break;
				case "search":
					MasterMahasiswa searchedmasterMahasiswa = masterMahasiswaService.getMasterMahasiswa(Integer.parseInt(String.valueOf(masterMahasiswa.getId())));
					masterMahasiswaResult = searchedmasterMahasiswa!=null ? searchedmasterMahasiswa: new MasterMahasiswa();
					break;
				case "back":
					model.addAttribute("mahasiswa",new MasterMahasiswa());
					break;
		}
		map.put("mahasiswaview", masterMahasiswaResult);
		map.put("mahasiswaList", masterMahasiswaService.getAllMasterMahasiswa());
		return "redirect:mahasiswa";
	}
	
	
	@RequestMapping("deleteMahasiswa")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		MasterMahasiswa masterMahasiswaResult = new MasterMahasiswa();
		masterMahasiswaService.delete(id);
		masterMahasiswaResult = new MasterMahasiswa();
		map.put("mahasiswa", masterMahasiswaResult);
		map.put("mahasiswaList", masterMahasiswaService.getAllMasterMahasiswa());
		return "redirect:mahasiswa"; 
	}	
	
}
