package com.sofa.modelll.kurikulum;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * A ListMatakuliahMayor.
 */
@Entity
@Table(name = "LISTMATAKULIAHMAYOR")
public class ListMatakuliahMayor implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private MasterMatakuliah masterMatakuliah;

    @ManyToOne
    private ReffMayor reffMayor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MasterMatakuliah getMasterMatakuliah() {
        return masterMatakuliah;
    }

    public void setMasterMatakuliah(MasterMatakuliah masterMatakuliah) {
        this.masterMatakuliah = masterMatakuliah;
    }

    public ReffMayor getReffMayor() {
        return reffMayor;
    }

    public void setReffMayor(ReffMayor reffMayor) {
        this.reffMayor = reffMayor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListMatakuliahMayor listMatakuliahMayor = (ListMatakuliahMayor) o;

        if ( ! Objects.equals(id, listMatakuliahMayor.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ListMatakuliahMayor{" +
                "id=" + id +
                '}';
    }
}
