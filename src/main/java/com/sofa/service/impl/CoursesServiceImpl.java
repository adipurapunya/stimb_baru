package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofa.dao.CoursesDao;
import com.sofa.model.courses.Courses;
import com.sofa.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesDao coursesDao;
	
	@Transactional
	public void add(Courses courses)
	{
		coursesDao.add(courses);
	}

	@Transactional
	public void edit(Courses courses)
	{
		coursesDao.edit(courses);
	}

	@Transactional
	public void delete(int coursesId)
	{
		coursesDao.delete(coursesId);
	}

	@Transactional
	public Courses getCourses(int coursesId)
	{
		return coursesDao.getCourses(coursesId);
	}

	@Transactional
	public List getAllCourses() 
	{
		return coursesDao.getAllCourses();
	}

}
