package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ListPrequisiteMatakuliah;

public interface ListPrrekuisiteDao 
{
	void add(ListPrequisiteMatakuliah listPrequisiteMatakuliah);
	void edit(ListPrequisiteMatakuliah listPrequisiteMatakuliah);
	void delete(int listPrequisiteMatakuliahId);
	ListPrequisiteMatakuliah find(int listPrequisiteMatakuliahId);
	List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliah();
	List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahById(int id);
	List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahByIdMatkul(Long id);
}
