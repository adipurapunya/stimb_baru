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

import com.sofa.model.stimb2.ListInstrumentMayor;
import com.sofa.model.stimb2.ListMatakuliah;
import com.sofa.model.stimb2.MasterKurikulum;
import com.sofa.model.stimb2.MasterMatakuliah;
import com.sofa.model.stimb2.ReffInstrumentMayor;
import com.sofa.service.ListIntrumentMayorService;
import com.sofa.service.MasterMatkulService;
import com.sofa.service.ReffInstrumentMayorService;

@Controller
public class ListInstrumentMayorController 
{
	//programStudiview.jsp
	@Autowired
	private ListIntrumentMayorService listIntrumentMayorService;
	
	@Autowired
	private MasterMatkulService masterMatkulService;
	
	@Autowired
	private ReffInstrumentMayorService ReffInstrumentMayorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/*
	@RequestMapping({"/listinstrumentmayor"})
	public String setupForm(Map<String, Object> map)
	{
		ListInstrumentMayor listInstrumentMayor = new ListInstrumentMayor();
		map.put("listmatkul", listmatkul);
		map.put("listmatkulList", listMatkulService.getAllListMatakuliah());
		
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		return "listmatkulview";
	}
	*/
	
	//=============================================================
		@RequestMapping(value="/viewInsMayor", method=RequestMethod.GET)
		public ModelAndView viewListMk(@RequestParam("id")Integer id, Map<String, Object> map)
		{
			ModelAndView mav = new ModelAndView("detailinstrumentmayorview");
			MasterMatakuliah matakuliah = masterMatkulService.getMasterMatakuliah(id);
			mav.addObject("detailinstrumentmayorview", matakuliah);
			map.put("getId",masterMatkulService.getMasterMatakuliah(id));
			map.put("instrumentmayorList", listIntrumentMayorService.getAllListInstrumentMayorId(id));
			return mav;
		}
		
		@RequestMapping(value="/addInstrument", method=RequestMethod.GET)
		public ModelAndView AddForm(@RequestParam("id")Integer id, Map<String, Object> map)
		{
			ModelAndView mav = new ModelAndView("detailinstrumentmayorAdd");
			//ReffInstrumentMayor kurikulum = masterKurikulumService.getMasterKurikulum(id);
			ListInstrumentMayor listInstrumentMayor = new ListInstrumentMayor();
			
			mav.addObject("detailinstrumentmayorAdd", listInstrumentMayor);
			map.put("matkulList", masterMatkulService.getMasterMatakuliah(id));
			map.put("instrumentList", ReffInstrumentMayorService.getAllReffMayor());
			return mav;
		}
		
		
		//===========================================================
		
		@RequestMapping(value="/instrumentmayor.do", method=RequestMethod.POST)
		public String doActions(@ModelAttribute ListInstrumentMayor listInstrumentMayor,BindingResult result, 
				@RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
		{
			ListInstrumentMayor listInstrumentResult = new ListInstrumentMayor();
			switch(action.toLowerCase())
			{	//only in Java7 you can put String in switch 
					case "add instrument":	
						listIntrumentMayorService.add(listInstrumentMayor);
						status.setComplete();
						listInstrumentResult = listInstrumentMayor;
						model.addAttribute("matkul",new MasterMatakuliah());
						break;
					case "edit":
						listIntrumentMayorService.edit(listInstrumentMayor);
						listInstrumentResult = listInstrumentMayor;
						model.addAttribute("instrumentmayor",new ListInstrumentMayor());
						break;
					case "delete":
						listIntrumentMayorService.delete(Integer.parseInt(String.valueOf(listInstrumentResult.getId())));
						listInstrumentResult = new ListInstrumentMayor();
						break;
					case "search":
						ListInstrumentMayor searchedListInstrumentMayor = listIntrumentMayorService.getListInstrumentMayor(Integer.parseInt(String.valueOf(listInstrumentMayor.getId())));
						listInstrumentResult = searchedListInstrumentMayor!=null ? searchedListInstrumentMayor: new ListInstrumentMayor();
						break;
			}
			
				//map.put("matkulview", listInstrumentResult);
				map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
				return "matkulview";
			
		}
		
		
		@RequestMapping("deleteInstrument")
		public String deleteForm(@RequestParam("id")Integer id,@RequestParam("idkul")Integer id2,Map<String, Object> map)
		{
			//ListInstrumentMayor listInstrumentMayorResult = new ListInstrumentMayor();
			listIntrumentMayorService.delete(id);
			//listInstrumentMayorResult = new ListInstrumentMayor();
			//map.put("kurikulumview", listInstrumentMayorResult);
			map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
			//return "redirect:matkul";//viewInsMayor?id=1
			return "redirect:viewInsMayor?id="+id2;
		}
}
