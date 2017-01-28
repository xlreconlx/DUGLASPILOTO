/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MbView;

import Daos.DaoAccesorios;
import HibernateUtil.HibernateUtil;
import Pojos.Accesorios;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author William Sanchez
 */
@ManagedBean
@ViewScoped
public class BeanAccesorio {

    /**
     * Creates a new instance of BeanAccesorio
     */
    private Session session;
    private Transaction transaccion;
    private Accesorios accesorio;
    private List<Accesorios> listaAccesorios;
    private List<Accesorios> listaAccesoriosFiltrado;
    private Accesorios accesoriosSelect;
    private UploadedFile avatar;
    private int codigoAccesorios;

    public BeanAccesorio() {
        this.accesorio = new Accesorios();
        this.listaAccesorios = new ArrayList<>();
    }

    public void registrar() {
        this.session = null;
        this.transaccion = null;

        try {
            if (this.accesorio.getNombre().equals("") || this.accesorio.getNombre().length() < 4) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres es muy corto"));
                return;
            }

            DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();

            daoAccesorios.registar(this.session, this.accesorio);

            this.transaccion.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El registro fue realizado correctamente"));
            this.accesorio = new Accesorios();
            this.listaAccesorios = new ArrayList<>();

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

    public List<Accesorios> getAll() {
        this.session = null;
        this.transaccion = null;

        try {
            DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.listaAccesorios = daoAccesorios.getAll(this.session);

            this.transaccion.commit();

            return this.listaAccesorios;
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

    public void actualizar() {
        this.session = null;
        this.transaccion = null;

        try {
            DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();

            if (this.accesorio.getNombre().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El campo nombres es obligatorio"));
                return;
            }

            daoAccesorios.actualizar(this.session, this.accesorio);

            this.transaccion.commit();

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

    public void cargarAccesoriosEditar(int codigoAccesorios) {
        this.session = null;
        this.transaccion = null;

        try {
            DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();

            this.accesorio = daoAccesorios.getById(this.session, codigoAccesorios);
//            this.transaccion.commit();
            RequestContext.getCurrentInstance().update("frmEditarAccesorio:panelEditarAccesorio");
            RequestContext.getCurrentInstance().execute("PF('dialogoEditarAccesorio').show()");

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

    public void actualizarAvatar() throws IOException {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {

            if (this.avatar.getSize() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ud. debe seleccionar un archivo de imagen \".png\""));
                return;
            }

            if (this.avatar.getFileName().endsWith(".png") || this.avatar.getFileName().endsWith(".jpg")) {

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "No se reconoce la extencion del archivo"));
                return;
            }

            if (this.avatar.getSize() > 2097152) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El archivo no puede ser más de 2mb"));
                return;
            }

//             HttpSession sessionUsuario = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String carpetaAccesorios = (String) servletContext.getRealPath("/carpetaAccesorios");

            outputStream = new FileOutputStream(new File(carpetaAccesorios + "/" + this.accesoriosSelect.getIdaccesorios() + ".png"));
            inputStream = this.avatar.getInputstream();

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

//            actualizarFoto(getById().getIdaccesorios() + this.avatar.getFileName());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Avatar actualizado correctamente"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

        } finally {

            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
        }

    }

    public Accesorios getById() {
        this.session = null;
        this.transaccion = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            DaoAccesorios daoAccesorios = new DaoAccesorios();

            Accesorios produc = daoAccesorios.getById(this.session, this.codigoAccesorios);
            this.transaccion.commit();
            return produc;

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

//    public void actualizarFoto(String nombreFoto) {
//        this.session = null;
//        this.transaccion = null;
//
//        try {
//
//            DaoAccesorios daoAccesorios = new DaoAccesorios();
//            Accesorios product;
//            product = getById();
//
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaccion = session.beginTransaction();
//
//            product.setImgPrinci(nombreFoto);
//            daoAccesorios.actualizar(this.session, product);
//
//            this.transaccion.commit();
//        } catch (Exception ex) {
//            if (this.transaccion != null) {
//                this.transaccion.rollback();
//            }
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
//        } finally {
//            if (this.session != null) {
//                this.session.close();
//            }
//        }
//
//    }
    public void cargarAccesorioEditarAvatar(int codigoAccesorio) {
        this.session = null;
        this.transaccion = null;
        System.out.println("Entra a cargar empleado");
        try {
            DaoAccesorios daoAccesorios = new DaoAccesorios();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = session.beginTransaction();
            this.accesoriosSelect = daoAccesorios.getById(this.session, codigoAccesorio);

            System.out.println("Cargo el Accesorio: " + this.accesoriosSelect.getIdaccesorios());

            RequestContext.getCurrentInstance().update(":avatarEmple:frmActualizarAvatar");
            RequestContext.getCurrentInstance().execute("PF('dialogoActualizarAvatar').show()");

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

    public Accesorios getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(Accesorios accesorio) {
        this.accesorio = accesorio;
    }

    public List<Accesorios> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(List<Accesorios> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    public List<Accesorios> getListaAccesoriosFiltrado() {
        return listaAccesoriosFiltrado;
    }

    public void setListaAccesoriosFiltrado(List<Accesorios> listaAccesoriosFiltrado) {
        this.listaAccesoriosFiltrado = listaAccesoriosFiltrado;
    }

    public Accesorios getAccesoriosSelect() {
        return accesoriosSelect;
    }

    public void setAccesoriosSelect(Accesorios accesoriosSelect) {
        this.accesoriosSelect = accesoriosSelect;
    }

    public UploadedFile getAvatar() {
        return avatar;
    }

    public void setAvatar(UploadedFile avatar) {
        this.avatar = avatar;
    }

}
