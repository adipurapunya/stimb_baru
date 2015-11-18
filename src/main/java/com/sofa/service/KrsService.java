package com.sofa.service;

import java.util.List;

import com.sofa.model.stimb2.KartuRencanaStudi;

public interface KrsService
{
	public void add(KartuRencanaStudi kartuRencanaStudi);
	public void edit(KartuRencanaStudi kartuRencanaStudi);
	public void editSetujui(int idTa, int idMhs);
	public void editSetujuiPkrs(int idTa, int idMhs);
	public void editMatkulPkrs(int id ,int idMhs, int idTa);
	public void editStatusAmbilPkrs(int idMhs, int idTa);
	public void deleteNilaiMhs(int IdMhs, int IdTa);
	public void deleteKrsMhs(int idMhs, int taId);
	public void delete(int kartuRencanaStudiId);
	public KartuRencanaStudi getKartuRencanaStudi(int kartuRencanaStudiId);
	public List<KartuRencanaStudi> getAllKartuRencanaStudi();
	public List<KartuRencanaStudi> getAllKartuRencanaStudiSql();
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsId(int MhsId, int TaId);
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsIdnyasaja(int MhsId);
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByStatusAmbil(int MhsId, int TaId, int param);
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByKelasId(int KelasId);
}
