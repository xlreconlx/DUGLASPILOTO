/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MbView;

import Clases.Puerta;
import Clases.Vitrina;
import Daos.DaoAbonoDetalle;
import Clases.Despiece;
import Clases.DespiecePuerta;
import Clases.DespieceVentana;
import Clases.ImprimeDespiece;
import Clases.PuertaBatiente;
import Clases.PuertaCorrediza;
import Clases.PuertaPoket;
import Clases.Puertas;
import Clases.VentanaAbati;
import Clases.VentanaCorre;
import Clases.VentanaProyec;
import Daos.DaoAbonos;
import Daos.DaoAccesorios;
import Daos.DaoCliente;
import Daos.DaoEmpleado;
import Daos.DaoManoObra;
import Daos.DaoMaterial;
import Daos.DaoProductos;
import Daos.DaoVidrio;
import HibernateUtil.HibernateUtil;
import Pojos.Abonodetalle;
import Pojos.Abonos;
import Pojos.Abonosecundario;
import Pojos.Accesorios;
import Pojos.Cliente;
import Pojos.Empleado;
import Pojos.Materiales;
import Pojos.Ventanadetalle;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import java.io.StringReader;
import java.text.SimpleDateFormat;
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
import org.primefaces.model.UploadedFile;

/**
 *
 * @author William Sanchez
 */
@ManagedBean
@ViewScoped
public class MbAbonos {

    /**
     * Creates a new instance of MbAbonos
     */
    private Session session;
    private Transaction transaccion;

    private Abonodetalle abonoDeta;
    private ArrayList<Abonodetalle> listaAbono;
    private ArrayList<Abonodetalle> listaFactura;
    private ArrayList<Materiales> lista;
    private List<Abonos> listaAbonosFiltrado;
    private int tipoVidrio;
    private int tipoVentana;
    private String ancho;
    private String alto;
    private int ganancia;
    private int manObra;
    private Abonos abonos;
    private List<Abonos> listaAbonoSel;
    private List<Abonos> listaVentasByFecha;
    private String idCliente;
    private int idEmpleado;
    private int idAbono;
    private long precioVidrio;
    private int precioAccesorios;
    private int idVidrio;
    private Date fechaFin;
    private Date fechaInicio;
    private long totalVentasFecha;
    private long montoAbono;
    private List<Abonosecundario> listaAbonoSecundario;
    private int idAbonoSecundario;
    private int productoTipo;
    private int tipoProductos;
    private String fondo;
    private int tipoPuerta;
    private int tipoVitrina;
    private int tipoEntrepanos;
    private String nombreProducto;
    private long precioTotal;
    private int tipoAluminio;
    private int tipoAluminioProy;
    private int tipoAluminioCorred;
    private int tipoAluminioBati;
    private int tipoAlumPuertaBat;
    private int tipoAlumPuertaCor;
   private int tipoAlumPuertaPok;
    private String numeroDocumento;
    private Cliente cliente;
    private Abonos abonoSelect;
    private Empleado empleado;
    private int codigoCliente;
    private int codigoEmpleado;
    private List<Despiece> lstDespiece;
    private int tipoAluminioPuerta;
    private int tipoColorVitrina;
    private int cantidadProducto;
    private int tipoColor;
    private int diseñoVentana;
    private int tipoModeloVentana;
        private int tipoModeloPuerta;
    private int precioInstalacion;
    private int diseno;
      private String altoFijo;
    private String anchoFijo;

    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleado;

    public MbAbonos() {
        this.lstDespiece = new ArrayList<>();
        this.listaVentasByFecha = new ArrayList<>();
        this.listaAbonoSel = new ArrayList<>();
        this.lista = new ArrayList<>();
        this.listaAbono = new ArrayList<>();
        this.listaFactura = new ArrayList<>();
        this.abonos = new Abonos();
        this.abonoDeta = new Abonodetalle();
        this.listaAbonoSecundario = new ArrayList<>();
        this.empleado = new Empleado();
        this.listaClientes = new ArrayList<>();
        this.listaEmpleado = new ArrayList<>();
        this.cliente = new Cliente();
        this.idVidrio = 0;
        this.ganancia = 0;
        this.alto = "";
        this.ancho = "";
        this.manObra = 0;
        this.tipoVentana = 0;
        this.tipoPuerta = 0;
        this.tipoVidrio = 0;
        this.tipoVitrina = 0;
        this.fondo = "";
        this.productoTipo = 0;
        this.tipoEntrepanos = 0;
        this.tipoAluminioPuerta = 0;
           this.precioInstalacion=0;
    }

    public void agregarProducto() {
        switch (this.tipoProductos) {
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
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto"));
                break;
        }
    }

