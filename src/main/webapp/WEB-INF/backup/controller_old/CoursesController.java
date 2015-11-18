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
import com.sofa.model.courses.Courses;
import com.sofaaa.service_old.CoursesService;


@Controller
public class CoursesController 
{
	@Autowired
	private CoursesService coursesService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/courses", "/course"})
	public String setupForm(Map<String, Object> map)
	{
		Courses courses = new Courses();
		map.put("courses", courses);
		map.put("coursesList", coursesService.getAllCourses());
		return "coursesview";
	}
	
	@RequestMapping(value="/updateCourses", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("coursesviewEdit");
		Courses courses = coursesService.getCourses(id);
		mav.addObject("coursesviewEdit", courses);
		return mav;
	}
	
	@RequestMapping(value="/updateCourses", method=RequestMethod.POST)
	public String update(@ModelAttribute("coursesviewEdit") Courses courses, BindingResult result, SessionStatus status)
	{
		coursesService.edit(courses);
		status.setComplete();
		return "redirect:courses";
	}
	
	@RequestMapping(value="/courses.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Courses courses, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		Courses coursesResult = new Courses();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":	
					coursesService.add(courses);
					status.setComplete();
					coursesResult = courses;
					model.addAttribute("courses",new Courses());
					break;
				case "tambah":
					coursesService.add(courses);
					status.setComplete();
					coursesResult = courses;
					model.addAttribute("courses",new Courses());
					break;
				case "edit":
					coursesService.edit(courses);
					coursesResult = courses;
					model.addAttribute("courses",new Courses());
					break;
				case "delete":
					coursesService.delete(courses.getId());
					coursesResult = new Courses();
					break;
				case "search":
					Courses searchedCourses = coursesService.getCourses(courses.getId());
					coursesResult = searchedCourses!=null ? searchedCourses: new Courses();
					break;
				case "back":
					model.addAttribute("courses",new Courses());
					break;
		}
		map.put("coursesview", coursesResult);
		map.put("coursesList", coursesService.getAllCourses());
		return "coursesview";
	}
	
	
	@RequestMapping("deleteCourses")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		Courses coursesResult = new Courses();
		coursesService.delete(id);
		coursesResult = new Courses();
		map.put("courses", coursesResult);
		map.put("coursesList", coursesService.getAllCourses());
		return "redirect:courses"; 
	}
}
