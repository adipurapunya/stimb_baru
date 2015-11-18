package com.sofaaa.service_old;

import java.util.List;

import com.sofa.model.kurikulum.ReffKelompokMatakuliah;;

public interface ReffKelMatkulService
{
	public void add(ReffKelompokMatakuliah reffKelompokMatakuliah);
	public void edit(ReffKelompokMatakuliah reffKelompokMatakuliah);
	public void delete(int reffKelompokMatakuliahId);
	public ReffKelompokMatakuliah getKelompokMatakuliah(int reffKelompokMatakuliahId);
	public List getAllKelompokMatakuliah();
}
