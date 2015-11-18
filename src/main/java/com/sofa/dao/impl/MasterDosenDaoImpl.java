package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.DosenBiodata;
import com.sofa.model.stimb2.DosenDataKeluarga;
import com.sofa.model.stimb2.DosenPendidikan;
import com.sofa.model.stimb2.DosenStatus;
import com.sofa.model.stimb2.MahasiswaDataAsalPendidikan;
import com.sofa.model.stimb2.MasterDosen;
import com.sofa.dao.MasterDosenDao;

@Repository
public class MasterDosenDaoImpl implements MasterDosenDao{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(MasterDosen masterDosen) 
	{
		session.getCurrentSession().save(masterDosen.getDosenBiodata());
		session.getCurrentSession().save(masterDosen.getDosenDataKeluarga());
		session.getCurrentSession().save(masterDosen.getDosenPendidikan());
		session.getCurrentSession().save(masterDosen.getDosenStatus());
		session.getCurrentSession().save(masterDosen);
	}

	@Override
	public void edit(MasterDosen masterDosen) 
	{
		session.getCurrentSession().update(masterDosen.getDosenBiodata());
		session.getCurrentSession().update(masterDosen.getDosenDataKeluarga());
		session.getCurrentSession().update(masterDosen.getDosenPendidikan());
		session.getCurrentSession().update(masterDosen.getDosenStatus());
		session.getCurrentSession().update(masterDosen);
	}

	@Override
	public void delete(int masterDosenId)
	{
		MasterDosen dosen = getMasterDosen(masterDosenId);
		Long id1 = dosen.getDosenBiodata().getId();
		Long id2 = dosen.getDosenDataKeluarga().getId();
		Long id3 = dosen.getDosenPendidikan().getId();
		Long id4 = dosen.getDosenStatus().getId();
		
		session.getCurrentSession().delete(getMasterDosen(masterDosenId));
		session.getCurrentSession().delete((DosenBiodata) session.getCurrentSession().get(DosenBiodata.class, id1));
		session.getCurrentSession().delete((DosenDataKeluarga) session.getCurrentSession().get(DosenDataKeluarga.class, id2));
		session.getCurrentSession().delete((DosenPendidikan) session.getCurrentSession().get(DosenPendidikan.class, id3));
		session.getCurrentSession().delete((DosenStatus) session.getCurrentSession().get(DosenStatus.class, id4));
	}

	@Override
	public MasterDosen getMasterDosen(int masterDosenId)
	{
		return (MasterDosen) session.getCurrentSession().get(MasterDosen.class, Long.parseLong(String.valueOf(masterDosenId)));
	}

	@Override
	public MasterDosen getMasterDosenByName(String name)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(MasterDosen.class);
		criteria.add(Restrictions.eq("nama", name));		
		return (MasterDosen) criteria.uniqueResult();
	}

	@Override
	public List<MasterDosen> getAllMasterDosen()
	{
		return session.getCurrentSession().createQuery("from MasterDosen").list();
	}

}
