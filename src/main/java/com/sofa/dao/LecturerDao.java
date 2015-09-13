package com.sofa.dao;

import java.util.List;

import com.sofa.model.lecturer.Lecturer;

public interface LecturerDao 
{
	public void add(Lecturer lecturer);
	public void edit(Lecturer lecturer);
	public void delete(int lecturerId);
	public Lecturer getLecturer(int lecturerId);
	public List<Lecturer> getAllLecturer();
}
