package com.sofaaa.service_old;

import java.util.List;

import com.sofa.model.tahunakademik.LevelAcademicYear;;

public interface LevelAcademicYearService
{
	public void add(LevelAcademicYear academicYear);
	public void edit(LevelAcademicYear academicYear);
	public void delete(int academicYearId);
	public LevelAcademicYear getYear(int academicYearId);
	public List getAllYear();
}
