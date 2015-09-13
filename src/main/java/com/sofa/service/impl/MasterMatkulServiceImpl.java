package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.dao.MasterMatkulDao;
import com.sofa.model.kurikulum.MasterMatakuliah;
import com.sofa.service.MasterMatkulService;


@Service
public class MasterMatkulServiceImpl implements MasterMatkulService {
	
	@Autowired
	private MasterMatkulDao masterMatkulDao;
	
	@Transactional
	public void add(MasterMatakuliah masterMatakuliah)
	{
		masterMatkulDao.add(masterMatakuliah);
	}

	@Transactional
	public void edit(MasterMatakuliah masterMatakuliah)
	{
		masterMatkulDao.edit(masterMatakuliah);
	}

	@Transactional
	public void delete(int masterMatakuliahId)
	{
		masterMatkulDao.delete(masterMatakuliahId);
	}

	@Transactional
	public MasterMatakuliah getMasterMatakuliah(int masterMatakuliahId)
	{
		return masterMatkulDao.getMatakuliah(masterMatakuliahId);
	}

	@Transactional
	public List getAllMasterMatakuliah() 
	{
		return masterMatkulDao.getAllMatakuliah();
	}

}
