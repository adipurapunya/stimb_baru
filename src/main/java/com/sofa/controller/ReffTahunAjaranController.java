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

import com.sofa.model.stimb2.ReffTahunAjaran;
import com.sofa.model.stimb2.ReffTahunAjaranForm;
import com.sofa.service.ReffTahunAjaranService;


@Controller
public class ReffTahunAjaranController 
{
	@Autowired
	private ReffTahunAjaranService reffTahunAjaranService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/tahunajaran", "/ta"})
	public String setupForm(Map<String, Object> map)
	{
		ReffTahunAjaran tahunajaran = new ReffTahunAjaran();
		map.put("tahunajaran", tahunajaran);
		map.put("tahunajaranList", reffTahunAjaranService.getAllReffTahunAjaran());
		return "tahunAjaranview";
	}
	
	@RequestMapping({"/aktivasita", "/ta"})
	public String setupForm2(Map<String, Object> map)
	{
		ReffTahunAjaranForm ajaranForm = new ReffTahunAjaranForm();
		ajaranForm.setReffTahunAjarans(reffTahunAjaranService.getAllReffTahunAjaran());
		map.put("aktivasita", ajaranForm);
		return "aktivasitahunajaranview";
	}
	
	@RequestMapping(value="/updateTahunAjaran", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("tahunAjaranviewEdit");
		ReffTahunAjaran tahunajaran = reffTahunAjaranService.getReffTahunAjaran(id);
		mav.addObject("tahunAjaranviewEdit", tahunajaran);
		return mav;
	}
	
	@RequestMapping(value="/updateTahunAjaran", method=RequestMethod.POST)
	public String update(@ModelAttribute("tahunAjaranviewEdit") ReffTahunAjaran tahunajaran, BindingResult result, SessionStatus status)
	{
		reffTahunAjaranService.edit(tahunajaran);
		status.setComplete();
		return "redirect:tahunajaran";
	}
	
	@RequestMapping(value="/tahunajaran.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute ReffTahunAjaran tahunajaran,@ModelAttribute("aktivasita") ReffTahunAjaranForm reffTahunAjaranForm , BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		ReffTahunAjaran tahunajaranResult = new ReffTahunAjaran();
		String a= "redirect:tahunajaran";
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					tahunajaran.setPeriode("GANJIL");
					reffTahunAjaranService.add(tahunajaran);
					tahunajaran.setPeriode("GENAP");
					reffTahunAjaranService.add(tahunajaran);
					status.setComplete();
					tahunajaranResult = tahunajaran;
					model.addAttribute("tahunajaran",new ReffTahunAjaran());
					break;
				case "tambah":
					reffTahunAjaranService.add(tahunajaran);
					status.setComplete();
					tahunajaranResult = tahunajaran;
					model.addAttribute("tahunajaran",new ReffTahunAjaran());
					break;
				case "aktifkan":
					List<ReffTahunAjaran> data = reffTahunAjaranForm.getReffTahunAjarans();
					for(ReffTahunAjaran dt : data)
					{
						try 
						{
							reffTahunAjaranService.edit(dt);
							System.out.println("Hasil "+dt.isAktivasi()+" Nama: "+dt.getNamaTahunAjaran()+" Periode : "+dt.getPeriode());
						} 
						catch (Exception e)
						{
						}
					}
					status.setComplete();
					a="redirect:aktivasita";
					break;
				case "delete":
					reffTahunAjaranService.delete(Integer.parseInt(String.valueOf(tahunajaran.getId())));
					tahunajaranResult = new ReffTahunAjaran();
					break;
				case "search":
					ReffTahunAjaran searchedReffTahunAjaran = reffTahunAjaranService.getReffTahunAjaran(Integer.parseInt(String.valueOf(tahunajaran.getId())));
					tahunajaranResult = searchedReffTahunAjaran != null ? searchedReffTahunAjaran: new ReffTahunAjaran();
					break;
				case "back":
					model.addAttribute("tahunajaran",new ReffTahunAjaran());
					break;
		}
		map.put("tahunajaranview", tahunajaranResult);
		map.put("tahunajaranList", reffTahunAjaranService.getAllReffTahunAjaran());
		
		return a; 
		//return "aktivasitahunajaranview";
	}
	
	@RequestMapping("deleteTahunAjaran")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ReffTahunAjaran tahunajaranResult = new ReffTahunAjaran();
		reffTahunAjaranService.delete(id);
		tahunajaranResult = new ReffTahunAjaran();
		map.put("tahunajaranview", tahunajaranResult);
		map.put("tahunajaranList", reffTahunAjaranService.getAllReffTahunAjaran());
		return "redirect:tahunajaran"; 
	}
}
