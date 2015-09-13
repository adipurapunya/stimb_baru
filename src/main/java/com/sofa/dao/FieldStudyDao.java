package com.sofa.dao;

import java.util.List;

import com.sofa.model.fieldstudy.FieldOfStudy;

public interface FieldStudyDao 
{
	public void add(FieldOfStudy fieldOfStudy);
	public void edit(FieldOfStudy fieldOfStudy);
	public void delete(int id);
	public FieldOfStudy getfieldOfStudy(int fieldOfStudyId);
	public List<FieldOfStudy> getAllfieldOfStudy();
}
