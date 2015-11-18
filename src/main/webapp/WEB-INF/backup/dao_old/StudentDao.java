package com.sofaaa.dao_old;

import java.util.List;

import com.sofa.model.student.Student;

public interface StudentDao 
{
	public void add(Student student);
	public void edit(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();
}
