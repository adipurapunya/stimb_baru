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
 * A DosenPendidikan.
 */
@Entity
@Table(name = "DOSENPENDIDIKAN")
public class DosenPendidikan implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
       
    @Column(name = "perguruan_tinggi_asal")
    private String perguruanTinggiAsal;
    
    @Column(name = "pendidikan_terakhir")
    private String pendidikanTerakhir;
    
    @Column(name = "gelar_akademik")
    private String gelarAkademik;
    
    @Column(name = "fakultas")
    private String fakultas;
    
    @Column(name = "tahun_lulus")
    private Float tahunLulus;
    
    @Column(name = "sks")
    private Float sks;
    
    @Column(name = "ipk")
    private Float ipk;

    @OneToOne
    private MasterDosen listDosenWali;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerguruanTinggiAsal() {
        return perguruanTinggiAsal;
    }

    public void setPerguruanTinggiAsal(String perguruanTinggiAsal) {
        this.perguruanTinggiAsal = perguruanTinggiAsal;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getGelarAkademik() {
        return gelarAkademik;
    }

    public void setGelarAkademik(String gelarAkademik) {
        this.gelarAkademik = gelarAkademik;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public Float getTahunLulus() {
        return tahunLulus;
    }

    public void setTahunLulus(Float tahunLulus) {
        this.tahunLulus = tahunLulus;
    }

    public Float getSks() {
        return sks;
    }

    public void setSks(Float sks) {
        this.sks = sks;
    }

    public Float getIpk() {
        return ipk;
    }

    public void setIpk(Float ipk) {
        this.ipk = ipk;
    }

    public MasterDosen getListDosenWali() {
        return listDosenWali;
    }

    public void setListDosenWali(MasterDosen masterDosen) {
        this.listDosenWali = masterDosen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DosenPendidikan dosenPendidikan = (DosenPendidikan) o;

        if ( ! Objects.equals(id, dosenPendidikan.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DosenPendidikan{" +
                "id=" + id +
                ", perguruanTinggiAsal='" + perguruanTinggiAsal + "'" +
                ", pendidikanTerakhir='" + pendidikanTerakhir + "'" +
                ", gelarAkademik='" + gelarAkademik + "'" +
                ", fakultas='" + fakultas + "'" +
                ", tahunLulus='" + tahunLulus + "'" +
                ", sks='" + sks + "'" +
                ", ipk='" + ipk + "'" +
                '}';
    }
}
