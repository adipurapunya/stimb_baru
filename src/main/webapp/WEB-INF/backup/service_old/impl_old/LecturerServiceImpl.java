package com.sofaaa.service_old.impl_old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.lecturer.Lecturer;
import com.sofaaa.dao_old.LecturerDao;
import com.sofaaa.service_old.LecturerService;

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
