package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.MasterMahasiswa;
import com.sofa.dao.MasterMahasiswaDao;
import com.sofa.service.MasterMahasiswaService;


@Service
public class MasterMahasiswaServiceImpl implements MasterMahasiswaService {
	
	@Autowired
	private MasterMahasiswaDao masterMahasiswaDao;
	
	@Transactional
	public void add(MasterMahasiswa masterMahasiswa)
	{
		masterMahasiswaDao.add(masterMahasiswa);
	}

	@Transactional
	public void edit(MasterMahasiswa masterMahasiswa)
	{
		masterMahasiswaDao.edit(masterMahasiswa);
	}

	@Transactional
	public void delete(int masterMahasiswaId)
	{
		masterMahasiswaDao.delete(masterMahasiswaId);
	}

	@Transactional
	public MasterMahasiswa getMasterMahasiswa(int masterMahasiswaId)
	{
		return masterMahasiswaDao.getMasterMahasiswa(masterMahasiswaId);
	}

	@Transactional
	public List getAllMasterMahasiswa() 
	{
		return masterMahasiswaDao.getAllMasterMahasiswa();
	}

	@Transactional
	public List<MasterMahasiswa> getMasterMahasiswaByNim(String nim) {
		
		return masterMahasiswaDao.getMasterMahasiswaByNim(nim);
	}

}
