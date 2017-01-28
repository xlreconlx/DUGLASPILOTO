/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MbView;

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
import Daos.DaoAccesorios;
import Daos.DaoManoObra;
import Daos.DaoMaterial;
import Daos.DaoProductos;
import Daos.DaoVidrio;
import HibernateUtil.HibernateUtil;
import Pojos.Accesorios;
import Pojos.Materiales;
import Pojos.Ventanadetalle;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author William Sanchez
 */
@ManagedBean
@ViewScoped
public class MbCalcular {

    private Session session;
    private Transaction transaction;
    private int tipoProducto;
    private String nombreProducto;
    private int tipoVitrina;
    private List<Materiales> lista;
    private int tipoColorVitrina;
    private String alto;
    private String ancho;
    private String fondo;
    private int manObra;
    private int ganancia;
    private int idVidrio;
    private long precioVidrio;
    private int tipoEntrepanos;
    private int precioAccesorios;
    private long precioTotal;
    private long precioTotalCantidad;
    private String mensajeCanti;
    private int canti;
    private int tipoVentana;
    private int tipoVidrio;
    private int productoTipo;
    private int tipoPuerta;
    private int tipoAlumPuertaCor;
    private int tipoAlumPuertaBat;
    private int tipoAlumPuertaPok;
    private int tipoColor;
    private int tipoModeloPuerta;
    private int cantidadProducto;
    private int diseno;
    private int precioInstalacion;
    private int tipoAluminioBati;
    private int tipoAluminioCorred;
    private int tipoAluminioProy;
    private int tipoModeloVentana;
    private final int IVA = 16;

    /**
     * Creates a new instance of MbCalcular
     */
    public MbCalcular() {
        lista = new ArrayList<>();

    }

    public void tipoProducto() {
        switch (productoTipo) {
            case 1:
                  calcularVentana();
                break;
            case 2:
                calcularPuertas();
                break;
            case 3:
                calcularVitrina();
                break;
            case 4:
                  calcularVentana();
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error:", "Escoja un tipo de producto"));
                break;
        }

    }

