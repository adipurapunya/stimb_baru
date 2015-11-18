package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.Angkatan;
import com.sofa.dao.AngkatanDao;

@Repository
public class AngkatanDaoImpl implements AngkatanDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addAngkatan(Angkatan angkatan)
	{
		session.getCurrentSession().save(angkatan);
	}

	@Override
	public void editAngkatan(Angkatan angkatan)
	{			
		session.getCurrentSession().update(angkatan);	
	}

	@Override
	public void deleteAngkatan(int angkatanId)
	{		
		session.getCurrentSession().delete((Angkatan)session.getCurrentSession().get(Angkatan.class, Long.parseLong(String.valueOf(angkatanId))));
	}

	@Override
	public Angkatan findAngkatan(int angkatanId)
	{
		return (Angkatan)session.getCurrentSession().get(Angkatan.class, Long.parseLong(String.valueOf(angkatanId)));
	}

	@Override
	public List<Angkatan> getAllAngkatan() 
	{
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(Angkatan.class);
		
		return critSelectedResumes.list();
	}

	@Override
	public List<Angkatan> findAngkatanName(String name) 
	{
		return null;
	}

}
