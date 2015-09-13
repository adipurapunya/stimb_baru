package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.ReffMayorDao;
import com.sofa.model.kurikulum.ReffMayor;

@Repository
public class ReffMayorDaoImpl implements ReffMayorDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addReffMayor(ReffMayor reffMayor)
	{
		session.getCurrentSession().save(reffMayor);
	}

	@Override
	public void editReffMayor(ReffMayor reffMayor)
	{			
		session.getCurrentSession().update(reffMayor);	
	}

	@Override
	public void deleteReffMayor(int reffMayorId)
	{		
		session.getCurrentSession().delete((ReffMayor)session.getCurrentSession().get(ReffMayor.class, Long.parseLong(String.valueOf(reffMayorId))));
	}

	@Override
	public ReffMayor findReffMayor(int reffMayorId)
	{
		return (ReffMayor)session.getCurrentSession().get(ReffMayor.class, Long.parseLong(String.valueOf(reffMayorId)));
	}

	@Override
	public List getAllReffMayor() 
	{
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(ReffMayor.class);
		
		return critSelectedResumes.list();
	}

	@Override
	public ReffMayor findReffMayorName(String name) 
	{
		return null;
	}

}
