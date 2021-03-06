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
public class VentanaCorre extends Ventanas {

    private int engancheReforzado;
    private int divisorPanoramico;
    private int hIferiorNave;
    private int hIferiorFijo;
    private int sillarAlfljia;
    private int sillarRiel;
    private int jambaCuerpoFijo;
    private int divisorVerticalPanoramico;
    private int adaptadorSuperior;
    private int adaptadorInferior;
    private int jambaPistas;
    private int empaquePvc;

    private int precioEngancheReforzado;
    private int precioDivisorPanoramico;
    private int precioSillarAlfaljia;
    private int precioJambaCuerpoFijo;
    private int precioDivisorVerticalPanoramico;
    private int PrecioEmpaquePvc;
    private int precioAdactadorSuperior;
    private int precioAdactadorInferior;
    private int preciojambPistas;
    private int precioHIferiorFijo;
    private int precioSillarRiel;

    public VentanaCorre() {
    }

    public void calcularVentanaCorre(int precioHIferiorFijo, int precioEngancheReforzado, int precioDivisorPanoramico, int precioSillarAlfaljia, int precioJambaCuerpoFijo, int precioDivisorVerticalPanoramico, int PrecioEmpaquePvc, int precioAdactadorSuperior, int precioAdactadorInferior, int preciojambPistas, int precioSillaRiel) {
        this.precioHIferiorFijo = precioHIferiorFijo / 6;
        this.precioEngancheReforzado = precioEngancheReforzado / 6;
        this.precioDivisorPanoramico = precioDivisorPanoramico / 6;
        this.precioSillarAlfaljia = precioSillarAlfaljia / 6;
        this.precioJambaCuerpoFijo = precioJambaCuerpoFijo / 6;
        this.precioDivisorVerticalPanoramico = precioDivisorVerticalPanoramico / 6;
        this.PrecioEmpaquePvc = PrecioEmpaquePvc;
        this.precioAdactadorSuperior = precioAdactadorSuperior / 6;
        this.precioAdactadorInferior = precioAdactadorInferior / 6;
        this.preciojambPistas = preciojambPistas / 6;
        this.precioSillarRiel = precioSillaRiel / 6;

        switch (getTipoProducto()) {
            case 1:
                // con este codigo fabricamos una ventana de 2 cuerpos con un movil y un fijo x0   1
                setCabezal(getAncho());
                setSillar(getAncho());
                this.sillarRiel = getAncho();
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho() / 2);// este es el h inferior nave
                this.hIferiorFijo = getAncho() / 2;
                setTraslape(getAlto() * 2);  // este es el vertical cerradura
                setEnganche(getAlto() * 2);
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() * 4 + getAlto() * 4);

                System.out.println("precio cabezal bd:::" + getPrecioCabezal());
                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal suma:::" + getPrecioCabezal());
                System.out.println("precio cabezal caso 1 x0  suma:::" + getPrecioCabezal());

                System.out.println("precio sillsr bd:::" + this.precioSillarRiel);
                this.precioSillarRiel = sillarRiel * precioSillaRiel;
                System.out.println("precio sillsr suma" + this.precioSillarRiel);

                System.out.println("precio jamba bd:::" + getPrecioJamba());
                setPrecioJamba(getJamba() * (getPrecioJamba() / 5));
                System.out.println("precio jamba suma" + getPrecioJamba());

                System.out.println("precio hsup bd:::" + getPrecioHsuperior());
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                System.out.println("precio hsup suma" + getPrecioHsuperior());

                System.out.println("precio hinf bd:::" + getPrecioHinferior());
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                System.out.println("precio hinf bd:::" + getPrecioHinferior());

                System.out.println("precio hinf fijo bd:::" + this.precioHIferiorFijo);
                this.precioHIferiorFijo = this.hIferiorFijo * this.precioHIferiorFijo;
                System.out.println("precio hinf fijo suma:::" + this.precioHIferiorFijo);

