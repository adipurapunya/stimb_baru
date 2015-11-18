package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A MasterMahasiswa.
 */
@Entity
@Table(name = "MASTERMAHASISWA")
public class MasterMahasiswa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "npm")
    private String npm;
    
    @Column(name = "nama")
    private String nama;
    
    @Column(name = "angkatan")
    private Float angkatan;
    
    @Column(name = "pilihan_jenjang_pendidikan")
    private String pilihanJenjangPendidikan;

    @OneToOne(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private MahasiswaDetaill mahasiswaDetaill;

    @OneToOne(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private StatusMahasiswa statusMahasiswa;

    @OneToMany(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private Set<KartuRencanaStudi> kartuRencanaStudis = new HashSet<>();

    @OneToMany(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private Set<KehadiranMahasiswa> kehadiranMahasiswas = new HashSet<>();

    @OneToMany(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private Set<ListDosenWali> listDosenWalis = new HashSet<>();

    @OneToOne(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private KartuHasilStudi kartuHasilStudi;

    @OneToOne(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private MahasiswaDataKeluarga mahasiswaDataKeluarga;

    @OneToOne(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private MahasiswaDataWali mahasiswaDataWali;

    @OneToOne(mappedBy = "masterMahasiswa")
    //@JsonIgnore
    private MahasiswaDataAsalPendidikan mahasiswaDataAsalPendidikan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Float getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(Float angkatan) {
        this.angkatan = angkatan;
    }

    public String getPilihanJenjangPendidikan() {
        return pilihanJenjangPendidikan;
    }

    public void setPilihanJenjangPendidikan(String pilihanJenjangPendidikan) {
        this.pilihanJenjangPendidikan = pilihanJenjangPendidikan;
    }

    public MahasiswaDetaill getMahasiswaDetaill() {
        return mahasiswaDetaill;
    }

    public void setMahasiswaDetaill(MahasiswaDetaill mahasiswaDetaill) {
        this.mahasiswaDetaill = mahasiswaDetaill;
    }

    public StatusMahasiswa getStatusMahasiswa() {
        return statusMahasiswa;
    }

    public void setStatusMahasiswa(StatusMahasiswa statusMahasiswa) {
        this.statusMahasiswa = statusMahasiswa;
    }

    public Set<KartuRencanaStudi> getKartuRencanaStudis() {
        return kartuRencanaStudis;
    }

    public void setKartuRencanaStudis(Set<KartuRencanaStudi> kartuRencanaStudis) {
        this.kartuRencanaStudis = kartuRencanaStudis;
    }

    public Set<KehadiranMahasiswa> getKehadiranMahasiswas() {
        return kehadiranMahasiswas;
    }

    public void setKehadiranMahasiswas(Set<KehadiranMahasiswa> kehadiranMahasiswas) {
        this.kehadiranMahasiswas = kehadiranMahasiswas;
    }

    public Set<ListDosenWali> getListDosenWalis() {
        return listDosenWalis;
    }

    public void setListDosenWalis(Set<ListDosenWali> listDosenWalis) {
        this.listDosenWalis = listDosenWalis;
    }

    public KartuHasilStudi getKartuHasilStudi() {
        return kartuHasilStudi;
    }

    public void setKartuHasilStudi(KartuHasilStudi kartuHasilStudi) {
        this.kartuHasilStudi = kartuHasilStudi;
    }

    public MahasiswaDataKeluarga getMahasiswaDataKeluarga() {
        return mahasiswaDataKeluarga;
    }

    public void setMahasiswaDataKeluarga(MahasiswaDataKeluarga mahasiswaDataKeluarga) {
        this.mahasiswaDataKeluarga = mahasiswaDataKeluarga;
    }

    public MahasiswaDataWali getMahasiswaDataWali() {
        return mahasiswaDataWali;
    }

    public void setMahasiswaDataWali(MahasiswaDataWali mahasiswaDataWali) {
        this.mahasiswaDataWali = mahasiswaDataWali;
    }

    public MahasiswaDataAsalPendidikan getMahasiswaDataAsalPendidikan() {
        return mahasiswaDataAsalPendidikan;
    }

    public void setMahasiswaDataAsalPendidikan(MahasiswaDataAsalPendidikan mahasiswaDataAsalPendidikan) {
        this.mahasiswaDataAsalPendidikan = mahasiswaDataAsalPendidikan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MasterMahasiswa masterMahasiswa = (MasterMahasiswa) o;

        if ( ! Objects.equals(id, masterMahasiswa.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MasterMahasiswa{" +
                "id=" + id +
                ", npm='" + npm + "'" +
                ", nama='" + nama + "'" +
                ", angkatan='" + angkatan + "'" +
                ", pilihanJenjangPendidikan='" + pilihanJenjangPendidikan + "'" +
                '}';
    }
}
