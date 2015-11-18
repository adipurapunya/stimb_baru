package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.model.stimb2.*;
import com.sofa.dao.MasterMahasiswaDao;

@Repository
public class MasterMahasiswaDaoImpl implements MasterMahasiswaDao{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(MasterMahasiswa masterMahasiswa) 
	{
		session.getCurrentSession().save(masterMahasiswa.getMahasiswaDataAsalPendidikan());
		session.getCurrentSession().save(masterMahasiswa.getMahasiswaDataKeluarga());
		session.getCurrentSession().save(masterMahasiswa.getMahasiswaDetaill());
		session.getCurrentSession().save(masterMahasiswa.getMahasiswaDataWali());
		session.getCurrentSession().save(masterMahasiswa.getStatusMahasiswa());
		session.getCurrentSession().save(masterMahasiswa);
	}

	@Override
	public void edit(MasterMahasiswa masterMahasiswa) 
	{
		session.getCurrentSession().update(masterMahasiswa.getMahasiswaDataAsalPendidikan());
		session.getCurrentSession().update(masterMahasiswa.getMahasiswaDataKeluarga());
		session.getCurrentSession().update(masterMahasiswa.getMahasiswaDetaill());
		session.getCurrentSession().update(masterMahasiswa.getMahasiswaDataWali());
		session.getCurrentSession().update(masterMahasiswa.getStatusMahasiswa());
		session.getCurrentSession().update(masterMahasiswa);
	}

	@Override
	public void delete(int masterMahasiswaId)
	{
		MasterMahasiswa mhs = getMasterMahasiswa(masterMahasiswaId);
		Long id1 = mhs.getMahasiswaDataAsalPendidikan().getId();
		Long id2 = mhs.getMahasiswaDataKeluarga().getId();
		Long id3 = mhs.getMahasiswaDataWali().getId();
		Long id4 = mhs.getMahasiswaDetaill().getId();
		Long id5= mhs.getStatusMahasiswa().getId();
		
		session.getCurrentSession().delete(getMasterMahasiswa(masterMahasiswaId));
		session.getCurrentSession().delete((MahasiswaDataAsalPendidikan) session.getCurrentSession().get(MahasiswaDataAsalPendidikan.class, id1));
		session.getCurrentSession().delete((MahasiswaDataKeluarga) session.getCurrentSession().get(MahasiswaDataKeluarga.class, id2));
		session.getCurrentSession().delete((MahasiswaDataWali) session.getCurrentSession().get(MahasiswaDataWali.class, id3));
		session.getCurrentSession().delete((MahasiswaDetaill) session.getCurrentSession().get(MahasiswaDetaill.class, id4));
		session.getCurrentSession().delete((StatusMahasiswa) session.getCurrentSession().get(StatusMahasiswa.class, id5));

	}

	@Override
	public MasterMahasiswa getMasterMahasiswa(int masterMahasiswaId)
	{
		return (MasterMahasiswa) session.getCurrentSession().get(MasterMahasiswa.class, Long.parseLong(String.valueOf(masterMahasiswaId)));
	}

	@Override
	public MasterMahasiswa getMasterMahasiswaByName(String name)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(MasterMahasiswa.class);
		criteria.add(Restrictions.eq("nama", name));		
		return (MasterMahasiswa) criteria.uniqueResult();
	}

	@Override
	public List<MasterMahasiswa> getAllMasterMahasiswa()
	{
		return session.getCurrentSession().createQuery("from MasterMahasiswa").list();
	}

	@Override
	public List<MasterMahasiswa> getMasterMahasiswaByNim(String nim) {
		Criteria criteria = session.getCurrentSession().createCriteria(MasterMahasiswa.class);
		criteria.add(Restrictions.eq("npm", nim));
		
		return (List<MasterMahasiswa>) criteria.list();
	}

}
