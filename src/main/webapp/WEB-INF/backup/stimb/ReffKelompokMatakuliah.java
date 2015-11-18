package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A ReffKelompokMatakuliah.
 */
@Entity
@Table(name = "REFFKELOMPOKMATAKULIAH")
public class ReffKelompokMatakuliah implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "nama_kelompok_mata_kuliah")
    private String namaKelompokMataKuliah;

    @OneToMany(mappedBy = "reffKelompokMatakulih")
    //@JsonIgnore
    private Set<MasterMatakuliah> masterMatakuliahs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKelompokMataKuliah() {
        return namaKelompokMataKuliah;
    }

    public void setNamaKelompokMataKuliah(String namaKelompokMataKuliah) {
        this.namaKelompokMataKuliah = namaKelompokMataKuliah;
    }

    public Set<MasterMatakuliah> getMasterMatakuliahs() {
        return masterMatakuliahs;
    }

    public void setMasterMatakuliahs(Set<MasterMatakuliah> masterMatakuliahs) {
        this.masterMatakuliahs = masterMatakuliahs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReffKelompokMatakuliah reffKelompokMatakuliah = (ReffKelompokMatakuliah) o;

        if ( ! Objects.equals(id, reffKelompokMatakuliah.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ReffKelompokMatakuliah{" +
                "id=" + id +
                ", namaKelompokMataKuliah='" + namaKelompokMataKuliah + "'" +
                '}';
    }
}
