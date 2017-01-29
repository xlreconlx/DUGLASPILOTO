/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author William Sanchez
 */
public class VentanaProyec extends Ventanas {

    private int pisavidrio;
    private int nave;
    private int alfajia;
    private int divisor;
    private int jambaPlus;
    private int cabezalPlus;
    private int marcoHInferior;

    private int precioPisavidrio;
    private int precioNave;
    private int precioAfajia;
    private int precioDivisor;
    private int precioJambaPlus;
    private int precioCabezalPlus;
    private int PrecioMarcoHInferior;

    public VentanaProyec() {
    }

    public void VentanaProyec(int precioPisavidrio, int precioNave, int precioAfajia, int precioDivisor, int precioJambaPlus,
        int precioCabezalPlus, int precioMarcoHInferior) {
        this.precioPisavidrio = precioPisavidrio;
        this.precioNave = precioNave;
        this.precioAfajia = precioAfajia;
        this.precioDivisor = precioDivisor;
        this.precioJambaPlus = precioJambaPlus;
        this.precioCabezalPlus = precioCabezalPlus;
        this.PrecioMarcoHInferior = precioMarcoHInferior;

        switch (getTipoProducto()) {
            case 1:
                //           con este codigo fabricamos una ventana proyectante  de un cuerpo con alfajia X  .....1  
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho()*2) + (getAlto() * 2);
                this.nave =  (getAncho()*2) + (getAlto() * 2);
                this.alfajia = getAncho();
                setEmpaque((getAncho() * 8) + (getAlto() * 8));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave + this.precioAfajia
                        + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 2:
                //con este codigo fabricamos una ventana proyectante  de dos cuerpo con alfajia XX 2
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 2) + (getAlto() * 4);
                this.nave = (getAncho() * 2) + (getAlto() * 4);
                this.alfajia = getAncho();
                this.divisor = getAlto();
                setEmpaque((getAncho() * 8) + (getAlto() * 16));
                System.out.println("precio cabezal bd:::" + getPrecioCabezal());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                System.out.println("precio cabezal suma:::" + getPrecioCabezal());

                System.out.println("precio jamba bd:::" + getPrecioJamba());
                setPrecioJamba(getJamba() * getPrecioJamba());
                System.out.println("precio jamba suma" + getPrecioJamba());
                System.out.println("precio pisa vidrio bd:::" + this.precioPisavidrio);
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                System.out.println("precio pisa vidrio suma:::" + this.precioPisavidrio);
                System.out.println("precio nave bd:::" + this.precioNave);
                this.precioNave = this.nave * this.precioNave;
                System.out.println("precio nave suma:::" + this.precioNave);
                System.out.println("precio alfajia bd:::" + this.precioAfajia);
                this.precioAfajia = this.alfajia * this.precioAfajia;
                System.out.println("precio alfajia suma:::" + this.precioAfajia);
                System.out.println("precio divisor bd:::" + this.precioDivisor);
                this.precioDivisor = this.divisor * this.precioDivisor;
                System.out.println("precio divisor suma:::" + this.precioDivisor);
                System.out.println("precio empaque bd:::" + getPrecioEmpaque());
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                System.out.println("precio empaque suma:::" + getPrecioEmpaque());

