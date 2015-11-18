package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.Angkatan;
import com.sofa.dao.AngkatanDao;
import com.sofa.service.AngkatanService;

@Service
public class AngkatanServiceImpl implements AngkatanService {
	
	@Autowired
	private AngkatanDao angkatanDao;
	
	@Transactional
	public void add(Angkatan angkatan)
	{
		angkatanDao.addAngkatan(angkatan);
	}

	@Transactional
	public void edit(Angkatan angkatan)
	{
		angkatanDao.editAngkatan(angkatan);
	}

	@Transactional
	public void delete(int angkatanId)
	{
		angkatanDao.deleteAngkatan(angkatanId);
	}

	@Transactional
	public Angkatan getAngkatan(int angkatanId)
	{
		return angkatanDao.findAngkatan(angkatanId);
	}

	@Transactional
	public List<Angkatan> getAllAngkatan() 
	{
		return angkatanDao.getAllAngkatan();
	}

	@Transactional
	public List<Angkatan> getAllAngkatanByName(String name) {
		
		return angkatanDao.findAngkatanName(name);
	}
}
