package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.ListInstrumentMayor;
import com.sofa.dao.ListInstrumentMayorDao;
import com.sofa.service.ListIntrumentMayorService;


@Service
public class ListInstrumentMayorServiceImpl implements ListIntrumentMayorService {
	
	@Autowired
	private ListInstrumentMayorDao listInstrumentMayorDao;
	
	@Transactional
	public void add(ListInstrumentMayor listInstrumentMayor)
	{
		listInstrumentMayorDao.add(listInstrumentMayor);
	}

	@Transactional
	public void edit(ListInstrumentMayor listInstrumentMayor)
	{
		listInstrumentMayorDao.edit(listInstrumentMayor);
	}

	@Transactional
	public void delete(int listInstrumentMayorId)
	{
		listInstrumentMayorDao.delete(listInstrumentMayorId);
	}

	@Transactional
	public ListInstrumentMayor getListInstrumentMayor(int listInstrumentMayorId)
	{
		return listInstrumentMayorDao.find(listInstrumentMayorId);
	}

	@Transactional
	public List getAllListInstrumentMayor() 
	{
		return listInstrumentMayorDao.getAllListInstrumentMayor();
	}

	@Transactional
	public List<ListInstrumentMayor> getAllListInstrumentMayorId(int listInstrumentMayorId)
	{
		return listInstrumentMayorDao.getAllListInstrumentMayorId(listInstrumentMayorId);
	}

	@Transactional
	public List<ListInstrumentMayor> getAllListInstrumentMayorByMatkulId(int matkulId) 
	{
		return listInstrumentMayorDao.getAllListInstrumentMayorByIdMatkul(matkulId);
	}

}
