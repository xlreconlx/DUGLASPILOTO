/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MbView;

import Clases.ValidacionTexto;
import Daos.DaoTipoProducto;
import HibernateUtil.HibernateUtil;
import Pojos.Tipoproducto;
import java.util.ArrayList;
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
public class BeanTipoProducto {

    /**
     * Creates a new instance of BeanTipoProducto
     */
    private Session session;
    private Transaction transacion;

    private Tipoproducto tipoProducto;
    private List<Tipoproducto> listaTipoproducto;
    private List<Tipoproducto> listaTipoproductoFiltrado;
    private int codigoTipoproducto;

    public BeanTipoProducto() {
        this.tipoProducto = new Tipoproducto();
        this.listaTipoproducto = new ArrayList<>();

    }

    public void registrar() {
        this.session = null;
        this.transacion = null;

        try {

            if (this.tipoProducto.getNombre().equals("") || this.tipoProducto.getNombre().length() < 2) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres es muy corto"));
                return;
            }

            ValidacionTexto valida = new ValidacionTexto();

            if (!valida.validar(this.tipoProducto.getNombre())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres no puede llevar numeros ni caracteres especiales"));

                return;
            }

            DaoTipoProducto daoTipoProducto = new DaoTipoProducto();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transacion = session.beginTransaction();

            if (daoTipoProducto.getByCodigoTipoProducto(this.session, this.codigoTipoproducto) != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El tipo de Producto ya se encuentra registrado en el sistema"));

                return;
            }

            daoTipoProducto.registrar(this.session, this.tipoProducto);

            this.transacion.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));

            this.tipoProducto = new Tipoproducto();
            this.tipoProducto.setIdtipoProducto(Integer.MIN_VALUE);

        } catch (Exception ex) {
            if (this.transacion != null) {
                this.transacion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }

    }

    public void update() {

        this.session = null;
        this.transacion = null;

        try {

            DaoTipoProducto daoTipoProducto = new DaoTipoProducto();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transacion = session.beginTransaction();

            if (this.tipoProducto.getNombre().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres es obligatorio"));
                return;

            }

            daoTipoProducto.update(this.session, this.tipoProducto);

            this.transacion.commit();

            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("NombreTipoProducto", this.tipoProducto.getNombre());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Los cambios fueron guardados correctamente"));

        } catch (Exception e) {
            if (this.transacion != null) {
                this.transacion.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + e.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void cargarTipoProductoEditar(int codigoTipoProducto) {
        this.session = null;
        this.transacion = null;

        try {

            DaoTipoProducto daoTipoProducto = new DaoTipoProducto();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transacion = session.beginTransaction();

            this.tipoProducto = daoTipoProducto.getByCodigoTipoProducto(this.session, codigoTipoProducto);

            RequestContext.getCurrentInstance().update("frmEditarTipoProducto:panelEditarTipoProducto");
            RequestContext.getCurrentInstance().execute("PF('dialogoTipoProducto').show()");

            this.transacion.commit();

        } catch (Exception e) {
            if (this.transacion != null) {
                this.transacion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + e.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }

    }

    ;
        
        public List<Tipoproducto> getALL() {
        this.session = null;
        this.transacion = null;

        try {

            DaoTipoProducto daoTipoProducto = new DaoTipoProducto();
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transacion = session.beginTransaction();

            this.listaTipoproducto = daoTipoProducto.getAll(this.session);

            this.transacion.commit();
            return this.listaTipoproducto;

        } catch (Exception e) {
            if (this.transacion != null) {
                this.transacion.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor intente mas tarde " + e.getMessage()));
            return null;

        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
        
            public Tipoproducto getByIdTipoProducto( int tipoProducto) {
        this.session = null;
        this.transacion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transacion = this.session.beginTransaction();
            DaoTipoProducto daoTipoProducto = new DaoTipoProducto();
            
            Tipoproducto tipo = daoTipoProducto.getByCodigoTipoProducto(this.session, tipoProducto);
        
            this.transacion.commit();
            return tipo;

        } catch (Exception ex) {
            if (this.transacion != null) {
                this.transacion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }
    }

    public Tipoproducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Tipoproducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<Tipoproducto> getListaTipoproducto() {
        return listaTipoproducto;
    }

    public void setListaTipoproducto(List<Tipoproducto> listaTipoproducto) {
        this.listaTipoproducto = listaTipoproducto;
    }

    public List<Tipoproducto> getListaTipoproductoFiltrado() {
        return listaTipoproductoFiltrado;
    }

    public void setListaTipoproductoFiltrado(List<Tipoproducto> listaTipoproductoFiltrado) {
        this.listaTipoproductoFiltrado = listaTipoproductoFiltrado;
    }

    public int getCodigoTipoproducto() {
        return codigoTipoproducto;
    }

    public void setCodigoTipoproducto(int codigoTipoproducto) {
        this.codigoTipoproducto = codigoTipoproducto;
    }

}
