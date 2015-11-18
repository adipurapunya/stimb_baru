package com.sofa.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sofa.dao.ListDosenKelasDao;
import com.sofa.model.stimb2.ListDosenKelas;

@Repository
public class ListDosenKelasDaoImpl implements ListDosenKelasDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(ListDosenKelas listDosenKelas) 
	{
		session.getCurrentSession().save(listDosenKelas);
	}

	@Override
	public void edit(ListDosenKelas listDosenKelas) 
	{
		session.getCurrentSession().update(listDosenKelas);
	}

	@Override
	public void delete(int listDosenKelasId)
	{
		session.getCurrentSession().delete(find(listDosenKelasId));
	}

	@Override
	public ListDosenKelas find(int listDosenKelasId)
	{
		return (ListDosenKelas) session.getCurrentSession().get(ListDosenKelas.class, Long.parseLong(String.valueOf(listDosenKelasId)));
	}

	@Override
	public List<ListDosenKelas> getAllListDosenKelas()
	{
		return session.getCurrentSession().createQuery("from ListDosenKelas").list();
	}

	@Override
	public List<ListDosenKelas> getAllListDosenKelasByIdDosen(int dosenId) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListDosenKelas.class);
		criteria.add(Restrictions.eq("masterDosen.id", Long.parseLong(String.valueOf(dosenId))));		
		return (List<ListDosenKelas>) criteria.list();
	}

	@Override
	public List<ListDosenKelas> getAllListDosenKelasByIdKelas(int kelasId) 
	{
		Criteria criteria = session.getCurrentSession().createCriteria(ListDosenKelas.class);
		criteria.add(Restrictions.eq("kelasPerkuliahan.id", Long.parseLong(String.valueOf(kelasId))));		
		return (List<ListDosenKelas>) criteria.list();
	}

	@Override
	public void deleteByIdKelas(int listDosenKelasId) 
	{
		session.getCurrentSession().createQuery("DELETE FROM ListDosenKelas WHERE kelasPerkuliahan_id = '"+listDosenKelasId+"'").executeUpdate();
	}
	
	

}
