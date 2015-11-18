package com.sofaaa.service_old;

import java.util.List;

import com.sofa.model.kurikulum.MasterMatakuliah;

public interface MasterMatkulService
{
	public void add(MasterMatakuliah masterMatakuliah);
	public void edit(MasterMatakuliah masterMatakuliah);
	public void delete(int masterMatakuliahId);
	public MasterMatakuliah getMasterMatakuliah(int masterMatakuliahId);
	public List getAllMasterMatakuliah();
}
