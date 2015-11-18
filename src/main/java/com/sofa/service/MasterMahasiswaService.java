package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.MasterMahasiswa;

public interface MasterMahasiswaService
{
	public void add(MasterMahasiswa masterMahasiswa);
	public void edit(MasterMahasiswa masterMahasiswa);
	public void delete(int masterMahasiswaId);
	public MasterMahasiswa getMasterMahasiswa(int masterMahasiswaId);
	public List<MasterMahasiswa> getMasterMahasiswaByNim(String nim);
	public List<MasterMahasiswa> getAllMasterMahasiswa();
}
