package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ListMatakuliah;

public interface ListMatkulService
{
	public void add(ListMatakuliah listMatakuliah);
	public void edit(ListMatakuliah listMatakuliah);
	public void delete(int listMatakuliahId);
	public ListMatakuliah getListMatakuliah(int listMatakuliahId);
	public List getAllListMatakuliah();
	List<ListMatakuliah> getAllListMatakuliahByIdKurikulum(int kurikulumId);
	List<ListMatakuliah> getAllListMatakuliahById(int Id);
}
