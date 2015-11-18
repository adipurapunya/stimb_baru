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
 * A ReffPertemuan.
 */
@Entity
@Table(name = "REFFPERTEMUAN")
public class ReffPertemuan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "pertemuan_ke")
    private String pertemuanKe;

    @OneToOne
    private KehadiranMahasiswa kehadiranMahasiswa;

    @OneToOne
    private KehadiranDosen kehadiranDosen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPertemuanKe() {
        return pertemuanKe;
    }

    public void setPertemuanKe(String pertemuanKe) {
        this.pertemuanKe = pertemuanKe;
    }

    public KehadiranMahasiswa getKehadiranMahasiswa() {
        return kehadiranMahasiswa;
    }

    public void setKehadiranMahasiswa(KehadiranMahasiswa kehadiranMahasiswa) {
        this.kehadiranMahasiswa = kehadiranMahasiswa;
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

        ReffPertemuan reffPertemuan = (ReffPertemuan) o;

        if ( ! Objects.equals(id, reffPertemuan.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ReffPertemuan{" +
                "id=" + id +
                ", pertemuanKe='" + pertemuanKe + "'" +
                '}';
    }
}
