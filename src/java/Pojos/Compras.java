package Pojos;
// Generated 4/01/2017 09:04:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compras generated by hbm2java
 */
public class Compras  implements java.io.Serializable {


     private Integer idcompras;
     private Empleado empleado;
     private Proveedor proveedor;
     private Long subtotal;
     private Long iva;
     private Long preciototal;
     private Date fechaCompra;
     private Set compradetalles = new HashSet(0);

    public Compras() {
    }

	
    public Compras(Empleado empleado, Proveedor proveedor, Date fechaCompra) {
        this.empleado = empleado;
        this.proveedor = proveedor;
        this.fechaCompra = fechaCompra;
    }
    public Compras(Empleado empleado, Proveedor proveedor, Long subtotal, Long iva, Long preciototal, Date fechaCompra, Set compradetalles) {
       this.empleado = empleado;
       this.proveedor = proveedor;
       this.subtotal = subtotal;
       this.iva = iva;
       this.preciototal = preciototal;
       this.fechaCompra = fechaCompra;
       this.compradetalles = compradetalles;
    }
   
    public Integer getIdcompras() {
        return this.idcompras;
    }
    
    public void setIdcompras(Integer idcompras) {
        this.idcompras = idcompras;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
    public Date getFechaCompra() {
        return this.fechaCompra;
    }
    
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public Set getCompradetalles() {
        return this.compradetalles;
    }
    
    public void setCompradetalles(Set compradetalles) {
        this.compradetalles = compradetalles;
    }




}


