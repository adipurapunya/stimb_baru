package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.MasterMatakuliah;

public interface MasterMatkulDao 
{
	public void add(MasterMatakuliah masterMatakuliah);
	public void edit(MasterMatakuliah masterMatakuliah);
	public void delete(int masterMatakuliahId);
	public MasterMatakuliah getMatakuliah(int masterMatakuliahId);
	public MasterMatakuliah getMatakuliahByName(String name);
	public List<MasterMatakuliah> getAllMatakuliah();
}
