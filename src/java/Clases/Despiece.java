/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author William Sanchez
 */
public class Despiece implements Serializable {

    private String alto;
    private String ancho;
    private int idVidrio;
    private int tipoVentana;
    private String nombreProducto;
    private int tipoProducto; //1 ventana, 2 puerta, 3 vitrina
    private int tipoAluminio;

    private int cantidadJamba;
    private int cantidadCabezal;
    private int cantidadSillar;
    private int cantidadTraslape;
    private int cantidadEnganche;
    private int cantidadEngancheAlto;
    private int cantidadHorizontalesSuperior;
    private int cantidadHorizontalesInferior;
    private int cantidadVidrio;
    private int cantidadAdactador;
    private String mensajeHSuperior;
    private String mensajeHInferior;
    private String mensajeCabezal;
    private String mensajeSillar;
    private String mensajeJamba;
    private String mensajeEnganche;
    private String mensajeEngancheAlto;
    private String mensajeTraslape;
    private String mensajeAdactador;
    private String mensajeVidrio;
    private int canti;
    private String mensajeCanti;

    //ventana proyctante
    private int cantidadPisavidrio;
    private int cantidadNave;
    private int cantidadAfajia;
    private int cantidadDivisor;
    private int cantidadDivisorAlto;
    private String mensajePisavidrio;
    private String mensajeNave;
    private String mensajeAfajia;
    private String mensajeDivisor;
    private String mensajeDivisorAlto;
//ventana corredera
    private int cantidadHInferiorNave;
    private int cantidadVerticalCerradura;
    private int cantidadEngancheReforzado; // tambien sse utiliza en abatibles
    private int cantidadDivisorPanoramico;
    private int cantidadSillarAlfaljia;  // tambien sse utiliza en abatibles
    private int cantidadJambaCuerpoFijo;
    private int cantidadDivisorVerticalPanoramico;
    private int cantidadEmpaquePvc;
    private int cantidadEmpaquePvcAlto;
    private int cantidadFelpa;
    private int cantidadFelpaAlto;
    private int cantidadAdactadorSuperior;
    private int cantidadAdactadorInferior;
    private int cantidadjambPistas;
    private String mensajeHInferiorNave;
    private String mensajeVerticalCerradura;
    private String mensajeEngancheReforzado;
    private String mensajeDivisorPanoramico;
    private String mensajeSillarAlfaljia;  // tambien sse utiliza en abatibles
    private String mensajeJambaCuerpoFijo;
    private String mensajeDivisorVerticalPanoramico;
    private String mensajeEmpaquePvc;
    private String mensajeEmpaquePvcAlto;
    private String MensajeFelpa;      // se utiliza tambien en puertas AdaptadorFelpa Ancho
    private String MensajeFelpaAlto;   // se utiliza tambien en puertas AdaptadorFelpa Alto
    private String mensajeAdactadorSuperior;
    private String mensajeAdactadorInferior;
    private String mensajejambPistas;

    //ventanas abatibles
    private int cantidadJambaNave;
    private int cantidadHorizontalNave;
    private int cantidadHorizontalMarcoFijo;   
    private int cantidadHorizontalMarcoFijoAlto;  
    private int cantidadEngancheMovil;
    private int cantidadEntrecierreNaveFijo;
    private String mensajeJambaNave;
    private String mensajeHorizontalNave;
    private String mensajeHorizontalMarcoFijo;
     private String mensajeHorizontalMarcoFijoAlto;
    private String mensajeEngancheMovil;
    private String mensajeEntrecierreNaveFijo;

//    estos son los mensajes y cantidades de las puertas
    private int tipoPuerta;

    private int cantidadMarcoAlto;  // se utiliza tambien en puertas Perimetral
    private int cantidadMarcoAncho;  // se utiliza tambien en puertas Perimetral
    private int cantidadNaveAlto;   // se utiliza tambien en puertas Vertical visagra
    private int cantidadNaveAncho;   // se utiliza tambien en puertas superior nave Ancho
     private int cantidadInferiorNaveAncho;
    private int cantidadPisaVidriosAncho;
    private int cantidadPisaVidriosAlto;
      private int cantidadPirlan;
    private int cantidadPartidor;
    private int cantidadEmpaque;
    private int cantidadEmpaqueAlto;
    private int cantidadEmpaqueEcv;
    private int cantidadEmpaqueEcvAlto;
    private int cantidadChapa;
    private int cantidadEscuadras;
    private int visagras;
     private int cantidadTornilloEnsam;
    private int cantidadTornilloInst;

