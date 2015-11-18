package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.NilaiMahasiswaDao;
import com.sofa.model.stimb2.NilaiMahasiswa;

@Repository
public class NilaiMahasiswaDaoImpl implements NilaiMahasiswaDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(NilaiMahasiswa nilaiMahasiswa) 
	{
		session.getCurrentSession().save(nilaiMahasiswa);
	}

	@Override
	public void edit(NilaiMahasiswa nilaiMahasiswa) 
	{
		session.getCurrentSession().update(nilaiMahasiswa);
	}

	@Override
	public void delete(int nilaiMahasiswaId)
	{
		session.getCurrentSession().delete(find(nilaiMahasiswaId));
	}

	@Override
	public NilaiMahasiswa find(int nilaiMahasiswaId)
	{
		return (NilaiMahasiswa) session.getCurrentSession().get(NilaiMahasiswa.class, Long.parseLong(String.valueOf(nilaiMahasiswaId)));
	}

	@Override
	public List<NilaiMahasiswa> getAllNilaiMahasiswa()
	{
		return session.getCurrentSession().createQuery("from NilaiMahasiswa").list();
	}
	
	@Override
	public List<NilaiMahasiswa> getNilaiMahasiswaById(int MhsId)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(NilaiMahasiswa.class);
		criteria.add(Restrictions.eq("id", Long.parseLong(String.valueOf(MhsId))));		
		return (List<NilaiMahasiswa>) criteria.list();
	}
	
	
}
