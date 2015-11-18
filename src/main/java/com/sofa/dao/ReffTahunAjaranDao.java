package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.ReffTahunAjaran;

public interface ReffTahunAjaranDao {
	void addReffTahunAjaran(ReffTahunAjaran reffTahunAjaran);
	void editReffTahunAjaran(ReffTahunAjaran reffTahunAjaran);
	void deleteReffTahunAjaran(int reffTahunAjaranId);
	ReffTahunAjaran findReffTahunAjaran(int reffTahunAjaranId);
	ReffTahunAjaran findReffTahunAjaranByName(String name);
	List<ReffTahunAjaran> getAllReffTahunAjaran();
	List<ReffTahunAjaran> getAllReffTahunAjaranByAktivasi(boolean indikator);
}
