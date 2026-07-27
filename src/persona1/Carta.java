/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona1;


/**
 *
 * @author wesrm
 */
public class Carta {
    private String imagen;
    private boolean estado;
    private String nombre;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carta(String imagen, String nombre) {
        this.imagen = imagen;
        this.estado = false;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carta{" + "imagen=" + imagen + ", estado=" + estado + ", nombre=" + nombre + '}';
    }
    
    

}