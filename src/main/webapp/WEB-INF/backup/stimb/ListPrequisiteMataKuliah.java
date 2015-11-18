package com.sofa.model.stimb;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * A ListPrequisiteMataKuliah.
 */
@Entity
@Table(name = "LISTPREQUISITEMATAKULIAH")
public class ListPrequisiteMataKuliah implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "prequisite_mata_kuliah")
    private String prequisiteMataKuliah;

    @ManyToOne
    private MasterMatakuliah masterMataKuliah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrequisiteMataKuliah() {
        return prequisiteMataKuliah;
    }

    public void setPrequisiteMataKuliah(String prequisiteMataKuliah) {
        this.prequisiteMataKuliah = prequisiteMataKuliah;
    }

    public MasterMatakuliah getMasterMataKuliah() {
        return masterMataKuliah;
    }

    public void setMasterMataKuliah(MasterMatakuliah masterMataKuliah) {
        this.masterMataKuliah = masterMataKuliah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListPrequisiteMataKuliah listPrequisiteMataKuliah = (ListPrequisiteMataKuliah) o;

        if ( ! Objects.equals(id, listPrequisiteMataKuliah.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ListPrequisiteMataKuliah{" +
                "id=" + id +
                ", prequisiteMataKuliah='" + prequisiteMataKuliah + "'" +
                '}';
    }
}
