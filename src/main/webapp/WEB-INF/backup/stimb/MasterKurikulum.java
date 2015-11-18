package com.sofa.model.stimb;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A MasterKurikulum.
 */
@Entity
@Table(name = "MASTERKURIKULUM")
public class MasterKurikulum implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    @Column(name = "nama_kurikulum")
    private String namaKurikulum;
    
    @Column(name = "mulai_berlaku")
    private String mulaiBerlaku;
    
    @Column(name = "aturan_sks_lulus")
    private Integer aturanSksLulus;
    
    @Column(name = "aturan_sks_wajib")
    private Integer aturanSksWajib;
    
    @Column(name = "aturan_sks_pilihan")
    private Integer aturanSksPilihan;
    
    @Column(name = "sks_matakuliah_wajib")
    private Integer sksMatakuliahWajib;
    
    @Column(name = "sks_matakuliah_pilihan")
    private Integer sksMatakuliahPilihan;

    @OneToMany(mappedBy = "masterKurikulum")
    //@JsonIgnore
    private Set<ListMatakuliah> listMatakuliahs = new HashSet<>();

    @ManyToOne
    private ReffProgramStudi reffProgramStudi;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKurikulum() {
        return namaKurikulum;
    }

    public void setNamaKurikulum(String namaKurikulum) {
        this.namaKurikulum = namaKurikulum;
    }

    public String getMulaiBerlaku() {
        return mulaiBerlaku;
    }

    public void setMulaiBerlaku(String mulaiBerlaku) {
        this.mulaiBerlaku = mulaiBerlaku;
    }

    public Integer getAturanSksLulus() {
        return aturanSksLulus;
    }

    public void setAturanSksLulus(Integer aturanSksLulus) {
        this.aturanSksLulus = aturanSksLulus;
    }

    public Integer getAturanSksWajib() {
        return aturanSksWajib;
    }

    public void setAturanSksWajib(Integer aturanSksWajib) {
        this.aturanSksWajib = aturanSksWajib;
    }

    public Integer getAturanSksPilihan() {
        return aturanSksPilihan;
    }

    public void setAturanSksPilihan(Integer aturanSksPilihan) {
        this.aturanSksPilihan = aturanSksPilihan;
    }

    public Integer getSksMatakuliahWajib() {
        return sksMatakuliahWajib;
    }

    public void setSksMatakuliahWajib(Integer sksMatakuliahWajib) {
        this.sksMatakuliahWajib = sksMatakuliahWajib;
    }

    public Integer getSksMatakuliahPilihan() {
        return sksMatakuliahPilihan;
    }

    public void setSksMatakuliahPilihan(Integer sksMatakuliahPilihan) {
        this.sksMatakuliahPilihan = sksMatakuliahPilihan;
    }

    public Set<ListMatakuliah> getListMatakuliahs() {
        return listMatakuliahs;
    }

    public void setListMatakuliahs(Set<ListMatakuliah> listMatakuliahs) {
        this.listMatakuliahs = listMatakuliahs;
    }
    
   
    public ReffProgramStudi getReffProgramStudi() {
        return reffProgramStudi;
    }

    public void setReffProgramStudi(ReffProgramStudi reffProgramStudi) {
        this.reffProgramStudi = reffProgramStudi;
    }
   

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MasterKurikulum masterKurikulum = (MasterKurikulum) o;

        if ( ! Objects.equals(id, masterKurikulum.id)) return false;

        return true;
    }

   

	@Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

	@Override
	public String toString() {
		return "MasterKurikulum [id=" + id + ", namaKurikulum=" + namaKurikulum
				+ ", mulaiBerlaku=" + mulaiBerlaku + ", aturanSksLulus="
				+ aturanSksLulus + ", aturanSksWajib=" + aturanSksWajib
				+ ", aturanSksPilihan=" + aturanSksPilihan
				+ ", sksMatakuliahWajib=" + sksMatakuliahWajib
				+ ", sksMatakuliahPilihan=" + sksMatakuliahPilihan
				+ ", listMatakuliahs=" + listMatakuliahs
				+ ", reffProgramStudi=" + reffProgramStudi + "]";
	}

}
