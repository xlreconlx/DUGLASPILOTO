/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Compradetalle;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public interface InterfaceCompraDetalle {
        public boolean insert(Session session, Compradetalle compradetalle) throws Exception;
        public List<Compradetalle>getAll(Session session)throws Exception;

    
}