    public void calcularVitrina() {
        this.session = null;
        this.transaccion = null;
        Vitrina vitrina = new Vitrina();
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            DaoProductos daoProductos = new DaoProductos();

            DaoMaterial daoMaterial = new DaoMaterial();
            this.lista.addAll(daoMaterial.getAll(this.session));

            if (this.tipoColorVitrina == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Seleccione un tipo de aluminio"));
                return;
            }

            int idProdVitrina = 0;
            switch (tipoVitrina) {
                case 1:
                    idProdVitrina = 7;
                    break;
                case 2:
                    idProdVitrina = 11;
                    break;
                case 3:
                    idProdVitrina = 12;
                    break;

            }

            String nombreAluminio = "";
            switch (tipoColorVitrina) {
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

            if (this.tipoVitrina == 1) {
//                vitrina de angulo de 1 1/2 con acoples

                vitrina = new Vitrina(this.ancho, this.alto, this.fondo, this.manObra, this.ganancia,
                        this.lista.get(36).getPreciocost(), this.lista.get(37).getPreciocost(),
                        this.lista.get(38).getPreciocost(), this.lista.get(41).getPreciocost(),
                        this.lista.get(39).getPreciocost(), this.lista.get(40).getPreciocost(),
                        this.lista.get(42).getPreciocost(), this.lista.get(43).getPreciocost(), this.tipoVitrina);

                //  
            } else {
                if (this.tipoVitrina == 2) {
//                        vitrina de angulo de 1  y rodamientos sencillos
                    vitrina = new Vitrina(this.ancho, this.alto, this.fondo, this.manObra, this.ganancia,
                            this.lista.get(36).getPrecioAnonizado(), this.lista.get(37).getPrecioAnonizado(),
                            this.lista.get(38).getPrecioAnonizado(), this.lista.get(41).getPrecioAnonizado(),
                            this.lista.get(39).getPrecioAnonizado(), this.lista.get(40).getPrecioAnonizado(),
                            this.lista.get(42).getPrecioAnonizado(), this.lista.get(43).getPrecioAnonizado(), this.tipoVitrina);

                } else {
                    if (this.tipoVitrina == 3) {
//                           vitrina de angulo de 1 , rodamientos sencillos y largo de mas de 135cm
                        vitrina = new Vitrina(this.ancho, this.alto, this.fondo, this.manObra, this.ganancia,
                                this.lista.get(36).getPrecioPintura(), this.lista.get(37).getPrecioPintura(),
                                this.lista.get(38).getPrecioPintura(), this.lista.get(41).getPrecioPintura(),
                                this.lista.get(39).getPrecioPintura(), this.lista.get(40).getPrecioPintura(),
                                this.lista.get(42).getPrecioPintura(), this.lista.get(43).getPrecioPintura(), this.tipoVitrina);

                    }
                }
            }

            if (this.idVidrio != 0) {
                int vidrioEntrepano = 0;
                DaoVidrio daoVidrio = new DaoVidrio();

                this.precioVidrio = daoVidrio.getById(this.session, this.idVidrio).getPreciocost();
                vidrioEntrepano = daoVidrio.getById(this.session, 6).getPreciocost();
                long precFondos = this.precioVidrio * (vitrina.getAlto() * vitrina.getFondo());
                precFondos = precFondos * 2;
                long precFondoAncho = this.precioVidrio * (vitrina.getAncho() * vitrina.getFondo());
                precFondoAncho = precFondoAncho * 2;
                this.precioVidrio = this.precioVidrio * (vitrina.getAlto() * vitrina.getAncho());
                this.precioVidrio = this.precioVidrio * 2;
                this.precioVidrio = this.precioVidrio + precFondos + precFondoAncho;

                if (this.tipoEntrepanos == 1) {
                    vidrioEntrepano = vidrioEntrepano * (vitrina.getAncho() * vitrina.getFondo() * 3);
                } else {
                    if (this.tipoEntrepanos == 2) {
                        vidrioEntrepano = vidrioEntrepano * (vitrina.getAncho() * vitrina.getFondo() * 4);
                    }
                }

                // this.precioVidrio=this.precioVidrio+(this.precioVidrio*50/100);
                this.precioVidrio = this.precioVidrio + vidrioEntrepano;
                this.precioVidrio = this.precioVidrio + (this.precioVidrio / 2);
                int espacios = String.valueOf(this.precioVidrio).length();
                this.precioVidrio = Integer.valueOf(String.valueOf(this.precioVidrio).substring(0, espacios - 4));

            } else {
                if (this.idVidrio == 0) {
                    this.precioVidrio = 0;
                }
            }
            if (this.tipoVitrina == 1) {
                DaoAccesorios daoAcessorios = new DaoAccesorios();

                int pianas = 0;
                int rodamientoPiso = 0;
                int rodamientoDucha = 0;
                int acoples = 0;

                Accesorios accseso = new Accesorios();
                accseso = daoAcessorios.getById(this.session, 18);

                if (accseso.getCantidad() > 8) {
                    //Se envia mensaje de que no hay la cantidad
                    return;
                }
                accseso.setCantidad(accseso.getCantidad() - 8);
                daoAcessorios.actualizar(this.session, accseso);

                pianas = accseso.getPrecioCosto() * 8;
                rodamientoPiso = daoAcessorios.getById(this.session, 4).getPrecioCosto() * 4;
                rodamientoDucha = daoAcessorios.getById(this.session, 6).getPrecioCosto() * 4;
                acoples = daoAcessorios.getById(this.session, 15).getPrecioCosto() * 8;

                this.precioAccesorios = pianas + rodamientoPiso + rodamientoDucha + acoples;

            } else {
                if (this.tipoVitrina == 2) {
                    DaoAccesorios daoAcessorios = new DaoAccesorios();

                    int pianas = 0;
                    int rodamientoEconomco = 0;
                    int anclajeA15 = 0;

                    pianas = daoAcessorios.getById(this.session, 18).getPrecioCosto() * 8;
                    rodamientoEconomco = daoAcessorios.getById(this.session, 5).getPrecioCosto() * 4;
                    anclajeA15 = daoAcessorios.getById(this.session, 22).getPrecioCosto() * 8;
                    this.precioAccesorios = pianas + rodamientoEconomco + anclajeA15;
                } else {
                    if (this.tipoVitrina == 3) {
                        DaoAccesorios daoAcessorios = new DaoAccesorios();

                        int pianas = 0;
                        int rodamientoEconomco = 0;
                        int anclajeA15 = 0;

                        pianas = daoAcessorios.getById(this.session, 18).getPrecioCosto() * 16;
                        rodamientoEconomco = daoAcessorios.getById(this.session, 5).getPrecioCosto() * 4;
                        anclajeA15 = daoAcessorios.getById(this.session, 22).getPrecioCosto() * 8;
                        this.precioAccesorios = pianas + rodamientoEconomco + anclajeA15;

                    }
                }

            }

            if (this.tipoVitrina < 4 && this.tipoVitrina > 0) {

                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idProdVitrina),
                        daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho + " fondo: " + this.fondo,
                        this.cantidadProducto, vitrina.getSumaTotal() + this.precioVidrio + this.precioAccesorios, this.cantidadProducto * vitrina.getSumaTotal()
                        + this.precioVidrio + this.precioAccesorios, this.manObra, this.ganancia, this.alto, this.ancho, this.fondo));
            }

            if (this.tipoVitrina == 1) {
                //Se agregan a la variable despiece
                //a el final se añade a la lista
                //luego cuando le den generar se debe crear un metodo que recorra y valide cual tipo de producto es
                Despiece despie = new Despiece();

                despie.setNombreProducto(nombreProducto);
                despie.setCantProducto(this.cantidadProducto);
                despie.setRecorteFondo(Double.valueOf(this.getFondo()));
                despie.setCantidadCuartoCirculoAlto(4 * this.cantidadProducto);
                despie.setCantidadCuartoCirculoAncho(4 * this.cantidadProducto);
                despie.setCantidadCuartoCirculoFondo(4 * this.cantidadProducto);
                despie.setCantidadAnguloMediaAlto(6 * this.cantidadProducto);
                despie.setCantidadAnguloMediaAncho(6 * this.cantidadProducto);
                despie.setCantidadAnguloMediaFondo(6 * this.cantidadProducto);
                despie.setCantidadNaveDivisionAncho(2 * this.cantidadProducto);
                despie.setCantidadVidrio(2 * this.cantidadProducto);
                despie.setCantidadVidrioEntrepanos(4 * this.cantidadProducto);

                despie.setMensajeCuartoCirculoAlto(despie.getCantidadCuartoCirculoAlto() + " Aluminio CuartoCirculo Alto de:" + (Double.valueOf(this.getAlto()) - 8.0));
                despie.setMensajeCuartoCirculoAncho(despie.getCantidadCuartoCirculoAncho() + "Alumininio CuartoCirculo Ancho de: " + (Double.valueOf(this.getAncho()) - 8.0));
                despie.setMensajeCuartoCirculoFondo(despie.getCantidadCuartoCirculoFondo() + "Alumininio CuartoCirculo Fondo de: " + (Double.valueOf(this.getFondo()) - 8.0));
                despie.setMensajeAnguloMediaAlto(despie.getCantidadAnguloMediaAlto() + "  AnguloMedia Alto de " + (Double.valueOf(this.getAlto()) - 8));
                despie.setMensajeAnguloMediaAncho(despie.getCantidadAnguloMediaAncho() + " AnguloMedia Ancho de:  " + (Double.valueOf(this.getAncho()) - 10));
                despie.setMensajeAnguloMediaFondo(despie.getCantidadAnguloMediaFondo() + " AnguloMedia Fondo de:  " + (Double.valueOf(this.getFondo()) - 10));
                despie.setMensajeNaveDivisionAncho(despie.getCantidadNaveDivisionAncho() + "Nave DivisionBano Ancho de:  " + (Double.valueOf(this.getAncho()) / 2));
                despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + " recorte ancho  " + (Double.valueOf(this.getAncho()) - 10.5));
                despie.setMensajeVidrioAltoFondo(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + "Recorte fondo" + (Double.valueOf(this.getFondo()) - 10.5));
                despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrioEntrepanos() + "  Vidrios de 6mm Ancho " + (Double.valueOf(this.getAncho()) - 1) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 8.5));
                despie.setNombreProducto(daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
                despie.setTipoProducto(42);
                lstDespiece.add(despie);
            } else {
                if (this.tipoVitrina == 2) {
                    Despiece despie = new Despiece();

                    despie.setNombreProducto(nombreProducto);
                    despie.setCantProducto(this.cantidadProducto);
                    despie.setCantidadPerfilEsquineroUnaAncho(4 * this.cantidadProducto);
                    despie.setCntidadPerfilEsquineroUnaFondo(2 * this.cantidadProducto);
                    despie.setCantidadAnguloMediaAlto(4 * this.cantidadProducto);
                    despie.setCantidadAnguloMediaAncho(2 * this.cantidadProducto);
                    despie.setCantidadAnguloMediaFondo(2 * this.cantidadProducto);
                    despie.setCantidadNaveDivisionAncho(2 * this.cantidadProducto);
                    despie.setCantidadNaveAncho(2 * this.cantidadProducto);
                    despie.setCantidadVidrio(2 * this.cantidadProducto);
                    despie.setPisaVidrioAlto(6 * this.cantidadProducto);
                    despie.setPisaVidrioAncho(6 * this.cantidadProducto);
                    despie.setPisaVidrioFondo(6 * this.cantidadProducto);

                    despie.setMensajePerfilEsquineroUna(despie.getCantidadPerfilEsquineroUnaAncho() + " Perfil o de Una Ancho de: " + (Double.valueOf(this.getAncho())));
                    despie.setMensajePerfilEsquineroUnaFondo(despie.getCntidadPerfilEsquineroUnaFondo() + " Perfil Esquinero de Una Fondo de: " + (Double.valueOf(this.getFondo())));
                    despie.setMensajeAnguloMediaAlto(despie.getCantidadAnguloMediaAlto() + "  Tubular 1 * 1 Alto de " + (Double.valueOf(this.getAlto()) - 5));
                    despie.setMensajeAnguloMediaAncho(despie.getCantidadAnguloMediaAncho() + " Tubular 1 * 1 Ancho de:  " + (Double.valueOf(this.getAncho()) - 5));
                    despie.setMensajeAnguloMediaFondo(despie.getCantidadAnguloMediaFondo() + " Tubular 1 * 1 Fondo de:  " + (Double.valueOf(this.getFondo()) - 5));
                    despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Pisavidrio de Media de: " + (Double.valueOf(this.getAlto())));
                    despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Pisavidrio de Media Alto de: " + (Double.valueOf(this.getAncho())));
                    despie.setMensajePisavidrioFondo(despie.getPisaVidrioFondo() + " Pisavidrio de Media Ancho de: " + (Double.valueOf(this.getFondo())));
                    despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + "Nave DivisionBano Ancho Fondo de:  " + (Double.valueOf(this.getAncho()) / 2));
                    despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + " recorte ancho  " + (Double.valueOf(this.getAncho()) - 10.5));
                    despie.setMensajeVidrioAltoFondo(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + "Recorte fondo" + (Double.valueOf(this.getFondo()) - 10.5));
                    despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrio() + "  Vidrios Ancho " + (Double.valueOf(this.getAncho()) - 10.5) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
                    despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrioEntrepanos() + "  Vidrios de 6mm Ancho " + (Double.valueOf(this.getAncho()) - 1) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
                    despie.setNombreProducto(daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
                    despie.setTipoProducto(43);
                    lstDespiece.add(despie);
                } else {
                    if (this.tipoVitrina == 3) {
                        Despiece despie = new Despiece();

                        despie.setNombreProducto(nombreProducto);
                        despie.setCantProducto(this.cantidadProducto);
                        despie.setCantidadPerfilEsquineroUnaAncho(2 * this.cantidadProducto);
                        despie.setCntidadPerfilEsquineroUnaFondo(2 * this.cantidadProducto);
                        despie.setCantidadAnguloMediaAlto(6 * this.cantidadProducto);
                        despie.setCantidadAnguloMediaAncho(2 * this.cantidadProducto);
                        despie.setCantidadAnguloMediaFondo(2 * this.cantidadProducto);
                        despie.setCantidadNaveDivisionAncho(2 * this.cantidadProducto);
                        despie.setCantidadNaveAncho(2 * this.cantidadProducto);
                        despie.setCantidadVidrioEntrepanos(4 * this.cantidadProducto);
                        despie.setCantidadVidrio(2 * this.cantidadProducto);
                        despie.setPisaVidrioAlto(6 * this.cantidadProducto);
                        despie.setPisaVidrioAncho(6 * this.cantidadProducto);
                        despie.setPisaVidrioFondo(6 * this.cantidadProducto);

                        despie.setMensajePerfilEsquineroUna(despie.getCantidadPerfilEsquineroUnaAncho() + " Perfil o de Una Ancho de: " + (Double.valueOf(this.getAncho())));
                        despie.setMensajePerfilEsquineroUnaFondo(despie.getCntidadPerfilEsquineroUnaFondo() + " Perfil Esquinero de Una Fondo de: " + (Double.valueOf(this.getFondo())));
                        despie.setMensajeAnguloMediaAlto(despie.getCantidadAnguloMediaAlto() + " AnguloMedia Alto de  " + (Double.valueOf(this.getAlto()) - 8));
                        despie.setMensajeAnguloMediaAncho(despie.getCantidadAnguloMediaAncho() + " AnguloMedia Ancho de:  " + (Double.valueOf(this.getAncho()) - 10));
                        despie.setMensajeAnguloMediaFondo(despie.getCantidadAnguloMediaFondo() + " AnguloMedia Fondo de: " + (Double.valueOf(this.getFondo()) - 10));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Pisavidrio de Media de: " + (Double.valueOf(this.getAlto())));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Pisavidrio de Media Alto de: " + (Double.valueOf(this.getAncho())));
                        despie.setMensajePisavidrioFondo(despie.getPisaVidrioFondo() + " Pisavidrio de Media Ancho de: " + (Double.valueOf(this.getFondo())));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + "Nave DivisionBano Ancho Fondo de:  " + (Double.valueOf(this.getAncho()) / 2));
                        despie.setMensajeVidrioAltoAncho(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + " recorte ancho  " + (Double.valueOf(this.getAncho()) - 10.5));
                        despie.setMensajeVidrioAltoFondo(despie.getCantidadVidrio() + "  Vidrios ALto" + (Double.valueOf(this.getAlto()) - 10.5) + "Recorte fondo" + (Double.valueOf(this.getFondo()) - 10.5));
                        despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrio() + "  Vidrios Ancho " + (Double.valueOf(this.getAncho()) - 10.5) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
                        despie.setMensajeVidrioAnchoFondo(despie.getCantidadVidrioEntrepanos() + "  Vidrios de 6mm Ancho " + (Double.valueOf(this.getAncho()) - 1) + "recorte fondo" + (Double.valueOf(this.getFondo()) - 1));
                        despie.setNombreProducto(daoProductos.getById(this.session, idProdVitrina).getNombre() + " " + nombreAluminio + "  " + this.alto + "*" + this.ancho);
                        despie.setTipoProducto(44);
                        lstDespiece.add(despie);
                    }
                }
            }

            this.transaccion.commit();

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

            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void calcularPuertas() {
        this.session = null;
        this.transaccion = null;
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
            this.transaccion = this.session.beginTransaction();
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
                System.out.println("el precio del vidrio es:........" + this.precioVidrio);
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
                    this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idPuerta),
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
                    precioInstala = (precioInstala * (batiente.getAlto() * batiente.getAncho())) / 10000;
                    Long precioBati = this.precioVidrio + this.precioAccesorios + batiente.getSumaTotal();
                    precioBati = (precioBati * batiente.getPrecioDescuento() / 100) + precioBati;
               

                  this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idPuerta),
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
                    Long precioExtrac = this.precioVidrio + this.precioAccesorios + poket.getSumaTotal();
                    precioExtrac = (precioExtrac * poket.getPrecioDescuento() / 100) + precioExtrac;
                 

                   this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idPuerta),
                            modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtrac + precioInstala, this.cantidadProducto * (precioExtrac + precioInstala),
                            this.manObra, this.ganancia, this.alto, this.ancho, ""));
                    break;
            }
            if (this.idVidrio == 0) {
                this.precioVidrio = 0;
            }

            DespiecePuerta despiecePuerta = new DespiecePuerta();
            lstDespiece.add(despiecePuerta.generaDespiece(tipoModeloPuerta, tipoPuerta, tipoAluminio, cantidadProducto, alto, ancho,  modeloPuerta + " " + nombrePuerta + " " + nombreAluminio));


            this.transaccion.commit();
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
        this.transaccion = null;

        VentanaAbati abati = new VentanaAbati();
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
            this.transaccion = this.session.beginTransaction();

            this.lista.addAll(daoMaterial.getAll(this.session));

