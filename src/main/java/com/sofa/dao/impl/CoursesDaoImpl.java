package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sofa.dao.CoursesDao;
import com.sofa.model.courses.Curriculum;
import com.sofa.model.courses.Courses;

@Repository
public class CoursesDaoImpl implements CoursesDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Courses courses)
	{
		session.getCurrentSession().save(courses.getCurriculum());
		session.getCurrentSession().save(courses);
	}

	@Override
	public void edit(Courses courses)
	{	
		courses.getCurriculum().setId(courses.getCurriculum().getId());
		session.getCurrentSession().update(courses.getCurriculum());
		
		session.getCurrentSession().update(courses);	
	}

	@Override
	public void delete(int coursesId)
	{		
		session.getCurrentSession().delete((Curriculum)session.getCurrentSession().get(Curriculum.class, getCourses(coursesId).getCurriculum().getId()));
		session.getCurrentSession().delete((Courses)session.getCurrentSession().get(Courses.class, coursesId));
	}

	@Override
	public Courses getCourses(int coursesId)
	{
		return (Courses)session.getCurrentSession().get(Courses.class, coursesId);
	}

	@Override
	public List getAllCourses() 
	{
		//return session.getCurrentSession().createQuery("from Student").list();
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(Courses.class);
		
		return critSelectedResumes.list();
	}

}
