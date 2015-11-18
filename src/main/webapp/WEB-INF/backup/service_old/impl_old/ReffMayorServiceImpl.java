package com.sofaaa.service_old.impl_old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sofa.model.kurikulum.ReffMayor;
import com.sofaaa.dao_old.ReffMayorDao;
import com.sofaaa.service_old.ReffMayorService;

@Service
public class ReffMayorServiceImpl implements ReffMayorService {
	@Autowired
	private ReffMayorDao reffMayorDao;
	
	@Transactional
	public void add(ReffMayor reffMayor)
	{
		reffMayorDao.addReffMayor(reffMayor);
	}

	@Transactional
	public void edit(ReffMayor reffMayor)
	{
		reffMayorDao.editReffMayor(reffMayor);
	}

	@Transactional
	public void delete(int reffMayorId)
	{
		reffMayorDao.deleteReffMayor(reffMayorId);
	}

	@Transactional
	public ReffMayor getReffMayor(int reffMayorId)
	{
		return reffMayorDao.findReffMayor(reffMayorId);
	}

	@Transactional
	public List getAllReffMayor() 
	{
		return reffMayorDao.getAllReffMayor();
	}

}
