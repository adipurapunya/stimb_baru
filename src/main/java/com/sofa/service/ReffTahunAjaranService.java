package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ReffTahunAjaran;

public interface ReffTahunAjaranService
{
	public void add(ReffTahunAjaran reffTahunAjaran);
	public void edit(ReffTahunAjaran reffTahunAjaran);
	public void delete(int reffTahunAjaranId);
	public ReffTahunAjaran getReffTahunAjaran(int reffTahunAjaranId);
	public List<ReffTahunAjaran> getAllReffTahunAjaran();
	public List<ReffTahunAjaran> getAllReffTahunAjaranByAktivasi(boolean param);
}
