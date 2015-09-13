package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.tahunakademik.LevelAcademicYear;
import com.sofa.service.LevelAcademicYearService;
import com.sofa.dao.LevelAcademicYearDao;

@Service
public class LevelAcademicYearServiceImpl implements LevelAcademicYearService 
{
	@Autowired
	private LevelAcademicYearDao academicYearDao;
	
	
	@Transactional
	public void add(LevelAcademicYear academicYear) 
	{
		academicYearDao.add(academicYear);
	}

	@Transactional
	public void edit(LevelAcademicYear academicYear) {
		academicYearDao.edit(academicYear);	
	}

	@Transactional
	public void delete(int academicYearId) {
		academicYearDao.delete(academicYearId);
	}

	@Transactional
	public LevelAcademicYear getYear(int academicYearId) 
	{
		return academicYearDao.getLevelAcademicYear(academicYearId);
	}

	@Transactional
	public List getAllYear() 
	{
		return academicYearDao.getAllLevelAcademicYear();
	}

}
