/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interface.InterfaceTipoproducto;
import Pojos.Tipoproducto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public class DaoTipoProducto implements InterfaceTipoproducto {

    @Override
    public boolean registrar(Session session, Tipoproducto tipoProducto) throws Exception {
        session.save(tipoProducto);
        return true;
    }

    @Override
    public List<Tipoproducto> getAll(Session session) throws Exception {
        String hql = "from Tipoproducto";
        Query query = session.createQuery(hql);
        List<Tipoproducto> listaTipoproducto = (List<Tipoproducto>) query.list();
        return listaTipoproducto;
    }

    @Override
    public Tipoproducto getByCodigoTipoProducto(Session session, int Tipoproducto) throws Exception {
        return (Tipoproducto) session.get(Tipoproducto.class, Tipoproducto);
    }

    @Override
    public boolean update(Session session, Tipoproducto tipoproducto) throws Exception {
        session.update(tipoproducto);
        return true;
    }

}
