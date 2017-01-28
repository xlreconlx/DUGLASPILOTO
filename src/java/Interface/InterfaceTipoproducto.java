/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Tipoproducto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public interface InterfaceTipoproducto {

    public boolean registrar(Session session, Tipoproducto tipoProducto) throws Exception;

    public List<Tipoproducto> getAll(Session session) throws Exception;

    public Tipoproducto getByCodigoTipoProducto(Session session, int Tipoproducto) throws Exception;

    public boolean update(Session session, Tipoproducto tipoproducto) throws Exception;

}
