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
import Pojos.Proveedor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
public class BeanCompras {

    /**
     * Creates a new instance of BeanCompras
     */
    Session session = null;
    Transaction transaction = null;
    private List<Compras> listaComprasFiltrado;
    private List<Compras> listaCompras;
    private List<Compras> listaComprasByFecha;
    private Compras compras;
    private Proveedor proveedor;
    private List<Proveedor> listaProveedor;
    private Integer codigoProveedor;
    private Accesorios accesorios;
    private List<Accesorios> listaAccesorios;
    private String codigoBarra;
    private Compradetalle detalleCompra;
    private List<Compradetalle> listaCompraDetalle;
    private String cantidadProducto;
    private String productoSelecionado;
    private String cantidadProducto2;
    private Long totalCompra;
    private Empleado empleado;
    private int idCompra;
    private Long numeroDocumento;

    public BeanCompras() {
        this.listaCompraDetalle = new ArrayList<>();
        this.proveedor = new Proveedor();
        this.accesorios = new Accesorios();
        this.listaAccesorios = new ArrayList<>();
        this.compras = new Compras();
    }

    public void agregarDatosCliente(Integer codProveedor) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoProveedor daoProveedor = new DaoProveedor();
            this.transaction = this.session.beginTransaction();
            //obtener los datos del proveedor en la variable objecto proveedor segun el codigo del cliente

            this.proveedor = daoProveedor.getByCodigoProveedor(this.session, codProveedor);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado "));
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

