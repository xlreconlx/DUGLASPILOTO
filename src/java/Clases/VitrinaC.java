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
public class VitrinaC {

    private int alto = 0;
    private int ancho = 0;
    private long sumaTotal;
    private long subTotal;

    private int canal37;
    private int canal55;
    private int canal103;
    private int adaptador;
    private int pisaVidrio;
    private int pisaVidrio10;
    private int pisaVidrio14;
    private int tapaDucto;
    private int adapt2810;
    private int horizontal;
    private int horizaontal168;
    private int verticales;
    private int verticalCanal;
    private int tornilloInst;
    private int empaque;

    private int precioCanal37;
    private int precioCanal55;
    private int precioCanal103;
    private int precioAdaptador;
    private int precioPisavidrio;
    private int precioPisavidrio10;
    private int precioPisavidrio14;
    private int precioTapaDu;
    private int precioAdaptador2810;
    private int precioHorizontal;
    private int precioHoriz1168;
    private int precioVertical;
    private int precioVertCanal;
    private int precioTornillo;
    private int precioEmpaque;
     private int precioDescuento;
    private int precioTrabajo;

    public VitrinaC(String ancho, String alto, int preTrabajo, int preDescuento,
            int precioCanal37,
            int precioCanal55,
            int precioCanal103,
            int precioAdaptador,//4
            int precioPisavidrio,
            int precioPisavidrio10,
            int precioPisavidrio14,
            int precioTapaDu, //8
            int precioAdaptador2810,
            int precioHorizontal,
            int precioHoriz1168,
            int precioVertical,//12
            int precioVertCanal,
            int precioTornillo,
            int preEmpaque, //15
            int tipoVitrina1) {
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

        switch (tipoVitrina1) {

            case 1: // VITRINA BISELADA O STAMDART
                this.canal37 = (this.ancho * 2) + (this.alto * 2);
                this.adaptador = (this.ancho * 2) + (this.alto * 2);
                this.pisaVidrio = (this.ancho * 2) + (this.alto * 2);
                this.empaque = ((this.ancho * 2) + (this.alto * 2)) * 2;
                this.tornilloInst = ((this.alto / 6) + (this.ancho / 6)) * 2;

                this.precioCanal37 = this.canal37 * precioCanal37;
                this.precioAdaptador = this.adaptador * precioAdaptador;
                this.precioPisavidrio = this.pisaVidrio = precioPisavidrio;
                this.precioEmpaque = this.empaque * preEmpaque;
                this.precioTornillo = this.tornilloInst * precioTornillo;

               this.sumaTotal = this.precioCanal37 + this.precioAdaptador
                        + this.precioPisavidrio + this.precioTornillo + this.precioEmpaque;
                
                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));
                break;
            case 2: // VITRINA BISELADA O DE ACOPLE
                this.tapaDucto = this.alto;
                this.canal103 = (this.ancho * 2) + this.alto;
                this.adapt2810 = (this.ancho * 2) + (this.alto * 2);
                this.pisaVidrio10 = (this.ancho * 2) + (this.alto * 2);
                this.empaque = ((this.ancho * 2) + (this.alto * 2)) * 2;
                this.tornilloInst = ((this.alto / 6) + (this.ancho / 6)) * 2;

                this.precioTapaDu = this.tapaDucto * precioTapaDu;
                this.precioCanal103 = this.canal103 * (precioCanal103/6);
                this.precioAdaptador2810 = this.adapt2810 * precioAdaptador2810;
                this.precioPisavidrio10 = this.pisaVidrio10 = precioPisavidrio10;
                this.precioEmpaque = this.empaque * preEmpaque;
                this.precioTornillo = this.tornilloInst * precioTornillo;

                this.sumaTotal = this.precioTapaDu + this.precioCanal103 + this.precioAdaptador2810
                        + this.precioPisavidrio10 + this.precioTornillo + this.precioEmpaque;
                
                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;
            case 3: // VITRINA BISELADA O-10MM STAMDART
                this.canal55 = (this.ancho * 2) + (this.alto * 2);
                this.adaptador = (this.ancho * 2) + (this.alto * 2);
                this.pisaVidrio14 = (this.ancho * 2) + (this.alto * 2);
                this.empaque = ((this.ancho * 2) + (this.alto * 2)) * 2;
                this.tornilloInst = ((this.alto / 6) + (this.ancho / 6)) * 2;