    public void calcularVitrina() {
        this.session = null;
        this.transaction = null;
        Vitrina vitrina = new Vitrina();
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
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

                pianas = daoAcessorios.getById(this.session, 18).getPrecioCosto() * 8;
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

            if (this.tipoEntrepanos == 1) {
                this.nombreProducto = "Vitrina de 3 entrepaños " + this.alto + " * " + this.ancho + " Fondo: " + this.fondo;
                this.precioTotal = vitrina.getSumaTotal() + this.precioVidrio;
                this.precioTotalCantidad = this.precioTotal * this.canti + this.precioAccesorios;
                this.mensajeCanti = String.valueOf(this.canti);
            } else {
                this.nombreProducto = "Vitrina de 4 entrepaños " + this.alto + " * " + this.ancho + " Fondo: " + this.fondo;
                this.precioTotal = vitrina.getSumaTotal() + this.precioVidrio + this.precioAccesorios;
                this.precioTotalCantidad = this.precioTotal * this.canti;
                this.mensajeCanti = String.valueOf(this.canti);
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

        } finally {
            if (this.session != null) {
                this.session.close();
            }
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
                case 2:
                    nombreAluminio = " Aluminio 3831 VITRAL";
                    break;
//                case 3:
//                    nombreAluminio = " Aluminio 8025";
//                    break;
            }
            switch (tipoAluminioCorred) {
                case 1:
                    nombreAluminio = " Aluminio AS 1700";
                    break;
                case 2:
                    nombreAluminio = " Aluminio AS 1800";
                    break;
                case 3:
                    nombreAluminio = " Aluminio AS 1900";
                    break;
            }
            switch (tipoAluminioBati) {
                case 1:
                    nombreAluminio = " Aluminio 3825";
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
                                     System.out.println("precio brazos:::" + BrazosBasculantes);
                                    acce = daoAccesorios.getById(this.session, 21);
                                    manijas = acce.getPrecioCosto() * 2;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 31;
                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos OO";
                                    opcionVentana = 6;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 17;
                                     this.precioAccesorios = tronillos;
                                    break;
                                case 3:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos O/O";
                                    opcionVentana = 7;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 43;
                                    this.precioAccesorios = tronillos;
                                    break;
                                case 4:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X/O";
                                    opcionVentana = 8;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 2;
                                  
                                    acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 1;
                                     acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 42;
                                  
                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 5:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X-O";
                                    opcionVentana = 10;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 4;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 1;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 41;
                                   this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 6:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X/O plus alfalgia";
                                    opcionVentana = 12;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 2;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 1;
                                     acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 42;
                                     this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 7:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X/X alfalgia";
                                    opcionVentana = 14;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 4;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 2;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 42;
                                     this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 8:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X/0 Boreal alfaljia";
                                    opcionVentana = 19;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 2;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 1;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 42;
                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 9:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos 0/0 Boreal alfalgia";
                                    opcionVentana = 20;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 2;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 1;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 43;
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
                                      acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 3;
                                     acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 43;
                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos 0-x-0 Alfaljia";
                                    opcionVentana = 9;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 6;
                                       acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 2;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 42;
                                     this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 3:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos alfajia x-0-x";
                                    opcionVentana = 11;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 4;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 2;
                               
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 44;
                                     this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 4:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos 0-0-0 ALFALJIA";
                                    opcionVentana = 15;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 24;
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
                                      acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 4;
                                     acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 43;
                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;

                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos 0-0-0-0";
                                    opcionVentana = 13;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 23;
                                    this.precioAccesorios = tronillos;
                                    break;
                                case 3:
                                    nombreVentana = "4 cuerpos 0/0/0/0/ ALFALJIA ";
                                    opcionVentana = 16;
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 48;
                                    this.precioAccesorios = tronillos;
                                    break;
                                case 4:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos xx/00 ALFALJIA";
                                    opcionVentana = 17;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 4;
                                     acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 2;
                                     acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 46;
                                    this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 5:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos X/X/0/0 ALFALJIA";
                                    opcionVentana = 18;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 4;
                                    acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 2;
                                   acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 42;
                                     this.precioAccesorios = BrazosBasculantes + manijas + tronillos;
                                    break;
                                case 6:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos 4 ALFALJIA";
                                    opcionVentana = 21;
                                    acce = daoAccesorios.getById(this.session, 9);//obtiene el accesorio de la bd
                                    BrazosBasculantes = acce.getPrecioCosto() * 2;
                                    acce = daoAccesorios.getById(this.session, 20);
                                    manijas = acce.getPrecioCosto() * 2;
                                     acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 44;
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
                                
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 25;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpo XX";
                                    opcionVentana = 23;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 4;
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                 
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 21;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
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
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 2;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 27;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos OXO BASICA";
                                    opcionVentana = 25;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 2;
                                  
                                    acce = daoAccesorios.getById(this.session, 23);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 26;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;
                                case 3:
                                    acce = new Accesorios();
                                    nombreVentana = "3 cuerpos OXX BASICA";
                                    opcionVentana = 26;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 4;
                               
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                 
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 27;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;
                                case 4:
                                    acce = new Accesorios();

                                    nombreVentana = "3 cuerpos X0/O";
                                    opcionVentana = 27;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 2;
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 22;
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
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                 
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 39;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos X0/00 Basica Alf";
                                    opcionVentana = 29;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 2;
                                 
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 39;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
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
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 36;
                                     this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos OXO /OOO BASICA";
                                    opcionVentana = 31;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 2;
                                   
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 32;
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
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                   
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 36;
                                    this.precioAccesorios = rodachina + cierre + tronillos;
                                    break;

                            }
                    }

