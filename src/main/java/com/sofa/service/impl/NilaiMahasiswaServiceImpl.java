package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.NilaiMahasiswa;
import com.sofa.dao.NilaiMahasiswaDao;
import com.sofa.service.NilaiMahasiswaService;


@Service
public class NilaiMahasiswaServiceImpl implements NilaiMahasiswaService {
	
	@Autowired
	private NilaiMahasiswaDao nilaiMahasiswaDao;
	
	@Transactional
	public void add(NilaiMahasiswa nilaiMahasiswa)
	{
		nilaiMahasiswaDao.add(nilaiMahasiswa);
	}

	@Transactional
	public void edit(NilaiMahasiswa nilaiMahasiswa)
	{
		nilaiMahasiswaDao.edit(nilaiMahasiswa);
	}

	@Transactional
	public void delete(int nilaiMahasiswaId)
	{
		nilaiMahasiswaDao.delete(nilaiMahasiswaId);
	}

	@Transactional
	public NilaiMahasiswa getNilaiMahasiswa(int nilaiMahasiswaId)
	{
		return nilaiMahasiswaDao.find(nilaiMahasiswaId);
	}

	@Transactional
	public List<NilaiMahasiswa> getAllNilaiMahasiswa() 
	{
		return nilaiMahasiswaDao.getAllNilaiMahasiswa();
	}

	@Transactional
	public List<NilaiMahasiswa> getNilaiMahasiswaByMhsId(int MhsId) 
	{
		return nilaiMahasiswaDao.getNilaiMahasiswaById(MhsId);
	}	
}
