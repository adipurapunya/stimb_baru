package com.sofa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.LevelAcademicYearDao;
import com.sofa.model.tahunakademik.LevelAcademicYear;;

@Repository
public class LevelAcademicYearDaoImpl implements LevelAcademicYearDao 
{	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(LevelAcademicYear academicYear)
	{
		session.getCurrentSession().save(academicYear);
	}

	@Override
	public void edit(LevelAcademicYear academicYear) 
	{
		session.getCurrentSession().update(academicYear);
	}

	@Override
	public void delete(int id) 
	{
		session.getCurrentSession().delete((LevelAcademicYear)session.getCurrentSession().get(LevelAcademicYear.class, id));
	}

	@Override
	public LevelAcademicYear getLevelAcademicYear(int LevelYearId)
	{
		return (LevelAcademicYear)session.getCurrentSession().get(LevelAcademicYear.class, LevelYearId);
	}

	@Override
	public List<LevelAcademicYear> getAllLevelAcademicYear() 
	{	
		Criteria critSelectedResumes = session.getCurrentSession().createCriteria(LevelAcademicYear.class);
		return critSelectedResumes.list();
	}

}
