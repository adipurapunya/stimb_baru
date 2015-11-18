package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.ListSemesterPerkuliahan;
import com.sofa.dao.ListAktivasiDao;
import com.sofa.service.ListAktivasiService;


@Service
public class ListPrequisiteServiceImpl implements ListAktivasiService {
	
	@Autowired
	private ListAktivasiDao listAktivasiDao;
	
	@Transactional
	public void add(ListSemesterPerkuliahan listSemesterPerkuliahan)
	{
		listAktivasiDao.add(listSemesterPerkuliahan);
	}

	@Transactional
	public void edit(ListSemesterPerkuliahan listSemesterPerkuliahan)
	{
		listAktivasiDao.edit(listSemesterPerkuliahan);
	}

	@Transactional
	public void delete(int listSemesterPerkuliahanId)
	{
		listAktivasiDao.delete(listSemesterPerkuliahanId);
	}

	@Transactional
	public ListSemesterPerkuliahan getListMatakuliah(int listSemesterPerkuliahanId)
	{
		return listAktivasiDao.find(listSemesterPerkuliahanId);
	}

	@Transactional
	public List getAllListSemesterPerkuliahan() 
	{
		return listAktivasiDao.getAllListSemesterPerkuliahan();
	}

	@Transactional
	public List<ListSemesterPerkuliahan> getAllListSemesterPerkuliahanById(int Id) 
	{
		return listAktivasiDao.getAllListSemesterPerkuliahanById(Id);
	}

	@Transactional
	public List<ListSemesterPerkuliahan> findTrue(boolean param) {
		// TODO Auto-generated method stub
		return listAktivasiDao.findTrue(param);
	}

}
