/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Proveedor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author William Sanchez
 */
public interface InterfaceProveedor {
    
       public boolean registrar(Session session, Proveedor proveedor) throws Exception;

    public List<Proveedor> getAll(Session session) throws Exception;

    public Proveedor getByCorreoElectronico(Session session, String correoElectronico) throws Exception;

    public Proveedor getByNumeroDocumento(Session session, String numerodocumentoprov) throws Exception;
  public Proveedor getByNumeroDocumento(Session session, Long numerodocumento) throws Exception;
    public boolean update(Session session, Proveedor proveedor) throws Exception;

    public boolean delete(Session session, Proveedor proveedor) throws Exception;
    
    public Proveedor getByCodigoProveedor(Session session, int codigoProveedor) throws Exception;
    
}
