/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionxml;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "infotributaria", catalog = "pruebafacturas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Infotributaria.findAll", query = "SELECT i FROM Infotributaria i"),
    @NamedQuery(name = "Infotributaria.findByAmbiente", query = "SELECT i FROM Infotributaria i WHERE i.ambiente = :ambiente"),
    @NamedQuery(name = "Infotributaria.findByTipoEmision", query = "SELECT i FROM Infotributaria i WHERE i.tipoEmision = :tipoEmision"),
    @NamedQuery(name = "Infotributaria.findByCodDoc", query = "SELECT i FROM Infotributaria i WHERE i.codDoc = :codDoc"),
    @NamedQuery(name = "Infotributaria.findByEstab", query = "SELECT i FROM Infotributaria i WHERE i.estab = :estab"),
    @NamedQuery(name = "Infotributaria.findByPtoEmi", query = "SELECT i FROM Infotributaria i WHERE i.ptoEmi = :ptoEmi"),
    @NamedQuery(name = "Infotributaria.findById", query = "SELECT i FROM Infotributaria i WHERE i.id = :id")})
public class Infotributaria implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ambiente")
    private int ambiente;
    @Basic(optional = false)
    @Column(name = "tipoEmision")
    private int tipoEmision;
    @Basic(optional = false)
    @Lob
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @Lob
    @Column(name = "nombreComercial")
    private String nombreComercial;
    @Basic(optional = false)
    @Lob
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Lob
    @Column(name = "claveAcceso")
    private String claveAcceso;
    @Basic(optional = false)
    @Column(name = "codDoc")
    private int codDoc;
    @Basic(optional = false)
    @Column(name = "estab")
    private int estab;
    @Basic(optional = false)
    @Column(name = "ptoEmi")
    private int ptoEmi;
    @Basic(optional = false)
    @Lob
    @Column(name = "secuencial")
    private String secuencial;
    @Basic(optional = false)
    @Lob
    @Column(name = "dirMatriz")
    private String dirMatriz;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Infotributaria() {
    }

    public Infotributaria(Integer id) {
        this.id = id;
    }

    public Infotributaria(Integer id, int ambiente, int tipoEmision, String razonSocial, String nombreComercial, String ruc, String claveAcceso, int codDoc, int estab, int ptoEmi, String secuencial, String dirMatriz) {
        this.id = id;
        this.ambiente = ambiente;
        this.tipoEmision = tipoEmision;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.ruc = ruc;
        this.claveAcceso = claveAcceso;
        this.codDoc = codDoc;
        this.estab = estab;
        this.ptoEmi = ptoEmi;
        this.secuencial = secuencial;
        this.dirMatriz = dirMatriz;
    }

    public int getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(int ambiente) {
        int oldAmbiente = this.ambiente;
        this.ambiente = ambiente;
        changeSupport.firePropertyChange("ambiente", oldAmbiente, ambiente);
    }

    public int getTipoEmision() {
        return tipoEmision;
    }

    public void setTipoEmision(int tipoEmision) {
        int oldTipoEmision = this.tipoEmision;
        this.tipoEmision = tipoEmision;
        changeSupport.firePropertyChange("tipoEmision", oldTipoEmision, tipoEmision);
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        String oldRazonSocial = this.razonSocial;
        this.razonSocial = razonSocial;
        changeSupport.firePropertyChange("razonSocial", oldRazonSocial, razonSocial);
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        String oldNombreComercial = this.nombreComercial;
        this.nombreComercial = nombreComercial;
        changeSupport.firePropertyChange("nombreComercial", oldNombreComercial, nombreComercial);
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        String oldRuc = this.ruc;
        this.ruc = ruc;
        changeSupport.firePropertyChange("ruc", oldRuc, ruc);
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        String oldClaveAcceso = this.claveAcceso;
        this.claveAcceso = claveAcceso;
        changeSupport.firePropertyChange("claveAcceso", oldClaveAcceso, claveAcceso);
    }

    public int getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(int codDoc) {
        int oldCodDoc = this.codDoc;
        this.codDoc = codDoc;
        changeSupport.firePropertyChange("codDoc", oldCodDoc, codDoc);
    }

    public int getEstab() {
        return estab;
    }

    public void setEstab(int estab) {
        int oldEstab = this.estab;
        this.estab = estab;
        changeSupport.firePropertyChange("estab", oldEstab, estab);
    }

    public int getPtoEmi() {
        return ptoEmi;
    }

    public void setPtoEmi(int ptoEmi) {
        int oldPtoEmi = this.ptoEmi;
        this.ptoEmi = ptoEmi;
        changeSupport.firePropertyChange("ptoEmi", oldPtoEmi, ptoEmi);
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(String secuencial) {
        String oldSecuencial = this.secuencial;
        this.secuencial = secuencial;
        changeSupport.firePropertyChange("secuencial", oldSecuencial, secuencial);
    }

    public String getDirMatriz() {
        return dirMatriz;
    }

    public void setDirMatriz(String dirMatriz) {
        String oldDirMatriz = this.dirMatriz;
        this.dirMatriz = dirMatriz;
        changeSupport.firePropertyChange("dirMatriz", oldDirMatriz, dirMatriz);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infotributaria)) {
            return false;
        }
        Infotributaria other = (Infotributaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "presentacionxml.Infotributaria[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
