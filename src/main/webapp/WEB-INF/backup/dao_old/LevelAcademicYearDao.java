package com.sofaaa.dao_old;

import java.util.List;

import com.sofa.model.tahunakademik.LevelAcademicYear;

public interface LevelAcademicYearDao 
{
	public void add(LevelAcademicYear academicYear);
	public void edit(LevelAcademicYear academicYear);
	public void delete(int id);
	public LevelAcademicYear getLevelAcademicYear(int LevelYearId);
	public List<LevelAcademicYear> getAllLevelAcademicYear();
}
