package com.sofa.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.sofa.model.stimb2.ListMatakuliah;
import com.sofa.model.stimb2.ListSemesterPerkuliahan;
import com.sofa.model.stimb2.ListSemesterPerkuliahanForm;
import com.sofa.model.stimb2.MasterKurikulum;
import com.sofa.service.ListAktivasiService;
import com.sofa.service.MasterKurikulumService;

@Controller
public class ListAktivasiController 
{
	//programStudiview.jsp
	@Autowired
	private ListAktivasiService listAktivasiService;
	
	@Autowired
	private MasterKurikulumService masterKurikulumService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/aktivasi", "/aktivation"})
	public String setupForm(Map<String, Object> map)
	{
		ListSemesterPerkuliahanForm listSemesterPerkuliahanForm = new ListSemesterPerkuliahanForm();
		listSemesterPerkuliahanForm.setListSemesterPerkuliahans(listAktivasiService.getAllListSemesterPerkuliahan());
		map.put("aktivasi", listSemesterPerkuliahanForm);
		//map.put("aktivasiList", listAktivasiService.getAllListSemesterPerkuliahan());
		//map.put("listKurikulum", masterKurikulumService.getAllMasterKurikulum());
		return "aktivasiview";
	}
	
	@RequestMapping(value="/aktivasi.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ListSemesterPerkuliahanForm data, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ListMatakuliah listmatkulResult = new ListMatakuliah();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "adds":	
					break;
				case "tambah":
					break;
				case "update":
					
					List<ListSemesterPerkuliahan> ListSemesterPerkuliahans = data.getListSemesterPerkuliahans(); 
						
						for(ListSemesterPerkuliahan ls : ListSemesterPerkuliahans)
						{
							//System.out.println(ls.getId()+"-"+ls.getMasterKurikulum().getId()+"-"+ls.getStatusSemester());
							
							try 
							{
								if(ls.getStatusSemester()==null)
								{
									ls.setStatusSemester(false);
								}
								listAktivasiService.edit(ls);
							} 
							catch (Exception e) 
							{
							}
						}
						status.setComplete();
						ListSemesterPerkuliahanForm listSemesterPerkuliahanForm = new ListSemesterPerkuliahanForm();
						listSemesterPerkuliahanForm.setListSemesterPerkuliahans(listAktivasiService.getAllListSemesterPerkuliahan());
						model.addAttribute("aktivasi",listSemesterPerkuliahanForm);
					
					break;
				case "delete":
					break;
				case "search":
					break;
				case "back":
					break;
		}
		//map.put("listmatkulview", listmatkulResult);
		//map.put("aktivasi", listSemesterPerkuliahanForm);
		///map.put("listmatkulList", listMatkulService.getAllListMatakuliah());		
		return "aktivasiview";
	}
	
	
	
	
	
	/*
	 
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
	*/
}
