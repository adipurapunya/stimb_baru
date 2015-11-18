package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.ReffInstrumentMayor;
import com.sofa.dao.ReffInstrumentMayorDao;

@Repository
public class ReffInstrumentMayorDaoImpl implements ReffInstrumentMayorDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addReffMayor(ReffInstrumentMayor reffMayor)
	{
		session.getCurrentSession().save(reffMayor);
	}

	@Override
	public void editReffMayor(ReffInstrumentMayor reffMayor)
	{			
		session.getCurrentSession().update(reffMayor);	
	}

	@Override
	public void deleteReffMayor(int reffMayorId)
	{		
		session.getCurrentSession().delete((ReffInstrumentMayor)session.getCurrentSession().get(ReffInstrumentMayor.class, Long.parseLong(String.valueOf(reffMayorId))));
	}

	@Override
	public ReffInstrumentMayor findReffMayor(int reffMayorId)
	{
		return (ReffInstrumentMayor)session.getCurrentSession().get(ReffInstrumentMayor.class, Long.parseLong(String.valueOf(reffMayorId)));
	}

	@Override
	public List<ReffInstrumentMayor> getAllReffMayor() 
	{
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(ReffInstrumentMayor.class);
		
		return critSelectedResumes.list();
	}

	@Override
	public ReffInstrumentMayor findReffMayorName(String name) 
	{
		return null;
	}

}
