/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interface.InterfaceCompraDetalle;
import Pojos.Compradetalle;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public class DaoCompraDetalle implements InterfaceCompraDetalle{

    @Override
    public boolean insert(Session session, Compradetalle compradetalle) throws Exception {
  session.save(compradetalle);
        
        return true;
        }    

    @Override
    public List<Compradetalle> getAll(Session session) throws Exception {
  String hql="from Compradetalle";
        Query query=session.createQuery(hql);
        
        List<Compradetalle> listaCompradetalle=(List<Compradetalle>) query.list();
        
        return listaCompradetalle;   
    }
    
}
