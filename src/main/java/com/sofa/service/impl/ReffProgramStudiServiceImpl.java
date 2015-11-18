package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sofa.model.stimb2.ReffProgramStudi;
import com.sofa.dao.ReffProgramStudiDao;
import com.sofa.service.ReffProgramStudiService;

@Service
public class ReffProgramStudiServiceImpl implements ReffProgramStudiService {
	@Autowired
	private ReffProgramStudiDao reffProgramStudiDao;
	
	@Transactional
	public void add(ReffProgramStudi reffProgramStudi)
	{
		reffProgramStudiDao.addReffProgramStudi(reffProgramStudi);
	}

	@Transactional
	public void edit(ReffProgramStudi reffProgramStudi)
	{
		reffProgramStudiDao.editReffProgramStudi(reffProgramStudi);
	}

	@Transactional
	public void delete(int reffProgramStudiId)
	{
		reffProgramStudiDao.deleteReffProgramStudi(reffProgramStudiId);
	}

	@Transactional
	public ReffProgramStudi getReffProgramStudi(int reffProgramStudiId)
	{
		return reffProgramStudiDao.findReffProgramStudi(reffProgramStudiId);
	}

	@Transactional
	public List getAllReffProgramStudi() 
	{
		return reffProgramStudiDao.getAllReffProgramStudi();
	}

}
