package MbView;

import Clases.Persianas;
import Clases.Puerta;
import Clases.PuertaBatiente;
import Clases.PuertaCorrediza;
import Clases.PuertaPoket;
import Clases.Puertas;
import Clases.VentanaAbati;
import Clases.VentanaCorre;
import Clases.VentanaProyec;
import Clases.Ventanas;
import Clases.Vitrina;
import Clases.VitrinaC;
import Daos.DaoAccesorios;
import Daos.DaoCliente;
import Daos.DaoDetalle;
import Daos.DaoEmpleado;
import Daos.DaoFactura;
import Daos.DaoManoObra;
import Daos.DaoMaterial;
import Daos.DaoProductos;
import Daos.DaoVidrio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import HibernateUtil.HibernateUtil;
import Pojos.Accesorios;
import Pojos.Cliente;
import Pojos.Empleado;
import Pojos.Facturas;
import Pojos.Materiales;
import Pojos.Ventanadetalle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 *
 *
 * @author ander
 *
 */
@ManagedBean

@ViewScoped

public class Factura {

    private Session session;
    private Transaction transaction;
    private Ventanadetalle ventana;
    private ArrayList<Ventanadetalle> listaVentana;
    private ArrayList<Ventanadetalle> listaFactura;
    private ArrayList<Materiales> lista;
    private int tipoVidrio;
    private int tipoVentana;
    private String ancho;
    private String alto;
    private String fondo;
    private int ganancia;
    private int manObra;
    private Facturas factura;
    private List<Facturas> listaFact;
    private List<Facturas> listaFactFiltrado;
    private List<Facturas> listaVentasByFecha;
    private String idCliente;
    private int idEmpleado;
    private long precioVidrio;
    private int idVidrio;
    private Date fechaFin;
    private Date fechaInicio;
    private long totalVentasFecha;
    private int tipoAluminio;
    private int tipoAluminioProy;
    private int tipoAluminioCorred;
    private int tipoAluminioBati;
    private int tipoAlumPuertaBat;
    private int tipoAlumPuertaCor;
    private int tipoAlumPuertaPok;
    private int productoTipo;
    private String numeroDocumento;
    private int tipoColorVitrina;
    private int tipoPuerta;
    private int precioAccesorios;
    private int tipoVitrina;
    private int tipoPersiana;
    private int idFactura;
    private Cliente cliente;
    private Long montoDinero;
    private Long saldoDevuelta;
    private int tipoEntrepanos;
    private String nombreProducto;
    private long precioTotal;
    private Cliente client1;
    private int tipoAluminioPuerta;
    private Empleado empleado;
    private int codigoCliente;
    private int codigoEmpleado;
    private String correoElectronico;
    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleado;
    private String productoSelecionado;
    private List<Cliente> listaClienteFiltrado;
    private int cantidadProducto;
    private int tipoColor;
    private int tipoModeloVentana;
    private int tipoModeloPuerta;
    private int diseno;
    private int precioInstalacion;
    private String altoFijo;
    private String anchoFijo;

    /**
     *
     * Creates a new instance of VentanaDetalle
     *
     */
    public Factura() {

        this.lista = new ArrayList<>();
        this.listaVentana = new ArrayList<>();
        this.listaFactura = new ArrayList<>();
        this.factura = new Facturas();
        this.ventana = new Ventanadetalle();
        this.listaClienteFiltrado = new ArrayList<>();
        this.idVidrio = 0;
        this.ganancia = 0;
        this.alto = "";
        this.ancho = "";
        this.manObra = 0;
        this.tipoVentana = 0;
        this.tipoVidrio = 0;
        this.tipoVitrina = 0;
        this.tipoPuerta = 0;
        this.fondo = "";
        this.tipoEntrepanos = 0;
        this.productoTipo = 0;
        this.empleado = new Empleado();
        this.client1 = new Cliente();
        this.listaClientes = new ArrayList<>();
        this.listaEmpleado = new ArrayList<>();
        this.cantidadProducto = 0;
        this.precioInstalacion = 0;
        this.tipoAluminioBati = 0;
        this.tipoAluminioBati = 0;
        this.tipoAluminioProy = 0;
        this.tipoModeloVentana = 0;
        this.altoFijo = "";
        this.anchoFijo = "";

    }

    public void agregarProducto() {

        switch (this.productoTipo) {
            case 1:
                calcularVentana();
                calcular();
                break;
            case 2:
                calcularPuertas();
                calcular();
                break;
            case 3:
                calcularVitrina();
                calcular();
                break;
            case 4:
                calcularVentana();
                calcular();
                break;
            case 5:
                calcularPersiana();
                calcular();
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto"));
                break;
        }
    }

