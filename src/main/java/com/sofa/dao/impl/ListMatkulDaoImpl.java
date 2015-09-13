package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.ListMatkulDao;
import com.sofa.model.kurikulum.ListMatakuliah;
import com.sofa.model.kurikulum.MasterMatakuliah;

@Repository
public class ListMatkulDaoImpl implements ListMatkulDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(ListMatakuliah listMatakuliah) 
	{
		session.getCurrentSession().save(listMatakuliah);
	}

	@Override
	public void edit(ListMatakuliah listMatakuliah) 
	{
		session.getCurrentSession().update(listMatakuliah);
	}

	@Override
	public void delete(int listMatakuliahId)
	{
		session.getCurrentSession().delete(find(listMatakuliahId));
	}

	@Override
	public ListMatakuliah find(int listMatakuliahId)
	{
		return (ListMatakuliah) session.getCurrentSession().get(ListMatakuliah.class, Long.parseLong(String.valueOf(listMatakuliahId)));
	}

	@Override
	public List<ListMatakuliah> getAllListMatakuliah()
	{
		return session.getCurrentSession().createQuery("from ListMatakuliah").list();
	}

	@Override
	public List<ListMatakuliah> getAllListMatakuliahByIdKurikulum(int kurikulumId) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListMatakuliah.class);
		criteria.add(Restrictions.eq("masterKurikulum.id", Long.parseLong(String.valueOf(kurikulumId))));		
		return (List<ListMatakuliah>) criteria.list();
	}

}