                System.out.println("precio tras bd:::" + getPrecioTraslape());
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 5));
                System.out.println("precio tras suma" + getPrecioTraslape());

                System.out.println("precio enga bd:::" + getPrecioEnganche());
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 5));
                System.out.println("precio enga suma" + getPrecioEnganche());

                System.out.println("precio getPrecioEmpaque bd:::" + getPrecioEmpaque());
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                System.out.println("precio getPrecioEmpaque bd:::" + getPrecioEmpaque());

                System.out.println("precio getPreciofelpa bd:::" + getPreciofelpa());
                setPreciofelpa(getFelpa() * getPreciofelpa());
                System.out.println("precio getPreciofelpa bd:::" + getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + this.precioSillarRiel + getPrecioJamba() + getPrecioHsuperior()
                        + getPrecioHinferior() + this.precioHIferiorFijo + getPrecioTraslape()
                        + getPrecioEnganche() + getPrecioEmpaque() + getPreciofelpa());
                   System.out.println("suma total perfiles :...." + getSumaTotal());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                System.out.println("suma total perfiles + precio trabajo:...." + getSumaTotal());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;
            case 2:
                //           con este codigo fabricamos una ventana de 2 cuerpos moviles xx  2
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 2);  // este es el vertical cerradura
                setEnganche(getAlto() * 2);
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() * 4 + getAlto() * 4);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso 2 xx AS 1700  suma:::" + getPrecioCabezal());

                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                System.out.println("precio sillar caso 2 suma" + getPrecioSillar());

                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                System.out.println("precio jamba caso 2 suma" + getPrecioJamba());

                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                System.out.println("precio hsup caso 2 suma" + getPrecioHsuperior());

                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                System.out.println("precio hinf bd:::" + getPrecioHinferior());

                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));

                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                System.out.println("precio enga suma" + getPrecioEnganche());

                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                System.out.println("precio getPrecioEmpaque bd:::" + getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());
                System.out.println("precio getPreciofelpa bd:::" + getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + getPrecioHsuperior()
                        + getPrecioHinferior() + getPrecioTraslape()
                        + getPrecioEnganche() + getPrecioEmpaque() + getPreciofelpa());
         System.out.println("suma total perfiles :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 3:
                //           con este codigo fabricamos una ventana de 4 cuerpos moviles 0xx0  3
                //fijo movil fijo movil
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                this.hIferiorFijo = getAncho() / 2;
                sethInferior(getAncho() / 2);// este es el h inferior nave
                setTraslape(getAlto() * 4);  // este es el vertical cerradura
                      this.engancheReforzado = getAlto() * 4;
                setAdaptador(getAlto());
                setEmpaque(getAncho() * 2 + getAlto() * 8);
                setFelpa(getAncho() * 4 + getAlto() * 8);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso 0XX0 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                this.precioHIferiorFijo = this.hIferiorFijo * this.precioHIferiorFijo;
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                this.precioEngancheReforzado = this.engancheReforzado * this.precioEngancheReforzado;
                setPrecioAdaptador(getAdaptador() * (getPrecioAdaptador() / 6));
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + getPrecioHsuperior()
                        + getPrecioHinferior() + this.precioHIferiorFijo + getPrecioTraslape()
                           + this.precioEngancheReforzado + getPrecioAdaptador() + getPrecioEmpaque() + getPreciofelpa());
         System.out.println("suma total perfiles caso 3 OXXO 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 4:
                //con este codigo fabricamos una ventana de 3 cuerpos moviles xox  4
                //fijo movil fijo 
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho() / 2);// este es el h inferior nave
                this.hIferiorFijo = getAncho() / 2;
                setTraslape(getAlto() * 2);  // este es el vertical cerradura
                this.engancheReforzado = getAlto() * 4;
                setEmpaque(getAncho() * 2 + getAlto() * 6);
                setFelpa(getAncho() * 4 + getAlto() * 6);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso xox AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                this.precioHIferiorFijo = this.hIferiorFijo * this.precioHIferiorFijo;
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                this.precioEngancheReforzado = this.engancheReforzado * this.precioEngancheReforzado;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + getPrecioHsuperior()
                        + getPrecioHinferior() + this.precioHIferiorFijo + getPrecioTraslape()
                        + this.precioEngancheReforzado + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 4 X0X 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 5:
                //           con este codigo fabricamos una ventana de 3 cuerpos moviles oxo   5
                //movil fijo movil
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho() / 3);// este es el h inferior nave
                this.hIferiorFijo = (getAncho() / 3) * 2;
                setTraslape(getAlto() * 4);  // este es el vertical cerradura
                setEnganche(getAlto() * 2);
                setAdaptador(getAlto());
                setEmpaque(getAncho() * 2 + getAlto() * 6);
                setFelpa(getAncho() * 4 + getAlto() * 6);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso 0x0 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                this.precioHIferiorFijo = this.hIferiorFijo * this.precioHIferiorFijo;
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                setPrecioAdaptador(getAdaptador() * (getPrecioAdaptador() / 6));
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + getPrecioHsuperior()
                        + getPrecioHinferior() + this.precioHIferiorFijo + getPrecioTraslape()
                        + getPrecioEnganche() + getPrecioAdaptador() + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 5 OXO 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;
            case 6:
                //           con este codigo fabricamos una ventana de 3 cuerpos moviles oxx  6
                // fijo movil movil
                setCabezal(getAncho());
                setSillar(getAncho());
                this.adaptadorSuperior = getAncho();
                this.adaptadorInferior = getAncho();
                this.jambaPistas = getAlto() * 2;
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 2);  // este es el vertical cerradura
                setEnganche(getAlto() * 4);
                setEmpaque(getAncho() * 2 + getAlto() * 6);
                setFelpa(getAncho() * 4 + getAlto() * 6);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                    System.out.println("precio cabezal caso 0XX AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                this.precioAdactadorSuperior = this.adaptadorSuperior * this.precioAdactadorSuperior;
                this.precioAdactadorInferior = this.adaptadorInferior * this.precioAdactadorInferior;
                this.preciojambPistas = this.jambaPistas * this.preciojambPistas;
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + this.precioAdactadorSuperior + this.precioAdactadorInferior
                        + this.preciojambPistas + getPrecioHsuperior() + getPrecioHinferior() + getPrecioTraslape()
                        + getPrecioEnganche() + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 6 OXX 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 7:
                //           con este codigo fabricamos una ventana de 6 cuerpos moviles 0XX XX0    7 
                //   movil fijo fijo fijo fijo movil  basica alf 

                setCabezal(getAncho());
                this.adaptadorSuperior = getAncho();
                setSillar(getAncho());
                this.adaptadorInferior = getAncho();
                this.jambaPistas = getAlto() * 2;
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 4);  // este es el vertical cerradura
                setEnganche(getAlto() * 8);
                setAdaptador(getAlto());
                setEmpaque(getAncho() * 2 + getAlto() * 12);
                setFelpa(getAncho() * 4 + getAlto() * 12);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso 0XX XX0 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                this.precioAdactadorSuperior = this.adaptadorSuperior * (this.precioAdactadorSuperior / 6);
                this.precioAdactadorInferior = this.adaptadorInferior * this.precioAdactadorInferior;
                this.preciojambPistas = this.jambaPistas * this.preciojambPistas;
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                setPrecioAdaptador(getAdaptador() * (getPrecioAdaptador() / 6));
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + this.precioAdactadorSuperior + this.precioAdactadorInferior
                        + this.preciojambPistas + getPrecioHsuperior() + getPrecioHinferior() + getPrecioTraslape()
                        + getPrecioEnganche() + getPrecioAdaptador() + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 7 OXX XXO 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;

            case 8:
                //XXXXXXXXXXXXXXXXXXXX Esta ventana lleva alto XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                //hay que ver el tipo de producto
                // con este codigo fabricamos una ventana de 3 cuerpos moviles xo/0   8
                //  movil fijo sobre fijo basica alf 
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 2);  // este es el vertical cerradura
                setEnganche(getAlto() * 2);
                this.divisorPanoramico = getAncho();
                this.jambaCuerpoFijo = getAltoFijo() * 2;//Obtenemos el alto fijo y lo multiplicamos por 2 XXXXXXXXXXXXXXXXXXXX
                this.sillarAlfljia = getAncho() * 2;
                this.empaquePvc = (getAncho() * 2) + getAltoFijo() * 2;
                setEmpaque((getAncho() * 2) + (getAlto() * 4));
                setFelpa(getAncho() * 4 + getAlto() * 4);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso xo/0 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                this.precioDivisorPanoramico = this.divisorPanoramico * this.precioDivisorPanoramico;
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                this.precioSillarAlfaljia = this.sillarAlfljia * this.precioSillarAlfaljia;
                this.PrecioEmpaquePvc = this.empaquePvc * this.PrecioEmpaquePvc;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getJamba()
                        + getPrecioHsuperior() + getPrecioHinferior() + getPrecioTraslape()
                        + getPrecioEnganche() + this.precioDivisorPanoramico + this.jambaCuerpoFijo + this.precioSillarAlfaljia
                        + this.PrecioEmpaquePvc + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 8 XO/O 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 9:
                //   con este codigo fabricamos una ventana de 4 cuerpos moviles xo/00    9
                //  movil fijo sobre fijo fijo basica alf 
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 2);  // este es el vertical cerradura
                setEnganche(getAlto() * 2);
                this.divisorPanoramico = getAncho();
                this.sillarAlfljia = getAncho();
                this.jambaCuerpoFijo = (getAltoFijo() * 2);
                this.divisorVerticalPanoramico = getAltoFijo();
                this.empaquePvc = (getAncho() * 2) + (getAltoFijo() * 4);
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() * 4 + getAlto() * 4);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso xo/00 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                this.precioDivisorPanoramico = this.divisorPanoramico * this.precioDivisorPanoramico;
                this.precioSillarAlfaljia = this.sillarAlfljia * this.precioSillarAlfaljia;
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                this.precioDivisorVerticalPanoramico = this.divisorVerticalPanoramico * this.precioDivisorVerticalPanoramico;
                this.PrecioEmpaquePvc = this.empaquePvc * this.PrecioEmpaquePvc;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + getPrecioHsuperior()
                        + getPrecioHinferior() + getPrecioTraslape() + getPrecioEnganche() + this.precioDivisorPanoramico
                        + this.precioSillarAlfaljia + this.precioJambaCuerpoFijo
                        + this.precioDivisorVerticalPanoramico + this.PrecioEmpaquePvc + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 9 XO/00 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 10:
                //           con este codigo fabricamos una ventana de 6 cuerpos moviles 0X0/000
                //   fijo  movol fijo  sobre fijo fijo fijo  basica alf 

                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 4);  // este es el vertical cerradura
                setEnganche(getAlto() * 2);
                this.divisorPanoramico = getAncho();
                this.sillarAlfljia = getAncho();
                this.jambaCuerpoFijo = (getAltoFijo() * 2);
                this.divisorVerticalPanoramico = (getAltoFijo() * 2);
                setAdaptador(getAlto());
                this.empaquePvc = getAncho() * 2 + (getAltoFijo() * 6);
                setEmpaque(getAncho() * 2 + getAlto() * 6);
                setFelpa(getAncho() * 4 + getAlto() * 6);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso 0X0/000 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                this.precioDivisorPanoramico = this.divisorPanoramico * this.precioDivisorPanoramico;
                this.precioSillarAlfaljia = this.sillarAlfljia * this.precioSillarAlfaljia;
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                this.precioDivisorVerticalPanoramico = this.divisorVerticalPanoramico * this.precioDivisorVerticalPanoramico;
                this.PrecioEmpaquePvc = this.empaquePvc * this.PrecioEmpaquePvc;
                setAdaptador(getAdaptador() * (getPrecioAdaptador() / 6));
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + gethSuperior()
                        + getPrecioHinferior() + getPrecioTraslape()
                        + getPrecioEnganche() + this.precioDivisorPanoramico + this.precioSillarAlfaljia
                        + this.precioJambaCuerpoFijo + this.precioDivisorVerticalPanoramico + this.PrecioEmpaquePvc
                        + getPrecioAdaptador() + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 10 0X0/000 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;
            case 11:
                //           con este codigo fabricamos una ventana de 8 cuerpos moviles 0XX0/0000      FALTABA
                //   fijo  movol fijo  sobre fijo fijo fijo  basica alf 
                setCabezal(getAncho());
                setSillar(getAncho());
                setJamba(getAlto() * 2);
                sethSuperior(getAncho());
                sethInferior(getAncho());// este es el h inferior nave
                setTraslape(getAlto() * 4);  // este es el vertical cerradura
                setEnganche(getAlto() * 4);
                this.divisorPanoramico = getAncho();
                this.sillarAlfljia = getAncho();
                this.jambaCuerpoFijo = (getAltoFijo() * 2);
                this.divisorVerticalPanoramico = (getAltoFijo() * 3);
                setAdaptador(getAlto());
                this.empaquePvc = (getAncho() * 2) + (getAltoFijo() * 8);
                setEmpaque(getAncho() * 4 + getAlto() * 8);
                setFelpa(getAncho() * 4 + getAlto() * 8);

                setPrecioCabezal((getPrecioCabezal() / 6) * getCabezal());
                System.out.println("precio cabezal caso 0XX0/0000 AS 1700 suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * (getPrecioSillar() / 6));
                setPrecioJamba(getJamba() * (getPrecioJamba() / 6));
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioHinferior(gethInferior() * (getPrecioHinferior() / 6));
                setPrecioTraslape(getTraslape() * (getPrecioTraslape() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                this.precioDivisorPanoramico = this.divisorPanoramico * this.precioDivisorPanoramico;
                this.precioSillarAlfaljia = this.sillarAlfljia * this.precioSillarAlfaljia;
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                this.precioDivisorVerticalPanoramico = this.divisorVerticalPanoramico * this.precioDivisorVerticalPanoramico;
                this.PrecioEmpaquePvc = this.empaquePvc * this.PrecioEmpaquePvc;
                setAdaptador(getAdaptador() * (getPrecioAdaptador() / 6));
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba() + gethSuperior()
                        + getPrecioHinferior() + getPrecioTraslape()
                        + getPrecioEnganche() + this.precioDivisorPanoramico + this.precioSillarAlfaljia
                        + this.precioJambaCuerpoFijo + this.precioDivisorVerticalPanoramico + this.PrecioEmpaquePvc
                        + getPrecioAdaptador() + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 11 0XX0/0000 1700 :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            //  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            // esta son las otras ventanas correderas vc-3825
            case 12:
                //con este codigo fabricamos una ventana de 2 cuerpos XO plus basica alfa
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                this.jambaCuerpoFijo = getAlto();//apunta al jamba marcoNave
                setJamba(getAlto());
                sethInferior(getAlto() / 2);//este le apunta al horizontal nave
                sethSuperior((getAncho() / 2) + getAlto());//este le apunta a horizontal marco fijoo
                setTraslape(getAlto());
                setEnganche(getAlto());// ESTE apunta aENGANCHE movil
                this.engancheReforzado = getAlto();
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() + getAlto());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                         System.out.println("precio cabezal caso 12 vc-3825 XO plus Basica Alfa  suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                setPrecioJamba(getJamba() * getPrecioJamba());
                setPrecioHinferior(gethInferior() * getPrecioHinferior());
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                this.precioEngancheReforzado = this.engancheReforzado * this.precioEngancheReforzado;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba()
                        + this.precioJambaCuerpoFijo + getPrecioHinferior() + getPrecioHsuperior()
                        + getPrecioTraslape() + getEnganche() + this.precioEngancheReforzado
                        + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso caso 12 vc-3825 XO plus Basica Alfa :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;
            case 13:
                // con este codigo fabricamos una ventana de 2 cuerpos XX Basica Alfa
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                this.jambaCuerpoFijo = getAlto();//apunta al jamba marcoNave
                sethInferior(getAlto());//este le apunta al horizontal nave
                sethSuperior(getAncho());//este le apunta a horizontal marco fijoo
                setEnganche(getAlto() * 2);// ESTE apunta aENGANCHE movil
                setTraslape(getAlto() * 2);
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() + getAlto());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                   System.out.println("precio cabezal caso 13 vc-3825 XX Basica Alfa  suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                setPrecioHinferior(gethInferior() * getPrecioHinferior());
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioEnganche(getEnganche() * (getPrecioEnganche() / 6));
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + this.precioJambaCuerpoFijo + getPrecioHinferior()
                + gethSuperior() + getPrecioEnganche() + getPrecioTraslape()      + +getPrecioEmpaque() + getPreciofelpa());
                    System.out.println("suma total perfiles caso 3 vc-3825 XX Basica Alfa :...." + getSumaTotal());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;

            case 14:
                // con este codigo fabricamos una ventana de 2 cuerpos 0X plus
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                this.jambaCuerpoFijo = getAlto();//apunta al jamba marcoNave
                setJamba(getAlto());
                sethInferior(getAlto() / 2);//este le apunta al horizontal nave
                sethSuperior((getAncho() / 2) + getAlto());//este le apunta a horizontal marco fijoo
                setTraslape(getAlto());
                this.engancheReforzado = getAlto() * 2;
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() + getAlto());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                   System.out.println("precio cabezal caso 14 vc-3825 XO plus  suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                this.precioJambaCuerpoFijo = this.jambaCuerpoFijo * this.precioJambaCuerpoFijo;
                setPrecioJamba(getJamba() * getPrecioJamba());
                setPrecioHinferior(gethInferior() * getPrecioHinferior());
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                this.precioEngancheReforzado = this.engancheReforzado * this.precioEngancheReforzado;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() +    this.precioJambaCuerpoFijo  + getPrecioJamba()
                        + getPrecioHinferior()  + gethSuperior() + getPrecioTraslape()
                        + this.precioEngancheReforzado + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles caso 13 vc-3825 XX Basica Alfa :...." + getSumaTotal());
                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 15:
                //con este codigo fabricamos una ventana de 4 cuerpos 0XX0 1672 DOBLE
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                setJamba(getAlto() * 2); //Jamba es la jamba normal
                sethInferior(getAlto());//este le apunta al horizontal nave
                sethSuperior(getAncho());//este le apunta a horizontal marco fijoo
                setTraslape(getAlto() * 2);
                setAdaptador(getAlto());
                this.engancheReforzado = getAlto() * 4;
                setEmpaque((getAncho() * 2) + (getAlto() * 8));
                setFelpa(getAncho() + (getAlto() * 5));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                System.out.println("precio cabezal caso 15 vc-3825 0XX0 1672 DOBLE  suma:::" + getPrecioCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                setPrecioJamba(getJamba() * getPrecioJamba());
                setPrecioHinferior(gethInferior() * getPrecioHinferior());
                setPrecioHsuperior(gethSuperior() * (getPrecioHsuperior() / 6));
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                setPrecioAdaptador(getAdaptador() * getPrecioAdaptador());
                this.precioEngancheReforzado = this.engancheReforzado * this.precioEngancheReforzado;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba()
                        + getPrecioHinferior() + + gethSuperior() + getPrecioTraslape()
                        + getPrecioAdaptador() + this.precioEngancheReforzado + getPrecioEmpaque() + getPreciofelpa());
  System.out.println("suma total perfiles 15 vc-3825 0XX0 1672 DOBLE :...." + getSumaTotal());
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

    public int getEngancheReforzado() {
        return engancheReforzado;
    }

    public void setEngancheReforzado(int engancheReforzado) {
        this.engancheReforzado = engancheReforzado;
    }

    public int getDivisorPanoramico() {
        return divisorPanoramico;
    }

    public void setDivisorPanoramico(int divisorPanoramico) {
        this.divisorPanoramico = divisorPanoramico;
    }

    public int gethIferiorNave() {
        return hIferiorNave;
    }

    public void sethIferiorNave(int hIferiorNave) {
        this.hIferiorNave = hIferiorNave;
    }

    public int getSillarAlfljia() {
        return sillarAlfljia;
    }

    public void setSillarAlfljia(int sillarAlfljia) {
        this.sillarAlfljia = sillarAlfljia;
    }

    public int getJambaCuerpoFijo() {
        return jambaCuerpoFijo;
    }

    public void setJambaCuerpoFijo(int jambaCuerpoFijo) {
        this.jambaCuerpoFijo = jambaCuerpoFijo;
    }

    public int getDivisorVerticalPanoramico() {
        return divisorVerticalPanoramico;
    }

    public void setDivisorVerticalPanoramico(int divisorVerticalPanoramico) {
        this.divisorVerticalPanoramico = divisorVerticalPanoramico;
    }

    public int getAdaptadorSuperior() {
        return adaptadorSuperior;
    }

    public void setAdaptadorSuperior(int adaptadorSuperior) {
        this.adaptadorSuperior = adaptadorSuperior;
    }

    public int getAdaptadorInferior() {
        return adaptadorInferior;
    }

    public void setAdaptadorInferior(int adaptadorInferior) {
        this.adaptadorInferior = adaptadorInferior;
    }

    public int getJambaPistas() {
        return jambaPistas;
    }

    public void setJambaPistas(int jambaPistas) {
        this.jambaPistas = jambaPistas;
    }

    public int getEmpaquePvc() {
        return empaquePvc;
    }

    public void setEmpaquePvc(int empaquePvc) {
        this.empaquePvc = empaquePvc;
    }

    public int getPrecioEngancheReforzado() {
        return precioEngancheReforzado;
    }

    public void setPrecioEngancheReforzado(int precioEngancheReforzado) {
        this.precioEngancheReforzado = precioEngancheReforzado;
    }

    public int getPrecioDivisorPanoramico() {
        return precioDivisorPanoramico;
    }

    public void setPrecioDivisorPanoramico(int precioDivisorPanoramico) {
        this.precioDivisorPanoramico = precioDivisorPanoramico;
    }

    public int getPrecioSillarAlfaljia() {
        return precioSillarAlfaljia;
    }

    public void setPrecioSillarAlfaljia(int precioSillarAlfaljia) {
        this.precioSillarAlfaljia = precioSillarAlfaljia;
    }

    public int getPrecioJambaCuerpoFijo() {
        return precioJambaCuerpoFijo;
    }

    public void setPrecioJambaCuerpoFijo(int precioJambaCuerpoFijo) {
        this.precioJambaCuerpoFijo = precioJambaCuerpoFijo;
    }

    public int getPrecioDivisorVerticalPanoramico() {
        return precioDivisorVerticalPanoramico;
    }

    public void setPrecioDivisorVerticalPanoramico(int precioDivisorVerticalPanoramico) {
        this.precioDivisorVerticalPanoramico = precioDivisorVerticalPanoramico;
    }

    public int getPrecioEmpaquePvc() {
        return PrecioEmpaquePvc;
    }

    public void setPrecioEmpaquePvc(int PrecioEmpaquePvc) {
        this.PrecioEmpaquePvc = PrecioEmpaquePvc;
    }

    public int getPrecioAdactadorSuperior() {
        return precioAdactadorSuperior;
    }

    public void setPrecioAdactadorSuperior(int precioAdactadorSuperior) {
        this.precioAdactadorSuperior = precioAdactadorSuperior;
    }

    public int getPrecioAdactadorInferior() {
        return precioAdactadorInferior;
    }

    public void setPrecioAdactadorInferior(int precioAdactadorInferior) {
        this.precioAdactadorInferior = precioAdactadorInferior;
    }

    public int getPreciojambPistas() {
        return preciojambPistas;
    }

    public void setPreciojambPistas(int preciojambPistas) {
        this.preciojambPistas = preciojambPistas;
    }

    public int gethIferiorFijo() {
        return hIferiorFijo;
    }

    public void sethIferiorFijo(int hIferiorFijo) {
        this.hIferiorFijo = hIferiorFijo;
    }

    public int getPrecioHIferiorFijo() {
        return precioHIferiorFijo;
    }

    public void setPrecioHIferiorFijo(int precioHIferiorFijo) {
        this.precioHIferiorFijo = precioHIferiorFijo;
    }

    public int getSillarRiel() {
        return sillarRiel;
    }

    public void setSillarRiel(int sillarRiel) {
        this.sillarRiel = sillarRiel;
    }

    public int getPrecioSillarRiel() {
        return precioSillarRiel;
    }

    public void setPrecioSillarRiel(int precioSillarRiel) {
        this.precioSillarRiel = precioSillarRiel;
    }

}