                Long sumt = 0L;
                sumt = getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + Long.valueOf(this.precioAfajia) + Long.valueOf(this.precioDivisor);
                System.out.println("la suma es::::::" + sumt);

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());
                
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                
                System.out.println("suma total todo:::" + getSumaTotal());
                break;

            case 3:
                //           con este codigo fabricamos una ventana proyectante  de tres cuerpo con alfajia XXX 3
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho()*2) + (getAlto() * 6);
                this.nave = (getAncho()*2) + (getAlto() * 6);
                this.alfajia = getAncho();
                this.divisor = getAlto() * 2;
                setEmpaque(getAncho() * 8 + getAlto() * 24);

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 4:
                //       con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con alfajia XXXX 4
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho()*2) + (getAlto() * 8);
                this.nave = (getAncho()*2) + (getAlto() * 8);
                this.alfajia = getAncho();
                this.divisor = getAlto() * 3;
                setEmpaque((getAncho()* 8) + (getAlto() * 24));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 5:
                //           con este codigo fabricamos una ventana proyectante  de uno cuerpo con alfajia 0  5
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 2) + (getAlto() * 2);
                this.alfajia = getAncho();
                setEmpaque((getAncho()* 4) + (getAlto() * 4));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio
                        + this.precioAfajia + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 6:
                //           con este codigo fabricamos una ventana proyectante  de dos cuerpo con alfajia 00 6
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho()*2) + (getAlto() * 4);
                this.alfajia = getAncho();
                this.divisor = getAlto();
                setEmpaque((getAncho()*4) + (getAlto() * 8));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 7:
                //           con este codigo fabricamos una ventana proyectante  de dos cuerpo con alfajia 0/0  7
                //         fijo sobre otro fijo 
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho()*4) + (getAlto() * 2);
                this.alfajia = getAncho();
                this.divisor = getAncho();
                setEmpaque((getAncho() * 8) + (getAlto() * 4));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 8:
                //   con este codigo fabricamos una ventana proyectante  de dos cuerpo con alfajia X/0 .... 8
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 2);
                this.nave = (getAncho() * 2) + (getAltoFijo()* 2);
                this.alfajia = getAncho();
                this.divisor = getAncho();
                setEmpaque((getAncho() * 14) + (getAlto() * 8));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 9:
                //           con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con alfajia 0-X-O  9
                //         movil movil sobre fijo  fijo 
                setCabezal(getAlto() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 6) + (getAlto() * 2);
                this.nave = ((getAncho() / 3) * 2) + (getAlto() * 2);
                this.alfajia = getAncho();
                this.divisor = getAlto() * 2;
                setEmpaque((getAncho() * 8) + (getAlto() * 24));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 10:
                //    con este codigo fabricamos una ventana proyectante  de dos cuerpo con alfajia X-0  ... 10
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 2) + (getAlto() * 4);
                this.nave = (getAnchoFijo()* 2) + (getAlto() * 2);
                this.alfajia = getAncho();
                this.divisor = getAlto();
                setEmpaque((getAncho() * 8) + (getAlto() * 12));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 11:
                //           con este codigo fabricamos una ventana proyectante  de tres cuerpo con alfajia x-0-x 11
                //         movil seguido fijo seguido  movil  
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 2) + (getAlto() * 6);
                this.nave = (getAnchoFijo()* 4) + (getAlto() * 4);
                this.alfajia = getAncho();
                this.divisor = getAlto() * 2;
                setEmpaque((getAncho() * 8) + (getAlto() * 24));

                setPrecioJamba(getJamba() * getPrecioJamba());
                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 12:
                //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con alfajia X/0 plus ...12
                setCabezal(getAncho());
                this.jambaPlus = getAlto() * 2;
                this.marcoHInferior = getAncho();
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 2);
                this.nave = (getAnchoFijo()* 2) + (getAlto() * 2);
                this.alfajia = getAncho();
                this.divisor = getAncho();
                setAdaptador(getAlto() * 2);
                setEmpaque((getAncho() * 12) + (getAlto() * 6));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                this.precioJambaPlus = this.jambaPlus * (this.precioJambaPlus / 6);
                this.PrecioMarcoHInferior = this.marcoHInferior * (this.PrecioMarcoHInferior / 6);
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * (this.precioDivisor / 6);
                setPrecioAdaptador(getAdaptador() * getPrecioAdaptador());
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + this.precioJambaPlus + this.PrecioMarcoHInferior + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioAdaptador() + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 13:
   //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con 0-0-0-0  ....13 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 2) + (getAlto() * 8);
                this.alfajia = getAncho();
                this.divisor = getAlto() * 3;
                setEmpaque((getAncho() * 4) + (getAlto() * 16));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 14:
                //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con X/X ALFALJIA  ....14
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 2);
                this.nave = (getAncho() * 4) + (getAltoFijo()* 2);
                this.alfajia = getAncho();
                this.divisor = getAncho();
                setEmpaque((getAncho() * 14) + (getAlto() * 14));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 15:
                //  con este codigo fabricamos una ventana proyectante  de TRES cuerpo con 0-0-0 ALFALJIA  ....15
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 2) + (getAlto() * 8);
                this.alfajia = getAncho();
                this.divisor = getAlto() * 2;
                setEmpaque((getAncho() * 4) + (getAlto() * 16));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 16:
                //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con 0/0/0/0/ ALFALJIA  ....16
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 8) + (getAlto() * 2);
                this.alfajia = getAncho();
                this.divisor = getAncho() * 3;
                setEmpaque((getAncho() * 16) + (getAlto() * 4));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 17:
                //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con xx/00 ALFALJIA  ....17
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 4);
                this.nave = (getAncho() * 2) + (getAltoFijo()* 4);
                this.alfajia = getAncho();
                this.divisor = getAncho() + getAlto();
                setEmpaque((getAncho() * 14) + (getAlto() * 14));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 18:
                //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con X/X/0/0 ALFALJIA  ....18
                setCabezal(getAncho() * 2);
                setJamba(getAlto() * 2);
                this.pisavidrio = (getAncho() * 8) + (getAlto() * 2);
                this.nave = (getAncho() * 4) + (getAltoFijo()* 4);
                this.alfajia = getAncho();
                this.divisor = getAncho() * 3;
                setEmpaque((getAncho() * 14) + (getAlto() * 14));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 19:
                //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con X/0 BOREAL ALFALJIA  ....19
                this.cabezalPlus = getAncho() * 2;
                this.jambaPlus = getAlto() * 2;
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 2);
                this.nave = (getAncho() * 2) + (getAltoFijo()* 2);
                this.alfajia = getAncho();
                setAdaptador((getAncho() * 2) + (getAlto() * 2));
                this.divisor = getAncho();
                setEmpaque((getAncho() * 12) + (getAlto() * 6));

                this.precioCabezalPlus = this.cabezalPlus * (this.precioCabezalPlus / 6);
                this.precioJambaPlus = this.jambaPlus * (this.precioJambaPlus / 6);
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                setPrecioAdaptador(getAdaptador() + getPrecioAdaptador());
                this.precioDivisor = this.divisor * (this.precioDivisor / 6);
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(this.precioCabezalPlus + this.precioJambaPlus + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + getPrecioAdaptador() + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 20:
                //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con 0/0 BOREAL ALFALJIA  ....20
                this.cabezalPlus = getAncho() * 2;
                this.jambaPlus = getAlto() * 2;
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 2);
                this.nave = (getAncho() * 2) + (getAltoFijo()*2);
                this.alfajia = getAncho();
                setAdaptador((getAncho() * 2) + (getAlto() * 2));
                this.divisor = getAncho();
                setEmpaque((getAncho() * 12) + (getAlto() * 6));

                this.precioCabezalPlus = this.cabezalPlus * (this.precioCabezalPlus / 6);
                this.precioJambaPlus = this.jambaPlus * (this.precioJambaPlus / 6);
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                setPrecioAdaptador(getAdaptador() + getPrecioAdaptador());
                this.precioDivisor = this.divisor * (this.precioDivisor / 6);
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(this.precioCabezalPlus + this.precioJambaPlus + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + getPrecioAdaptador() + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 21:
                //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con ALFALJIA 21
                setCabezal(getAncho() * 2);
                setJamba((getAlto() * 2) + getAncho());
                this.pisavidrio = (getAncho() * 4) + (getAlto() * 4);
                this.nave = (getAnchoFijo()* 2) + (getAltoFijo()* 2);
                this.alfajia = getAncho();
                setAdaptador(getAncho());
                this.divisor = getAlto();
                setEmpaque((getAncho() * 14) + (getAlto() * 14));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioJamba(getJamba() * getPrecioJamba());
                this.precioPisavidrio = this.pisavidrio * this.precioPisavidrio;
                this.precioNave = this.nave * this.precioNave;
                this.precioAfajia = this.alfajia * this.precioAfajia;
                setPrecioAdaptador(getAdaptador() + getPrecioAdaptador());
                this.precioDivisor = this.divisor * this.precioDivisor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());

                setSumaTotal(getPrecioCabezal() + getPrecioJamba() + this.precioPisavidrio + this.precioNave
                        + this.precioAfajia + getPrecioAdaptador() + this.precioDivisor + getPrecioEmpaque());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

        }

    }

    private int recortar(String numero) {
        int espacios = numero.length();
        return Integer.valueOf(numero.substring(0, espacios - 2));
    }

    public int getPisavidrio() {
        return pisavidrio;
    }

    public void setPisavidrio(int pisavidrio) {
        this.pisavidrio = pisavidrio;
    }

    public int getNave() {
        return nave;
    }

    public void setNave(int nave) {
        this.nave = nave;
    }

    public int getAlfajia() {
        return alfajia;
    }

    public void setAlfajia(int alfajia) {
        this.alfajia = alfajia;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getPrecioPisavidrio() {
        return precioPisavidrio;
    }

    public void setPrecioPisavidrio(int precioPisavidrio) {
        this.precioPisavidrio = precioPisavidrio;
    }

    public int getPrecioNave() {
        return precioNave;
    }

    public void setPrecioNave(int precioNave) {
        this.precioNave = precioNave;
    }

    public int getPrecioAfajia() {
        return precioAfajia;
    }

    public void setPrecioAfajia(int precioAfajia) {
        this.precioAfajia = precioAfajia;
    }

    public int getPrecioDivisor() {
        return precioDivisor;
    }

    public void setPrecioDivisor(int precioDivisor) {
        this.precioDivisor = precioDivisor;
    }

    public int getJambaPlus() {
        return jambaPlus;
    }

    public void setJambaPlus(int jambaPlus) {
        this.jambaPlus = jambaPlus;
    }

    public int getCabezalPlus() {
        return cabezalPlus;
    }

    public void setCabezalPlus(int cabezalPlus) {
        this.cabezalPlus = cabezalPlus;
    }

    public int getMarcoHInferior() {
        return marcoHInferior;
    }

    public void setMarcoHInferior(int marcoHInferior) {
        this.marcoHInferior = marcoHInferior;
    }

    public int getPrecioJambaPlus() {
        return precioJambaPlus;
    }

    public void setPrecioJambaPlus(int precioJambaPlus) {
        this.precioJambaPlus = precioJambaPlus;
    }

    public int getPrecioCabezalPlus() {
        return precioCabezalPlus;
    }

    public void setPrecioCabezalPlus(int precioCabezalPlus) {
        this.precioCabezalPlus = precioCabezalPlus;
    }

    public int getPrecioMarcoHInferior() {
        return PrecioMarcoHInferior;
    }

    public void setPrecioMarcoHInferior(int PrecioMarcoHInferior) {
        this.PrecioMarcoHInferior = PrecioMarcoHInferior;
    }

}


