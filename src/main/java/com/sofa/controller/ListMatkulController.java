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

import com.sofa.model.kurikulum.ListMatakuliah;
import com.sofa.service.ListMatkulService;
import com.sofa.service.MasterKurikulumService;
import com.sofa.service.MasterMatkulService;

@Controller
public class ListMatkulController 
{
	//programStudiview.jsp
	@Autowired
	private ListMatkulService listMatkulService;
	
	@Autowired
	private MasterKurikulumService masterKurikulumService;
	
	@Autowired
	private MasterMatkulService masterMatkulService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/listmatkul", "/listmatakuliah"})
	public String setupForm(Map<String, Object> map)
	{
		ListMatakuliah listmatkul = new ListMatakuliah();
		map.put("listmatkul", listmatkul);
		map.put("listmatkulList", listMatkulService.getAllListMatakuliah());
		
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		return "listmatkulview";
	}
	
	@RequestMapping(value="/updateListmatkul", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("listmatkulviewEdit");
		ListMatakuliah listmatkul = listMatkulService.getListMatakuliah(id);
		mav.addObject("listmatkulviewEdit", listmatkul);
		map.put("listmatkulList", listMatkulService.getAllListMatakuliah());
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		return mav;
	}
	
	@RequestMapping(value="/updateListmatkul", method=RequestMethod.POST)
	public String update(@ModelAttribute("listmatkulviewEdit") ListMatakuliah listmatkul, BindingResult result, SessionStatus status)
	{
		listMatkulService.edit(listmatkul);
		status.setComplete();
		return "redirect:listmatkul";
	}
	
	@RequestMapping(value="/listmatkul.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ListMatakuliah listmatkul, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ListMatakuliah listmatkulResult = new ListMatakuliah();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					listMatkulService.add(listmatkul);
					status.setComplete();
					listmatkulResult = listmatkul;
					model.addAttribute("listmatkul",new ListMatakuliah());
					break;
				case "tambah":
					listMatkulService.add(listmatkul);
					status.setComplete();
					listmatkulResult = listmatkul;
					model.addAttribute("listmatkul",new ListMatakuliah());
					break;
				case "edit":
					listMatkulService.edit(listmatkul);
					listmatkulResult = listmatkul;
					model.addAttribute("listmatkul",new ListMatakuliah());
					break;
				case "delete":
					listMatkulService.delete(Integer.parseInt(String.valueOf(listmatkulResult.getId())));
					listmatkulResult = new ListMatakuliah();
					break;
				case "search":
					ListMatakuliah searchedListMatakuliah = listMatkulService.getListMatakuliah(Integer.parseInt(String.valueOf(listmatkul.getId())));
					listmatkulResult = searchedListMatakuliah!=null ? searchedListMatakuliah: new ListMatakuliah();
					break;
				case "back":
					model.addAttribute("listmatkul",new ListMatakuliah());
					break;
		}
		map.put("listmatkulview", listmatkulResult);
		map.put("listmatkulList", listMatkulService.getAllListMatakuliah());
		
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		
		return "listmatkulview";
	}
	
	
	@RequestMapping("deleteListmatkul")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ListMatakuliah listmatkulResult = new ListMatakuliah();
		listMatkulService.delete(id);
		listmatkulResult = new ListMatakuliah();
		map.put("listmatkulview", listmatkulResult);
		map.put("listmatkulList", listMatkulService.getAllListMatakuliah());
		return "redirect:listmatkul"; 
	}
}
