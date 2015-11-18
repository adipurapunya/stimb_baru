package com.sofa.model.stimb;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * A ListMayor.
 */
@Entity
@Table(name = "LISTMAYOR")
public class ListMayor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    

    @ManyToOne
    private MasterMatakuliah masterMataKuliah;

    @ManyToOne
    private ReffMayor reffMayor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MasterMatakuliah getMasterMataKuliah() {
        return masterMataKuliah;
    }

    public void setMasterMataKuliah(MasterMatakuliah masterMataKuliah) {
        this.masterMataKuliah = masterMataKuliah;
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

        ListMayor listMayor = (ListMayor) o;

        if ( ! Objects.equals(id, listMayor.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ListMayor{" +
                "id=" + id +
                '}';
    }
}
