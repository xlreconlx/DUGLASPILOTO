package Pojos;
// Generated 4/01/2017 09:04:05 PM by Hibernate Tools 4.3.1



/**
 * ManoObra generated by hbm2java
 */
public class ManoObra  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Integer precio;

    public ManoObra() {
    }

    public ManoObra(String nombre, Integer precio) {
       this.nombre = nombre;
       this.precio = precio;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }




}


