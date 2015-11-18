package com.sofa.model.stimb2;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * A NilaiMahasiswa.
 */
@Entity
@Table(name = "NILAI_MAHASISWA")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NilaiMahasiswa implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nilai_tugas")
    private String nilaiTugas;
    
    @Column(name = "nilai_uts")
    private String nilaiUTS;
    
    @Column(name = "nilai_uas")
    private String nilaiUAS;
    
    @Column(name = "nilai_akhir_angka")
    private Float nilaiAkhirAngka;
    
    @Column(name = "nilai_akhir_huruf")
    private String nilaiAkhirHuruf;
    
    @Column(name = "nilai_indeks")
    private Float nilaiIndeks;

    //@OneToOne(mappedBy = "nilaiMahasiswa")
    //@JsonIgnore
    //private AktifitasPerkuliahan aktifitasPerkuliahan;

    //@OneToMany(mappedBy = "nilaiMahasiswa")
    //@JsonIgnore
    //@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    //private Set<KartuHasilStudi> kartuHasilStudis = new HashSet<>();

    //@OneToOne(mappedBy = "nilaiMahasiswa")
    //@JsonIgnore
    //private ReffKriteriaPenilaian reffKriteriaPenilaian;

    //@OneToOne(mappedBy = "nilaiMahasiswa")
    //@JsonIgnore
    //private ReffKeteranganHasilStudi reffKeteranganHasilStudi;

   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNilaiTugas() {
		return nilaiTugas;
	}

	public void setNilaiTugas(String nilaiTugas) {
		this.nilaiTugas = nilaiTugas;
	}

	public String getNilaiUTS() {
		return nilaiUTS;
	}

	public void setNilaiUTS(String nilaiUTS) {
		this.nilaiUTS = nilaiUTS;
	}

	public String getNilaiUAS() {
		return nilaiUAS;
	}

	public void setNilaiUAS(String nilaiUAS) {
		this.nilaiUAS = nilaiUAS;
	}

	public Float getNilaiAkhirAngka() {
		return nilaiAkhirAngka;
	}

	public void setNilaiAkhirAngka(Float nilaiAkhirAngka) {
		this.nilaiAkhirAngka = nilaiAkhirAngka;
	}

	public String getNilaiAkhirHuruf() {
		return nilaiAkhirHuruf;
	}

	public void setNilaiAkhirHuruf(String nilaiAkhirHuruf) {
		this.nilaiAkhirHuruf = nilaiAkhirHuruf;
	}

	public Float getNilaiIndeks() {
		return nilaiIndeks;
	}

	public void setNilaiIndeks(Float nilaiIndeks) {
		this.nilaiIndeks = nilaiIndeks;
	}
	/*
	public AktifitasPerkuliahan getAktifitasPerkuliahan() {
        return aktifitasPerkuliahan;
    }

    public void setAktifitasPerkuliahan(AktifitasPerkuliahan aktifitasPerkuliahan) {
        this.aktifitasPerkuliahan = aktifitasPerkuliahan;
    }

    public Set<KartuHasilStudi> getKartuHasilStudis() {
        return kartuHasilStudis;
    }

    public void setKartuHasilStudis(Set<KartuHasilStudi> kartuHasilStudis) {
        this.kartuHasilStudis = kartuHasilStudis;
    }

    public ReffKriteriaPenilaian getReffKriteriaPenilaian() {
        return reffKriteriaPenilaian;
    }

    public void setReffKriteriaPenilaian(ReffKriteriaPenilaian reffKriteriaPenilaian) {
        this.reffKriteriaPenilaian = reffKriteriaPenilaian;
    }

    public ReffKeteranganHasilStudi getReffKeteranganHasilStudi() {
        return reffKeteranganHasilStudi;
    }

    public void setReffKeteranganHasilStudi(ReffKeteranganHasilStudi reffKeteranganHasilStudi) {
        this.reffKeteranganHasilStudi = reffKeteranganHasilStudi;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NilaiMahasiswa nilaiMahasiswa = (NilaiMahasiswa) o;

        if ( ! Objects.equals(id, nilaiMahasiswa.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "NilaiMahasiswa{" +
                "id=" + id +
                ", nilaiTugas='" + nilaiTugas + "'" +
                ", nilaiUTS='" + nilaiUTS + "'" +
                ", nilaiUAS='" + nilaiUAS + "'" +
                ", nilaiAkhirAngka='" + nilaiAkhirAngka + "'" +
                ", nilaiAkhirHuruf='" + nilaiAkhirHuruf + "'" +
                ", nilaiIndeks='" + nilaiIndeks + "'" +
                '}';
    }
}
