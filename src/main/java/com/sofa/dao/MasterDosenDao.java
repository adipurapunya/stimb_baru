package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.MasterDosen;

public interface MasterDosenDao 
{
	public void add(MasterDosen masterDosen);
	public void edit(MasterDosen masterDosen);
	public void delete(int masterDosenId);
	public MasterDosen getMasterDosen(int masterDosenId);
	public MasterDosen getMasterDosenByName(String name);
	public List<MasterDosen> getAllMasterDosen();
}
