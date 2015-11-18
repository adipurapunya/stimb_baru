package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.ListInstrumentMayorDao;
import com.sofa.model.stimb2.ListInstrumentMayor;

@Repository
public class ListInstrumentMayorDaoImpl implements ListInstrumentMayorDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(ListInstrumentMayor listInstrumentMayor) 
	{
		session.getCurrentSession().save(listInstrumentMayor);
	}

	@Override
	public void edit(ListInstrumentMayor listInstrumentMayor) 
	{
		session.getCurrentSession().update(listInstrumentMayor);
	}

	@Override
	public void delete(int listInstrumentMayorId)
	{
		session.getCurrentSession().delete(find(listInstrumentMayorId));
	}

	@Override
	public ListInstrumentMayor find(int listInstrumentMayorId)
	{
		return (ListInstrumentMayor) session.getCurrentSession().get(ListInstrumentMayor.class, Long.parseLong(String.valueOf(listInstrumentMayorId)));
	}

	@Override
	public List<ListInstrumentMayor> getAllListInstrumentMayor()
	{
		return session.getCurrentSession().createQuery("from ListInstrumentMayor").list();
	}

	@Override
	public List<ListInstrumentMayor> getAllListInstrumentMayorId(int listInstrumentMayorId) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListInstrumentMayor.class);
		criteria.add(Restrictions.eq("masterMatakuliah.id", Long.parseLong(String.valueOf(listInstrumentMayorId))));		
		return (List<ListInstrumentMayor>) criteria.list();
	}
	
	@Override
	public List<ListInstrumentMayor> getAllListInstrumentMayorByIdMatkul(int matkulId) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListInstrumentMayor.class);
		criteria.add(Restrictions.eq("masterMatakuliah.id", Long.parseLong(String.valueOf(matkulId))));		
		return (List<ListInstrumentMayor>) criteria.list();
	}

}
