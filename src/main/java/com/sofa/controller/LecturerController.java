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
import com.sofa.model.lecturer.Lecturer;
import com.sofa.service.LecturerService;;


@Controller
public class LecturerController 
{
	@Autowired
	private LecturerService lecturerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/lecturer", "/lecturers"})
	public String setupForm(Map<String, Object> map)
	{
		Lecturer lecturer = new Lecturer();
		map.put("lecturer", lecturer);
		map.put("lecturerList", lecturerService.getAllLecturer());
		return "lecturerview";
	}
	
	@RequestMapping(value="/updateLecturer", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("lecturerviewEdit");
		Lecturer lecturer = lecturerService.getLecturer(id);
		mav.addObject("lecturerviewEdit", lecturer);
		return mav;
	}
	
	@RequestMapping(value="/updateLecturer", method=RequestMethod.POST)
	public String update(@ModelAttribute("lecturerviewEdit") Lecturer lecturer, BindingResult result, SessionStatus status)
	{
		lecturerService.edit(lecturer);
		status.setComplete();
		return "redirect:lecturer";
	}
	
	@RequestMapping(value="/lecturer.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Lecturer lecturer, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		Lecturer lecturerResult = new Lecturer();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":		
					lecturerService.add(lecturer);
					status.setComplete();
					lecturerResult = lecturer;
					model.addAttribute("lecturer",new Lecturer());
					break;
				case "tambah":
					lecturerService.add(lecturer);
					status.setComplete();
					lecturerResult = lecturer;
					model.addAttribute("lecturer",new Lecturer());
					break;
				case "edit":
					lecturerService.edit(lecturer);
					lecturerResult = lecturer;
					model.addAttribute("student",new Lecturer());
					break;
				case "delete":
					lecturerService.delete(lecturer.getId());
					lecturerResult = new Lecturer();
					break;
				case "search":
					Lecturer searchedLecturer = lecturerService.getLecturer(lecturer.getId());
					lecturerResult = searchedLecturer!=null ? searchedLecturer: new Lecturer();
					break;
				case "back":
					model.addAttribute("lecturer",new Lecturer());
					break;
		}
		map.put("lecturerview", lecturerResult);
		map.put("lecturerList", lecturerService.getAllLecturer());
		return "lecturerview";
	}
	
	
	@RequestMapping("deleteLecturer")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		Lecturer lecturerResult = new Lecturer();
		lecturerService.delete(id);
		lecturerResult = new Lecturer();
		map.put("lecturer", lecturerResult);
		map.put("lecturerList", lecturerService.getAllLecturer());
		return "redirect:lecturer"; 
	}	
}
