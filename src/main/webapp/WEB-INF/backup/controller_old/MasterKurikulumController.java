package com.sofaaa.controller_old;

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
import com.sofa.model.kurikulum.MasterKurikulum;
import com.sofa.model.kurikulum.MasterMatakuliah;
import com.sofaaa.service_old.ListMatkulService;
import com.sofaaa.service_old.MasterKurikulumService;
import com.sofaaa.service_old.MasterMatkulService;
import com.sofaaa.service_old.ReffProgramStudiService;


@Controller
public class MasterKurikulumController 
{
	//programStudiview.jsp
	@Autowired
	private MasterKurikulumService masterKurikulumService;
	
	@Autowired
	private ReffProgramStudiService reffProgramStudiService;
	
	@Autowired
	private MasterMatkulService masterMatkulService;
	
	@Autowired
	private ListMatkulService listMatkulService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/addMatkul", method=RequestMethod.GET)
	public ModelAndView AddForm(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("detailkurikulumAdd");
		MasterKurikulum kurikulum = masterKurikulumService.getMasterKurikulum(id);
		ListMatakuliah listMatakuliah = new ListMatakuliah();
		
		mav.addObject("detailkurikulumAdd", listMatakuliah);
		map.put("kurikulumList", kurikulum);
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		return mav;
	}
	
	/*
	@RequestMapping({"/addMatkul"})
	public String AddForm(Map<String, Object> map, @RequestParam("id")Integer id)
	{
		ListMatakuliah listMatakuliah = new ListMatakuliah();
		map.put("listmatkul", listMatakuliah);
		map.put("kurikulumList", masterKurikulumService.getMasterKurikulum(id));
		//map.put("prodiList", masterKurikulumService.getAllMasterKurikulum());
		return "detailkurikulumAdd";
	}
	*/
	
	//=============
	
	@RequestMapping({"/kurikulum", "/curiculums"})
	public String setupForm(Map<String, Object> map)
	{
		MasterKurikulum kurikulum = new MasterKurikulum();
		map.put("kurikulum", kurikulum);
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		return "kurikulumview";
	}
	//=============================================================
	@RequestMapping(value="/viewMk", method=RequestMethod.GET)
	public ModelAndView viewListMk(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("detailkurikulumview");
		MasterKurikulum kurikulum = masterKurikulumService.getMasterKurikulum(id);
		mav.addObject("detailkurikulumview", kurikulum);
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		map.put("listmatkulList", listMatkulService.getAllListMatakuliahByIdKurikulum(id));
		return mav;
	}
	
	//===========================================================
	@RequestMapping(value="/updateKurikulum", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("kurikulumviewEdit");
		MasterKurikulum kurikulum = masterKurikulumService.getMasterKurikulum(id);
		mav.addObject("kurikulumviewEdit", kurikulum);
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		return mav;
	}
	
	@RequestMapping(value="/updateKurikulum", method=RequestMethod.POST)
	public String update(@ModelAttribute("kurikulumviewEdit") MasterKurikulum kurikulum, BindingResult result, SessionStatus status)
	{
		masterKurikulumService.edit(kurikulum);
		status.setComplete();
		return "redirect:kurikulum";
	}
	//===========================================================
	@RequestMapping(value="/kurikulum.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute MasterKurikulum kurikulum,@ModelAttribute ListMatakuliah listMatakuliah, BindingResult result, 
			@RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		MasterKurikulum kurikulumResult = new MasterKurikulum();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch 
				case "add":	
					masterKurikulumService.add(kurikulum);
					status.setComplete();
					kurikulumResult = kurikulum;
					model.addAttribute("kurikulum",new MasterKurikulum());
					break;
				case "tambah":
					masterKurikulumService.add(kurikulum);
					status.setComplete();
					kurikulumResult = kurikulum;
					model.addAttribute("kurikulum",new MasterKurikulum());
					break;
				case "add matkul":	
					listMatkulService.add(listMatakuliah);
					status.setComplete();
					kurikulumResult = kurikulum;
					model.addAttribute("kurikulum",new MasterKurikulum());
					break;
				case "edit":
					masterKurikulumService.edit(kurikulum);
					kurikulumResult = kurikulum;
					model.addAttribute("kurikulum",new MasterKurikulum());
					break;
				case "delete":
					masterKurikulumService.delete(Integer.parseInt(String.valueOf(kurikulumResult.getId())));
					kurikulumResult = new MasterKurikulum();
					break;
				case "search":
					MasterKurikulum searchedMasterKurikulum = masterKurikulumService.getMasterKurikulum(Integer.parseInt(String.valueOf(kurikulum.getId())));
					kurikulumResult = searchedMasterKurikulum!=null ? searchedMasterKurikulum: new MasterKurikulum();
					break;
				case "back":
					model.addAttribute("prodi",new MasterKurikulum());
					break;
		}
		map.put("kurikulumview", kurikulumResult);
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		map.put("prodiList", reffProgramStudiService.getAllReffProgramStudi());
		return "kurikulumview";
	}
	
	
	@RequestMapping("deleteKurikulum")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		MasterKurikulum kurikulumResult = new MasterKurikulum();
		masterKurikulumService.delete(id);
		kurikulumResult = new MasterKurikulum();
		map.put("kurikulumview", kurikulumResult);
		map.put("kurikulumList", masterKurikulumService.getAllMasterKurikulum());
		return "redirect:kurikulum"; 
	}
}