    private String mensajeMarcoAncho;
    private String mensajeMarcoAlto;
    private String mensajeNaveAlto;
    private String mensajeNaveAncho;
    private String mensajeInfNaveAncho;
    private String mensajePisaVidriosAncho;
    private String mensajePisavidriosAlto;
     private String mensajePirlan;
    private String mensajePartidor;
    private String mensageEmpaqueEcv;
    private String mensageEmpaqueEcvAlto;
    private String MensajeEmpaque;    
    private String MensajeEmpaqueAlto;
    private String mensajeVarillasTensoras;
    private String mensajeChapa;
    private String mensajeEscuadras1;
    private String mensajeVisagras;
    private int cantiPuerta;
    private String mensajeCantiPuerta;
    private long precioTotalCantidad;
     private String mensajeTornilloEnsam;
    private String mensajeTornilloInst;

//    esta son los mensajes y las cantidades de las vitrina
    private int tipoVitrina;
    private int modelo;
    private int tipoEntrepanos;
    private int cantidadCuartoCirculoAlto;
    private int cantidadCuartoCirculoAncho;
    private int cantidadCuartoCirculoFondo;
    private int cantidadAnguloMediaAlto;
    private int cantidadAnguloMediaAncho;
    private int cantidadAnguloMediaFondo;
    private int cantidadNaveDivisionAncho;
    private int cantidadVidrioEntrepanos;
    private int cantidadPerfilEsquineroUnaAncho;
    private int cntidadPerfilEsquineroUnaFondo;
    private int cantidadTubularUna;
    private int pisaVidrioAlto;
    private int pisaVidrioAncho;
    private int pisaVidrioFondo;
    private String mensajeCuartoCirculoAlto;
    private String mensajeCuartoCirculoAncho;
    private String mensajeCuartoCirculoFondo;
    private String mensajeAnguloMediaAlto;
    private String mensajeAnguloMediaAncho;
    private String mensajeAnguloMediaFondo;
    private String mensajeNaveDivisionAncho;
    private String mensajeVidrioAltoAncho;
    private String mensajeVidrioAltoFondo;
    private String mensajeVidrioAnchoFondo;
    private String mensajeEntrepano;
    private String mensajePerfilEsquineroUna;
    private String mensajePerfilEsquineroUnaFondo;
    private String mensajeTubularUna;
    private String mensajePisavidrioAlto;
    private String mensajePisavidrioAncho;
    private String mensajePisavidrioFondo;
    private int cantProducto;
    private double recorteFondo;
    private double recorteVidrioFondo;

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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getTipoAluminio() {
        return tipoAluminio;
    }

    public void setTipoAluminio(int tipoAluminio) {
        this.tipoAluminio = tipoAluminio;
    }

    public int getCantidadJamba() {
        return cantidadJamba;
    }

    public void setCantidadJamba(int cantidadJamba) {
        this.cantidadJamba = cantidadJamba;
    }

    public int getCantidadCabezal() {
        return cantidadCabezal;
    }

    public void setCantidadCabezal(int cantidadCabezal) {
        this.cantidadCabezal = cantidadCabezal;
    }

    public int getCantidadSillar() {
        return cantidadSillar;
    }

    public void setCantidadSillar(int cantidadSillar) {
        this.cantidadSillar = cantidadSillar;
    }

    public int getCantidadTraslape() {
        return cantidadTraslape;
    }

    public void setCantidadTraslape(int cantidadTraslape) {
        this.cantidadTraslape = cantidadTraslape;
    }

    public int getCantidadEnganche() {
        return cantidadEnganche;
    }

    public void setCantidadEnganche(int cantidadEnganche) {
        this.cantidadEnganche = cantidadEnganche;
    }

    public int getCantidadHorizontalesSuperior() {
        return cantidadHorizontalesSuperior;
    }

    public void setCantidadHorizontalesSuperior(int cantidadHorizontalesSuperior) {
        this.cantidadHorizontalesSuperior = cantidadHorizontalesSuperior;
    }

    public int getCantidadHorizontalesInferior() {
        return cantidadHorizontalesInferior;
    }

    public void setCantidadHorizontalesInferior(int cantidadHorizontalesInferior) {
        this.cantidadHorizontalesInferior = cantidadHorizontalesInferior;
    }

    public int getCantidadVidrio() {
        return cantidadVidrio;
    }

    public void setCantidadVidrio(int cantidadVidrio) {
        this.cantidadVidrio = cantidadVidrio;
    }

    public int getCantidadAdactador() {
        return cantidadAdactador;
    }

    public void setCantidadAdactador(int cantidadAdactador) {
        this.cantidadAdactador = cantidadAdactador;
    }

    public String getMensajeHSuperior() {
        return mensajeHSuperior;
    }

    public void setMensajeHSuperior(String mensajeHSuperior) {
        this.mensajeHSuperior = mensajeHSuperior;
    }

    public String getMensajeHInferior() {
        return mensajeHInferior;
    }

    public void setMensajeHInferior(String mensajeHInferior) {
        this.mensajeHInferior = mensajeHInferior;
    }

    public String getMensajeCabezal() {
        return mensajeCabezal;
    }

    public void setMensajeCabezal(String mensajeCabezal) {
        this.mensajeCabezal = mensajeCabezal;
    }

    public String getMensajeSillar() {
        return mensajeSillar;
    }

    public void setMensajeSillar(String mensajeSillar) {
        this.mensajeSillar = mensajeSillar;
    }

    public String getMensajeJamba() {
        return mensajeJamba;
    }

    public void setMensajeJamba(String mensajeJamba) {
        this.mensajeJamba = mensajeJamba;
    }

    public String getMensajeEnganche() {
        return mensajeEnganche;
    }

    public void setMensajeEnganche(String mensajeEnganche) {
        this.mensajeEnganche = mensajeEnganche;
    }

    public String getMensajeTraslape() {
        return mensajeTraslape;
    }

    public void setMensajeTraslape(String mensajeTraslape) {
        this.mensajeTraslape = mensajeTraslape;
    }

    public String getMensajeAdactador() {
        return mensajeAdactador;
    }

    public void setMensajeAdactador(String mensajeAdactador) {
        this.mensajeAdactador = mensajeAdactador;
    }

    public String getMensajeVidrio() {
        return mensajeVidrio;
    }

