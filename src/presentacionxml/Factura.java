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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "factura", catalog = "libresfacturaproyecto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByCodigo", query = "SELECT f FROM Factura f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Factura.findByCedula", query = "SELECT f FROM Factura f WHERE f.cedula = :cedula"),
    @NamedQuery(name = "Factura.findByRuc", query = "SELECT f FROM Factura f WHERE f.ruc = :ruc"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByTotalSinIva", query = "SELECT f FROM Factura f WHERE f.totalSinIva = :totalSinIva"),
    @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva"),
    @NamedQuery(name = "Factura.findByTotalConIva", query = "SELECT f FROM Factura f WHERE f.totalConIva = :totalConIva"),
    @NamedQuery(name = "Factura.findByVivienda", query = "SELECT f FROM Factura f WHERE f.vivienda = :vivienda"),
    @NamedQuery(name = "Factura.findByAlimentacion", query = "SELECT f FROM Factura f WHERE f.alimentacion = :alimentacion"),
    @NamedQuery(name = "Factura.findBySalud", query = "SELECT f FROM Factura f WHERE f.salud = :salud"),
    @NamedQuery(name = "Factura.findByEducacion", query = "SELECT f FROM Factura f WHERE f.educacion = :educacion"),
    @NamedQuery(name = "Factura.findByVestimenta", query = "SELECT f FROM Factura f WHERE f.vestimenta = :vestimenta"),
    @NamedQuery(name = "Factura.findByOtros", query = "SELECT f FROM Factura f WHERE f.otros = :otros"),
    @NamedQuery(name = "Factura.findByNumeroFactura", query = "SELECT f FROM Factura f WHERE f.numeroFactura = :numeroFactura")})
public class Factura implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "RUC")
    private String ruc;
    @Column(name = "FECHA")
    private String fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_SIN_IVA")
    private Float totalSinIva;
    @Column(name = "IVA")
    private Float iva;
    @Column(name = "TOTAL_CON_IVA")
    private Float totalConIva;
    @Column(name = "VIVIENDA")
    private Long vivienda;
    @Column(name = "ALIMENTACION")
    private Long alimentacion;
    @Column(name = "SALUD")
    private Long salud;
    @Column(name = "EDUCACION")
    private Long educacion;
    @Column(name = "VESTIMENTA")
    private Long vestimenta;
    @Column(name = "OTROS")
    private Long otros;
    @Basic(optional = false)
    @Column(name = "NUMERO_FACTURA")
    private String numeroFactura;

    public Factura() {
    }

    public Factura(String codigo) {
        this.codigo = codigo;
    }

    public Factura(String codigo, String numeroFactura) {
        this.codigo = codigo;
        this.numeroFactura = numeroFactura;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        String oldCedula = this.cedula;
        this.cedula = cedula;
        changeSupport.firePropertyChange("cedula", oldCedula, cedula);
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        String oldRuc = this.ruc;
        this.ruc = ruc;
        changeSupport.firePropertyChange("ruc", oldRuc, ruc);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        String oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Float getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(Float totalSinIva) {
        Float oldTotalSinIva = this.totalSinIva;
        this.totalSinIva = totalSinIva;
        changeSupport.firePropertyChange("totalSinIva", oldTotalSinIva, totalSinIva);
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        Float oldIva = this.iva;
        this.iva = iva;
        changeSupport.firePropertyChange("iva", oldIva, iva);
    }

    public Float getTotalConIva() {
        return totalConIva;
    }

    public void setTotalConIva(Float totalConIva) {
        Float oldTotalConIva = this.totalConIva;
        this.totalConIva = totalConIva;
        changeSupport.firePropertyChange("totalConIva", oldTotalConIva, totalConIva);
    }

    public Long getVivienda() {
        return vivienda;
    }

    public void setVivienda(Long vivienda) {
        Long oldVivienda = this.vivienda;
        this.vivienda = vivienda;
        changeSupport.firePropertyChange("vivienda", oldVivienda, vivienda);
    }

    public Long getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(Long alimentacion) {
        Long oldAlimentacion = this.alimentacion;
        this.alimentacion = alimentacion;
        changeSupport.firePropertyChange("alimentacion", oldAlimentacion, alimentacion);
    }

    public Long getSalud() {
        return salud;
    }

    public void setSalud(Long salud) {
        Long oldSalud = this.salud;
        this.salud = salud;
        changeSupport.firePropertyChange("salud", oldSalud, salud);
    }

    public Long getEducacion() {
        return educacion;
    }

    public void setEducacion(Long educacion) {
        Long oldEducacion = this.educacion;
        this.educacion = educacion;
        changeSupport.firePropertyChange("educacion", oldEducacion, educacion);
    }

    public Long getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(Long vestimenta) {
        Long oldVestimenta = this.vestimenta;
        this.vestimenta = vestimenta;
        changeSupport.firePropertyChange("vestimenta", oldVestimenta, vestimenta);
    }

    public Long getOtros() {
        return otros;
    }

    public void setOtros(Long otros) {
        Long oldOtros = this.otros;
        this.otros = otros;
        changeSupport.firePropertyChange("otros", oldOtros, otros);
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        String oldNumeroFactura = this.numeroFactura;
        this.numeroFactura = numeroFactura;
        changeSupport.firePropertyChange("numeroFactura", oldNumeroFactura, numeroFactura);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "presentacionxml.Factura[ codigo=" + codigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
