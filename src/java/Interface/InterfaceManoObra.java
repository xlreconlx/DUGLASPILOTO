/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.ManoObra;
import org.hibernate.Session;

/**
 *
 * @author ander
 */
public interface InterfaceManoObra {
    public boolean actualizar(Session session,ManoObra obra)throws Exception;
    public ManoObra getById(Session session, int id)throws Exception;
}
