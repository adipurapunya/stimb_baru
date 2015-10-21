package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.MasterKurikulum;
import com.sofa.dao.MasterKurikulumDao;

@Repository
public class MasterKurikulumDaoImpl implements MasterKurikulumDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(MasterKurikulum masterKurikulum) {
		session.getCurrentSession().save(masterKurikulum);
	}

	@Override
	public void edit(MasterKurikulum masterKurikulum) {
		session.getCurrentSession().update(masterKurikulum);
	}

	@Override
	public void delete(int masterKurikulumId) {
		session.getCurrentSession().delete(getMasterKurikulum(masterKurikulumId));
	}

	@Override
	public MasterKurikulum getMasterKurikulum(int masterKurikulumId) {
		return (MasterKurikulum) session.getCurrentSession().get(MasterKurikulum.class, Long.parseLong(String.valueOf(masterKurikulumId)));
	}

	@Override
	public MasterKurikulum getMasterKurikulumByName(String name)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(MasterKurikulum.class);
		criteria.add(Restrictions.eq("namaKurikulum", name));		
		return (MasterKurikulum) criteria.uniqueResult();
	}

	@Override
	public List<MasterKurikulum> getAllMasterKurikulum() {
		return session.getCurrentSession().createQuery("from MasterKurikulum").list();
	}

}
