package Pojos;
// Generated 4/01/2017 09:04:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Facturas generated by hbm2java
 */
public class Facturas  implements java.io.Serializable {


     private Integer idfacturas;
     private Cliente cliente;
     private Empleado empleado;
     private Long subtotal;
     private Long iva;
     private Long preciototal;
     private Date fechaventa;
     private Set ventanadetalles = new HashSet(0);

    public Facturas() {
    }

	
    public Facturas(Cliente cliente, Empleado empleado, Date fechaventa) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaventa = fechaventa;
    }
    public Facturas(Cliente cliente, Empleado empleado, Long subtotal, Long iva, Long preciototal, Date fechaventa, Set ventanadetalles) {
       this.cliente = cliente;
       this.empleado = empleado;
       this.subtotal = subtotal;
       this.iva = iva;
       this.preciototal = preciototal;
       this.fechaventa = fechaventa;
       this.ventanadetalles = ventanadetalles;
    }
   
    public Integer getIdfacturas() {
        return this.idfacturas;
    }
    
    public void setIdfacturas(Integer idfacturas) {
        this.idfacturas = idfacturas;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Long getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }
    public Long getIva() {
        return this.iva;
    }
    
    public void setIva(Long iva) {
        this.iva = iva;
    }
    public Long getPreciototal() {
        return this.preciototal;
    }
    
    public void setPreciototal(Long preciototal) {
        this.preciototal = preciototal;
    }
    public Date getFechaventa() {
        return this.fechaventa;
    }
    
    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }
    public Set getVentanadetalles() {
        return this.ventanadetalles;
    }
    
    public void setVentanadetalles(Set ventanadetalles) {
        this.ventanadetalles = ventanadetalles;
    }




}

