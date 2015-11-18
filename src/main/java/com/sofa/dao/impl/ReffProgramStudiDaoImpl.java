package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.ListSemesterPerkuliahan;
import com.sofa.model.stimb2.ReffProgramStudi;
import com.sofa.model.stimb2.ReffTahunAjaran;
import com.sofa.dao.ReffProgramStudiDao;

@Repository
public class ReffProgramStudiDaoImpl implements ReffProgramStudiDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addReffProgramStudi(ReffProgramStudi reffProgramStudi) {
		session.getCurrentSession().save(reffProgramStudi);
	}

	@Override
	public void editReffProgramStudi(ReffProgramStudi reffProgramStudi) {
		session.getCurrentSession().update(reffProgramStudi);
	}

	@Override
	public void deleteReffProgramStudi(int reffProgramStudiId) {
		session.getCurrentSession().delete(findReffProgramStudi(reffProgramStudiId));
	}

	@Override
	public ReffProgramStudi findReffProgramStudi(int reffProgramStudiId) {
		return (ReffProgramStudi) session.getCurrentSession().get(ReffProgramStudi.class, Long.parseLong(String.valueOf(reffProgramStudiId)));
	}

	@Override
	public ReffProgramStudi findReffProgramStudiByName(String name)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ReffProgramStudi.class);
		criteria.add(Restrictions.eq("namaProgramStudi", name));		
		return (ReffProgramStudi) criteria.uniqueResult();
	}

	@Override
	public List<ReffProgramStudi> getAllReffProgramStudi() {
		return session.getCurrentSession().createQuery("from ReffProgramStudi").list();
	}

}
