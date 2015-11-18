package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A AktifitasPerkuliahan.
 */
@Entity
@Table(name = "AKTIFITASPERKULIAHAN")
public class AktifitasPerkuliahan implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "tanggal_perkuliahan")
    private String tanggalPerkuliahan;

    @ManyToOne
    private ListJadwalPerkuliahan listJadwalPerkuliahan;

    @OneToMany(mappedBy = "aktifitasPerkuliahan")
    //@JsonIgnore
    private Set<KehadiranMahasiswa> kehadiranMahasiswas = new HashSet<>();

    @OneToOne
    private KehadiranDosen kehadiranDosen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanggalPerkuliahan() {
        return tanggalPerkuliahan;
    }

    public void setTanggalPerkuliahan(String tanggalPerkuliahan) {
        this.tanggalPerkuliahan = tanggalPerkuliahan;
    }

    public ListJadwalPerkuliahan getListJadwalPerkuliahan() {
        return listJadwalPerkuliahan;
    }

    public void setListJadwalPerkuliahan(ListJadwalPerkuliahan listJadwalPerkuliahan) {
        this.listJadwalPerkuliahan = listJadwalPerkuliahan;
    }

    public Set<KehadiranMahasiswa> getKehadiranMahasiswas() {
        return kehadiranMahasiswas;
    }

    public void setKehadiranMahasiswas(Set<KehadiranMahasiswa> kehadiranMahasiswas) {
        this.kehadiranMahasiswas = kehadiranMahasiswas;
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

        AktifitasPerkuliahan aktifitasPerkuliahan = (AktifitasPerkuliahan) o;

        if ( ! Objects.equals(id, aktifitasPerkuliahan.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AktifitasPerkuliahan{" +
                "id=" + id +
                ", tanggalPerkuliahan='" + tanggalPerkuliahan + "'" +
                '}';
    }
}
