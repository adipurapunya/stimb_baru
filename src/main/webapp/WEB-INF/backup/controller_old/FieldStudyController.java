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

import com.sofa.model.fieldstudy.FieldOfStudy;
import com.sofaaa.service_old.FieldStudyService;


@Controller
public class FieldStudyController 
{
	@Autowired
	private FieldStudyService fieldStudyService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/fieldstudy", "/fieldstudys"})
	public String setupForm(Map<String, Object> map)
	{
		FieldOfStudy fieldOfStudy = new FieldOfStudy();
		map.put("fieldofstudy", fieldOfStudy);
		map.put("fieldofstudyList", fieldStudyService.getAllfieldOfStudy());
		return "fieldStudyview";
	}
	
	@RequestMapping(value="/updatefieldstudy", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("fieldStudyviewEdit");
		FieldOfStudy fieldOfStudy = fieldStudyService.getfieldOfStudy(id);
		mav.addObject("fieldStudyviewEdit", fieldOfStudy);
		return mav;
	}
	
	@RequestMapping(value="/updatefieldstudy", method=RequestMethod.POST)
	public String update(@ModelAttribute("fieldstudyviewEdit") FieldOfStudy fieldOfStudy, BindingResult result, SessionStatus status)
	{
		//System.out.println("Hasil dari kontroller: "+student.getStudentDetail().getDateBirth());
		fieldStudyService.edit(fieldOfStudy);
		status.setComplete();
		return "redirect:fieldstudy";
	}
	
	@RequestMapping(value="/fieldstudy.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute FieldOfStudy fieldOfStudy, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		FieldOfStudy fieldOfStudyResult = new FieldOfStudy();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":
					fieldStudyService.add(fieldOfStudy);
					status.setComplete();
					fieldOfStudyResult = fieldOfStudy;
					model.addAttribute("fieldofstudy",new FieldOfStudy());
					break;
				case "tambah":
					fieldStudyService.add(fieldOfStudy);
					status.setComplete();
					fieldOfStudyResult = fieldOfStudy;
					model.addAttribute("fieldofstudy",new FieldOfStudy());
					break;
				case "search":
					FieldOfStudy searchedfieldOfStudy = fieldStudyService.getfieldOfStudy(fieldOfStudy.getId());
					fieldOfStudyResult = searchedfieldOfStudy!=null ? searchedfieldOfStudy : new FieldOfStudy();
					break;
				case "back":
					model.addAttribute("fieldofstudy",new FieldOfStudy());
					break;
		}
		map.put("fieldStudyview", fieldOfStudyResult);
		map.put("fieldofstudyList", fieldStudyService.getAllfieldOfStudy());
		return "fieldStudyview";
	}
	
	
	@RequestMapping("deletefieldstudy")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		FieldOfStudy fieldOfStudyResult = new FieldOfStudy();
		fieldStudyService.delete(id);
		fieldOfStudyResult = new FieldOfStudy();
		map.put("fieldStudyview", fieldOfStudyResult);
		map.put("fieldofstudyList", fieldStudyService.getAllfieldOfStudy());
		return "redirect:fieldstudy"; 
	}
}
