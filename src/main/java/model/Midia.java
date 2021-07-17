/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "midia", catalog = "locadora", schema = "")
public class Midia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_midia")
    private Integer idMidia;
    @Basic(optional = false)
    @Column(name = "inutilizada")
    private boolean inutilizada;
    @JoinColumn(name = "id_filme", referencedColumnName = "id_filme")
    @ManyToOne(optional = false)
    private Filme idFilme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMidia")
    private Collection<Locacao> locacaoCollection;

    public Midia() {
    }

    public Midia(Integer idMidia) {
        this.idMidia = idMidia;
    }

    public Midia(Integer idMidia, boolean inutilizada) {
        this.idMidia = idMidia;
        this.inutilizada = inutilizada;
    }

    public Integer getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(Integer idMidia) {
        this.idMidia = idMidia;
    }

    public boolean getInutilizada() {
        return inutilizada;
    }

    public void setInutilizada(boolean inutilizada) {
        this.inutilizada = inutilizada;
    }

    public Filme getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Filme idFilme) {
        this.idFilme = idFilme;
    }

    public Collection<Locacao> getLocacaoCollection() {
        return locacaoCollection;
    }

    public void setLocacaoCollection(Collection<Locacao> locacaoCollection) {
        this.locacaoCollection = locacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMidia != null ? idMidia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Midia)) {
            return false;
        }
        Midia other = (Midia) object;
        if ((this.idMidia == null && other.idMidia != null) || (this.idMidia != null && !this.idMidia.equals(other.idMidia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Midia[ idMidia=" + idMidia + " ]";
    }
    
}
