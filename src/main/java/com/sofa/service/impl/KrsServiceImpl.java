package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.dao.KrsDao;
import com.sofa.service.KrsService;


@Service
public class KrsServiceImpl implements KrsService {
	
	@Autowired
	private KrsDao krsDao;
	
	@Transactional
	public void add(KartuRencanaStudi kartuRencanaStudi)
	{
		krsDao.add(kartuRencanaStudi);
	}

	@Transactional
	public void edit(KartuRencanaStudi kartuRencanaStudi)
	{
		krsDao.edit(kartuRencanaStudi);
	}

	@Transactional
	public void deleteNilaiMhs(int IdMhs, int IdTa)
	{
		krsDao.deleteNilaiMhs(IdMhs, IdTa);
	}

	@Transactional
	public KartuRencanaStudi getKartuRencanaStudi(int kartuRencanaStudiId)
	{
		return krsDao.find(kartuRencanaStudiId);
	}

	@Transactional
	public List<KartuRencanaStudi> getAllKartuRencanaStudi() 
	{
		return krsDao.getAllKartuRencanaStudi();
	}

	@Transactional
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsId(int MhsId, int TaId) 
	{
		return krsDao.getAllKartuRencanaStudiByMhsId(MhsId,TaId);
	}

	@Transactional
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByKelasId(int KelasId) 
	{
		return krsDao.getAllKartuRencanaStudiByKelasId(KelasId);
	}

	@Transactional
	public List<KartuRencanaStudi> getAllKartuRencanaStudiSql() {
		return krsDao.getAllKartuRencanaStudiSql();
	}

	@Transactional
	public void editSetujui(int idTa, int idMhs) {
		krsDao.editSetujui(idMhs, idTa);
	}

	@Transactional
	public void deleteKrsMhs(int idMhs, int taId) {
		krsDao.deleteAllKrsMhs(idMhs,taId);
	}

	@Transactional
	public void editSetujuiPkrs(int idTa, int idMhs) {
		krsDao.editSetujuiPkrs(idMhs, idTa);
	}

	@Transactional
	public void editMatkulPkrs(int id,int idMhs, int idTa) {
		krsDao.editMatkulPkrs(id,idMhs, idTa);
	}

	@Transactional
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByStatusAmbil(int MhsId, int TaId, int param) {
		return krsDao.getAllKartuRencanaStudiByStatusAmbil(MhsId, TaId, param);
	}

	@Transactional
	public void editStatusAmbilPkrs(int idMhs, int idTa)
	{
		krsDao.editStatusAmbilPkrs(idMhs, idTa);
	}

	@Transactional
	public void delete(int kartuRencanaStudiId) {
		krsDao.delete(kartuRencanaStudiId);
	}

	@Transactional
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsIdnyasaja(int MhsId) 
	{
		return krsDao.getAllKartuRencanaStudiByMhsIdnyasaja(MhsId);
	}
}