//            if (this.tipoAluminioProy == 0 || this.tipoAluminioCorred==0 || this.tipoAluminioBati==0) {
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
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
            }
            switch (tipoAluminioCorred) {
                case 1:
                    nombreAluminio = " VC AS 1700";
                    break;
                case 2:
                    nombreAluminio = " VC 3825";
                    break;
              
            }
            switch (tipoAluminioBati) {
                case 1:
                    nombreAluminio = " Aluminio batiente";
                    break;
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
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 17;
                                    acce.setCantidad(acce.getCantidad() - (17 * this.cantidadProducto));
                                    daoAccesorios.actualizar(this.session, acce);
                                    this.precioAccesorios = BrazosBasculantes + tronillos;
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
                                    break;
                                case 3:
                                    nombreVentana = "4 cuerpos 0/0/0/0/ ALFALJIA ";
                                    opcionVentana = 16;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 48;
                                    acce.setCantidad(acce.getCantidad() - (48 * this.cantidadProducto));
                                    daoAccesorios.actualizar(this.session, acce);
                                    this.precioAccesorios = tronillos;
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
                                    break;

                            }
                    }
                    break;
                case 2://Corrediza
                    switch (tipoVentana) {
                        case 1://2 cuerpos
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpo X0";
                                    opcionVentana = 22;
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
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpo XX";
                                    opcionVentana = 23;
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
                                    break;

                                //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                                //VENTANAS CORREDIZAS VC3825 OJO                  
                                case 3:
                                    //ventana corrediza vc 3825
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X0 plus basica alfa";
                                    opcionVentana = 33;
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
                                    break;
                                case 4:
                                    acce = new Accesorios();
                                    //ventana corrediza vc 3825
                                    nombreVentana = "2 cuerpos XX Alf BASICA";
                                    opcionVentana = 34;
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
                                    break;
                                case 5:
                                    acce = new Accesorios();
                                    //ventana corrediza vc 3825
                                    nombreVentana = "2 cuerpos X0 plus Reforzada";
                                    opcionVentana = 35;
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
                                    break;

                            }
                            break;
                        case 2:// 3 CUERPOS
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos X0X BASICA";
                                    opcionVentana = 24;
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
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos OXO BASICA";
                                    opcionVentana = 25;
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
                                    break;
                                case 3:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos OXX BASICA";
                                    opcionVentana = 26;
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
                                    break;
                                case 4:
                                    acce = new Accesorios();

                                    nombreVentana = "3 cuerpos X0/O";
                                    opcionVentana = 27;
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
                                    break;

                            }
                            break;
                        case 3:// 4 CUERPOS
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos OXXO BASICA";
                                    opcionVentana = 28;
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
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos X0/00 Basica Alf";
                                    opcionVentana = 29;
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
                                    break;

                                //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                                //VENTANA COREDIZA VC 3825
                                case 3:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos 0XX0 1672 DOBLE";
                                    opcionVentana = 36;
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
                                    break;

                            }
                        case 4:// 6 cuerpos
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos 0XX XXO BASICA";
                                    opcionVentana = 30;
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
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos OXO /OOO BASICA";
                                    opcionVentana = 31;
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
                                    break;

                            }
                        case 5:// 8 cuerpos
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos OXXO /OOO0 BASICA";
                                    opcionVentana = 32;
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
                                    break;

                            }
                    }

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
                                    proyec.setPrecioTrabajo(this.manObra);
                                    proyec.setPrecioDescuento(this.ganancia);
                                    proyec.setTipoProducto(opcionVentana);
                                    proyec.setPrecioCabezal(this.lista.get(131).getPreciocost());
                                    proyec.setPrecioSillar(this.lista.get(137).getPreciocost());
                                    proyec.setPrecioJamba(this.lista.get(132).getPreciocost());
                                    proyec.setPrecioAdaptador(this.lista.get(133).getPreciocost());
                                    proyec.setPrecioEmpaque(this.lista.get(354).getPreciocost());

                                    proyec.VentanaProyec(this.lista.get(134).getPreciocost(), this.lista.get(138).getPreciocost(),
                                            this.lista.get(169).getPreciocost(), this.lista.get(135).getPreciocost(),
                                            this.lista.get(343).getPreciocost(), this.lista.get(342).getPreciocost(), this.lista.get(346).getPreciocost());
                                    break;

                                case 2:// para ventanas proyectante  de aluminio 3831 Anolo linea ECOMICA ALE
                                    proyec = new VentanaProyec();
                                    proyec.setAlto(alto);
                                    proyec.setAncho(ancho);
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
                                            this.lista.get(343).getPrecioAnonizado(), this.lista.get(342).getPrecioAnonizado(), this.lista.get(346).getPrecioAnonizado());
                                    break;

                                case 3:// para ventanas proyectante  de aluminio 3831 Pintura linea ECOMICA ALE
                                    proyec = new VentanaProyec();
                                    proyec.setAlto(alto);
                                    proyec.setAncho(ancho);
                                    proyec.setPrecioTrabajo(this.manObra);
                                    proyec.setPrecioDescuento(this.ganancia);
                                    proyec.setTipoProducto(opcionVentana);
                                    proyec.setPrecioCabezal(this.lista.get(131).getPrecioPintura());
                                    proyec.setPrecioSillar(this.lista.get(137).getPrecioPintura());
                                    proyec.setPrecioJamba(this.lista.get(2).getPrecioPintura());
                                    proyec.setPrecioAdaptador(this.lista.get(133).getPrecioPintura());
                                    proyec.setPrecioEmpaque(this.lista.get(354).getPrecioPintura());

                                    proyec.VentanaProyec(this.lista.get(134).getPrecioPintura(), this.lista.get(138).getPrecioPintura(),
                                            this.lista.get(169).getPrecioPintura(), this.lista.get(135).getPrecioPintura(),
                                            this.lista.get(343).getPrecioPintura(), this.lista.get(342).getPrecioPintura(), this.lista.get(346).getPrecioPintura());
                                    break;
                            }
                            break;
                        case 2:
                            switch (tipoColor) {
                                case 1:// para ventanas proyectante  de aluminio 3831 Natural en la linea FINA VITRAL
                                    proyec = new VentanaProyec();
                                    proyec.setAlto(alto);
                                    proyec.setAncho(ancho);
                                    proyec.setPrecioTrabajo(this.manObra);
                                    proyec.setPrecioDescuento(this.ganancia);
                                    proyec.setTipoProducto(opcionVentana);
                                    proyec.setPrecioCabezal(this.lista.get(131).getPreciocost());
                                    proyec.setPrecioSillar(this.lista.get(137).getPreciocost());
                                    proyec.setPrecioJamba(this.lista.get(132).getPreciocost());
                                    proyec.setPrecioAdaptador(this.lista.get(133).getPreciocost());
                                    proyec.setPrecioEmpaque(this.lista.get(366).getPreciocost());

                                    proyec.VentanaProyec(this.lista.get(134).getPreciocost(), this.lista.get(138).getPreciocost(),
                                            this.lista.get(169).getPreciocost(), this.lista.get(135).getPreciocost(),
                                            this.lista.get(343).getPreciocost(), this.lista.get(342).getPreciocost(), this.lista.get(346).getPreciocost());
                                    break;

                                case 2:// para ventanas proyectante  de aluminio 3831 ANOLO en la linea FINA VITRAL
                                    proyec = new VentanaProyec();
                                    proyec.setAlto(alto);
                                    proyec.setAncho(ancho);
                                    proyec.setPrecioTrabajo(this.manObra);
                                    proyec.setPrecioDescuento(this.ganancia);
                                    proyec.setTipoProducto(opcionVentana);
                                    proyec.setPrecioCabezal(this.lista.get(131).getPrecioAnonizado());
                                    proyec.setPrecioSillar(this.lista.get(137).getPrecioAnonizado());
                                    proyec.setPrecioJamba(this.lista.get(132).getPrecioAnonizado());
                                    proyec.setPrecioAdaptador(this.lista.get(133).getPrecioAnonizado());
                                    proyec.setPrecioEmpaque(this.lista.get(366).getPrecioAnonizado());

                                    proyec.VentanaProyec(this.lista.get(134).getPrecioAnonizado(), this.lista.get(138).getPrecioAnonizado(),
                                            this.lista.get(169).getPrecioAnonizado(), this.lista.get(135).getPrecioAnonizado(),
                                            this.lista.get(343).getPrecioAnonizado(), this.lista.get(342).getPrecioAnonizado(), this.lista.get(346).getPrecioAnonizado());
                                    break;

                                case 3:// para ventanas proyectante  de aluminio 3831 Pintura en la linea FINA VITRAL
                                    proyec = new VentanaProyec();
                                    proyec.setAlto(alto);
                                    proyec.setAncho(ancho);
                                    proyec.setPrecioTrabajo(this.manObra);
                                    proyec.setPrecioDescuento(this.ganancia);
                                    proyec.setTipoProducto(opcionVentana);
                                    proyec.setPrecioCabezal(this.lista.get(131).getPrecioPintura());
                                    proyec.setPrecioSillar(this.lista.get(137).getPrecioPintura());
                                    proyec.setPrecioJamba(this.lista.get(2).getPrecioPintura());
                                    proyec.setPrecioAdaptador(this.lista.get(133).getPrecioPintura());
                                    proyec.setPrecioEmpaque(this.lista.get(366).getPrecioPintura());

                                    proyec.VentanaProyec(this.lista.get(134).getPrecioPintura(), this.lista.get(138).getPrecioPintura(),
                                            this.lista.get(169).getPrecioPintura(), this.lista.get(135).getPrecioPintura(),
                                            this.lista.get(343).getPrecioPintura(), this.lista.get(342).getPrecioPintura(), this.lista.get(346).getPrecioPintura());
                                    break;
                            }
                            break;
                    }

                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (proyec.getAlto() * proyec.getAncho())) / 10000;
                    Long precioExtra = this.precioVidrio + this.precioAccesorios + proyec.getSumaTotal();
                    precioExtra = (precioExtra * proyec.getPrecioDescuento() / 100) + precioExtra;

                    this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idVentana),
                            modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtra + precioInstala, this.cantidadProducto * (precioExtra + precioInstala), this.manObra, this.ganancia, this.alto, this.ancho, ""));
                    break;

                case 2: //////Caso 2 ventanas 
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
      //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                      
                        case 2:    // este es para una ventana CORREDERA VC3825 
                            switch (tipoColor) {
                                case 1:
                                    // este es para una ventana CORREDERA VC3825 
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
                                            0, 0, this.lista.get(152).getPreciocost(),   0, 0, 0, 0, 0, 0);
                                
                                     
                                    break;
                                case 2:
                                    // este es para una ventana CORREDERA VC3825  Anolo
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
                                            0, 0, this.lista.get(152).getPrecioAnonizado(),   0, 0, 0, 0, 0, 0);
                                    break;
                                case 3:
                                    // este es para una ventana CORREDERA VC3825  pintura
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
                                            0, 0, this.lista.get(152).getPrecioPintura(),   0, 0, 0, 0, 0, 0);
                                    break;
                            }
                            break;
                    
                     
                    }
                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (corredera.getAlto() * corredera.getAncho())) / 10000;
                    Long precioExtrac = this.precioVidrio + this.precioAccesorios + corredera.getSumaTotal();
                    precioExtrac = (precioExtrac * corredera.getPrecioDescuento() / 100) + precioExtrac;

                    this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idVentana),
                            modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtrac + precioInstala, this.cantidadProducto * (precioExtrac + precioInstala), this.manObra, this.ganancia, this.alto, this.ancho, ""));
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

                    this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, idVentana),
                            modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho,
                            this.cantidadProducto, precioExtraa + precioInstala, this.cantidadProducto * (precioExtraa + precioInstala), this.manObra, this.ganancia, this.alto, this.ancho, ""));
