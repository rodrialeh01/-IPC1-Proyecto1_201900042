package Clases;

//==================LIBRERIAS===============
//IO-SERIALIZABLE
import java.io.Serializable;

public class Sucursales implements Serializable{
    
    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private String direccion;
    private String correo;
    private int telefono;
    
    //CONSTRUCTOR
    public Sucursales(int codigo, String nombre, String direccion, String correo, int telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    //METODO PARA MOSTRAR LOS OBJETOS
    public void MostrarSucursales(){
        System.out.println("====================================");
        System.out.println("==            SUCURSAL            ==");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Correo: " + correo);
        System.out.println("Telefono: " + telefono);
    }
    
    //ENCAPSULAMIENTO
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
