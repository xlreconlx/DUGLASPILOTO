/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MbView;

import Daos.DaoAccesorios;
import Daos.DaoCompraDetalle;
import Daos.DaoCompras;
import Daos.DaoEmpleado;
import Daos.DaoProveedor;
import HibernateUtil.HibernateUtil;
import Pojos.Accesorios;
import Pojos.Compradetalle;
import Pojos.Compras;
import Pojos.Empleado;
import Pojos.Productos;
import Pojos.Proveedor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author William Sanchez
 */
@ManagedBean
@ViewScoped
public class MbCompra {

    /**
     * Creates a new instance of MbCompra
     */
    Session session;
    Transaction transaction;
    private Productos productos;

    private List<Compras> listaComprasFiltrado;
    private List<Compras> listaCompras;
    private List<Compras> listaComprasByFecha;
    private Compras compras;
    private List<Compradetalle> listaCompraDetalle;
    private Empleado empleado;
    private Proveedor proveedor;
    private List<Proveedor> listaProveedor;
    private int codigoEmpleado;
    private int codigoProveedor;
    private Date fechaFin;
    private Date fechaInicio;
    private BigDecimal totalCompraFecha;
    private BigDecimal montoDineroA;
    private BigDecimal saldoDevueltaA;
    private Accesorios accesorios;
    private List<Accesorios> listaAcesorios;
    private int idCompra;
       private String productoSelecionado;
        private String cantidadProducto;

    public MbCompra() {
        this.compras = new Compras();
        this.accesorios = new Accesorios();
        this.listaCompraDetalle = new ArrayList<>();
        this.listaAcesorios = new ArrayList<>();
    }

    public List<Accesorios> getAllAccesorios() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.transaction = this.session.beginTransaction();
            this.listaAcesorios = daoAccesorios.getAll(session);

            this.transaction.commit();

            return this.listaAcesorios;
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
//        metodo para pedir la cnatidad del producto selecionado
    public void pedirCantidadProducto(String codBarra) {
        this.productoSelecionado = codBarra;
    }
    
