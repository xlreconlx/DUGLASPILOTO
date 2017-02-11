/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author William sanchez
 */
public class Persianas {

    private int alto = 0;
    private int ancho = 0;
    private long sumaTotal;
    private long subTotal;

    private int cabaezal;
    private int persiana;
    private int persianaPeq;
    private int persiana89;
    private int tornilloInst;
    private int tornilloLamas;

    private int precioCabezal;
    private int precioPersiana;
    private int precioPersianaPeq;
    private int precioPersiana89;
    private int precioTornillo;
    private int precioTornilloLamas;
    private int precioDescuento;
    private int precioTrabajo;

    public Persianas(String ancho, String alto, int preTrabajo, int preDescuento,
            int precioCabezal,
            int precioPersiana, //2
            int precioPersianaPeq,
            int precioPersiana89,//4
            int precioTornillo,
            int precioTornilloLamas,//6
            int tipoPersiana) {
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
        switch (tipoPersiana) {

            case 1:// DISEÑO 316  O

                this.cabaezal = (this.alto * 2) + (this.alto * 2);
                this.persiana = (this.alto / 5) * this.ancho;
                this.tornilloInst = (this.alto / 5) * this.ancho;
                this.tornilloLamas = (this.alto / 3) * 4;

                this.precioCabezal = this.cabaezal * (precioCabezal / 6);
                this.precioPersiana = this.persiana * precioPersiana;
                this.precioTornillo = this.tornilloInst * precioTornillo;
                this.precioTornilloLamas = this.tornilloLamas * precioTornilloLamas;

                this.sumaTotal = this.precioCabezal +  this.precioPersiana + this.precioTornillo + this.precioTornilloLamas;

                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;

            case 2:// PERSINA 3189   O
                this.cabaezal = (this.alto * 2) + (this.alto * 2);
                this.persiana89 = (this.alto / (25 / 100)) * this.ancho;
                this.tornilloInst = (this.alto / 5) * this.ancho;
                this.tornilloLamas = (this.alto / (25 / 100)) * 4;

                this.precioCabezal = this.cabaezal * (precioCabezal / 6);
                this.precioPersiana89 = this.persiana89 * (precioPersiana89 / 6);
                this.precioTornillo = this.tornilloInst * precioTornillo;
                this.precioTornilloLamas = this.tornilloLamas * precioTornilloLamas;

                this.sumaTotal = this.precioCabezal + this.precioPersiana89 + this.precioTornillo + this.precioTornilloLamas;

                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;

            case 3:// PERSINA 362 O
                this.cabaezal = (this.alto * 2) + (this.alto * 2);
                this.persiana = (this.alto / (8 / 100)) * this.ancho;
                this.tornilloInst = (this.alto / 5) * this.ancho;
                this.tornilloLamas = (this.alto / (25 / 100)) * 4;

                this.precioCabezal = this.cabaezal * (precioCabezal / 6);
                this.precioPersiana = this.persiana * (precioPersianaPeq / 6);
                this.precioTornillo = this.tornilloInst * precioTornillo;
                this.precioTornilloLamas = this.tornilloLamas * precioTornilloLamas;

                this.sumaTotal = this.precioCabezal + this.precioPersiana + this.precioTornillo + this.precioTornilloLamas;

                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;

        }

    }

    public Persianas() {
    }

    public final int recortar(String numero) {
        int espacios = numero.length();
        return Integer.valueOf(numero.substring(0, espacios - 2));

    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
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

    public int getCabaezal() {
        return cabaezal;
    }

    public void setCabaezal(int cabaezal) {
        this.cabaezal = cabaezal;
    }

    public int getPersiana() {
        return persiana;
    }

    public void setPersiana(int persiana) {
        this.persiana = persiana;
    }

    public int getPersianaPeq() {
        return persianaPeq;
    }

    public void setPersianaPeq(int persianaPeq) {
        this.persianaPeq = persianaPeq;
    }

    public int getTornilloInst() {
        return tornilloInst;
    }

    public void setTornilloInst(int tornilloInst) {
        this.tornilloInst = tornilloInst;
    }

    public int getTornilloLamas() {
        return tornilloLamas;
    }

    public void setTornilloLamas(int tornilloLamas) {
        this.tornilloLamas = tornilloLamas;
    }

    public int getPrecioCabezal() {
        return precioCabezal;
    }

    public void setPrecioCabezal(int precioCabezal) {
        this.precioCabezal = precioCabezal;
    }

    public int getPrecioPersiana() {
        return precioPersiana;
    }

    public void setPrecioPersiana(int precioPersiana) {
        this.precioPersiana = precioPersiana;
    }

    public int getPrecioPersianaPeq() {
        return precioPersianaPeq;
    }

    public void setPrecioPersianaPeq(int precioPersianaPeq) {
        this.precioPersianaPeq = precioPersianaPeq;
    }

    public int getPrecioTornillo() {
        return precioTornillo;
    }

    public void setPrecioTornillo(int precioTornillo) {
        this.precioTornillo = precioTornillo;
    }

    public int getPrecioTornilloLamas() {
        return precioTornilloLamas;
    }

    public void setPrecioTornilloLamas(int precioTornilloLamas) {
        this.precioTornilloLamas = precioTornilloLamas;
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

    public int getPersiana89() {
        return persiana89;
    }

    public void setPersiana89(int persiana89) {
        this.persiana89 = persiana89;
    }

}
