package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sofa.dao.ListAktivasiDao;
import com.sofa.model.stimb2.ListSemesterPerkuliahan;

@Repository
public class ListAktivasiDaoImpl implements ListAktivasiDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(ListSemesterPerkuliahan listSemesterPerkuliahan) 
	{
		session.getCurrentSession().save(listSemesterPerkuliahan);
	}

	@Override
	public void edit(ListSemesterPerkuliahan listSemesterPerkuliahan) 
	{
		session.getCurrentSession().update(listSemesterPerkuliahan);
	}

	@Override
	public void delete(int listSemesterPerkuliahanId)
	{
		session.getCurrentSession().delete(find(listSemesterPerkuliahanId));
	}

	@Override
	public ListSemesterPerkuliahan find(int listSemesterPerkuliahanId)
	{
		return (ListSemesterPerkuliahan) session.getCurrentSession().get(ListSemesterPerkuliahan.class, Long.parseLong(String.valueOf(listSemesterPerkuliahanId)));
	}

	@Override
	public List<ListSemesterPerkuliahan> getAllListSemesterPerkuliahan()
	{
		return session.getCurrentSession().createQuery("from ListSemesterPerkuliahan").list();
	}

	@Override
	public List<ListSemesterPerkuliahan> getAllListSemesterPerkuliahanById(int id) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListSemesterPerkuliahan.class);
		criteria.add(Restrictions.eq("id", Long.parseLong(String.valueOf(id))));		
		return (List<ListSemesterPerkuliahan>) criteria.list();
	}

	@Override
	public List<ListSemesterPerkuliahan> findTrue(boolean param) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListSemesterPerkuliahan.class);
		criteria.add(Restrictions.eq("statusSemester", param));		
		return (List<ListSemesterPerkuliahan>) criteria.list();
		
 		//ListSemesterPerkuliahan a = new ListSemesterPerkuliahan();
		//a.setStatusSemester(param);
		//return (ListSemesterPerkuliahan) session.getCurrentSession().get(ListSemesterPerkuliahan.class, a.getStatusSemester());
	}
	
	

}
