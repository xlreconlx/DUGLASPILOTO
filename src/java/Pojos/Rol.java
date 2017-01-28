package Pojos;
// Generated 4/01/2017 09:04:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private int idrol;
     private String nombreRol;
     private Set empleados = new HashSet(0);

    public Rol() {
    }

	
    public Rol(int idrol, String nombreRol) {
        this.idrol = idrol;
        this.nombreRol = nombreRol;
    }
    public Rol(int idrol, String nombreRol, Set empleados) {
       this.idrol = idrol;
       this.nombreRol = nombreRol;
       this.empleados = empleados;
    }
   
    public int getIdrol() {
        return this.idrol;
    }
    
    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }
    public String getNombreRol() {
        return this.nombreRol;
    }
    
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public Set getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }




}


