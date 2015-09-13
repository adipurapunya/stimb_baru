package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.LecturerDao;
import com.sofa.model.lecturer.Lecturer;
import com.sofa.model.lecturer.DetailLecturer;
import com.sofa.model.lecturer.EducationLecturer;
import com.sofa.model.lecturer.AddressLecturer;

@Repository
public class LecturerDaoImpl implements LecturerDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Lecturer lecturer)
	{
		session.getCurrentSession().save(lecturer.getEducationLecturer());
		session.getCurrentSession().save(lecturer.getDetailLecturer());
		session.getCurrentSession().save(lecturer.getAddressLecturer());
		session.getCurrentSession().save(lecturer);
	}

	@Override
	public void edit(Lecturer lecturer)
	{
		lecturer.getEducationLecturer().setId(lecturer.getEducationLecturer().getId());		
		session.getCurrentSession().update(lecturer.getEducationLecturer());
	
		lecturer.getDetailLecturer().setId(lecturer.getDetailLecturer().getId());
		session.getCurrentSession().update(lecturer.getDetailLecturer());
		
		lecturer.getAddressLecturer().setId(lecturer.getDetailLecturer().getId());
		session.getCurrentSession().update(lecturer.getDetailLecturer());
			
		session.getCurrentSession().update(lecturer);	
	}

	@Override
	public void delete(int lecturerId)
	{		
		session.getCurrentSession().delete((DetailLecturer)session.getCurrentSession().get(DetailLecturer.class, getLecturer(lecturerId).getDetailLecturer().getId()));
		session.getCurrentSession().delete((EducationLecturer)session.getCurrentSession().get(EducationLecturer.class, getLecturer(lecturerId).getEducationLecturer().getId()));
		session.getCurrentSession().delete((AddressLecturer)session.getCurrentSession().get(AddressLecturer.class, getLecturer(lecturerId).getAddressLecturer().getId()));
	
		session.getCurrentSession().delete((Lecturer)session.getCurrentSession().get(Lecturer.class, lecturerId));
	}

	@Override
	public Lecturer getLecturer(int lecturerId)
	{
		return (Lecturer)session.getCurrentSession().get(Lecturer.class, lecturerId);
	}

	@Override
	public List getAllLecturer() 
	{
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(Lecturer.class);
		
		return critSelectedResumes.list();
	}

}
