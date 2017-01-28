///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package MbView;
//
//import Clases.Puerta;
//import Clases.Vitrina;
//import Daos.DaoAbonoDetalle;
//import Clases.Despiece;
//import Clases.Ventana;
//import Clases.VentanaAbatible;
//import Clases.VentanaCorredera;
//import Clases.VentanaProyectante;
//import Daos.DaoAbonos;
//import Daos.DaoAccesorios;
//import Daos.DaoCliente;
//import Daos.DaoEmpleado;
//import Daos.DaoMaterial;
//import Daos.DaoProductos;
//import Daos.DaoVidrio;
//import HibernateUtil.HibernateUtil;
//import Pojos.Abonodetalle;
//import Pojos.Abonos;
//import Pojos.Abonosecundario;
//import Pojos.Accesorios;
//import Pojos.Cliente;
//import Pojos.Empleado;
//import Pojos.Materiales;
//import com.lowagie.text.Document;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.html.simpleparser.HTMLWorker;
//import com.sun.org.apache.bcel.internal.generic.SWITCH;
//import java.io.StringReader;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.primefaces.context.RequestContext;
//import org.primefaces.event.RowEditEvent;
//import org.primefaces.model.UploadedFile;
//
///**
// *
// * @author William Sanchez
// */
//@ManagedBean
//@ViewScoped
//public class BeanAbonos2 {
//
//    /**
//     * Creates a new instance of MbAbonos
//     */
//    private Session session;
//    private Transaction transaccion;
//
//    private Abonodetalle abonoDeta;
//    private ArrayList<Abonodetalle> listaAbono;
//    private ArrayList<Abonodetalle> listaFactura;
//    private ArrayList<Materiales> lista;
//    private List<Abonos> listaAbonosFiltrado;
//    private int tipoVidrio;
//    private int tipoVentana;
//    private String ancho;
//    private String alto;
//    private int ganancia;
//    private int manObra;
//    private Abonos abonos;
//    private List<Abonos> listaAbonoSel;
//    private List<Abonos> listaVentasByFecha;
//    private String idCliente;
//    private int idEmpleado;
//    private int idAbono;
//    private long precioVidrio;
//    private int precioAccesorios;
//    private int idVidrio;
//    private Date fechaFin;
//    private Date fechaInicio;
//    private long totalVentasFecha;
//    private long montoAbono;
//    private List<Abonosecundario> listaAbonoSecundario;
//    private int idAbonoSecundario;
//    private int productoTipo;
//    private int tipoProductos;
//    private String fondo;
//    private int tipoPuerta;
//    private int tipoVitrina;
//    private int tipoEntrepanos;
//    private String nombreProducto;
//    private long precioTotal;
//    private int tipoAluminio;
//    private String numeroDocumento;
//    private Cliente cliente;
//    private Abonos abonoSelect;
//    private Empleado empleado;
//    private int codigoCliente;
//    private int codigoEmpleado;
//    private List<Despiece> lstDespiece;
//    private int tipoAluminioPuerta;
//    private int tipoColorVitrina;
//    private int cantidadProducto;
//    private int tipoColor;
//    private int tipoModeloVentana;
//    private int tipoNaves;
//    private int tipo3Naves;
//    private int tipo4Naves;
//    private int tipo5Naves;
//
//    private List<Cliente> listaClientes;
//    private List<Empleado> listaEmpleado;
//
//    public BeanAbonos2() {
//        this.lstDespiece = new ArrayList<>();
//        this.listaVentasByFecha = new ArrayList<>();
//        this.listaAbonoSel = new ArrayList<>();
//        this.lista = new ArrayList<>();
//        this.listaAbono = new ArrayList<>();
//        this.listaFactura = new ArrayList<>();
//        this.abonos = new Abonos();
//        this.abonoDeta = new Abonodetalle();
//        this.listaAbonoSecundario = new ArrayList<>();
//        this.empleado = new Empleado();
//        this.listaClientes = new ArrayList<>();
//        this.listaEmpleado = new ArrayList<>();
//        this.cliente = new Cliente();
//        this.idVidrio = 0;
//        this.ganancia = 0;
//        this.alto = "";
//        this.ancho = "";
//        this.manObra = 0;
//        this.tipoVentana = 0;
//        this.tipoPuerta = 0;
//        this.tipoVidrio = 0;
//        this.tipoVitrina = 0;
//        this.fondo = "";
//        this.productoTipo = 0;
//        this.tipoEntrepanos = 0;
//        this.tipoAluminioPuerta = 0;
//    }
//
//    public void agregarProducto() {
//        switch (this.tipoProductos) {
//            case 1:
//                calcularVentanaCorrediza();
//                calcular();
//                break;
//            case 2:
//                calcularVentanaAbatible();
//                calcular();
//                break;
//            case 3:
//                calcularVentanaCelosial(); //proyectante
//                calcular();
//                break;
//
//            case 4:
//                calcularPuerta();
//                calcular();
//                break;
//            case 5:
//                calcularVitrina();
//                calcular();
//                break;
//            case 6:
//                calcularVentanaCorrediza();
//                calcular();
//                break;
//            case 0:
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto"));
//                break;
//        }
//    }
//
//    public void calcularVitrina() {
//        this.session = null;
//        this.transaccion = null;
//        Vitrina vitrina = new Vitrina();
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//            DaoProductos daoProductos = new DaoProductos();
//
//            DaoMaterial daoMaterial = new DaoMaterial();
//            this.lista.addAll(daoMaterial.getAll(this.session));
//
//            if (this.tipoColorVitrina == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
//                return;
//            }
//
//            int idProdVitrina = 0;
//            switch (tipoVitrina) {
//                case 1:
//                    idProdVitrina = 7;
//                    break;
//                case 2:
//                    idProdVitrina = 11;
//                    break;
//                case 3:
//                    idProdVitrina = 12;
//                    break;
//
//            }
//
//            String nombreAluminio = "";
//            switch (tipoColorVitrina) {
//                case 1:
//                    nombreAluminio = " Color natural";
//                    break;
//                case 2:
//                    nombreAluminio = " Color Anolo";
//                    break;
//                case 3:
//                    nombreAluminio = " Colores ";
//                    break;
//            }
//
//            if (this.tipoVitrina == 1) {
////                vitrina de angulo de 1 1/2 con acoples
//
//                vitrina = new Vitrina(this.ancho, this.alto, this.fondo, this.manObra, this.ganancia,
//                        this.lista.get(77).getPreciocost(), this.lista.get(78).getPreciocost(),
//                        this.lista.get(79).getPreciocost(), this.lista.get(117).getPreciocost(),
//                        this.tipoVitrina, this.lista.get(80).getPreciocost(), this.lista.get(81).getPreciocost());
//
//                //  
//            } else {
//                if (this.tipoVitrina == 2) {
////                        vitrina de angulo de 1  y rodamientos sencillos
//
//                    vitrina = new Vitrina(this.ancho, this.alto, this.fondo, this.manObra, this.ganancia,
//                            this.lista.get(107).getPreciocost(), this.lista.get(108).getPreciocost(),
//                            this.lista.get(109).getPreciocost(), this.lista.get(118).getPreciocost(),
//                            this.tipoVitrina, this.lista.get(110).getPreciocost(), this.lista.get(111).getPreciocost());
//
//                } else {
//                    if (this.tipoVitrina == 3) {
////                           vitrina de angulo de 1 , rodamientos sencillos y largo de mas de 135cm
//
//                        vitrina = new Vitrina(this.ancho, this.alto, this.fondo, this.manObra, this.ganancia,
//                                this.lista.get(112).getPreciocost(), this.lista.get(113).getPreciocost(),
//                                this.lista.get(114).getPreciocost(), this.lista.get(119).getPreciocost(),
//                                this.tipoVitrina, this.lista.get(115).getPreciocost(), this.lista.get(116).getPreciocost());
//
//                    }
//                }
//            }
//
//            if (this.idVidrio != 0) {
//                int vidrioEntrepano = 0;
//                DaoVidrio daoVidrio = new DaoVidrio();
//
//                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
//                vidrioEntrepano = daoVidrio.getById(this.session, 6).getPreciocost();
//                long precFondos = this.precioVidrio * (vitrina.getAlto() * vitrina.getFondo());
//                precFondos = precFondos * 2;
//                long precFondoAncho = this.precioVidrio * (vitrina.getAncho() * vitrina.getFondo());
//                precFondoAncho = precFondoAncho * 2;
//                this.precioVidrio = this.precioVidrio * (vitrina.getAlto() * vitrina.getAncho());
//                this.precioVidrio = this.precioVidrio * 2;
//                this.precioVidrio = this.precioVidrio + precFondos + precFondoAncho;
//
//                if (this.tipoEntrepanos == 1) {
//                    vidrioEntrepano = vidrioEntrepano * (vitrina.getAncho() * vitrina.getFondo() * 3);
//                } else {
//                    if (this.tipoEntrepanos == 2) {
//                        vidrioEntrepano = vidrioEntrepano * (vitrina.getAncho() * vitrina.getFondo() * 4);
//                    }
//                }
//
//                // this.precioVidrio=this.precioVidrio+(this.precioVidrio*50/100);
//                this.precioVidrio = this.precioVidrio + vidrioEntrepano;
//                this.precioVidrio = this.precioVidrio + (this.precioVidrio / 2);
//                int espacios = String.valueOf(this.precioVidrio).length();
//                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
//
//            } else {
//                if (this.idVidrio == 0) {
//                    this.precioVidrio = 0;
//                }
//            }
//            if (this.tipoVitrina == 1) {
//                DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                int pianas = 0;
//                int rodamientoPiso = 0;
//                int rodamientoDucha = 0;
//                int acoples = 0;
//
//                pianas = daoAcessorios.getById(this.session, 18).getPrecioCosto() * 8;
//                rodamientoPiso = daoAcessorios.getById(this.session, 4).getPrecioCosto() * 4;
//                rodamientoDucha = daoAcessorios.getById(this.session, 6).getPrecioCosto() * 4;
//                acoples = daoAcessorios.getById(this.session, 15).getPrecioCosto() * 8;
//
//                this.precioAccesorios = pianas + rodamientoPiso + rodamientoDucha + acoples;
//
//            } else {
//                if (this.tipoVitrina == 2) {
//                    DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                    int pianas = 0;
//                    int rodamientoEconomco = 0;
//                    int anclajeA15 = 0;
//
//                    pianas = daoAcessorios.getById(this.session, 18).getPrecioCosto() * 8;
//                    rodamientoEconomco = daoAcessorios.getById(this.session, 5).getPrecioCosto() * 4;
//                    anclajeA15 = daoAcessorios.getById(this.session, 22).getPrecioCosto() * 8;
//                    this.precioAccesorios = pianas + rodamientoEconomco + anclajeA15;
//                } else {
//                    if (this.tipoVitrina == 3) {
//                        DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                        int pianas = 0;
//                        int rodamientoEconomco = 0;
//                        int anclajeA15 = 0;
//
//                        pianas = daoAcessorios.getById(this.session, 18).getPrecioCosto() * 16;
//                        rodamientoEconomco = daoAcessorios.getById(this.session, 5).getPrecioCosto() * 4;
//                        anclajeA15 = daoAcessorios.getById(this.session, 22).getPrecioCosto() * 8;
//                        this.precioAccesorios = pianas + rodamientoEconomco + anclajeA15;
//
//                    }
//                }
//
//            }
//
//            if (this.tipoVitrina < 4 && this.tipoVitrina > 0) {
//
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idProdVitrina),
//                        daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho + " fondo: " + this.fondo,
//                        this.cantidadProducto, vitrina.getSumaTotal() + this.precioVidrio + this.precioAccesorios, this.cantidadProducto * vitrina.getSumaTotal()
//                        + this.precioVidrio + this.precioAccesorios, this.manObra, this.ganancia, this.alto, this.ancho, this.fondo));
//            }
//
//            if (this.tipoVitrina == 1) {
//                //Se agregan a la variable despiece
//                //a el final se añade a la lista
//                //luego cuando le den generar se debe crear un metodo que recorra y valide cual tipo de producto es
//                Despiece despie = new Despiece();
//
//                despie.setNombreProducto(nombreProducto);
//                despie.setCantProducto(this.cantidadProducto);
//                despie.setRecorteFondo(Double.valueOf(this.getFondo()));
//                despie.setCantidadCuartoCirculoAlto(4 * this.cantidadProducto);
//                despie.setCantidadCuartoCirculoAncho(4 * this.cantidadProducto);
//                despie.setCantidadCuartoCirculoFondo(4 * this.cantidadProducto);
//                despie.setCantidadAnguloMediaAlto(6 * this.cantidadProducto);
//                despie.setCantidadAnguloMediaAncho(6 * this.cantidadProducto);
//                despie.setCantidadAnguloMediaFondo(6 * this.cantidadProducto);
//                despie.setCantidadNaveDivisionAncho(2 * this.cantidadProducto);
//                despie.setCantidadVidrio(2 * this.cantidadProducto);
//                despie.setCantidadVidrioEntrepanos(4 * this.cantidadProducto);
//
//                despie.setMensajeCuartoCirculoAlto(despie.getCantidadCuartoCirculoAlto() + " Aluminio CuartoCirculo Alto de:" + (Double.valueOf(this.getAlto()) - 8.0));
//                despie.setMensajeCuartoCirculoAncho(despie.getCantidadCuartoCirculoAncho() + "Alumininio CuartoCirculo Ancho de: " + (Double.valueOf(this.getAncho()) - 8.0));
//                despie.setMensajeCuartoCirculoFondo(despie.getCantidadCuartoCirculoFondo() + "Alumininio CuartoCirculo Fondo de: " + (Double.valueOf(this.getFondo()) - 8.0));
//                despie.setMensajeAnguloMediaAlto(despie.getCantidadAnguloMediaAlto() + "  AnguloMedia Alto de " + (Double.valueOf(this.getAlto()) - 8));
//                despie.setMensajeAnguloMediaAncho(despie.getCantidadAnguloMediaAncho() + " AnguloMedia Ancho de:  " + (Double.valueOf(this.getAncho()) - 10));
//                despie.setMensajeAnguloMediaFondo(despie.getCantidadAnguloMediaFondo() + " AnguloMedia Fondo de:  " + (Double.valueOf(this.getFondo()) - 10));
//                despie.setMensajeNaveDivisionAncho(despie.getCantidadNaveDivisionAncho() + "Nave DivisionBano Ancho de:  " + (Double.valueOf(this.getAncho()) / 2));
//                despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + " recorte ancho  " + (Double.valueOf(this.getAncho()) - 10.5));
//                despie.setMensajeVidrioAltoFondo(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + "Recorte fondo" + (Double.valueOf(this.getFondo()) - 10.5));
//                despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrioEntrepanos() + "  Vidrios de 6mm Ancho " + (Double.valueOf(this.getAncho()) - 1) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 8.5));
//                despie.setNombreProducto(daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                despie.setTipoProducto(9);
//                lstDespiece.add(despie);
//            } else {
//                if (this.tipoVitrina == 2) {
//                    Despiece despie = new Despiece();
//
//                    despie.setNombreProducto(nombreProducto);
//                    despie.setCantProducto(this.cantidadProducto);
//                    despie.setCantidadPerfilEsquineroUnaAncho(4 * this.cantidadProducto);
//                    despie.setCntidadPerfilEsquineroUnaFondo(2 * this.cantidadProducto);
//                    despie.setCantidadAnguloMediaAlto(4 * this.cantidadProducto);
//                    despie.setCantidadAnguloMediaAncho(2 * this.cantidadProducto);
//                    despie.setCantidadAnguloMediaFondo(2 * this.cantidadProducto);
//                    despie.setCantidadNaveDivisionAncho(2 * this.cantidadProducto);
//                    despie.setCantidadNaveAncho(2 * this.cantidadProducto);
//                    despie.setCantidadVidrio(2 * this.cantidadProducto);
//                    despie.setPisaVidrioAlto(6 * this.cantidadProducto);
//                    despie.setPisaVidrioAncho(6 * this.cantidadProducto);
//                    despie.setPisaVidrioFondo(6 * this.cantidadProducto);
//
//                    despie.setMensajePerfilEsquineroUna(despie.getCantidadPerfilEsquineroUnaAncho() + " Perfil o de Una Ancho de: " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajePerfilEsquineroUnaFondo(despie.getCntidadPerfilEsquineroUnaFondo() + " Perfil Esquinero de Una Fondo de: " + (Double.valueOf(this.getFondo())));
//                    despie.setMensajeAnguloMediaAlto(despie.getCantidadAnguloMediaAlto() + "  Tubular 1 * 1 Alto de " + (Double.valueOf(this.getAlto()) - 5));
//                    despie.setMensajeAnguloMediaAncho(despie.getCantidadAnguloMediaAncho() + " Tubular 1 * 1 Ancho de:  " + (Double.valueOf(this.getAncho()) - 5));
//                    despie.setMensajeAnguloMediaFondo(despie.getCantidadAnguloMediaFondo() + " Tubular 1 * 1 Fondo de:  " + (Double.valueOf(this.getFondo()) - 5));
//                    despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Pisavidrio de Media de: " + (Double.valueOf(this.getAlto())));
//                    despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Pisavidrio de Media Alto de: " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajePisavidrioFondo(despie.getPisaVidrioFondo() + " Pisavidrio de Media Ancho de: " + (Double.valueOf(this.getFondo())));
//                    despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + "Nave DivisionBano Ancho Fondo de:  " + (Double.valueOf(this.getAncho()) / 2));
//                    despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + " recorte ancho  " + (Double.valueOf(this.getAncho()) - 10.5));
//                    despie.setMensajeVidrioAltoFondo(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + "Recorte fondo" + (Double.valueOf(this.getFondo()) - 10.5));
//                    despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrio() + "  Vidrios Ancho " + (Double.valueOf(this.getAncho()) - 10.5) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
//                    despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrioEntrepanos() + "  Vidrios de 6mm Ancho " + (Double.valueOf(this.getAncho()) - 1) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
//                    despie.setNombreProducto(daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                    despie.setTipoProducto(10);
//                    lstDespiece.add(despie);
//                } else {
//                    if (this.tipoVitrina == 3) {
//                        Despiece despie = new Despiece();
//
//                        despie.setNombreProducto(nombreProducto);
//                        despie.setCantProducto(this.cantidadProducto);
//                        despie.setCantidadPerfilEsquineroUnaAncho(2 * this.cantidadProducto);
//                        despie.setCntidadPerfilEsquineroUnaFondo(2 * this.cantidadProducto);
//                        despie.setCantidadAnguloMediaAlto(6 * this.cantidadProducto);
//                        despie.setCantidadAnguloMediaAncho(2 * this.cantidadProducto);
//                        despie.setCantidadAnguloMediaFondo(2 * this.cantidadProducto);
//                        despie.setCantidadNaveDivisionAncho(2 * this.cantidadProducto);
//                        despie.setCantidadNaveAncho(2 * this.cantidadProducto);
//                        despie.setCantidadVidrioEntrepanos(4 * this.cantidadProducto);
//                        despie.setCantidadVidrio(2 * this.cantidadProducto);
//                        despie.setPisaVidrioAlto(6 * this.cantidadProducto);
//                        despie.setPisaVidrioAncho(6 * this.cantidadProducto);
//                        despie.setPisaVidrioFondo(6 * this.cantidadProducto);
//
//                        despie.setMensajePerfilEsquineroUna(despie.getCantidadPerfilEsquineroUnaAncho() + " Perfil o de Una Ancho de: " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajePerfilEsquineroUnaFondo(despie.getCntidadPerfilEsquineroUnaFondo() + " Perfil Esquinero de Una Fondo de: " + (Double.valueOf(this.getFondo())));
//                        despie.setMensajeAnguloMediaAlto(despie.getCantidadAnguloMediaAlto() + " AnguloMedia Alto de  " + (Double.valueOf(this.getAlto()) - 8));
//                        despie.setMensajeAnguloMediaAncho(despie.getCantidadAnguloMediaAncho() + " AnguloMedia Ancho de:  " + (Double.valueOf(this.getAncho()) - 10));
//                        despie.setMensajeAnguloMediaFondo(despie.getCantidadAnguloMediaFondo() + " AnguloMedia Fondo de: " + (Double.valueOf(this.getFondo()) - 10));
//                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Pisavidrio de Media de: " + (Double.valueOf(this.getAlto())));
//                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Pisavidrio de Media Alto de: " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajePisavidrioFondo(despie.getPisaVidrioFondo() + " Pisavidrio de Media Ancho de: " + (Double.valueOf(this.getFondo())));
//                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + "Nave DivisionBano Ancho Fondo de:  " + (Double.valueOf(this.getAncho()) / 2));
//                        despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + " recorte ancho  " + (Double.valueOf(this.getAncho()) - 10.5));
//                        despie.setMensajeVidrioAltoFondo(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + "Recorte fondo" + (Double.valueOf(this.getFondo()) - 10.5));
//                        despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrio() + "  Vidrios Ancho " + (Double.valueOf(this.getAncho()) - 10.5) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
//                        despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrioEntrepanos() + "  Vidrios de 6mm Ancho " + (Double.valueOf(this.getAncho()) - 1) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
//                        despie.setNombreProducto(daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                        despie.setTipoProducto(11);
//                        lstDespiece.add(despie);
//                    }
//                }
//            }
//
//            this.transaccion.commit();
//
//            this.idVidrio = 0;
//            this.ganancia = 0;
//            this.alto = "";
//            this.ancho = "";
//            this.manObra = 0;
//            this.tipoVentana = 0;
//            this.tipoVidrio = 0;
//            this.tipoVitrina = 0;
//            this.fondo = "";
//            this.productoTipo = 0;
//        } catch (Exception ex) {
//
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public void calcularPuerta() {
//        this.session = null;
//        this.transaccion = null;
//        Puerta puertas = new Puerta();
//
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//            DaoProductos daoProductos = new DaoProductos();
//
//            DaoMaterial daoMaterial = new DaoMaterial();
//            this.lista.addAll(daoMaterial.getAll(this.session));
//
//            if (this.tipoAluminioPuerta == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
//                return;
//            }
//
//            int idProdPuerta = 0;
//            switch (tipoPuerta) {
//                case 1:
//                    idProdPuerta = 5;
//                    break;
//                case 2:
//                    idProdPuerta = 6;
//                    break;
//                case 3:
//                    idProdPuerta = 8;
//                    break;
//                case 4:
//                    idProdPuerta = 9;
//                    break;
//                case 5:
//                    idProdPuerta = 10;
//                    break;
//            }
//
//            String nombreAluminio = "";
//            switch (tipoAluminioPuerta) {
//                case 1:
//                    nombreAluminio = " Color natural";
//                    break;
//                case 2:
//                    nombreAluminio = " Color Anolo";
//                    break;
//                case 3:
//                    nombreAluminio = " Color ";
//                    break;
//            }
//
//            if (this.tipoAluminioPuerta == 1) {
//                puertas = new Puerta(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(69).getPreciocost(), this.lista.get(68).getPreciocost(),
//                        this.lista.get(70).getPreciocost(), this.lista.get(71).getPreciocost(),
//                        this.lista.get(72).getPreciocost(), this.tipoPuerta,
//                        this.lista.get(73).getPreciocost(), this.lista.get(74).getPreciocost(),
//                        this.lista.get(75).getPreciocost(), this.lista.get(76).getPreciocost());
//
//            } else {
//                if (this.tipoAluminioPuerta == 2) {
//                    puertas = new Puerta(this.ancho, this.alto, this.manObra, this.ganancia,
//                            this.lista.get(93).getPreciocost(), this.lista.get(92).getPreciocost(),
//                            this.lista.get(94).getPreciocost(), this.lista.get(95).getPreciocost(),
//                            this.lista.get(96).getPreciocost(), this.tipoPuerta,
//                            this.lista.get(97).getPreciocost(), this.lista.get(98).getPreciocost(),
//                            this.lista.get(99).getPreciocost(), this.lista.get(76).getPreciocost());
//
//                } else {
//                    if (this.tipoAluminioPuerta == 3) {
//                        puertas = new Puerta(this.ancho, this.alto, this.manObra, this.ganancia,
//                                this.lista.get(101).getPreciocost(), this.lista.get(100).getPreciocost(),
//                                this.lista.get(102).getPreciocost(), this.lista.get(103).getPreciocost(),
//                                this.lista.get(104).getPreciocost(), this.tipoPuerta,
//                                this.lista.get(105).getPreciocost(), this.lista.get(106).getPreciocost(),
//                                this.lista.get(107).getPreciocost(), this.lista.get(76).getPreciocost());
//                    }
//                }
//            }
//
//            if (this.idVidrio != 0) {
//                DaoVidrio daoVidrio = new DaoVidrio();
//
//                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
////                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El precio1 del vidrio es: " + this.precioVidrio));
//
//                this.precioVidrio = this.precioVidrio * (puertas.getAlto() * puertas.getAncho());
//                // this.precioVidrio=this.precioVidrio+(this.precioVidrio*50/100);
//                this.precioVidrio = this.precioVidrio + (this.precioVidrio / 2);
//                int espacios = String.valueOf(this.precioVidrio).length();
//                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
//
//            } else {
//                if (this.idVidrio == 0) {
//                    this.precioVidrio = 0;
//                }
//            }
//            if (this.tipoPuerta == 1 || this.tipoPuerta == 2 || this.tipoPuerta == 3 || this.tipoPuerta == 4) {
//                DaoAccesorios daoAcessorios = new DaoAccesorios();
//                int pibotes = 0;
//                int chapaPuerta = 0;
//                int varrillasTesora = 0;
//                int escuadras = 0;
//
//                pibotes = daoAcessorios.getById(this.session, 11).getPrecioCosto() * 1;
//                chapaPuerta = daoAcessorios.getById(this.session, 10).getPrecioCosto() * 1;
//                varrillasTesora = daoAcessorios.getById(this.session, 12).getPrecioCosto() * 2;
//                escuadras = daoAcessorios.getById(this.session, 13).getPrecioCosto() * 12;
//
//                this.precioAccesorios = pibotes + chapaPuerta + varrillasTesora + escuadras;
//
//            } else {
//                if (this.tipoPuerta == 5) {
//                    DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                    int bisagras = 0;
//                    int chapaPuerta = 0;
//                    int varrillasTesora = 0;
//                    int escuadras = 0;
//
//                    bisagras = daoAcessorios.getById(this.session, 14).getPrecioCosto() * 2;
//                    chapaPuerta = daoAcessorios.getById(this.session, 10).getPrecioCosto() * 1;
//                    varrillasTesora = daoAcessorios.getById(this.session, 12).getPrecioCosto() * 2;
//                    escuadras = daoAcessorios.getById(this.session, 13).getPrecioCosto() * 12;
//
//                    this.precioAccesorios = bisagras + chapaPuerta + varrillasTesora + escuadras;
//                }
//
//            }
//            if (this.tipoPuerta < 6 && this.tipoPuerta > 0) {
//
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idProdPuerta),
//                        daoProductos.getById(this.session, idProdPuerta).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, puertas.getSumaTotal() + this.precioVidrio + this.precioAccesorios, this.cantidadProducto * puertas.getSumaTotal()
//                        + this.precioVidrio + this.precioAccesorios, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//
//            if (tipoPuerta == 1) {
//                Despiece despie = new Despiece();
//
//                despie.setNombreProducto(nombreProducto);
//                despie.setCantProducto(this.cantidadProducto);
//                despie.setCantidadMarcoAncho(1 * this.cantidadProducto);// 1 es la cantidad
//                despie.setCantidadMarcoAlto(2 * this.cantidadProducto);
//                despie.setCantidadNaveAlto(2 * this.cantidadProducto);
//                despie.setCantidadNaveAncho(2 * this.cantidadProducto);
//                despie.setCantidadPartidor(1 * this.cantidadProducto);
//                despie.setCantidadPibotes(1 * this.cantidadProducto);
//                despie.setCantidadChapa(1 * this.cantidadProducto);
//                despie.setCantidadVarillasTensoras(2 * this.cantidadProducto);
//                despie.setCantidadEscuadras(12 * this.cantidadProducto);
//                despie.setCantidadPisaVidriosAlto(8 * this.cantidadProducto);
//                despie.setCantidadPisaVidriosAncho(8 * this.cantidadProducto);
//                despie.setCantidadVidrio(2 * this.cantidadProducto);
//
//                despie.setMensajeAluminio3Alto(despie.getCantidadMarcoAlto() + " Recorte Aluminio 3 media Alto de:" + (Double.valueOf(this.getAlto())));
//                despie.setMensajeAluminio3Ancho(despie.getCantidadMarcoAncho() + " Recorte Alumininio 3 media Ancho de: " + (Double.valueOf(this.getAncho())));
//                despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte  AluminiT87 Alto de " + (Double.valueOf(this.getAlto()) - 5.0));
//                despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte AluminioT87 Ancho de:  " + (Double.valueOf(this.getAncho()) - 8.0));
//                despie.setMensajePisaVidriosAncho(despie.getCantidadPisaVidriosAncho() + " Recorte PisaVidrios Ancho de:  " + (Double.valueOf(this.getAncho()) - 15.6));
//                despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte PisaVidrios Alto de:  " + (Double.valueOf(this.getAlto()) - 19.2));
//                despie.setMensajePartidor(despie.getCantidadPartidor() + " Recorte Partidor de:  " + (Double.valueOf(this.getAncho()) - 15.6));
//                despie.setMensajePibotes(despie.getCantidadPibotes() + " Cantidad Pibotes Americanos .");
//                despie.setMensajeChapa(despie.getCantidadChapa() + " Cantidad Chapa .");
//                despie.setMensajeEscuadras1(despie.getCantidadEscuadras() + "Cantidad Escudras .");
//                despie.setMensajeVarillasTensoras(despie.getCantidadVarillasTensoras() + " Cantidad Varillas Tensoras .");
//                despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + " Recorte  Vidrio Alto de: " + (Double.valueOf(this.getAlto()) / 2 - 19.7) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 16.1));
//                despie.setNombreProducto(daoProductos.getById(this.session, idProdPuerta).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                despie.setTipoProducto(1);
//
//                lstDespiece.add(despie);
//            } else {
//                if (this.tipoPuerta == 2) {
//                    //Se agregan a la variable despiece
//                    //a el final se añade a la lista
//                    //luego cuando le den generar se debe crear un metodo que recorra y valide cual tipo de producto es
//                    Despiece despie = new Despiece();
//
//                    despie.setNombreProducto(nombreProducto);
//                    despie.setCantProducto(this.cantidadProducto);
//                    despie.setCantidadMarcoAncho(1 * this.cantidadProducto);// 1 es la cantidad
//                    despie.setCantidadMarcoAlto(2 * this.cantidadProducto);
//                    despie.setCantidadNaveAlto(2 * this.cantidadProducto);
//                    despie.setCantidadNaveAncho(2 * this.cantidadProducto);
////                    despie.setCantidadPerfilU71(this.despie.getCantidadPerfilU71() = Double.valueOf(this.getAncho()) / 7 * 1);
//
//                    despie.setCantidadPibotes(1 * this.cantidadProducto);
//                    despie.setCantidadChapa(1 * this.cantidadProducto);
//                    despie.setCantidadVarillasTensoras(2 * this.cantidadProducto);
//                    despie.setCantidadEscuadras(12 * this.cantidadProducto);
//                    despie.setCantidadPartidor(1 * this.cantidadProducto);
//                    despie.setCantidadPisaVidriosAlto(4 * this.cantidadProducto);
//                    despie.setCantidadPisaVidriosAncho(4 * this.cantidadProducto);
//
//                    despie.setMensajeAluminio3Alto(despie.getCantidadMarcoAlto() + " Recorte Aluminio 3 media Alto de:" + (Double.valueOf(this.getAlto())));
//                    despie.setMensajeAluminio3Ancho(despie.getCantidadMarcoAncho() + " Recorte Alumininio 3 media Ancho de: " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + "  Recorte AluminiT103 Alto de " + (Double.valueOf(this.getAlto()) - 5.0));
//                    despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte AluminioT103 Ancho de:  " + (Double.valueOf(this.getAncho()) - 8.0));
//                    despie.setMensajePerfilU71(despie.getCantidadPerfilU71() + " Recorte pefil U71 Alto de:  " + (Double.valueOf(this.getAlto()) - 20.2));
//                    despie.setMensajePibotes(despie.getCantidadPibotes() + " Cantidad Pibotes Americanos .");
//                    despie.setMensajeChapa(despie.getCantidadChapa() + " Cantidad Chapa .");
//                    despie.setMensajeEscuadras1(despie.getCantidadEscuadras() + " Cantidad Escudras .");
//                    despie.setMensajeVarillasTensoras(despie.getCantidadVarillasTensoras() + " Cantidad Varillas Tensoras .");
//                    despie.setTipoProducto(2);
//
//                    lstDespiece.add(despie);
//                } else {
//                    if (this.tipoPuerta == 3) {
//                        //Se agregan a la variable despiece
//                        //a el final se añade a la lista
//                        //luego cuando le den generar se debe crear un metodo que recorra y valide cual tipo de producto es
//                        Despiece despie = new Despiece();
//
//                        despie.setNombreProducto(nombreProducto);
//                        despie.setCantProducto(this.cantidadProducto);
//                        despie.setCantidadMarcoAncho(1 * this.cantidadProducto);// 1 es la cantidad
//                        despie.setCantidadMarcoAlto(2 * this.cantidadProducto);
//                        despie.setCantidadNaveAlto(2 * this.cantidadProducto);
//                        despie.setCantidadNaveAncho(2 * this.cantidadProducto);
//                        despie.setCantidadPibotes(1 * this.cantidadProducto);
//                        despie.setCantidadChapa(1 * this.cantidadProducto);
//                        despie.setCantidadVarillasTensoras(2 * this.cantidadProducto);
//                        despie.setCantidadEscuadras(12 * this.cantidadProducto);
//                        despie.setCantidadEntamboradoF06(Integer.valueOf(this.getAncho()) / 7 * this.cantidadProducto);
//                        despie.setCantidadVidrio(2 * this.cantidadProducto);
//
//                        despie.setMensajeAluminio3Alto(despie.getCantidadMarcoAlto() + " Recorte Aluminio 3 media Alto de:" + (Double.valueOf(this.getAlto())));
//                        despie.setMensajeAluminio3Ancho(despie.getCantidadMarcoAncho() + " Recorte Alumininio 3 media Ancho de: " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + "  Recorte AluminiT87 Alto de " + (Double.valueOf(this.getAlto()) - 3.0));
//                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte AluminioT87 Ancho de:  " + (Double.valueOf(this.getAncho()) - 2.0));
//                        despie.setMensajePisaVidriosAncho(despie.getCantidadPisaVidriosAncho() + "  Recorte PisaVidrios Ancho de:  " + (Double.valueOf(this.getAncho()) - 4.5));
//                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte PisaVidrios Alto de:  " + (Double.valueOf(this.getAlto()) - 5.0));
//                        despie.setMensageEntamboradoF06(despie.getCantidadEntamboradoF06() + " Recorte Emtamborado F06" + (Double.valueOf(this.getAlto()) - 12.6));
//                        despie.setMensajePibotes(despie.getCantidadPibotes() + " Cantidad Pibotes Americanos .");
//                        despie.setMensajeChapa(despie.getCantidadChapa() + " Cantidad Chapa .");
//                        despie.setMensajeEscuadras1(despie.getCantidadEscuadras() + " Cantidad Escudras .");
//                        despie.setMensajeVarillasTensoras(despie.getCantidadVarillasTensoras() + "Cantidad Varillas Tensoras .");
//                        despie.setTipoProducto(3);
//
//                        lstDespiece.add(despie);
//                    } else {
//                        if (this.tipoVentana == 4) {
//                            //Se agregan a la variable despiece
//                            //a el final se añade a la lista
//                            //luego cuando le den generar se debe crear un metodo que recorra y valide cual tipo de producto es
//                            Despiece despie = new Despiece();
//
//                            despie.setNombreProducto(nombreProducto);
//                            despie.setCantProducto(this.cantidadProducto);
//                            despie.setCantidadMarcoAncho(1 * this.cantidadProducto);// 1 es la cantidad
//                            despie.setCantidadMarcoAlto(2 * this.cantidadProducto);
//                            despie.setCantidadNaveAlto(2 * this.cantidadProducto);
//                            despie.setCantidadNaveAncho(2 * this.cantidadProducto);
//                            despie.setCantidadPisaVidriosAlto(4 * this.cantidadProducto);
//                            despie.setCantidadPisaVidriosAncho(8 * this.cantidadProducto);
//                            despie.setCantidadPartidor(1 * this.cantidadProducto);
//                            despie.setCantidadPibotes(1 * this.cantidadProducto);
//                            despie.setCantidadChapa(1 * this.cantidadProducto);
//                            despie.setCantidadVarillasTensoras(2 * this.cantidadProducto);
//                            despie.setCantidadEscuadras(12 * this.cantidadProducto);
//                            despie.setCantidadVidrio(2 * this.cantidadProducto);
//
//                            despie.setMensajeAluminio3Alto(despie.getCantidadMarcoAlto() + " Recorte Aluminio 3 media Alto de:" + (Double.valueOf(this.getAlto())));
//                            despie.setMensajeAluminio3Ancho(despie.getCantidadMarcoAncho() + " Recorte Alumininio 3 media Ancho de: " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte  AluminiT103  Alto de " + (Double.valueOf(this.getAlto()) - 5.0));
//                            despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte AluminioT103 de:  " + (Double.valueOf(this.getAncho()) - 8.0));
//                            despie.setMensajePartidor(despie.getCantidadPartidor() + " Recorte Partidor Aluminio T103 de: " + (Double.valueOf(this.getAncho()) - 23.6));
//                            despie.setMensajePisaVidriosAncho(despie.getCantidadPisaVidriosAncho() + "  Recorte PisaVidrios Ancho de:  " + (Double.valueOf(this.getAncho()) - 23.6));
//                            despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte PisaVidrios Alto de:  " + (Double.valueOf(this.getAlto()) - 20.6));
//                            despie.setMensajePibotes(despie.getCantidadPibotes() + "  Cantidad Pibotes Americanos .");
//                            despie.setMensajeChapa(despie.getCantidadChapa() + " Cantidad Chapa .");
//                            despie.setMensajeEscuadras1(despie.getCantidadEscuadras() + " Cantidad Escudras .");
//                            despie.setMensajeVarillasTensoras(despie.getCantidadVarillasTensoras() + " Cantidad Varillas Tensoras .");
//
////                            this.recorteVidrioAncho = Integer.valueOf(this.getAncho()) - 24.1;
////                            this.recorteVidrioAlto = Integer.valueOf(this.getAlto()) - 21.1;
////                            this.recorteVidrioAlto = Integer.valueOf(this.getAlto()) / 2;
//                            despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + " Recorte  Vidrio Alto de: " + (Double.valueOf(this.getAlto()) / 2 - 19.7) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 16.1));
//                            despie.setNombreProducto(daoProductos.getById(this.session, idProdPuerta).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//
//                            despie.setTipoProducto(4);
//
//                            lstDespiece.add(despie);
//
//                        } else {
//                            if (this.tipoPuerta == 5) {
//                                //Se agregan a la variable despiece
//                                //a el final se añade a la lista
//                                //luego cuando le den generar se debe crear un metodo que recorra y valide cual tipo de producto es
//                                Despiece despie = new Despiece();
//
//                                despie.setNombreProducto(nombreProducto);
//                                despie.setCantProducto(this.cantidadProducto);
//                                despie.setCantidadMarcoAncho(1 * this.cantidadProducto);// 1 es la cantidad
//                                despie.setCantidadMarcoAlto(2 * this.cantidadProducto);
//                                despie.setCantidadNaveAlto(2 * this.cantidadProducto);
//                                despie.setCantidadNaveAncho(2 * this.cantidadProducto);
//                                despie.setCantidadPisaVidriosAlto(4 * this.cantidadProducto);
//                                despie.setCantidadPisaVidriosAncho(8 * this.cantidadProducto);
//                                despie.setCantidadPartidor(1 * this.cantidadProducto);
//                                despie.setVisagras(2 * this.cantidadProducto);
//                                despie.setCantidadChapa(1 * this.cantidadProducto);
//                                despie.setCantidadVarillasTensoras(2 * this.cantidadProducto);
//                                despie.setCantidadEscuadras(12 * this.cantidadProducto);
//                                despie.setCantidadVidrio(2 * this.cantidadProducto);
//
//                                despie.setMensajeAluminio3Alto(despie.getCantidadMarcoAlto() + " Recorte Aluminio 3 media Alto de:" + (Double.valueOf(this.getAlto())));
//                                despie.setMensajeAluminio3Ancho(despie.getCantidadMarcoAncho() + " Recorte Alumininio 3 media Ancho de: " + (Double.valueOf(this.getAncho())));
//                                despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + "  Recorte AluminioT103  Alto de " + (Double.valueOf(this.getAlto()) - 5.0));
//                                despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte AluminioT103  Ancho de:  " + (Double.valueOf(this.getAncho()) - 8.0));
//                                despie.setMensajePartidor(despie.getCantidadPartidor() + " Recorte Partidor Aluminio T103 Ancho de: " + (Double.valueOf(this.getAncho()) - 23.6));
//                                despie.setMensajePisaVidriosAncho(despie.getCantidadPisaVidriosAncho() + " Recorte PisaVidrios Ancho de:  " + (Double.valueOf(this.getAncho()) - 23.6));
//                                despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte PisaVidrios Alto de:  " + (Double.valueOf(this.getAlto()) - 20.6));
//                                despie.setMensajeVisagras(despie.getVisagras() + " Cantidad Visagras .");
//                                despie.setMensajeChapa(despie.getCantidadChapa() + " Cantidad Chapa .");
//                                despie.setMensajeEscuadras1(despie.getCantidadEscuadras() + " Cantidad Escudras .");
//                                despie.setMensajeVarillasTensoras(despie.getCantidadVarillasTensoras() + "Cantidad Varillas Tensoras .");
////                                this.recorteVidrioAncho = Integer.valueOf(this.getAncho()) - 24.1;
////                                this.recorteVidrioAlto = Integer.valueOf(this.getAlto()) - 21.1;
////                                this.recorteVidrioAlto = Integer.valueOf(this.getAlto()) / 2;
//                                despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + " Recorte  Vidrio Alto de: " + (Double.valueOf(this.getAlto()) / 2 - 21.1) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 24.1));
//                                despie.setNombreProducto(daoProductos.getById(this.session, idProdPuerta).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//
//                                despie.setTipoProducto(5);
//
//                                lstDespiece.add(despie);
//
//                            }
//                        }
//
//                    }
//                }
//            }
//
//            this.transaccion.commit();
//            this.idVidrio = 0;
//            this.ganancia = 0;
//            this.alto = "";
//            this.ancho = "";
//            this.manObra = 0;
//            this.tipoVidrio = 0;
//            this.tipoVitrina = 0;
//            this.fondo = "";
//            this.productoTipo = 0;
//            this.tipoAluminioPuerta = 0;
//
//        } catch (Exception ex) {
//
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//
//    }
//
//    public void calcularVentanaCorrediza() {
//        this.session = null;
//        this.transaccion = null;
//
//        VentanaCorredera ventanaCorredera = new VentanaCorredera();
//        try {
//
//            if (this.alto.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));
//                return;
//            }
//
//            if (this.ancho.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));
//                return;
//            }
//
//            if (this.alto.length() > 3 || this.ancho.length() > 3) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));
//                return;
//            }
//
//            if (String.valueOf(this.manObra).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));
//                return;
//            }
//
//            if (String.valueOf(this.ganancia).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));
//                return;
//            }
//
//            if (this.tipoVentana == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto."));
//                return;
//            }
//
//            try {
//                int o = Integer.valueOf(this.alto);
//                int p = Integer.valueOf(this.ancho);
//                int m = this.manObra;
//                int t = this.ganancia;
//            } catch (NumberFormatException nfe) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
//            }
//
//            DaoMaterial daoMaterial = new DaoMaterial();
//            DaoProductos daoProductos = new DaoProductos();
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            this.lista.addAll(daoMaterial.getAll(this.session));
//
//            if (this.tipoAluminio == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
//                return;
//            }
//
//               int idVentana = 0;
//            switch (tipoVentana) {
//                case 1:
//                    idVentana = 1;
//                    break;
//                case 2:
//                    idVentana = 2;
//                    break;
//                case 3:
//                    idVentana = 3;
//                    break;
//                      case 4:
//                    idVentana = 5;
//                    break;
//                            case 5:
//                    idVentana = 5;
//                    break;
//
//            }
//        
//
////         
////            String dosNaves = "";
////            switch (tipoNaves) {
////                case 1:
////                    dosNaves = "Movil Fija basica X0";
////                    break;
////                case 2:
////                    dosNaves = "Movil Movil Basica X0";
////                    break;
////            }
////            String tresNaves = "";
////            switch (tipo3Naves) {
////                case 1:
////                    tresNaves = "Fijol Movil Fijo X0X";
////                    break;
////                case 2:
////                    tresNaves = "Fijo Movil Fijo 0X0";
////                    break;
////                case 3:
////                    tresNaves = "Fijo Movil Movil 0XX";
////                    break;
////                case 4:
////                    tresNaves = " Movil Fijo sobre Fijo X0/0";
////                    break;
////            }
////
////            String cuatroNaves = "";
////            switch (tipo4Naves) {
////                case 1:
////                    cuatroNaves = "Fijo Movil Movil Fijo 0XXO";
////                    break;
////                case 2:
////                    cuatroNaves = "Movil Fijo sobre Fijo Fijo ALF";
////                    break;
////            }
////            String cincoNaves = "";
////            switch (tipo5Naves) {
////                case 1:
////                    cincoNaves = "Fijo Movil Movil Movil Movil Fijo 0XXXXO";
////                    break;
////                case 2:
////                    cincoNaves = "Fijo Movil Fijo sobre Fijo Fijo fijo ALF";
////                    break;
////            }
//            
//              String nombreAluminio = "";
//            switch (tipoAluminio) {
//                case 1:
//                    nombreAluminio = " Aluminio 744";
//                    break;
//                case 2:
//                    nombreAluminio = " Aluminio 5020";
//                    break;
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
//            }
//
//            switch (tipoColor) {
//                case 1:
//                    nombreAluminio += " Natural";
//                    break;
//                case 2:
//                    nombreAluminio += " Anolo";
//                    break;
//                case 3:
//                    nombreAluminio += " Colores";
//                    break;
//            }
//
//      // este caso es para los modelos de las ventanas   este es para una ventana de dos cuerpos 
//                            // movil movil  sobre fijo fijo X0/00 con su tipo de aluminio y color  // ventana 2 de la clase ventana cooredera
//
//    
//                    switch (this.tipoAluminio) {
//                        case 1: // estos constructores es para ventanas corredizas de aluminio 744 y con sus distintos colores
//                           switch (tipoColor) { 
//                                case 1:
//                                ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//                                case 2:
//                                  ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//                                    break;
//                                case 3:
//                            ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPreciocost(), this.lista.get(250).getPreciocost(),
//                                                    this.lista.get(230).getPreciocost(), this.lista.get(234).getPreciocost(),
//                                                    this.lista.get(236).getPreciocost(), this.lista.get(295).getPreciocost(),
//                                                    this.lista.get(231).getPreciocost(), this.lista.get(241).getPreciocost(),
//                                                    this.lista.get(235).getPreciocost(), this.lista.get(247).getPreciocost(),
//                                                    this.lista.get(218).getPreciocost(), this.lista.get(242).getPreciocost(),
//                                                    this.lista.get(220).getPreciocost(), this.lista.get(0).getPreciocost(),
//                                                    this.lista.get(0).getPreciocost(), this.lista.get(0).getPreciocost(),
//                                                    this.lista.get(246).getPreciocost(), this.lista.get(248).getPreciocost(),
//                                                    this.lista.get(249).getPreciocost(), this.lista.get(285).getPreciocost(),
//                                                    this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                        case 2:// este constructoer es para ventanas corredizas de aluminio 5020 y con sus distintos colores
//                            switch (tipoColor) { 
//                                case 1:
//                                ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPreciocost(), this.lista.get(250).getPreciocost(),
//                                                    this.lista.get(230).getPreciocost(), this.lista.get(234).getPreciocost(),
//                                                    this.lista.get(236).getPreciocost(), this.lista.get(295).getPreciocost(),
//                                                    this.lista.get(231).getPreciocost(), this.lista.get(241).getPreciocost(),
//                                                    this.lista.get(235).getPreciocost(), this.lista.get(247).getPreciocost(),
//                                                    this.lista.get(218).getPreciocost(), this.lista.get(242).getPreciocost(),
//                                                    this.lista.get(220).getPreciocost(), this.lista.get(0).getPreciocost(),
//                                                    this.lista.get(0).getPreciocost(), this.lista.get(0).getPreciocost(),
//                                                    this.lista.get(246).getPreciocost(), this.lista.get(248).getPreciocost(),
//                                                    this.lista.get(249).getPreciocost(), this.lista.get(285).getPreciocost(),
//                                                    this.tipoVentana);
//                                    break;
//                                case 2:
//                             ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//                                    break;
//                                case 3:
//                              ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                        case 3: // este constructoer es para ventanas corredizas de aluminio 8025 y con sus distintos colores
//                            switch (tipoColor) {
//                                case 1:
//                                  ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//
//                                    break;
//                                case 2:
//                                     ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//                                    break;
//                                case 3:
//                                      ventanaCorredera = new VentanaCorredera(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(232).getPrecioAnonizado(), this.lista.get(250).getPrecioAnonizado(),
//                                                    this.lista.get(230).getPrecioAnonizado(), this.lista.get(234).getPrecioAnonizado(),
//                                                    this.lista.get(236).getPrecioAnonizado(), this.lista.get(295).getPrecioAnonizado(),
//                                                    this.lista.get(231).getPrecioAnonizado(), this.lista.get(241).getPrecioAnonizado(),
//                                                    this.lista.get(235).getPrecioAnonizado(), this.lista.get(247).getPrecioAnonizado(),
//                                                    this.lista.get(218).getPrecioAnonizado(), this.lista.get(242).getPrecioAnonizado(),
//                                                    this.lista.get(220).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(0).getPrecioAnonizado(), this.lista.get(0).getPrecioAnonizado(),
//                                                    this.lista.get(246).getPrecioAnonizado(), this.lista.get(248).getPrecioAnonizado(),
//                                                    this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado(),
//                                                    this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                    }
//
//
//           
//        
//            if (this.idVidrio != 0) {
//                DaoVidrio daoVidrio = new DaoVidrio();
//
//                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
//                this.precioVidrio = this.precioVidrio * (ventanaCorredera.getAlto() * ventanaCorredera.getAncho());
//                int espacios = String.valueOf(this.precioVidrio).length();
//                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
//            }
//            if (this.idVidrio == 0) {
//                this.precioVidrio = 0;
//            }
//
//            if (this.tipoVentana == 1) {
//                DaoAccesorios daoAcessorios = new DaoAccesorios();
//                int rodamientos = 0;
//                int chapaVentana = 0;
//                int guias = 0;
//
//                rodamientos = daoAcessorios.getById(this.session, 1).getPrecioCosto() * 2;
//                chapaVentana = daoAcessorios.getById(this.session, 7).getPrecioCosto() * 1;
//                guias = daoAcessorios.getById(this.session, 19).getPrecioCosto() * 8;
//
//                this.precioAccesorios = rodamientos + chapaVentana + guias;
//
//            } else {
//                if (this.tipoVentana == 2 || this.tipoVentana == 3) {
//                    DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                    int rodamientos = 0;
//                    int chapaVentana = 0;
//                    int guias = 0;
//
//                    rodamientos = daoAcessorios.getById(this.session, 1).getPrecioCosto() * 4;
//                    chapaVentana = daoAcessorios.getById(this.session, 7).getPrecioCosto() * 2;
//                    guias = daoAcessorios.getById(this.session, 19).getPrecioCosto() * 8;
//
//                    this.precioAccesorios = rodamientos + chapaVentana + guias;
//                }
//
//            }
//            if (this.tipoVentana < 4 && this.tipoVentana > 0) {
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idVentana),
//                        daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, ventanaCorredera.getSumaTotal() + this.precioVidrio + this.precioAccesorios, this.cantidadProducto * ventanaCorredera.getSumaTotal()
//                        + this.precioVidrio + this.precioAccesorios, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//            if (this.tipoProductos == 4) {
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, this.tipoVentana),
//                        daoProductos.getById(this.session, this.tipoVentana).getNombre() + " " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, this.precioVidrio + this.manObra, this.cantidadProducto * this.precioVidrio, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//
//            if (this.tipoVentana == 1) {
//                if (this.tipoAluminio == 1 || this.tipoAluminio == 4 || this.tipoAluminio == 7) {
//                    Despiece despie = new Despiece();
//
//                    despie.setNombreProducto(nombreProducto);
//                    despie.setCantProducto(this.cantidadProducto);
//                    despie.setCantidadCabezal(1 * this.cantidadProducto);
//                    despie.setCantidadSillar(1 * this.cantidadProducto);
//                    despie.setCantidadJamba(2 * this.cantidadProducto);
//                    despie.setCantidadEnganche(2 * this.cantidadProducto);
//                    despie.setCantidadEnganche(2 * this.cantidadProducto);
//                    despie.setCantidadTraslape(2 * this.cantidadProducto);
//                    despie.setCantidadTraslape(2 * this.cantidadProducto);
//                    despie.setCantidadHorizontalesSuperior(2 * this.cantidadProducto);
//                    despie.setCantidadHorizontalesInferior(2 * this.cantidadProducto);
//                    despie.setCantidadVidrio(2 * this.cantidadProducto);
//                    despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeSillar(despie.getCantidadSillar() + "  RecorteSillar de: " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                    despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganchez de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                    despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte traslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                    despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                    despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                    despie.setTipoProducto(6);
//
//                    lstDespiece.add(despie);
//                }
//            } else {
//                if (this.tipoVentana == 2) {
//                    if (this.tipoAluminio == 2 || this.tipoAluminio == 5 || this.tipoAluminio == 8) {
//                        Despiece despie = new Despiece();
//
//                        despie.setNombreProducto(nombreProducto);
//                        despie.setCantProducto(this.cantidadProducto);
//                        despie.setCantidadCabezal(1 * this.cantidadProducto);
//                        despie.setCantidadSillar(1 * this.cantidadProducto);
//                        despie.setCantidadJamba(2 * this.cantidadProducto);
//                        despie.setCantidadEnganche(2 * this.cantidadProducto);
//                        despie.setCantidadTraslape(4 * this.cantidadProducto);
//                        despie.setCantidadHorizontalesSuperior(3 * this.cantidadProducto);
//                        despie.setCantidadHorizontalesInferior(3 * this.cantidadProducto);
//                        despie.setMensajeCabezal(despie.getCantidadCabezal() + "Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeSillar(despie.getCantidadSillar() + " Recorte Sillar de: " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganches de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recortetraslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() - 1 + "Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Superior de: " + (Double.valueOf(this.getAncho()))));
//                        despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() - 1 + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Inferior de: " + (Double.valueOf(this.getAncho()))));
//                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                        despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                        despie.setTipoProducto(7);
//
//                        lstDespiece.add(despie);
//                    } else {
//                        if (this.tipoAluminio == 3 || this.tipoAluminio == 6 || this.tipoAluminio == 9) {
//                            Despiece despie = new Despiece();
//
//                            despie.setNombreProducto(nombreProducto);
//                            despie.setCantProducto(this.cantidadProducto);
//                            despie.setCantidadCabezal(1 * this.cantidadProducto);
//                            despie.setCantidadSillar(1 * this.cantidadProducto);
//                            despie.setCantidadJamba(2 * this.cantidadProducto);
//                            despie.setCantidadEnganche(4 * this.cantidadProducto);
//                            despie.setCantidadTraslape(4 * this.cantidadProducto);
//                            despie.setCantidadHorizontalesSuperior(4 * this.cantidadProducto);
//                            despie.setCantidadHorizontalesInferior(4 * this.cantidadProducto);
//                            despie.setCantidadAdactador(1 * this.cantidadProducto);
//                            despie.setMensajeCabezal(despie.getCantidadCabezal() + "Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeSillar(despie.getCantidadSillar() + " Recorte Sillar de: " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                            despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganches de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recortetraslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeAdactador(despie.getCantidadAdactador() + " Adaptador de: " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() - 1 + "Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Superior de: " + (Double.valueOf(this.getAncho()))));
//                            despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() - 1 + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Inferior de: " + (Double.valueOf(this.getAncho()))));
//                            despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                            despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                            despie.setTipoProducto(8);
//
//                            lstDespiece.add(despie);
//                        }
//                    }
//                }
//            }
//
//            this.transaccion.commit();
//            this.idVidrio = 0;
//            this.ganancia = 0;
//            this.alto = "";
//            this.ancho = "";
//            this.manObra = 0;
//            this.tipoVentana = 0;
//            this.tipoVidrio = 0;
//            this.productoTipo = 0;
//
//        } catch (Exception ex) {
//
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//
//    }
//
//    public void calcularVentanaAbatible() {
//        this.session = null;
//        this.transaccion = null;
//
//        VentanaAbatible ventanaAbatible = new VentanaAbatible();
//        try {
//
//            if (this.alto.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));
//                return;
//            }
//
//            if (this.ancho.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));
//                return;
//            }
//
//            if (this.alto.length() > 3 || this.ancho.length() > 3) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));
//                return;
//            }
//
//            if (String.valueOf(this.manObra).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));
//                return;
//            }
//
//            if (String.valueOf(this.ganancia).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));
//                return;
//            }
//
//            if (this.tipoVentana == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto."));
//                return;
//            }
//
//            try {
//                int o = Integer.valueOf(this.alto);
//                int p = Integer.valueOf(this.ancho);
//                int m = this.manObra;
//                int t = this.ganancia;
//            } catch (NumberFormatException nfe) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
//            }
//
//            DaoMaterial daoMaterial = new DaoMaterial();
//            DaoProductos daoProductos = new DaoProductos();
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            this.lista.addAll(daoMaterial.getAll(this.session));
//
//            if (this.tipoAluminio == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
//                return;
//            }
//
//                     int idVentana = 0;
//            switch (tipoVentana) {
//                case 1:
//                    idVentana = 1;
//                    break;
//                case 2:
//                    idVentana = 2;
//                    break;
//                case 3:
//                    idVentana = 3;
//                    break;
//                      case 4:
//                    idVentana = 5;
//                    break;
//                            case 5:
//                    idVentana = 5;
//                    break;
//
//            }
//        
//
////         
////            String dosNaves = "";
////            switch (tipoNaves) {
////                case 1:
////                    dosNaves = "Movil Fija basica X0";
////                    break;
////                case 2:
////                    dosNaves = "Movil Movil Basica X0";
////                    break;
////            }
////            String tresNaves = "";
////            switch (tipo3Naves) {
////                case 1:
////                    tresNaves = "Fijol Movil Fijo X0X";
////                    break;
////                case 2:
////                    tresNaves = "Fijo Movil Fijo 0X0";
////                    break;
////                case 3:
////                    tresNaves = "Fijo Movil Movil 0XX";
////                    break;
////                case 4:
////                    tresNaves = " Movil Fijo sobre Fijo X0/0";
////                    break;
////            }
////
////            String cuatroNaves = "";
////            switch (tipo4Naves) {
////                case 1:
////                    cuatroNaves = "Fijo Movil Movil Fijo 0XXO";
////                    break;
////                case 2:
////                    cuatroNaves = "Movil Fijo sobre Fijo Fijo ALF";
////                    break;
////            }
////            String cincoNaves = "";
////            switch (tipo5Naves) {
////                case 1:
////                    cincoNaves = "Fijo Movil Movil Movil Movil Fijo 0XXXXO";
////                    break;
////                case 2:
////                    cincoNaves = "Fijo Movil Fijo sobre Fijo Fijo fijo ALF";
////                    break;
////            }
//            
//              String nombreAluminio = "";
//            switch (tipoAluminio) {
//                case 1:
//                    nombreAluminio = " Aluminio 744";
//                    break;
//                case 2:
//                    nombreAluminio = " Aluminio 5020";
//                    break;
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
//            }
//
//            switch (tipoColor) {
//                case 1:
//                    nombreAluminio += " Natural";
//                    break;
//                case 2:
//                    nombreAluminio += " Anolo";
//                    break;
//                case 3:
//                    nombreAluminio += " Colores";
//                    break;
//            }
//
//      // este caso es para los modelos de las ventanas   este es para una ventana de dos cuerpos 
//                            // movil movil  sobre fijo fijo X0/00 con su tipo de aluminio y color  // ventana 2 de la clase ventana cooredera
//
//    
//                    switch (this.tipoAluminio) {
//                        case 1: // estos constructores es para ventanas corredizas de aluminio 744 y con sus distintos colores
//                           switch (tipoColor) { 
//                                case 1:
//                                      ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(0).getPreciocost(), this.lista.get(56).getPreciocost(),
//                                                    this.lista.get(59).getPreciocost(), this.lista.get(2).getPreciocost(),
//                                                    this.lista.get(79).getPreciocost(), this.lista.get(82).getPreciocost(),
//                                                    this.lista.get(4).getPreciocost(), this.lista.get(85).getPreciocost(),
//                                                    this.lista.get(47).getPreciocost(), this.lista.get(76).getPreciocost(),
//                                                    this.lista.get(8).getPreciocost(), this.lista.get(7).getPreciocost(),
//                                                    this.lista.get(66).getPreciocost(), this.tipoVentana);
//                                case 2:
//                                    ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                   this.lista.get(0).getPrecioAnonizado(), this.lista.get(56).getPrecioAnonizado(),
//                                                    this.lista.get(59).getPrecioAnonizado(), this.lista.get(2).getPrecioAnonizado(),
//                                                    this.lista.get(79).getPrecioAnonizado(), this.lista.get(82).getPrecioAnonizado(),
//                                                    this.lista.get(4).getPrecioAnonizado(), this.lista.get(85).getPrecioAnonizado(),
//                                                    this.lista.get(47).getPrecioAnonizado(), this.lista.get(76).getPrecioAnonizado(),
//                                                    this.lista.get(8).getPrecioAnonizado(), this.lista.get(7).getPrecioAnonizado(),
//                                                    this.lista.get(66).getPrecioAnonizado(), this.tipoVentana);
//                                    break;
//                                case 3:
//                                    ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                this.lista.get(0).getPrecioPintura(), this.lista.get(56).getPrecioPintura(),
//                                                    this.lista.get(59).getPrecioPintura(), this.lista.get(2).getPrecioPintura(),
//                                                    this.lista.get(79).getPrecioPintura(), this.lista.get(82).getPrecioPintura(),
//                                                    this.lista.get(4).getPrecioPintura(), this.lista.get(85).getPrecioPintura(),
//                                                    this.lista.get(47).getPrecioPintura(), this.lista.get(76).getPrecioPintura(),
//                                                    this.lista.get(8).getPrecioPintura(), this.lista.get(7).getPrecioPintura(),
//                                                    this.lista.get(66).getPrecioPintura(), this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                        case 2:// este constructoer es para ventanas corredizas de aluminio 5020 y con sus distintos colores
//                            switch (tipoColor) { 
//                                case 1:
//                                  ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(9).getPreciocost(), this.lista.get(57).getPreciocost(),
//                                                    this.lista.get(60).getPreciocost(), this.lista.get(11).getPreciocost(),
//                                                    this.lista.get(80).getPreciocost(), this.lista.get(83).getPreciocost(),
//                                                    this.lista.get(13).getPreciocost(), this.lista.get(86).getPreciocost(),
//                                                    this.lista.get(48).getPreciocost(), this.lista.get(77).getPreciocost(),
//                                                    this.lista.get(23).getPreciocost(), this.lista.get(7).getPreciocost(),
//                                                    this.lista.get(66).getPreciocost(), this.tipoVentana);
//                                    break;
//                                case 2:
//                                     ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(9).getPrecioAnonizado(), this.lista.get(57).getPrecioAnonizado(),
//                                                    this.lista.get(60).getPrecioAnonizado(), this.lista.get(11).getPrecioAnonizado(),
//                                                    this.lista.get(80).getPrecioAnonizado(), this.lista.get(83).getPrecioAnonizado(),
//                                                    this.lista.get(13).getPrecioAnonizado(), this.lista.get(86).getPrecioAnonizado(),
//                                                    this.lista.get(48).getPrecioAnonizado(), this.lista.get(77).getPrecioAnonizado(),
//                                                    this.lista.get(23).getPrecioAnonizado(), this.lista.get(7).getPrecioAnonizado(),
//                                                    this.lista.get(66).getPrecioAnonizado(), this.tipoVentana);
//                                    break;
//                                case 3:
//                                   ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                    this.lista.get(9).getPrecioPintura(), this.lista.get(57).getPrecioPintura(),
//                                                    this.lista.get(60).getPrecioPintura(), this.lista.get(11).getPrecioPintura(),
//                                                    this.lista.get(80).getPrecioPintura(), this.lista.get(83).getPrecioPintura(),
//                                                    this.lista.get(13).getPrecioPintura(), this.lista.get(86).getPrecioPintura(),
//                                                    this.lista.get(48).getPrecioPintura(), this.lista.get(77).getPrecioPintura(),
//                                                    this.lista.get(23).getPrecioPintura(), this.lista.get(7).getPrecioPintura(),
//                                                    this.lista.get(66).getPrecioPintura(), this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                        case 3: // este constructoer es para ventanas corredizas de aluminio 8025 y con sus distintos colores
//                            switch (tipoColor) {
//                                case 1:
//                                    ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                       this.lista.get(16).getPreciocost(), this.lista.get(58).getPreciocost(),
//                                                    this.lista.get(61).getPreciocost(), this.lista.get(18).getPreciocost(),
//                                                    this.lista.get(81).getPreciocost(), this.lista.get(84).getPreciocost(),
//                                                    this.lista.get(20).getPreciocost(), this.lista.get(87).getPreciocost(),
//                                                    this.lista.get(49).getPreciocost(), this.lista.get(78).getPreciocost(),
//                                                    this.lista.get(24).getPreciocost(), this.lista.get(7).getPreciocost(),
//                                                    this.lista.get(67).getPreciocost(), this.tipoVentana);
//
//                                    break;
//                                case 2:
//                                     ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                          this.lista.get(16).getPrecioAnonizado(), this.lista.get(58).getPrecioAnonizado(),
//                                                    this.lista.get(61).getPrecioAnonizado(), this.lista.get(18).getPrecioAnonizado(),
//                                                    this.lista.get(81).getPrecioAnonizado(), this.lista.get(84).getPrecioAnonizado(),
//                                                    this.lista.get(20).getPrecioAnonizado(), this.lista.get(87).getPrecioAnonizado(),
//                                                    this.lista.get(49).getPrecioAnonizado(), this.lista.get(78).getPrecioAnonizado(),
//                                                    this.lista.get(24).getPrecioAnonizado(), this.lista.get(7).getPrecioAnonizado(),
//                                                    this.lista.get(67).getPrecioAnonizado(), this.tipoVentana);
//                                    break;
//                                case 3:
//                                ventanaAbatible = new VentanaAbatible(this.ancho, this.alto, this.manObra, this.ganancia,
//                                                        this.lista.get(16).getPrecioPintura(), this.lista.get(58).getPrecioPintura(),
//                                                    this.lista.get(61).getPrecioPintura(), this.lista.get(18).getPrecioPintura(),
//                                                    this.lista.get(81).getPrecioPintura(), this.lista.get(84).getPrecioPintura(),
//                                                    this.lista.get(20).getPrecioPintura(), this.lista.get(87).getPrecioPintura(),
//                                                    this.lista.get(49).getPrecioPintura(), this.lista.get(78).getPrecioPintura(),
//                                                    this.lista.get(24).getPrecioPintura(), this.lista.get(7).getPrecioPintura(),
//                                                    this.lista.get(67).getPrecioPintura(), this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                    }
//
//
//           
//        
//            if (this.idVidrio != 0) {
//                DaoVidrio daoVidrio = new DaoVidrio();
//
//                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
//                this.precioVidrio = this.precioVidrio * (ventanaAbatible.getAlto() * ventanaAbatible.getAncho());
//                int espacios = String.valueOf(this.precioVidrio).length();
//                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
//            }
//            if (this.idVidrio == 0) {
//                this.precioVidrio = 0;
//            }
//
//            if (this.tipoVentana == 1) {
//                DaoAccesorios daoAcessorios = new DaoAccesorios();
//                int rodamientos = 0;
//                int chapaVentana = 0;
//                int guias = 0;
//
//                rodamientos = daoAcessorios.getById(this.session, 1).getPrecioCosto() * 2;
//                chapaVentana = daoAcessorios.getById(this.session, 7).getPrecioCosto() * 1;
//                guias = daoAcessorios.getById(this.session, 19).getPrecioCosto() * 8;
//
//                this.precioAccesorios = rodamientos + chapaVentana + guias;
//
//            } else {
//                if (this.tipoVentana == 2 || this.tipoVentana == 3) {
//                    DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                    int rodamientos = 0;
//                    int chapaVentana = 0;
//                    int guias = 0;
//
//                    rodamientos = daoAcessorios.getById(this.session, 1).getPrecioCosto() * 4;
//                    chapaVentana = daoAcessorios.getById(this.session, 7).getPrecioCosto() * 2;
//                    guias = daoAcessorios.getById(this.session, 19).getPrecioCosto() * 8;
//
//                    this.precioAccesorios = rodamientos + chapaVentana + guias;
//                }
//
//            }
//            if (this.tipoVentana < 4 && this.tipoVentana > 0) {
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idVentana),
//                        daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, ventanaAbatible.getSumaTotal() + this.precioVidrio + this.precioAccesorios, this.cantidadProducto * ventanaAbatible.getSumaTotal()
//                        + this.precioVidrio + this.precioAccesorios, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//            if (this.tipoProductos == 4) {
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, this.tipoVentana),
//                        daoProductos.getById(this.session, this.tipoVentana).getNombre() + " " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, this.precioVidrio + this.manObra, this.cantidadProducto * this.precioVidrio, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//
//            if (this.tipoVentana == 1) {
//                if (this.tipoAluminio == 1 || this.tipoAluminio == 4 || this.tipoAluminio == 7) {
//                    Despiece despie = new Despiece();
//
//                    despie.setNombreProducto(nombreProducto);
//                    despie.setCantProducto(this.cantidadProducto);
//                    despie.setCantidadCabezal(1 * this.cantidadProducto);
//                    despie.setCantidadSillar(1 * this.cantidadProducto);
//                    despie.setCantidadJamba(2 * this.cantidadProducto);
//                    despie.setCantidadEnganche(2 * this.cantidadProducto);
//                    despie.setCantidadEnganche(2 * this.cantidadProducto);
//                    despie.setCantidadTraslape(2 * this.cantidadProducto);
//                    despie.setCantidadTraslape(2 * this.cantidadProducto);
//                    despie.setCantidadHorizontalesSuperior(2 * this.cantidadProducto);
//                    despie.setCantidadHorizontalesInferior(2 * this.cantidadProducto);
//                    despie.setCantidadVidrio(2 * this.cantidadProducto);
//                    despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeSillar(despie.getCantidadSillar() + "  RecorteSillar de: " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                    despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganchez de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                    despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte traslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                    despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                    despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                    despie.setTipoProducto(6);
//
//                    lstDespiece.add(despie);
//                }
//            } else {
//                if (this.tipoVentana == 2) {
//                    if (this.tipoAluminio == 2 || this.tipoAluminio == 5 || this.tipoAluminio == 8) {
//                        Despiece despie = new Despiece();
//
//                        despie.setNombreProducto(nombreProducto);
//                        despie.setCantProducto(this.cantidadProducto);
//                        despie.setCantidadCabezal(1 * this.cantidadProducto);
//                        despie.setCantidadSillar(1 * this.cantidadProducto);
//                        despie.setCantidadJamba(2 * this.cantidadProducto);
//                        despie.setCantidadEnganche(2 * this.cantidadProducto);
//                        despie.setCantidadTraslape(4 * this.cantidadProducto);
//                        despie.setCantidadHorizontalesSuperior(3 * this.cantidadProducto);
//                        despie.setCantidadHorizontalesInferior(3 * this.cantidadProducto);
//                        despie.setMensajeCabezal(despie.getCantidadCabezal() + "Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeSillar(despie.getCantidadSillar() + " Recorte Sillar de: " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganches de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recortetraslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() - 1 + "Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Superior de: " + (Double.valueOf(this.getAncho()))));
//                        despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() - 1 + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Inferior de: " + (Double.valueOf(this.getAncho()))));
//                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                        despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                        despie.setTipoProducto(7);
//
//                        lstDespiece.add(despie);
//                    } else {
//                        if (this.tipoAluminio == 3 || this.tipoAluminio == 6 || this.tipoAluminio == 9) {
//                            Despiece despie = new Despiece();
//
//                            despie.setNombreProducto(nombreProducto);
//                            despie.setCantProducto(this.cantidadProducto);
//                            despie.setCantidadCabezal(1 * this.cantidadProducto);
//                            despie.setCantidadSillar(1 * this.cantidadProducto);
//                            despie.setCantidadJamba(2 * this.cantidadProducto);
//                            despie.setCantidadEnganche(4 * this.cantidadProducto);
//                            despie.setCantidadTraslape(4 * this.cantidadProducto);
//                            despie.setCantidadHorizontalesSuperior(4 * this.cantidadProducto);
//                            despie.setCantidadHorizontalesInferior(4 * this.cantidadProducto);
//                            despie.setCantidadAdactador(1 * this.cantidadProducto);
//                            despie.setMensajeCabezal(despie.getCantidadCabezal() + "Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeSillar(despie.getCantidadSillar() + " Recorte Sillar de: " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                            despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganches de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recortetraslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeAdactador(despie.getCantidadAdactador() + " Adaptador de: " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() - 1 + "Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Superior de: " + (Double.valueOf(this.getAncho()))));
//                            despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() - 1 + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Inferior de: " + (Double.valueOf(this.getAncho()))));
//                            despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                            despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                            despie.setTipoProducto(8);
//
//                            lstDespiece.add(despie);
//                        }
//                    }
//                }
//            }
//
//            this.transaccion.commit();
//            this.idVidrio = 0;
//            this.ganancia = 0;
//            this.alto = "";
//            this.ancho = "";
//            this.manObra = 0;
//            this.tipoVentana = 0;
//            this.tipoVidrio = 0;
//            this.productoTipo = 0;
//
//        } catch (Exception ex) {
//
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//
//    }
//
//    public void calcularVentanaCelosial() {
//        this.session = null;
//        this.transaccion = null;
//
//        VentanaProyectante ventanaProyectante = new VentanaProyectante();
//        try {
//
//            if (this.alto.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el alto."));
//                return;
//            }
//
//            if (this.ancho.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor digite el ancho."));
//                return;
//            }
//
//            if (this.alto.length() > 3 || this.ancho.length() > 3) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Las medidas no pueden superar 3 cifras."));
//                return;
//            }
//
//            if (String.valueOf(this.manObra).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el precio de la mano de obra."));
//                return;
//            }
//
//            if (String.valueOf(this.ganancia).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el porcentaje de ganancia."));
//                return;
//            }
//
//            if (this.tipoVentana == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto."));
//                return;
//            }
//
//            try {
//                int o = Integer.valueOf(this.alto);
//                int p = Integer.valueOf(this.ancho);
//                int m = this.manObra;
//                int t = this.ganancia;
//            } catch (NumberFormatException nfe) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
//            }
//
//            DaoMaterial daoMaterial = new DaoMaterial();
//            DaoProductos daoProductos = new DaoProductos();
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            this.lista.addAll(daoMaterial.getAll(this.session));
//
//            if (this.tipoAluminio == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
//                return;
//            }
//         int idVentana = 0;
//            switch (tipoVentana) {
//                case 1:
//                    idVentana = 1;
//                    break;
//                case 2:
//                    idVentana = 2;
//                    break;
//                case 3:
//                    idVentana = 3;
//                    break;
//                      case 4:
//                    idVentana = 5;
//                    break;
//                            case 5:
//                    idVentana = 5;
//                    break;
//
//            }
//        
//
////         
////            String dosNaves = "";
////            switch (tipoNaves) {
////                case 1:
////                    dosNaves = "Movil Fija basica X0";
////                    break;
////                case 2:
////                    dosNaves = "Movil Movil Basica X0";
////                    break;
////            }
////            String tresNaves = "";
////            switch (tipo3Naves) {
////                case 1:
////                    tresNaves = "Fijol Movil Fijo X0X";
////                    break;
////                case 2:
////                    tresNaves = "Fijo Movil Fijo 0X0";
////                    break;
////                case 3:
////                    tresNaves = "Fijo Movil Movil 0XX";
////                    break;
////                case 4:
////                    tresNaves = " Movil Fijo sobre Fijo X0/0";
////                    break;
////            }
////
////            String cuatroNaves = "";
////            switch (tipo4Naves) {
////                case 1:
////                    cuatroNaves = "Fijo Movil Movil Fijo 0XXO";
////                    break;
////                case 2:
////                    cuatroNaves = "Movil Fijo sobre Fijo Fijo ALF";
////                    break;
////            }
////            String cincoNaves = "";
////            switch (tipo5Naves) {
////                case 1:
////                    cincoNaves = "Fijo Movil Movil Movil Movil Fijo 0XXXXO";
////                    break;
////                case 2:
////                    cincoNaves = "Fijo Movil Fijo sobre Fijo Fijo fijo ALF";
////                    break;
////            }
//            
//              String nombreAluminio = "";
//            switch (tipoAluminio) {
//                case 1:
//                    nombreAluminio = " Aluminio 744";
//                    break;
//                case 2:
//                    nombreAluminio = " Aluminio 5020";
//                    break;
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
//            }
//
//            switch (tipoColor) {
//                case 1:
//                    nombreAluminio += " Natural";
//                    break;
//                case 2:
//                    nombreAluminio += " Anolo";
//                    break;
//                case 3:
//                    nombreAluminio += " Colores";
//                    break;
//            }
//
//      // este caso es para los modelos de las ventanas   este es para una ventana de dos cuerpos 
//                            // movil movil  sobre fijo fijo X0/00 con su tipo de aluminio y color  // ventana 2 de la clase ventana cooredera
//
//    
//                    switch (this.tipoAluminio) {
//                        case 1: // estos constructores es para ventanas corredizas de aluminio 744 y con sus distintos colores
//                           switch (tipoColor) { 
//                                case 1:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(0).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(30).getPreciocost(), this.lista.get(38).getPreciocost(),
//                        this.lista.get(88).getPreciocost(), this.lista.get(8).getPreciocost(),
//                        this.lista.get(50).getPreciocost(), this.lista.get(1).getPreciocost(),
//                                            this.lista.get(7).getPreciocost(),  this.tipoVentana);
//                                case 2:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                                this.lista.get(0).getPrecioAnonizado(), this.lista.get(2).getPrecioAnonizado(),
//                        this.lista.get(30).getPrecioAnonizado(), this.lista.get(38).getPrecioAnonizado(),
//                        this.lista.get(88).getPrecioAnonizado(), this.lista.get(8).getPrecioAnonizado(),
//                        this.lista.get(50).getPrecioAnonizado(), this.lista.get(1).getPrecioAnonizado(),
//                                            this.lista.get(7).getPreciocost(),  this.tipoVentana);
//                                    break;
//                                case 3:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                                    this.lista.get(0).getPrecioPintura(), this.lista.get(2).getPrecioPintura(),
//                        this.lista.get(30).getPrecioPintura(), this.lista.get(38).getPrecioPintura(),
//                        this.lista.get(88).getPrecioPintura(), this.lista.get(8).getPrecioPintura(),
//                        this.lista.get(50).getPrecioPintura(), this.lista.get(1).getPrecioPintura(),
//                                            this.lista.get(7).getPreciocost(),  this.tipoVentana);
//                                    break;
//                            }
//                            break;
//                        case 2:// este constructoer es para ventanas corredizas de aluminio 5020 y con sus distintos colores
//                            switch (tipoColor) { 
//                                case 1:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(232).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(1).getPreciocost(), this.lista.get(3).getPreciocost(),
//                        this.lista.get(4).getPreciocost(), this.lista.get(5).getPreciocost(),
//                        this.lista.get(6).getPreciocost(), this.lista.get(7).getPreciocost(),
//                        this.tipoVentana, this.lista.get(119).getPreciocost());
//                                    break;
//                                case 2:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(232).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(1).getPreciocost(), this.lista.get(3).getPreciocost(),
//                        this.lista.get(4).getPreciocost(), this.lista.get(5).getPreciocost(),
//                        this.lista.get(6).getPreciocost(), this.lista.get(7).getPreciocost(),
//                        this.tipoVentana, this.lista.get(119).getPreciocost());
//                                    break;
//                                case 3:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(232).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(1).getPreciocost(), this.lista.get(3).getPreciocost(),
//                        this.lista.get(4).getPreciocost(), this.lista.get(5).getPreciocost(),
//                        this.lista.get(6).getPreciocost(), this.lista.get(7).getPreciocost(),
//                        this.tipoVentana, this.lista.get(119).getPreciocost());
//                                    break;
//                            }
//                            break;
//                        case 3: // este constructoer es para ventanas corredizas de aluminio 8025 y con sus distintos colores
//                            switch (tipoColor) {
//                                case 1:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(232).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(1).getPreciocost(), this.lista.get(3).getPreciocost(),
//                        this.lista.get(4).getPreciocost(), this.lista.get(5).getPreciocost(),
//                        this.lista.get(6).getPreciocost(), this.lista.get(7).getPreciocost(),
//                        this.tipoVentana, this.lista.get(119).getPreciocost());
//
//                                    break;
//                                case 2:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(232).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(1).getPreciocost(), this.lista.get(3).getPreciocost(),
//                        this.lista.get(4).getPreciocost(), this.lista.get(5).getPreciocost(),
//                        this.lista.get(6).getPreciocost(), this.lista.get(7).getPreciocost(),
//                        this.tipoVentana, this.lista.get(119).getPreciocost());
//                                    break;
//                                case 3:
//                                    ventanaProyectante = new VentanaProyectante(this.ancho, this.alto, this.manObra, this.ganancia,
//                        this.lista.get(232).getPreciocost(), this.lista.get(2).getPreciocost(),
//                        this.lista.get(1).getPreciocost(), this.lista.get(3).getPreciocost(),
//                        this.lista.get(4).getPreciocost(), this.lista.get(5).getPreciocost(),
//                        this.lista.get(6).getPreciocost(), this.lista.get(7).getPreciocost(),
//                        this.tipoVentana, this.lista.get(119).getPreciocost());
//                                    break;
//                            }
//                            break;
//                    }
//
//            if (this.idVidrio != 0) {
//                DaoVidrio daoVidrio = new DaoVidrio();
//
//                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
//                this.precioVidrio = this.precioVidrio * (ventanaProyectante.getAlto() * ventanaProyectante.getAncho());
//                int espacios = String.valueOf(this.precioVidrio).length();
//                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));
//            }
//            if (this.idVidrio == 0) {
//                this.precioVidrio = 0;
//            }
//
//            if (this.tipoVentana == 1) {
//                DaoAccesorios daoAcessorios = new DaoAccesorios();
//                int rodamientos = 0;
//                int chapaVentana = 0;
//                int guias = 0;
//
//                rodamientos = daoAcessorios.getById(this.session, 1).getPrecioCosto() * 2;
//                chapaVentana = daoAcessorios.getById(this.session, 7).getPrecioCosto() * 1;
//                guias = daoAcessorios.getById(this.session, 19).getPrecioCosto() * 8;
//
//                this.precioAccesorios = rodamientos + chapaVentana + guias;
//
//            } else {
//                if (this.tipoVentana == 2 || this.tipoVentana == 3) {
//                    DaoAccesorios daoAcessorios = new DaoAccesorios();
//
//                    int rodamientos = 0;
//                    int chapaVentana = 0;
//                    int guias = 0;
//
//                    rodamientos = daoAcessorios.getById(this.session, 1).getPrecioCosto() * 4;
//                    chapaVentana = daoAcessorios.getById(this.session, 7).getPrecioCosto() * 2;
//                    guias = daoAcessorios.getById(this.session, 19).getPrecioCosto() * 8;
//
//                    this.precioAccesorios = rodamientos + chapaVentana + guias;
//                }
//
//            }
//            if (this.tipoVentana < 4 && this.tipoVentana > 0) {
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idVentana),
//                        daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, ventanaProyectante.getSumaTotal() + this.precioVidrio + this.precioAccesorios, this.cantidadProducto * ventanaProyectante.getSumaTotal()
//                        + this.precioVidrio + this.precioAccesorios, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//            if (this.tipoProductos == 4) {
//                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, this.tipoVentana),
//                        daoProductos.getById(this.session, this.tipoVentana).getNombre() + " " + this.alto + "*" + this.ancho,
//                        this.cantidadProducto, this.precioVidrio + this.manObra, this.cantidadProducto * this.precioVidrio, this.manObra, this.ganancia, this.alto, this.ancho, ""));
//            }
//
//            if (this.tipoVentana == 1) {
//                if (this.tipoAluminio == 1 || this.tipoAluminio == 4 || this.tipoAluminio == 7) {
//                    Despiece despie = new Despiece();
//
//                    despie.setNombreProducto(nombreProducto);
//                    despie.setCantProducto(this.cantidadProducto);
//                    despie.setCantidadCabezal(1 * this.cantidadProducto);
//                    despie.setCantidadSillar(1 * this.cantidadProducto);
//                    despie.setCantidadJamba(2 * this.cantidadProducto);
//                    despie.setCantidadEnganche(2 * this.cantidadProducto);
//                    despie.setCantidadEnganche(2 * this.cantidadProducto);
//                    despie.setCantidadTraslape(2 * this.cantidadProducto);
//                    despie.setCantidadTraslape(2 * this.cantidadProducto);
//                    despie.setCantidadHorizontalesSuperior(2 * this.cantidadProducto);
//                    despie.setCantidadHorizontalesInferior(2 * this.cantidadProducto);
//                    despie.setCantidadVidrio(2 * this.cantidadProducto);
//                    despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeSillar(despie.getCantidadSillar() + "  RecorteSillar de: " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                    despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganchez de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                    despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte traslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                    despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho())));
//                    despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                    despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                    despie.setTipoProducto(6);
//
//                    lstDespiece.add(despie);
//                }
//            } else {
//                if (this.tipoVentana == 2) {
//                    if (this.tipoAluminio == 2 || this.tipoAluminio == 5 || this.tipoAluminio == 8) {
//                        Despiece despie = new Despiece();
//
//                        despie.setNombreProducto(nombreProducto);
//                        despie.setCantProducto(this.cantidadProducto);
//                        despie.setCantidadCabezal(1 * this.cantidadProducto);
//                        despie.setCantidadSillar(1 * this.cantidadProducto);
//                        despie.setCantidadJamba(2 * this.cantidadProducto);
//                        despie.setCantidadEnganche(2 * this.cantidadProducto);
//                        despie.setCantidadTraslape(4 * this.cantidadProducto);
//                        despie.setCantidadHorizontalesSuperior(3 * this.cantidadProducto);
//                        despie.setCantidadHorizontalesInferior(3 * this.cantidadProducto);
//                        despie.setMensajeCabezal(despie.getCantidadCabezal() + "Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeSillar(despie.getCantidadSillar() + " Recorte Sillar de: " + (Double.valueOf(this.getAncho())));
//                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganches de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recortetraslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() - 1 + "Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Superior de: " + (Double.valueOf(this.getAncho()))));
//                        despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() - 1 + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Inferior de: " + (Double.valueOf(this.getAncho()))));
//                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                        despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                        despie.setTipoProducto(7);
//
//                        lstDespiece.add(despie);
//                    } else {
//                        if (this.tipoAluminio == 3 || this.tipoAluminio == 6 || this.tipoAluminio == 9) {
//                            Despiece despie = new Despiece();
//
//                            despie.setNombreProducto(nombreProducto);
//                            despie.setCantProducto(this.cantidadProducto);
//                            despie.setCantidadCabezal(1 * this.cantidadProducto);
//                            despie.setCantidadSillar(1 * this.cantidadProducto);
//                            despie.setCantidadJamba(2 * this.cantidadProducto);
//                            despie.setCantidadEnganche(4 * this.cantidadProducto);
//                            despie.setCantidadTraslape(4 * this.cantidadProducto);
//                            despie.setCantidadHorizontalesSuperior(4 * this.cantidadProducto);
//                            despie.setCantidadHorizontalesInferior(4 * this.cantidadProducto);
//                            despie.setCantidadAdactador(1 * this.cantidadProducto);
//                            despie.setMensajeCabezal(despie.getCantidadCabezal() + "Recorte Cabeazal de:  " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeSillar(despie.getCantidadSillar() + " Recorte Sillar de: " + (Double.valueOf(this.getAncho())));
//                            despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(this.getAlto()) - 1.3));
//                            despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte Enganches de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recortetraslapes de:  " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeAdactador(despie.getCantidadAdactador() + " Adaptador de: " + (Double.valueOf(this.getAlto()) - 2.5));
//                            despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() - 1 + "Recorte Horizontales Superior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Superior de: " + (Double.valueOf(this.getAncho()))));
//                            despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() - 1 + " Recorte Horizontales Inferior de:  " + (Double.valueOf(this.getAncho()) / 2 + "  y 1 horizontal Inferior de: " + (Double.valueOf(this.getAncho()))));
//                            despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(this.getAlto()) - 5) + " Recorte VidrioAncho de: " + (Double.valueOf(this.getAncho()) - 5.5));
//                            despie.setNombreProducto(daoProductos.getById(this.session, idVentana).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
//                            despie.setTipoProducto(8);
//
//                            lstDespiece.add(despie);
//                        }
//                    }
//                }
//            }
//
//            this.transaccion.commit();
//            this.idVidrio = 0;
//            this.ganancia = 0;
//            this.alto = "";
//            this.ancho = "";
//            this.manObra = 0;
//            this.tipoVentana = 0;
//            this.tipoVidrio = 0;
//            this.productoTipo = 0;
//
//        } catch (Exception ex) {
//
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//
//    }
//
//    public void imprimeDespiese(Object document) {
//        try {
//            Document pdf = (Document) document;
//            pdf.open();
//            pdf.setPageSize(PageSize.A4);
//
//            HTMLWorker htmlWorker = new HTMLWorker(pdf);
//            String html = "";
//            for (Despiece item : lstDespiece) {
//                if (item.getTipoProducto() == 1) {
//                    html += "<p>Tipo Producto Puerta</p><br></br>";
//                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                    html += "<p>Aluminio 3 Alto:" + item.getMensajeAluminio3Alto() + "</p>";
//                    html += "<p>Aluminio 3 ancho:" + item.getMensajeAluminio3Ancho() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajePisaVidriosAncho() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajePartidor() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajePibotes() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajeVarillasTensoras() + "</p>";
//                    html += "<p>Aluminio :" + item.getMensajeVidrioAltoAncho() + "</p>";
//                    html += "______________________________________________________";
//                } else {
//                    if (item.getTipoProducto() == 2) {
//                        html += "<p>Tipo Producto Puerta</p><br></br>";
//                        html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                        html += "<p>Aluminio 3 Alto:" + item.getMensajeAluminio3Alto() + "</p>";
//                        html += "<p>Aluminio 3 ancho:" + item.getMensajeAluminio3Ancho() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajePerfilU71() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajePibotes() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
//                        html += "<p>Aluminio :" + item.getMensajeVarillasTensoras() + "</p>";
//                        html += "______________________________________________________";
//                    } else {
//                        if (item.getTipoProducto() == 3) {
//                            html += "<p>Tipo Producto Puerta</p><br></br>";
//                            html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                            html += "<p>Aluminio 3 Alto:" + item.getMensajeAluminio3Alto() + "</p>";
//                            html += "<p>Aluminio 3 ancho:" + item.getMensajeAluminio3Ancho() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajePisaVidriosAncho() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensageEntamboradoF06() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajePibotes() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajeVarillasTensoras() + "</p>";
//                            html += "<p>Aluminio :" + item.getMensajeVidrioAltoAncho() + "</p>";
//                            html += "______________________________________________________";
//                        } else {
//                            if (item.getTipoProducto() == 4) {
//                                html += "<p>Tipo Producto Puerta</p><br></br>";
//                                html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                html += "<p>Aluminio 3 Alto:" + item.getMensajeAluminio3Alto() + "</p>";
//                                html += "<p>Aluminio 3 ancho:" + item.getMensajeAluminio3Ancho() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajePisaVidriosAncho() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajePartidor() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajePibotes() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
//                                html += "<p>Aluminio :" + item.getMensajeVarillasTensoras() + "</p>";
//                                html += "______________________________________________________";
//
//                            } else {
//                                if (item.getTipoProducto() == 5) {
//                                    html += "<p>Tipo Producto Puerta</p><br></br>";
//                                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                    html += "<p>Aluminio 3 Alto:" + item.getMensajeAluminio3Alto() + "</p>";
//                                    html += "<p>Aluminio 3 ancho:" + item.getMensajeAluminio3Ancho() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajePisaVidriosAncho() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajePartidor() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeVisagras() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeVarillasTensoras() + "</p>";
//                                    html += "<p>Aluminio :" + item.getMensajeVidrioAltoAncho() + "</p>";
//                                    html += "______________________________________________________";
//
//                                } else {
//                                    if (item.getTipoProducto() == 6) {
//                                        html += "<p>Tipo Producto Ventana</p><br></br>";
//                                        html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeTraslape() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
//                                        html += "<p>Aluminio :" + item.getMensajeVidrio() + "</p>";
//                                        html += "______________________________________________________";
//
//                                    } else {
//                                        if (item.getTipoProducto() == 7) {
//                                            html += "<p>Tipo Producto Ventana</p><br></br>";
//                                            html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeTraslape() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
//                                            html += "<p>Aluminio :" + item.getMensajeVidrio() + "</p>";
//                                            html += "______________________________________________________";
//
//                                        } else {
//                                            if (item.getTipoProducto() == 8) {
//                                                html += "<p>Tipo Producto Puerta</p><br></br>";
//                                                html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeTraslape() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
//                                                html += "<p>Aluminio 3 Alto:" + item.getMensajeAdactador() + "</p>";
//                                                html += "<p>Aluminio :" + item.getMensajeVidrio() + "</p>";
//                                                html += "______________________________________________________";
//
//                                            } else {
//                                                if (item.getTipoProducto() == 9) {
//                                                    html += "<p>Tipo Producto Vitrina</p><br></br>";
//                                                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeCuartoCirculoAlto() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeCuartoCirculoAncho() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeCuartoCirculoFondo() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeAnguloMediaAlto() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeAnguloMediaAncho() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeAnguloMediaFondo() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeNaveDivisionAncho() + "</p>";
//                                                    html += "<p>Aluminio :" + item.getMensajeVidrioAltoAncho() + "</p>";
//                                                    html += "<p>Vidrio:" + item.getMensajeVidrioAltoFondo() + "</p>";
//                                                    html += "<p>Vidrio :" + item.getMensajeVidrioAnchoFondo() + "</p>";
//                                                    html += "______________________________________________________";
//
//                                                } else {
//
//                                                    if (item.getTipoProducto() == 10) {
//                                                        html += "<p>Tipo Producto Vitrina</p><br></br>";
//                                                        html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajePerfilEsquineroUna() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajePerfilEsquineroUnaFondo() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajeAnguloMediaAlto() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajeAnguloMediaAncho() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajeAnguloMediaFondo() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
//                                                        html += "<p>Aluminio :" + item.getMensajePisavidrioFondo() + "</p>";
//                                                        html += "<p>Aluminio:" + item.getMensajeNaveAncho() + "</p>";
//                                                        html += "<p>Vidrio :" + item.getMensajeVidrioAltoAncho() + "</p>";
//                                                        html += "<p>Vidrio :" + item.getMensajeVidrioAltoFondo() + "</p>";
//                                                        html += "<p>Vidrio :" + item.getMensajeVidrioAnchoFondo() + "</p>";
//                                                        html += "<p>Vidrio :" + item.getMensajeVidrioAnchoFondo() + "</p>";
//                                                        html += "______________________________________________________";
//                                                    } else {
//                                                        if (item.getTipoProducto() == 11) {
//                                                            html += "<p>Tipo Producto Vitrina</p><br></br>";
//                                                            html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajePerfilEsquineroUna() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajePerfilEsquineroUnaFondo() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajeAnguloMediaAlto() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajeAnguloMediaAncho() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajeAnguloMediaFondo() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
//                                                            html += "<p>Aluminio :" + item.getMensajePisavidrioFondo() + "</p>";
//                                                            html += "<p>Aluminio:" + item.getMensajeNaveAncho() + "</p>";
//                                                            html += "<p>Vidrio :" + item.getMensajeVidrioAltoAncho() + "</p>";
//                                                            html += "<p>Vidrio :" + item.getMensajeVidrioAltoFondo() + "</p>";
//                                                            html += "<p>Vidrio :" + item.getMensajeVidrioAnchoFondo() + "</p>";
//                                                            html += "<p>Vidrio :" + item.getMensajeVidrioAnchoFondo() + "</p>";
//                                                            html += "______________________________________________________";
//
//                                                        }
//                                                    }
//                                                }
//                                            }
//
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            htmlWorker.parse(new StringReader(html));
//        } catch (Exception e) {
//            System.out.println("Ocurrio un error generando pdf: " + e.toString());
//        }
//
//    }
//
//    public void generarFactura() {
//        this.session = null;
//        this.transaccion = null;
//        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        String correoEmple = httpSession.getAttribute("correoElectronico").toString();
//        try {
//            DaoCliente daoCliente = new DaoCliente();
//            DaoEmpleado daoEmpleado = new DaoEmpleado();
//            DaoAbonos daoAbonos = new DaoAbonos();
//            DaoAbonoDetalle daoAbonoDetalle = new DaoAbonoDetalle();
//
//            if (this.montoAbono == 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el valor del Abono."));
//                return;
//            }
//            if (String.valueOf(this.montoAbono).equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el valor del Abono."));
//                return;
//            }
//            try {
//
//                long m = this.montoAbono;
//
//            } catch (NumberFormatException nfe) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
//            }
//
//            if (this.cliente == null) {
//                System.out.println("codigo del cliente");
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor selecione un cliente."));
//                return;
//            }
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            this.abonos.setCliente(cliente);
//            this.abonos.setEmpleado(daoEmpleado.getByCorreoElectronico(this.session, correoEmple));
//            this.abonos.setFecharegistro(new Date());
//            daoAbonos.registar(this.session, this.abonos);
//
//            this.abonos = daoAbonos.getByUltimoRegistro(this.session);
//            long suma = 0;
//            for (Abonodetalle listaAbono1 : this.listaAbono) {
//                listaAbono1.setAbonos(this.abonos);
//                suma += listaAbono1.getTotal();
//
////                este metodo es para descontar de la bd los productos por unidades 
////                estos son pra las vitrinas 3 8 9
//                if (this.productoTipo == 3) {
//
//                    DaoAccesorios daoAccesorios = new DaoAccesorios();
//
//                    Accesorios accesorios = new Accesorios();
//                    accesorios = daoAccesorios.getById(this.session, 18);//este el codigo de Piañas
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 4);//este el codigo de RodamientopPiso
//                    if (accesorios.getCantidad() >= 4) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (4 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//
//                    accesorios = daoAccesorios.getById(this.session, 6);//este el codigo de Rodamiento Ducha
//                    if (accesorios.getCantidad() >= 4) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (4 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 15);//este el codigo  de Acoples
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                        System.out.println("restamos la cantidad de producto");
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                        return;
//                    }
//
//                }
//
//                if (this.productoTipo == 8) {
//                    DaoAccesorios daoAccesorios = new DaoAccesorios();
//                    Accesorios accesorios = new Accesorios();
//
//                    accesorios = daoAccesorios.getById(this.session, 18);//este el codigo de Piañas
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 5);//este el codigo de Rodamiento
//                    if (accesorios.getCantidad() >= 4) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (4 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//
//                    accesorios = daoAccesorios.getById(this.session, 22);//este el codigo de Anclaje A15
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                        System.out.println("restamos la cantidad de producto");
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                        return;
//                    }
//
//                }
//                if (this.productoTipo == 9) {
//                    DaoAccesorios daoAccesorios = new DaoAccesorios();
//                    Accesorios accesorios = new Accesorios();
//                    accesorios = daoAccesorios.getById(this.session, 18);//este el codigo de tiañas
//                    if (accesorios.getCantidad() >= 16) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (16 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 5);//este el codigo de Rodamiento
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//
//                    accesorios = daoAccesorios.getById(this.session, 22);//este el codigo de Anclaje A15
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                        System.out.println("restamos la cantidad de producto");
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                        return;
//                    }
//
//                }
//                //                este metodo es para descontar de la bd los productos por unidades 
////                estos son para las puertas 2 4 5 6 7
//                if (this.productoTipo == 2 || this.productoTipo == 4 || this.productoTipo == 5 || this.productoTipo == 6) {
//
//                    DaoAccesorios daoAccesorios = new DaoAccesorios();
//                    Accesorios accesorios = new Accesorios();
//                    accesorios = daoAccesorios.getById(this.session, 11);//este el codigo de Pibotes
//                    if (accesorios.getCantidad() >= 1) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (1 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 10);//este el codigo de Chapa
//                    if (accesorios.getCantidad() >= 1) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (1 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//
//                    accesorios = daoAccesorios.getById(this.session, 12);//este el codigo de Varrrilas Tensoras
//                    if (accesorios.getCantidad() >= 2) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (2 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 13);//este el codigo de Escuadras
//                    if (accesorios.getCantidad() >= 12) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (12 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                        return;
//                    }
//
//                } else {
//                    if (this.productoTipo == 7) {
//
//                        DaoAccesorios daoAccesorios = new DaoAccesorios();
//                        Accesorios accesorios = new Accesorios();
//                        accesorios = daoAccesorios.getById(this.session, 14);//este el codigo de bisagras
//                        if (accesorios.getCantidad() >= 2) {
//                            accesorios.setCantidad(accesorios.getCantidad() - (2 * this.cantidadProducto));
//                            daoAccesorios.actualizar(this.session, accesorios);
//                        }
//                        accesorios = daoAccesorios.getById(this.session, 10);//este el codigo de Chapa Puerta
//                        if (accesorios.getCantidad() >= 1) {
//                            accesorios.setCantidad(accesorios.getCantidad() - (1 * this.cantidadProducto));
//                            daoAccesorios.actualizar(this.session, accesorios);
//                        }
//
//                        accesorios = daoAccesorios.getById(this.session, 12);//este el codigo de Varrrilas Tensoras
//                        if (accesorios.getCantidad() >= 2) {
//                            accesorios.setCantidad(accesorios.getCantidad() - (2 * this.cantidadProducto));
//                            daoAccesorios.actualizar(this.session, accesorios);
//                        }
//                        accesorios = daoAccesorios.getById(this.session, 13);//este el codigo de Escuadras
//                        if (accesorios.getCantidad() >= 12) {
//                            accesorios.setCantidad(accesorios.getCantidad() - (12 * this.cantidadProducto));
//                            daoAccesorios.actualizar(this.session, accesorios);
//                        } else {
//                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                            return;
//                        }
//                    }
//                }
//
//                //                este metodo es para descontar de la bd los productos por unidades 
////                estos son pra las ventanas 1 2 3
////                esta es para ventana de 2 cuerpos
//                if (this.tipoAluminio == 1) {
//
//                    DaoAccesorios daoAccesorios = new DaoAccesorios();
//                    Accesorios accesorios = new Accesorios();
//                    accesorios = daoAccesorios.getById(this.session, 1);//este el codigo de Rodamientos
//                    if (accesorios.getCantidad() >= 2) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (2 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 7);//este el codigo de chapaVentana
//                    if (accesorios.getCantidad() >= 1) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (1 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//
//                    accesorios = daoAccesorios.getById(this.session, 19);//este el codigo de guias
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                        return;
//                    }
//
//                }
////                    esta es ventana de 3 cuerpos
//
//                if (this.tipoAluminio == 2 || this.tipoAluminio == 3) {
//                    DaoAccesorios daoAccesorios = new DaoAccesorios();
//                    Accesorios accesorios = new Accesorios();
//
//                    accesorios = daoAccesorios.getById(this.session, 1);//este el codigo de rodamientos
//                    if (accesorios.getCantidad() >= 4) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (4 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//                    accesorios = daoAccesorios.getById(this.session, 7);//este el codigo de chapaVentana
//                    if (accesorios.getCantidad() >= 2) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (2 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    }
//
//                    accesorios = daoAccesorios.getById(this.session, 19);//este el codigo de guias
//                    if (accesorios.getCantidad() >= 8) {
//                        accesorios.setCantidad(accesorios.getCantidad() - (8 * this.cantidadProducto));
//                        daoAccesorios.actualizar(this.session, accesorios);
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrecto", "La Cantidad produtos superara el STOCK"));
//                        return;
//                    }
//
//                }
//
//                daoAbonoDetalle.registar(this.session, listaAbono1);
//            }
//            this.listaFactura = this.listaAbono;
//            this.abonos.setPrecioTotal(suma);
//            this.abonos.setMontoabono(this.montoAbono);
//            this.abonos.setSaldofinal(this.abonos.getPrecioTotal() - this.abonos.getMontoabono());
//            daoAbonos.actualizar(this.session, this.abonos);
//            this.abonos.getFecharegistro();
//            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            sesson.setAttribute("idfactura", this.abonos.getIdabonos());
//            this.transaccion.commit();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Se ha registrado "));
//
//            for (Despiece item : lstDespiece) {
//                if (item.getTipoProducto() == 1) {
//                    System.out.println("Puerta");
//                    System.out.println("Nombre: " + item.getNombreProducto());
//                    System.out.println("Aluminio 3 Alto: " + item.getMensajeAluminio3Alto());
//                }
//
//            }
//
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//    }
//
//    public void retirarListaVentaDetalle(String nombre) {
//        try {
//            int i = 0;
//            for (Abonodetalle listaAbono1 : this.listaAbono) {
//                if (listaAbono1.getNombrepro().equals(nombre)) {
//                    this.listaAbono.remove(i);
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Productos retirado de la lista de ventas"));
//
//                    break;
//                }
//                i++;
//            }
//            long total = 0;
//
//            for (Abonodetalle listaAbono1 : this.listaAbono) {
//                listaAbono1.setTotal(listaAbono1.getCantidad() * listaAbono1.getPrecioventa());
//                total = total + listaAbono1.getTotal();
//
//            }
//            this.abonos.setPrecioTotal(total);
////            this.abonos.setSaldofinal(this.abonos.getPrecioTotal() - this.abonos.getMontoabono());
//
////            RequestContext.getCurrentInstance().update("frmFactura:tablaProductosFactura frmFactura:gripTotalFactura");
//            RequestContext.getCurrentInstance().update("frmAbono:mensajeGeneral");
//
//        } catch (Exception ex) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
//        }
//    }
//
//    public void calcular() {
//        long total = 0;
//        for (Abonodetalle listaAbono1 : listaAbono) {
//            listaAbono1.setTotal(listaAbono1.getCantidad() * listaAbono1.getPrecioventa());
//            total = total + listaAbono1.getTotal();
//        }
//        this.abonos.setPrecioTotal(total);
////      this.abonos.setSaldofinal(this.abonos.getSaldofinal() - this.abonos.getPrecioTotal());
//    }
//
//    public String convertFecha(Date fecha) {
//        if (fecha != null) {
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//            return format.format(fecha);
//        }
//        return "";
//    }
//
//    public List<Abonodetalle> getByIdFactura() {
//        this.session = null;
//        this.transaccion = null;
//
//        try {
//
//            DaoAbonos daoAbonos = new DaoAbonos();
//            DaoAbonoDetalle daoAbonoDetalle = new DaoAbonoDetalle();
//
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//
//            this.abonos = daoAbonos.getById(this.session, Integer.valueOf(sesson.getAttribute("idfactura").toString()));
//            List<Abonodetalle> listaVenta = daoAbonoDetalle.getAllByIdFactura(this.session, this.abonos.getIdabonos());
//            this.transaccion.commit();
//            return listaVenta;
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//            return null;
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//    }
//
//    public Abonos getFacturaActual() {
//        this.session = null;
//        this.transaccion = null;
//
//        try {
//            DaoAbonos daoAbonos = new DaoAbonos();
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            this.abonos = daoAbonos.getById(this.session, Integer.valueOf(sesson.getAttribute("idfactura").toString()));
//
//            this.transaccion.commit();
//            return this.abonos;
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//            return null;
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//
//        }
//    }
//
//    public List<Abonos> getAll() {
//        this.session = null;
//        this.transaccion = null;
//        try {
//
//            DaoAbonos daoAbonos = new DaoAbonos();
//
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            this.listaAbonoSel = daoAbonos.getAll(this.session);
//            this.transaccion.commit();
//            return this.listaAbonoSel;
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));
//
//            return null;
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public List<Abonos> getListVentasByFecha() {
//        if (listaVentasByFecha == null) {
//            listaVentasByFecha = new ArrayList<>();
//        }
//        return listaVentasByFecha;
//    }
//
//    public void consultarVentas() {
//        this.session = null;
//        this.transaccion = null;
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//
//            DaoAbonos daoAbonos = new DaoAbonos();
//            this.listaVentasByFecha = daoAbonos.getAllFecha(this.session, this.fechaInicio, this.fechaFin);
//
//            totalVentasFecha = 0;
//            for (Abonos abono : listaVentasByFecha) {
//                totalVentasFecha = totalVentasFecha + (abono.getMontoabono());
//            }
//            this.transaccion.commit();
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public void selectAbono(int id) {
//        this.idAbono = id;
//    }
//
//    public void searchByDocumento() {
//        this.listaAbonoSel = new ArrayList<>();
//        this.session = null;
//        this.transaccion = null;
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = this.session.beginTransaction();
//            DaoCliente daoCliente = new DaoCliente();
//            DaoAbonos daoAbonos = new DaoAbonos();
//            this.cliente = daoCliente.getByNumeroDocumento(this.session, this.numeroDocumento);
//            this.listaAbonoSel.addAll(daoAbonos.getAllByCliente(this.session, this.numeroDocumento));
//
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Contacte con su administrador" + e.getMessage()));
//            this.listaAbonoSel = null;
//            this.cliente = null;
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//                this.session.close();
//            }
//        }
//    }
//
//    //    aqui comienza el codigo nuevo 
//    public void agregarDatosCliente(Integer codCliente) {
//        this.session = null;
//        this.transaccion = null;
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//
//            DaoCliente daoCliente = new DaoCliente();
//            this.transaccion = this.session.beginTransaction();
//            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente
//            this.cliente = daoCliente.getById(this.session, codCliente);
//
//            this.transaccion.commit();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
//        } catch (Exception e) {
//            if (this.transaccion != null) {
//                System.out.println(e.getMessage());
//                transaccion.rollback();
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));
//
//            }
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public void agregarDatosCliente2() {
//        this.session = null;
//        this.transaccion = null;
//        try {
//
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            DaoCliente daoCliente = new DaoCliente();
//            this.transaccion = this.session.beginTransaction();
//            //obtener los datos del producto en la variable objecto cliente segun el codigo del cliente
//
//            this.cliente = daoCliente.getById(this.session, this.codigoCliente);
//
////            if (this.cliente != null) {
////                this.codigoCliente = null;
////                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Cliente Agregado"));
////
////            } else {
////                this.codigoCliente = null;
////                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El cliente no fue encontrado"));
////            }
//            this.transaccion.commit();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
//        } catch (Exception e) {
//            if (this.transaccion != null) {
//                System.out.println(e.getMessage());
//                transaccion.rollback();
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));
//
//            }
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public void limpiarAbonos() {
//        this.cliente = new Cliente();
//        this.empleado = new Empleado();
//        this.abonos = new Abonos();
//        this.listaAbono = new ArrayList<>();
//        this.listaFactura = new ArrayList<>();
//        this.montoAbono = 0;
//
////        invocar el metodo para destivar controles en a factura
//        this.disableButton();
//
//    }
//
//    public void agregarDatosEmpleado(Integer codEmpleado) {
//        this.session = null;
//        this.transaccion = null;
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//
//            DaoEmpleado daoEmpleado = new DaoEmpleado();
//            this.transaccion = this.session.beginTransaction();
//            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente
//
//            this.empleado = daoEmpleado.getById(this.session, codEmpleado);
//
//            this.transaccion.commit();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
//        } catch (Exception e) {
//            if (this.transaccion != null) {
//                System.out.println(e.getMessage());
//                transaccion.rollback();
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));
//
//            }
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public void agregarDatosEmpleado2() {
//        this.session = null;
//        this.transaccion = null;
//        try {
//
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            DaoEmpleado daoEmpleado = new DaoEmpleado();
//            this.transaccion = this.session.beginTransaction();
//            //obtener los datos del producto en la variable objecto cliente segun el codigo del cliente
//
//            this.empleado = daoEmpleado.getById(this.session, this.codigoEmpleado);
//
////            if (this.empleado != null) {
//////                this.codigoEmpleado = null;
////                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Cliente Agregado"));
////
////            } else {
////                this.codigoCliente = null;
////                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El cliente no fue encontrado"));
////            }
//            this.transaccion.commit();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
//        } catch (Exception e) {
//            if (this.transaccion != null) {
//                System.out.println(e.getMessage());
//                transaccion.rollback();
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));
//
//            }
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public List<Cliente> getAllClientes() {
//        this.session = null;
//        this.transaccion = null;
//
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//
//            DaoCliente daoCliente = new DaoCliente();
//
//            this.transaccion = this.session.beginTransaction();
//
//            this.listaClientes = daoCliente.getAll(this.session);
//
//            this.transaccion.commit();
//
//            return this.listaClientes;
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
//
//            return null;
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public List<Empleado> getAllEmpleado() {
//        this.session = null;
//        this.transaccion = null;
//
//        try {
//            this.session = HibernateUtil.getSessionFactory().openSession();
//
//            DaoEmpleado daoEmpleado = new DaoEmpleado();
//            this.transaccion = this.session.beginTransaction();
//
//            this.listaEmpleado = daoEmpleado.getAll(this.session);
//
//            this.transaccion.commit();
//
//            return this.listaEmpleado;
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
//
//            return null;
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//    }
//
//    public void onRowEdit(RowEditEvent Event) {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO:", "Producto editado "));
//
////                invocamos al metodo calculartotalfactura para actualizar la factura
//        this.calcular();
//    }
//
//    public void onRowEditCancel(RowEditEvent event) {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "...:", "No se hizo ningun cambio "));
//
//    }
//
////    metodos para activar o desativar los botnes del sistema
//    private boolean enabled;
//
//    public boolean isEnabled() {
//        return enabled;
//
//    }
//
//    public void enebleButton() {
//        enabled = true;
//    }
//
//    public void disableButton() {
//        enabled = false;
//    }
//
//    public Abonodetalle getAbonoDeta() {
//        return abonoDeta;
//    }
//
//    public void setAbonoDeta(Abonodetalle abonoDeta) {
//        this.abonoDeta = abonoDeta;
//    }
//
//    public ArrayList<Abonodetalle> getListaAbono() {
//        return listaAbono;
//    }
//
//    public void setListaAbono(ArrayList<Abonodetalle> listaAbono) {
//        this.listaAbono = listaAbono;
//    }
//
//    public ArrayList<Abonodetalle> getListaFactura() {
//        return listaFactura;
//    }
//
//    public void setListaFactura(ArrayList<Abonodetalle> listaFactura) {
//        this.listaFactura = listaFactura;
//    }
//
//    public ArrayList<Materiales> getLista() {
//        return lista;
//    }
//
//    public void setLista(ArrayList<Materiales> lista) {
//        this.lista = lista;
//    }
//
//    public int getTipoVidrio() {
//        return tipoVidrio;
//    }
//
//    public void setTipoVidrio(int tipoVidrio) {
//        this.tipoVidrio = tipoVidrio;
//    }
//
//    public int getTipoVentana() {
//        return tipoVentana;
//    }
//
//    public void setTipoVentana(int tipoVentana) {
//        this.tipoVentana = tipoVentana;
//    }
//
//    public String getAncho() {
//        return ancho;
//    }
//
//    public void setAncho(String ancho) {
//        this.ancho = ancho;
//    }
//
//    public String getAlto() {
//        return alto;
//    }
//
//    public void setAlto(String alto) {
//        this.alto = alto;
//    }
//
//    public int getGanancia() {
//        return ganancia;
//    }
//
//    public void setGanancia(int ganancia) {
//        this.ganancia = ganancia;
//    }
//
//    public int getManObra() {
//        return manObra;
//    }
//
//    public void setManObra(int manObra) {
//        this.manObra = manObra;
//    }
//
//    public Abonos getAbonos() {
//        return abonos;
//    }
//
//    public void setAbonos(Abonos abonos) {
//        this.abonos = abonos;
//    }
//
//    public List<Abonos> getListaAbonoSel() {
//        return listaAbonoSel;
//    }
//
//    public void setListaAbonoSel(List<Abonos> listaAbonoSel) {
//        this.listaAbonoSel = listaAbonoSel;
//    }
//
//    public String getNumeroDocumento() {
//        return numeroDocumento;
//    }
//
//    public void setNumeroDocumento(String numeroDocumento) {
//        this.numeroDocumento = numeroDocumento;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public List<Abonos> getListaVentasByFecha() {
//        return listaVentasByFecha;
//    }
//
//    public void setListaVentasByFecha(List<Abonos> listaVentasByFecha) {
//        this.listaVentasByFecha = listaVentasByFecha;
//    }
//
//    public String getIdCliente() {
//        return idCliente;
//    }
//
//    public void setIdCliente(String idCliente) {
//        this.idCliente = idCliente;
//    }
//
//    public int getIdEmpleado() {
//        return idEmpleado;
//    }
//
//    public void setIdEmpleado(int idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }
//
//    public long getPrecioVidrio() {
//        return precioVidrio;
//    }
//
//    public void setPrecioVidrio(long precioVidrio) {
//        this.precioVidrio = precioVidrio;
//    }
//
//    public int getIdVidrio() {
//        return idVidrio;
//    }
//
//    public void setIdVidrio(int idVidrio) {
//        this.idVidrio = idVidrio;
//    }
//
//    public Date getFechaFin() {
//        return fechaFin;
//    }
//
//    public void setFechaFin(Date fechaFin) {
//        this.fechaFin = fechaFin;
//    }
//
//    public Date getFechaInicio() {
//        return fechaInicio;
//    }
//
//    public void setFechaInicio(Date fechaInicio) {
//        this.fechaInicio = fechaInicio;
//    }
//
//    public long getTotalVentasFecha() {
//        return totalVentasFecha;
//    }
//
//    public void setTotalVentasFecha(long totalVentasFecha) {
//        this.totalVentasFecha = totalVentasFecha;
//    }
//
//    public List<Abonos> getListaAbonosFiltrado() {
//        return listaAbonosFiltrado;
//    }
//
//    public void setListaAbonosFiltrado(List<Abonos> listaAbonosFiltrado) {
//        this.listaAbonosFiltrado = listaAbonosFiltrado;
//    }
//
//    public long getMontoAbono() {
//        return montoAbono;
//    }
//
//    public void setMontoAbono(long montoAbono) {
//        this.montoAbono = montoAbono;
//    }
//
//    public int getIdAbono() {
//        return idAbono;
//    }
//
//    public void setIdAbono(int idAbono) {
//        this.idAbono = idAbono;
//    }
//
//    public List<Abonosecundario> getListaAbonoSecundario() {
//        return listaAbonoSecundario;
//    }
//
//    public void setListaAbonoSecundario(List<Abonosecundario> listaAbonoSecundario) {
//        this.listaAbonoSecundario = listaAbonoSecundario;
//    }
//
//    public int getIdAbonoSecundario() {
//        return idAbonoSecundario;
//    }
//
//    public void setIdAbonoSecundario(int idAbonoSecundario) {
//        this.idAbonoSecundario = idAbonoSecundario;
//    }
//
//    public int getProductoTipo() {
//        return productoTipo;
//    }
//
//    public void setProductoTipo(int productoTipo) {
//        this.productoTipo = productoTipo;
//    }
//
//    public String getFondo() {
//        return fondo;
//    }
//
//    public void setFondo(String fondo) {
//        this.fondo = fondo;
//    }
//
//    public int getTipoPuerta() {
//        return tipoPuerta;
//    }
//
//    public void setTipoPuerta(int tipoPuerta) {
//        this.tipoPuerta = tipoPuerta;
//    }
//
//    public int getTipoVitrina() {
//        return tipoVitrina;
//    }
//
//    public void setTipoVitrina(int tipoVitrina) {
//        this.tipoVitrina = tipoVitrina;
//    }
//
//    public int getTipoEntrepanos() {
//        return tipoEntrepanos;
//    }
//
//    public void setTipoEntrepanos(int tipoEntrepanos) {
//        this.tipoEntrepanos = tipoEntrepanos;
//    }
//
//    public String getNombreProducto() {
//        return nombreProducto;
//    }
//
//    public void setNombreProducto(String nombreProducto) {
//        this.nombreProducto = nombreProducto;
//    }
//
//    public long getPrecioTotal() {
//        return precioTotal;
//    }
//
//    public void setPrecioTotal(long precioTotal) {
//        this.precioTotal = precioTotal;
//    }
//
//    public int getTipoAluminio() {
//        return tipoAluminio;
//    }
//
//    public void setTipoAluminio(int tipoAluminio) {
//        this.tipoAluminio = tipoAluminio;
//    }
//
//    public Abonos getAbonoSelect() {
//        return abonoSelect;
//    }
//
//    public void setAbonoSelect(Abonos abonoSelect) {
//        this.abonoSelect = abonoSelect;
//    }
//
//    public Empleado getEmpleado() {
//        return empleado;
//    }
//
//    public void setEmpleado(Empleado empleado) {
//        this.empleado = empleado;
//    }
//
//    public int getCodigoCliente() {
//        return codigoCliente;
//    }
//
//    public void setCodigoCliente(int codigoCliente) {
//        this.codigoCliente = codigoCliente;
//    }
//
//    public int getCodigoEmpleado() {
//        return codigoEmpleado;
//    }
//
//    public void setCodigoEmpleado(int codigoEmpleado) {
//        this.codigoEmpleado = codigoEmpleado;
//    }
//
//    public List<Cliente> getListaClientes() {
//        return listaClientes;
//    }
//
//    public void setListaClientes(List<Cliente> listaClientes) {
//        this.listaClientes = listaClientes;
//    }
//
//    public List<Empleado> getListaEmpleado() {
//        return listaEmpleado;
//    }
//
//    public void setListaEmpleado(List<Empleado> listaEmpleado) {
//        this.listaEmpleado = listaEmpleado;
//    }
//
//    public int getTipoProductos() {
//        return tipoProductos;
//    }
//
//    public void setTipoProductos(int tipoProductos) {
//        this.tipoProductos = tipoProductos;
//    }
//
//    public List<Despiece> getLstDespiece() {
//        return lstDespiece;
//    }
//
//    public void setLstDespiece(List<Despiece> lstDespiece) {
//        this.lstDespiece = lstDespiece;
//    }
//
//    public int getTipoAluminioPuerta() {
//        return tipoAluminioPuerta;
//    }
//
//    public void setTipoAluminioPuerta(int tipoAluminioPuerta) {
//        this.tipoAluminioPuerta = tipoAluminioPuerta;
//    }
//
//    public int getTipoColorVitrina() {
//        return tipoColorVitrina;
//    }
//
//    public void setTipoColorVitrina(int tipoColorVitrina) {
//        this.tipoColorVitrina = tipoColorVitrina;
//    }
//
//    public int getPrecioAccesorios() {
//        return precioAccesorios;
//    }
//
//    public void setPrecioAccesorios(int precioAccesorios) {
//        this.precioAccesorios = precioAccesorios;
//    }
//
//    public int getCantidadProducto() {
//        return cantidadProducto;
//    }
//
//    public void setCantidadProducto(int cantidadProducto) {
//        this.cantidadProducto = cantidadProducto;
//    }
//
//    public int getTipoColor() {
//        return tipoColor;
//    }
//
//    public void setTipoColor(int tipoColor) {
//        this.tipoColor = tipoColor;
//    }
//
//    public int getTipoModeloVentana() {
//        return tipoModeloVentana;
//    }
//
//    public void setTipoModeloVentana(int tipoModeloVentana) {
//        this.tipoModeloVentana = tipoModeloVentana;
//    }
//
//    public int getTipoNaves() {
//        return tipoNaves;
//    }
//
//    public void setTipoNaves(int tipoNaves) {
//        this.tipoNaves = tipoNaves;
//    }
//
//    public int getTipo3Naves() {
//        return tipo3Naves;
//    }
//
//    public void setTipo3Naves(int tipo3Naves) {
//        this.tipo3Naves = tipo3Naves;
//    }
//
//    public int getTipo4Naves() {
//        return tipo4Naves;
//    }
//
//    public void setTipo4Naves(int tipo4Naves) {
//        this.tipo4Naves = tipo4Naves;
//    }
//
//    public int getTipo5Naves() {
//        return tipo5Naves;
//    }
//
//    public void setTipo5Naves(int tipo5Naves) {
//        this.tipo5Naves = tipo5Naves;
//    }
//  
//}
