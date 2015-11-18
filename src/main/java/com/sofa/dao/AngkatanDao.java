package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.Angkatan;

public interface AngkatanDao 
{
	void addAngkatan(Angkatan angkatan);
	void editAngkatan(Angkatan angkatan);
	void deleteAngkatan(int angkatanId);
	Angkatan findAngkatan(int angkatanId);
	List<Angkatan> findAngkatanName(String name);
	List<Angkatan> getAllAngkatan();
}
