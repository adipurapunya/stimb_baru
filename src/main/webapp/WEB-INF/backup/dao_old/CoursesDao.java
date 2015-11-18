package com.sofaaa.dao_old;

import java.util.List;

import com.sofa.model.courses.Courses;

public interface CoursesDao 
{
	public void add(Courses courses);
	public void edit(Courses courses);
	public void delete(int coursesId);
	public Courses getCourses(int coursesId);
	public List<Courses> getAllCourses();
}
