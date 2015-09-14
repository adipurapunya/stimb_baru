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
import com.sofa.model.tahunakademik.LevelAcademicYear;
import com.sofa.service.LevelAcademicYearService;

// by adipura
@Controller
public class AcademicLevelYearController 
{
	@Autowired
	private LevelAcademicYearService academicYearService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/levelyear", "/levelyears"})
	public String setupForm(Map<String, Object> map)
	{
		LevelAcademicYear levelAcademicYear = new LevelAcademicYear();
		map.put("levelacademicyear", levelAcademicYear);
		map.put("levelacademicyearList", academicYearService.getAllYear());
		return "levelYearview";
	}
	
	@RequestMapping(value="/updatelevelyear", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("levelYearviewEdit");
		LevelAcademicYear levelAcademicYear = academicYearService.getYear(id);
		mav.addObject("levelYearviewEdit", levelAcademicYear);
		return mav;
	}
	
	@RequestMapping(value="/updatelevelyear", method=RequestMethod.POST)
	public String update(@ModelAttribute("levelYearviewEdit") LevelAcademicYear levelAcademicYear, BindingResult result, SessionStatus status)
	{
		//System.out.println("Hasil dari kontroller: "+student.getStudentDetail().getDateBirth());
		academicYearService.edit(levelAcademicYear);
		status.setComplete();
		return "redirect:levelyear";
	}
	
	@RequestMapping(value="/levelyear.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute LevelAcademicYear levelAcademicYear, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		LevelAcademicYear levelAcademicYearResult = new LevelAcademicYear();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":
					academicYearService.add(levelAcademicYear);
					status.setComplete();
					levelAcademicYearResult = levelAcademicYear;
					model.addAttribute("levelacademicyear",new LevelAcademicYear());
					break;
				case "tambah":
					academicYearService.add(levelAcademicYear);
					status.setComplete();
					levelAcademicYearResult = levelAcademicYear;
					model.addAttribute("levelacademicyear",new LevelAcademicYear());
					break;
				case "search":
					LevelAcademicYear searchedlevelAcademicYear = academicYearService.getYear(levelAcademicYear.getId());
					levelAcademicYearResult = searchedlevelAcademicYear!=null ? searchedlevelAcademicYear : new LevelAcademicYear();
					break;
				case "back":
					model.addAttribute("levelacademicyear",new LevelAcademicYear());
					break;
		}
		map.put("levelYearview", levelAcademicYearResult);
		map.put("levelacademicyearList", academicYearService.getAllYear());
		return "levelYearview";
	}
	
	
	@RequestMapping("deleteLevelYear")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		LevelAcademicYear levelAcademicYearResult = new LevelAcademicYear();
		academicYearService.delete(id);
		levelAcademicYearResult = new LevelAcademicYear();
		map.put("levelYearview", levelAcademicYearResult);
		map.put("levelacademicyearList", academicYearService.getAllYear());
		return "redirect:levelyear"; 
	}
}
