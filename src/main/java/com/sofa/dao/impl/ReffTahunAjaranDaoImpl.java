package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.ReffTahunAjaranDao;
import com.sofa.model.stimb2.ReffTahunAjaran;

@Repository
public class ReffTahunAjaranDaoImpl implements  ReffTahunAjaranDao {
	
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addReffTahunAjaran(ReffTahunAjaran reffTahunAjaran) 
	{
		session.getCurrentSession().save(reffTahunAjaran);
	}

	@Override
	public void editReffTahunAjaran(ReffTahunAjaran reffTahunAjaran) 
	{
		session.getCurrentSession().update(reffTahunAjaran);
	}

	@Override
	public void deleteReffTahunAjaran(int reffTahunAjaranId) {
		session.getCurrentSession().delete(findReffTahunAjaran(reffTahunAjaranId));
	}

	@Override
	public ReffTahunAjaran findReffTahunAjaran(int reffTahunAjaranId) {
		return (ReffTahunAjaran) session.getCurrentSession().get(ReffTahunAjaran.class, Long.parseLong(String.valueOf(reffTahunAjaranId)));
	}

	@Override
	public ReffTahunAjaran findReffTahunAjaranByName(String name)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ReffTahunAjaran.class);
		criteria.add(Restrictions.eq("namaTahunAjaran", name));		
		return (ReffTahunAjaran) criteria.uniqueResult();
	}

	@Override
	public List<ReffTahunAjaran> getAllReffTahunAjaran() {
		return session.getCurrentSession().createQuery("from ReffTahunAjaran").list();
	}

	@Override
	public List<ReffTahunAjaran> getAllReffTahunAjaranByAktivasi(boolean indikator) {
		Criteria criteria = session.getCurrentSession().createCriteria(ReffTahunAjaran.class);
		criteria.add(Restrictions.eq("aktivasi", indikator));		
		return (List<ReffTahunAjaran>) criteria.list();
	}

}
