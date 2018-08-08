/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "avisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avisos.findAll", query = "SELECT a FROM Avisos a"),
    @NamedQuery(name = "Avisos.findByIdavisos", query = "SELECT a FROM Avisos a WHERE a.idavisos = :idavisos"),
    @NamedQuery(name = "Avisos.findByInfo", query = "SELECT a FROM Avisos a WHERE a.info = :info"),
    @NamedQuery(name = "Avisos.findByEstatusaviso", query = "SELECT a FROM Avisos a WHERE a.estatusaviso = :estatusaviso")})
public class Avisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavisos")
    private Integer idavisos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 360)
    @Column(name = "info")
    private String info;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatusaviso")
    private String estatusaviso;
    @JoinColumns({
        @JoinColumn(name = "escuela", referencedColumnName = "escuela"),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel"),
        @JoinColumn(name = "grado", referencedColumnName = "grado"),
        @JoinColumn(name = "grupo", referencedColumnName = "grupo")})
    @ManyToOne(optional = false)
    private Grupo grupo;

    public Avisos() {
    }

    public Avisos(Integer idavisos) {
        this.idavisos = idavisos;
    }

    public Avisos(Integer idavisos, String info, String estatusaviso) {
        this.idavisos = idavisos;
        this.info = info;
        this.estatusaviso = estatusaviso;
    }

    public Integer getIdavisos() {
        return idavisos;
    }

    public void setIdavisos(Integer idavisos) {
        this.idavisos = idavisos;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEstatusaviso() {
        return estatusaviso;
    }

    public void setEstatusaviso(String estatusaviso) {
        this.estatusaviso = estatusaviso;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavisos != null ? idavisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avisos)) {
            return false;
        }
        Avisos other = (Avisos) object;
        if ((this.idavisos == null && other.idavisos != null) || (this.idavisos != null && !this.idavisos.equals(other.idavisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Avisos[ idavisos=" + idavisos + " ]";
    }
    
}
