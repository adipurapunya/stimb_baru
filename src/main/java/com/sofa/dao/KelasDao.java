package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.KelasPerkuliahan;

public interface KelasDao 
{
	void add(KelasPerkuliahan kelasPerkuliahan);
	void edit(KelasPerkuliahan kelasPerkuliahan);
	void delete(int kelasPerkuliahanId);
	KelasPerkuliahan find(int kelasPerkuliahanId);
	List<KelasPerkuliahan> getAllKelasPerkuliahan();
	List<KelasPerkuliahan> getAllKelasPerkuliahanByIdKurikulum(int id);
}
