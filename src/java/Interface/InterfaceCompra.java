/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Compras;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
    public interface InterfaceCompra {
    public boolean insert(Session session, Compras compras) throws Exception;
    public Compras getUltimoRegistro(Session session) throws Exception;
    public List< Compras> getAll(Session session) throws Exception;
   public boolean update(Session session, Compras compras) throws Exception;
   public boolean delete(Session session, Compras compras) throws Exception;
   public Compras getByCodigoCompras(Session session, int codigoAbonos) throws Exception;
   public List<Compras> getAllFecha(Session session, Date fechaInicio, Date fechaFin) throws Exception;
    public Compras getByCodigoBarras(Session session, String codigoBarras) throws Exception;
 
    
}
