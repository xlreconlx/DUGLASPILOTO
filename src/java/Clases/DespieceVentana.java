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
public class DespieceVentana {
//Tipo producto despiece
// 1 = ventanas de 2 cuerpos xo en proyectante
// 2 = ventanas de 2 cuerpos ox en proyectante
// 3 = ventanas de 2 cuerpos xx en proyectante

    
    
    public DespieceVentana() {
    }

    public Despiece generaDespiece(int tipoModeloVentana, int tipoVentana, int tipoAluminio, int cantidadProducto, String alto, String ancho, String nombre) {
        Despiece despie = new Despiece();
        switch (tipoModeloVentana) {
            case 1://Proyectante    
                switch (tipoVentana) {
                    case 1://ventana proyectante  de un cuerpo con alfajia X
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
                    case 2://ventana proyectante  de dos cuerpo con alfajia XX..................

                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(1 * cantidadProducto);
                        despie.setCantidadNaveAncho(1 * cantidadProducto);
                        despie.setCantidadNaveAlto(2 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(8 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(2);
                 
                        break;
                    case 3:      //  con este codigo fabricamos una ventana proyectante  de tres cuerpo con alfajia XXX
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(6 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(6 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(2 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(24 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(3);
             
                        break;
                    case 4:     // ventana proyectante  de cuatro cuerpo con alfajia XXXX
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(8 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(8 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(3 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(24 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(4);
            
                        break;
                    case 5:  //  ventana proyectante  de uno cuerpo con alfajia 0  
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(2 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(1 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)-2.5));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(5);
               
                        break;
                    case 6: //  ventana proyectante  de dos cuerpo con alfajia 00 
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(8 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(24 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(6);
                   
                        break;
                    case 7:  //  a ventana proyectante  de dos cuerpo con alfajia 0/0   fijo sobre otro fijo       
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(4 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(7);
                 
                        break;
                           case 8:      //  ventana proyectante  de dos cuerpo con alfajia X/0 .... 8 ----------------------------------------------------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(8);
               
                        break;
                        
                     case 9:  //  ventana proyectante  de tres cuerpo con alfajia 0-X-0
                        //         movil seguido fijo seguido  movil  
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(6 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(8 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(2 * cantidadProducto);
                        despie.setCantidadEmpaque(8 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(24 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(9);
                 
                        break;
                          case 10:   //    ventana proyectante  de dos cuerpo con alfajia X-0  ... 10 -----------------------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(10);
                    
                        break;
                        
                    case 11: // ventana proyectante  de TRES cuerpo con alfajia X-0-X
                        //         movil movil sobre fijo  fijo 
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(11);
                

                        break;
                  
                  
                    case 12:   //  proyectante  de dos cuerpo con alfajia X/0 plus ...12 ---------------------------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(12);
           
                        break;
                    case 13:      //   ventana proyectante  de dos cuerpo con 0-0-0-0  ....13 ----------------------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(13);
        
                        break;
                    case 14:  //  ventana proyectante  de dos cuerpo con X/X ALFALJIA  ....14  -----------------------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(14);
         
                        break;
                    case 15:  //  con este codigo fabricamos una ventana proyectante  de TRES cuerpo con 0-0-0 ALFALJIA  ....15   ------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(15);
            
                        break;
                    case 16: //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con 0/0/0/0/ ALFALJIA  ....16  -----------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(16);
         
                        break;
                    case 17: //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con 0x0 ALFALJIA  ....17  ---------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(17);
             
                        break;
                    case 18: //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con X/X/0/0 ALFALJIA  ....18  ---------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(18);
      
                        break;
                    case 19:   //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con X/0 BOREAL ALFALJIA  ....19  -------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(19);
             
                        break;
                    case 20:    //  con este codigo fabricamos una ventana proyectante  de dos cuerpo con 0/0 BOREAL ALFALJIA  ....20 ----------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(20);
          
                        break;
                    case 21:  //  con este codigo fabricamos una ventana proyectante  de cuatro cuerpo con ALFALJIA 21  --------------------------------------
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(2 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setPisaVidrioAncho(2 * cantidadProducto);
                        despie.setCantidadPisaVidriosAlto(4 * cantidadProducto);
                        despie.setCantidadNaveAncho(2 * cantidadProducto);
                        despie.setCantidadNaveAlto(4 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadDivisor(1 * cantidadProducto);
                        despie.setCantidadDivisorAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(4 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(14 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajePisavidrioAncho(despie.getCantidadPisaVidriosAncho() + " Recorte Pisavidrio Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajePisavidrioAlto(despie.getCantidadPisaVidriosAlto() + " Recorte Pisavidrio Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeNaveAncho(despie.getCantidadNaveAncho() + " Recorte Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeNaveAlto(despie.getCantidadNaveAlto() + " Recorte Nave Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeDivisor(despie.getCantidadDivisor() + " Recorte Divisor ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeDivisorAlto(despie.getCantidadDivisorAlto() + " Recorte Divisor ALTO de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(21);
          
                        break;
                }
                break;
                /////////////
            case 2://Corrediza
                switch (tipoVentana) {
                    case 1:  // con este codigo fabricamos una ventana de 2 cuerpos con un movil y un fijo x0
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHorizontalesInferior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEnganche(4 * cantidadProducto);
                        despie.setCantidadEngancheAlto(2 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(4 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferior(despie.getCantidadHInferiorNave() + " Recorte Horizontal Inferior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche ANCHO de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeEngancheAlto(despie.getCantidadEngancheAlto() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(22);
                  
                        break;

                    case 2:  //  ventana de 2 cuerpos moviles xx
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEngancheAlto(2 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(4 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEngancheAlto(despie.getCantidadEngancheAlto() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(23);
                        
                        break;
                    case 3:   //  ventana de 3 cuerpos moviles xox    fijo movil fijo 
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHorizontalesInferior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEngancheReforzado(4 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(8 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(8 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferior(despie.getCantidadHInferiorNave() + " Recorte Horizontal Inferior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEngancheReforzado(despie.getCantidadEngancheReforzado() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(24);
                       
                        break;
                    case 4:     //  ventana de 3 cuerpos moviles oxo  movil fijo movil
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHorizontalesInferior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEnganche(4 * cantidadProducto);
                        despie.setCantidadAdactador(1 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(6 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(6 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferior(despie.getCantidadHInferiorNave() + " Recorte Horizontal Inferior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAdactador(despie.getCantidadAdactador() + " Recorte Adactador Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(25);
                       
                        break;
                    case 5:    //  ventana de 3 cuerpos moviles oxx   fijo movil movil
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHorizontalesInferior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadAdactadorSuperior(1 * cantidadProducto);
                        despie.setCantidadAdactadorInferior(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEnganche(4 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(6 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(6 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAdactadorSuperior(despie.getCantidadAdactadorSuperior() + " Recorte Adaptador superior de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeAdactadorInferior(despie.getCantidadAdactadorInferior() + " Recorte Adaptador Inferior de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferior(despie.getCantidadHInferiorNave() + " Recorte Horizontal Inferior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(26);
                       
                        break;
                    case 6:  // ventana de 3 cuerpos moviles xo/0
                        //  movil fijo sobre fijo basica alf 
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEnganche(2 * cantidadProducto);
                        despie.setCantidadDivisorPanoramico(1 * cantidadProducto);
                        despie.setCantidadJambaCuerpoFijo(1 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(12 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(1 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeDivisorPanoramico(despie.getCantidadDivisorPanoramico() + " Recorte divisor panoramico Ancho de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeJambaCuerpoFijo(despie.getCantidadJambaCuerpoFijo() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(27);
                       
                        break;
                    case 7:     //  ventana de 4 cuerpos moviles 0xx0  fijo movil fijo movil           
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHorizontalesInferior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEnganche(2 * cantidadProducto);
                        despie.setCantidadAdactador(1 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(8 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(8 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferior(despie.getCantidadHorizontalesInferior() + " Recorte Hinferior  Ancho de:  " + (Double.valueOf(ancho) / 2 - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) / 2 - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAdactador(despie.getCantidadAdactador() + " Recorte Adactador Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(28);
                       
                        break;
                    case 8:     // ventana de 4 cuerpos X0/00 Basica Alf   //   
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(2 * cantidadProducto);
                        despie.setCantidadEnganche(2 * cantidadProducto);
                        despie.setCantidadDivisorPanoramico(1 * cantidadProducto);
                        despie.setCantidadSillarAlfaljia(1 * cantidadProducto);
                        despie.setCantidadJambaCuerpoFijo(2 * cantidadProducto);
                        despie.setCantidadDivisorVerticalPanoramico(1 * cantidadProducto);
                        despie.setCantidadEmpaquePvc(2 * cantidadProducto);
                        despie.setCantidadEmpaquePvcAlto(4 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(4 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeDivisorPanoramico(despie.getCantidadDivisorPanoramico() + " Recorte divisor panoramico Ancho de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeSillarAlfaljia(despie.getCantidadSillarAlfaljia() + " Recorte Sillar Alfaljia Ancho de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeJambaCuerpoFijo(despie.getCantidadJambaCuerpoFijo() + " Recorte Jamba Cuerpo fijo Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaquePvc(despie.getCantidadEmpaquePvc() + " Recorte Empaque Ancho pvc de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaquePvcAlto(despie.getCantidadEmpaquePvcAlto() + " Recorte Empaque Pvc Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(29);
                      
                        break;
                    case 9:    // ventana de 6 cuerpos moviles 0XX XX0      //   movil fijo fijo fijo fijo movil  basica alf    
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadAdactadorSuperior(1 * cantidadProducto);
                        despie.setCantidadAdactadorInferior(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(4 * cantidadProducto);
                        despie.setCantidadEnganche(4 * cantidadProducto);
                        despie.setCantidadAdactador(1 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(12 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(12 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAdactadorSuperior(despie.getCantidadAdactadorSuperior() + " Recorte Adaptador superior de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeAdactadorInferior(despie.getCantidadAdactadorInferior() + " Recorte Adaptador Inferior de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAdactador(despie.getCantidadAdactador() + " Recorte Adaptador Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(30);
                      
                        break;
                    case 10:   //ventana de 6 cuerpos moviles 0X0/000   //   fijo  movol fijo  sobre fijo fijo fijo  basica alf         
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(4 * cantidadProducto);
                        despie.setCantidadEnganche(4 * cantidadProducto);
                        despie.setCantidadDivisorPanoramico(1 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadJambaCuerpoFijo(2 * cantidadProducto);
                        despie.setCantidadDivisorVerticalPanoramico(2 * cantidadProducto);
                        despie.setCantidadAdactador(1 * cantidadProducto);
                        despie.setCantidadEmpaquePvc(2 * cantidadProducto);
                        despie.setCantidadEmpaquePvcAlto(6 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(6 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(6 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeDivisorPanoramico(despie.getCantidadDivisorPanoramico() + " Recorte Divisor Panoramico Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia Ancho de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeJambaCuerpoFijo(despie.getCantidadJambaCuerpoFijo() + " Recorte Jamba Cuerpo fijo Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeDivisorVerticalPanoramico(despie.getCantidadDivisorVerticalPanoramico() + " Recorte Divisor Vertical Panoramico Alto de " + (Double.valueOf(alto) / 3 - 1.3));
                        despie.setMensajeAdactador(despie.getCantidadAdactador() + " Recorte Adaptador Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaquePvc(despie.getCantidadEmpaquePvc() + " Recorte Empaque PVC Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaquePvcAlto(despie.getCantidadEmpaquePvcAlto() + " Recorte Empaque PVC Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(31);
                       
                        break;
                    case 11:    //  con este codigo fabricamos una ventana de 6 cuerpos moviles 0XX0/0000      FALTABA
                        //   fijo  movol fijo  sobre fijo fijo fijo  basica alf
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillar(1 * cantidadProducto);
                        despie.setCantidadJamba(2 * cantidadProducto);
                        despie.setCantidadHorizontalesSuperior(1 * cantidadProducto);
                        despie.setCantidadHInferiorNave(1 * cantidadProducto);
                        despie.setCantidadVerticalCerradura(4 * cantidadProducto);
                        despie.setCantidadEnganche(4 * cantidadProducto);
                        despie.setCantidadDivisorPanoramico(1 * cantidadProducto);
                        despie.setCantidadAfajia(1 * cantidadProducto);
                        despie.setCantidadJambaCuerpoFijo(2 * cantidadProducto);
                        despie.setCantidadDivisorVerticalPanoramico(2 * cantidadProducto);
                        despie.setCantidadAdactador(1 * cantidadProducto);
                        despie.setCantidadEmpaquePvc(2 * cantidadProducto);
                        despie.setCantidadEmpaquePvcAlto(6 * cantidadProducto);
                        despie.setCantidadFelpa(4 * cantidadProducto);
                        despie.setCantidadFelpaAlto(6 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(6 * cantidadProducto);
                        despie.setCantidadVidrio(3 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillar(despie.getCantidadCabezal() + " Recorte Sillar de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba Pistas de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHSuperior(despie.getCantidadHorizontalesSuperior() + " Recorte Horizontal Superior Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHInferiorNave(despie.getCantidadHInferiorNave() + " Recorte Hinferior Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeVerticalCerradura(despie.getCantidadVerticalCerradura() + " Recorte vertical cerradura de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEnganche(despie.getCantidadEnganche() + " Recorte enganche Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeDivisorPanoramico(despie.getCantidadDivisorPanoramico() + " Recorte Divisor Panoramico Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeAfajia(despie.getCantidadAfajia() + " Recorte Alfaljia Ancho de " + (Double.valueOf(ancho) - 1.3));
                        despie.setMensajeJambaCuerpoFijo(despie.getCantidadJambaCuerpoFijo() + " Recorte Jamba Cuerpo fijo Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeDivisorVerticalPanoramico(despie.getCantidadDivisorVerticalPanoramico() + " Recorte Divisor Vertical Panoramico Alto de " + (Double.valueOf(alto) / 3 - 1.3));
                        despie.setMensajeAdactador(despie.getCantidadAdactador() + " Recorte Adaptador Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaquePvc(despie.getCantidadEmpaquePvc() + " Recorte Empaque PVC Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaquePvcAlto(despie.getCantidadEmpaquePvcAlto() + " Recorte Empaque PVC Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(32);
                       
                        break;

                }
                break;
            case 3://Batiente
                switch (tipoVentana) {
                    case 1:   // ventana de 2 cuerpos XO plus basica alfa
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillarAlfaljia(1 * cantidadProducto);
                        despie.setCantidadJambaNave(1 * cantidadProducto);
                        despie.setCantidadJamba(1 * cantidadProducto);
                        despie.setCantidadHorizontalNave(2 * cantidadProducto);
                        despie.setCantidadHorizontalMarcoFijo(2 * cantidadProducto);
                        despie.setCantidadHorizontalMarcoFijoAlto(1 * cantidadProducto);
                        despie.setCantidadTraslape(1 * cantidadProducto);
                        despie.setCantidadEngancheMovil(1 * cantidadProducto);
                        despie.setCantidadEngancheReforzado(1 * cantidadProducto);
                        despie.setCantidadFelpa(1 * cantidadProducto);
                        despie.setCantidadFelpaAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillarAlfaljia(despie.getCantidadSillarAlfaljia() + " Recorte Sillar Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJambaNave(despie.getCantidadJambaNave() + " Recorte Jamba Nave de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba  de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHorizontalNave(despie.getCantidadHorizontalNave() + " Recorte Horizontal Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHorizontalMarcoFijo(despie.getCantidadHorizontalMarcoFijo() + " Recorte Horizontal marcofijo Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHorizontalMarcoFijoAlto(despie.getCantidadHorizontalMarcoFijoAlto() + " Recorte Horizontal marcofijo Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte Traslape de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEngancheMovil(despie.getCantidadEngancheMovil() + " Recorte enganche Movil Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEngancheReforzado(despie.getCantidadEngancheReforzado() + " Recorte enganche reforzado Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(33);
                       
                        break;

                    case 2:  // ventana Abatible de 2 cuerpos XX Basica Alfa
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillarAlfaljia(1 * cantidadProducto);
                        despie.setCantidadJambaNave(1 * cantidadProducto);
                        despie.setCantidadHorizontalNave(1 * cantidadProducto);
                        despie.setCantidadHorizontalMarcoFijo(1 * cantidadProducto);
                        despie.setCantidadEntrecierreNaveFijo(2 * cantidadProducto);
                        despie.setCantidadTraslape(2 * cantidadProducto);
                        despie.setCantidadFelpa(1 * cantidadProducto);
                        despie.setCantidadFelpaAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillarAlfaljia(despie.getCantidadSillarAlfaljia() + " Recorte Sillar Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJambaNave(despie.getCantidadJambaNave() + " Recorte Jamba Nave de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHorizontalNave(despie.getCantidadHorizontalNave() + " Recorte Horizontal Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHorizontalMarcoFijo(despie.getCantidadHorizontalMarcoFijo() + " Recorte Horizontal marcofijo Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeEntrecierreNaveFijo(despie.getCantidadEntrecierreNaveFijo() + " Recorte Entrecierre nave fijo marcofijo Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte Traslape de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(34);
                        
                        break;
                    case 3:        // con este codigo fabricamos una ventana de 2 cuerpos X0 plus reforzada
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillarAlfaljia(1 * cantidadProducto);
                        despie.setCantidadJambaNave(1 * cantidadProducto);
                        despie.setCantidadJamba(1 * cantidadProducto);
                        despie.setCantidadHorizontalNave(2 * cantidadProducto);
                        despie.setCantidadHorizontalMarcoFijo(2 * cantidadProducto);
                        despie.setCantidadHorizontalMarcoFijoAlto(1 * cantidadProducto);
                        despie.setCantidadTraslape(1 * cantidadProducto);
                        despie.setCantidadEngancheReforzado(2 * cantidadProducto);
                        despie.setCantidadFelpa(1 * cantidadProducto);
                        despie.setCantidadFelpaAlto(1 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(4 * cantidadProducto);
                        despie.setCantidadVidrio(2 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillarAlfaljia(despie.getCantidadSillarAlfaljia() + " Recorte Sillar Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJambaNave(despie.getCantidadJambaNave() + " Recorte Jamba Nave de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba  de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHorizontalNave(despie.getCantidadHorizontalNave() + " Recorte Horizontal Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHorizontalMarcoFijo(despie.getCantidadHorizontalMarcoFijo() + " Recorte Horizontal marcofijo Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHorizontalMarcoFijoAlto(despie.getCantidadHorizontalMarcoFijoAlto() + " Recorte Horizontal marcofijo Alto de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte Traslape de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeEngancheReforzado(despie.getCantidadEngancheReforzado() + " Recorte enganche reforzado Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(35);
                       
                        break;
                    case 4:          //con este codigo fabricamos una ventana de 4 cuerpos 0XX0 1672 DOBLE
                        despie.setCantProducto(cantidadProducto);
                        despie.setCantidadCabezal(1 * cantidadProducto);
                        despie.setCantidadSillarAlfaljia(1 * cantidadProducto);
                        despie.setCantidadJamba(1 * cantidadProducto);
                        despie.setCantidadHorizontalNave(1 * cantidadProducto);
                        despie.setCantidadHorizontalMarcoFijo(1 * cantidadProducto);
                        despie.setCantidadTraslape(2 * cantidadProducto);
                        despie.setCantidadAdactador(1 * cantidadProducto);
                        despie.setCantidadEngancheReforzado(4 * cantidadProducto);
                        despie.setCantidadFelpa(1 * cantidadProducto);
                        despie.setCantidadFelpaAlto(5 * cantidadProducto);
                        despie.setCantidadEmpaque(2 * cantidadProducto);
                        despie.setCantidadEmpaqueAlto(8 * cantidadProducto);
                        despie.setCantidadVidrio(4 * cantidadProducto);
                        despie.setMensajeCabezal(despie.getCantidadCabezal() + " Recorte Cabezal de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeSillarAlfaljia(despie.getCantidadSillarAlfaljia() + " Recorte Sillar Alfaljia de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeJamba(despie.getCantidadJamba() + " Recorte Jamba  de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeHorizontalNave(despie.getCantidadHorizontalNave() + " Recorte Horizontal Nave Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeHorizontalMarcoFijo(despie.getCantidadHorizontalMarcoFijo() + " Recorte Horizontal marcofijo Ancho de:  " + (Double.valueOf(ancho) - 2.5));
                        despie.setMensajeTraslape(despie.getCantidadTraslape() + " Recorte Traslape de:  " + (Double.valueOf(alto) - 2.5));
                        despie.setMensajeAdactador(despie.getCantidadAdactador() + " Recorte Adaptador Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEngancheReforzado(despie.getCantidadEngancheReforzado() + " Recorte enganche reforzado Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpa(despie.getCantidadFelpa() + " Recorte Felpa  Ancho de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeFelpaAlto(despie.getCantidadFelpaAlto() + " Recorte Felpa  Alto de " + (Double.valueOf(alto) - 1.3));
                        despie.setMensajeEmpaque(despie.getCantidadEmpaque() + " Recorte Empaque Ancho de:  " + (Double.valueOf(ancho)));
                        despie.setMensajeEmpaqueAlto(despie.getCantidadEmpaqueAlto() + " Recorte Empaque Alto de:  " + (Double.valueOf(alto)));
                        despie.setMensajeVidrio(despie.getCantidadVidrio() + " Recorte Vidrio Alto de: " + (Double.valueOf(alto) - 5) + "  Recorte VidrioAncho de: " + (Double.valueOf(ancho) - 5.5));
                        despie.setNombreProducto(nombre + "  " + alto + "*" + ancho);
                        despie.setTipoProducto(36);
                      
                        break;
                }
                break;
        }
        return despie;
    }

}
