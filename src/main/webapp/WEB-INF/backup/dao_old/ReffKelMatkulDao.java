package com.sofaaa.dao_old;

import java.util.List;

import com.sofa.model.kurikulum.ReffKelompokMatakuliah;

public interface ReffKelMatkulDao 
{
	void addKelompokMatakuliah(ReffKelompokMatakuliah reffKelompokMatakuliah);
	void editKelompokMatakuliah(ReffKelompokMatakuliah reffKelompokMatakuliah);
	void deleteKelompokMatakuliah(int reffKelompokMatakuliahId);
	ReffKelompokMatakuliah findReffKelompokMatakuliah(int reffKelompokMatakuliahId);
	ReffKelompokMatakuliah findReffKelompokMatakuliahName(String name);
	List<ReffKelompokMatakuliah> getAllReffKelompokMatakuliah();
}
