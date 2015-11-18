package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A KelasPerkuliahan.
 */
@Entity
@Table(name = "KELASPERKULIAHAN")
public class KelasPerkuliahan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "semester")
    private String semester;
    
    @Column(name = "kode_mata_kuliah")
    private String kodeMataKuliah;
    
    @Column(name = "nama_mata_kuliah")
    private String namaMataKuliah;
    
    @Column(name = "nama_kelas")
    private String namaKelas;
    
    @Column(name = "sks")
    private Integer sks;
    
    @Column(name = "peserta_kelas")
    private Float pesertaKelas;

    @ManyToOne
    private ListSemesterPerkuliahan listSemesterPerkuliahan;

    @OneToMany(mappedBy = "kelasPerkuliahan")
    //@JsonIgnore
    private Set<ListJadwalPerkuliahan> listJadwalPerkuliahans = new HashSet<>();

    @OneToMany(mappedBy = "kelasPerkuliahan")
    //@JsonIgnore
    private Set<KartuRencanaStudi> kartuRencanaStudis = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getKodeMataKuliah() {
        return kodeMataKuliah;
    }

    public void setKodeMataKuliah(String kodeMataKuliah) {
        this.kodeMataKuliah = kodeMataKuliah;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    public Float getPesertaKelas() {
        return pesertaKelas;
    }

    public void setPesertaKelas(Float pesertaKelas) {
        this.pesertaKelas = pesertaKelas;
    }

    public ListSemesterPerkuliahan getListSemesterPerkuliahan() {
        return listSemesterPerkuliahan;
    }

    public void setListSemesterPerkuliahan(ListSemesterPerkuliahan listSemesterPerkuliahan) {
        this.listSemesterPerkuliahan = listSemesterPerkuliahan;
    }

    public Set<ListJadwalPerkuliahan> getListJadwalPerkuliahans() {
        return listJadwalPerkuliahans;
    }

    public void setListJadwalPerkuliahans(Set<ListJadwalPerkuliahan> listJadwalPerkuliahans) {
        this.listJadwalPerkuliahans = listJadwalPerkuliahans;
    }

    public Set<KartuRencanaStudi> getKartuRencanaStudis() {
        return kartuRencanaStudis;
    }

    public void setKartuRencanaStudis(Set<KartuRencanaStudi> kartuRencanaStudis) {
        this.kartuRencanaStudis = kartuRencanaStudis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KelasPerkuliahan kelasPerkuliahan = (KelasPerkuliahan) o;

        if ( ! Objects.equals(id, kelasPerkuliahan.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "KelasPerkuliahan{" +
                "id=" + id +
                ", semester='" + semester + "'" +
                ", kodeMataKuliah='" + kodeMataKuliah + "'" +
                ", namaMataKuliah='" + namaMataKuliah + "'" +
                ", namaKelas='" + namaKelas + "'" +
                ", sks='" + sks + "'" +
                ", pesertaKelas='" + pesertaKelas + "'" +
                '}';
    }
}
