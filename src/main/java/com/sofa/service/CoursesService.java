package com.sofa.service;

import java.util.List;

import com.sofa.model.courses.Courses;

public interface CoursesService
{
	public void add(Courses courses);
	public void edit(Courses courses);
	public void delete(int coursesId);
	public Courses getCourses(int coursesId);
	public List getAllCourses();
}