    public void agregarDatosCliente2() {
        this.session = null;
        this.transaction = null;
        try {
            if (this.codigoProveedor == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            DaoProveedor daoProveedor = new DaoProveedor();
            this.transaction = this.session.beginTransaction();
            //obtener los datos del producto en la variable objecto cliente segun el codigo del cliente

            this.proveedor = daoProveedor.getByCodigoProveedor(this.session, this.codigoProveedor);

            if (this.proveedor != null) {
                this.codigoProveedor = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Cliente Agregado"));

            } else {
                this.codigoProveedor = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El cliente no fue encontrado"));
            }
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado"));
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

//        metodo para pedir la cnatidad del producto selecionado
    public void pedirCantidadProducto(String codBarra) {
        this.productoSelecionado = codBarra;
    }

    public void agregarDatosProducto() {
        this.session = null;
        this.transaction = null;
        try {

            if (!(this.cantidadProducto.matches("[0-9]")) || this.cantidadProducto.equals("0") || this.cantidadProducto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La cantidad es incorrecta"));

            } else {
                this.session = HibernateUtil.getSessionFactory().openSession();
                this.transaction = this.session.beginTransaction();
                DaoAccesorios daoAccesorios = new DaoAccesorios();

                //obtener los datos del productos en la variable objecto cliente segun el codigo del cliente  
                this.accesorios = daoAccesorios.getByCodigoBarras(this.session, this.productoSelecionado);
                for (Compradetalle item : listaCompraDetalle) {
                    if (this.accesorios.getCodigoBrras().equals(item.getCodigobarras())) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "el producto ya esta agregado"));
                        return;
                    }
                }
                this.listaCompraDetalle.add(new Compradetalle(this.accesorios, null, this.accesorios.getNombre(), this.accesorios.getCodigoBrras(), Integer.parseInt(this.cantidadProducto), this.accesorios.getPrecioCosto(),
                        Long.valueOf(this.cantidadProducto) * this.accesorios.getPrecioCosto()));

                this.transaction.commit();
                this.cantidadProducto = null;

//           llamamos al metodo calcular total factura venta
                this.CalculartotalFacturaVenta();
            }

        } catch (Exception e) {
            if (this.transaction != null) {
                System.out.println(e.getMessage());
                transaction.rollback();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo metodo 1"));

            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

//           este metodo es para llamarlo desde un input de codigo de barra
    public void agregarDatosProducto2() {
        DaoAccesorios daoAccesorios = new DaoAccesorios();
        if (!(this.cantidadProducto2.matches("[0-9]")) || this.cantidadProducto2.equals("0") || this.cantidadProducto2.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La cantidad es incorrecta"));

        } else {

            this.listaCompraDetalle.add(new Compradetalle(this.accesorios, null, this.accesorios.getNombre(), this.accesorios.getCodigoBrras(), Integer.parseInt(this.cantidadProducto2), this.accesorios.getPrecioCosto(),
                    Long.parseLong(this.cantidadProducto2) * this.accesorios.getPrecioCosto()));

            this.cantidadProducto2 = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El producto agregado correctamente al detalle"));
            this.CalculartotalFacturaVenta();
        }
    }
//    para mostrar los datos cuando se pone en el input de codigo de barras

    public void mostrarCantidadProducto2() {
        this.session = null;
        this.transaction = null;
        try {
            if (this.codigoBarra.equals("")) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            DaoAccesorios daoAccesorios = new DaoAccesorios();
            this.accesorios = daoAccesorios.getByCodigoBarras(this.session, this.codigoBarra);

//          mostrar dialogo cantidad producto2
            if (this.accesorios != null) {
                RequestContext contex = RequestContext.getCurrentInstance();
                contex.execute("PF('dialogoCantidadProducto2').show()");
                this.codigoBarra = null;

            } else {
                this.codigoBarra = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El producto agregado correctamente"));

            }

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El producto agregado correctamente"));
//           llamamos al metodo total venta factura
            this.CalculartotalFacturaVenta();
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

    public void CalculartotalFacturaVenta() {
        this.totalCompra = 0L;
        long total = 0;
        try {
            for (Compradetalle item : listaCompraDetalle) {
                System.out.println("vamos en la lista");
                item.setTotal(item.getCantidad() * item.getPrecioCompra());
                System.out.println("sumamamos las cantidades");
                total = total + item.getTotal();
                System.out.println("totalizamos ");
                totalCompra = totalCompra + total;
            }
            System.out.println("despues del for");
            this.compras.setPreciototal(totalCompra);
            System.out.println("valor total ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "ERROR:", "El Calculo fue erroneo"));

        }
    }

//    metodo para quitar un producto de la factura
    public void retirarProducto(String codigoBarra, Integer filaseleccionada) {
        try {
            int i = 0;
            for (Compradetalle item : listaCompraDetalle) {
                if (item.getCodigobarras().equals(codigoBarra) && filaseleccionada.equals(i)) {
                    this.listaCompraDetalle.remove(i);
                    break;
                }
                i++;
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO:", "Producto retirado de la lista "));
            this.CalculartotalFacturaVenta();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El Producto no ue retirado"));

        }

    }

    public void onRowEdit(RowEditEvent Event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO:", "Producto editado "));

//                invocamos al metodo calculartotalfactura para actualizar la factura
        this.CalculartotalFacturaVenta();
    }

    public void onRowEditCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "...:", "No se hizo ningun cambio "));

    }

    public void limpiarFactura() {

        this.proveedor = new Proveedor();
        this.compras = new Compras();
        this.listaCompraDetalle = new ArrayList<>();
        this.totalCompra = new Long(0);

//        invocar el metodo para destivar controles en a factura
        this.disableButton();
    }

    public void registrarVentaFactura() {
        this.session = null;
        this.transaction = null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String correoEmple = httpSession.getAttribute("correoElectronico").toString();
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();

            DaoCompras daoCompra = new DaoCompras();
            DaoCompraDetalle daoCompraDetalle = new DaoCompraDetalle();
            DaoEmpleado daoempleado = new DaoEmpleado();
            DaoProveedor daoProveedor = new DaoProveedor();
            DaoAccesorios daoAccesorios = new DaoAccesorios();

            if (this.proveedor == null) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor selecione un cliente."));
                return;
            }

//            datos para guardar en a base de datos
            this.compras.setIdcompras(idCompra + 1);
            this.compras.setProveedor(proveedor);
            this.compras.setEmpleado(daoempleado.getByCorreoElectronico(this.session, correoEmple));
            this.compras.setFechaCompra(new Date());
            daoCompra.insert(this.session, this.compras);

//            
//            guardamos la venta
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO:", "venta registrada "));

//            recuperar ekl ultimo registro de la venta
//            recorremos el arraylist para guardar cada registro en la bd
            for (Compradetalle item : listaCompraDetalle) {
                this.accesorios = daoAccesorios.getByCodigoBarras(this.session, item.getCodigobarras());
                this.accesorios.setCantidad(this.accesorios.getCantidad() + item.getCantidad());

//                if (this.accesorios.getCantidad() >= item.getCantidad()) {
//                    this.accesorios.setCantidad(this.accesorios.getCantidad()-item.getCantidad());
//                } else {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                    return;
//                }
                item.setCompras(compras);
                item.setAccesorios(accesorios);

//                hacemos el insert en la tabla ventadetalle
                daoCompraDetalle.insert(this.session, item);
            }
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO:", "ventaregistrada "));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transaction != null) {
                this.transaction.rollback();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro no se realizo"));

            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
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

    
      public List<Compras> getAll() {
        this.session = null;
        this.transaction = null;
        try {

        
            DaoCompras daoCompras = new DaoCompras();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();

       
            this.listaCompras = daoCompras.getAll(this.session);
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

    public List<Compras> getListaComprasByFecha() {
        return listaComprasByFecha;
    }

    public void setListaComprasByFecha(List<Compras> listaComprasByFecha) {
        this.listaComprasByFecha = listaComprasByFecha;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Accesorios getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Accesorios accesorios) {
        this.accesorios = accesorios;
    }

    public List<Accesorios> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(List<Accesorios> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Compradetalle getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(Compradetalle detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public List<Compradetalle> getListaCompraDetalle() {
        return listaCompraDetalle;
    }

    public void setListaCompraDetalle(List<Compradetalle> listaCompraDetalle) {
        this.listaCompraDetalle = listaCompraDetalle;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getProductoSelecionado() {
        return productoSelecionado;
    }

    public void setProductoSelecionado(String productoSelecionado) {
        this.productoSelecionado = productoSelecionado;
    }

    public String getCantidadProducto2() {
        return cantidadProducto2;
    }

    public void setCantidadProducto2(String cantidadProducto2) {
        this.cantidadProducto2 = cantidadProducto2;
    }

    public Long getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Long totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

}
