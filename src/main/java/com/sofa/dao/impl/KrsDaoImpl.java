package com.sofa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sofa.dao.KrsDao;
import com.sofa.model.stimb2.KartuRencanaStudi;
import com.sofa.model.stimb2.NilaiMahasiswa;

@Repository
public class KrsDaoImpl implements KrsDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(KartuRencanaStudi kartuRencanaStudi) 
	{
		NilaiMahasiswa nilaiMahasiswa = new NilaiMahasiswa();
		kartuRencanaStudi.setNilaiMahasiswa(nilaiMahasiswa);
		session.getCurrentSession().save(nilaiMahasiswa);
		session.getCurrentSession().save(kartuRencanaStudi);
	}

	@Override
	public void edit(KartuRencanaStudi kartuRencanaStudi) 
	{
		session.getCurrentSession().update(kartuRencanaStudi.getNilaiMahasiswa());
		//session.getCurrentSession().update(kartuRencanaStudi);
	}
	
	
	@Override
	public void delete(int kartuRencanaStudiId)
	{
		session.getCurrentSession().delete(find(kartuRencanaStudiId));
		//(NilaiMahasiswa) session.getCurrentSession().get(NilaiMahasiswa.class, Long.parseLong(String.valueOf(kartuRencanaStudiId)));
	}

	@Override
	public void deleteNilaiMhs(int IdMhs, int IdTa)
	{
		System.out.println("Masuk");
		List<KartuRencanaStudi> kr = getAllKartuRencanaStudiByMhsId(IdMhs, IdTa);
		if(kr!=null)
		{
			System.out.println("tidak NULLLLLL");
		}
		for(KartuRencanaStudi krs : kr)
		{
			session.getCurrentSession().delete(session.getCurrentSession().get(NilaiMahasiswa.class, krs.getNilaiMahasiswa().getId()));
			System.out.println("Masuk");
		}
	}

	@Override
	public KartuRencanaStudi find(int kartuRencanaStudiId)
	{
		return (KartuRencanaStudi) session.getCurrentSession().get(KartuRencanaStudi.class, Long.parseLong(String.valueOf(kartuRencanaStudiId)));
	}
	
	

	@Override
	public List<KartuRencanaStudi> getAllKartuRencanaStudi()
	{
		return session.getCurrentSession().createQuery("from KartuRencanaStudi").list();
	}
	
	@Override
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsId(int MhsId, int TaId)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(KartuRencanaStudi.class);
		criteria.add(Restrictions.eq("masterMahasiswa.id", Long.parseLong(String.valueOf(MhsId))));		
		criteria.add(Restrictions.eq("reffTahunAjaran.id", Long.parseLong(String.valueOf(TaId))));	
		return (List<KartuRencanaStudi>) criteria.list();
		//return session.getCurrentSession().createQuery("from ListDosenKelas").list();
	}
	
	@Override
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByKelasId(int KelasId)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(KartuRencanaStudi.class);
		criteria.add(Restrictions.eq("kelasPerkuliahan.id", Long.parseLong(String.valueOf(KelasId))));		
		return (List<KartuRencanaStudi>) criteria.list();
	}

	@Override
	public List<KartuRencanaStudi> getAllKartuRencanaStudiSql() 
	{
		return session.getCurrentSession().createQuery("from KartuRencanaStudi GROUP BY masterMahasiswa_id, reffTahunAjaran_id").list();
	}

	@Override
	public void editSetujui(int idMhs, int idTa) {
		session.getCurrentSession().createQuery("UPDATE KartuRencanaStudi SET keterangan = 'Sudah Disetujui' WHERE masterMahasiswa_id='"+idMhs+"' AND reffTahunAjaran_id='"+idTa+"'").executeUpdate();
	}

	@Override
	public void deleteAllKrsMhs(int mhsId, int taId) 
	{
		//session.getCurrentSession().createQuery("DELETE FROM KartuRencanaStudi WHERE masterMahasiswa_id =: idMhs").setParameter("idMhs", mhsId).executeUpdate();
		List<KartuRencanaStudi> kr = getAllKartuRencanaStudiByMhsId(mhsId, taId);
		List<KartuRencanaStudi> krss = kr;
		session.getCurrentSession().createQuery("DELETE FROM KartuRencanaStudi WHERE masterMahasiswa_id ='"+mhsId+"' AND reffTahunAjaran_id='"+taId+"'").executeUpdate();
		for(KartuRencanaStudi b : krss)
		{
			session.getCurrentSession().delete(session.getCurrentSession().get(NilaiMahasiswa.class, b.getNilaiMahasiswa().getId()));
		}	
	}

	@Override
	public void editMatkulPkrs(int id ,int idMhs, int idTa) {
		session.getCurrentSession().createQuery("UPDATE KartuRencanaStudi SET statusambil = 0 WHERE masterMahasiswa_id='"+idMhs+"' AND reffTahunAjaran_id='"+idTa+"' AND id='"+id+"'").executeUpdate();
	}

	@Override
	public void editSetujuiPkrs(int idMhs, int idTa) {
		session.getCurrentSession().createQuery("UPDATE KartuRencanaStudi SET statuspkrs = 'PKRS Sudah Disetujui' WHERE masterMahasiswa_id='"+idMhs+"' AND reffTahunAjaran_id='"+idTa+"'").executeUpdate();
	}

	@Override
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByStatusAmbil(int MhsId, int TaId, Integer param)
	{
		/*
		Criteria criteria = session.getCurrentSession().createCriteria(KartuRencanaStudi.class);
		criteria.add(Restrictions.eq("masterMahasiswa.id", Long.parseLong(String.valueOf(MhsId))));		
		criteria.add(Restrictions.eq("reffTahunAjaran.id", Long.parseLong(String.valueOf(TaId))));	
		criteria.add(Restrictions.eq("statusambil", param));	
		return (List<KartuRencanaStudi>) criteria.list();
		*/
		
		return session.getCurrentSession().createQuery("from KartuRencanaStudi WHERE masterMahasiswa_id='"+MhsId+"' AND reffTahunAjaran_id='"+TaId+"' AND statusambil IN( '1','3')").list();
	}

	@Override
	public void editStatusAmbilPkrs(int idMhs, int idTa) 
	{
		session.getCurrentSession().createQuery("UPDATE KartuRencanaStudi SET ambilpkrs = 1 WHERE masterMahasiswa_id='"+idMhs+"' AND reffTahunAjaran_id='"+idTa+"'").executeUpdate();
	}

	@Override
	public List<KartuRencanaStudi> getAllKartuRencanaStudiByMhsIdnyasaja(int MhsId) 
	{
		//Criteria criteria = session.getCurrentSession().createCriteria(KartuRencanaStudi.class);
		//criteria.add(Restrictions.eq("masterMahasiswa.id", Long.parseLong(String.valueOf(MhsId))));	
		//return (List<KartuRencanaStudi>) criteria.list();
		return session.getCurrentSession().createQuery("from KartuRencanaStudi WHERE masterMahasiswa_id='"+MhsId+"'").list();
	}
}
