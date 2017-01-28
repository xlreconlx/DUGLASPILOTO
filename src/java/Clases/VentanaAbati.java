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
public class VentanaAbati extends Ventanas {


    private int jambaMarcoNave;
    private int horizontalMarcoFijo;
    private int engancheMovil;
    private int engancheReforzado;
    private int entrecierreNaveFijo;


    private int precioJambaNave;
    private int precioHorizontalMarcoFijo;
    private int precioEngancheMovil;
    private int precioEngancheRefor;
    private int precioEntrecierreNaveFijo;

    public VentanaAbati() {
    }

    public void CalcularVentana( int precioJambaNave,  int precioHorizontalMarcoFijo, int precioEngancheMovil, int precioEngancheRefor, int precioEntrecierreNaveFijo) {
  
        this.precioJambaNave = precioJambaNave;
        this.precioHorizontalMarcoFijo = precioHorizontalMarcoFijo;
        this.precioEngancheMovil = precioEngancheMovil;
        this.precioEngancheRefor = precioEngancheRefor;
        this.precioEntrecierreNaveFijo = precioEntrecierreNaveFijo;

        switch (getTipoProducto()) {
            case 1:
                //con este codigo fabricamos una ventana de 2 cuerpos XO plus basica alfa
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                this.jambaMarcoNave = getAlto();
                setJamba(getAlto());
                sethInferior(getAlto()/2);//este le apunta al horizontal nave
                this.horizontalMarcoFijo = (getAncho() / 2) + getAlto();
                setTraslape(getAlto());
                this.engancheMovil = getAlto();
                this.engancheReforzado = getAlto();
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() + getAlto());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                this.precioJambaNave = this.jambaMarcoNave * this.precioJambaNave;
                setPrecioJamba(getJamba() * getPrecioJamba());
                setPrecioHinferior(gethInferior() * getPrecioHinferior());
                this.precioHorizontalMarcoFijo = this.horizontalMarcoFijo * this.precioHorizontalMarcoFijo;
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                this.precioEngancheMovil = this.engancheMovil * this.precioEngancheMovil;
                this.precioEngancheRefor = this.engancheReforzado * this.precioEngancheRefor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba()
                        + this.precioJambaNave + getPrecioHinferior() + this.precioHorizontalMarcoFijo
                        + getPrecioTraslape() + this.precioEngancheMovil + this.precioEngancheRefor
                        + getPrecioEmpaque() + getPreciofelpa());

                setSubTotal(getSumaTotal());

