package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.model.stimb2.NilaiMahasiswa;

public interface NilaiMahasiswaDao 
{
	void add(NilaiMahasiswa nilaiMahasiswa);
	void edit(NilaiMahasiswa nilaiMahasiswa);
	void delete(int nilaiMahasiswaId);
	NilaiMahasiswa find(int nilaiMahasiswaId);
	List<NilaiMahasiswa> getNilaiMahasiswaById(int nilaiMahasiswaId);
	List<NilaiMahasiswa> getAllNilaiMahasiswa();
}
