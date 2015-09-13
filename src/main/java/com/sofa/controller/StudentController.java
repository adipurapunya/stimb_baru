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

import com.sofa.enkripsi.md5.md5;
import com.sofa.model.account.User;
import com.sofa.model.account.UserStatus;
import com.sofa.model.student.Student;
import com.sofa.service.FieldStudyService;
import com.sofa.service.LevelAcademicYearService;
import com.sofa.service.StudentService;


@Controller
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	@Autowired
	private FieldStudyService fieldStudyService;
	@Autowired
	private LevelAcademicYearService academicYearService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping({"/student", "/students"})
	public String setupForm(Map<String, Object> map)
	{
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		map.put("fieldStudyList", fieldStudyService.getAllfieldOfStudy());
		map.put("academicYearList", academicYearService.getAllYear());
		return "studentview";
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		ModelAndView mav = new ModelAndView("studentviewEdit");
		Student student = studentService.getStudent(id);
		mav.addObject("studentviewEdit", student);
		map.put("fieldStudyList", fieldStudyService.getAllfieldOfStudy());
		map.put("academicYearList", academicYearService.getAllYear());
		//model.addAttribute("student",new Student());
		return mav;
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
	public String update(@ModelAttribute("studentviewEdit") Student student, BindingResult result, SessionStatus status)
	{
		System.out.println("Hasil dari kontroller: "+student.getStudentDetail().getDateBirth());
		studentService.edit(student);
		status.setComplete();
		//return "studentview";
		return "redirect:student";
	}
	
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map, SessionStatus status, ModelMap model)
	{
		Student studentResult = new Student();
		switch(action.toLowerCase())
		{	//only in Java7 you can put String in switch
				case "add":
					
					User user = new User();
					user.setPassword(new md5().encrypt(student.getNim()));
					user.setUsername(student.getNim());
					user.setStatus(UserStatus.ACTIVE);
					student.setUser(user);
					
					studentService.add(student);
					
					status.setComplete();
					studentResult = student;
					model.addAttribute("student",new Student());
					break;
				case "tambah":
					
					User user2 = new User();
					user2.setPassword(new md5().encrypt(student.getNim()));
					user2.setUsername(student.getNim());
					user2.setStatus(UserStatus.ACTIVE);
					student.setUser(user2);
					
					studentService.add(student);
					
					status.setComplete();
					studentResult = student;
					model.addAttribute("student",new Student());
					break;
				case "edit":
					studentService.edit(student);
					studentResult = student;
					model.addAttribute("student",new Student());
					break;
				case "delete":
					studentService.delete(student.getId());
					studentResult = new Student();
					break;
				case "search":
					Student searchedStudent = studentService.getStudent(student.getId());
					studentResult = searchedStudent!=null ? searchedStudent : new Student();
					break;
				case "back":
					model.addAttribute("student",new Student());
					break;
		}
		map.put("studentview", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "studentview";
	}
	
	
	@RequestMapping("deleteContact")
	public String deleteForm(@RequestParam("id")Integer id,Map<String, Object> map)
	{
		Student studentResult = new Student();
		studentService.delete(id);
		studentResult = new Student();
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "redirect:student"; 
		//return "studentview";
	}
	/*
	@RequestMapping(value="/saveStudent", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("studentview");
		Student student = new Student();
		mav.getModelMap().put("studentview", student);
		return mav;
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public String create(@ModelAttribute("newStudent")Student student, SessionStatus status)
	{
		//contactsDAO.save(contact);
		studentService.add(student);
		status.setComplete();
		return "redirect:studentview";
	}
	*/
	
}
