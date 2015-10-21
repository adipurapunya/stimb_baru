package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ListMatakuliah;

public interface ListMatkulDao 
{
	void add(ListMatakuliah listMatakuliah);
	void edit(ListMatakuliah listMatakuliah);
	void delete(int listMatakuliahId);
	ListMatakuliah find(int listMatakuliahId);
	List<ListMatakuliah> getAllListMatakuliah();
	List<ListMatakuliah> getAllListMatakuliahByIdKurikulum(int kurikulumId);
	List<ListMatakuliah> getAllListMatakuliahById(int id);
}
