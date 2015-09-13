package com.sofa.dao;

import java.util.List;

import com.sofa.model.kurikulum.MasterKurikulum;

public interface MasterKurikulumDao 
{
	public void add(MasterKurikulum masterKurikulum);
	public void edit(MasterKurikulum masterKurikulum);
	public void delete(int masterKurikulumId);
	public MasterKurikulum getMasterKurikulum(int masterKurikulumId);
	public MasterKurikulum getMasterKurikulumByName(String name);
	public List<MasterKurikulum> getAllMasterKurikulum();
}
