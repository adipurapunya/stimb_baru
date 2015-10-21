package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.MasterKurikulum;

public interface MasterKurikulumService
{
	public void add(MasterKurikulum masterKurikulum);
	public void edit(MasterKurikulum masterKurikulum);
	public void delete(int studentId);
	public MasterKurikulum getMasterKurikulum(int masterKurikulumId);
	public List getAllMasterKurikulum();
}
