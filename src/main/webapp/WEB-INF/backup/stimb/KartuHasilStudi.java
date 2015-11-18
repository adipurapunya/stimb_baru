package com.sofa.model.stimb;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * A KartuHasilStudi.
 */
@Entity
@Table(name = "KARTUHASILSTUDI")
public class KartuHasilStudi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "semester")
    private String semester;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "ips")
    private Float ips;
    
    @Column(name = "ipk")
    private Float ipk;
    
    @Column(name = "sks_semester")
    private Float sksSemester;
    
    @Column(name = "sks_total")
    private Float sksTotal;
    
    @Column(name = "kumulatif_nilai")
    private String kumulatifNilai;

    @ManyToOne
    private NilaiMahasiswa nilaiMahasiswa;

    @OneToOne
    private MasterMahasiswa masterMahasiswa;

    @OneToOne(mappedBy = "kartuHasilStudi")
   // @JsonIgnore
    private ReffKeteranganHasilStudi reffKeteranganHasilStudi;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getIps() {
        return ips;
    }

    public void setIps(Float ips) {
        this.ips = ips;
    }

    public Float getIpk() {
        return ipk;
    }

    public void setIpk(Float ipk) {
        this.ipk = ipk;
    }

    public Float getSksSemester() {
        return sksSemester;
    }

    public void setSksSemester(Float sksSemester) {
        this.sksSemester = sksSemester;
    }

    public Float getSksTotal() {
        return sksTotal;
    }

    public void setSksTotal(Float sksTotal) {
        this.sksTotal = sksTotal;
    }

    public String getKumulatifNilai() {
        return kumulatifNilai;
    }

    public void setKumulatifNilai(String kumulatifNilai) {
        this.kumulatifNilai = kumulatifNilai;
    }

    public NilaiMahasiswa getNilaiMahasiswa() {
        return nilaiMahasiswa;
    }

    public void setNilaiMahasiswa(NilaiMahasiswa nilaiMahasiswa) {
        this.nilaiMahasiswa = nilaiMahasiswa;
    }

    public MasterMahasiswa getMasterMahasiswa() {
        return masterMahasiswa;
    }

    public void setMasterMahasiswa(MasterMahasiswa masterMahasiswa) {
        this.masterMahasiswa = masterMahasiswa;
    }

    public ReffKeteranganHasilStudi getReffKeteranganHasilStudi() {
        return reffKeteranganHasilStudi;
    }

    public void setReffKeteranganHasilStudi(ReffKeteranganHasilStudi reffKeteranganHasilStudi) {
        this.reffKeteranganHasilStudi = reffKeteranganHasilStudi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KartuHasilStudi kartuHasilStudi = (KartuHasilStudi) o;

        if ( ! Objects.equals(id, kartuHasilStudi.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "KartuHasilStudi{" +
                "id=" + id +
                ", semester='" + semester + "'" +
                ", status='" + status + "'" +
                ", ips='" + ips + "'" +
                ", ipk='" + ipk + "'" +
                ", sksSemester='" + sksSemester + "'" +
                ", sksTotal='" + sksTotal + "'" +
                ", kumulatifNilai='" + kumulatifNilai + "'" +
                '}';
    }
}