    public void calcularVitrina() {
        this.session = null;
        this.transaction = null;
        VitrinaC vitrina = new VitrinaC();
        this.precioAccesorios = 0;
        try {
            if (this.alto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));
            }
            if (this.ancho.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));
                return;
            }
            if (this.alto.length() > 3 || this.ancho.length() > 3) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));
                return;
            }

            if (String.valueOf(this.manObra).equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));
                return;
            }
            if (String.valueOf(this.ganancia).equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));
                return;
            }
            try {
                int o = Integer.valueOf(this.alto);
                int p = Integer.valueOf(this.ancho);
                int m = this.manObra;
                int t = this.ganancia;
            } catch (NumberFormatException nfe) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            DaoProductos daoProductos = new DaoProductos();
            DaoMaterial daoMaterial = new DaoMaterial();

            this.lista.addAll(daoMaterial.getAll(this.session));
            if (this.tipoColor == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
                return;
            }
            
            if(this.tipoVitrina==0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de vitrina"));
                return;
            }

            int idProdVitrina = 0;
            switch (tipoVitrina) {
                case 1:
                    idProdVitrina = 13;
                    break;
                case 2:
                    idProdVitrina = 14;
                    break;
                case 3:
                    idProdVitrina = 15;
                    break;
                case 4:
                    idProdVitrina = 16;
                    break;
                case 5:
                    idProdVitrina = 17;
                    break;

            }

            String nombreAluminio = "";
            switch (tipoColor) {
                case 1:
                    nombreAluminio = " Color natural";
                    break;
                case 2:
                    nombreAluminio = " Color Anolo";
                    break;
                case 3:
                    nombreAluminio = " Colores ";
                    break;
            }
            int precioInstala = 0;
            switch (this.tipoVitrina) {
                case 1:
                    vitrina = new VitrinaC(this.ancho, this.alto, this.manObra, this.ganancia,
                            this.lista.get(5).getPreciocost(), this.lista.get(100).getPreciocost(),
                            this.lista.get(87).getPreciocost(), this.lista.get(133).getPreciocost(),
                            this.lista.get(134).getPreciocost(), this.lista.get(22).getPreciocost(),
                            this.lista.get(59).getPreciocost(), this.lista.get(88).getPreciocost(),
                            this.lista.get(61).getPreciocost(), this.lista.get(63).getPreciocost(),
                            this.lista.get(85).getPreciocost(), this.lista.get(84).getPreciocost(),
                            this.lista.get(74).getPreciocost(), this.lista.get(359).getPreciocost(),
                            this.lista.get(358).getPreciocost(), this.tipoVitrina);
                    break;
                case 2:
                    vitrina = new VitrinaC(this.ancho, this.alto, this.manObra, this.ganancia,
                            this.lista.get(5).getPrecioAnonizado(), this.lista.get(100).getPrecioAnonizado(),
                            this.lista.get(87).getPrecioAnonizado(), this.lista.get(133).getPrecioAnonizado(),
                            this.lista.get(134).getPrecioAnonizado(), this.lista.get(22).getPrecioAnonizado(),
                            this.lista.get(59).getPrecioAnonizado(), this.lista.get(88).getPrecioAnonizado(),
                            this.lista.get(61).getPrecioAnonizado(), this.lista.get(63).getPrecioAnonizado(),
                            this.lista.get(85).getPrecioAnonizado(), this.lista.get(84).getPrecioAnonizado(),
                            this.lista.get(74).getPrecioAnonizado(), this.lista.get(359).getPrecioAnonizado(),
                            this.lista.get(358).getPrecioAnonizado(), this.tipoVitrina);
                    break;
                case 3:
                    vitrina = new VitrinaC(this.ancho, this.alto, this.manObra, this.ganancia,
                            this.lista.get(5).getPrecioPintura(), this.lista.get(100).getPrecioPintura(),
                            this.lista.get(87).getPrecioPintura(), this.lista.get(133).getPrecioPintura(),
                            this.lista.get(134).getPrecioPintura(), this.lista.get(22).getPrecioPintura(),
                            this.lista.get(59).getPrecioPintura(), this.lista.get(88).getPrecioPintura(),
                            this.lista.get(61).getPrecioPintura(), this.lista.get(63).getPrecioPintura(),
                            this.lista.get(85).getPrecioPintura(), this.lista.get(84).getPrecioPintura(),
                            this.lista.get(74).getPrecioPintura(), this.lista.get(359).getPrecioPintura(),
                            this.lista.get(358).getPrecioPintura(), this.tipoVitrina);
                    break;
            }

            if (this.idVidrio != 0) {
                DaoVidrio daoVidrio = new DaoVidrio();
                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
                this.precioVidrio = this.precioVidrio * (Integer.valueOf(alto) * Integer.valueOf(ancho));
                int espacios = String.valueOf(this.precioVidrio).length();
                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
            }

            if (this.idVidrio == 0) {
                this.precioVidrio = 0;
            }

            if (this.tipoVitrina == 1 || this.tipoVitrina == 2 || this.tipoVitrina == 3 || this.tipoVitrina == 5) {
                DaoAccesorios daoAcessorios = new DaoAccesorios();
                int anclaje = 0;
                anclaje = daoAcessorios.getById(this.session, 56).getPrecioCosto() * 4;
                this.precioAccesorios = anclaje;
            }

            if (this.tipoVitrina < 6 && this.tipoVitrina > 0) {
                precioInstala = this.precioInstalacion;
                precioInstala = (precioInstala * (vitrina.getAlto() * vitrina.getAncho())) / 10000;
                
                Long precioExtra = this.precioAccesorios + vitrina.getSumaTotal() + precioVidrio;
                Long aux = precioExtra;
                precioExtra = precioExtra * ganancia / 100;
                precioExtra+=aux+precioInstala;
                
                
                this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idProdVitrina),
                        daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho,
                        cantidadProducto, precioExtra , cantidadProducto * precioExtra, this.manObra, this.ganancia, this.alto, this.ancho, this.fondo));
            }

            this.transaction.commit();
            this.idVidrio = 0;
            this.ganancia = 0;
            this.alto = "";
            this.ancho = "";
            this.manObra = 0;
            this.tipoVentana = 0;
            this.tipoVidrio = 0;
            this.tipoVitrina = 0;
            this.fondo = "";
            this.productoTipo = 0;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            System.out.println("Ocurrio un error::::" + ex.toString());
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void calcularPersiana() {
        this.session = null;
        this.transaction = null;
        Persianas persianas = new Persianas();
        try {
            if (this.alto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));
            }
            if (this.ancho.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));
                return;
            }
            if (this.alto.length() > 3 || this.ancho.length() > 3) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));
                return;
            }

            if (String.valueOf(this.manObra).equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));
                return;
            }
            if (String.valueOf(this.ganancia).equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));
                return;
            }
            try {
                int o = Integer.valueOf(this.alto);
                int p = Integer.valueOf(this.ancho);
                int m = this.manObra;
                int t = this.ganancia;
            } catch (NumberFormatException nfe) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            DaoProductos daoProductos = new DaoProductos();
            DaoMaterial daoMaterial = new DaoMaterial();

            this.lista.addAll(daoMaterial.getAll(this.session));
            if (this.tipoColor == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
                return;
            }

            int idPersiana = 0;
            switch (tipoPersiana) {
                case 1:
                    idPersiana = 1;
                    break;
                case 2:
                    idPersiana = 2;
                    break;
                case 3:
                    idPersiana = 3;
                    break;
            }

            String nombreAluminio = "";
            switch (tipoColor) {
                case 1:
                    nombreAluminio = " Color natural";
                    break;
                case 2:
                    nombreAluminio = " Color Anolo";
                    break;
                case 3:
                    nombreAluminio = " Colores ";
                    break;
            }
            int precioInstala = 0;
            if (this.tipoColor == 1) {
                persianas = new Persianas(this.ancho, this.alto, this.manObra, this.ganancia,
                        this.lista.get(211).getPreciocost(), this.lista.get(57).getPreciocost(),
                        this.lista.get(163).getPreciocost(), this.lista.get(55).getPreciocost(),
                        this.lista.get(359).getPreciocost(), this.lista.get(358).getPreciocost(), this.tipoPersiana);
                // 
            } else {
                if (this.tipoColor == 2) {
                    persianas = new Persianas(this.ancho, this.alto, this.manObra, this.ganancia,
                            this.lista.get(211).getPrecioAnonizado(), this.lista.get(57).getPrecioAnonizado(),
                            this.lista.get(163).getPrecioAnonizado(), this.lista.get(55).getPrecioAnonizado(),
                            this.lista.get(359).getPrecioAnonizado(), this.lista.get(358).getPrecioAnonizado(), this.tipoPersiana);
                } else {
                    if (this.tipoColor == 3) {
                        persianas = new Persianas(this.ancho, this.alto, this.manObra, this.ganancia,
                                this.lista.get(211).getPrecioPintura(), this.lista.get(57).getPrecioPintura(),
                                this.lista.get(163).getPrecioPintura(), this.lista.get(55).getPrecioPintura(),
                                this.lista.get(359).getPrecioPintura(), this.lista.get(358).getPrecioPintura(), this.tipoPersiana);
                    }
                }
            }

            if (this.tipoPersiana < 6 && this.tipoPersiana > 0) {
                precioInstala = this.precioInstalacion;
                precioInstala = (precioInstala * (persianas.getAlto() * persianas.getAncho())) / 10000;
                System.out.println("precio instalacion :  ..." + precioInstala);
                Long precioExtra = persianas.getSumaTotal();
                precioExtra = (precioExtra * persianas.getPrecioDescuento() / 100) + precioExtra;
                System.out.println("precio extra :  ..." + precioExtra);

                this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idPersiana),
                        daoProductos.getById(this.session, idPersiana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho + " fondo: " + this.fondo,
                        1, persianas.getSumaTotal() + precioExtra, 1 * persianas.getSumaTotal() + precioExtra,
                        this.manObra, this.ganancia, this.alto, this.ancho, this.fondo));
            }

            this.transaction.commit();
            this.idVidrio = 0;
            this.ganancia = 0;
            this.alto = "";
            this.ancho = "";
            this.manObra = 0;
            this.tipoVentana = 0;
            this.tipoVidrio = 0;
            this.tipoPersiana = 0;
            this.fondo = "";
            this.productoTipo = 0;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            System.out.println("Ocurrio un error::::" + ex.toString());
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void calcularPuertas() {
        this.session = null;
        this.transaction = null;
        Puertas puert = new Puertas();
        try {
            if (this.alto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));
                return;
            }
            if (this.ancho.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));
                return;
            }
            if (this.alto.length() > 3 || this.ancho.length() > 3) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));
                return;
            }
            if (String.valueOf(this.manObra).equals("")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));
                return;
            }
            if (String.valueOf(this.ganancia).equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));
                return;
            }
            try {
                int o = Integer.valueOf(this.alto);
                int p = Integer.valueOf(this.ancho);
                int m = this.manObra;
                int t = this.ganancia;
            } catch (NumberFormatException nfe) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
            }

            DaoMaterial daoMaterial = new DaoMaterial();
            DaoProductos daoProductos = new DaoProductos();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.lista.addAll(daoMaterial.getAll(this.session));

            int idPuerta = 0;
            switch (tipoPuerta) {
                case 1:
                    idPuerta = 1;
                    break;
                case 2:
                    idPuerta = 2;
                    break;
                case 3:
                    idPuerta = 3;
                    break;
            }

            String nombreAluminio = "";
            String nombrePuerta = "";
            String modeloPuerta = "";
            switch (tipoAlumPuertaCor) {
                case 1:
                    nombreAluminio = " Aluminio Sider 00";
                    break;
//                case 2:
//                    nombreAluminio = " Aluminio 3831 VITRAL";
//                    break;
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
            }

            switch (tipoAlumPuertaBat) {
                case 1:
                    nombreAluminio = " Aluminio Sider 2400";
                    break;
//                case 2:
//                    nombreAluminio = " Aluminio AS 1800";
//                    break;
//                case 3:
//                    nombreAluminio = " Aluminio AS 1900";
//                    break;
            }

            switch (tipoAlumPuertaPok) {
                case 1:
                    nombreAluminio = " Aluminio Sider 001";
                    break;
//                case 2:
//                    nombreAluminio = " Aluminio 5020";
//                    break;
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
            }

            switch (tipoColor) {
                case 1:
                    nombreAluminio += " Natural";
                    break;
                case 2:
                    nombreAluminio += " Anolo";
                    break;
                case 3:
                    nombreAluminio += " Colores";
                    break;
            }

            DaoAccesorios daoAccesorios = new DaoAccesorios();
            int bisagrasFlash = 0;
            int escuadras = 0;
            int Cerradura = 0;
            int tornilloEnsa = 0;
            int tronilloInst = 0;
            int opcionVentana = 0;

            Accesorios acce = new Accesorios();
            switch (tipoModeloPuerta) {
                case 1://CORREDIZA
                    switch (tipoPuerta) {
                        case 1://
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;

                case 2://ABATIBLE
                    switch (tipoPuerta) {
                        case 1://
                            acce = new Accesorios();
                            nombrePuerta = "XI XD Con divisor";
                            opcionVentana = 37;
                            acce = daoAccesorios.getById(this.session, 14);//obtiene el accesorio de la bd
                            bisagrasFlash = acce.getPrecioCosto() * 3;
                            acce.setCantidad(acce.getCantidad() - (3 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                            acce = daoAccesorios.getById(this.session, 54);//obtiene el accesorio de la bd
                            escuadras = acce.getPrecioCosto() * 2;
                            acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                            acce = daoAccesorios.getById(this.session, 30);//obtiene el accesorio de la bd
                            Cerradura = acce.getPrecioCosto() * 1;
                            acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                            acce = daoAccesorios.getById(this.session, 104);//Se realiza el mismo procedimiento para todos los accesorios
                            tornilloEnsa = acce.getPrecioCosto() * 10;
                            acce.setCantidad(acce.getCantidad() - (10 * this.cantidadProducto));
                            daoAccesorios.actualizar(this.session, acce);

                            acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                            tronilloInst = acce.getPrecioCosto() * 9;
                            acce.setCantidad(acce.getCantidad() - (9 * this.cantidadProducto));
                            daoAccesorios.actualizar(this.session, acce);

                            this.precioAccesorios = bisagrasFlash + escuadras + Cerradura + tornilloEnsa + tronilloInst;
                            break;
                        case 2:
                            nombrePuerta = "XI XD PANORAMICA";
                            opcionVentana = 38;
                            acce = daoAccesorios.getById(this.session, 14);//obtiene el accesorio de la bd
                            bisagrasFlash = acce.getPrecioCosto() * 3;
                            acce.setCantidad(acce.getCantidad() - (3 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                            acce = daoAccesorios.getById(this.session, 54);//obtiene el accesorio de la bd
                            escuadras = acce.getPrecioCosto() * 2;
                            acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                            acce = daoAccesorios.getById(this.session, 29);//obtiene el accesorio de la bd
                            Cerradura = acce.getPrecioCosto() * 1;
                            acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                            acce = daoAccesorios.getById(this.session, 104);//Se realiza el mismo procedimiento para todos los accesorios
                            tornilloEnsa = acce.getPrecioCosto() * 10;
                            acce.setCantidad(acce.getCantidad() - (10 * this.cantidadProducto));
                            daoAccesorios.actualizar(this.session, acce);
                            acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                            tronilloInst = acce.getPrecioCosto() * 9;
                            acce.setCantidad(acce.getCantidad() - (9 * this.cantidadProducto));
                            daoAccesorios.actualizar(this.session, acce);

                            this.precioAccesorios = bisagrasFlash + escuadras + Cerradura + tornilloEnsa + tronilloInst;
                            break;

                        case 3:
                            nombrePuerta = "XX Panoramica";
                            opcionVentana = 39;

                            acce = daoAccesorios.getById(this.session, 14);//obtiene el accesorio de la bd
                            bisagrasFlash = acce.getPrecioCosto() * 6;
                            acce.setCantidad(acce.getCantidad() - (6 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                            acce = daoAccesorios.getById(this.session, 54);//obtiene el accesorio de la bd
                            escuadras = acce.getPrecioCosto() * 2;
                            acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                            acce = daoAccesorios.getById(this.session, 29);//obtiene el accesorio de la bd
                            Cerradura = acce.getPrecioCosto() * 1;
                            acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad
                            daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                            acce = daoAccesorios.getById(this.session, 104);//Se realiza el mismo procedimiento para todos los accesorios
                            tornilloEnsa = acce.getPrecioCosto() * 20;
                            acce.setCantidad(acce.getCantidad() - (20 * this.cantidadProducto));
                            daoAccesorios.actualizar(this.session, acce);
                            acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                            tronilloInst = acce.getPrecioCosto() * 18;
                            acce.setCantidad(acce.getCantidad() - (18 * this.cantidadProducto));
                            daoAccesorios.actualizar(this.session, acce);

                            this.precioAccesorios = bisagrasFlash + escuadras + Cerradura + tornilloEnsa + tronilloInst;
                            break;
                    }
                    break;

                case 3://POKET
                    switch (tipoPuerta) {
                        case 1://
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
            }

            switch (tipoModeloPuerta) {
                case 1:
                    modeloPuerta = "CORREDIZA";
                    break;
                case 2:
                    modeloPuerta = "ABATIBLE";
                    break;
                case 3:
                    modeloPuerta = "POKET";
                    break;
            }

            if (this.idVidrio != 0) {
                DaoVidrio daoVidrio = new DaoVidrio();
                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
                this.precioVidrio = this.precioVidrio * (Integer.valueOf(alto) * Integer.valueOf(ancho));
                int espacios = String.valueOf(this.precioVidrio).length();
                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
            }

            if (this.idVidrio == 0) {
                this.precioVidrio = 0;
            }

            PuertaCorrediza corrediza = new PuertaCorrediza();
            DaoManoObra daoObra = new DaoManoObra();
            int precioInstala = 0;
            switch (tipoModeloPuerta) {
                case 1: //Opcion 1 es para puertas corredizas
                    switch (tipoAlumPuertaCor) {
                        case 1: // para puertas corredizas
                            switch (tipoColor) {
                                case 1:// para ventanas corredizas
                                    corrediza = new PuertaCorrediza();
                                    corrediza.setAlto(alto);
                                    corrediza.setAncho(ancho);
                                    corrediza.setPrecioTrabajo(this.manObra);
                                    corrediza.setPrecioDescuento(this.ganancia);
                                    corrediza.setTipoProducto(tipoPuerta);
                                    corrediza.setPrecioPerimetral(this.lista.get(131).getPreciocost());
                                    corrediza.setPrecioVerticalVisagra(this.lista.get(137).getPreciocost());
                                    corrediza.setPrecioSuperiorNave(this.lista.get(132).getPreciocost());
                                    corrediza.setPrecioInferiorNave(this.lista.get(133).getPreciocost());
                                    corrediza.setPrecioPirlan(this.lista.get(354).getPreciocost());
                                    corrediza.setPrecioAdaptador(this.lista.get(354).getPreciocost());
                                    corrediza.setPrecioEmpaqueEmv(this.lista.get(354).getPreciocost());
                                    corrediza.setPrecioEmpaqueEcv(this.lista.get(354).getPreciocost());
                                    corrediza.setPrecioFelpa(this.lista.get(354).getPreciocost());
                                    corrediza.calcularPuertaCorrediza(this.lista.get(diseno).getPreciocost());
                                    break;

                                case 2:// para ventanas corredizatante  de aluminio 3831 Anolo linea ECOMICA ALE
                                    corrediza = new PuertaCorrediza();
                                    corrediza.setAlto(alto);
                                    corrediza.setAncho(ancho);
                                    corrediza.setPrecioTrabajo(this.manObra);
                                    corrediza.setPrecioDescuento(this.ganancia);
                                    corrediza.setTipoProducto(tipoPuerta);
                                    corrediza.setPrecioPerimetral(this.lista.get(131).getPrecioAnonizado());
                                    corrediza.setPrecioVerticalVisagra(this.lista.get(137).getPrecioAnonizado());
                                    corrediza.setPrecioSuperiorNave(this.lista.get(132).getPrecioAnonizado());
                                    corrediza.setPrecioInferiorNave(this.lista.get(133).getPrecioAnonizado());
                                    corrediza.setPrecioPirlan(this.lista.get(354).getPrecioAnonizado());
                                    corrediza.setPrecioAdaptador(this.lista.get(354).getPrecioAnonizado());
                                    corrediza.setPrecioEmpaqueEmv(this.lista.get(354).getPrecioAnonizado());
                                    corrediza.setPrecioEmpaqueEcv(this.lista.get(354).getPrecioAnonizado());
                                    corrediza.setPrecioFelpa(this.lista.get(354).getPrecioAnonizado());
                                    corrediza.calcularPuertaCorrediza(this.lista.get(diseno).getPrecioAnonizado());
                                    break;

                                case 3:// para ventanas corredizatante  de aluminio 3831 Pintura linea ECOMICA ALE
                                    corrediza = new PuertaCorrediza();
                                    corrediza.setAlto(alto);
                                    corrediza.setAncho(ancho);
                                    corrediza.setPrecioTrabajo(this.manObra);
                                    corrediza.setPrecioDescuento(this.ganancia);
                                    corrediza.setTipoProducto(tipoPuerta);
                                    corrediza.setPrecioPerimetral(this.lista.get(131).getPrecioPintura());
                                    corrediza.setPrecioVerticalVisagra(this.lista.get(137).getPrecioPintura());
                                    corrediza.setPrecioSuperiorNave(this.lista.get(132).getPrecioPintura());
                                    corrediza.setPrecioInferiorNave(this.lista.get(133).getPrecioPintura());
                                    corrediza.setPrecioPirlan(this.lista.get(354).getPrecioPintura());
                                    corrediza.setPrecioAdaptador(this.lista.get(354).getPrecioPintura());
                                    corrediza.setPrecioEmpaqueEmv(this.lista.get(354).getPrecioPintura());
                                    corrediza.setPrecioEmpaqueEcv(this.lista.get(354).getPrecioPintura());
                                    corrediza.setPrecioFelpa(this.lista.get(354).getPrecioPintura());
                                    corrediza.calcularPuertaCorrediza(this.lista.get(diseno).getPrecioPintura());
                                    break;
                            }
                            break;
                    }

                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (corrediza.getAlto() * corrediza.getAncho())) / 10000;
                    System.out.println("precio instalacion :  ..." + precioInstala);
                    Long precioExtra = this.precioVidrio + this.precioAccesorios + corrediza.getSumaTotal();
                    precioExtra = (precioExtra * corrediza.getPrecioDescuento() / 100) + precioExtra;
                    System.out.println("precio extra :  ..." + precioExtra);
//                    Long precioIva = precioExtra + precioInstala*16/100;
//                    precioIva+=precioExtra + precioInstala;
                    this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idPuerta),
                            modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtra + precioInstala, this.cantidadProducto * (precioExtra + precioInstala),
                            this.manObra, this.ganancia, this.alto, this.ancho, ""));
                    break;

                case 2: //////Caso 2 puertas
                    PuertaBatiente batiente = new PuertaBatiente();
                    switch (tipoAlumPuertaBat) {
                        case 1:
                            switch (tipoColor) {
                                case 1:
                                    batiente = new PuertaBatiente();
                                    batiente.setAlto(alto);
                                    batiente.setAncho(ancho);
                                    batiente.setPrecioTrabajo(this.manObra);
                                    batiente.setPrecioDescuento(this.ganancia);
                                    batiente.setTipoProducto(tipoPuerta);
                                    batiente.setPrecioPerimetral(this.lista.get(297).getPreciocost());
                                    batiente.setPrecioVerticalVisagra(this.lista.get(298).getPreciocost());
                                    batiente.setPrecioSuperiorNave(this.lista.get(299).getPreciocost());
                                    batiente.setPrecioInferiorNave(this.lista.get(300).getPreciocost());
                                    batiente.setPrecioPirlan(this.lista.get(303).getPreciocost());
                                    batiente.setPrecioAdaptador(this.lista.get(305).getPreciocost());
                                    batiente.setPrecioEmpaqueEmv(this.lista.get(359).getPreciocost());
                                    batiente.setPrecioEmpaqueEcv(this.lista.get(358).getPreciocost());
                                    batiente.setPrecioFelpa(this.lista.get(304).getPreciocost());
                                    batiente.calcularPuertaBatiente(this.lista.get(367).getPreciocost());
                                    break;

                                case 2:
                                    // este es para una puerta con aluminio  Anolo
                                    batiente = new PuertaBatiente();
                                    batiente.setAlto(alto);
                                    batiente.setAncho(ancho);
                                    batiente.setPrecioTrabajo(this.manObra);
                                    batiente.setPrecioDescuento(this.ganancia);
                                    batiente.setTipoProducto(tipoPuerta);
                                    batiente.setPrecioPerimetral(this.lista.get(297).getPrecioAnonizado());
                                    batiente.setPrecioVerticalVisagra(this.lista.get(298).getPrecioAnonizado());
                                    batiente.setPrecioSuperiorNave(this.lista.get(299).getPrecioAnonizado());
                                    batiente.setPrecioInferiorNave(this.lista.get(300).getPrecioAnonizado());
                                    batiente.setPrecioPirlan(this.lista.get(303).getPrecioAnonizado());
                                    batiente.setPrecioAdaptador(this.lista.get(305).getPrecioAnonizado());
                                    batiente.setPrecioEmpaqueEmv(this.lista.get(359).getPrecioAnonizado());
                                    batiente.setPrecioEmpaqueEcv(this.lista.get(358).getPrecioAnonizado());
                                    batiente.setPrecioFelpa(this.lista.get(304).getPrecioAnonizado());
                                    batiente.calcularPuertaBatiente(this.lista.get(367).getPrecioAnonizado());
                                    break;

                                case 3:
                                    // este es para una ventana con aluminio AS 1700 Pintura
                                    batiente = new PuertaBatiente();
                                    batiente.setAlto(alto);
                                    batiente.setAncho(ancho);
                                    batiente.setPrecioTrabajo(this.manObra);
                                    batiente.setPrecioDescuento(this.ganancia);
                                    batiente.setTipoProducto(tipoPuerta);
                                    batiente.setPrecioPerimetral(this.lista.get(297).getPrecioPintura());
                                    batiente.setPrecioVerticalVisagra(this.lista.get(298).getPrecioPintura());
                                    batiente.setPrecioSuperiorNave(this.lista.get(299).getPrecioPintura());
                                    batiente.setPrecioInferiorNave(this.lista.get(300).getPrecioPintura());
                                    batiente.setPrecioPirlan(this.lista.get(303).getPrecioPintura());
                                    batiente.setPrecioAdaptador(this.lista.get(305).getPrecioPintura());
                                    batiente.setPrecioEmpaqueEmv(this.lista.get(359).getPrecioPintura());
                                    batiente.setPrecioEmpaqueEcv(this.lista.get(358).getPrecioPintura());
                                    batiente.setPrecioFelpa(this.lista.get(304).getPrecioPintura());
                                    batiente.calcularPuertaBatiente(this.lista.get(367).getPrecioPintura());
                                    break;
                            }
                            break;
                    }

                    precioInstala = this.precioInstalacion;
                    System.out.println("alto:::" + batiente.getAlto());
                    System.out.println("ancho:::" + batiente.getAncho());
                    precioInstala = (precioInstala * (batiente.getAlto() * batiente.getAncho())) / 10000;
                    System.out.println("precio instalacion :  ..." + precioInstala);
                    Long precioBati = this.precioVidrio + this.precioAccesorios + batiente.getSumaTotal();
                    precioBati = (precioBati * batiente.getPrecioDescuento() / 100) + precioBati;
                    System.out.println("precio bati :  ..." + precioBati);
//                    Long precioIva = precioExtra + precioInstala*16/100;
//                    precioIva+=precioExtra + precioInstala;
                    this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idPuerta),
                            modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioBati + precioInstala, this.cantidadProducto * (precioBati + precioInstala),
                            this.manObra, this.ganancia, this.alto, this.ancho, ""));
                    break;

                case 3:    // este es para una ventana con aluminio AS 1800 Natural
                    PuertaPoket poket = new PuertaPoket();
                    switch (this.tipoAlumPuertaPok) {
                        case 1: // este constructoer es para ventanas Correderas de aluminio  y con sus distintos colores
                            switch (tipoColor) {
                                case 1:// este es para una ventana con aluminio AS 1700 natutal
                                    poket = new PuertaPoket();
                                    poket.setAlto(alto);
                                    poket.setAncho(ancho);
                                    poket.setPrecioTrabajo(this.manObra);
                                    poket.setPrecioDescuento(this.ganancia);
                                    poket.setTipoProducto(opcionVentana);
                                    poket.setPrecioPerimetral(this.lista.get(131).getPreciocost());
                                    poket.setPrecioVerticalVisagra(this.lista.get(137).getPreciocost());
                                    poket.setPrecioSuperiorNave(this.lista.get(132).getPreciocost());
                                    poket.setPrecioInferiorNave(this.lista.get(133).getPreciocost());
                                    poket.setPrecioPirlan(this.lista.get(354).getPreciocost());
                                    poket.setPrecioAdaptador(this.lista.get(354).getPreciocost());
                                    poket.setPrecioEmpaqueEmv(this.lista.get(354).getPreciocost());
                                    poket.setPrecioEmpaqueEcv(this.lista.get(354).getPreciocost());
                                    poket.setPrecioFelpa(this.lista.get(354).getPreciocost());
                                    poket.calcularPuertaPoket(this.lista.get(diseno).getPreciocost());
                                    break;

                                case 2:
                                    // este es para una ventana con aluminio AS 1800 Anolo
                                    poket = new PuertaPoket();
                                    poket.setAlto(alto);
                                    poket.setAncho(ancho);
                                    poket.setPrecioTrabajo(this.manObra);
                                    poket.setPrecioDescuento(this.ganancia);
                                    poket.setTipoProducto(opcionVentana);
                                    poket.setPrecioPerimetral(this.lista.get(131).getPrecioAnonizado());
                                    poket.setPrecioVerticalVisagra(this.lista.get(137).getPrecioAnonizado());
                                    poket.setPrecioSuperiorNave(this.lista.get(132).getPrecioAnonizado());
                                    poket.setPrecioInferiorNave(this.lista.get(133).getPrecioAnonizado());
                                    poket.setPrecioPirlan(this.lista.get(354).getPrecioAnonizado());
                                    poket.setPrecioAdaptador(this.lista.get(354).getPrecioAnonizado());
                                    poket.setPrecioEmpaqueEmv(this.lista.get(354).getPrecioAnonizado());
                                    poket.setPrecioEmpaqueEcv(this.lista.get(354).getPrecioAnonizado());
                                    poket.setPrecioFelpa(this.lista.get(354).getPrecioAnonizado());
                                    poket.calcularPuertaPoket(this.lista.get(diseno).getPrecioAnonizado());
                                    break;
                                case 3:

                                    // este es para una ventana con aluminio AS 1800 pintura
                                    poket = new PuertaPoket();
                                    poket.setAlto(alto);
                                    poket.setAncho(ancho);
                                    poket.setPrecioTrabajo(this.manObra);
                                    poket.setPrecioDescuento(this.ganancia);
                                    poket.setTipoProducto(opcionVentana);
                                    poket.setPrecioPerimetral(this.lista.get(131).getPrecioPintura());
                                    poket.setPrecioVerticalVisagra(this.lista.get(137).getPrecioPintura());
                                    poket.setPrecioSuperiorNave(this.lista.get(132).getPrecioPintura());
                                    poket.setPrecioInferiorNave(this.lista.get(133).getPrecioPintura());
                                    poket.setPrecioPirlan(this.lista.get(354).getPrecioPintura());
                                    poket.setPrecioAdaptador(this.lista.get(354).getPrecioPintura());
                                    poket.setPrecioEmpaqueEmv(this.lista.get(354).getPrecioPintura());
                                    poket.setPrecioEmpaqueEcv(this.lista.get(354).getPrecioPintura());
                                    poket.setPrecioFelpa(this.lista.get(354).getPrecioPintura());
                                    poket.calcularPuertaPoket(this.lista.get(diseno).getPrecioPintura());
                                    break;
                            }
                            break;
                    }

                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (poket.getAlto() * poket.getAncho())) / 10000;
                    System.out.println("precio instalacion :  ..." + precioInstala);
                    Long precioExtrac = this.precioVidrio + this.precioAccesorios + poket.getSumaTotal();
                    precioExtrac = (precioExtrac * poket.getPrecioDescuento() / 100) + precioExtrac;
                    System.out.println("precio extra :  ..." + precioExtrac);

                    this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idPuerta),
                            modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtrac + precioInstala, this.cantidadProducto * (precioExtrac + precioInstala),
                            this.manObra, this.ganancia, this.alto, this.ancho, ""));
                    break;
            }

            if (this.idVidrio == 0) {
                this.precioVidrio = 0;
            }

            this.transaction.commit();
            this.idVidrio = 0;
            this.ganancia = 0;
            this.alto = "";
            this.ancho = "";
            this.manObra = 0;
            this.tipoVentana = 0;
            this.tipoVidrio = 0;
            this.productoTipo = 0;
            this.cantidadProducto = 0;
            this.precioInstalacion = 0;
            this.tipoAluminioBati = 0;
            this.tipoAluminioCorred = 0;
            this.tipoAluminioProy = 0;
            this.tipoModeloVentana = 0;
        } catch (Exception e) {
        }
    }

    public void calcularVentana() {
        this.session = null;

        this.transaction = null;

        Ventanas ventana = new Ventanas();

        try {

            if (this.alto.equals("")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));

                return;

            }

            if (this.ancho.equals("")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));

                return;

            }

            if (this.alto.length() > 3 || this.ancho.length() > 3) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));

                return;

            }

            if (String.valueOf(this.manObra).equals("")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));

                return;

            }

            if (String.valueOf(this.ganancia).equals("")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));

                return;

            }

            if (this.tipoVentana == 0) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto."));

                return;

            }

            try {

                int o = Integer.valueOf(this.alto);

                int p = Integer.valueOf(this.ancho);

                int m = this.manObra;

                int t = this.ganancia;

            } catch (NumberFormatException nfe) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));

            }

            DaoMaterial daoMaterial = new DaoMaterial();

            DaoProductos daoProductos = new DaoProductos();

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            this.lista.addAll(daoMaterial.getAll(this.session));

