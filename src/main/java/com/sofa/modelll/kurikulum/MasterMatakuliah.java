package com.sofa.modelll.kurikulum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A MasterMatakuliah.
 */
@Entity
@Table(name = "MASTERMATAKULIAH")
public class MasterMatakuliah implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @Column(name = "kode_matakuliah")
    private String kodeMatakuliah;
    
    @Column(name = "nama_matakuliah")
    private String namaMatakuliah;
    
    @Column(name = "sks_matakuliah")
    private Integer sksMatakuliah;
    
    @Column(name = "sks_tatap_muka")
    private Integer sksTatapMuka;
    
    @Column(name = "sks_praktikum")
    private Integer sksPraktikum;
    
    @Column(name = "sks_praktek_lapangan")
    private Integer sksPraktekLapangan;
    
    @Column(name = "sks_simulasi")
    private Integer sksSimulasi;
    
    @Column(name = "metode_kuliah")
    private String metodeKuliah;
    
    @Column(name = "ada_sap")
    private Boolean adaSap;
    
    @Column(name = "ada_silabus")
    private Boolean adaSilabus;
    
    @Column(name = "ada_bahan_ajar")
    private Boolean adaBahanAjar;
    
    @Column(name = "ada_acara_praktek")
    private Boolean adaAcaraPraktek;
    
    @Column(name = "ada_diktat")
    private Boolean adaDiktat;

    @OneToMany(mappedBy = "masterMatakuliah")
    //@JsonIgnore
    private Set<ListMatakuliah> listMatakuliahs = new HashSet<>();

    @OneToMany(mappedBy = "masterMatakuliah")
    //@JsonIgnore
    private Set<ListMatakuliahMayor> listMatakuliahMayors = new HashSet<>();

    @OneToMany(mappedBy = "masterMatakuliah")
    //@JsonIgnore
    private Set<PrequisiteMatakuliah> prequisiteMatakuliahs = new HashSet<>();

    @ManyToOne
    private ReffKelompokMatakuliah reffKelompokMatakulih;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeMatakuliah() {
        return kodeMatakuliah;
    }

    public void setKodeMatakuliah(String kodeMatakuliah) {
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public String getNamaMatakuliah() {
        return namaMatakuliah;
    }

    public void setNamaMatakuliah(String namaMatakuliah) {
        this.namaMatakuliah = namaMatakuliah;
    }

    public Integer getSksMatakuliah() {
        return sksMatakuliah;
    }

    public void setSksMatakuliah(Integer sksMatakuliah) {
        this.sksMatakuliah = sksMatakuliah;
    }

    public Integer getSksTatapMuka() {
        return sksTatapMuka;
    }

    public void setSksTatapMuka(Integer sksTatapMuka) {
        this.sksTatapMuka = sksTatapMuka;
    }

    public Integer getSksPraktikum() {
        return sksPraktikum;
    }

    public void setSksPraktikum(Integer sksPraktikum) {
        this.sksPraktikum = sksPraktikum;
    }

    public Integer getSksPraktekLapangan() {
        return sksPraktekLapangan;
    }

    public void setSksPraktekLapangan(Integer sksPraktekLapangan) {
        this.sksPraktekLapangan = sksPraktekLapangan;
    }

    public Integer getSksSimulasi() {
        return sksSimulasi;
    }

    public void setSksSimulasi(Integer sksSimulasi) {
        this.sksSimulasi = sksSimulasi;
    }

    public String getMetodeKuliah() {
        return metodeKuliah;
    }

    public void setMetodeKuliah(String metodeKuliah) {
        this.metodeKuliah = metodeKuliah;
    }

    public Boolean getAdaSap() {
        return adaSap;
    }

    public void setAdaSap(Boolean adaSap) {
        this.adaSap = adaSap;
    }

    public Boolean getAdaSilabus() {
        return adaSilabus;
    }

    public void setAdaSilabus(Boolean adaSilabus) {
        this.adaSilabus = adaSilabus;
    }

    public Boolean getAdaBahanAjar() {
        return adaBahanAjar;
    }

    public void setAdaBahanAjar(Boolean adaBahanAjar) {
        this.adaBahanAjar = adaBahanAjar;
    }

    public Boolean getAdaAcaraPraktek() {
        return adaAcaraPraktek;
    }

    public void setAdaAcaraPraktek(Boolean adaAcaraPraktek) {
        this.adaAcaraPraktek = adaAcaraPraktek;
    }

    public Boolean getAdaDiktat() {
        return adaDiktat;
    }

    public void setAdaDiktat(Boolean adaDiktat) {
        this.adaDiktat = adaDiktat;
    }

    public Set<ListMatakuliah> getListMatakuliahs() {
        return listMatakuliahs;
    }

    public void setListMatakuliahs(Set<ListMatakuliah> listMatakuliahs) {
        this.listMatakuliahs = listMatakuliahs;
    }

    public Set<ListMatakuliahMayor> getListMatakuliahMayors() {
        return listMatakuliahMayors;
    }

    public void setListMatakuliahMayors(Set<ListMatakuliahMayor> listMatakuliahMayors) {
        this.listMatakuliahMayors = listMatakuliahMayors;
    }

    public Set<PrequisiteMatakuliah> getPrequisiteMatakuliahs() {
        return prequisiteMatakuliahs;
    }

    public void setPrequisiteMatakuliahs(Set<PrequisiteMatakuliah> prequisiteMatakuliahs) {
        this.prequisiteMatakuliahs = prequisiteMatakuliahs;
    }

    public ReffKelompokMatakuliah getReffKelompokMatakulih() {
        return reffKelompokMatakulih;
    }

    public void setReffKelompokMatakulih(ReffKelompokMatakuliah reffKelompokMatakuliah) {
        this.reffKelompokMatakulih = reffKelompokMatakuliah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MasterMatakuliah masterMatakuliah = (MasterMatakuliah) o;

        if ( ! Objects.equals(id, masterMatakuliah.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MasterMatakuliah{" +
                "id=" + id +
                ", kodeMatakuliah='" + kodeMatakuliah + "'" +
                ", namaMatakuliah='" + namaMatakuliah + "'" +
                ", sksMatakuliah='" + sksMatakuliah + "'" +
                ", sksTatapMuka='" + sksTatapMuka + "'" +
                ", sksPraktikum='" + sksPraktikum + "'" +
                ", sksPraktekLapangan='" + sksPraktekLapangan + "'" +
                ", sksSimulasi='" + sksSimulasi + "'" +
                ", metodeKuliah='" + metodeKuliah + "'" +
                ", adaSap='" + adaSap + "'" +
                ", adaSilabus='" + adaSilabus + "'" +
                ", adaBahanAjar='" + adaBahanAjar + "'" +
                ", adaAcaraPraktek='" + adaAcaraPraktek + "'" +
                ", adaDiktat='" + adaDiktat + "'" +
                '}';
    }
}
