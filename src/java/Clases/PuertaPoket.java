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
public class PuertaPoket extends Puertas{
        private int empaque;
    private int precioEmpaque;

    public PuertaPoket() {
    }

    public void calcularPuertaPoket(int precioEmpaque) {
        this.precioEmpaque = precioEmpaque;
              switch (getTipoProducto()) {
            case 1://con eeste fabricamos una puerta X1 XD CON DIVISOR  CERRADURA MOVILE
                setPerimetral(getAncho() + getAlto() * 2);
                setVerticalVisagra(getAlto() * 2);
                setSuperiorNave(getAncho());
                setInferiorNave(getAncho() * 2);
                setPirlan(getAncho());
                setEmpaqueEmv((getAncho() * 4) + (getAlto() * 2));
                setEmpaqueEcb(getAncho() + (getAlto() * 2));
                setAdaptadorfelpa(getAncho());

                setPrecioPerimetral(getPerimetral() * (getPrecioPerimetral() / 6));
                setPrecioVerticalVisagra(getVerticalVisagra() * (getPrecioVerticalVisagra() / 6));
                setPrecioSuperiorNave(getSuperiorNave() * (getPrecioSuperiorNave() / 6));
                setPrecioInferiorNave(getInferiorNave() * (getPrecioInferiorNave() / 6));
                setPrecioPirlan(getPirlan() * (getPrecioPirlan() / 6));
                setPrecioEmpaqueEmv(getEmpaqueEmv() * (getPrecioEmpaqueEmv() / 6));
                setPrecioEmpaqueEcv(getEmpaqueEcb() * (getPrecioEmpaqueEcv() / 6));
                setPrecioFelpa(getAdaptadorfelpa()* (getPrecioFelpa()));

                setSumaTotal(getPrecioPerimetral() + getPrecioVerticalVisagra() + getPrecioSuperiorNave()
                        + getPrecioInferiorNave() + getPrecioPirlan() + getPrecioEmpaqueEmv() + getPrecioEmpaqueEcv() + getPrecioFelpa());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                System.out.println("suma total todo:::" + getSumaTotal());

                break;
            case 2://con eeste fabricamos una puerta X1 XD PANORAMICA   CERRADURA PHILLIS
                setPerimetral(getAncho() + getAlto() * 2);
                setVerticalVisagra(getAlto() * 2);
                setSuperiorNave(getAncho());
                setInferiorNave(getAncho());
                setPirlan(getAncho());
                setEmpaqueEmv((getAncho() * 2) + (getAlto() * 2));
                setEmpaqueEcb(getAncho() + (getAlto() * 2));
                setAdaptadorfelpa(getAncho());

                setPrecioPerimetral(getPerimetral() * (getPrecioPerimetral() / 6));
                setPrecioVerticalVisagra(getVerticalVisagra() * (getPrecioVerticalVisagra() / 6));
                setPrecioSuperiorNave(getSuperiorNave() * (getPrecioSuperiorNave() / 6));
                setPrecioInferiorNave(getInferiorNave() * (getPrecioInferiorNave() / 6));
                setPrecioPirlan(getPirlan() * (getPrecioPirlan() / 6));
                setPrecioEmpaqueEmv(getEmpaqueEmv() * (getPrecioEmpaqueEmv() / 6));
                setPrecioEmpaqueEcv(getEmpaqueEcb() * (getPrecioEmpaqueEcv() / 6));
                setPrecioFelpa(getAdaptadorfelpa()* (getPrecioFelpa()));

                setSumaTotal(getPrecioPerimetral() + getPrecioVerticalVisagra() + getPrecioSuperiorNave()
                        + getPrecioInferiorNave() + getPrecioPirlan() + getPrecioEmpaqueEmv() + getPrecioEmpaqueEcv() + getPrecioFelpa());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                System.out.println("suma total todo:::" + getSumaTotal());

                break;
            case 3://con eeste fabricamos una puerta XX PANORAMICA   CERRADURA PHILLIS Negra
                 setPerimetral(getAncho() + getAlto() * 2);
                setVerticalVisagra(getAlto() * 4);
                setSuperiorNave(getAncho());
                setInferiorNave(getAncho());
                setPirlan(getAncho());
                setAdaptador(getAlto());
                setEmpaqueEmv((getAncho() * 2) + (getAlto() * 2));
                setEmpaqueEcb(getAncho() + (getAlto() * 2));
                setAdaptadorfelpa(getAncho());

                setPrecioPerimetral(getPerimetral() * (getPrecioPerimetral() / 6));
                setPrecioVerticalVisagra(getVerticalVisagra() * (getPrecioVerticalVisagra() / 6));
                setPrecioSuperiorNave(getSuperiorNave() * (getPrecioSuperiorNave() / 6));
                setPrecioInferiorNave(getInferiorNave() * (getPrecioInferiorNave() / 6));
                setPrecioPirlan(getPirlan() * (getPrecioPirlan() / 6));
                setPrecioAdaptador(getAdaptador()*(getPrecioAdaptador()/6));
                setPrecioEmpaqueEmv(getEmpaqueEmv() * (getPrecioEmpaqueEmv() / 6));
                setPrecioEmpaqueEcv(getEmpaqueEcb() * (getPrecioEmpaqueEcv() / 6));
                setPrecioFelpa(getAdaptadorfelpa()* (getPrecioFelpa()));

                setSumaTotal(getPrecioPerimetral() + getPrecioVerticalVisagra() + getPrecioSuperiorNave()  + getPrecioInferiorNave() 
                      + getPrecioPirlan()+ getPrecioAdaptador() + getPrecioEmpaqueEmv() + getPrecioEmpaqueEcv() + getPrecioFelpa());

                setSubTotal(getSumaTotal());
                setPrecioTrabajo(getPrecioTrabajo() * 100);
                setSumaTotal(getSumaTotal() + getPrecioTrabajo());
                setSumaTotal(recortar(String.valueOf(getSumaTotal())));

                System.out.println("suma total todo:::" + getSumaTotal());
                break;
        }
    }
    private int recortar(String numero) {
        int espacios = numero.length();
        return Integer.valueOf(numero.substring(0, espacios - 2));
    }

    public int getEmpaque() {
        return empaque;
    }

    public void setEmpaque(int empaque) {
        this.empaque = empaque;
    }

    public int getPrecioEmpaque() {
        return precioEmpaque;
    }

    public void setPrecioEmpaque(int precioEmpaque) {
        this.precioEmpaque = precioEmpaque;
    }
    
    
    
}
