/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interface.InterfaceAccesorios;
import Pojos.Accesorios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public class DaoAccesorios implements InterfaceAccesorios{

    @Override
    public boolean registar(Session session, Accesorios accesorios) throws Exception {
session.save(accesorios);
    return true;
    }

    @Override
    public boolean actualizar(Session session, Accesorios accesorios) throws Exception {
session.update(accesorios);
    return true;
    }

    @Override
    public boolean eliminar(Session session, Accesorios accesorios) throws Exception {
session.delete(accesorios);
    return true;
    }

    @Override
    public Accesorios getById(Session session, int id) throws Exception {
      return (Accesorios) session.get(Accesorios.class, id);    }

    @Override
    public List<Accesorios> getAll(Session session) throws Exception {
        String hql = "FROM Accesorios";
        Query query = session.createQuery(hql);
        return (List<Accesorios>) query.list();
    }

    @Override
    public Accesorios getByCodigoBarras(Session session, String codigoBarras) throws Exception {
     String hql="from Accesorios where codigoBrras=:codigoBrras";
        Query query=session.createQuery(hql);
        query.setParameter("codigoBrras", codigoBarras);
        
        return (Accesorios) query.uniqueResult();    }
    
}
