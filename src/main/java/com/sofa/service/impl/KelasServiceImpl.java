package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofa.model.stimb2.KelasPerkuliahan;
import com.sofa.dao.KelasDao;
import com.sofa.service.KelasService;


@Service
public class KelasServiceImpl implements KelasService {
	
	@Autowired
	private KelasDao kelasDao;
	
	@Transactional
	public void add(KelasPerkuliahan kelasPerkuliahan)
	{
		kelasDao.add(kelasPerkuliahan);
	}

	@Transactional
	public void edit(KelasPerkuliahan kelasPerkuliahan)
	{
		kelasDao.edit(kelasPerkuliahan);
	}

	@Transactional
	public void delete(int kelasPerkuliahanId)
	{
		kelasDao.delete(kelasPerkuliahanId);
	}

	@Transactional
	public KelasPerkuliahan getKelasPerkuliahan(int kelasPerkuliahanId)
	{
		return kelasDao.find(kelasPerkuliahanId);
	}

	@Transactional
	public  List<KelasPerkuliahan> getAllKelasPerkuliahan() 
	{
		return kelasDao.getAllKelasPerkuliahan();
	}

	@Transactional
	public List<KelasPerkuliahan> getAllKelasPerkuliahanByIdKurikulum(int id) {
	
		return kelasDao.getAllKelasPerkuliahanByIdKurikulum(id);
	}
}
