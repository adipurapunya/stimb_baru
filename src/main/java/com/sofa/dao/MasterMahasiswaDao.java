package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.MasterMahasiswa;

public interface MasterMahasiswaDao 
{
	public void add(MasterMahasiswa masterMahasiswa);
	public void edit(MasterMahasiswa masterMahasiswa);
	public void delete(int masterMahasiswaId);
	public MasterMahasiswa getMasterMahasiswa(int masterMahasiswaId);
	public MasterMahasiswa getMasterMahasiswaByName(String name);
	public List<MasterMahasiswa> getMasterMahasiswaByNim(String nim);
	public List<MasterMahasiswa> getAllMasterMahasiswa();
}
