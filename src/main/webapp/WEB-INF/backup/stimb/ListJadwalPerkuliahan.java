package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A ListJadwalPerkuliahan.
 */
@Entity
@Table(name = "LISTJADWALPERKULIAHAN")
public class ListJadwalPerkuliahan implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private KelasPerkuliahan kelasPerkuliahan;

    @ManyToOne
    private MasterDosen masterDosen;

    @OneToMany(mappedBy = "listJadwalPerkuliahan")
    //@JsonIgnore
    private Set<AktifitasPerkuliahan> aktifitasPerkuliahans = new HashSet<>();

    @OneToOne(mappedBy = "listJadwalPerkuliahan")
    //@JsonIgnore
    private ReffRuangKelas reffRuangKelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KelasPerkuliahan getKelasPerkuliahan() {
        return kelasPerkuliahan;
    }

    public void setKelasPerkuliahan(KelasPerkuliahan kelasPerkuliahan) {
        this.kelasPerkuliahan = kelasPerkuliahan;
    }

    public MasterDosen getMasterDosen() {
        return masterDosen;
    }

    public void setMasterDosen(MasterDosen masterDosen) {
        this.masterDosen = masterDosen;
    }

    public Set<AktifitasPerkuliahan> getAktifitasPerkuliahans() {
        return aktifitasPerkuliahans;
    }

    public void setAktifitasPerkuliahans(Set<AktifitasPerkuliahan> aktifitasPerkuliahans) {
        this.aktifitasPerkuliahans = aktifitasPerkuliahans;
    }

    public ReffRuangKelas getReffRuangKelas() {
        return reffRuangKelas;
    }

    public void setReffRuangKelas(ReffRuangKelas reffRuangKelas) {
        this.reffRuangKelas = reffRuangKelas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListJadwalPerkuliahan listJadwalPerkuliahan = (ListJadwalPerkuliahan) o;

        if ( ! Objects.equals(id, listJadwalPerkuliahan.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ListJadwalPerkuliahan{" +
                "id=" + id +
                '}';
    }
}
