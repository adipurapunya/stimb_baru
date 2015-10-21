package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.MasterMatakuliah;
import com.sofa.dao.MasterMatkulDao;

@Repository
public class MasterMatkulDaoImpl implements MasterMatkulDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(MasterMatakuliah masterMatakuliah) 
	{
		session.getCurrentSession().save(masterMatakuliah);
	}

	@Override
	public void edit(MasterMatakuliah masterMatakuliah) 
	{
		session.getCurrentSession().update(masterMatakuliah);
	}

	@Override
	public void delete(int masterMatakuliahId)
	{
		session.getCurrentSession().delete(getMatakuliah(masterMatakuliahId));
	}

	@Override
	public MasterMatakuliah getMatakuliah(int masterMatakuliahId)
	{
		return (MasterMatakuliah) session.getCurrentSession().get(MasterMatakuliah.class, Long.parseLong(String.valueOf(masterMatakuliahId)));
	}

	@Override
	public MasterMatakuliah getMatakuliahByName(String name)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(MasterMatakuliah.class);
		criteria.add(Restrictions.eq("namaMatakuliah", name));		
		return (MasterMatakuliah) criteria.uniqueResult();
	}

	@Override
	public List<MasterMatakuliah> getAllMatakuliah()
	{
		return session.getCurrentSession().createQuery("from MasterMatakuliah").list();
	}

}
