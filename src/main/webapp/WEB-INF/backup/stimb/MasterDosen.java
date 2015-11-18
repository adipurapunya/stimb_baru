package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A MasterDosen.
 */
@Entity
@Table(name = "MASTERDOSEN")
public class MasterDosen implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nama")
    private String nama;
    
    @Column(name = "nidn")
    private Float nidn;
    
    @Column(name = "niy")
    private Float niy;
    
    @Column(name = "nik")
    private Float nik;
    
    @Column(name = "bidang_keahlian")
    private String bidangKeahlian;

    @OneToOne(mappedBy = "listDosenWali")
    //@JsonIgnore
    private DosenDetaill dosenDetaill;

    @OneToMany(mappedBy = "masterDosen")
    //@JsonIgnore
    private Set<ListDosenWali> listDosenWalis = new HashSet<>();

    @OneToMany(mappedBy = "masterDosen")
    //@JsonIgnore
    private Set<ListJadwalPerkuliahan> listJadwalPerkuliahans = new HashSet<>();

    @OneToOne(mappedBy = "listDosenWali")
    //@JsonIgnore
    private DosenPendidikan dosenPendidikan;

    @OneToOne(mappedBy = "listDosenWali")
    //@JsonIgnore
    private DosenStatus dosenStatus;

    @OneToOne(mappedBy = "listDosenWali")
    //@JsonIgnore
    private DosenDataKeluarga dosenDataKeluarga;

    @OneToOne(mappedBy = "masterDosen")
    //@JsonIgnore
    private KehadiranDosen kehadiranDosen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Float getNidn() {
        return nidn;
    }

    public void setNidn(Float nidn) {
        this.nidn = nidn;
    }

    public Float getNiy() {
        return niy;
    }

    public void setNiy(Float niy) {
        this.niy = niy;
    }

    public Float getNik() {
        return nik;
    }

    public void setNik(Float nik) {
        this.nik = nik;
    }

    public String getBidangKeahlian() {
        return bidangKeahlian;
    }

    public void setBidangKeahlian(String bidangKeahlian) {
        this.bidangKeahlian = bidangKeahlian;
    }

    public DosenDetaill getDosenDetaill() {
        return dosenDetaill;
    }

    public void setDosenDetaill(DosenDetaill dosenDetaill) {
        this.dosenDetaill = dosenDetaill;
    }

    public Set<ListDosenWali> getListDosenWalis() {
        return listDosenWalis;
    }

    public void setListDosenWalis(Set<ListDosenWali> listDosenWalis) {
        this.listDosenWalis = listDosenWalis;
    }

    public Set<ListJadwalPerkuliahan> getListJadwalPerkuliahans() {
        return listJadwalPerkuliahans;
    }

    public void setListJadwalPerkuliahans(Set<ListJadwalPerkuliahan> listJadwalPerkuliahans) {
        this.listJadwalPerkuliahans = listJadwalPerkuliahans;
    }

    public DosenPendidikan getDosenPendidikan() {
        return dosenPendidikan;
    }

    public void setDosenPendidikan(DosenPendidikan dosenPendidikan) {
        this.dosenPendidikan = dosenPendidikan;
    }

    public DosenStatus getDosenStatus() {
        return dosenStatus;
    }

    public void setDosenStatus(DosenStatus dosenStatus) {
        this.dosenStatus = dosenStatus;
    }

    public DosenDataKeluarga getDosenDataKeluarga() {
        return dosenDataKeluarga;
    }

    public void setDosenDataKeluarga(DosenDataKeluarga dosenDataKeluarga) {
        this.dosenDataKeluarga = dosenDataKeluarga;
    }

    public KehadiranDosen getKehadiranDosen() {
        return kehadiranDosen;
    }

    public void setKehadiranDosen(KehadiranDosen kehadiranDosen) {
        this.kehadiranDosen = kehadiranDosen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MasterDosen masterDosen = (MasterDosen) o;

        if ( ! Objects.equals(id, masterDosen.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MasterDosen{" +
                "id=" + id +
                ", nama='" + nama + "'" +
                ", nidn='" + nidn + "'" +
                ", niy='" + niy + "'" +
                ", nik='" + nik + "'" +
                ", bidangKeahlian='" + bidangKeahlian + "'" +
                '}';
    }
}
