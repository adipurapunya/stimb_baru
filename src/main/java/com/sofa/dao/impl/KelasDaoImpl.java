package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.KelasDao;
import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.model.stimb2.KelasPerkuliahan;

@Repository
public class KelasDaoImpl implements KelasDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(KelasPerkuliahan kelasPerkuliahan) 
	{
		session.getCurrentSession().save(kelasPerkuliahan);
	}

	@Override
	public void edit(KelasPerkuliahan kelasPerkuliahan) 
	{
		session.getCurrentSession().update(kelasPerkuliahan);
	}

	@Override
	public void delete(int kelasPerkuliahanId)
	{
		session.getCurrentSession().delete(find(kelasPerkuliahanId));
	}

	@Override
	public KelasPerkuliahan find(int kelasPerkuliahanId)
	{
		return (KelasPerkuliahan) session.getCurrentSession().get(KelasPerkuliahan.class, Long.parseLong(String.valueOf(kelasPerkuliahanId)));
	}

	@Override
	public List<KelasPerkuliahan> getAllKelasPerkuliahan()
	{
		return session.getCurrentSession().createQuery("from KelasPerkuliahan").list();
	}

	@Override
	public List<KelasPerkuliahan> getAllKelasPerkuliahanByIdKurikulum(int id) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(KelasPerkuliahan.class);
		criteria.add(Restrictions.eq("masterKurikulum.id", Long.parseLong(String.valueOf(id))));		
		
		return (List<KelasPerkuliahan>) criteria.list();
	}

}
