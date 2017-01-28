/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author ander
 */
public class Ventanas implements Serializable {

    private int alto = 0;
    private int ancho = 0;
    private int altoFijo;
    private int anchoFijo;
    private long sumaTotal;
    private long subTotal;
    private int jamba;
    private int cabezal;
    private int sillar;
    private int traslape;
    private int enganche;
    private int hSuperior;
    private int hInferior;
    private int felpa;

    private int precioCabezal;
    private int precioSillar;
    private int precioJamba;
    private int precioEnganche;
    private int precioTraslape;
    private int precioHsuperior;
    private int precioHinferior;
    private int precioEmpaque;
    private int empaque;
    private int adaptador;
    private int precioAdaptador;
    private int tipoProducto;
    private int precioDescuento;
    private int precioTrabajo;
    private int preciofelpa;

    public int getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        switch (alto.substring(2)) {
            case "1":
                this.alto = Integer.valueOf(alto) + 9;
                break;
            case "2":
                this.alto = Integer.valueOf(alto) + 8;
                break;
            case "3":
                this.alto = Integer.valueOf(alto) + 7;
                break;
            case "4":
                this.alto = Integer.valueOf(alto) + 6;
                break;
            case "5":
                this.alto = Integer.valueOf(alto) + 5;
                break;
            case "6":
                this.alto = Integer.valueOf(alto) + 4;
                break;
            case "7":
                this.alto = Integer.valueOf(alto) + 3;
                break;
            case "8":
                this.alto = Integer.valueOf(alto) + 2;
                break;
            case "9":
                this.alto = Integer.valueOf(alto) + 1;
                break;
            case "0":
                this.alto = Integer.valueOf(alto);
                break;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        switch (ancho.substring(2)) {
            case "1":
                this.ancho = Integer.valueOf(ancho) + 9;
                break;
            case "2":
                this.ancho = Integer.valueOf(ancho) + 8;
                break;
            case "3":
                this.ancho = Integer.valueOf(ancho) + 7;
                break;
            case "4":
                this.ancho = Integer.valueOf(ancho) + 6;
                break;
            case "5":
                this.ancho = Integer.valueOf(ancho) + 5;
                break;
            case "6":
                this.ancho = Integer.valueOf(ancho) + 4;
                break;
            case "7":
                this.ancho = Integer.valueOf(ancho) + 3;
                break;
            case "8":
                this.ancho = Integer.valueOf(ancho) + 2;
                break;
            case "9":
                this.ancho = Integer.valueOf(ancho) + 1;
                break;
            case "0":
                this.ancho = Integer.valueOf(ancho);
                break;
        }
    }

    public int getAltoFijo() {
        return altoFijo;
    }

    public void setAltoFijo(String altoFijo) {
        if(altoFijo.equals("")){
             this.altoFijo = 0;
        }else{
            this.altoFijo = Integer.valueOf(altoFijo);   
        }
     }

    public int getAnchoFijo() {
        return anchoFijo;
    }

    public void setAnchoFijo(String anchoFijo) {
        if(anchoFijo.equals("")){
            this.anchoFijo = 0;
        }else{
           this.anchoFijo = Integer.valueOf(anchoFijo);  
        }
    }

    public long getSumaTotal() {
        return sumaTotal;
    }

    public void setSumaTotal(long sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public int getJamba() {
        return jamba;
    }

    public void setJamba(int jamba) {
        this.jamba = jamba;
    }

    public int getCabezal() {
        return cabezal;
    }

    public void setCabezal(int cabezal) {
        this.cabezal = cabezal;
    }

    public int getSillar() {
        return sillar;
    }

    public void setSillar(int sillar) {
        this.sillar = sillar;
    }

    public int getTraslape() {
        return traslape;
    }

    public void setTraslape(int traslape) {
        this.traslape = traslape;
    }

    public int getEnganche() {
        return enganche;
    }

    public void setEnganche(int enganche) {
        this.enganche = enganche;
    }

    public int gethSuperior() {
        return hSuperior;
    }

    public void sethSuperior(int hSuperior) {
        this.hSuperior = hSuperior;
    }

    public int gethInferior() {
        return hInferior;
    }

    public void sethInferior(int hInferior) {
        this.hInferior = hInferior;
    }

    public int getPrecioCabezal() {
        return precioCabezal;
    }

    public void setPrecioCabezal(int precioCabezal) {
        this.precioCabezal = precioCabezal;
    }

    public int getPrecioSillar() {
        return precioSillar;
    }

    public void setPrecioSillar(int precioSillar) {
        this.precioSillar = precioSillar;
    }

    public int getPrecioJamba() {
        return precioJamba;
    }

    public void setPrecioJamba(int precioJamba) {
        this.precioJamba = precioJamba;
    }

    public int getPrecioEnganche() {
        return precioEnganche;
    }

    public void setPrecioEnganche(int precioEnganche) {
        this.precioEnganche = precioEnganche;
    }

    public int getPrecioTraslape() {
        return precioTraslape;
    }

    public void setPrecioTraslape(int precioTraslape) {
        this.precioTraslape = precioTraslape;
    }

    public int getPrecioHsuperior() {
        return precioHsuperior;
    }

    public void setPrecioHsuperior(int precioHsuperior) {
        this.precioHsuperior = precioHsuperior;
    }

    public int getPrecioHinferior() {
        return precioHinferior;
    }

    public void setPrecioHinferior(int precioHinferior) {
        this.precioHinferior = precioHinferior;
    }

    public int getEmpaque() {
        return empaque;
    }

    public void setEmpaque(int empaque) {
        this.empaque = empaque;
    }

    public int getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(int adaptador) {
        this.adaptador = adaptador;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getPrecioEmpaque() {
        return precioEmpaque;
    }

    public void setPrecioEmpaque(int precioEmpaque) {
        this.precioEmpaque = precioEmpaque;
    }

    public int getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(int precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public int getPrecioTrabajo() {
        return precioTrabajo;
    }

    public void setPrecioTrabajo(int precioTrabajo) {
        this.precioTrabajo = precioTrabajo;
    }

    public int getPrecioAdaptador() {
        return precioAdaptador;
    }

    public void setPrecioAdaptador(int precioAdaptador) {
        this.precioAdaptador = precioAdaptador;
    }

    public int getFelpa() {
        return felpa;
    }

    public void setFelpa(int felpa) {
        this.felpa = felpa;
    }

    public int getPreciofelpa() {
        return preciofelpa;
    }

    public void setPreciofelpa(int preciofelpa) {
        this.preciofelpa = preciofelpa;
    }

}
