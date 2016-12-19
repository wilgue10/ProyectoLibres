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
@Table(name = "infofactura", catalog = "pruebafacturas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Infofactura.findAll", query = "SELECT i FROM Infofactura i"),
    @NamedQuery(name = "Infofactura.findByContribuyenteEspecial", query = "SELECT i FROM Infofactura i WHERE i.contribuyenteEspecial = :contribuyenteEspecial"),
    @NamedQuery(name = "Infofactura.findByIdinfFact", query = "SELECT i FROM Infofactura i WHERE i.idinfFact = :idinfFact")})
public class Infofactura implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Lob
    @Column(name = "dirEstablecimiento")
    private String dirEstablecimiento;
    @Basic(optional = false)
    @Column(name = "contribuyenteEspecial")
    private int contribuyenteEspecial;
    @Basic(optional = false)
    @Lob
    @Column(name = "obligadoContabilidad")
    private String obligadoContabilidad;
    @Basic(optional = false)
    @Lob
    @Column(name = "tipoIdentificacionComprador")
    private String tipoIdentificacionComprador;
    @Basic(optional = false)
    @Lob
    @Column(name = "razonSocialComprador")
    private String razonSocialComprador;
    @Basic(optional = false)
    @Lob
    @Column(name = "identificacionComprador")
    private String identificacionComprador;
    @Basic(optional = false)
    @Lob
    @Column(name = "totalSinImpuestos")
    private String totalSinImpuestos;
    @Basic(optional = false)
    @Lob
    @Column(name = "totalDescuento")
    private String totalDescuento;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_infFact")
    private Integer idinfFact;

    public Infofactura() {
    }

    public Infofactura(Integer idinfFact) {
        this.idinfFact = idinfFact;
    }

    public Infofactura(Integer idinfFact, String dirEstablecimiento, int contribuyenteEspecial, String obligadoContabilidad, String tipoIdentificacionComprador, String razonSocialComprador, String identificacionComprador, String totalSinImpuestos, String totalDescuento) {
        this.idinfFact = idinfFact;
        this.dirEstablecimiento = dirEstablecimiento;
        this.contribuyenteEspecial = contribuyenteEspecial;
        this.obligadoContabilidad = obligadoContabilidad;
        this.tipoIdentificacionComprador = tipoIdentificacionComprador;
        this.razonSocialComprador = razonSocialComprador;
        this.identificacionComprador = identificacionComprador;
        this.totalSinImpuestos = totalSinImpuestos;
        this.totalDescuento = totalDescuento;
    }

    public String getDirEstablecimiento() {
        return dirEstablecimiento;
    }

    public void setDirEstablecimiento(String dirEstablecimiento) {
        String oldDirEstablecimiento = this.dirEstablecimiento;
        this.dirEstablecimiento = dirEstablecimiento;
        changeSupport.firePropertyChange("dirEstablecimiento", oldDirEstablecimiento, dirEstablecimiento);
    }

    public int getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    public void setContribuyenteEspecial(int contribuyenteEspecial) {
        int oldContribuyenteEspecial = this.contribuyenteEspecial;
        this.contribuyenteEspecial = contribuyenteEspecial;
        changeSupport.firePropertyChange("contribuyenteEspecial", oldContribuyenteEspecial, contribuyenteEspecial);
    }

    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    public void setObligadoContabilidad(String obligadoContabilidad) {
        String oldObligadoContabilidad = this.obligadoContabilidad;
        this.obligadoContabilidad = obligadoContabilidad;
        changeSupport.firePropertyChange("obligadoContabilidad", oldObligadoContabilidad, obligadoContabilidad);
    }

    public String getTipoIdentificacionComprador() {
        return tipoIdentificacionComprador;
    }

    public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
        String oldTipoIdentificacionComprador = this.tipoIdentificacionComprador;
        this.tipoIdentificacionComprador = tipoIdentificacionComprador;
        changeSupport.firePropertyChange("tipoIdentificacionComprador", oldTipoIdentificacionComprador, tipoIdentificacionComprador);
    }

    public String getRazonSocialComprador() {
        return razonSocialComprador;
    }

    public void setRazonSocialComprador(String razonSocialComprador) {
        String oldRazonSocialComprador = this.razonSocialComprador;
        this.razonSocialComprador = razonSocialComprador;
        changeSupport.firePropertyChange("razonSocialComprador", oldRazonSocialComprador, razonSocialComprador);
    }

    public String getIdentificacionComprador() {
        return identificacionComprador;
    }

    public void setIdentificacionComprador(String identificacionComprador) {
        String oldIdentificacionComprador = this.identificacionComprador;
        this.identificacionComprador = identificacionComprador;
        changeSupport.firePropertyChange("identificacionComprador", oldIdentificacionComprador, identificacionComprador);
    }

    public String getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(String totalSinImpuestos) {
        String oldTotalSinImpuestos = this.totalSinImpuestos;
        this.totalSinImpuestos = totalSinImpuestos;
        changeSupport.firePropertyChange("totalSinImpuestos", oldTotalSinImpuestos, totalSinImpuestos);
    }

    public String getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(String totalDescuento) {
        String oldTotalDescuento = this.totalDescuento;
        this.totalDescuento = totalDescuento;
        changeSupport.firePropertyChange("totalDescuento", oldTotalDescuento, totalDescuento);
    }

    public Integer getIdinfFact() {
        return idinfFact;
    }

    public void setIdinfFact(Integer idinfFact) {
        Integer oldIdinfFact = this.idinfFact;
        this.idinfFact = idinfFact;
        changeSupport.firePropertyChange("idinfFact", oldIdinfFact, idinfFact);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfFact != null ? idinfFact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infofactura)) {
            return false;
        }
        Infofactura other = (Infofactura) object;
        if ((this.idinfFact == null && other.idinfFact != null) || (this.idinfFact != null && !this.idinfFact.equals(other.idinfFact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "presentacionxml.Infofactura[ idinfFact=" + idinfFact + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
