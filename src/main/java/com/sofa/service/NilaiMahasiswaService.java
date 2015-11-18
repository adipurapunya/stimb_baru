package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.NilaiMahasiswa;

public interface NilaiMahasiswaService
{
	public void add(NilaiMahasiswa nilaiMahasiswa);
	public void edit(NilaiMahasiswa nilaiMahasiswa);
	public void delete(int nilaiMahasiswaId);
	public List<NilaiMahasiswa> getAllNilaiMahasiswa();
	public List<NilaiMahasiswa> getNilaiMahasiswaByMhsId(int MhsId);
}
