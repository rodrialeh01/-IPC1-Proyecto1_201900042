package Clases;

public class Ventas {
    private int nofactura;
    private int nit;
    private String nombre;
    private String fecha;
    private double total;
    
    //CONSTRUCTOR
    public Ventas(int nofactura, int nit, String nombre, String fecha, double total) {
        this.nofactura = nofactura;
        this.nit = nit;
        this.nombre = nombre;
        this.fecha = fecha;
        this.total = total;
    }
    
    //PRESENTAR LA VENTA EN CONSOLA
    public void MostrarVenta(){
        System.out.println("==================================");
        System.out.println("==              VENTAS          ==");
        System.out.println("No. Factura: " + nofactura);
        System.out.println("Nit: " + nit);
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Total: "+ total);
    }
    
    //ENCAPSULAMIENTO
    /**
     * @return the nofactura
     */
    public int getNofactura() {
        return nofactura;
    }

    /**
     * @param nofactura the nofactura to set
     */
    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    /**
     * @return the nit
     */
    public int getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(int nit) {
        this.nit = nit;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
