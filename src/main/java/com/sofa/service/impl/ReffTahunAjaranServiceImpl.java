package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofa.model.stimb2.ReffTahunAjaran;
import com.sofa.dao.ReffTahunAjaranDao;
import com.sofa.service.ReffTahunAjaranService;

@Service
public class ReffTahunAjaranServiceImpl implements ReffTahunAjaranService {
	
	@Autowired
	private ReffTahunAjaranDao reffTahunAjaranDao;
	
	@Transactional
	public void add(ReffTahunAjaran reffTahunAjaran)
	{
		reffTahunAjaranDao.addReffTahunAjaran(reffTahunAjaran);
	}

	@Transactional
	public void edit(ReffTahunAjaran reffTahunAjaran)
	{
		reffTahunAjaranDao.editReffTahunAjaran(reffTahunAjaran);
	}

	@Transactional
	public void delete(int reffTahunAjaranId)
	{
		reffTahunAjaranDao.deleteReffTahunAjaran(reffTahunAjaranId);
	}

	@Transactional
	public ReffTahunAjaran getReffTahunAjaran(int reffTahunAjaranId)
	{
		return reffTahunAjaranDao.findReffTahunAjaran(reffTahunAjaranId);
	}

	@Transactional
	public List<ReffTahunAjaran> getAllReffTahunAjaran() 
	{
		return reffTahunAjaranDao.getAllReffTahunAjaran();
	}

	@Transactional
	public List<ReffTahunAjaran> getAllReffTahunAjaranByAktivasi(boolean param) 
	{
		return reffTahunAjaranDao.getAllReffTahunAjaranByAktivasi(param);
	}

}