    public void agregarListCompraDetalle() {
        this.session = null;
        this.transaction = null;
        
        try {
              if (!(this.cantidadProducto.matches("[0-9]")) || this.cantidadProducto.equals("0") || this.cantidadProducto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La cantidad es incorrecta"));
            
                
            } else {
            this.session = HibernateUtil.getSessionFactory().openSession();

                DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.transaction = this.session.beginTransaction();

            this.accesorios = daoAccesorios.getByCodigoBarras(this.session,this.productoSelecionado);
           
            this.listaCompraDetalle.add(new Compradetalle( this.accesorios,null, this.accesorios.getNombre(),this.accesorios.getCodigoBrras(), Integer.parseInt(this.cantidadProducto), this.accesorios.getPrecioCosto(),Long.parseLong(this.cantidadProducto)* this.accesorios.getPrecioCosto()));

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Productos agregado"));
//           llamamos al metodo calcular total compra
                this.calcularCostos();
//            RequestContext.getCurrentInstance().update("frmRealizarCompra:tablaListaProductosCompra");
//            RequestContext.getCurrentInstance().update("frmRealizarCompra:mensajeGeneral");
              }
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void retirarListaCompraDetalle(String nombre) {
        try {
            int i = 0;

            for (Compradetalle item : this.listaCompraDetalle) {
                if (item.getNombre().equals(nombre)) {
                    this.listaCompraDetalle.remove(i);

                    break;
                }

                i++;
            }
            long total = 0;

            for (Compradetalle item : this.listaCompraDetalle) {
                item.setTotal(item.getCantidad() * item.getPrecioCompra());
                total = total + item.getTotal();

            }

            this.compras.setSubtotal(this.compras.getPreciototal() - this.compras.getIva());
            this.compras.setIva(this.compras.getPreciototal() * 16 / 100);
            this.compras.setPreciototal(total);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Productos retirado de la lista de ventas"));

//            RequestContext.getCurrentInstance().update("frmRealizarCompra:tablaListaProductosCompra");
//            RequestContext.getCurrentInstance().update("frmRealizarCompra:panelFinalCompra");
//            RequestContext.getCurrentInstance().update("frmRealizarCompra:mensajeGeneral");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    public void calcularCostos() {
        long total = 0;
        try {
            for (Compradetalle item : this.listaCompraDetalle) {
                item.setTotal(item.getCantidad() * item.getPrecioCompra());
                total = total + item.getTotal();

            }
            this.compras.setSubtotal(this.compras.getPreciototal() - this.compras.getIva());
            this.compras.setIva(this.compras.getPreciototal() * 16 / 100);
            this.compras.setPreciototal(total);

//            RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    public List<Compras> getAll() {

        this.session = null;
        this.transaction = null;

        try {
            DaoCompras daoCompras = new DaoCompras();
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();

            this.listaCompras = daoCompras.getAll(session);
            this.transaction.commit();
            return this.listaCompras;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void realizarCompra() {
        this.session = null;
        this.transaction = null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String correoEmple = httpSession.getAttribute("correoElectronico").toString();
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoCompras daoCompra = new DaoCompras();
            DaoCompraDetalle daoCompraDetalle = new DaoCompraDetalle();
            DaoEmpleado daoempleado = new DaoEmpleado();
            DaoProveedor daoProveedor = new DaoProveedor();

             if (this.proveedor==null ) {
   
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor selecione un cliente."));
                return;
            }
            this.transaction = this.session.beginTransaction();
            this.compras.setIdcompras(idCompra + 1);
            this.compras.setProveedor(proveedor);
            this.compras.setEmpleado(daoempleado.getByCorreoElectronico(this.session, correoEmple));
            this.compras.setFechaCompra(new Date());
            daoCompra.insert(this.session, this.compras);
            this.compras = daoCompra.getUltimoRegistro(this.session);
            long suma = 0;
            long subtota = 0;
            long ivat = 0;
            for (Compradetalle item : this.listaCompraDetalle) {

                item.setAccesorios(this.accesorios);
                 item.setCompras(this.compras);
                suma = item.getTotal();
                ivat = this.compras.getPreciototal() * 16 / 100;
//                this.subtota = this.compras.getPreciototal() - ivat;

                daoCompraDetalle.insert(this.session, item);
            }

            this.transaction.commit();

            this.listaCompraDetalle = new ArrayList<>();
            this.compras = new Compras();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Venta realizada correctamente"));
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
  
    }

    public void consultarCompras() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            DaoCompras daoCompras = new DaoCompras();

            this.listaComprasByFecha = daoCompras.getAllFecha(this.session, this.fechaInicio, this.fechaFin);
            long totalCompraFecha = 0;

            for (Compras compra : listaComprasByFecha) {
                totalCompraFecha = totalCompraFecha + compras.getPreciototal();
            }
            this.transaction.commit();
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    //    aqui comienza el codigo nuevo 
    public void agregarDatosProveedor(Integer codProveedor) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoProveedor daoProveedor = new DaoProveedor();
            this.transaction = this.session.beginTransaction();
            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente
            this.proveedor = daoProveedor.getByCodigoProveedor(this.session, codProveedor);

            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
        } catch (Exception e) {
            if (this.transaction != null) {
                System.out.println(e.getMessage());
                transaction.rollback();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));

            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void agregarDatosProveedor2() {
        this.session = null;
        this.transaction = null;
        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            DaoProveedor daoProveedor = new DaoProveedor();
            this.transaction = this.session.beginTransaction();
            //obtener los datos del producto en la variable objecto cliente segun el codigo del cliente

            this.proveedor = daoProveedor.getByCodigoProveedor(this.session, this.codigoProveedor);

//            if (this.proveedor != null) {
//                this.codigoCliente = null;
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Cliente Agregado"));
//
//            } else {
//                this.codigoCliente = null;
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El cliente no fue encontrado"));
//            }
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
        } catch (Exception e) {
            if (this.transaction != null) {
                System.out.println(e.getMessage());
                transaction.rollback();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));

            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void limpiarCompra() {

        this.proveedor = new Proveedor();
        this.empleado = new Empleado();
        this.compras = new Compras();
        this.listaCompraDetalle = new ArrayList<>();

//        invocar el metodo para destivar controles en a factura
        this.disableButton();

    }

    public List<Proveedor> getAllProveedor() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoProveedor daoProveedor = new DaoProveedor();

            this.transaction = this.session.beginTransaction();

            this.listaProveedor = daoProveedor.getAll(this.session);

            this.transaction.commit();

            return this.listaProveedor;
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    
    
    public void onRowEdit(RowEditEvent Event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO:", "Producto editado "));

//                invocamos al metodo calculartotalfactura para actualizar la factura
        this.calcularCostos();
    }

    public void onRowEditCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "...:", "No se hizo ningun cambio "));

    }

//    metodos para activar o desativar los botnes del sistema
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;

    }

    public void enebleButton() {
        enabled = true;
    }

    public void disableButton() {
        enabled = false;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public List<Compras> getListaComprasFiltrado() {
        return listaComprasFiltrado;
    }

    public void setListaComprasFiltrado(List<Compras> listaComprasFiltrado) {
        this.listaComprasFiltrado = listaComprasFiltrado;
    }

    public List<Compras> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public List<Compradetalle> getListaCompraDetalle() {
        return listaCompraDetalle;
    }

    public void setListaCompraDetalle(List<Compradetalle> listaCompraDetalle) {
        this.listaCompraDetalle = listaCompraDetalle;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Compras> getListaComprasByFecha() {
        return listaComprasByFecha;
    }

    public void setListaComprasByFecha(List<Compras> listaComprasByFecha) {
        this.listaComprasByFecha = listaComprasByFecha;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BigDecimal getTotalCompraFecha() {
        return totalCompraFecha;
    }

    public void setTotalCompraFecha(BigDecimal totalCompraFecha) {
        this.totalCompraFecha = totalCompraFecha;
    }

    public BigDecimal getMontoDineroA() {
        return montoDineroA;
    }

    public void setMontoDineroA(BigDecimal montoDineroA) {
        this.montoDineroA = montoDineroA;
    }

    public BigDecimal getSaldoDevueltaA() {
        return saldoDevueltaA;
    }

    public void setSaldoDevueltaA(BigDecimal saldoDevueltaA) {
        this.saldoDevueltaA = saldoDevueltaA;
    }

    public Accesorios getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Accesorios accesorios) {
        this.accesorios = accesorios;
    }

    public List<Accesorios> getListaAcesorios() {
        return listaAcesorios;
    }

    public void setListaAcesorios(List<Accesorios> listaAcesorios) {
        this.listaAcesorios = listaAcesorios;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

  

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public String getProductoSelecionado() {
        return productoSelecionado;
    }

    public void setProductoSelecionado(String productoSelecionado) {
        this.productoSelecionado = productoSelecionado;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

}