    public void setMensajeVidrio(String mensajeVidrio) {
        this.mensajeVidrio = mensajeVidrio;
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

    public int getTipoPuerta() {
        return tipoPuerta;
    }

    public void setTipoPuerta(int tipoPuerta) {
        this.tipoPuerta = tipoPuerta;
    }

    public int getCantidadMarcoAlto() {
        return cantidadMarcoAlto;
    }

    public void setCantidadMarcoAlto(int cantidadMarcoAlto) {
        this.cantidadMarcoAlto = cantidadMarcoAlto;
    }

    public int getCantidadMarcoAncho() {
        return cantidadMarcoAncho;
    }

    public void setCantidadMarcoAncho(int cantidadMarcoAncho) {
        this.cantidadMarcoAncho = cantidadMarcoAncho;
    }

    public int getCantidadNaveAlto() {
        return cantidadNaveAlto;
    }

    public void setCantidadNaveAlto(int cantidadNaveAlto) {
        this.cantidadNaveAlto = cantidadNaveAlto;
    }

    public int getCantidadNaveAncho() {
        return cantidadNaveAncho;
    }

    public void setCantidadNaveAncho(int cantidadNaveAncho) {
        this.cantidadNaveAncho = cantidadNaveAncho;
    }

    public int getCantidadPisaVidriosAncho() {
        return cantidadPisaVidriosAncho;
    }

    public void setCantidadPisaVidriosAncho(int cantidadPisaVidriosAncho) {
        this.cantidadPisaVidriosAncho = cantidadPisaVidriosAncho;
    }

    public int getCantidadPisaVidriosAlto() {
        return cantidadPisaVidriosAlto;
    }

    public void setCantidadPisaVidriosAlto(int cantidadPisaVidriosAlto) {
        this.cantidadPisaVidriosAlto = cantidadPisaVidriosAlto;
    }

    public int getCantidadPartidor() {
        return cantidadPartidor;
    }

    public void setCantidadPartidor(int cantidadPartidor) {
        this.cantidadPartidor = cantidadPartidor;
    }

   

    public int getCantidadEmpaque() {
        return cantidadEmpaque;
    }

    public void setCantidadEmpaque(int cantidadEmpaque) {
        this.cantidadEmpaque = cantidadEmpaque;
    }

   
    public int getCantidadChapa() {
        return cantidadChapa;
    }

    public void setCantidadChapa(int cantidadChapa) {
        this.cantidadChapa = cantidadChapa;
    }

    public int getCantidadEscuadras() {
        return cantidadEscuadras;
    }

    public void setCantidadEscuadras(int cantidadEscuadras) {
        this.cantidadEscuadras = cantidadEscuadras;
    }

    public int getVisagras() {
        return visagras;
    }

    public void setVisagras(int visagras) {
        this.visagras = visagras;
    }

    
    public String getMensajeNaveAlto() {
        return mensajeNaveAlto;
    }

    public void setMensajeNaveAlto(String mensajeNaveAlto) {
        this.mensajeNaveAlto = mensajeNaveAlto;
    }

    public String getMensajeNaveAncho() {
        return mensajeNaveAncho;
    }

    public void setMensajeNaveAncho(String mensajeNaveAncho) {
        this.mensajeNaveAncho = mensajeNaveAncho;
    }

    public String getMensajePisaVidriosAncho() {
        return mensajePisaVidriosAncho;
    }

    public void setMensajePisaVidriosAncho(String mensajePisaVidriosAncho) {
        this.mensajePisaVidriosAncho = mensajePisaVidriosAncho;
    }

    public String getMensajePisavidriosAlto() {
        return mensajePisavidriosAlto;
    }

    public void setMensajePisavidriosAlto(String mensajePisavidriosAlto) {
        this.mensajePisavidriosAlto = mensajePisavidriosAlto;
    }

    public String getMensajePartidor() {
        return mensajePartidor;
    }

    public void setMensajePartidor(String mensajePartidor) {
        this.mensajePartidor = mensajePartidor;
    }

   

    public String getMensajeEmpaque() {
        return MensajeEmpaque;
    }

    public void setMensajeEmpaque(String MensajeEmpaque) {
        this.MensajeEmpaque = MensajeEmpaque;
    }

    public String getMensajeVarillasTensoras() {
        return mensajeVarillasTensoras;
    }

    public void setMensajeVarillasTensoras(String mensajeVarillasTensoras) {
        this.mensajeVarillasTensoras = mensajeVarillasTensoras;
    }

    public String getMensajeChapa() {
        return mensajeChapa;
    }

    public void setMensajeChapa(String mensajeChapa) {
        this.mensajeChapa = mensajeChapa;
    }

    public String getMensajeEscuadras1() {
        return mensajeEscuadras1;
    }

    public void setMensajeEscuadras1(String mensajeEscuadras1) {
        this.mensajeEscuadras1 = mensajeEscuadras1;
    }


    public String getMensajeVisagras() {
        return mensajeVisagras;
    }

    public void setMensajeVisagras(String mensajeVisagras) {
        this.mensajeVisagras = mensajeVisagras;
    }

    public int getCantiPuerta() {
        return cantiPuerta;
    }

    public void setCantiPuerta(int cantiPuerta) {
        this.cantiPuerta = cantiPuerta;
    }

    public String getMensajeCantiPuerta() {
        return mensajeCantiPuerta;
    }

    public void setMensajeCantiPuerta(String mensajeCantiPuerta) {
        this.mensajeCantiPuerta = mensajeCantiPuerta;
    }

    public long getPrecioTotalCantidad() {
        return precioTotalCantidad;
    }

    public void setPrecioTotalCantidad(long precioTotalCantidad) {
        this.precioTotalCantidad = precioTotalCantidad;
    }

    public int getTipoVitrina() {
        return tipoVitrina;
    }

    public void setTipoVitrina(int tipoVitrina) {
        this.tipoVitrina = tipoVitrina;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getTipoEntrepanos() {
        return tipoEntrepanos;
    }

    public void setTipoEntrepanos(int tipoEntrepanos) {
        this.tipoEntrepanos = tipoEntrepanos;
    }

    public int getCantidadCuartoCirculoAlto() {
        return cantidadCuartoCirculoAlto;
    }

    public void setCantidadCuartoCirculoAlto(int cantidadCuartoCirculoAlto) {
        this.cantidadCuartoCirculoAlto = cantidadCuartoCirculoAlto;
    }

    public int getCantidadCuartoCirculoAncho() {
        return cantidadCuartoCirculoAncho;
    }

    public void setCantidadCuartoCirculoAncho(int cantidadCuartoCirculoAncho) {
        this.cantidadCuartoCirculoAncho = cantidadCuartoCirculoAncho;
    }

    public int getCantidadCuartoCirculoFondo() {
        return cantidadCuartoCirculoFondo;
    }

    public void setCantidadCuartoCirculoFondo(int cantidadCuartoCirculoFondo) {
        this.cantidadCuartoCirculoFondo = cantidadCuartoCirculoFondo;
    }

    public int getCantidadAnguloMediaAlto() {
        return cantidadAnguloMediaAlto;
    }

    public void setCantidadAnguloMediaAlto(int cantidadAnguloMediaAlto) {
        this.cantidadAnguloMediaAlto = cantidadAnguloMediaAlto;
    }

    public int getCantidadAnguloMediaAncho() {
        return cantidadAnguloMediaAncho;
    }

    public void setCantidadAnguloMediaAncho(int cantidadAnguloMediaAncho) {
        this.cantidadAnguloMediaAncho = cantidadAnguloMediaAncho;
    }

    public int getCantidadAnguloMediaFondo() {
        return cantidadAnguloMediaFondo;
    }

    public void setCantidadAnguloMediaFondo(int cantidadAnguloMediaFondo) {
        this.cantidadAnguloMediaFondo = cantidadAnguloMediaFondo;
    }

    public int getCantidadNaveDivisionAncho() {
        return cantidadNaveDivisionAncho;
    }

    public void setCantidadNaveDivisionAncho(int cantidadNaveDivisionAncho) {
        this.cantidadNaveDivisionAncho = cantidadNaveDivisionAncho;
    }

    public int getCantidadVidrioEntrepanos() {
        return cantidadVidrioEntrepanos;
    }

    public void setCantidadVidrioEntrepanos(int cantidadVidrioEntrepanos) {
        this.cantidadVidrioEntrepanos = cantidadVidrioEntrepanos;
    }

    public int getCantidadPerfilEsquineroUnaAncho() {
        return cantidadPerfilEsquineroUnaAncho;
    }

    public void setCantidadPerfilEsquineroUnaAncho(int cantidadPerfilEsquineroUnaAncho) {
        this.cantidadPerfilEsquineroUnaAncho = cantidadPerfilEsquineroUnaAncho;
    }

    public int getCntidadPerfilEsquineroUnaFondo() {
        return cntidadPerfilEsquineroUnaFondo;
    }

    public void setCntidadPerfilEsquineroUnaFondo(int cntidadPerfilEsquineroUnaFondo) {
        this.cntidadPerfilEsquineroUnaFondo = cntidadPerfilEsquineroUnaFondo;
    }

    public int getCantidadTubularUna() {
        return cantidadTubularUna;
    }

    public void setCantidadTubularUna(int cantidadTubularUna) {
        this.cantidadTubularUna = cantidadTubularUna;
    }

    public int getPisaVidrioAlto() {
        return pisaVidrioAlto;
    }

    public void setPisaVidrioAlto(int pisaVidrioAlto) {
        this.pisaVidrioAlto = pisaVidrioAlto;
    }

    public int getPisaVidrioAncho() {
        return pisaVidrioAncho;
    }

    public void setPisaVidrioAncho(int pisaVidrioAncho) {
        this.pisaVidrioAncho = pisaVidrioAncho;
    }

    public int getPisaVidrioFondo() {
        return pisaVidrioFondo;
    }

    public void setPisaVidrioFondo(int pisaVidrioFondo) {
        this.pisaVidrioFondo = pisaVidrioFondo;
    }

    public String getMensajeCuartoCirculoAlto() {
        return mensajeCuartoCirculoAlto;
    }

    public void setMensajeCuartoCirculoAlto(String mensajeCuartoCirculoAlto) {
        this.mensajeCuartoCirculoAlto = mensajeCuartoCirculoAlto;
    }

    public String getMensajeCuartoCirculoAncho() {
        return mensajeCuartoCirculoAncho;
    }

    public void setMensajeCuartoCirculoAncho(String mensajeCuartoCirculoAncho) {
        this.mensajeCuartoCirculoAncho = mensajeCuartoCirculoAncho;
    }

    public String getMensajeCuartoCirculoFondo() {
        return mensajeCuartoCirculoFondo;
    }

    public void setMensajeCuartoCirculoFondo(String mensajeCuartoCirculoFondo) {
        this.mensajeCuartoCirculoFondo = mensajeCuartoCirculoFondo;
    }

    public String getMensajeAnguloMediaAlto() {
        return mensajeAnguloMediaAlto;
    }

    public void setMensajeAnguloMediaAlto(String mensajeAnguloMediaAlto) {
        this.mensajeAnguloMediaAlto = mensajeAnguloMediaAlto;
    }

    public String getMensajeAnguloMediaAncho() {
        return mensajeAnguloMediaAncho;
    }

    public void setMensajeAnguloMediaAncho(String mensajeAnguloMediaAncho) {
        this.mensajeAnguloMediaAncho = mensajeAnguloMediaAncho;
    }

    public String getMensajeAnguloMediaFondo() {
        return mensajeAnguloMediaFondo;
    }

    public void setMensajeAnguloMediaFondo(String mensajeAnguloMediaFondo) {
        this.mensajeAnguloMediaFondo = mensajeAnguloMediaFondo;
    }

    public String getMensajeNaveDivisionAncho() {
        return mensajeNaveDivisionAncho;
    }

    public void setMensajeNaveDivisionAncho(String mensajeNaveDivisionAncho) {
        this.mensajeNaveDivisionAncho = mensajeNaveDivisionAncho;
    }

    public String getMensajeVidrioAltoAncho() {
        return mensajeVidrioAltoAncho;
    }

    public void setMensajeVidrioAltoAncho(String mensajeVidrioAltoAncho) {
        this.mensajeVidrioAltoAncho = mensajeVidrioAltoAncho;
    }

    public String getMensajeVidrioAltoFondo() {
        return mensajeVidrioAltoFondo;
    }

    public void setMensajeVidrioAltoFondo(String mensajeVidrioAltoFondo) {
        this.mensajeVidrioAltoFondo = mensajeVidrioAltoFondo;
    }

    public String getMensajeVidrioAnchoFondo() {
        return mensajeVidrioAnchoFondo;
    }

    public void setMensajeVidrioAnchoFondo(String mensajeVidrioAnchoFondo) {
        this.mensajeVidrioAnchoFondo = mensajeVidrioAnchoFondo;
    }

    public String getMensajeEntrepano() {
        return mensajeEntrepano;
    }

    public void setMensajeEntrepano(String mensajeEntrepano) {
        this.mensajeEntrepano = mensajeEntrepano;
    }

    public String getMensajePerfilEsquineroUna() {
        return mensajePerfilEsquineroUna;
    }

    public void setMensajePerfilEsquineroUna(String mensajePerfilEsquineroUna) {
        this.mensajePerfilEsquineroUna = mensajePerfilEsquineroUna;
    }

    public String getMensajeTubularUna() {
        return mensajeTubularUna;
    }

    public void setMensajeTubularUna(String mensajeTubularUna) {
        this.mensajeTubularUna = mensajeTubularUna;
    }

    public String getMensajePisavidrioAlto() {
        return mensajePisavidrioAlto;
    }

    public void setMensajePisavidrioAlto(String mensajePisavidrioAlto) {
        this.mensajePisavidrioAlto = mensajePisavidrioAlto;
    }

    public String getMensajePisavidrioAncho() {
        return mensajePisavidrioAncho;
    }

    public void setMensajePisavidrioAncho(String mensajePisavidrioAncho) {
        this.mensajePisavidrioAncho = mensajePisavidrioAncho;
    }

    public String getMensajePisavidrioFondo() {
        return mensajePisavidrioFondo;
    }

    public void setMensajePisavidrioFondo(String mensajePisavidrioFondo) {
        this.mensajePisavidrioFondo = mensajePisavidrioFondo;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getMensajePerfilEsquineroUnaFondo() {
        return mensajePerfilEsquineroUnaFondo;
    }

    public void setMensajePerfilEsquineroUnaFondo(String mensajePerfilEsquineroUnaFondo) {
        this.mensajePerfilEsquineroUnaFondo = mensajePerfilEsquineroUnaFondo;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public double getRecorteFondo() {
        return recorteFondo;
    }

    public void setRecorteFondo(double recorteFondo) {
        this.recorteFondo = recorteFondo;
    }

    public int getCantidadPisavidrio() {
        return cantidadPisavidrio;
    }

    public void setCantidadPisavidrio(int cantidadPisavidrio) {
        this.cantidadPisavidrio = cantidadPisavidrio;
    }

    public int getCantidadNave() {
        return cantidadNave;
    }

    public void setCantidadNave(int cantidadNave) {
        this.cantidadNave = cantidadNave;
    }

    public int getCantidadAfajia() {
        return cantidadAfajia;
    }

    public void setCantidadAfajia(int cantidadAfajia) {
        this.cantidadAfajia = cantidadAfajia;
    }

    public int getCantidadDivisor() {
        return cantidadDivisor;
    }

    public void setCantidadDivisor(int cantidadDivisor) {
        this.cantidadDivisor = cantidadDivisor;
    }

    public int getCantidadHInferiorNave() {
        return cantidadHInferiorNave;
    }

    public void setCantidadHInferiorNave(int cantidadHInferiorNave) {
        this.cantidadHInferiorNave = cantidadHInferiorNave;
    }

    public int getCantidadVerticalCerradura() {
        return cantidadVerticalCerradura;
    }

    public void setCantidadVerticalCerradura(int cantidadVerticalCerradura) {
        this.cantidadVerticalCerradura = cantidadVerticalCerradura;
    }

    public int getCantidadEngancheReforzado() {
        return cantidadEngancheReforzado;
    }

    public void setCantidadEngancheReforzado(int cantidadEngancheReforzado) {
        this.cantidadEngancheReforzado = cantidadEngancheReforzado;
    }

    public int getCantidadDivisorPanoramico() {
        return cantidadDivisorPanoramico;
    }

    public void setCantidadDivisorPanoramico(int cantidadDivisorPanoramico) {
        this.cantidadDivisorPanoramico = cantidadDivisorPanoramico;
    }

    public int getCantidadSillarAlfaljia() {
        return cantidadSillarAlfaljia;
    }

    public void setCantidadSillarAlfaljia(int cantidadSillarAlfaljia) {
        this.cantidadSillarAlfaljia = cantidadSillarAlfaljia;
    }

    public int getCantidadJambaCuerpoFijo() {
        return cantidadJambaCuerpoFijo;
    }

    public void setCantidadJambaCuerpoFijo(int cantidadJambaCuerpoFijo) {
        this.cantidadJambaCuerpoFijo = cantidadJambaCuerpoFijo;
    }

    public int getCantidadDivisorVerticalPanoramico() {
        return cantidadDivisorVerticalPanoramico;
    }

    public void setCantidadDivisorVerticalPanoramico(int cantidadDivisorVerticalPanoramico) {
        this.cantidadDivisorVerticalPanoramico = cantidadDivisorVerticalPanoramico;
    }

    public int getCantidadEmpaquePvc() {
        return cantidadEmpaquePvc;
    }

    public void setCantidadEmpaquePvc(int cantidadEmpaquePvc) {
        this.cantidadEmpaquePvc = cantidadEmpaquePvc;
    }

    public int getCantidadAdactadorSuperior() {
        return cantidadAdactadorSuperior;
    }

    public void setCantidadAdactadorSuperior(int cantidadAdactadorSuperior) {
        this.cantidadAdactadorSuperior = cantidadAdactadorSuperior;
    }

    public int getCantidadAdactadorInferior() {
        return cantidadAdactadorInferior;
    }

    public void setCantidadAdactadorInferior(int cantidadAdactadorInferior) {
        this.cantidadAdactadorInferior = cantidadAdactadorInferior;
    }

    public int getCantidadjambPistas() {
        return cantidadjambPistas;
    }

    public void setCantidadjambPistas(int cantidadjambPistas) {
        this.cantidadjambPistas = cantidadjambPistas;
    }

    public int getCantidadJambaNave() {
        return cantidadJambaNave;
    }

    public void setCantidadJambaNave(int cantidadJambaNave) {
        this.cantidadJambaNave = cantidadJambaNave;
    }

    public int getCantidadHorizontalNave() {
        return cantidadHorizontalNave;
    }

    public void setCantidadHorizontalNave(int cantidadHorizontalNave) {
        this.cantidadHorizontalNave = cantidadHorizontalNave;
    }

    public int getCantidadHorizontalMarcoFijo() {
        return cantidadHorizontalMarcoFijo;
    }

    public void setCantidadHorizontalMarcoFijo(int cantidadHorizontalMarcoFijo) {
        this.cantidadHorizontalMarcoFijo = cantidadHorizontalMarcoFijo;
    }

    public int getCantidadEngancheMovil() {
        return cantidadEngancheMovil;
    }

    public void setCantidadEngancheMovil(int cantidadEngancheMovil) {
        this.cantidadEngancheMovil = cantidadEngancheMovil;
    }

    public int getCantidadEntrecierreNaveFijo() {
        return cantidadEntrecierreNaveFijo;
    }

    public void setCantidadEntrecierreNaveFijo(int cantidadEntrecierreNaveFijo) {
        this.cantidadEntrecierreNaveFijo = cantidadEntrecierreNaveFijo;
    }

    public double getRecorteVidrioFondo() {
        return recorteVidrioFondo;
    }

    public void setRecorteVidrioFondo(double recorteVidrioFondo) {
        this.recorteVidrioFondo = recorteVidrioFondo;
    }

    public String getMensajePisavidrio() {
        return mensajePisavidrio;
    }

    public void setMensajePisavidrio(String mensajePisavidrio) {
        this.mensajePisavidrio = mensajePisavidrio;
    }

    public String getMensajeNave() {
        return mensajeNave;
    }

    public void setMensajeNave(String mensajeNave) {
        this.mensajeNave = mensajeNave;
    }

    public String getMensajeAfajia() {
        return mensajeAfajia;
    }

    public void setMensajeAfajia(String mensajeAfajia) {
        this.mensajeAfajia = mensajeAfajia;
    }

    public String getMensajeDivisor() {
        return mensajeDivisor;
    }

    public void setMensajeDivisor(String mensajeDivisor) {
        this.mensajeDivisor = mensajeDivisor;
    }

    public String getMensajeHInferiorNave() {
        return mensajeHInferiorNave;
    }

    public void setMensajeHInferiorNave(String mensajeHInferiorNave) {
        this.mensajeHInferiorNave = mensajeHInferiorNave;
    }

    public String getMensajeVerticalCerradura() {
        return mensajeVerticalCerradura;
    }

    public void setMensajeVerticalCerradura(String mensajeVerticalCerradura) {
        this.mensajeVerticalCerradura = mensajeVerticalCerradura;
    }

    public String getMensajeEngancheReforzado() {
        return mensajeEngancheReforzado;
    }

    public void setMensajeEngancheReforzado(String mensajeEngancheReforzado) {
        this.mensajeEngancheReforzado = mensajeEngancheReforzado;
    }

    public String getMensajeDivisorPanoramico() {
        return mensajeDivisorPanoramico;
    }

    public void setMensajeDivisorPanoramico(String mensajeDivisorPanoramico) {
        this.mensajeDivisorPanoramico = mensajeDivisorPanoramico;
    }

    public String getMensajeSillarAlfaljia() {
        return mensajeSillarAlfaljia;
    }

    public void setMensajeSillarAlfaljia(String mensajeSillarAlfaljia) {
        this.mensajeSillarAlfaljia = mensajeSillarAlfaljia;
    }

    public String getMensajeJambaCuerpoFijo() {
        return mensajeJambaCuerpoFijo;
    }

    public void setMensajeJambaCuerpoFijo(String mensajeJambaCuerpoFijo) {
        this.mensajeJambaCuerpoFijo = mensajeJambaCuerpoFijo;
    }

    public String getMensajeDivisorVerticalPanoramico() {
        return mensajeDivisorVerticalPanoramico;
    }

    public void setMensajeDivisorVerticalPanoramico(String mensajeDivisorVerticalPanoramico) {
        this.mensajeDivisorVerticalPanoramico = mensajeDivisorVerticalPanoramico;
    }

    public String getMensajeEmpaquePvc() {
        return mensajeEmpaquePvc;
    }

    public void setMensajeEmpaquePvc(String mensajeEmpaquePvc) {
        this.mensajeEmpaquePvc = mensajeEmpaquePvc;
    }

    public String getMensajeAdactadorSuperior() {
        return mensajeAdactadorSuperior;
    }

    public void setMensajeAdactadorSuperior(String mensajeAdactadorSuperior) {
        this.mensajeAdactadorSuperior = mensajeAdactadorSuperior;
    }

    public String getMensajeAdactadorInferior() {
        return mensajeAdactadorInferior;
    }

    public void setMensajeAdactadorInferior(String mensajeAdactadorInferior) {
        this.mensajeAdactadorInferior = mensajeAdactadorInferior;
    }

    public String getMensajejambPistas() {
        return mensajejambPistas;
    }

    public void setMensajejambPistas(String mensajejambPistas) {
        this.mensajejambPistas = mensajejambPistas;
    }

    public String getMensajeJambaNave() {
        return mensajeJambaNave;
    }

    public void setMensajeJambaNave(String mensajeJambaNave) {
        this.mensajeJambaNave = mensajeJambaNave;
    }

    public String getMensajeHorizontalNave() {
        return mensajeHorizontalNave;
    }

    public void setMensajeHorizontalNave(String mensajeHorizontalNave) {
        this.mensajeHorizontalNave = mensajeHorizontalNave;
    }

    public String getMensajeHorizontalMarcoFijo() {
        return mensajeHorizontalMarcoFijo;
    }

    public void setMensajeHorizontalMarcoFijo(String mensajeHorizontalMarcoFijo) {
        this.mensajeHorizontalMarcoFijo = mensajeHorizontalMarcoFijo;
    }

    public String getMensajeEngancheMovil() {
        return mensajeEngancheMovil;
    }

    public void setMensajeEngancheMovil(String mensajeEngancheMovil) {
        this.mensajeEngancheMovil = mensajeEngancheMovil;
    }

    public String getMensajeEntrecierreNaveFijo() {
        return mensajeEntrecierreNaveFijo;
    }

    public void setMensajeEntrecierreNaveFijo(String mensajeEntrecierreNaveFijo) {
        this.mensajeEntrecierreNaveFijo = mensajeEntrecierreNaveFijo;
    }

    public String getMensajeEmpaqueAlto() {
        return MensajeEmpaqueAlto;
    }

    public void setMensajeEmpaqueAlto(String MensajeEmpaqueAlto) {
        this.MensajeEmpaqueAlto = MensajeEmpaqueAlto;
    }

    public int getCantidadEmpaqueAlto() {
        return cantidadEmpaqueAlto;
    }

    public void setCantidadEmpaqueAlto(int cantidadEmpaqueAlto) {
        this.cantidadEmpaqueAlto = cantidadEmpaqueAlto;
    }

    public int getCantidadDivisorAlto() {
        return cantidadDivisorAlto;
    }

    public void setCantidadDivisorAlto(int cantidadDivisorAlto) {
        this.cantidadDivisorAlto = cantidadDivisorAlto;
    }

    public String getMensajeDivisorAlto() {
        return mensajeDivisorAlto;
    }

    public void setMensajeDivisorAlto(String mensajeDivisorAlto) {
        this.mensajeDivisorAlto = mensajeDivisorAlto;
    }

    public int getCantidadEngancheAlto() {
        return cantidadEngancheAlto;
    }

    public void setCantidadEngancheAlto(int cantidadEngancheAlto) {
        this.cantidadEngancheAlto = cantidadEngancheAlto;
    }

    public int getCantidadEmpaquePvcAlto() {
        return cantidadEmpaquePvcAlto;
    }

    public void setCantidadEmpaquePvcAlto(int cantidadEmpaquePvcAlto) {
        this.cantidadEmpaquePvcAlto = cantidadEmpaquePvcAlto;
    }

    public int getCantidadFelpa() {
        return cantidadFelpa;
    }

    public void setCantidadFelpa(int cantidadFelpa) {
        this.cantidadFelpa = cantidadFelpa;
    }

   

    public int getCantidadFelpaAlto() {
        return cantidadFelpaAlto;
    }

    public void setCantidadFelpaAlto(int cantidadFelpaAlto) {
        this.cantidadFelpaAlto = cantidadFelpaAlto;
    }

    public String getMensajeEmpaquePvcAlto() {
        return mensajeEmpaquePvcAlto;
    }

    public void setMensajeEmpaquePvcAlto(String mensajeEmpaquePvcAlto) {
        this.mensajeEmpaquePvcAlto = mensajeEmpaquePvcAlto;
    }

    public String getMensajeEngancheAlto() {
        return mensajeEngancheAlto;
    }

    public void setMensajeEngancheAlto(String mensajeEngancheAlto) {
        this.mensajeEngancheAlto = mensajeEngancheAlto;
    }

    public String getMensajeFelpa() {
        return MensajeFelpa;
    }

    public void setMensajeFelpa(String MensajeFelpa) {
        this.MensajeFelpa = MensajeFelpa;
    }

    public String getMensajeFelpaAlto() {
        return MensajeFelpaAlto;
    }

    public void setMensajeFelpaAlto(String MensajeFelpaAlto) {
        this.MensajeFelpaAlto = MensajeFelpaAlto;
    }

    public int getCantidadHorizontalMarcoFijoAlto() {
        return cantidadHorizontalMarcoFijoAlto;
    }

    public void setCantidadHorizontalMarcoFijoAlto(int cantidadHorizontalMarcoFijoAlto) {
        this.cantidadHorizontalMarcoFijoAlto = cantidadHorizontalMarcoFijoAlto;
    }

    public String getMensajeHorizontalMarcoFijoAlto() {
        return mensajeHorizontalMarcoFijoAlto;
    }

    public void setMensajeHorizontalMarcoFijoAlto(String mensajeHorizontalMarcoFijoAlto) {
        this.mensajeHorizontalMarcoFijoAlto = mensajeHorizontalMarcoFijoAlto;
    }

    public int getCantidadInferiorNaveAncho() {
        return cantidadInferiorNaveAncho;
    }

    public void setCantidadInferiorNaveAncho(int cantidadInferiorNaveAncho) {
        this.cantidadInferiorNaveAncho = cantidadInferiorNaveAncho;
    }

    public int getCantidadPirlan() {
        return cantidadPirlan;
    }

    public void setCantidadPirlan(int cantidadPirlan) {
        this.cantidadPirlan = cantidadPirlan;
    }

    public int getCantidadEmpaqueEcv() {
        return cantidadEmpaqueEcv;
    }

    public void setCantidadEmpaqueEcv(int cantidadEmpaqueEcv) {
        this.cantidadEmpaqueEcv = cantidadEmpaqueEcv;
    }

    public int getCantidadEmpaqueEcvAlto() {
        return cantidadEmpaqueEcvAlto;
    }

    public void setCantidadEmpaqueEcvAlto(int cantidadEmpaqueEcvAlto) {
        this.cantidadEmpaqueEcvAlto = cantidadEmpaqueEcvAlto;
    }

    public String getMensajeMarcoAncho() {
        return mensajeMarcoAncho;
    }

    public void setMensajeMarcoAncho(String mensajeMarcoAncho) {
        this.mensajeMarcoAncho = mensajeMarcoAncho;
    }

    public String getMensajeMarcoAlto() {
        return mensajeMarcoAlto;
    }

    public void setMensajeMarcoAlto(String mensajeMarcoAlto) {
        this.mensajeMarcoAlto = mensajeMarcoAlto;
    }

    public String getMensajeInfNaveAncho() {
        return mensajeInfNaveAncho;
    }

    public void setMensajeInfNaveAncho(String mensajeInfNaveAncho) {
        this.mensajeInfNaveAncho = mensajeInfNaveAncho;
    }

    public String getMensajePirlan() {
        return mensajePirlan;
    }

    public void setMensajePirlan(String mensajePirlan) {
        this.mensajePirlan = mensajePirlan;
    }

    public String getMensageEmpaqueEcv() {
        return mensageEmpaqueEcv;
    }

    public void setMensageEmpaqueEcv(String mensageEmpaqueEcv) {
        this.mensageEmpaqueEcv = mensageEmpaqueEcv;
    }

    public String getMensageEmpaqueEcvAlto() {
        return mensageEmpaqueEcvAlto;
    }

    public void setMensageEmpaqueEcvAlto(String mensageEmpaqueEcvAlto) {
        this.mensageEmpaqueEcvAlto = mensageEmpaqueEcvAlto;
    }

    public int getCantidadTornilloEnsam() {
        return cantidadTornilloEnsam;
    }

    public void setCantidadTornilloEnsam(int cantidadTornilloEnsam) {
        this.cantidadTornilloEnsam = cantidadTornilloEnsam;
    }

    public int getCantidadTornilloInst() {
        return cantidadTornilloInst;
    }

    public void setCantidadTornilloInst(int cantidadTornilloInst) {
        this.cantidadTornilloInst = cantidadTornilloInst;
    }

  

   

    public String getMensajeTornilloEnsam() {
        return mensajeTornilloEnsam;
    }

    public void setMensajeTornilloEnsam(String mensajeTornilloEnsam) {
        this.mensajeTornilloEnsam = mensajeTornilloEnsam;
    }

    public String getMensajeTornilloInst() {
        return mensajeTornilloInst;
    }

    public void setMensajeTornilloInst(String mensajeTornilloInst) {
        this.mensajeTornilloInst = mensajeTornilloInst;
    }

 

}
