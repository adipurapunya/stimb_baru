package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.ListMatakuliah;
import com.sofa.dao.ListMatkulDao;
import com.sofa.service.ListMatkulService;


@Service
public class ListMatkulServiceImpl implements ListMatkulService {
	
	@Autowired
	private ListMatkulDao listMatkulDao;
	
	@Transactional
	public void add(ListMatakuliah listMatakuliah)
	{
		listMatkulDao.add(listMatakuliah);
	}

	@Transactional
	public void edit(ListMatakuliah listMatakuliah)
	{
		listMatkulDao.edit(listMatakuliah);
	}

	@Transactional
	public void delete(int listMatakuliahId)
	{
		listMatkulDao.delete(listMatakuliahId);
	}

	@Transactional
	public ListMatakuliah getListMatakuliah(int listMatakuliahId)
	{
		return listMatkulDao.find(listMatakuliahId);
	}

	@Transactional
	public List getAllListMatakuliah() 
	{
		return listMatkulDao.getAllListMatakuliah();
	}

	@Transactional
	public List<ListMatakuliah> getAllListMatakuliahByIdKurikulum(int kurikulumId)
	{
		return listMatkulDao.getAllListMatakuliahByIdKurikulum(kurikulumId);
	}

	@Transactional
	public List<ListMatakuliah> getAllListMatakuliahById(int Id) 
	{
		return listMatkulDao.getAllListMatakuliahById(Id);
	}

}
