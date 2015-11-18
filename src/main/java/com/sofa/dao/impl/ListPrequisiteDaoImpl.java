package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sofa.dao.ListPrrekuisiteDao;
import com.sofa.model.stimb2.ListPrequisiteMatakuliah;

@Repository
public class ListPrequisiteDaoImpl implements ListPrrekuisiteDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(ListPrequisiteMatakuliah listPrequisiteMatakuliah) 
	{
		session.getCurrentSession().save(listPrequisiteMatakuliah);
	}

	@Override
	public void edit(ListPrequisiteMatakuliah listPrequisiteMatakuliah) 
	{
		session.getCurrentSession().update(listPrequisiteMatakuliah);
	}

	@Override
	public void delete(int listPrequisiteMatakuliahId)
	{
		session.getCurrentSession().delete(find(listPrequisiteMatakuliahId));
	}

	@Override
	public ListPrequisiteMatakuliah find(int listPrequisiteMatakuliahId)
	{
		return (ListPrequisiteMatakuliah) session.getCurrentSession().get(ListPrequisiteMatakuliah.class, Long.parseLong(String.valueOf(listPrequisiteMatakuliahId)));
	}

	@Override
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliah()
	{
		return session.getCurrentSession().createQuery("from ListPrequisiteMatakuliah").list();
	}

	@Override
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahById(int id) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListPrequisiteMatakuliah.class);
		criteria.add(Restrictions.eq("id", Long.parseLong(String.valueOf(id))));		
		return (List<ListPrequisiteMatakuliah>) criteria.list();
	}

	@Override
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahByIdMatkul(Long id) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListPrequisiteMatakuliah.class);
		criteria.add(Restrictions.eq("masterMatakuliah.id", id));		
		return (List<ListPrequisiteMatakuliah>) criteria.list();
	}

}
