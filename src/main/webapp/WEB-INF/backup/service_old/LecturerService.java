package com.sofaaa.service_old;

import java.util.List;

import com.sofa.model.lecturer.Lecturer;

public interface LecturerService
{
	public void add(Lecturer lecturer);
	public void edit(Lecturer lecturer);
	public void delete(int lecturerId);
	public Lecturer getLecturer(int lecturerId);
	public List getAllLecturer();
}
