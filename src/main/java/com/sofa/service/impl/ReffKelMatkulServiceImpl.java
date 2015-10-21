package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.ReffKelompokMatakuliah;
import com.sofa.dao.ReffKelMatkulDao;
import com.sofa.service.ReffKelMatkulService;

@Service
public class ReffKelMatkulServiceImpl implements ReffKelMatkulService {
	
	@Autowired
	private ReffKelMatkulDao reffKelMatkulDao;
	
	@Transactional
	public void add(ReffKelompokMatakuliah reffKelompokMatakuliah)
	{
		reffKelMatkulDao.addKelompokMatakuliah(reffKelompokMatakuliah);
	}

	@Transactional
	public void edit(ReffKelompokMatakuliah reffKelompokMatakuliah)
	{
		reffKelMatkulDao.editKelompokMatakuliah(reffKelompokMatakuliah);
	}

	@Transactional
	public void delete(int reffKelompokMatakuliahId)
	{
		reffKelMatkulDao.deleteKelompokMatakuliah(reffKelompokMatakuliahId);
	}

	@Transactional
	public ReffKelompokMatakuliah getKelompokMatakuliah(int reffKelompokMatakuliahId)
	{
		return reffKelMatkulDao.findReffKelompokMatakuliah(reffKelompokMatakuliahId);
	}

	@Transactional
	public List getAllKelompokMatakuliah() 
	{
		return reffKelMatkulDao.getAllReffKelompokMatakuliah();
	}

}
