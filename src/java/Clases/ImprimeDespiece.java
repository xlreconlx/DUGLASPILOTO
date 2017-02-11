/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author William Sanchez
 */
public class ImprimeDespiece implements Serializable {

    public String imprime(List<Despiece> lstDespiece) {
        String html = "";
        //Imprime la imagen la ruta hay que cambiarla segun la carpeta donde este la imagen
        //  html+="<img src=\"C:\imagenes\img.jpg\"></img>";
        for (Despiece item : lstDespiece) {
            switch (item.getTipoProducto()) {
                case 1:  // ventanas proyectantes

                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio 3 Alto:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 2:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio 3 Alto:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 3:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio 3 Alto:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 4:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio 3 Alto:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 5:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 6:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 7:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 8:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 9:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePisavidrioAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAfajia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisor() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisorAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 10:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferiorNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEngancheAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 11:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferiorNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEngancheAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 12:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferiorNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEngancheAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 13:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferiorNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 14:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactadorSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactadorInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferiorNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 15:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisorPanoramico() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJambaCuerpoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 16:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferiorNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 17:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisorPanoramico() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJambaCuerpoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaquePvc() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaquePvcAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 18:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactadorSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactadorInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 19:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHSuperior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHInferior() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVerticalCerradura() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisorPanoramico() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJambaCuerpoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeDivisorVerticalPanoramico() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaquePvc() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaquePvcAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 20:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillar() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJambaNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijoAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTraslape() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEngancheMovil() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEngancheReforzado() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 21:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJambaNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEntrecierreNaveFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTraslape() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 22:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJambaNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijoAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTraslape() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 23:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;

//                    por definir de la 24 a al 36
                case 24:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 25:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 26:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 27:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 28:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 29:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 30:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 31:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 32:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 33:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 34:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 35:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 36:
                    html += "<p>Tipo Producto Ventana</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeCabezal() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeSillarAlfaljia() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeJamba() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalNave() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeHorizontalMarcoFijo() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEnganche() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeAdactador() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Felpa :" + item.getMensajeFelpaAlto() + "</p>";
                    html += "<p>Empaque :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Empaque:" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Vidrio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                // Hasta Aqui llegan las ventanas -------------------------------------------------------------------------

                //comienzan las puertas ...............................................................................
                case 37:
                    html += "<p>Tipo Producto Puerta</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeMarcoAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeMarcoAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeInfNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePirlan() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensageEmpaqueEcv() + "</p>";
                    html += "<p>Aluminio :" + item.getMensageEmpaqueEcv() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVisagras() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTornilloEnsam() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTornilloInst() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 38:
                    html += "<p>Tipo Producto Puerta</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeMarcoAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeMarcoAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeInfNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePirlan() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensageEmpaqueEcv() + "</p>";
                    html += "<p>Aluminio :" + item.getMensageEmpaqueEcv() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVisagras() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTornilloEnsam() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTornilloInst() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;
                case 39:
                    html += "<p>Tipo Producto Puerta</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeMarcoAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeMarcoAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeInfNaveAncho() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajePirlan() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeFelpa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaque() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEmpaqueAlto() + "</p>";
                    html += "<p>Aluminio :" + item.getMensageEmpaqueEcv() + "</p>";
                    html += "<p>Aluminio :" + item.getMensageEmpaqueEcv() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVisagras() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeEscuadras1() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeChapa() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTornilloEnsam() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeTornilloInst() + "</p>";
                    html += "<p>Aluminio :" + item.getMensajeVidrio() + "</p>";
                    html += "______________________________________________________";
                    break;

                // hasta aqui llegan las puertas..................................................................
                //comienzan las vitrinas--------------------------------------------------------------------------
                case 40:
                    html += "<p>Tipo Producto Vitrina</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";

                    html += "______________________________________________________";
                    break;
                case 41:
                    html += "<p>Tipo Producto Vitrina</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";

                    html += "______________________________________________________";
                    break;
                case 42:
                    html += "<p>Tipo Producto Vitrina</p><br></br>";
                    html += "<p>Nombre: " + item.getNombreProducto() + "</p>";

                    html += "______________________________________________________";
                    break;

            }
        }
        return html;
    }

}
