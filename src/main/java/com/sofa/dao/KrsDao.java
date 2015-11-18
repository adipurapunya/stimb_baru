package com.sofa.dao;

import java.util.List;

import com.sofa.model.stimb2.KartuRencanaStudi;

public interface KrsDao 
{
	void add(KartuRencanaStudi kartuRencanaStudi);
	void edit(KartuRencanaStudi kartuRencanaStudi);
	void editSetujui(int idMhs, int idTa);
	void editSetujuiPkrs(int idMhs, int idTa);
	void editMatkulPkrs(int id,int idMhs, int idTa);
	void editStatusAmbilPkrs(int idMhs, int idTa);
	void delete(int kartuRencanaStudiId);
	void deleteNilaiMhs(int IdMhs, int IdTa);
	void deleteAllKrsMhs(int mhsId, int taId);
	KartuRencanaStudi find(int kartuRencanaStudiId);
	List<KartuRencanaStudi> getAllKartuRencanaStudi();
	List<KartuRencanaStudi> getAllKartuRencanaStudiSql();
	List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsId(int MhsId, int TaId);
	List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsIdnyasaja(int MhsId);
	List<KartuRencanaStudi> getAllKartuRencanaStudiByStatusAmbil(int MhsId, int TaId, Integer param);
	List<KartuRencanaStudi> getAllKartuRencanaStudiByKelasId(int KelasId);
}
