package com.sofa.model.stimb;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * A KartuRencanaStudi.
 */
@Entity
@Table(name = "KARTURENCANASTUDI")
public class KartuRencanaStudi implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "status_perubahan")
    private String statusPerubahan;
    
    @Column(name = "keterangan")
    private String keterangan;

    @ManyToOne
    private KelasPerkuliahan kelasPerkuliahan;

    @OneToOne(mappedBy = "kartuRencanaStudi")
    //@JsonIgnore
    private NilaiMahasiswa nilaiMahasiswa;

    @ManyToOne
    private MasterMahasiswa masterMahasiswa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusPerubahan() {
        return statusPerubahan;
    }

    public void setStatusPerubahan(String statusPerubahan) {
        this.statusPerubahan = statusPerubahan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public KelasPerkuliahan getKelasPerkuliahan() {
        return kelasPerkuliahan;
    }

    public void setKelasPerkuliahan(KelasPerkuliahan kelasPerkuliahan) {
        this.kelasPerkuliahan = kelasPerkuliahan;
    }

    public NilaiMahasiswa getNilaiMahasiswa() {
        return nilaiMahasiswa;
    }

    public void setNilaiMahasiswa(NilaiMahasiswa nilaiMahasiswa) {
        this.nilaiMahasiswa = nilaiMahasiswa;
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

        KartuRencanaStudi kartuRencanaStudi = (KartuRencanaStudi) o;

        if ( ! Objects.equals(id, kartuRencanaStudi.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "KartuRencanaStudi{" +
                "id=" + id +
                ", statusPerubahan='" + statusPerubahan + "'" +
                ", keterangan='" + keterangan + "'" +
                '}';
    }
}