                this.precioCanal55 = this.canal55 * precioCanal55;
                this.precioAdaptador = this.adaptador * precioAdaptador;
                this.precioPisavidrio14 = this.pisaVidrio14 = precioPisavidrio14;
                this.precioEmpaque = this.empaque * preEmpaque;
                this.precioTornillo = this.tornilloInst * precioTornillo;

                this.sumaTotal = this.precioCanal55 + this.precioAdaptador
                        + this.precioPisavidrio14 + this.precioTornillo + this.precioEmpaque;
                
                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;
            case 4: // VITRINA BISELADA O-M-500-3 STAMDART
                this.horizontal = (this.ancho * 2) + (this.alto * 2);
                this.verticalCanal = (this.ancho * 2) + (this.alto * 2);
                this.pisaVidrio = (this.ancho * 2) + (this.alto * 2);
                this.empaque = ((this.ancho * 2) + (this.alto * 2)) * 2;
                this.tornilloInst = ((this.alto / 6) + (this.ancho / 6)) * 2;

                this.precioHorizontal = this.horizontal * precioHorizontal;
                this.precioVertCanal = this.verticalCanal * precioVertCanal;
                this.precioPisavidrio = this.pisaVidrio = precioPisavidrio;
                this.precioEmpaque = this.empaque * preEmpaque;
                this.precioTornillo = this.tornilloInst * precioTornillo;

                this.sumaTotal = this.precioHorizontal + this.precioVertCanal
                        + this.pisaVidrio + this.precioTornillo + this.precioEmpaque;
                
                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;
            case 5: // VITRINA BISELADA O-M-3876 -ALE STAMDART
                this.verticales = (this.ancho * 2) + (this.alto * 2);
                this.horizaontal168 = (this.ancho * 2) + (this.alto * 2);
                this.pisaVidrio10 = (this.ancho * 2) + (this.alto * 2);
                this.empaque = ((this.ancho * 2) + (this.alto * 2)) * 2;
                this.tornilloInst = ((this.alto / 6) + (this.ancho / 6)) * 2;

                this.precioVertical = this.verticales * precioVertical;
                this.precioHoriz1168= this.horizaontal168 * precioHoriz1168;
                this.precioPisavidrio10 = this.pisaVidrio10 = precioPisavidrio10;
                this.precioEmpaque = this.empaque * preEmpaque;
                this.precioTornillo = this.tornilloInst * precioTornillo;

                this.sumaTotal = this.precioVertical + this.precioHoriz1168
                        + this.precioPisavidrio10 + this.precioTornillo + this.precioEmpaque;
                
                this.subTotal = this.sumaTotal;
                preTrabajo = (preTrabajo * 100);
                this.sumaTotal = this.sumaTotal + preTrabajo;
                this.sumaTotal = recortar(String.valueOf(sumaTotal));

