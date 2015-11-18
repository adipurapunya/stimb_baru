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
 * A ReffKeteranganHasilStudi.
 */
@Entity
@Table(name = "REFFKETERANGANHASILSTUDI")
public class ReffKeteranganHasilStudi implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "keterangan")
    private String keterangan;

    @OneToOne
    private NilaiMahasiswa nilaiMahasiswa;

    @OneToOne
    private KartuHasilStudi kartuHasilStudi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public NilaiMahasiswa getNilaiMahasiswa() {
        return nilaiMahasiswa;
    }

    public void setNilaiMahasiswa(NilaiMahasiswa nilaiMahasiswa) {
        this.nilaiMahasiswa = nilaiMahasiswa;
    }

    public KartuHasilStudi getKartuHasilStudi() {
        return kartuHasilStudi;
    }

    public void setKartuHasilStudi(KartuHasilStudi kartuHasilStudi) {
        this.kartuHasilStudi = kartuHasilStudi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReffKeteranganHasilStudi reffKeteranganHasilStudi = (ReffKeteranganHasilStudi) o;

        if ( ! Objects.equals(id, reffKeteranganHasilStudi.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ReffKeteranganHasilStudi{" +
                "id=" + id +
                ", keterangan='" + keterangan + "'" +
                '}';
    }
}
