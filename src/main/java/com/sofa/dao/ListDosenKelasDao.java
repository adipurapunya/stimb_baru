package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ListDosenKelas;

public interface ListDosenKelasDao 
{
	void add(ListDosenKelas listDosenKelas);
	void edit(ListDosenKelas listDosenKelas);
	void delete(int listDosenKelasId);
	void deleteByIdKelas(int listDosenKelasId);
	ListDosenKelas find(int listDosenKelasId);
	List<ListDosenKelas> getAllListDosenKelas();
	List<ListDosenKelas> getAllListDosenKelasByIdDosen(int dosenId);
	List<ListDosenKelas> getAllListDosenKelasByIdKelas(int kelasid);
}
