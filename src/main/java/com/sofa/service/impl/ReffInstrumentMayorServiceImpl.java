package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sofa.model.stimb2.ReffInstrumentMayor;
import com.sofa.dao.ReffInstrumentMayorDao;
import com.sofa.service.ReffInstrumentMayorService;

@Service
public class ReffInstrumentMayorServiceImpl implements ReffInstrumentMayorService {
	@Autowired
	private ReffInstrumentMayorDao reffMayorDao;
	
	@Transactional
	public void add(ReffInstrumentMayor reffMayor)
	{
		reffMayorDao.addReffMayor(reffMayor);
	}

	@Transactional
	public void edit(ReffInstrumentMayor reffMayor)
	{
		reffMayorDao.editReffMayor(reffMayor);
	}

	@Transactional
	public void delete(int reffMayorId)
	{
		reffMayorDao.deleteReffMayor(reffMayorId);
	}

	@Transactional
	public ReffInstrumentMayor getReffMayor(int reffMayorId)
	{
		return reffMayorDao.findReffMayor(reffMayorId);
	}

	@Transactional
	public List<ReffInstrumentMayor> getAllReffMayor() 
	{
		return reffMayorDao.getAllReffMayor();
	}

}
