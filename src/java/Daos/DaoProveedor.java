/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interface.InterfaceProveedor;
import Pojos.Proveedor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public class DaoProveedor implements InterfaceProveedor {

    @Override
    public boolean registrar(Session session, Proveedor proveedor) throws Exception {
        session.save(proveedor);
        return true;
    }

    @Override
    public List<Proveedor> getAll(Session session) throws Exception {
        String hql = "from Proveedor";
        Query query = session.createQuery(hql);

        List<Proveedor> listaProveedor = (List<Proveedor>) query.list();

        return listaProveedor;
    }

    @Override
    public Proveedor getByCorreoElectronico(Session session, String correoElectronico) throws Exception {
        String hql = "from Proveedor where correoElectronico=:correoElectronico";
        Query query = session.createQuery(hql);
        query.setParameter("correoElectronico", correoElectronico);

        Proveedor proveedor = (Proveedor) query.uniqueResult();

        return proveedor;
    }

    @Override
    public Proveedor getByNumeroDocumento(Session session, String numerodocumentoprov) throws Exception {
        String hql = "FROM Proveedor WHERE numeroDocumento=:numeroDocumento";
        Query query = session.createQuery(hql);
        query.setParameter("numeroDocumento", numerodocumentoprov);
        return (Proveedor) query.uniqueResult();
    }

    @Override
    public boolean update(Session session, Proveedor proveedor) throws Exception {
        session.update(proveedor);
        return true;
    }

    @Override
    public boolean delete(Session session, Proveedor proveedor) throws Exception {
        session.delete(proveedor);
        return true;
    }

    @Override
    public Proveedor getByCodigoProveedor(Session session, int codigoProveedor) throws Exception {
   return (Proveedor) session.get(Proveedor.class, codigoProveedor); 
    }

    @Override
    public Proveedor getByNumeroDocumento(Session session, Long numerodocumento) throws Exception {
 String hql = "FROM Proveedor WHERE numeroDocumento=:numeroDocumento";
        Query query = session.createQuery(hql);
        query.setParameter("numeroDocumento", numerodocumento);
        return (Proveedor) query.uniqueResult();    }

}
