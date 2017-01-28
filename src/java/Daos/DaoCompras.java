/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interface.InterfaceCompra;
import Pojos.Compras;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public class DaoCompras implements InterfaceCompra{

    @Override
    public boolean insert(Session session,Compras compras) throws Exception {
  session.save(compras);

        return true;
    }

    @Override
    public Compras getUltimoRegistro(Session session) throws Exception {
 String hql = "from Compras order by idCompras desc";
        Query query = session.createQuery(hql).setMaxResults(1);


        return (Compras) query.uniqueResult();    
}
     @Override
      public List<Compras> getAll(Session session) throws Exception {
        String hql = "from Compras";
        Query query = session.createQuery(hql);
        List<Compras> listaCompras = (List<Compras>) query.list();
        return listaCompras; 
    }

    @Override
    public boolean update(Session session, Compras compras) throws Exception {
session.update(compras);
    return true;
    }

    @Override
    public boolean delete(Session session, Compras compras) throws Exception {
session.delete(compras);
    return true;
    }

    @Override
    public Compras getByCodigoCompras(Session session, int codigoAbonos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compras> getAllFecha(Session session, Date fechaInicio, Date fechaFin) throws Exception {
 String hql = "from Compras where fechacompra between :fechaInicio and :fechaFin";
        Query query = session.createQuery(hql);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
        return (List<Compras>) query.list();
    }

    @Override
    public Compras getByCodigoBarras(Session session, String codigoBarras) throws Exception {
     String hql="from Compras where codigoBarras=:codigoBarras";
        Query query=session.createQuery(hql);
        query.setParameter("codigoBarras", codigoBarras);
        
        return (Compras) query.uniqueResult();    }
}
