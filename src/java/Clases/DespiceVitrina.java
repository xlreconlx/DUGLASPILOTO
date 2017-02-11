/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author ander
 */
public class DespiceVitrina implements Serializable {

    public DespiceVitrina() {
    }

    public Despiece generaDespiece(int tipoVitrina, int cantidadProducto,String alto,String ancho,String nombre) {
        Despiece despie = new Despiece();
        
        switch(tipoVitrina){
            case 1:
                despie.setCantProducto(cantidadProducto);
                despie.setNombreProducto(nombre);
                despie.setTipoProducto(40);
                break;
            case 2:
                despie.setCantProducto(cantidadProducto);
                despie.setNombreProducto(nombre);
                despie.setTipoProducto(41);
                break;
            case 3:
                despie.setCantProducto(cantidadProducto);
                despie.setNombreProducto(nombre);
                despie.setTipoProducto(42);
                break;
            case 4:
                despie.setCantProducto(cantidadProducto);
                despie.setNombreProducto(nombre);
                despie.setTipoProducto(43);
                break;
            case 5:
                despie.setCantProducto(cantidadProducto);
                despie.setNombreProducto(nombre);
                despie.setTipoProducto(44);
                break;
        }
        
        return despie;
    }

}
