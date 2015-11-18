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
import com.sofa.model.stimb2.ReffKelompokMatakuliah;
import com.sofa.service.ReffKelMatkulService;


@Controller
public class ReffKelompokMatkulController 
{
	//programStudiview.jsp
	@Autowired
	private ReffKelMatkulService reffKelMatkulService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/kelompokkul", "/kelompok"})
	public String setupForm(Map<String, Object> map)
	{
		ReffKelompokMatakuliah kelompokkul = new ReffKelompokMatakuliah();
		map.put("kelompokkul", kelompokkul);
		map.put("kelompokkulList", reffKelMatkulService.getAllKelompokMatakuliah());
		return "kelompokkulview";
	}
	
	@RequestMapping(value="/updateKelompokkul", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("kelompokkulviewEdit");
		ReffKelompokMatakuliah kelompokkul = reffKelMatkulService.getKelompokMatakuliah(id);
		mav.addObject("kelompokkulviewEdit", kelompokkul);
		return mav;
	}
	
	@RequestMapping(value="/updateKelompokkul", method=RequestMethod.POST)
	public String update(@ModelAttribute("prodiviewEdit") ReffKelompokMatakuliah kelompokkul, BindingResult result, SessionStatus status)
	{
		reffKelMatkulService.edit(kelompokkul);
		status.setComplete();
		return "redirect:kelompokkul";
	}
	
	@RequestMapping(value="/kelompokkul.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ReffKelompokMatakuliah kelompokkul, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ReffKelompokMatakuliah kelompokkulResult = new ReffKelompokMatakuliah();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					reffKelMatkulService.add(kelompokkul);
					status.setComplete();
					kelompokkulResult = kelompokkul;
					model.addAttribute("kelompokkul",new ReffKelompokMatakuliah());
					break;
				case "tambah":
					reffKelMatkulService.add(kelompokkul);
					status.setComplete();
					kelompokkulResult = kelompokkul;
					model.addAttribute("kelompokkul",new ReffKelompokMatakuliah());
					break;
				case "edit":
					reffKelMatkulService.edit(kelompokkul);
					kelompokkulResult = kelompokkul;
					model.addAttribute("kelompokkul",new ReffKelompokMatakuliah());
					break;
				case "delete":
					reffKelMatkulService.delete(Integer.parseInt(String.valueOf(kelompokkul.getId())));
					kelompokkulResult = new ReffKelompokMatakuliah();
					break;
				case "search":
					ReffKelompokMatakuliah searchedReffKelompokMatakuliah = reffKelMatkulService.getKelompokMatakuliah(Integer.parseInt(String.valueOf(kelompokkul.getId())));
					kelompokkulResult = searchedReffKelompokMatakuliah!=null ? searchedReffKelompokMatakuliah: new ReffKelompokMatakuliah();
					break;
				case "back":
					model.addAttribute("kelompokkul",new ReffKelompokMatakuliah());
					break;
		}
		map.put("kelompokkulview", kelompokkulResult);
		map.put("kelompokkulList", reffKelMatkulService.getAllKelompokMatakuliah());
		return "kelompokkulview";
	}
	
	
	@RequestMapping("deleteKelompokkul")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ReffKelompokMatakuliah kelompokkulResult = new ReffKelompokMatakuliah();
		reffKelMatkulService.delete(id);
		kelompokkulResult = new ReffKelompokMatakuliah();
		map.put("kelompokkulview", kelompokkulResult);
		map.put("kelompokkulList", reffKelMatkulService.getAllKelompokMatakuliah());
		return "redirect:kelompokkul"; 
	}
}