//            if (this.tipoAluminioProy == 0 || this.tipoAluminioBati == 0 || this.tipoAluminioCorred == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
//                return;
//            }
            int idVentana = 0;

            switch (tipoVentana) {

                case 1:

                    idVentana = 1;

                    break;

                case 2:

                    idVentana = 2;

                    break;

                case 3:

                    idVentana = 3;

                    break;

            }

            String nombreAluminio = "";

            String nombreVentana = "";

            String modeloVentana = "";

            switch (tipoAluminioProy) {

                case 1:

                    nombreAluminio = " Aluminio 3831 ALE";

                    break;

//                case 2:
//                    nombreAluminio = " Aluminio 3831 VITRAL";
//                    break;
////                case 3:
////                    nombreAluminio = " Aluminio 8025";
////                    break;
            }

            switch (tipoAluminioCorred) {

                case 1:

                    nombreAluminio = " Aluminio AS 1700";

                    break;

                case 2:

                    nombreAluminio = " VC 3825";

                    break;

            }

            switch (tipoAluminioBati) {

                case 1:

                    nombreAluminio = " Aluminio 3825";

                    break;

//            
            }

            switch (tipoColor) {

                case 1:

                    nombreAluminio += " Natural";

                    break;

                case 2:

                    nombreAluminio += " Anolo";

                    break;

                case 3:

                    nombreAluminio += " Colores";

                    break;

            }

            DaoAccesorios daoAccesorios = new DaoAccesorios();

            int BrazosBasculantes = 0;

            int tronillos = 0;

            int tronillos1 = 0;

            int manijas = 0;

            int rodachina = 0;

            int cierre = 0;

            int opcionVentana = 0;

            Accesorios acce = new Accesorios();

            switch (tipoModeloVentana) {

                case 1://Proyectante

                    switch (tipoVentana) {

                        case 1://1 cuerpos

                            switch (diseno) {

                                case 1:

                                    acce = new Accesorios();

                                    nombreVentana = "1 cuerpo X";

                                    opcionVentana = 1;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad
                                    acce = daoAccesorios.getById(this.session, 21);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    System.out.println("precio manijas:::" + manijas);

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 17;

                                    acce.setCantidad(acce.getCantidad() - (17 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + tronillos + manijas;
                                    System.out.println("precio accesorios vProyectante 1 CUERPO X:::" + this.precioAccesorios);

                                    break;

                                case 2:

                                    acce = new Accesorios();

                                    nombreVentana = "1 cuerpo O";

                                    opcionVentana = 5;

                                    acce = daoAccesorios.getById(this.session, 104);

                                    tronillos = acce.getPrecioCosto() * 24;

                                    acce.setCantidad(acce.getCantidad() - (24 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = tronillos;
                                    System.out.println("precio accesorios vProyectante 1 CUERPO 0:::" + this.precioAccesorios);

                                    break;

                            }

                            break;

                        case 2:// 2 CUERPOS

                            switch (diseno) {

                                case 1:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos XX basica";

                                    opcionVentana = 2;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    System.out.println("precio brazos:::" + BrazosBasculantes);

                                    acce = daoAccesorios.getById(this.session, 21);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    System.out.println("precio manijas:::" + manijas);

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 31;

                                    acce.setCantidad(acce.getCantidad() - (31 * this.cantidadProducto));

                                    System.out.println("precio tornillos:::" + tronillos);

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;

                                    System.out.println("precio accesorios:::" + this.precioAccesorios);
                                    System.out.println("precio accesorios vProyectante 2 CUERPO XX:::" + this.precioAccesorios);

                                    break;

                                case 2:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos OO";

                                    opcionVentana = 6;

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 17;

                                    acce.setCantidad(acce.getCantidad() - (17 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = tronillos;
                                    System.out.println("precio accesorios vProyectante 2 CUERPO 00:::" + this.precioAccesorios);

                                    break;

                                case 3:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos O/O";

                                    opcionVentana = 7;

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 43;

                                    acce.setCantidad(acce.getCantidad() - (43 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = tronillos;
                                    System.out.println("precio accesorios 2 cuerpos O/O :::" + this.precioAccesorios);

                                    break;

                                case 4:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos X/O";

                                    opcionVentana = 8;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 1;

                                    acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 42;

                                    acce.setCantidad(acce.getCantidad() - (42 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X/O :::" + this.precioAccesorios);

                                    break;

                                case 5:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos X-O";

                                    opcionVentana = 10;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 1;

                                    acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 41;

                                    acce.setCantidad(acce.getCantidad() - (41 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X-O :::" + this.precioAccesorios);

                                    break;

                                case 6:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos X/O plus alfalgia";

                                    opcionVentana = 12;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 1;

                                    acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 42;

                                    acce.setCantidad(acce.getCantidad() - (42 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X/O PLUS :::" + this.precioAccesorios);

                                    break;

                                case 7:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos X/X alfalgia";

                                    opcionVentana = 14;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 42;

                                    acce.setCantidad(acce.getCantidad() - (42 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X/X :::" + this.precioAccesorios);

                                    break;

                                case 8:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos X/0 Boreal alfaljia";

                                    opcionVentana = 19;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 1;

                                    acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 42;

                                    acce.setCantidad(acce.getCantidad() - (42 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X/O BOREAL :::" + this.precioAccesorios);

                                    break;

                                case 9:

                                    acce = new Accesorios();

                                    nombreVentana = "2 cuerpos 0/0 Boreal alfalgia";

                                    opcionVentana = 20;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 1;

                                    acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 43;

                                    acce.setCantidad(acce.getCantidad() - (43 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos O/O BOREAL :::" + this.precioAccesorios);

                                    break;

                            }

                            break;

                        case 3:// 3 CUERPOS

                            switch (diseno) {

                                case 1:

                                    acce = new Accesorios();

                                    nombreVentana = "3 cuerpos XXX alfajia";

                                    opcionVentana = 3;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 6;

                                    acce.setCantidad(acce.getCantidad() - (6 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 3;

                                    acce.setCantidad(acce.getCantidad() - (3 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 43;

                                    acce.setCantidad(acce.getCantidad() - (43 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 3 cuerpos XXX :::" + this.precioAccesorios);

                                    break;

                                case 2:

                                    acce = new Accesorios();

                                    nombreVentana = "3 cuerpos 0-x-0 Alfaljia";

                                    opcionVentana = 9;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 6;

                                    acce.setCantidad(acce.getCantidad() - (6 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 42;

                                    acce.setCantidad(acce.getCantidad() - (42 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 3 cuerpos O-X-0 :::" + this.precioAccesorios);

                                    break;

                                case 3:

                                    acce = new Accesorios();

                                    nombreVentana = "3 cuerpos alfajia x-0-x";

                                    opcionVentana = 11;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 44;

                                    acce.setCantidad(acce.getCantidad() - (44 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X-O-X :::" + this.precioAccesorios);

                                    break;

                                case 4:

                                    acce = new Accesorios();

                                    nombreVentana = "3 cuerpos 0-0-0 ALFALJIA";

                                    opcionVentana = 15;

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 24;

                                    acce.setCantidad(acce.getCantidad() - (24 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = tronillos;
                                    System.out.println("precio accesorios 2 cuerpos O-O-0 ALFALJIA :::" + this.precioAccesorios);

                                    break;

                            }

                        case 4:// 4 cuerpos

                            switch (diseno) {

                                case 1:

                                    acce = new Accesorios();

                                    nombreVentana = "4 cuerpos alfajia XXXX";

                                    opcionVentana = 4;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 8;

                                    acce.setCantidad(acce.getCantidad() - (8 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 43;

                                    acce.setCantidad(acce.getCantidad() - (43 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 4 cuerpos XXXX :::" + this.precioAccesorios);

                                    break;

                                case 2:

                                    acce = new Accesorios();

                                    nombreVentana = "4 cuerpos 0-0-0-0";

                                    opcionVentana = 13;

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 23;

                                    acce.setCantidad(acce.getCantidad() - (23 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = tronillos;
                                    System.out.println("precio accesorios 4 cuerpos O-O-O-O:::" + this.precioAccesorios);

                                    break;

                                case 3:

                                    nombreVentana = "4 cuerpos 0/0/0/0/ ALFALJIA ";

                                    opcionVentana = 16;

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 48;

                                    acce.setCantidad(acce.getCantidad() - (48 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = tronillos;
                                    System.out.println("precio accesorios 4 cuerpos O/O/0/0 ALFALJIA :::" + this.precioAccesorios);

                                    break;

                                case 4:

                                    acce = new Accesorios();

                                    nombreVentana = "4 cuerpos xx/00 ALFALJIA";

                                    opcionVentana = 17;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 46;

                                    acce.setCantidad(acce.getCantidad() - (46 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 4 cuerpos XX/OO ALFALJIA :::" + this.precioAccesorios);
                                    break;

                                case 5:

                                    acce = new Accesorios();

                                    nombreVentana = "4 cuerpos X/X/0/0 ALFALJIA";

                                    opcionVentana = 18;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 4;

                                    acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 42;

                                    acce.setCantidad(acce.getCantidad() - (42 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 2 cuerpos X/X/O/O ALFALJIA:::" + this.precioAccesorios);

                                    break;

                                case 6:

                                    acce = new Accesorios();

                                    nombreVentana = "4 cuerpos 4 ALFALJIA";

                                    opcionVentana = 21;

                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd

                                    BrazosBasculantes = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 20);

                                    manijas = acce.getPrecioCosto() * 2;

                                    acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));//Descuenta la cantidad

                                    daoAccesorios.actualizar(this.session, acce);//Actualiza la cantidad

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                    tronillos = acce.getPrecioCosto() * 44;

                                    acce.setCantidad(acce.getCantidad() - (44 * this.cantidadProducto));

                                    daoAccesorios.actualizar(this.session, acce);

                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    System.out.println("precio accesorios 4 cuerpos ALFALJIA :::" + this.precioAccesorios);

                                    break;

                            }

                    }

                    break;

                case 2://Corrediza

                    //Validacion segun aluminio corredera si es 1 y si es 2
                    if (tipoAluminioCorred == 1) {

                        switch (tipoVentana) {

                            case 1://2 cuerpos

                                switch (diseno) {

                                    case 1:

                                        acce = new Accesorios();

                                        nombreVentana = "2 cuerpo X0";

                                        opcionVentana = 1;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        System.out.println("precio rodachina:::" + rodachina);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        System.out.println("precio cierre:::" + cierre);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 25;

                                        acce.setCantidad(acce.getCantidad() - (25 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        System.out.println("precio tronillos:::" + tronillos);

                                        this.precioAccesorios = rodachina + cierre + tronillos;

                                        System.out.println("precio accesorios totla:::" + this.precioAccesorios);
                                        System.out.println("precio accesorios 2 cuerpos XO :::" + this.precioAccesorios);

                                        break;

                                    case 2:

                                        acce = new Accesorios();

                                        nombreVentana = "2 cuerpo XX";

                                        opcionVentana = 2;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 21;

                                        acce.setCantidad(acce.getCantidad() - (21 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 2 cuerpos XX :::" + this.precioAccesorios);

                                        break;

                                }

                                break;

                            case 2:// 3 CUERPOS

                                switch (diseno) {

                                    case 1:

                                        acce = new Accesorios();

                                        nombreVentana = "3 cuerpos X0X BASICA";

                                        opcionVentana = 4;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 27;

                                        acce.setCantidad(acce.getCantidad() - (27 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 3 cuerpos X0X :::" + this.precioAccesorios);

                                        break;

                                    case 2:

                                        acce = new Accesorios();

                                        nombreVentana = "3 cuerpos OXO BASICA";

                                        opcionVentana = 5;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 23);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 26;

                                        acce.setCantidad(acce.getCantidad() - (26 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 3 cuerpos OXO :::" + this.precioAccesorios);

                                        break;

                                    case 3:

                                        acce = new Accesorios();

                                        nombreVentana = "3 cuerpos OXX BASICA";

                                        opcionVentana = 6;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 27;

                                        acce.setCantidad(acce.getCantidad() - (27 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 3 cuerpos OXX :::" + this.precioAccesorios);

                                        break;

                                    case 4:

                                        acce = new Accesorios();

                                        nombreVentana = "3 cuerpos X0/O";

                                        opcionVentana = 8;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 22;

                                        acce.setCantidad(acce.getCantidad() - (22 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 3 cuerpos XO/O :::" + this.precioAccesorios);

                                        break;

                                }

                                break;

                            case 3:// 4 CUERPOS

                                switch (diseno) {

                                    case 1:

                                        acce = new Accesorios();

                                        nombreVentana = "4 cuerpos OXXO BASICA";

                                        opcionVentana = 3;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 39;

                                        acce.setCantidad(acce.getCantidad() - (39 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 2 cuerpos OXXO :::" + this.precioAccesorios);

                                        break;

                                    case 2:

                                        acce = new Accesorios();

                                        nombreVentana = "4 cuerpos X0/00 Basica Alf";

                                        opcionVentana = 9;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 39;

                                        acce.setCantidad(acce.getCantidad() - (39 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 4 cuerpos XO/OO :::" + this.precioAccesorios);

                                        break;

                                }

                            case 4:// 6 cuerpos

                                switch (diseno) {

                                    case 1:

                                        acce = new Accesorios();

                                        nombreVentana = "6 cuerpos 0XX XXO BASICA";

                                        opcionVentana = 7;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 8;

                                        acce.setCantidad(acce.getCantidad() - (8 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 36;

                                        acce.setCantidad(acce.getCantidad() - (36 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 6 cuerpos OXX XXO :::" + this.precioAccesorios);

                                        break;

                                    case 2:

                                        acce = new Accesorios();

                                        nombreVentana = "6 cuerpos OXO /OOO BASICA";

                                        opcionVentana = 10;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 32;

                                        acce.setCantidad(acce.getCantidad() - (32 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 6 cuerpos OXO/O00 :::" + this.precioAccesorios);

                                        break;

                                }

                            case 5:// 8 cuerpos

                                switch (diseno) {

                                    case 1:

                                        acce = new Accesorios();

                                        nombreVentana = "8 cuerpos OXXO /OOO0 BASICA";

                                        opcionVentana = 11;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 36;

                                        acce.setCantidad(acce.getCantidad() - (36 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos;
                                        System.out.println("precio accesorios 2 cuerpos OXX0/OOOO :::" + this.precioAccesorios);

                                        break;

                                }

                        }

                    } else if (tipoAluminioCorred == 2) {

                        switch (tipoVentana) {

                            case 1://2 cuerpos VC3825

                                switch (diseno) {

                                    case 1:

                                        //ventana corrediza vc 3825
                                        acce = new Accesorios();

                                        nombreVentana = "2 cuerpos X0 plus basica alfa";

                                        opcionVentana = 12;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 2;

                                        acce.setCantidad(acce.getCantidad() - (2 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 10;

                                        acce.setCantidad(acce.getCantidad() - (10 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos1 = acce.getPrecioCosto() * 9;

                                        acce.setCantidad(acce.getCantidad() - (9 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                        System.out.println("precio accesorios CORRDIZA  3825 2 CUERPO  X0 PLUS BASICA ALFA :::" + this.precioAccesorios);

                                        break;

                                    case 2:

                                        acce = new Accesorios();

                                        //ventana corrediza vc 3825
                                        nombreVentana = "2 cuerpos XX Alf BASICA";

                                        opcionVentana = 13;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 36;

                                        acce.setCantidad(acce.getCantidad() - (36 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos1 = acce.getPrecioCosto() * 9;

                                        acce.setCantidad(acce.getCantidad() - (9 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                        System.out.println("precio accesorios CORRDIZA 3825 2 CUERPO  XX ALF BASICA :::" + this.precioAccesorios);
                                        System.out.println("OPCIONVENTANA CORRDIZA 3825 2 CUERPO  XX ALF BASICA :::" + opcionVentana);

                                        break;

                                    case 3:

                                        acce = new Accesorios();

                                        //ventana corrediza vc 3825
                                        nombreVentana = "2 cuerpos X0 plus Reforzada";

                                        opcionVentana = 14;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 36;

                                        acce.setCantidad(acce.getCantidad() - (36 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos1 = acce.getPrecioCosto() * 9;

                                        acce.setCantidad(acce.getCantidad() - (9 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                        System.out.println("precio accesorios CORRDIZA 3825 2 CUERPO  XO PLUS REFORZADA :::" + this.precioAccesorios);

                                        break;

                                }

                                break;

                            case 2://4 cuerpos VC3825

                                switch (diseno) {

                                    case 1:

                                        acce = new Accesorios();

                                        nombreVentana = "4 cuerpos 0XX0 1672 DOBLE";

                                        opcionVentana = 15;

                                        acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios

                                        rodachina = acce.getPrecioCosto() * 4;

                                        acce.setCantidad(acce.getCantidad() - (4 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios

                                        cierre = acce.getPrecioCosto() * 1;

                                        acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos = acce.getPrecioCosto() * 20;

                                        acce.setCantidad(acce.getCantidad() - (20 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios

                                        tronillos1 = acce.getPrecioCosto() * 16;

                                        acce.setCantidad(acce.getCantidad() - (16 * this.cantidadProducto));

                                        daoAccesorios.actualizar(this.session, acce);

                                        this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                        System.out.println("precio accesorios CORRDIZA 3825 4 CUERPO  0XX0 1672 DOBLE :::" + this.precioAccesorios);

                                        break;

                                }

                                break;

                        }

                    }

////////////////////////////////
                    break;

                case 3://Batiente

                    switch (tipoVentana) {

                        case 1:

                            switch (diseno) {

                            }

                        case 2:

                            switch (diseno) {

                            }

                            break;

                    }

                    break;

            }

            //////
            switch (tipoModeloVentana) {

                case 1:

                    modeloVentana = "Proyectante";

                    break;

                case 2:

                    modeloVentana = "Corrediza";

                    break;

                case 3:

                    modeloVentana = "Batiente";

                    break;

            }

            if (this.idVidrio != 0) {

                DaoVidrio daoVidrio = new DaoVidrio();

                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();

                this.precioVidrio = this.precioVidrio * (Integer.valueOf(alto) * Integer.valueOf(ancho));

                int espacios = String.valueOf(this.precioVidrio).length();

                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));

            }

            if (this.idVidrio == 0) {

                this.precioVidrio = 0;

            }

            VentanaProyec proyec = new VentanaProyec();

            DaoManoObra daoObra = new DaoManoObra();

            int precioInstala = 0;

            switch (tipoModeloVentana) {

                case 1: //Opcion 1 es para ventana proyectante

                    switch (this.tipoAluminioProy) {

                        case 1: // para ventanas proyectante  de aluminio 3831 de la linea ECOMICA ALE

                            switch (tipoColor) {

                                case 1:// para ventanas proyectante  de aluminio 3831 Natural linea ECOMICA ALE

                                    proyec = new VentanaProyec();

                                    proyec.setAlto(alto);

                                    proyec.setAncho(ancho);

                                    proyec.setAltoFijo(this.altoFijo);

                                    proyec.setAnchoFijo(this.anchoFijo);

                                    proyec.setPrecioTrabajo(this.manObra);

                                    proyec.setPrecioDescuento(this.ganancia);

                                    proyec.setTipoProducto(opcionVentana);

                                    proyec.setPrecioCabezal(this.lista.get(131).getPreciocost());

                                    proyec.setPrecioSillar(this.lista.get(137).getPreciocost());

                                    proyec.setPrecioJamba(this.lista.get(132).getPreciocost());

                                    proyec.setPrecioAdaptador(this.lista.get(133).getPreciocost());

                                    proyec.setPrecioEmpaque(this.lista.get(354).getPreciocost());

                                    proyec.VentanaProyec(this.lista.get(134).getPreciocost(), this.lista.get(136).getPreciocost(),
                                            this.lista.get(169).getPreciocost(), this.lista.get(135).getPreciocost(),
                                            this.lista.get(343).getPreciocost(), this.lista.get(342).getPreciocost(), this.lista.get(346).getPreciocost(),
                                            this.lista.get(347).getPreciocost());

                                    break;

                                case 2:// para ventanas proyectante  de aluminio 3831 Anolo linea ECOMICA ALE

                                    proyec = new VentanaProyec();

                                    proyec.setAlto(alto);

                                    proyec.setAncho(ancho);

                                    proyec.setAltoFijo(this.altoFijo);

                                    proyec.setAnchoFijo(this.anchoFijo);

                                    proyec.setPrecioTrabajo(this.manObra);

                                    proyec.setPrecioDescuento(this.ganancia);

                                    proyec.setTipoProducto(opcionVentana);

                                    proyec.setPrecioCabezal(this.lista.get(131).getPrecioAnonizado());

                                    proyec.setPrecioSillar(this.lista.get(137).getPrecioAnonizado());

                                    proyec.setPrecioJamba(this.lista.get(132).getPrecioAnonizado());

                                    proyec.setPrecioAdaptador(this.lista.get(133).getPrecioAnonizado());

                                    proyec.setPrecioEmpaque(this.lista.get(354).getPrecioAnonizado());

                                    proyec.VentanaProyec(this.lista.get(134).getPrecioAnonizado(), this.lista.get(138).getPrecioAnonizado(),
                                            this.lista.get(169).getPrecioAnonizado(), this.lista.get(135).getPrecioAnonizado(),
                                            this.lista.get(343).getPrecioAnonizado(), this.lista.get(342).getPrecioAnonizado(), this.lista.get(346).getPrecioAnonizado(),
                                            this.lista.get(347).getPrecioAnonizado());

                                    break;

                                case 3:// para ventanas proyectante  de aluminio 3831 Pintura linea ECOMICA ALE

                                    proyec = new VentanaProyec();

                                    proyec.setAlto(alto);

                                    proyec.setAncho(ancho);

                                    proyec.setAltoFijo(this.altoFijo);

                                    proyec.setAnchoFijo(this.anchoFijo);

                                    proyec.setPrecioTrabajo(this.manObra);

                                    proyec.setPrecioDescuento(this.ganancia);

                                    proyec.setTipoProducto(opcionVentana);

                                    proyec.setPrecioCabezal(this.lista.get(131).getPrecioPintura());

                                    proyec.setPrecioSillar(this.lista.get(137).getPrecioPintura());

                                    proyec.setPrecioJamba(this.lista.get(132).getPrecioPintura());

                                    proyec.setPrecioAdaptador(this.lista.get(133).getPrecioPintura());

                                    proyec.setPrecioEmpaque(this.lista.get(354).getPrecioPintura());

                                    proyec.VentanaProyec(this.lista.get(134).getPrecioPintura(), this.lista.get(138).getPrecioPintura(),
                                            this.lista.get(169).getPrecioPintura(), this.lista.get(135).getPrecioPintura(),
                                            this.lista.get(343).getPrecioPintura(), this.lista.get(342).getPrecioPintura(), this.lista.get(346).getPrecioPintura(),
                                            this.lista.get(347).getPrecioPintura());

                                    break;

                            }

                            break;

//                        case 4://aluminio 744
//                            break;
                    }

                    precioInstala = this.precioInstalacion;

                    precioInstala = (precioInstala * (proyec.getAlto() * proyec.getAncho())) / 10000;

                    Long precioExtra = this.precioVidrio + this.precioAccesorios + proyec.getSumaTotal();

                    precioExtra = (precioExtra * proyec.getPrecioDescuento() / 100) + precioExtra;

                    this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idVentana),
                            modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtra + precioInstala, this.cantidadProducto * (precioExtra + precioInstala),
                            this.manObra, this.ganancia, this.alto, this.ancho, ""));

                    break;

                case 2: //////Caso 2 ventanas

                    System.out.println("Ventana Corredera XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

                    VentanaCorre corredera = new VentanaCorre();

                    switch (this.tipoAluminioCorred) {

                        case 1: // este constructoer es para ventanas Correderas de aluminio  y con sus distintos colores

                            switch (tipoColor) {

                                case 1:// este es para una ventana con aluminio AS 1700 natutal

                                    corredera = new VentanaCorre();

                                    corredera.setAlto(alto);

                                    corredera.setAncho(ancho);

                                    corredera.setAltoFijo(this.altoFijo);

                                    corredera.setAnchoFijo(this.anchoFijo);

                                    corredera.setPrecioTrabajo(this.manObra);

                                    corredera.setPrecioDescuento(this.ganancia);

                                    corredera.setTipoProducto(opcionVentana);

                                    corredera.setPrecioCabezal(this.lista.get(232).getPreciocost());

                                    corredera.setPrecioSillar(this.lista.get(233).getPreciocost());

                                    corredera.setPrecioJamba(this.lista.get(230).getPreciocost());

                                    corredera.setPrecioHsuperior(this.lista.get(234).getPreciocost());

                                    corredera.setPrecioHinferior(this.lista.get(236).getPreciocost());//este apunta al hInferiorNave

                                    corredera.setPrecioEnganche(this.lista.get(235).getPreciocost());

                                    corredera.setPrecioTraslape(this.lista.get(273).getPreciocost());//este apunta al vertical cerradura

                                    corredera.setPrecioAdaptador(this.lista.get(246).getPreciocost());

                                    corredera.setPrecioEmpaque(this.lista.get(365).getPreciocost());

                                    corredera.setPreciofelpa(this.lista.get(366).getPreciocost());

                                    corredera.calcularVentanaCorre(this.lista.get(295).getPreciocost(), this.lista.get(278).getPreciocost(),
                                            this.lista.get(284).getPreciocost(), this.lista.get(218).getPreciocost(), this.lista.get(279).getPreciocost(),
                                            this.lista.get(220).getPreciocost(), this.lista.get(361).getPreciocost(), this.lista.get(248).getPreciocost(),
                                            this.lista.get(249).getPreciocost(), this.lista.get(285).getPreciocost(), this.lista.get(250).getPreciocost());

                                    System.out.println("entro a correedera 1700:::" + this.tipoAluminioCorred);

                                    break;

                                case 2:

                                    // este es para una ventana con aluminio AS 1700 Anolo
                                    corredera = new VentanaCorre();

                                    corredera.setAlto(alto);

                                    corredera.setAncho(ancho);

                                    corredera.setAltoFijo(this.altoFijo);

                                    corredera.setAnchoFijo(this.anchoFijo);

                                    corredera.setPrecioTrabajo(this.manObra);

                                    corredera.setPrecioDescuento(this.ganancia);

                                    corredera.setTipoProducto(opcionVentana);

                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioAnonizado());

                                    corredera.setPrecioSillar(this.lista.get(233).getPrecioAnonizado());

                                    corredera.setPrecioJamba(this.lista.get(230).getPrecioAnonizado());

                                    corredera.setPrecioHsuperior(this.lista.get(234).getPrecioAnonizado());

                                    corredera.setPrecioHinferior(this.lista.get(236).getPrecioAnonizado());//este apunta al hInferiorNave

                                    corredera.setPrecioEnganche(this.lista.get(235).getPrecioAnonizado());

                                    corredera.setPrecioTraslape(this.lista.get(273).getPrecioAnonizado());//este apunta al vertical cerradura

                                    corredera.setPrecioAdaptador(this.lista.get(246).getPrecioAnonizado());

                                    corredera.setPrecioEmpaque(this.lista.get(365).getPrecioAnonizado());

                                    corredera.setPreciofelpa(this.lista.get(366).getPreciocost());

                                    corredera.calcularVentanaCorre(this.lista.get(295).getPrecioAnonizado(), this.lista.get(278).getPrecioAnonizado(),
                                            this.lista.get(284).getPrecioAnonizado(), this.lista.get(218).getPrecioAnonizado(), this.lista.get(279).getPrecioAnonizado(),
                                            this.lista.get(220).getPrecioAnonizado(), this.lista.get(361).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
                                            this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado());

                                    break;

                                case 3:

                                    // este es para una ventana con aluminio AS 1700 Pintura
                                    corredera = new VentanaCorre();

                                    corredera.setAlto(alto);

                                    corredera.setAncho(ancho);

                                    corredera.setAltoFijo(this.altoFijo);

                                    corredera.setAnchoFijo(this.anchoFijo);

                                    corredera.setPrecioTrabajo(this.manObra);

                                    corredera.setPrecioDescuento(this.ganancia);

                                    corredera.setTipoProducto(opcionVentana);

                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioPintura());

                                    corredera.setPrecioSillar(this.lista.get(233).getPrecioPintura());

                                    corredera.setPrecioJamba(this.lista.get(230).getPrecioPintura());

                                    corredera.setPrecioHsuperior(this.lista.get(234).getPrecioPintura());

                                    corredera.setPrecioHinferior(this.lista.get(236).getPrecioPintura());//este apunta al hInferiorNave

                                    corredera.setPrecioEnganche(this.lista.get(235).getPrecioPintura());

                                    corredera.setPrecioTraslape(this.lista.get(273).getPrecioPintura());//este apunta al vertical cerradura

                                    corredera.setPrecioAdaptador(this.lista.get(246).getPrecioPintura());

                                    corredera.setPrecioEmpaque(this.lista.get(365).getPrecioPintura());

                                    corredera.setPreciofelpa(this.lista.get(366).getPrecioPintura());

                                    corredera.calcularVentanaCorre(this.lista.get(295).getPrecioPintura(), this.lista.get(278).getPrecioPintura(),
                                            this.lista.get(284).getPrecioPintura(), this.lista.get(218).getPrecioPintura(), this.lista.get(279).getPrecioPintura(),
                                            this.lista.get(220).getPrecioPintura(), this.lista.get(361).getPrecioPintura(), this.lista.get(248).getPrecioPintura(),
                                            this.lista.get(249).getPrecioPintura(), this.lista.get(285).getPrecioPintura(), this.lista.get(250).getPrecioPintura());

                                    break;

                            }

                            break;

                        case 2:    // este es para una ventana con aluminio AS 1800 Natural

                            switch (tipoColor) {

                                case 1:

                                    // este es para una ventana con aluminio AS 1800 Natural
                                    //  estos posiciones hay que revisarlas porque el codigo no existe en la base de datos
                                    corredera = new VentanaCorre();

                                    corredera.setAlto(alto);

                                    corredera.setAncho(ancho);

                                    corredera.setAltoFijo(this.altoFijo);

                                    corredera.setAnchoFijo(this.anchoFijo);

                                    corredera.setPrecioTrabajo(this.manObra);

                                    corredera.setPrecioDescuento(this.ganancia);

                                    corredera.setTipoProducto(opcionVentana);

                                    corredera.setPrecioCabezal(this.lista.get(146).getPreciocost());

                                    corredera.setPrecioSillar(this.lista.get(145).getPreciocost());

                                    corredera.setPrecioJamba(this.lista.get(144).getPreciocost());

                                    corredera.setPrecioHsuperior(this.lista.get(151).getPreciocost());

                                    corredera.setPrecioHinferior(this.lista.get(149).getPreciocost());

                                    corredera.setPrecioTraslape(this.lista.get(150).getPreciocost());

                                    corredera.setPrecioAdaptador(this.lista.get(117).getPreciocost());

                                    corredera.setPrecioEmpaque(this.lista.get(362).getPreciocost());

                                    corredera.setPreciofelpa(this.lista.get(366).getPreciocost());

                                    corredera.calcularVentanaCorre(0, this.lista.get(147).getPreciocost(),
                                            0, 0, this.lista.get(152).getPreciocost(), 0, 0, 0, 0, 0, 0);

                                    System.out.println("entro a correedera 3825................................:::" + this.tipoAluminioCorred);

                                    System.out.println("entro a tipo modelo ventana 3825................................:::" + this.tipoModeloVentana);

                                    System.out.println("entro a diseno................................:::" + this.diseno);

                                    System.out.println("entro a opcion ventana 3825................................:::" + opcionVentana);

                                    break;

                                case 2:

                                    // este es para una ventana con aluminio AS 1800 Anolo
                                    corredera = new VentanaCorre();

                                    corredera.setAlto(alto);

                                    corredera.setAncho(ancho);

                                    corredera.setAltoFijo(this.altoFijo);

                                    corredera.setAnchoFijo(this.anchoFijo);

                                    corredera.setPrecioTrabajo(this.manObra);

                                    corredera.setPrecioDescuento(this.ganancia);

                                    corredera.setTipoProducto(opcionVentana);

                                    corredera.setPrecioCabezal(this.lista.get(146).getPrecioAnonizado());

                                    corredera.setPrecioSillar(this.lista.get(145).getPrecioAnonizado());

                                    corredera.setPrecioJamba(this.lista.get(144).getPrecioAnonizado());

                                    corredera.setPrecioHsuperior(this.lista.get(151).getPrecioAnonizado());

                                    corredera.setPrecioHinferior(this.lista.get(149).getPrecioAnonizado());

                                    corredera.setPrecioTraslape(this.lista.get(150).getPrecioAnonizado());

                                    corredera.setPrecioAdaptador(this.lista.get(117).getPrecioAnonizado());

                                    corredera.setPrecioEmpaque(this.lista.get(362).getPrecioAnonizado());

                                    corredera.setPreciofelpa(this.lista.get(366).getPrecioAnonizado());

                                    corredera.calcularVentanaCorre(0, this.lista.get(147).getPrecioAnonizado(),
                                            0, 0, this.lista.get(152).getPrecioAnonizado(), 0, 0, 0, 0, 0, 0);

                                    break;

                                case 3:

                                    // este es para una ventana con aluminio AS 1800 pintura
                                    corredera = new VentanaCorre();

                                    corredera.setAlto(alto);

                                    corredera.setAncho(ancho);

                                    corredera.setAltoFijo(this.altoFijo);

                                    corredera.setAnchoFijo(this.anchoFijo);

                                    corredera.setPrecioTrabajo(this.manObra);

                                    corredera.setPrecioDescuento(this.ganancia);

                                    corredera.setTipoProducto(opcionVentana);

                                    corredera.setPrecioCabezal(this.lista.get(146).getPrecioPintura());

                                    corredera.setPrecioSillar(this.lista.get(145).getPrecioPintura());

                                    corredera.setPrecioJamba(this.lista.get(144).getPrecioPintura());

                                    corredera.setPrecioHsuperior(this.lista.get(151).getPrecioPintura());

                                    corredera.setPrecioHinferior(this.lista.get(149).getPrecioPintura());

                                    corredera.setPrecioTraslape(this.lista.get(150).getPrecioPintura());

                                    corredera.setPrecioAdaptador(this.lista.get(117).getPrecioPintura());

                                    corredera.setPrecioEmpaque(this.lista.get(362).getPrecioPintura());

                                    corredera.setPreciofelpa(this.lista.get(366).getPrecioPintura());

                                    corredera.calcularVentanaCorre(0, this.lista.get(147).getPrecioPintura(),
                                            0, 0, this.lista.get(152).getPrecioPintura(), 0, 0, 0, 0, 0, 0);

                                    break;

                            }

                            break;

                    }

                    precioInstala = this.precioInstalacion;

                    precioInstala = (precioInstala * (corredera.getAlto() * corredera.getAncho())) / 10000;

                    Long precioExtrac = this.precioVidrio + this.precioAccesorios + corredera.getSumaTotal();

                    precioExtrac = (precioExtrac * corredera.getPrecioDescuento() / 100) + precioExtrac;

                    this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idVentana),
                            modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtrac + precioInstala, this.cantidadProducto * (precioExtrac + precioInstala),
                            this.manObra, this.ganancia, this.alto, this.ancho, ""));

                    break;

                case 3: //////Caso 2 ventanas de  Abatibles celosial

                    VentanaAbati abatible = new VentanaAbati();

                    switch (this.tipoAluminioBati) {

                        case 1: // este constructoer es para ventanas Abatibles celosial de aluminio 3835 y con sus distintos colores

                            switch (tipoColor) {

                            }

                            break;

                    }

                    precioInstala = this.precioInstalacion;

                    precioInstala = (precioInstala * (abatible.getAlto() * abatible.getAncho())) / 10000;

                    Long precioExtraa = this.precioVidrio + this.precioAccesorios + abatible.getSumaTotal();

                    precioExtraa = (precioExtraa * abatible.getPrecioDescuento() / 100) + precioExtraa;

                    this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, idVentana),
                            modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtraa + precioInstala, this.cantidadProducto * (precioExtraa + precioInstala), this.manObra, this.ganancia, this.alto, this.ancho, ""));

//////////////Caso 3
                    break;

            }

            if (this.idVidrio == 0) {

                this.precioVidrio = 0;

            }

            if (this.productoTipo == 4) {

                this.listaVentana.add(new Ventanadetalle(null, daoProductos.getById(this.session, this.tipoVentana),
                        daoProductos.getById(this.session, this.tipoVentana).getNombre() + " " + this.alto + "*" + this.ancho,
                        this.cantidadProducto, this.precioVidrio + this.manObra, this.cantidadProducto * this.precioVidrio, this.manObra, this.ganancia, this.alto, this.ancho, ""));

            }

            this.transaction.commit();

            this.idVidrio = 0;

            this.ganancia = 0;

            this.alto = "";

            this.ancho = "";

            this.manObra = 0;

            this.tipoVentana = 0;

            this.tipoVidrio = 0;

            this.productoTipo = 0;

            this.cantidadProducto = 0;

            this.precioInstalacion = 0;

            this.tipoAluminioBati = 0;

            this.tipoAluminioCorred = 0;

            this.tipoAluminioProy = 0;

            this.tipoModeloVentana = 0;

        } catch (Exception ex) {

            if (this.transaction != null) {

                this.transaction.rollback();

            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.toString()));

            System.out.println("Ocurrio un error:::" + ex.toString());

        } finally {

            if (this.session != null) {

                this.session.close();

            }

        }

    }

    public long calculaIva(Long preci) {

        Long sumaIva = preci * 16 / 100;

        sumaIva += preci;

        return sumaIva;

    }

    public void generarFactura() throws Exception {

        this.session = null;

        this.transaction = null;

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        String correoEmple = httpSession.getAttribute("correoElectronico").toString();

        try {

            DaoEmpleado daoEmpleado = new DaoEmpleado();

            DaoFactura daoFactura = new DaoFactura();

            DaoDetalle daoDetalle = new DaoDetalle();

            if (this.cliente == null) {

                System.out.println("codigo del cliente");

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor selecione un cliente."));

                return;

            }

            System.out.println(".........3");

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            Facturas factu = new Facturas();

            factu = daoFactura.getByUltimoRegistro(this.session);

            int idBdFactura = 0;

            if (factu != null) {

                idBdFactura = factu.getIdfacturas();

            }

            this.factura.setIdfacturas(idBdFactura + 1);

            this.factura.setCliente(cliente);

            this.factura.setEmpleado(daoEmpleado.getByCorreoElectronico(this.session, correoEmple));

            System.out.println(".........4");

            this.factura.setFechaventa(new Date());

            daoFactura.registar(this.session, this.factura);

            System.out.println(".........5");

            this.factura = daoFactura.getByUltimoRegistro(this.session);

            long suma = 0;

            long subtota = 0;

            long ivat = 0;

            for (Ventanadetalle listaVentana1 : this.listaVentana) {

                listaVentana1.setFacturas(this.factura);

                suma += listaVentana1.getTotal();

                ivat = suma * 16 / 100;

                subtota = suma + ivat;

                daoDetalle.registar(this.session, listaVentana1);

            }

            this.listaFactura = this.listaVentana;

            this.factura.setSubtotal(suma);

            this.factura.setIva(ivat);

            this.factura.setPreciototal(subtota);

            daoFactura.actualizar(this.session, this.factura);

            this.factura.setFechaventa(new Date());

            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

            sesson.setAttribute("idfactura", this.factura.getIdfacturas());

            System.out.println("recuperamos el id de la fact " + getFactura().getIdfacturas());

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Se ha registrado "));

            System.out.println("ok se registro");

        } catch (Exception ex) {

            if (this.transaction != null) {

                this.transaction.rollback();

            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            System.out.println("error:::::::::::" + ex.toString());

        } finally {

            if (this.session != null) {

                this.session.close();

            }

        }

    }

    public String convertFecha(Date fecha) {

        if (fecha != null) {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            return format.format(fecha);

        }

        return "";

    }

    public void retirarListaVentaDetalle(String nombre) {

        try {

            int i = 0;

            for (Ventanadetalle listaVentana1 : this.listaVentana) {

                if (listaVentana1.getNombrepro().equals(nombre)) {

                    this.listaVentana.remove(i);

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Productos retirado de la lista de ventas"));

                    break;

                }

                i++;

            }

            long total = 0;

            for (Ventanadetalle listaVentana1 : listaVentana) {

                listaVentana1.setTotal(listaVentana1.getCantidad() * listaVentana1.getPrecioventa());

                total = total + listaVentana1.getTotal();

            }

            this.factura.setSubtotal(total);

            this.factura.setIva((this.factura.getSubtotal() * 16) / 100);

            this.factura.setPreciototal(this.factura.getSubtotal() + this.factura.getIva());

        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));

        }

    }

    public void calcular() {

        long total = 0;

        try {

            for (Ventanadetalle listaVentana1 : listaVentana) {

                listaVentana1.setTotal(listaVentana1.getCantidad() * listaVentana1.getPrecioventa());

                total = total + listaVentana1.getTotal();

            }

            this.factura.setSubtotal(total);

            this.factura.setIva((this.factura.getSubtotal() * 16) / 100);

            this.factura.setPreciototal(this.factura.getSubtotal() + this.factura.getIva());

//            RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));

        }

    }

    public List<Ventanadetalle> getByIdFactura() {

        this.session = null;

        this.transaction = null;

        try {

            DaoFactura daoFactura = new DaoFactura();

            DaoDetalle daoDetalle = new DaoDetalle();

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

            this.factura = daoFactura.getById(this.session, Integer.valueOf(sesson.getAttribute("idfactura").toString()));

            List<Ventanadetalle> listaVenta = daoDetalle.getAllByIdFactura(this.session, this.factura.getIdfacturas());

            this.transaction.commit();

            return listaVenta;

        } catch (Exception ex) {

            if (this.transaction != null) {

                this.transaction.rollback();

            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;

        } finally {

            if (this.session != null) {

                this.session.close();

            }

        }

    }

    public Facturas getFacturaActual() {

        this.session = null;

        this.transaction = null;

        try {

            DaoFactura daoFactura = new DaoFactura();

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

            this.factura = daoFactura.getById(this.session, Integer.valueOf(sesson.getAttribute("idfactura").toString()));

            this.transaction.commit();

            return this.factura;

        } catch (Exception ex) {

            if (this.transaction != null) {

                this.transaction.rollback();

            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;

        } finally {

            if (this.session != null) {

                this.session.close();

            }

        }

    }

    public List<Facturas> getAll() {

        this.session = null;

        this.transaction = null;

        try {

            DaoFactura daoFactura = new DaoFactura();

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            this.listaFact = daoFactura.getAll(this.session);

            this.transaction.commit();

            return this.listaFact;

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

    public List<Facturas> getListVentasByFecha() {

        if (listaVentasByFecha == null) {

            listaVentasByFecha = new ArrayList<>();

        }

        return listaVentasByFecha;

    }

    public List<String> completeText(String query) {

        MbCliente mbCliente = new MbCliente();

        List<Cliente> allClientes = new ArrayList<>();

        allClientes.addAll(mbCliente.getAll());

        List<String> results = new ArrayList<>();

        for (int i = 0; i < allClientes.size(); i++) {

            Cliente clients = allClientes.get(i);

            if (clients.getNumeroDocumentoC().toLowerCase().startsWith(query)) {

                results.add(clients.getNumeroDocumentoC());

            }

        }

        return results;

    }

    public void consultarVentas() {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            DaoFactura daoFactura = new DaoFactura();

            this.listaVentasByFecha = daoFactura.getAllFecha(this.session, this.fechaInicio, this.fechaFin);

            totalVentasFecha = 0;

            for (Facturas facturas : listaVentasByFecha) {

                totalVentasFecha = totalVentasFecha + (facturas.getPreciototal());

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

    public void selectFactura(int id) {

        this.idFactura = id;

    }

    public void searchByDocumento() {

        this.listaFact = new ArrayList<>();

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            this.transaction = this.session.beginTransaction();

            DaoCliente daoCliente = new DaoCliente();

            DaoFactura daoFactura = new DaoFactura();

            this.cliente = daoCliente.getByNumeroDocumento(this.session, this.numeroDocumento);

            this.listaFact.addAll(daoFactura.getAllByCliente(this.session, this.numeroDocumento));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Contacte con su administrador" + e.getMessage()));

            this.listaFact = null;

            this.cliente = null;

            if (this.transaction != null) {

                this.transaction.rollback();

                this.session.close();

            }

        }

    }

    public void calcularDevueltas(int monto, long precioVenta) {

        try {

            this.setMontoDinero(montoDinero);

            saldoDevuelta = saldoDevuelta + (this.montoDinero - this.factura.getPreciototal());

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));

        }

    }

//    aqui comienza el codigo nuevo
    public void agregarDatosCliente(Integer codCliente) {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoCliente daoCliente = new DaoCliente();

            this.transaction = this.session.beginTransaction();

            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente
            this.cliente = daoCliente.getById(this.session, codCliente);

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

    public void agregarDatosCliente2() {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoCliente daoCliente = new DaoCliente();

            this.transaction = this.session.beginTransaction();

            //obtener los datos del producto en la variable objecto cliente segun el codigo del cliente
            this.cliente = daoCliente.getById(this.session, this.codigoCliente);

//            if (this.cliente != null) {
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

    public void agregarDatosEmpleado(Integer codEmpleado) {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoEmpleado daoEmpleado = new DaoEmpleado();

            this.transaction = this.session.beginTransaction();

            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente
            this.empleado = daoEmpleado.getById(this.session, codEmpleado);

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

    public void agregarDatosEmpleado2() {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoEmpleado daoEmpleado = new DaoEmpleado();

            this.transaction = this.session.beginTransaction();

            //obtener los datos del producto en la variable objecto cliente segun el codigo del cliente
            this.empleado = daoEmpleado.getById(this.session, this.codigoEmpleado);

//            if (this.empleado != null) {
////                this.codigoEmpleado = null;
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

    public void limpiarFactura() {

        this.cliente = new Cliente();

        this.empleado = new Empleado();

        this.factura = new Facturas();

        this.listaVentana = new ArrayList<>();

        this.listaFactura = new ArrayList<>();

//        invocar el metodo para destivar controles en a factura
        this.disableButton();

    }

    public List<Cliente> getAllClientes() {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoCliente daoCliente = new DaoCliente();

            this.transaction = this.session.beginTransaction();

            this.listaClientes = daoCliente.getAll(this.session);

            this.transaction.commit();

            return this.listaClientes;

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

    public List<Empleado> getAllEmpleado() {

        this.session = null;

        this.transaction = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoEmpleado daoEmpleado = new DaoEmpleado();

            this.transaction = this.session.beginTransaction();

            this.listaEmpleado = daoEmpleado.getAll(this.session);

            this.transaction.commit();

            return this.listaEmpleado;

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
        this.calcular();

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

    public long getPrecioVidrio() {

        return precioVidrio;

    }

    public void setPrecioVidrio(long precioVidrio) {

        this.precioVidrio = precioVidrio;

    }

    public int getIdVidrio() {

        return idVidrio;

    }

    public void setIdVidrio(int idVidrio) {

        this.idVidrio = idVidrio;

    }

    public Facturas getFactura() {

        return factura;

    }

    public void setFactura(Facturas factura) {

        this.factura = factura;

    }

    public String getIdCliente() {

        return idCliente;

    }

    public void setIdCliente(String idCliente) {

        this.idCliente = idCliente;

    }

    public int getIdEmpleado() {

        return idEmpleado;

    }

    public void setIdEmpleado(int idEmpleado) {

        this.idEmpleado = idEmpleado;

    }

    public int getGanancia() {

        return ganancia;

    }

    public void setGanancia(int ganancia) {

        this.ganancia = ganancia;

    }

    public int getManObra() {

        return manObra;

    }

    public void setManObra(int manObra) {

        this.manObra = manObra;

    }

    public String getAncho() {

        return ancho;

    }

    public void setAncho(String ancho) {

        this.ancho = ancho;

    }

    public String getAlto() {

        return alto;

    }

    public void setAlto(String alto) {

        this.alto = alto;

    }

    public Ventanadetalle getVentana() {

        return ventana;

    }

    public void setVentana(Ventanadetalle ventana) {

        this.ventana = ventana;

    }

    public ArrayList<Ventanadetalle> getListaVentana() {

        return listaVentana;

    }

    public void setListaVentana(ArrayList<Ventanadetalle> listaVentana) {

        this.listaVentana = listaVentana;

    }

    public int getTipoVidrio() {

        return tipoVidrio;

    }

    public void setTipoVidrio(int tipoVidrio) {

        this.tipoVidrio = tipoVidrio;

    }

    public int getTipoVentana() {

        return tipoVentana;

    }

    public void setTipoVentana(int tipoVentana) {

        this.tipoVentana = tipoVentana;

    }

    public ArrayList<Materiales> getLista() {

        return lista;

    }

    public void setLista(ArrayList<Materiales> lista) {

        this.lista = lista;

    }

    public ArrayList<Ventanadetalle> getListaFactura() {

        return listaFactura;

    }

    public void setListaFactura(ArrayList<Ventanadetalle> listaFactura) {

        this.listaFactura = listaFactura;

    }

    public List<Facturas> getListaFact() {

        return listaFact;

    }

    public void setListaFact(List<Facturas> listaFact) {

        this.listaFact = listaFact;

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

    public long getTotalVentasFecha() {

        return totalVentasFecha;

    }

    public void setTotalVentasFecha(long totalVentasFecha) {

        this.totalVentasFecha = totalVentasFecha;

    }

    public List<Facturas> getListaVentasByFecha() {

        return listaVentasByFecha;

    }

    public void setListaVentasByFecha(List<Facturas> listaVentasByFecha) {

        this.listaVentasByFecha = listaVentasByFecha;

    }

    public List<Facturas> getListaFactFiltrado() {

        return listaFactFiltrado;

    }

    public void setListaFactFiltrado(List<Facturas> listaFactFiltrado) {

        this.listaFactFiltrado = listaFactFiltrado;

    }

    public int getTipoAluminio() {

        return tipoAluminio;

    }

    public void setTipoAluminio(int tipoAluminio) {

        this.tipoAluminio = tipoAluminio;

    }

    public String getFondo() {

        return fondo;

    }

    public void setFondo(String fondo) {

        this.fondo = fondo;

    }

    public int getProductoTipo() {

        return productoTipo;

    }

    public void setProductoTipo(int productoTipo) {

        this.productoTipo = productoTipo;

    }

    public int getTipoPuerta() {

        return tipoPuerta;

    }

    public void setTipoPuerta(int tipoPuerta) {

        this.tipoPuerta = tipoPuerta;

    }

    public int getTipoVitrina() {

        return tipoVitrina;

    }

    public void setTipoVitrina(int tipoVitrina) {

        this.tipoVitrina = tipoVitrina;

    }

    public String getNumeroDocumento() {

        return numeroDocumento;

    }

    public void setNumeroDocumento(String numeroDocumento) {

        this.numeroDocumento = numeroDocumento;

    }

    public int getIdFactura() {

        return idFactura;

    }

    public void setIdFactura(int idFactura) {

        this.idFactura = idFactura;

    }

    public Cliente getCliente() {

        return cliente;

    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;

    }

    public Long getMontoDinero() {

        return montoDinero;

    }

    public void setMontoDinero(Long montoDinero) {

        this.montoDinero = montoDinero;

    }

    public Long getSaldoDevuelta() {

        return saldoDevuelta;

    }

    public void setSaldoDevuelta(Long saldoDevuelta) {

        this.saldoDevuelta = saldoDevuelta;

    }

    public int getTipoEntrepanos() {

        return tipoEntrepanos;

    }

    public void setTipoEntrepanos(int tipoEntrepanos) {

        this.tipoEntrepanos = tipoEntrepanos;

    }

    public String getNombreProducto() {

        return nombreProducto;

    }

    public void setNombreProducto(String nombreProducto) {

        this.nombreProducto = nombreProducto;

    }

    public long getPrecioTotal() {

        return precioTotal;

    }

    public void setPrecioTotal(long precioTotal) {

        this.precioTotal = precioTotal;

    }

    public Cliente getClient1() {

        return client1;

    }

    public void setClient1(Cliente client1) {

        this.client1 = client1;

    }

    public Empleado getEmpleado() {

        return empleado;

    }

    public void setEmpleado(Empleado empleado) {

        this.empleado = empleado;

    }

    public int getCodigoCliente() {

        return codigoCliente;

    }

    public void setCodigoCliente(int codigoCliente) {

        this.codigoCliente = codigoCliente;

    }

    public int getCodigoEmpleado() {

        return codigoEmpleado;

    }

    public void setCodigoEmpleado(int codigoEmpleado) {

        this.codigoEmpleado = codigoEmpleado;

    }

    public String getCorreoElectronico() {

        return correoElectronico;

    }

    public void setCorreoElectronico(String correoElectronico) {

        this.correoElectronico = correoElectronico;

    }

    public List<Cliente> getListaClientes() {

        return listaClientes;

    }

    public void setListaClientes(List<Cliente> listaClientes) {

        this.listaClientes = listaClientes;

    }

    public List<Empleado> getListaEmpleado() {

        return listaEmpleado;

    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {

        this.listaEmpleado = listaEmpleado;

    }

    public String getProductoSelecionado() {

        return productoSelecionado;

    }

    public void setProductoSelecionado(String productoSelecionado) {

        this.productoSelecionado = productoSelecionado;

    }

    public List<Cliente> getListaClienteFiltrado() {

        return listaClienteFiltrado;

    }

    public void setListaClienteFiltrado(List<Cliente> listaClienteFiltrado) {

        this.listaClienteFiltrado = listaClienteFiltrado;

    }

    public int getTipoColorVitrina() {

        return tipoColorVitrina;

    }

    public void setTipoColorVitrina(int tipoColorVitrina) {

        this.tipoColorVitrina = tipoColorVitrina;

    }

    public int getPrecioAccesorios() {

        return precioAccesorios;

    }

    public void setPrecioAccesorios(int precioAccesorios) {

        this.precioAccesorios = precioAccesorios;

    }

    public int getTipoAluminioPuerta() {

        return tipoAluminioPuerta;

    }

    public void setTipoAluminioPuerta(int tipoAluminioPuerta) {

        this.tipoAluminioPuerta = tipoAluminioPuerta;

    }

    private Accesorios daoAccesorios(Session session, int i) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public int getCantidadProducto() {

        return cantidadProducto;

    }

    public void setCantidadProducto(int cantidadProducto) {

        this.cantidadProducto = cantidadProducto;

    }

    public int getTipoColor() {

        return tipoColor;

    }

    public void setTipoColor(int tipoColor) {

        this.tipoColor = tipoColor;

    }

    public int getTipoModeloVentana() {

        return tipoModeloVentana;

    }

    public void setTipoModeloVentana(int tipoModeloVentana) {

        this.tipoModeloVentana = tipoModeloVentana;

    }

    public int getDiseno() {

        return diseno;

    }

    public void setDiseno(int diseno) {

        this.diseno = diseno;

    }

    public int getPrecioInstalacion() {

        return precioInstalacion;

    }

    public void setPrecioInstalacion(int precioInstalacion) {

        this.precioInstalacion = precioInstalacion;

    }

    public int getTipoAluminioProy() {

        return tipoAluminioProy;

    }

    public void setTipoAluminioProy(int tipoAluminioProy) {

        this.tipoAluminioProy = tipoAluminioProy;

    }

    public int getTipoAluminioCorred() {

        return tipoAluminioCorred;

    }

    public void setTipoAluminioCorred(int tipoAluminioCorred) {

        this.tipoAluminioCorred = tipoAluminioCorred;

    }

    public int getTipoAluminioBati() {

        return tipoAluminioBati;

    }

    public void setTipoAluminioBati(int tipoAluminioBati) {

        this.tipoAluminioBati = tipoAluminioBati;

    }

    public int getTipoAlumPuertaBat() {

        return tipoAlumPuertaBat;

    }

    public void setTipoAlumPuertaBat(int tipoAlumPuertaBat) {

        this.tipoAlumPuertaBat = tipoAlumPuertaBat;

    }

    public int getTipoAlumPuertaCor() {

        return tipoAlumPuertaCor;

    }

    public void setTipoAlumPuertaCor(int tipoAlumPuertaCor) {

        this.tipoAlumPuertaCor = tipoAlumPuertaCor;

    }

    public int getTipoAlumPuertaPok() {

        return tipoAlumPuertaPok;

    }

    public void setTipoAlumPuertaPok(int tipoAlumPuertaPok) {

        this.tipoAlumPuertaPok = tipoAlumPuertaPok;

    }

    public int getTipoModeloPuerta() {

        return tipoModeloPuerta;

    }

    public void setTipoModeloPuerta(int tipoModeloPuerta) {

        this.tipoModeloPuerta = tipoModeloPuerta;

    }

    public String getAltoFijo() {

        return altoFijo;

    }

    public void setAltoFijo(String altoFijo) {

        this.altoFijo = altoFijo;

    }

    public String getAnchoFijo() {

        return anchoFijo;

    }

    public void setAnchoFijo(String anchoFijo) {

        this.anchoFijo = anchoFijo;

    }

    public int getTipoPersiana() {
        return tipoPersiana;
    }

    public void setTipoPersiana(int tipoPersiana) {
        this.tipoPersiana = tipoPersiana;
    }

}
