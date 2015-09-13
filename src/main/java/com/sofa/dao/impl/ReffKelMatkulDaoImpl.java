package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.ReffKelMatkulDao;
import com.sofa.model.kurikulum.ReffKelompokMatakuliah;

@Repository
public class ReffKelMatkulDaoImpl implements ReffKelMatkulDao 

{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addKelompokMatakuliah(ReffKelompokMatakuliah reffKelompokMatakuliah)
	{
		session.getCurrentSession().save(reffKelompokMatakuliah);
	}

	@Override
	public void editKelompokMatakuliah(ReffKelompokMatakuliah reffKelompokMatakuliah)
	{			
		session.getCurrentSession().update(reffKelompokMatakuliah);	
	}

	@Override
	public void deleteKelompokMatakuliah(int reffKelompokMatakuliahId)
	{		
		session.getCurrentSession().delete((ReffKelompokMatakuliah)session.getCurrentSession().get(ReffKelompokMatakuliah.class, Long.parseLong(String.valueOf(reffKelompokMatakuliahId))));
	}

	@Override
	public ReffKelompokMatakuliah findReffKelompokMatakuliah(int reffKelompokMatakuliahId)
	{
		return (ReffKelompokMatakuliah)session.getCurrentSession().get(ReffKelompokMatakuliah.class, Long.parseLong(String.valueOf(reffKelompokMatakuliahId)));
	}

	@Override
	public List getAllReffKelompokMatakuliah() 
	{
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(ReffKelompokMatakuliah.class);
		
		return critSelectedResumes.list();
	}

	@Override
	public ReffKelompokMatakuliah findReffKelompokMatakuliahName(String name) 
	{
		return null;
	}

}
