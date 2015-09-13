package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.FieldStudyDao;
import com.sofa.model.fieldstudy.FieldOfStudy;;

@Repository
public class FieldStudyDaoImpl implements FieldStudyDao 
{	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(FieldOfStudy fieldOfStudy)
	{
		session.getCurrentSession().save(fieldOfStudy);
	}

	@Override
	public void edit(FieldOfStudy fieldOfStudy) 
	{
		session.getCurrentSession().update(fieldOfStudy);
	}

	@Override
	public void delete(int id) 
	{
		session.getCurrentSession().delete((FieldOfStudy)session.getCurrentSession().get(FieldOfStudy.class, id));
	}

	@Override
	public FieldOfStudy getfieldOfStudy(int fieldOfStudyId)
	{
		return (FieldOfStudy)session.getCurrentSession().get(FieldOfStudy.class, fieldOfStudyId);
	}

	@Override
	public List<FieldOfStudy> getAllfieldOfStudy() 
	{	
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(FieldOfStudy.class);
		return critSelectedResumes.list();
	}

}
