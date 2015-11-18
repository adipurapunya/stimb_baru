package com.sofa.model.stimb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A ReffTahunAjaran.
 */
@Entity
@Table(name = "REFFTAHUNAJARAN")
public class ReffTahunAjaran implements Serializable 
{
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "nama_tahun_ajaran")
    private String namaTahunAjaran;

    @OneToMany(mappedBy = "reffTahunAjaran")
    //@JsonIgnore
    private Set<ListSemesterPerkuliahan> listSemesterPerkuliahans = new HashSet<>();

    @OneToOne
    private ReffProgramStudi reffProgramStudi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaTahunAjaran() {
        return namaTahunAjaran;
    }

    public void setNamaTahunAjaran(String namaTahunAjaran) {
        this.namaTahunAjaran = namaTahunAjaran;
    }

    public Set<ListSemesterPerkuliahan> getListSemesterPerkuliahans() {
        return listSemesterPerkuliahans;
    }

    public void setListSemesterPerkuliahans(Set<ListSemesterPerkuliahan> listSemesterPerkuliahans) {
        this.listSemesterPerkuliahans = listSemesterPerkuliahans;
    }

    public ReffProgramStudi getReffProgramStudi() {
        return reffProgramStudi;
    }

    public void setReffProgramStudi(ReffProgramStudi reffProgramStudi) {
        this.reffProgramStudi = reffProgramStudi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReffTahunAjaran reffTahunAjaran = (ReffTahunAjaran) o;

        if ( ! Objects.equals(id, reffTahunAjaran.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ReffTahunAjaran{" +
                "id=" + id +
                ", namaTahunAjaran='" + namaTahunAjaran + "'" +
                '}';
    }
}
