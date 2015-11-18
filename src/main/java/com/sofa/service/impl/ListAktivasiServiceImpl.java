package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.ListPrequisiteMatakuliah;
import com.sofa.dao.ListPrrekuisiteDao;
import com.sofa.service.ListPrequisiteService;


@Service
public class ListAktivasiServiceImpl implements ListPrequisiteService {
	
	@Autowired
	private ListPrrekuisiteDao listPrrekuisiteDao;
	
	@Transactional
	public void add(ListPrequisiteMatakuliah listPrequisiteMatakuliah)
	{
		listPrrekuisiteDao.add(listPrequisiteMatakuliah);
	}

	@Transactional
	public void edit(ListPrequisiteMatakuliah listPrequisiteMatakuliah)
	{
		listPrrekuisiteDao.edit(listPrequisiteMatakuliah);
	}

	@Transactional
	public void delete(int listPrequisiteMatakuliahId)
	{
		listPrrekuisiteDao.delete(listPrequisiteMatakuliahId);
	}

	@Transactional
	public ListPrequisiteMatakuliah getListMatakuliah(int listPrequisiteMatakuliahId)
	{
		return listPrrekuisiteDao.find(listPrequisiteMatakuliahId);
	}

	@Transactional
	public List getAllListPrequisiteMatakuliah() 
	{
		return listPrrekuisiteDao.getAllListPrequisiteMatakuliah();
	}

	@Transactional
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahById(int Id) 
	{
		return listPrrekuisiteDao.getAllListPrequisiteMatakuliahById(Id);
	}

	@Transactional
	public ListPrequisiteMatakuliah find(int listPrequisiteMatakuliahId) 
	{
		return listPrrekuisiteDao.find(listPrequisiteMatakuliahId);
	}

	@Transactional
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahByIdMatkul(Long id)
	{
		return listPrrekuisiteDao.getAllListPrequisiteMatakuliahByIdMatkul(id);
	}
}
