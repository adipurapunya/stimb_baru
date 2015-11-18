package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.KelasPerkuliahan;

public interface KelasService
{
	public void add(KelasPerkuliahan kelasPerkuliahan);
	public void edit(KelasPerkuliahan kelasPerkuliahan);
	public void delete(int kelasPerkuliahanId);
	public KelasPerkuliahan getKelasPerkuliahan(int kelasPerkuliahanId);
	public List<KelasPerkuliahan> getAllKelasPerkuliahan();
	public List<KelasPerkuliahan> getAllKelasPerkuliahanByIdKurikulum(int id);
}
