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
 * A KehadiranDosen.
 */
@Entity
@Table(name = "KEHADIRANDOSEN")
public class KehadiranDosen implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "status_kehadiran")
    private Boolean statusKehadiran;
    
    @Column(name = "jumlah_kehadiran_dosen")
    private Integer jumlahKehadiranDosen;

    @OneToOne(mappedBy = "kehadiranDosen")
    //@JsonIgnore
    private AktifitasPerkuliahan aktifitasPerkuliahan;

    @OneToOne
    private MasterDosen masterDosen;

    @OneToOne(mappedBy = "kehadiranDosen")
    //@JsonIgnore
    private ReffPertemuan reffPertemuan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatusKehadiran() {
        return statusKehadiran;
    }

    public void setStatusKehadiran(Boolean statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }

    public Integer getJumlahKehadiranDosen() {
        return jumlahKehadiranDosen;
    }

    public void setJumlahKehadiranDosen(Integer jumlahKehadiranDosen) {
        this.jumlahKehadiranDosen = jumlahKehadiranDosen;
    }

    public AktifitasPerkuliahan getAktifitasPerkuliahan() {
        return aktifitasPerkuliahan;
    }

    public void setAktifitasPerkuliahan(AktifitasPerkuliahan aktifitasPerkuliahan) {
        this.aktifitasPerkuliahan = aktifitasPerkuliahan;
    }

    public MasterDosen getMasterDosen() {
        return masterDosen;
    }

    public void setMasterDosen(MasterDosen masterDosen) {
        this.masterDosen = masterDosen;
    }

    public ReffPertemuan getReffPertemuan() {
        return reffPertemuan;
    }

    public void setReffPertemuan(ReffPertemuan reffPertemuan) {
        this.reffPertemuan = reffPertemuan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KehadiranDosen kehadiranDosen = (KehadiranDosen) o;

        if ( ! Objects.equals(id, kehadiranDosen.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "KehadiranDosen{" +
                "id=" + id +
                ", statusKehadiran='" + statusKehadiran + "'" +
                ", jumlahKehadiranDosen='" + jumlahKehadiranDosen + "'" +
                '}';
    }
}