                break;
        }

    }

    public VitrinaC() {
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

    public int getCanal37() {
        return canal37;
    }

    public void setCanal37(int canal37) {
        this.canal37 = canal37;
    }

    public int getCanal55() {
        return canal55;
    }

    public void setCanal55(int canal55) {
        this.canal55 = canal55;
    }

    public int getCanal103() {
        return canal103;
    }

    public void setCanal103(int canal103) {
        this.canal103 = canal103;
    }

    public int getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(int adaptador) {
        this.adaptador = adaptador;
    }

    public int getPisaVidrio() {
        return pisaVidrio;
    }

    public void setPisaVidrio(int pisaVidrio) {
        this.pisaVidrio = pisaVidrio;
    }

    public int getPisaVidrio10() {
        return pisaVidrio10;
    }

    public void setPisaVidrio10(int pisaVidrio10) {
        this.pisaVidrio10 = pisaVidrio10;
    }

    public int getPisaVidrio14() {
        return pisaVidrio14;
    }

    public void setPisaVidrio14(int pisaVidrio14) {
        this.pisaVidrio14 = pisaVidrio14;
    }

    public int getTapaDucto() {
        return tapaDucto;
    }

    public void setTapaDucto(int tapaDucto) {
        this.tapaDucto = tapaDucto;
    }

    public int getAdapt2810() {
        return adapt2810;
    }

    public void setAdapt2810(int adapt2810) {
        this.adapt2810 = adapt2810;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getHorizaontal168() {
        return horizaontal168;
    }

    public void setHorizaontal168(int horizaontal168) {
        this.horizaontal168 = horizaontal168;
    }

    public int getVerticales() {
        return verticales;
    }

    public void setVerticales(int verticales) {
        this.verticales = verticales;
    }

    public int getVerticalCanal() {
        return verticalCanal;
    }

    public void setVerticalCanal(int verticalCanal) {
        this.verticalCanal = verticalCanal;
    }

    public int getTornilloInst() {
        return tornilloInst;
    }

    public void setTornilloInst(int tornilloInst) {
        this.tornilloInst = tornilloInst;
    }

    public int getEmpaque() {
        return empaque;
    }

    public void setEmpaque(int empaque) {
        this.empaque = empaque;
    }

    public int getPrecioCanal37() {
        return precioCanal37;
    }

    public void setPrecioCanal37(int precioCanal37) {
        this.precioCanal37 = precioCanal37;
    }

    public int getPrecioCanal55() {
        return precioCanal55;
    }

    public void setPrecioCanal55(int precioCanal55) {
        this.precioCanal55 = precioCanal55;
    }

    public int getPrecioCanal103() {
        return precioCanal103;
    }

    public void setPrecioCanal103(int precioCanal103) {
        this.precioCanal103 = precioCanal103;
    }

    public int getPrecioAdaptador() {
        return precioAdaptador;
    }

    public void setPrecioAdaptador(int precioAdaptador) {
        this.precioAdaptador = precioAdaptador;
    }

    public int getPrecioPisavidrio() {
        return precioPisavidrio;
    }

    public void setPrecioPisavidrio(int precioPisavidrio) {
        this.precioPisavidrio = precioPisavidrio;
    }

    public int getPrecioPisavidrio10() {
        return precioPisavidrio10;
    }

    public void setPrecioPisavidrio10(int precioPisavidrio10) {
        this.precioPisavidrio10 = precioPisavidrio10;
    }

    public int getPrecioPisavidrio14() {
        return precioPisavidrio14;
    }

    public void setPrecioPisavidrio14(int precioPisavidrio14) {
        this.precioPisavidrio14 = precioPisavidrio14;
    }

    public int getPrecioTapaDu() {
        return precioTapaDu;
    }

    public void setPrecioTapaDu(int precioTapaDu) {
        this.precioTapaDu = precioTapaDu;
    }

    public int getPrecioAdaptador2810() {
        return precioAdaptador2810;
    }

    public void setPrecioAdaptador2810(int precioAdaptador2810) {
        this.precioAdaptador2810 = precioAdaptador2810;
    }

    public int getPrecioHorizontal() {
        return precioHorizontal;
    }

    public void setPrecioHorizontal(int precioHorizontal) {
        this.precioHorizontal = precioHorizontal;
    }

    public int getPrecioHoriz1168() {
        return precioHoriz1168;
    }

    public void setPrecioHoriz1168(int precioHoriz1168) {
        this.precioHoriz1168 = precioHoriz1168;
    }

    public int getPrecioVertical() {
        return precioVertical;
    }

    public void setPrecioVertical(int precioVertical) {
        this.precioVertical = precioVertical;
    }

    public int getPrecioVertCanal() {
        return precioVertCanal;
    }

    public void setPrecioVertCanal(int precioVertCanal) {
        this.precioVertCanal = precioVertCanal;
    }

    public int getPrecioTornillo() {
        return precioTornillo;
    }

    public void setPrecioTornillo(int precioTornillo) {
        this.precioTornillo = precioTornillo;
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

}