//////////////Caso 3
                    break;

            }

            if (this.idVidrio == 0) {
                this.precioVidrio = 0;
            }

            if (this.tipoProductos == 4) {
                this.listaAbono.add(new Abonodetalle(null, daoProductos.getById(this.session, this.tipoVentana),
                        daoProductos.getById(this.session, this.tipoVentana).getNombre() + " " + this.alto + "*" + this.ancho,
                        this.cantidadProducto, this.precioVidrio + this.manObra, this.cantidadProducto * this.precioVidrio, this.manObra, this.ganancia, this.alto, this.ancho, ""));
            }
            DespieceVentana despieceVent = new DespieceVentana();
            lstDespiece.add(despieceVent.generaDespiece(tipoModeloVentana, opcionVentana, tipoAluminio, cantidadProducto, alto, ancho, modeloVentana + " " + nombreVentana + " " + nombreAluminio));

            this.transaccion.commit();
            this.idVidrio = 0;
            this.ganancia = 0;
            this.alto = "";
            this.ancho = "";
            this.manObra = 0;
            this.tipoVentana = 0;
            this.tipoVidrio = 0;
            this.productoTipo = 0;

        } catch (Exception ex) {

            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }

    }

    public void imprimeDespiese(Object document) {
        try {
            Document pdf = (Document) document;
            pdf.open();
            pdf.setPageSize(PageSize.A4);
            HTMLWorker htmlWorker = new HTMLWorker(pdf);
            String html = "";
            html = new ImprimeDespiece().imprime(lstDespiece);
            htmlWorker.parse(new StringReader(html));
        } catch (Exception e) {
            System.out.println("Ocurrio un error generando pdf: " + e.toString());
        }

    }

      public long calculaIva(Long preci){
        Long sumaIva = preci*16/100;
        sumaIva+=preci;
        return sumaIva;
    }
    
    
    public void generarFactura() {
        this.session = null;
        this.transaccion = null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String correoEmple = httpSession.getAttribute("correoElectronico").toString();
        try {
            DaoCliente daoCliente = new DaoCliente();
            DaoEmpleado daoEmpleado = new DaoEmpleado();
            DaoAbonos daoAbonos = new DaoAbonos();
            DaoAbonoDetalle daoAbonoDetalle = new DaoAbonoDetalle();

            if (this.montoAbono == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el valor del Abono."));
                return;
            }
            if (String.valueOf(this.montoAbono).equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digite el valor del Abono."));
                return;
            }
            try {

                long m = this.montoAbono;

            } catch (NumberFormatException nfe) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Digito texto en un campo numerico."));
            }

            if (this.cliente == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Por favor selecione un cliente."));
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.abonos.setCliente(cliente);
            this.abonos.setEmpleado(daoEmpleado.getByCorreoElectronico(this.session, correoEmple));
            this.abonos.setFecharegistro(new Date());
            daoAbonos.registar(this.session, this.abonos);

            this.abonos = daoAbonos.getByUltimoRegistro(this.session);
            long suma = 0;
            for (Abonodetalle listaAbono1 : this.listaAbono) {
                listaAbono1.setAbonos(this.abonos);
                suma += listaAbono1.getTotal();

                //      listaAbono1.getProductos().getIdproductos()
////                este metodo es para descontar de la bd los productos por unidades 
////                estos son para las vitrinas 3 8 9
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
                daoAbonoDetalle.registar(this.session, listaAbono1);
            }
            this.listaFactura = this.listaAbono;
            this.abonos.setPrecioTotal(suma);
            this.abonos.setMontoabono(this.montoAbono);
            this.abonos.setSaldofinal(this.abonos.getPrecioTotal() - this.abonos.getMontoabono());
            daoAbonos.actualizar(this.session, this.abonos);
            this.abonos.getFecharegistro();
            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sesson.setAttribute("idfactura", this.abonos.getIdabonos());
            this.transaccion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Se ha registrado "));

        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }
    }

    public void retirarListaVentaDetalle(String nombre) {
        try {
            int i = 0;
            for (Abonodetalle listaAbono1 : this.listaAbono) {
                if (listaAbono1.getNombrepro().equals(nombre)) {
                    this.listaAbono.remove(i);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Productos retirado de la lista de ventas"));

                    break;
                }
                i++;
            }
            long total = 0;
            long subTotal = 0;
            long iva = 0;

            for (Abonodetalle listaAbono1 : this.listaAbono) {
                listaAbono1.setTotal(listaAbono1.getCantidad() * listaAbono1.getPrecioventa());
                total = total + listaAbono1.getTotal();

            }
            subTotal = total;
            iva = (subTotal * 16) / 100;
            this.abonos.setPrecioTotal(subTotal + iva);
//            this.abonos.setSaldofinal(this.abonos.getPrecioTotal() - this.abonos.getMontoabono());

//            RequestContext.getCurrentInstance().update("frmFactura:tablaProductosFactura frmFactura:gripTotalFactura");
            RequestContext.getCurrentInstance().update("frmAbono:mensajeGeneral");

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    
    public void calcular() {
        long total = 0;
        long subTotal = 0;
        long iva = 0;
        for (Abonodetalle listaAbono1 : listaAbono) {
            listaAbono1.setTotal(listaAbono1.getCantidad() * listaAbono1.getPrecioventa());
            total = total + listaAbono1.getTotal();
        }
        subTotal = total;
        iva = (subTotal * 16) / 100;
        this.abonos.setPrecioTotal(subTotal + iva);
//      this.abonos.setSaldofinal(this.abonos.getSaldofinal() - this.abonos.getPrecioTotal());
    }

    public String convertFecha(Date fecha) {
        if (fecha != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.format(fecha);
        }
        return "";
    }

    public List<Abonodetalle> getByIdFactura() {
        this.session = null;
        this.transaccion = null;

        try {

            DaoAbonos daoAbonos = new DaoAbonos();
            DaoAbonoDetalle daoAbonoDetalle = new DaoAbonoDetalle();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

            this.abonos = daoAbonos.getById(this.session, Integer.valueOf(sesson.getAttribute("idfactura").toString()));
            List<Abonodetalle> listaVenta = daoAbonoDetalle.getAllByIdFactura(this.session, this.abonos.getIdabonos());
            this.transaccion.commit();
            return listaVenta;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }
    }

    public Abonos getFacturaActual() {
        this.session = null;
        this.transaccion = null;

        try {
            DaoAbonos daoAbonos = new DaoAbonos();
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            HttpSession sesson = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            this.abonos = daoAbonos.getById(this.session, Integer.valueOf(sesson.getAttribute("idfactura").toString()));

            this.transaccion.commit();
            return this.abonos;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }
    }

    public List<Abonos> getAll() {
        this.session = null;
        this.transaccion = null;
        try {

            DaoAbonos daoAbonos = new DaoAbonos();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.listaAbonoSel = daoAbonos.getAll(this.session);
            this.transaccion.commit();
            return this.listaAbonoSel;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public List<Abonos> getListVentasByFecha() {
        if (listaVentasByFecha == null) {
            listaVentasByFecha = new ArrayList<>();
        }
        return listaVentasByFecha;
    }

    public void consultarVentas() {
        this.session = null;
        this.transaccion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            DaoAbonos daoAbonos = new DaoAbonos();
            this.listaVentasByFecha = daoAbonos.getAllFecha(this.session, this.fechaInicio, this.fechaFin);

            totalVentasFecha = 0;
            for (Abonos abono : listaVentasByFecha) {
                totalVentasFecha = totalVentasFecha + (abono.getMontoabono());
            }
            this.transaccion.commit();
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void selectAbono(int id) {
        this.idAbono = id;
    }

    public void searchByDocumento() {
        this.listaAbonoSel = new ArrayList<>();
        this.session = null;
        this.transaccion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            DaoCliente daoCliente = new DaoCliente();
            DaoAbonos daoAbonos = new DaoAbonos();
            this.cliente = daoCliente.getByNumeroDocumento(this.session, this.numeroDocumento);
            this.listaAbonoSel.addAll(daoAbonos.getAllByCliente(this.session, this.numeroDocumento));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Contacte con su administrador" + e.getMessage()));
            this.listaAbonoSel = null;
            this.cliente = null;
            if (this.transaccion != null) {
                this.transaccion.rollback();
                this.session.close();
            }
        }
    }

    //    aqui comienza el codigo nuevo 
    public void agregarDatosCliente(Integer codCliente) {
        this.session = null;
        this.transaccion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoCliente daoCliente = new DaoCliente();
            this.transaccion = this.session.beginTransaction();
            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente
            this.cliente = daoCliente.getById(this.session, codCliente);

            this.transaccion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
        } catch (Exception e) {
            if (this.transaccion != null) {
                System.out.println(e.getMessage());
                transaccion.rollback();
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
        this.transaccion = null;
        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            DaoCliente daoCliente = new DaoCliente();
            this.transaccion = this.session.beginTransaction();
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
            this.transaccion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
        } catch (Exception e) {
            if (this.transaccion != null) {
                System.out.println(e.getMessage());
                transaccion.rollback();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));

            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void limpiarAbonos() {
        this.cliente = new Cliente();
        this.empleado = new Empleado();
        this.abonos = new Abonos();
        this.listaAbono = new ArrayList<>();
        this.listaFactura = new ArrayList<>();
        this.montoAbono = 0;

//        invocar el metodo para destivar controles en a factura
        this.disableButton();

    }

    public void agregarDatosEmpleado(Integer codEmpleado) {
        this.session = null;
        this.transaccion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoEmpleado daoEmpleado = new DaoEmpleado();
            this.transaccion = this.session.beginTransaction();
            //obtener los datos del cliente en la variable objecto cliente segun el codigo del cliente

            this.empleado = daoEmpleado.getById(this.session, codEmpleado);

            this.transaccion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
        } catch (Exception e) {
            if (this.transaccion != null) {
                System.out.println(e.getMessage());
                transaccion.rollback();
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
        this.transaccion = null;
        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            DaoEmpleado daoEmpleado = new DaoEmpleado();
            this.transaccion = this.session.beginTransaction();
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
            this.transaccion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
        } catch (Exception e) {
            if (this.transaccion != null) {
                System.out.println(e.getMessage());
                transaccion.rollback();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El registro fue erroneo"));

            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public List<Cliente> getAllClientes() {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoCliente daoCliente = new DaoCliente();

            this.transaccion = this.session.beginTransaction();

            this.listaClientes = daoCliente.getAll(this.session);

            this.transaccion.commit();

            return this.listaClientes;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                transaccion.rollback();
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
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoEmpleado daoEmpleado = new DaoEmpleado();
            this.transaccion = this.session.beginTransaction();

            this.listaEmpleado = daoEmpleado.getAll(this.session);

            this.transaccion.commit();

            return this.listaEmpleado;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                transaccion.rollback();
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

    public Abonodetalle getAbonoDeta() {
        return abonoDeta;
    }

    public void setAbonoDeta(Abonodetalle abonoDeta) {
        this.abonoDeta = abonoDeta;
    }

    public ArrayList<Abonodetalle> getListaAbono() {
        return listaAbono;
    }

    public void setListaAbono(ArrayList<Abonodetalle> listaAbono) {
        this.listaAbono = listaAbono;
    }

    public ArrayList<Abonodetalle> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(ArrayList<Abonodetalle> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public ArrayList<Materiales> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Materiales> lista) {
        this.lista = lista;
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

    public Abonos getAbonos() {
        return abonos;
    }

    public void setAbonos(Abonos abonos) {
        this.abonos = abonos;
    }

    public List<Abonos> getListaAbonoSel() {
        return listaAbonoSel;
    }

    public void setListaAbonoSel(List<Abonos> listaAbonoSel) {
        this.listaAbonoSel = listaAbonoSel;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Abonos> getListaVentasByFecha() {
        return listaVentasByFecha;
    }

    public void setListaVentasByFecha(List<Abonos> listaVentasByFecha) {
        this.listaVentasByFecha = listaVentasByFecha;
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

    public List<Abonos> getListaAbonosFiltrado() {
        return listaAbonosFiltrado;
    }

    public void setListaAbonosFiltrado(List<Abonos> listaAbonosFiltrado) {
        this.listaAbonosFiltrado = listaAbonosFiltrado;
    }

    public long getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(long montoAbono) {
        this.montoAbono = montoAbono;
    }

    public int getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = idAbono;
    }

    public List<Abonosecundario> getListaAbonoSecundario() {
        return listaAbonoSecundario;
    }

    public void setListaAbonoSecundario(List<Abonosecundario> listaAbonoSecundario) {
        this.listaAbonoSecundario = listaAbonoSecundario;
    }

    public int getIdAbonoSecundario() {
        return idAbonoSecundario;
    }

    public void setIdAbonoSecundario(int idAbonoSecundario) {
        this.idAbonoSecundario = idAbonoSecundario;
    }

    public int getProductoTipo() {
        return productoTipo;
    }

    public void setProductoTipo(int productoTipo) {
        this.productoTipo = productoTipo;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
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

    public int getTipoAluminio() {
        return tipoAluminio;
    }

    public void setTipoAluminio(int tipoAluminio) {
        this.tipoAluminio = tipoAluminio;
    }

    public Abonos getAbonoSelect() {
        return abonoSelect;
    }

    public void setAbonoSelect(Abonos abonoSelect) {
        this.abonoSelect = abonoSelect;
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

    public int getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(int tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    public List<Despiece> getLstDespiece() {
        return lstDespiece;
    }

    public void setLstDespiece(List<Despiece> lstDespiece) {
        this.lstDespiece = lstDespiece;
    }

    public int getTipoAluminioPuerta() {
        return tipoAluminioPuerta;
    }

    public void setTipoAluminioPuerta(int tipoAluminioPuerta) {
        this.tipoAluminioPuerta = tipoAluminioPuerta;
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

    public int getDiseñoVentana() {
        return diseñoVentana;
    }

    public void setDiseñoVentana(int diseñoVentana) {
        this.diseñoVentana = diseñoVentana;
    }

    public int getPrecioInstalacion() {
        return precioInstalacion;
    }

    public void setPrecioInstalacion(int precioInstalacion) {
        this.precioInstalacion = precioInstalacion;
    }

    public int getDiseno() {
        return diseno;
    }

    public void setDiseno(int diseno) {
        this.diseno = diseno;
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

    public int getTipoAluminioProy() {
        return tipoAluminioProy;
    }

    public void setTipoAluminioProy(int tipoAluminioProy) {
        this.tipoAluminioProy = tipoAluminioProy;
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

}
