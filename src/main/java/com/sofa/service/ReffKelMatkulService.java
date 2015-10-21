package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ReffKelompokMatakuliah;;

public interface ReffKelMatkulService
{
	public void add(ReffKelompokMatakuliah reffKelompokMatakuliah);
	public void edit(ReffKelompokMatakuliah reffKelompokMatakuliah);
	public void delete(int reffKelompokMatakuliahId);
	public ReffKelompokMatakuliah getKelompokMatakuliah(int reffKelompokMatakuliahId);
	public List getAllKelompokMatakuliah();
}
