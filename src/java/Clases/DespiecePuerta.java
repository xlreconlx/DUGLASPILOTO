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
public class DespiecePuerta {

    public DespiecePuerta() {
    }

    public Despiece generaDespiece(int tipoModeloVentana, int tipoPuerta, int tipoAluminio, int cantidadProducto, String alto, String ancho, String nombre) {
        Despiece despie = new Despiece();
        switch (tipoModeloVentana) {
            case 1://Puertas corredizas    
                switch (tipoPuerta) {
                    case 1://Puertas corredizas 
                        break;
                    case 2:
                        break;
                }
                break;
            case 2://Puertas Abatibles
                switch (tipoPuerta) {
                    case 1://Puertas Abatible 
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadMarcoAncho(1 * cantidadProducto);// 1 es la cantidad
                        despie.setCantidadMarcoAlto(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(2 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadPirlan(1 * cantidadProducto);
                        despie.setCantidadFelpa(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(2 * cantidadProducto);
                        despie.setCantidadEmpaqueEcv(1 * cantidadProducto);
                        despie.setCantidadEmpaqueEcvAlto(2 * cantidadProducto);
                        despie.setCantidadChapa(1 * cantidadProducto);
                        despie.setVisagras(1 * cantidadProducto);
                        despie.setCantidadEscuadras(1 * cantidadProducto);
                        despie.setCantidadTornilloEnsam(10 * cantidadProducto);
                        despie.setCantidadTornilloInst(9 * cantidadProducto);
                        despie.setCantidadVidrio(1 * cantidadProducto);

                        despie.setMensajeMarcoAncho(despie.getCantidadMarcoAncho() + " Recorte Perimetral Ancho de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeMarcoAlto(despie.getCantidadMarcoAlto() + " Recorte Perimetral Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Vertical cerradura ALto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeInfNaveAncho(despie.getCantidadInferiorNaveAncho() + " Recorte Inferior Ancho de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajePirlan(despie.getCantidadPirlan() + " Recorte Pirlan de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeFelpa(despie.getCantidadPirlan() + " Recorte Adaptador Felpa de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque EMV Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque EMV Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensageEmpaqueEcv(despie.getCantidadEmpaqueEcv() + " Recorte Empaque ECB Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensageEmpaqueEcvAlto(despie.getCantidadEmpaqueEcvAlto() + " Recorte Empaque ECB Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVisagras(despie.getVisagras() + " Visagras :  ");
                        despie.setMensajeEscuadras1(despie.getCantidadEscuadras() + " Escuadras :  ");
                        despie.setMensajeChapa(despie.getCantidadChapa() + " Chapa :  ");
                        despie.setMensajeTornilloEnsam(despie.getCantidadTornilloEnsam() + " Tornillo ensamble :  ");
                        despie.setMensajeTornilloInst(despie.getCantidadTornilloInst() + " Tornillo Instalacion :  ");
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(37);
                        break;
                    case 2:
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAncho(1 * cantidadProducto);
                        despie.setCantidadNaveAncho(1 * cantidadProducto);
                        despie.setCantidadNaveAlto(2 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(8 * cantidadProducto);
                        despie.setCantidadVidrio(1 * cantidadProducto);
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(1);
                        break;
                    case 3:
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAncho(1 * cantidadProducto);
                        despie.setCantidadNaveAncho(1 * cantidadProducto);
                        despie.setCantidadNaveAlto(2 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(8 * cantidadProducto);
                        despie.setCantidadVidrio(1 * cantidadProducto);
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(1);
                        break;
                }
                break;
            case 3://Puertas Poket
                switch (tipoPuerta) {
                    case 1://Puertas Poket 
                        break;
                    case 2:
                        break;
                }
                break;
        }

        return despie;
    }

}
