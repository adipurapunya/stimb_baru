package com.sofaaa.service_old;

import java.util.List;

import com.sofa.model.kurikulum.MasterKurikulum;

public interface MasterKurikulumService
{
	public void add(MasterKurikulum masterKurikulum);
	public void edit(MasterKurikulum masterKurikulum);
	public void delete(int studentId);
	public MasterKurikulum getMasterKurikulum(int masterKurikulumId);
	public List getAllMasterKurikulum();
}
