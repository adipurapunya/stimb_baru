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
 * A DosenDataKeluarga.
 */
@Entity
@Table(name = "DOSENDATAKELUARGA")
public class DosenDataKeluarga implements Serializable 
{	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "nama_istri")
    private String namaIstri;
    
    @Column(name = "status")
    private Float status;
    
    @Column(name = "pekerjaan")
    private String pekerjaan;
    
    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "rt")
    private Float rt;
    
    @Column(name = "rw")
    private Float rw;
    
    @Column(name = "no_telp_rumah")
    private Float noTelpRumah;
    
    @Column(name = "no_hp")
    private Float noHp;
    
    @Column(name = "kode_pos")
    private Float kodePos;
    
    @Column(name = "jumlah_anak")
    private Float jumlahAnak;

    @OneToOne
    private MasterDosen listDosenWali;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaIstri() {
        return namaIstri;
    }

    public void setNamaIstri(String namaIstri) {
        this.namaIstri = namaIstri;
    }

    public Float getStatus() {
        return status;
    }

    public void setStatus(Float status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
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

    public Float getKodePos() {
        return kodePos;
    }

    public void setKodePos(Float kodePos) {
        this.kodePos = kodePos;
    }

    public Float getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(Float jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
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

        DosenDataKeluarga dosenDataKeluarga = (DosenDataKeluarga) o;

        if ( ! Objects.equals(id, dosenDataKeluarga.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DosenDataKeluarga{" +
                "id=" + id +
                ", namaIstri='" + namaIstri + "'" +
                ", status='" + status + "'" +
                ", pekerjaan='" + pekerjaan + "'" +
                ", alamat='" + alamat + "'" +
                ", rt='" + rt + "'" +
                ", rw='" + rw + "'" +
                ", noTelpRumah='" + noTelpRumah + "'" +
                ", noHp='" + noHp + "'" +
                ", kodePos='" + kodePos + "'" +
                ", jumlahAnak='" + jumlahAnak + "'" +
                '}';
    }
}
