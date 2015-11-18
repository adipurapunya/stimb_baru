package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.Angkatan;

public interface AngkatanService
{
	public void add(Angkatan angkatan);
	public void edit(Angkatan angkatan);
	public void delete(int angkatanId);
	public Angkatan getAngkatan(int angkatanId);
	public List<Angkatan> getAllAngkatan();
	public List<Angkatan> getAllAngkatanByName(String name);
}
