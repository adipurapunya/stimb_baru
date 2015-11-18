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
import com.sofa.model.kurikulum.MasterMatakuliah;
import com.sofaaa.service_old.MasterMatkulService;
import com.sofaaa.service_old.ReffKelMatkulService;


@Controller
public class MasterMatkulController 
{
	//programStudiview.jsp
	@Autowired
	private MasterMatkulService masterMatkulService;
	
	@Autowired
	private ReffKelMatkulService reffKelMatkulService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/matkul", "/matakuliah"})
	public String setupForm(Map<String, Object> map)
	{
		MasterMatakuliah matkul = new MasterMatakuliah();
		map.put("matkul", matkul);
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		map.put("kelompokList", reffKelMatkulService.getAllKelompokMatakuliah());
		return "matkulview";
	}
	
	@RequestMapping(value="/updateMatkul", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id, Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("matkulviewEdit");
		MasterMatakuliah matkul = masterMatkulService.getMasterMatakuliah(id);
		mav.addObject("matkulviewEdit", matkul);
		map.put("kelompokList", reffKelMatkulService.getAllKelompokMatakuliah());
		return mav;
	}
	
	@RequestMapping(value="/updateMatkul", method=RequestMethod.POST)
	public String update(@ModelAttribute("matkulviewEdit") MasterMatakuliah matkul, BindingResult result, SessionStatus status)
	{
		masterMatkulService.edit(matkul);
		status.setComplete();
		return "redirect:matkul";
	}
	
	@RequestMapping(value="/matkul.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute MasterMatakuliah matkul, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		MasterMatakuliah matkulResult = new MasterMatakuliah();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					masterMatkulService.add(matkul);
					status.setComplete();
					matkulResult = matkul;
					model.addAttribute("matkul",new MasterMatakuliah());
					break;
				case "tambah":
					masterMatkulService.add(matkul);
					status.setComplete();
					matkulResult = matkul;
					model.addAttribute("matkul",new MasterMatakuliah());
					break;
				case "edit":
					masterMatkulService.edit(matkul);
					matkulResult = matkul;
					model.addAttribute("matkul",new MasterMatakuliah());
					break;
				case "delete":
					masterMatkulService.delete(Integer.parseInt(String.valueOf(matkulResult.getId())));
					matkulResult = new MasterMatakuliah();
					break;
				case "search":
					MasterMatakuliah searchedMasterMatakuliah = masterMatkulService.getMasterMatakuliah(Integer.parseInt(String.valueOf(matkul.getId())));
					matkulResult = searchedMasterMatakuliah!=null ? searchedMasterMatakuliah: new MasterMatakuliah();
					break;
				case "back":
					model.addAttribute("matkul",new MasterMatakuliah());
					break;
		}
		map.put("matkulview", matkulResult);
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		map.put("kelompokList", reffKelMatkulService.getAllKelompokMatakuliah());
		return "matkulview";
	}
	
	
	@RequestMapping("deleteMatkul")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		MasterMatakuliah matkulResult = new MasterMatakuliah();
		masterMatkulService.delete(id);
		matkulResult = new MasterMatakuliah();
		map.put("matkulview", matkulResult);
		map.put("matkulList", masterMatkulService.getAllMasterMatakuliah());
		return "redirect:matkul"; 
	}
}
