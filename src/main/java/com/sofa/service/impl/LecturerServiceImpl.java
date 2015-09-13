package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofa.dao.LecturerDao;
import com.sofa.model.lecturer.Lecturer;
import com.sofa.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {
	@Autowired
	private LecturerDao lecturerDao;
	
	@Transactional
	public void add(Lecturer lecturer)
	{
		lecturerDao.add(lecturer);
	}

	@Transactional
	public void edit(Lecturer lecturer)
	{
		lecturerDao.edit(lecturer);
	}

	@Transactional
	public void delete(int lecturerId)
	{
		lecturerDao.delete(lecturerId);
	}

	@Transactional
	public Lecturer getLecturer(int lecturerId)
	{
		return lecturerDao.getLecturer(lecturerId);
	}

	@Transactional
	public List getAllLecturer() 
	{
		return lecturerDao.getAllLecturer();
	}

}
