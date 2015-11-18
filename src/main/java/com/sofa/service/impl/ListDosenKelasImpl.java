package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofa.model.stimb2.ListDosenKelas;
import com.sofa.dao.ListDosenKelasDao;
import com.sofa.service.ListDosenKelasService;


@Service
public class ListDosenKelasImpl implements ListDosenKelasService {
	
	@Autowired
	private ListDosenKelasDao listDosenKelasDao;
	
	@Transactional
	public void add(ListDosenKelas listDosenKelas)
	{
		listDosenKelasDao.add(listDosenKelas);
	}

	@Transactional
	public void edit(ListDosenKelas listDosenKelas)
	{
		listDosenKelasDao.edit(listDosenKelas);
	}

	@Transactional
	public void delete(int listDosenKelasId)
	{
		listDosenKelasDao.delete(listDosenKelasId);
	}

	@Transactional
	public ListDosenKelas getListDosenKelas(int listDosenKelasId)
	{
		return listDosenKelasDao.find(listDosenKelasId);
	}

	@Transactional
	public List getAllListDosenKelas() 
	{
		return listDosenKelasDao.getAllListDosenKelas();
	}

	@Transactional
	public List<ListDosenKelas> getAllListDosenKelasByIdDosen(int dosenId)
	{
		return listDosenKelasDao.getAllListDosenKelasByIdDosen(dosenId);
	}

	@Transactional
	public List<ListDosenKelas> getAllListDosenKelasByIdKelas(int kelasId) 
	{
		return listDosenKelasDao.getAllListDosenKelasByIdKelas(kelasId);
	}

	@Transactional
	public void deleteByIdKelas(int listDosenKelasId)
	{
		listDosenKelasDao.deleteByIdKelas(listDosenKelasId);
	}

}
