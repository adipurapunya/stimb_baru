package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.ListJadwalPerkuliahan;

public interface JadwalService
{
	public void add(ListJadwalPerkuliahan listJadwalPerkuliahan);
	public void edit(ListJadwalPerkuliahan listJadwalPerkuliahan);
	public void delete(int listJadwalPerkuliahanId);
	public ListJadwalPerkuliahan find(int listJadwalPerkuliahanId);
	public List<ListJadwalPerkuliahan> getAllListJadwalPerkuliahan();
	public List<ListJadwalPerkuliahan> getAllListJadwalPerkuliahanById(int id);
}
