package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.MasterKurikulum;
import com.sofa.dao.MasterKurikulumDao;
import com.sofa.service.MasterKurikulumService;


@Service
public class MasterKurikulumServiceImpl implements MasterKurikulumService {
	
	@Autowired
	private MasterKurikulumDao masterKurikulumDao;
	
	@Transactional
	public void add(MasterKurikulum masterKurikulum)
	{
		masterKurikulumDao.add(masterKurikulum);
	}

	@Transactional
	public void edit(MasterKurikulum masterKurikulum)
	{
		masterKurikulumDao.edit(masterKurikulum);
	}

	@Transactional
	public void delete(int masterKurikulumId)
	{
		masterKurikulumDao.delete(masterKurikulumId);
	}

	@Transactional
	public MasterKurikulum getMasterKurikulum(int masterKurikulumId)
	{
		return masterKurikulumDao.getMasterKurikulum(masterKurikulumId);
	}

	@Transactional
	public List getAllMasterKurikulum() 
	{
		return masterKurikulumDao.getAllMasterKurikulum();
	}

}