                    break;
                case 3://Batiente
                    switch (tipoVentana) {
                        case 1:
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X0 plus basica alfa";
                                    opcionVentana = 33;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 2;
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                    acce.setCantidad(acce.getCantidad() - (1 * this.cantidadProducto));
                                    daoAccesorios.actualizar(this.session, acce);

                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 10;
                                  
                                    acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos1 = acce.getPrecioCosto() * 9;
                                     this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                    break;
                                case 2:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos XX Alf BASICA";
                                    opcionVentana = 34;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 4;
                                   
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 36;
                                  
                                    acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos1 = acce.getPrecioCosto() * 9;
                                    this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                    break;
                                case 3:
                                    acce = new Accesorios();
                                    nombreVentana = "2 cuerpos X0 plus Reforzada";
                                    opcionVentana = 35;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 4;
                                  
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 36;
                                  
                                    acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos1 = acce.getPrecioCosto() * 9;
                                    this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                    break;
                            }
                        case 2:
                            switch (diseno) {
                                case 1:
                                    acce = new Accesorios();
                                    nombreVentana = "4 cuerpos 0XX0 1672 DOBLE";
                                    opcionVentana = 36;
                                    acce = daoAccesorios.getById(this.session, 89);//Se realiza el mismo procedimiento para todos los accesorios
                                    rodachina = acce.getPrecioCosto() * 4;
                                   
                                    acce = daoAccesorios.getById(this.session, 24);//Se realiza el mismo procedimiento para todos los accesorios
                                    cierre = acce.getPrecioCosto() * 1;
                                  
                                    acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos = acce.getPrecioCosto() * 20;
                                  
                                    acce = daoAccesorios.getById(this.session, 103);//Se realiza el mismo procedimiento para todos los accesorios
                                    tronillos1 = acce.getPrecioCosto() * 16;
                                    this.precioAccesorios = rodachina + cierre + tronillos + tronillos1;
                                    break;
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
                                    proyec.setTipoProducto(this.tipoVentana);
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
                                    proyec.setTipoProducto(this.tipoVentana);
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
                                    proyec.setTipoProducto(this.tipoVentana);
                                    proyec.setPrecioCabezal(this.lista.get(131).getPrecioPintura());
                                    proyec.setPrecioSillar(this.lista.get(137).getPrecioPintura());
                                    proyec.setPrecioJamba(this.lista.get(132).getPrecioPintura());
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
                                    proyec.setPrecioEmpaque(this.lista.get(354).getPreciocost());

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
                                    proyec.setPrecioEmpaque(this.lista.get(365).getPrecioAnonizado());

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
                                    proyec.setPrecioJamba(this.lista.get(132).getPrecioPintura());
                                    proyec.setPrecioAdaptador(this.lista.get(133).getPrecioPintura());
                                    proyec.setPrecioEmpaque(this.lista.get(365).getPrecioPintura());

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
        
                    Long precioIva = ((precioExtra + precioInstala)*IVA)/100;
                    precioIva+=precioExtra + precioInstala;
                    nombreProducto =   modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho;
                    precioTotal = precioIva;
                    precioTotalCantidad = precioTotal * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
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
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPreciocost());
                                    corredera.setPrecioSillar(this.lista.get(250).getPreciocost());
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
                                            this.lista.get(249).getPreciocost(), this.lista.get(285).getPreciocost());
                                    break;

                                case 2:
                                    // este es para una ventana con aluminio AS 1700 Anolo

                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioAnonizado());
                                    corredera.setPrecioSillar(this.lista.get(250).getPrecioAnonizado());
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
                                            this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado());
                                    break;

                                case 3:
                                    // este es para una ventana con aluminio AS 1700 Pintura
                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioPintura());
                                    corredera.setPrecioSillar(this.lista.get(250).getPrecioPintura());
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
                                            this.lista.get(249).getPrecioPintura(), this.lista.get(285).getPrecioPintura());
                                    break;
                            }
                            break;
                        case 2:    // este es para una ventana con aluminio AS 1800 Natural
                            switch (tipoColor) {
                                case 1:
                                    // este es para una ventana con aluminio AS 1800 Natural
                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPreciocost());
                                    corredera.setPrecioSillar(this.lista.get(250).getPreciocost());
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
                                            this.lista.get(249).getPreciocost(), this.lista.get(285).getPreciocost());
                                    break;
                                case 2:
                                    // este es para una ventana con aluminio AS 1800 Anolo
                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioAnonizado());
                                    corredera.setPrecioSillar(this.lista.get(250).getPrecioAnonizado());
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
                                            this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado());
                                    break;
                                case 3:
                                    // este es para una ventana con aluminio AS 1800 pintura
                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioPintura());
                                    corredera.setPrecioSillar(this.lista.get(250).getPrecioPintura());
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
                                            this.lista.get(249).getPrecioPintura(), this.lista.get(285).getPrecioPintura());
                                    break;
                            }
                            break;
                        case 3:  // este es para una ventana con aluminio AS 1900 Natural
                            switch (tipoColor) {
                                case 1:
                                    // este es para una ventana con aluminio AS 1900 Natural
                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPreciocost());
                                    corredera.setPrecioSillar(this.lista.get(250).getPreciocost());
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
                                            this.lista.get(249).getPreciocost(), this.lista.get(285).getPreciocost());
                                    break;
                                case 2:
                                    // este es para una ventana con aluminio AS 1900 Anolo

                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioAnonizado());
                                    corredera.setPrecioSillar(this.lista.get(250).getPrecioAnonizado());
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
                                            this.lista.get(249).getPrecioAnonizado(), this.lista.get(285).getPrecioAnonizado());
                                    break;
                                case 3:
                                    // este es para una ventana con aluminio AS 1900 Pintura

                                    corredera = new VentanaCorre();
                                    corredera.setAlto(alto);
                                    corredera.setAncho(ancho);
                                    corredera.setPrecioTrabajo(this.manObra);
                                    corredera.setPrecioDescuento(this.ganancia);
                                    corredera.setTipoProducto(this.tipoVentana);
                                    corredera.setPrecioCabezal(this.lista.get(232).getPrecioPintura());
                                    corredera.setPrecioSillar(this.lista.get(250).getPrecioPintura());
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
                                            this.lista.get(249).getPrecioPintura(), this.lista.get(285).getPrecioPintura());
                                    break;
                            }
                            break;
                    }
                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (corredera.getAlto() * corredera.getAncho())) / 10000;
                    Long precioExtraC = this.precioVidrio + this.precioAccesorios + corredera.getSumaTotal();
                    precioExtraC = (precioExtraC * corredera.getPrecioDescuento() / 100) + precioExtraC;
        
                    Long precioIvaC = ((precioExtraC + precioInstala)*IVA)/100;
                    precioIvaC+=precioExtraC + precioInstala;
                    nombreProducto =   modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho;
                    precioTotal = precioIvaC;
                    precioTotalCantidad = precioTotal * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
                    break;

                case 3: //////Caso 2 ventanas de  Abatibles celosial
                    VentanaAbati abatible = new VentanaAbati();
                    switch (this.tipoAluminioBati) {
                        case 1: // este constructoer es para ventanas Abatibles celosial de aluminio 3835 y con sus distintos colores
                            switch (tipoColor) {
                                case 1: // este es para una ventana con aluminio AS 3825 Natural
                                    abatible = new VentanaAbati();
                                    abatible.setAlto(alto);
                                    abatible.setAncho(ancho);
                                    abatible.setPrecioTrabajo(this.manObra);
                                    abatible.setPrecioDescuento(this.ganancia);
                                    abatible.setTipoProducto(this.tipoVentana);
                                    abatible.setPrecioCabezal(this.lista.get(146).getPreciocost());
                                    abatible.setPrecioSillar(this.lista.get(145).getPreciocost());
                                    abatible.setPrecioJamba(this.lista.get(144).getPreciocost());
                                    abatible.setPrecioHinferior(this.lista.get(149).getPreciocost());
                                    abatible.setPrecioTraslape(this.lista.get(150).getPreciocost());
                                    abatible.setPrecioEmpaque(this.lista.get(362).getPreciocost());
                                    abatible.setPreciofelpa(this.lista.get(360).getPreciocost());

                                    abatible.CalcularVentana(this.lista.get(147).getPreciocost(), this.lista.get(151).getPreciocost(),
                                            this.lista.get(148).getPreciocost(), this.lista.get(153).getPreciocost(), this.lista.get(152).getPreciocost());
                                    break;

                                case 2:
                                    // este es para una ventana con aluminio AS 3825 Anolo
                                    abatible = new VentanaAbati();
                                    abatible.setAlto(alto);
                                    abatible.setAncho(ancho);
                                    abatible.setPrecioTrabajo(this.manObra);
                                    abatible.setPrecioDescuento(this.ganancia);
                                    abatible.setTipoProducto(this.tipoVentana);
                                    abatible.setPrecioCabezal(this.lista.get(146).getPrecioAnonizado());
                                    abatible.setPrecioJamba(this.lista.get(144).getPrecioAnonizado());
                                    abatible.setPrecioSillar(this.lista.get(145).getPreciocost());
                                    abatible.setPrecioHinferior(this.lista.get(149).getPrecioAnonizado());
                                    abatible.setPrecioTraslape(this.lista.get(150).getPrecioAnonizado());
                                    abatible.setPrecioEmpaque(this.lista.get(362).getPrecioAnonizado());
                                    abatible.setPreciofelpa(this.lista.get(360).getPrecioAnonizado());

                                    abatible.CalcularVentana(this.lista.get(147).getPrecioAnonizado(), this.lista.get(151).getPrecioAnonizado(),
                                            this.lista.get(148).getPrecioAnonizado(), this.lista.get(153).getPrecioAnonizado(),
                                            this.lista.get(152).getPrecioAnonizado());
                                    break;

                                case 3:
                                    // este es para una ventana con aluminio AS 3825 Pintura
                                    abatible = new VentanaAbati();
                                    abatible.setAlto(alto);
                                    abatible.setAncho(ancho);
                                    abatible.setPrecioTrabajo(this.manObra);
                                    abatible.setPrecioDescuento(this.ganancia);
                                    abatible.setTipoProducto(this.tipoVentana);
                                    abatible.setPrecioCabezal(this.lista.get(146).getPrecioPintura());
                                    abatible.setPrecioJamba(this.lista.get(144).getPrecioPintura());
                                    abatible.setPrecioHinferior(this.lista.get(149).getPrecioPintura());
                                    abatible.setPrecioSillar(this.lista.get(145).getPrecioPintura());
                                    abatible.setPrecioTraslape(this.lista.get(150).getPrecioPintura());
                                    abatible.setPrecioEmpaque(this.lista.get(362).getPrecioPintura());
                                    abatible.setPreciofelpa(this.lista.get(366).getPrecioPintura());

                                    abatible.CalcularVentana(this.lista.get(147).getPrecioPintura(), this.lista.get(151).getPrecioPintura(),
                                            this.lista.get(148).getPrecioPintura(), this.lista.get(153).getPrecioPintura(),
                                            this.lista.get(152).getPrecioPintura());
                                    break;
                            }
                            break;
                    }

                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (abatible.getAlto() * abatible.getAncho())) / 10000;
                    Long precioExtraA = this.precioVidrio + this.precioAccesorios + abatible.getSumaTotal();
                    precioExtraA = (precioExtraA * abatible.getPrecioDescuento() / 100) + precioExtraA;
        
                    Long precioIvaA = ((precioExtraA + precioInstala)*IVA)/100;
                    precioIvaA+=precioExtraA + precioInstala;
                    nombreProducto =   modeloVentana + " " + nombreVentana + " " + nombreAluminio + " " + this.alto + "*" + this.ancho;
                    precioTotal = precioIvaA;
                    precioTotalCantidad = precioTotal * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
                    break;

            }
            if (this.idVidrio == 0) {
                this.precioVidrio = 0;
            }

            if (this.productoTipo == 4) {
                    precioInstala = this.precioInstalacion;
                    precioInstala = (precioInstala * (Integer.valueOf(this.alto) * Integer.valueOf(this.ancho))) / 10000;
                    long sumaTot = this.precioVidrio + this.manObra;
                    sumaTot = ((sumaTot * this.ganancia) /100)+sumaTot;
                    long precioIvaV = ((precioInstala + sumaTot)*IVA)/100;
                    precioIvaV+=precioInstala + sumaTot;
                    nombreProducto = "VIDRIO"+this.alto+" * "+this.ancho;
                    precioTotal = precioIvaV;
                    precioTotalCantidad = precioIvaV * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
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

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

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
                            acce = daoAccesorios.getById(this.session, 14);//obtiene el accesorio de la bd
                            bisagrasFlash = acce.getPrecioCosto() * 3;
                           
                            acce = daoAccesorios.getById(this.session, 54);//obtiene el accesorio de la bd
                            escuadras = acce.getPrecioCosto() * 2;
                           
                            acce = daoAccesorios.getById(this.session, 30);//obtiene el accesorio de la bd
                            Cerradura = acce.getPrecioCosto() * 1;
                           
                            acce = daoAccesorios.getById(this.session, 104);//Se realiza el mismo procedimiento para todos los accesorios
                            tornilloEnsa = acce.getPrecioCosto() * 10;
                           
                            acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                            tronilloInst = acce.getPrecioCosto() * 9;
                          
                            this.precioAccesorios = bisagrasFlash + escuadras + Cerradura + tornilloEnsa + tronilloInst;

                            break;
                        case 2:
                            nombrePuerta = "XI XD PANORAMICA";
                            acce = daoAccesorios.getById(this.session, 14);//obtiene el accesorio de la bd
                            bisagrasFlash = acce.getPrecioCosto() * 3;
                          
                            acce = daoAccesorios.getById(this.session, 54);//obtiene el accesorio de la bd
                            escuadras = acce.getPrecioCosto() * 2;
                          
                            acce = daoAccesorios.getById(this.session, 29);//obtiene el accesorio de la bd
                            Cerradura = acce.getPrecioCosto() * 1;
                          
                            acce = daoAccesorios.getById(this.session, 104);//Se realiza el mismo procedimiento para todos los accesorios
                            tornilloEnsa = acce.getPrecioCosto() * 10;
                          
                            acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                            tronilloInst = acce.getPrecioCosto() * 9;
                         
                            this.precioAccesorios = bisagrasFlash + escuadras + Cerradura + tornilloEnsa + tronilloInst;

                            break;
                        case 3:
                            nombrePuerta = "XX Panoramica";
                            acce = daoAccesorios.getById(this.session, 14);//obtiene el accesorio de la bd
                            bisagrasFlash = acce.getPrecioCosto() * 6;
                          
                            acce = daoAccesorios.getById(this.session, 54);//obtiene el accesorio de la bd
                            escuadras = acce.getPrecioCosto() * 2;
                          
                            acce = daoAccesorios.getById(this.session, 29);//obtiene el accesorio de la bd
                            Cerradura = acce.getPrecioCosto() * 1;
                         
                            acce = daoAccesorios.getById(this.session, 104);//Se realiza el mismo procedimiento para todos los accesorios
                            tornilloEnsa = acce.getPrecioCosto() * 20;
                           
                            acce = daoAccesorios.getById(this.session, 105);//Se realiza el mismo procedimiento para todos los accesorios
                            tronilloInst = acce.getPrecioCosto() * 18;
                           
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
                    Long precioExtra = this.precioVidrio + this.precioAccesorios + corrediza.getSumaTotal();
                    precioExtra = (precioExtra * corrediza.getPrecioDescuento() / 100) + precioExtra;
        
                    Long precioIva = ((precioExtra + precioInstala)*IVA)/100;
                    precioIva+=precioExtra + precioInstala;
                    nombreProducto =  modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho;
                    precioTotal = precioIva;
                    precioTotalCantidad = precioTotal * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
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
                    Long precioExtraB = this.precioVidrio + this.precioAccesorios + batiente.getSumaTotal();
                    precioExtraB = (precioExtraB * batiente.getPrecioDescuento() / 100) + precioExtraB;
        
                    Long precioIvaB = ((precioExtraB + precioInstala)*IVA)/100;
                    precioIvaB+=precioExtraB + precioInstala;
                    nombreProducto =  modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho;
                    precioTotal = precioIvaB;
                    precioTotalCantidad = precioTotal * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
                    break;

                case 3:    // este es para una ventana con aluminio AS 1800 Natural
                    
                    // en este metodo falta definir a cuales apunta en la base de daatos 

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
                                        // en este metodo falta definir a cuales apunta en la base de daatos 
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
                                        // en este metodo falta definir a cuales apunta en la base de daatos 
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
                    Long precioExtraP = this.precioVidrio + this.precioAccesorios + poket.getSumaTotal();
                    precioExtraB = (precioExtraP * poket.getPrecioDescuento() / 100) + precioExtraP;
        
                    Long precioIvaP = ((precioExtraP + precioInstala)*IVA)/100;
                    precioIvaP+=precioExtraB + precioInstala;
                    nombreProducto =  modeloPuerta + " " + nombrePuerta + " " + nombreAluminio + " " + this.alto + "*" + this.ancho;
                    precioTotal = precioIvaP;
                    precioTotalCantidad = precioTotal * this.cantidadProducto;
                    mensajeCanti = ""+cantidadProducto;
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
            System.out.println("Ocurrio un error:"+e.toString());
        }
    }

    public List<Materiales> getLista() {
        return lista;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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

    public int getIdVidrio() {
        return idVidrio;
    }

    public void setIdVidrio(int idVidrio) {
        this.idVidrio = idVidrio;
    }

    public int getTipoVentana() {
        return tipoVentana;
    }

    public void setTipoVentana(int tipoVentana) {
        this.tipoVentana = tipoVentana;
    }



    public long getPrecioVidrio() {
        return precioVidrio;
    }

    public void setPrecioVidrio(long precioVidrio) {
        this.precioVidrio = precioVidrio;
    }



    public long getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(long precioTotal) {
        this.precioTotal = precioTotal;
    }

   

    public int getTipoVitrina() {
        return tipoVitrina;
    }

    public void setTipoVitrina(int tipoVitrina) {
        this.tipoVitrina = tipoVitrina;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCanti() {
        return canti;
    }

    public void setCanti(int canti) {
        this.canti = canti;
    }

    public String getMensajeCanti() {
        return mensajeCanti;
    }

    public void setMensajeCanti(String mensajeCanti) {
        this.mensajeCanti = mensajeCanti;
    }

    public long getPrecioTotalCantidad() {
        return precioTotalCantidad;
    }

    public void setPrecioTotalCantidad(long precioTotalCantidad) {
        this.precioTotalCantidad = precioTotalCantidad;
    }

    public int getTipoEntrepanos() {
        return tipoEntrepanos;
    }

    public void setTipoEntrepanos(int tipoEntrepanos) {
        this.tipoEntrepanos = tipoEntrepanos;
    }

    public int getTipoPuerta() {
        return tipoPuerta;
    }

    public void setTipoPuerta(int tipoPuerta) {
        this.tipoPuerta = tipoPuerta;
    }

  

    public int getPrecioAccesorios() {
        return precioAccesorios;
    }

    public void setPrecioAccesorios(int precioAccesorios) {
        this.precioAccesorios = precioAccesorios;
    }

    public int getTipoColorVitrina() {
        return tipoColorVitrina;
    }

    public void setTipoColorVitrina(int tipoColorVitrina) {
        this.tipoColorVitrina = tipoColorVitrina;
    }

 

    public int getTipoVidrio() {
        return tipoVidrio;
    }

    public void setTipoVidrio(int tipoVidrio) {
        this.tipoVidrio = tipoVidrio;
    }

    public int getProductoTipo() {
        return productoTipo;
    }

    public void setProductoTipo(int productoTipo) {
        this.productoTipo = productoTipo;
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

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getTipoAlumPuertaCor() {
        return tipoAlumPuertaCor;
    }

    public void setTipoAlumPuertaCor(int tipoAlumPuertaCor) {
        this.tipoAlumPuertaCor = tipoAlumPuertaCor;
    }

    public int getTipoAlumPuertaBat() {
        return tipoAlumPuertaBat;
    }

    public void setTipoAlumPuertaBat(int tipoAlumPuertaBat) {
        this.tipoAlumPuertaBat = tipoAlumPuertaBat;
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

    
    
    
}
