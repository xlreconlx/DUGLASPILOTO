/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interface.InterfaceManoObra;
import Pojos.ManoObra;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author ander
 */
public class DaoManoObra implements InterfaceManoObra, Serializable {

    @Override
    public boolean actualizar(Session session, ManoObra obra) throws Exception {
        session.update(obra);
        return true;
    }

    @Override
    public ManoObra getById(Session session, int id) throws Exception {
        return (ManoObra) session.get(ManoObra.class, id);
    }

}
