/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Accesorios;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public interface InterfaceAccesorios {
    public boolean registar(Session session, Accesorios accesorios)throws Exception;
    public boolean actualizar(Session session, Accesorios accesorios)throws Exception;
    public boolean eliminar(Session session, Accesorios accesorios)throws Exception;
    public Accesorios getById(Session session, int id)throws Exception;
    public List<Accesorios> getAll(Session session)throws Exception; 
        public Accesorios getByCodigoBarras(Session session, String codigoBarras) throws Exception;
}
