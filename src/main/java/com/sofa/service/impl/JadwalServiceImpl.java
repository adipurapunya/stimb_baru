package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.ListJadwalPerkuliahan;
import com.sofa.dao.JadwalDao;
import com.sofa.service.JadwalService;


@Service
public class JadwalServiceImpl implements JadwalService {
	
	@Autowired
	private JadwalDao jadwalDao;
	
	@Transactional
	public void add(ListJadwalPerkuliahan listJadwalPerkuliahan)
	{
		jadwalDao.add(listJadwalPerkuliahan);
	}

	@Transactional
	public void edit(ListJadwalPerkuliahan listJadwalPerkuliahan)
	{
		jadwalDao.edit(listJadwalPerkuliahan);
	}

	@Transactional
	public void delete(int listJadwalPerkuliahanId)
	{
		jadwalDao.delete(listJadwalPerkuliahanId);
	}

	@Transactional
	public ListJadwalPerkuliahan getListJadwalPerkuliahan(int listJadwalPerkuliahanId)
	{
		return jadwalDao.find(listJadwalPerkuliahanId);
	}

	@Transactional
	public List getAllListJadwalPerkuliahan() 
	{
		return jadwalDao.getAllListJadwalPerkuliahan();
	}

	@Transactional
	public List<ListJadwalPerkuliahan> getAllListJadwalPerkuliahanById(int listJadwalPerkuliahanId) 
	{
		return jadwalDao.getAllListJadwalPerkuliahanById(listJadwalPerkuliahanId);
	}

	@Transactional
	public ListJadwalPerkuliahan find(int listJadwalPerkuliahanId) 
	{
		return jadwalDao.find(listJadwalPerkuliahanId);
	}

}
