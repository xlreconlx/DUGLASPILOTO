/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MbView;

import Clases.ValidacionTexto;
import Daos.DaoCiudad;
import Daos.DaoProveedor;
import Daos.DaoTipodocumento;
import HibernateUtil.HibernateUtil;
import Pojos.Proveedor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author William Sanchez
 */
@ManagedBean
@ViewScoped
public class BeanProveedor {

    /**
     * Creates a new instance of BeanProveedor
     */
    private Session session;
    private Transaction transaccion;

    private Proveedor proveedor;
    private List<Proveedor> listaProveedor;
    private List<Proveedor> listaProveedorFiltrado;
    private int codigoProveedor;
    private String numeroDocumento;
    private String correoElectronico;
  private int CodigoCiudad;
    private int CodigotipoDocumento;

    public BeanProveedor() {
        this.proveedor = new Proveedor();
        this.proveedor.setIdproveedor(Integer.MIN_VALUE);
        this.correoElectronico = "";
        this.CodigoCiudad = 0;
        this.CodigotipoDocumento = 0;
    }

    public void registrar() {
        this.session = null;
        this.transaccion = null;

        try {
            if (this.proveedor.getNombre().equals("") || this.proveedor.getNombre().length() < 2) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres es muy corto"));
                return ;
            }

            ValidacionTexto valida = new ValidacionTexto();

            if (!valida.validar(this.proveedor.getNombre())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres no puede llevar numeros ni caracteres especiales"));

                return ;
            }

            if (this.proveedor.getNumeroDocumento().equals("") || this.proveedor.getNumeroDocumento().length() < 5) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El numero de documento es obligatorio y debe contener minimo 5 caracteres"));
                return ;
            }
            DaoProveedor daoproveedor = new DaoProveedor();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();

            DaoCiudad daoCiudad = new DaoCiudad();
            DaoTipodocumento daoTipodocumento = new DaoTipodocumento();

            this.proveedor.setCiudad(daoCiudad.getByCodigoCiudad(this.session, this.CodigoCiudad));
            this.proveedor.setTipodocumento(daoTipodocumento.getByCodigoTipodocumeno(this.session, this.CodigotipoDocumento));

            daoproveedor.registrar(this.session, this.proveedor);

            this.transaccion.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));

            this.proveedor = new Proveedor();
            this.proveedor.setIdproveedor(Integer.MIN_VALUE);
            this.correoElectronico = "";
            this.CodigoCiudad = 0;
            this.CodigotipoDocumento = 0;

         

        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    
    }

    public Proveedor getByCorreoElectronico() {
        this.session = null;
        this.transaccion = null;

        try {
            DaoProveedor daoproveedor = new DaoProveedor();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            HttpSession sessionProveedor = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

            this.proveedor = daoproveedor.getByCorreoElectronico(this.session, sessionProveedor.getAttribute("correoElectronico").toString());

            this.transaccion.commit();

            return this.proveedor;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
        return null;
    }

    public void update() {
        this.session = null;
        this.transaccion = null;

        try {
            DaoProveedor daoproveedor = new DaoProveedor();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();

            if (this.proveedor.getNombre().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres es obligatorio"));
                return;
            }

       

            daoproveedor.update(this.session, this.proveedor);

            this.transaccion.commit();

            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("correoElectronico", this.proveedor.getCorreoElectronico());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Los cambios fueron guardados correctamente"));
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public List<Proveedor> getAll() {
        this.session = null;
        this.transaccion = null;
        try {
            DaoProveedor dao = new DaoProveedor();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.listaProveedor = dao.getAll(this.session);
            this.transaccion.commit();
            return this.listaProveedor;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void cargarProveedorEditar(int codigoProveedor) {
        this.session = null;
        this.transaccion = null;

        try {
            DaoProveedor daoProveedor = new DaoProveedor();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();

            this.proveedor = daoProveedor.getByCodigoProveedor(this.session, codigoProveedor);

            RequestContext.getCurrentInstance().update("frmEditarProveedor:panelEditarProveedor");
            RequestContext.getCurrentInstance().execute("PF('dialogoEditarProveedor').show()");

            this.transaccion.commit();
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

     public Proveedor getById(int id) {
        this.session = null;
        this.transaccion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
               DaoProveedor daoProveedor = new DaoProveedor();

            Proveedor provee = daoProveedor.getByCodigoProveedor(this.session, id);
            this.transaccion.commit();
            return provee;

        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public List<Proveedor> getListaProveedorFiltrado() {
        return listaProveedorFiltrado;
    }

    public void setListaProveedorFiltrado(List<Proveedor> listaProveedorFiltrado) {
        this.listaProveedorFiltrado = listaProveedorFiltrado;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getCodigoCiudad() {
        return CodigoCiudad;
    }

    public void setCodigoCiudad(int CodigoCiudad) {
        this.CodigoCiudad = CodigoCiudad;
    }

    public int getCodigotipoDocumento() {
        return CodigotipoDocumento;
    }

    public void setCodigotipoDocumento(int CodigotipoDocumento) {
        this.CodigotipoDocumento = CodigotipoDocumento;
    }

}
