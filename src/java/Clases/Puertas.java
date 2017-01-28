/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author William sanchez
 */
public class Puertas implements Serializable{

    private int alto = 0;
    private int ancho = 0;
    private long sumaTotal;
    private long subTotal;
    
    private int perimetral;
    private int verticalVisagra;
    private int superiorNave;
    private int inferiorNave;
    private int pirlan;
    private int adaptadorfelpa;
    private int adaptador;
    private int empaqueEmv;
    private int empaqueEcb;
 
     private int precioPerimetral;
    private int precioVerticalVisagra;
    private int precioSuperiorNave;
    private int precioInferiorNave;
    private int precioPirlan;
    private int precioFelpa;
    private int precioAdaptador;
     private int tipoProducto;
    private int precioDescuento;
    private int precioTrabajo;
      private int precioEmpaqueEmv;
        private int precioEmpaqueEcv;

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

    public int getPerimetral() {
        return perimetral;
    }

    public void setPerimetral(int perimetral) {
        this.perimetral = perimetral;
    }

    public int getVerticalVisagra() {
        return verticalVisagra;
    }

    public void setVerticalVisagra(int verticalVisagra) {
        this.verticalVisagra = verticalVisagra;
    }

    public int getSuperiorNave() {
        return superiorNave;
    }

    public void setSuperiorNave(int superiorNave) {
        this.superiorNave = superiorNave;
    }

    public int getInferiorNave() {
        return inferiorNave;
    }

    public void setInferiorNave(int inferiorNave) {
        this.inferiorNave = inferiorNave;
    }

    public int getPirlan() {
        return pirlan;
    }

    public void setPirlan(int pirlan) {
        this.pirlan = pirlan;
    }

    public int getAdaptadorfelpa() {
        return adaptadorfelpa;
    }

    public void setAdaptadorfelpa(int adaptadorfelpa) {
        this.adaptadorfelpa = adaptadorfelpa;
    }

   

    public int getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(int adaptador) {
        this.adaptador = adaptador;
    }

    public int getPrecioPerimetral() {
        return precioPerimetral;
    }

    public void setPrecioPerimetral(int precioPerimetral) {
        this.precioPerimetral = precioPerimetral;
    }

    public int getPrecioVerticalVisagra() {
        return precioVerticalVisagra;
    }

    public void setPrecioVerticalVisagra(int precioVerticalVisagra) {
        this.precioVerticalVisagra = precioVerticalVisagra;
    }

    public int getPrecioSuperiorNave() {
        return precioSuperiorNave;
    }

    public void setPrecioSuperiorNave(int precioSuperiorNave) {
        this.precioSuperiorNave = precioSuperiorNave;
    }

    public int getPrecioInferiorNave() {
        return precioInferiorNave;
    }

    public void setPrecioInferiorNave(int precioInferiorNave) {
        this.precioInferiorNave = precioInferiorNave;
    }

    public int getPrecioPirlan() {
        return precioPirlan;
    }

    public void setPrecioPirlan(int precioPirlan) {
        this.precioPirlan = precioPirlan;
    }

    public int getPrecioFelpa() {
        return precioFelpa;
    }

    public void setPrecioFelpa(int precioFelpa) {
        this.precioFelpa = precioFelpa;
    }

    public int getPrecioAdaptador() {
        return precioAdaptador;
    }

    public void setPrecioAdaptador(int precioAdaptador) {
        this.precioAdaptador = precioAdaptador;
    }

    public int getEmpaqueEmv() {
        return empaqueEmv;
    }

    public void setEmpaqueEmv(int empaqueEmv) {
        this.empaqueEmv = empaqueEmv;
    }

    public int getEmpaqueEcb() {
        return empaqueEcb;
    }

    public void setEmpaqueEcb(int empaqueEcb) {
        this.empaqueEcb = empaqueEcb;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
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

    public int getPrecioEmpaqueEmv() {
        return precioEmpaqueEmv;
    }

    public void setPrecioEmpaqueEmv(int precioEmpaqueEmv) {
        this.precioEmpaqueEmv = precioEmpaqueEmv;
    }

    public int getPrecioEmpaqueEcv() {
        return precioEmpaqueEcv;
    }

    public void setPrecioEmpaqueEcv(int precioEmpaqueEcv) {
        this.precioEmpaqueEcv = precioEmpaqueEcv;
    }
    
    
}
