package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ListDosenKelas;

public interface ListDosenKelasService
{
	public void add(ListDosenKelas listDosenKelas);
	public void edit(ListDosenKelas listDosenKelas);
	public void delete(int listDosenKelasId);
	public void deleteByIdKelas(int listDosenKelasId);
	public ListDosenKelas getListDosenKelas(int listDosenKelasId);
	public List<ListDosenKelas> getAllListDosenKelas();
	public List<ListDosenKelas> getAllListDosenKelasByIdDosen(int dosenId);
	public List<ListDosenKelas> getAllListDosenKelasByIdKelas(int kelasId);
}
