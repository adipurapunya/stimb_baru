package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.MasterDosen;

public interface MasterDosenService
{
	public void add(MasterDosen masterDosen);
	public void edit(MasterDosen masterDosen);
	public void delete(int masterDosenId);
	public MasterDosen getMasterDosen(int masterDosenId);
	public List getAllMasterDosen();
}
