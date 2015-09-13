package com.sofa.service;

import java.util.List;

import com.sofa.model.fieldstudy.FieldOfStudy;

public interface FieldStudyService
{
	public void add(FieldOfStudy fieldOfStudy);
	public void edit(FieldOfStudy fieldOfStudy);
	public void delete(int fieldOfStudyId);
	public FieldOfStudy getfieldOfStudy(int fieldOfStudyId);
	public List getAllfieldOfStudy();
}
