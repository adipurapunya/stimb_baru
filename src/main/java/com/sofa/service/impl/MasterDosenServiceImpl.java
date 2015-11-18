package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.MasterDosen;
import com.sofa.dao.MasterDosenDao;
import com.sofa.service.MasterDosenService;


@Service
public class MasterDosenServiceImpl implements MasterDosenService {
	
	@Autowired
	private MasterDosenDao masterDosenDao;
	
	@Transactional
	public void add(MasterDosen masterDosen)
	{
		masterDosenDao.add(masterDosen);
	}

	@Transactional
	public void edit(MasterDosen masterDosen)
	{
		masterDosenDao.edit(masterDosen);
	}

	@Transactional
	public void delete(int masterDosenId)
	{
		masterDosenDao.delete(masterDosenId);
	}

	@Transactional
	public MasterDosen getMasterDosen(int masterDosenId)
	{
		return masterDosenDao.getMasterDosen(masterDosenId);
	}

	@Transactional
	public List getAllMasterDosen() 
	{
		return masterDosenDao.getAllMasterDosen();
	}

}
