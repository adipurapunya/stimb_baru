package com.sofa.model.stimb;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * A MahasiswaDataKeluarga.
 */
@Entity
@Table(name = "MAHASISWADATAKELUARGA")
public class MahasiswaDataKeluarga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nama_ayah")
    private String namaAyah;
    
    @Column(name = "status_ayah")
    private String statusAyah;
    
    @Column(name = "pekerjaan_ayah")
    private String pekerjaanAyah;
    
    @Column(name = "penghasilan_ayah")
    private Float penghasilanAyah;
    
    @Column(name = "nama_ibu")
    private String namaIbu;
    
    @Column(name = "status_ibu")
    private String statusIbu;
    
    @Column(name = "pekerjaan_ibu")
    private String pekerjaanIbu;
    
    @Column(name = "penghasilan_ibu")
    private Float penghasilanIbu;
    
    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "rt")
    private Float rt;
    
    @Column(name = "rw")
    private Float rw;
    
    @Column(name = "kota")
    private String kota;
    
    @Column(name = "kode_pos")
    private Float kodePos;
    
    @Column(name = "no_telp_rumah")
    private Float noTelpRumah;
    
    @Column(name = "no_hp")
    private Float noHp;
    
    @Column(name = "pendidikan_ayah")
    private String pendidikanAyah;
    
    @Column(name = "pendidikan_ibu")
    private String pendidikanIbu;

    @OneToOne
    private MasterMahasiswa masterMahasiswa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getStatusAyah() {
        return statusAyah;
    }

    public void setStatusAyah(String statusAyah) {
        this.statusAyah = statusAyah;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public Float getPenghasilanAyah() {
        return penghasilanAyah;
    }

    public void setPenghasilanAyah(Float penghasilanAyah) {
        this.penghasilanAyah = penghasilanAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getStatusIbu() {
        return statusIbu;
    }

    public void setStatusIbu(String statusIbu) {
        this.statusIbu = statusIbu;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public Float getPenghasilanIbu() {
        return penghasilanIbu;
    }

    public void setPenghasilanIbu(Float penghasilanIbu) {
        this.penghasilanIbu = penghasilanIbu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Float getRt() {
        return rt;
    }

    public void setRt(Float rt) {
        this.rt = rt;
    }

    public Float getRw() {
        return rw;
    }

    public void setRw(Float rw) {
        this.rw = rw;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Float getKodePos() {
        return kodePos;
    }

    public void setKodePos(Float kodePos) {
        this.kodePos = kodePos;
    }

    public Float getNoTelpRumah() {
        return noTelpRumah;
    }

    public void setNoTelpRumah(Float noTelpRumah) {
        this.noTelpRumah = noTelpRumah;
    }

    public Float getNoHp() {
        return noHp;
    }

    public void setNoHp(Float noHp) {
        this.noHp = noHp;
    }

    public String getPendidikanAyah() {
        return pendidikanAyah;
    }

    public void setPendidikanAyah(String pendidikanAyah) {
        this.pendidikanAyah = pendidikanAyah;
    }

    public String getPendidikanIbu() {
        return pendidikanIbu;
    }

    public void setPendidikanIbu(String pendidikanIbu) {
        this.pendidikanIbu = pendidikanIbu;
    }

    public MasterMahasiswa getMasterMahasiswa() {
        return masterMahasiswa;
    }

    public void setMasterMahasiswa(MasterMahasiswa masterMahasiswa) {
        this.masterMahasiswa = masterMahasiswa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MahasiswaDataKeluarga mahasiswaDataKeluarga = (MahasiswaDataKeluarga) o;

        if ( ! Objects.equals(id, mahasiswaDataKeluarga.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MahasiswaDataKeluarga{" +
                "id=" + id +
                ", namaAyah='" + namaAyah + "'" +
                ", statusAyah='" + statusAyah + "'" +
                ", pekerjaanAyah='" + pekerjaanAyah + "'" +
                ", penghasilanAyah='" + penghasilanAyah + "'" +
                ", namaIbu='" + namaIbu + "'" +
                ", statusIbu='" + statusIbu + "'" +
                ", pekerjaanIbu='" + pekerjaanIbu + "'" +
                ", penghasilanIbu='" + penghasilanIbu + "'" +
                ", alamat='" + alamat + "'" +
                ", rt='" + rt + "'" +
                ", rw='" + rw + "'" +
                ", kota='" + kota + "'" +
                ", kodePos='" + kodePos + "'" +
                ", noTelpRumah='" + noTelpRumah + "'" +
                ", noHp='" + noHp + "'" +
                ", pendidikanAyah='" + pendidikanAyah + "'" +
                ", pendidikanIbu='" + pendidikanIbu + "'" +
                '}';
    }
}
