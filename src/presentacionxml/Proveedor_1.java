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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "proveedor", catalog = "pruebafacturas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proveedor_1.findAll", query = "SELECT p FROM Proveedor_1 p"),
    @NamedQuery(name = "Proveedor_1.findByRuc", query = "SELECT p FROM Proveedor_1 p WHERE p.ruc = :ruc"),
    @NamedQuery(name = "Proveedor_1.findByNombre", query = "SELECT p FROM Proveedor_1 p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedor_1.findByApellido", query = "SELECT p FROM Proveedor_1 p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Proveedor_1.findByTelefono", query = "SELECT p FROM Proveedor_1 p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor_1.findByEmail", query = "SELECT p FROM Proveedor_1 p WHERE p.email = :email"),
    @NamedQuery(name = "Proveedor_1.findByIdProveedor", query = "SELECT p FROM Proveedor_1 p WHERE p.idProveedor = :idProveedor")})
public class Proveedor_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "ruc")
    private Integer ruc;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    public Proveedor_1() {
    }

    public Proveedor_1(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        Integer oldRuc = this.ruc;
        this.ruc = ruc;
        changeSupport.firePropertyChange("ruc", oldRuc, ruc);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        Integer oldIdProveedor = this.idProveedor;
        this.idProveedor = idProveedor;
        changeSupport.firePropertyChange("idProveedor", oldIdProveedor, idProveedor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor_1)) {
            return false;
        }
        Proveedor_1 other = (Proveedor_1) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "presentacionxml.Proveedor_1[ idProveedor=" + idProveedor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
