package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sofa.dao.JadwalDao;
import com.sofa.model.stimb2.ListJadwalPerkuliahan;

@Repository
public class JadwalDaoImpl implements JadwalDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(ListJadwalPerkuliahan listJadwalPerkuliahan) 
	{
		session.getCurrentSession().save(listJadwalPerkuliahan);
	}

	@Override
	public void edit(ListJadwalPerkuliahan listJadwalPerkuliahan) 
	{
		session.getCurrentSession().update(listJadwalPerkuliahan);
	}

	@Override
	public void delete(int listJadwalPerkuliahanId)
	{
		session.getCurrentSession().delete(find(listJadwalPerkuliahanId));
	}

	@Override
	public ListJadwalPerkuliahan find(int listJadwalPerkuliahanId)
	{
		return (ListJadwalPerkuliahan) session.getCurrentSession().get(ListJadwalPerkuliahan.class, Long.parseLong(String.valueOf(listJadwalPerkuliahanId)));
	}

	@Override
	public List<ListJadwalPerkuliahan> getAllListJadwalPerkuliahan()
	{
		return session.getCurrentSession().createQuery("from ListJadwalPerkuliahan").list();
	}

	@Override
	public List<ListJadwalPerkuliahan> getAllListJadwalPerkuliahanById(int id) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListJadwalPerkuliahan.class);
		criteria.add(Restrictions.eq("id", Long.parseLong(String.valueOf(id))));		
		return (List<ListJadwalPerkuliahan>) criteria.list();
	}

}
