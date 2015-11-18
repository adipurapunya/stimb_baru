package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ListPrequisiteMatakuliah;

public interface ListPrequisiteService
{
	public void add(ListPrequisiteMatakuliah listPrequisiteMatakuliah);
	public void edit(ListPrequisiteMatakuliah listPrequisiteMatakuliah);
	public void delete(int listPrequisiteMatakuliahId);
	public ListPrequisiteMatakuliah find(int listPrequisiteMatakuliahId);
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliah();
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahById(int id);
	public List<ListPrequisiteMatakuliah> getAllListPrequisiteMatakuliahByIdMatkul(Long id);
}