                setSumaTotal(getSumaTotal() + (getSumaTotal() * getPrecioDescuento() / 100));
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;
            case 2:
                // con este codigo fabricamos una ventana de 2 cuerpos XX Basica Alfa
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                this.jambaMarcoNave = getAlto();
                 sethInferior(getAlto());//este le apunta al horizontal nave
                this.horizontalMarcoFijo = getAncho();
                this.entrecierreNaveFijo = (getAlto() * 2);
                setTraslape(getAlto() * 2);
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() + getAlto());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                this.precioJambaNave = this.jambaMarcoNave * this.precioJambaNave;
                     setPrecioHinferior(gethInferior() * getPrecioHinferior());
                this.precioHorizontalMarcoFijo = this.horizontalMarcoFijo * this.precioHorizontalMarcoFijo;
                this.precioEntrecierreNaveFijo = this.entrecierreNaveFijo * getPrecioEntrecierreNaveFijo();
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + this.precioJambaNave + getPrecioHinferior()
                        + this.precioHorizontalMarcoFijo + getPrecioTraslape() + this.precioEntrecierreNaveFijo
                        + getPrecioEmpaque() + getPreciofelpa());

                setSubTotal(getSumaTotal());

                setSumaTotal(getSumaTotal() + (getSumaTotal() * getPrecioDescuento() / 100));
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                break;

            case 3:
                // con este codigo fabricamos una ventana de 2 cuerpos 0X plus
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                this.jambaMarcoNave = getAlto();
                setJamba(getAlto());
                sethInferior(getAlto()/2);//este le apunta al horizontal nave
                this.horizontalMarcoFijo = (getAncho() / 2) + getAncho();
                setTraslape(getAlto());
                this.engancheReforzado = getAlto() * 2;
                setEmpaque(getAncho() * 2 + getAlto() * 4);
                setFelpa(getAncho() + getAlto());

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                this.precioJambaNave = this.jambaMarcoNave * this.precioJambaNave;
                setPrecioJamba(getJamba() * getPrecioJamba());
                     setPrecioHinferior(gethInferior() * getPrecioHinferior());
                this.precioHorizontalMarcoFijo = this.horizontalMarcoFijo * this.precioHorizontalMarcoFijo;
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                this.precioEngancheRefor = this.engancheReforzado * this.precioEngancheRefor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + this.precioJambaNave + getPrecioJamba()
                     + getPrecioHinferior() + this.precioHorizontalMarcoFijo + getPrecioTraslape()
                        + this.precioEngancheRefor + getPrecioEmpaque() + getPreciofelpa());

                setSubTotal(getSumaTotal());

                setSumaTotal(getSumaTotal() + (getSumaTotal() * getPrecioDescuento() / 100));
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));
                break;

            case 4:
                //con este codigo fabricamos una ventana de 2 cuerpos 0XX0 DOBLE
                setCabezal(getAncho());
                setSillar(getAncho()); //Este apunta al sillar alfagia
                setJamba(getAlto() * 2); //Jamba es la jamba normal
               sethInferior(getAlto());//este le apunta al horizontal nave
                this.horizontalMarcoFijo = (getAncho());
                setTraslape(getAlto() * 2);
                setAdaptador(getAlto());
                this.engancheReforzado = getAlto() * 4;
                setEmpaque((getAncho() * 2) + (getAlto() * 8));
                setFelpa(getAncho() + (getAlto() * 5));

                setPrecioCabezal(getPrecioCabezal() * getCabezal());
                setPrecioSillar(getSillar() * getPrecioSillar());
                setPrecioJamba(getJamba() * getPrecioJamba());
                    setPrecioHinferior(gethInferior() * getPrecioHinferior());
                this.precioHorizontalMarcoFijo = this.horizontalMarcoFijo * this.precioHorizontalMarcoFijo;
                setPrecioTraslape(getTraslape() * getPrecioTraslape());
                setPrecioAdaptador(getAdaptador() * getPrecioAdaptador());
                this.precioEngancheRefor = this.engancheReforzado * this.precioEngancheRefor;
                setPrecioEmpaque(getEmpaque() * getPrecioEmpaque());
                setPreciofelpa(getFelpa() * getPreciofelpa());

                setSumaTotal(getPrecioCabezal() + getPrecioSillar() + getPrecioJamba()
                        + getPrecioHinferior() + this.precioHorizontalMarcoFijo + getPrecioTraslape()
                        + getPrecioAdaptador() + this.precioEngancheRefor + getPrecioEmpaque() + getPreciofelpa());

                setSubTotal(getSumaTotal());

                setSumaTotal(getSumaTotal() + (getSumaTotal() * getPrecioDescuento() / 100));
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
 public int getJambaMarcoNave() {
        return jambaMarcoNave;
    }

    public void setJambaMarcoNave(int jambaMarcoNave) {
        this.jambaMarcoNave = jambaMarcoNave;
    }

 

    public int getHorizontalMarcoFijo() {
        return horizontalMarcoFijo;
    }

    public void setHorizontalMarcoFijo(int horizontalMarcoFijo) {
        this.horizontalMarcoFijo = horizontalMarcoFijo;
    }

    public int getEngancheMovil() {
        return engancheMovil;
    }

    public void setEngancheMovil(int engancheMovil) {
        this.engancheMovil = engancheMovil;
    }

    public int getEngancheReforzado() {
        return engancheReforzado;
    }

    public void setEngancheReforzado(int engancheReforzado) {
        this.engancheReforzado = engancheReforzado;
    }

    public int getEntrecierreNaveFijo() {
        return entrecierreNaveFijo;
    }

    public void setEntrecierreNaveFijo(int entrecierreNaveFijo) {
        this.entrecierreNaveFijo = entrecierreNaveFijo;
    }


    public int getPrecioJambaNave() {
        return precioJambaNave;
    }

    public void setPrecioJambaNave(int precioJambaNave) {
        this.precioJambaNave = precioJambaNave;
    }



    public int getPrecioHorizontalMarcoFijo() {
        return precioHorizontalMarcoFijo;
    }

    public void setPrecioHorizontalMarcoFijo(int precioHorizontalMarcoFijo) {
        this.precioHorizontalMarcoFijo = precioHorizontalMarcoFijo;
    }

    public int getPrecioEngancheMovil() {
        return precioEngancheMovil;
    }

    public void setPrecioEngancheMovil(int precioEngancheMovil) {
        this.precioEngancheMovil = precioEngancheMovil;
    }

    public int getPrecioEngancheRefor() {
        return precioEngancheRefor;
    }

    public void setPrecioEngancheRefor(int precioEngancheRefor) {
        this.precioEngancheRefor = precioEngancheRefor;
    }

    public int getPrecioEntrecierreNaveFijo() {
        return precioEntrecierreNaveFijo;
    }

    public void setPrecioEntrecierreNaveFijo(int precioEntrecierreNaveFijo) {
        this.precioEntrecierreNaveFijo = precioEntrecierreNaveFijo;
    }

}
