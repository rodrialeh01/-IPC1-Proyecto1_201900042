package Clases;

public class Vendedores {

    private int codigo;
    private String nombre;
    private int caja;
    private int ventas;
    private String genero;
    private String password;
    private Ventas[] ventasv;
    private int cventas;
    
    //CONSTRUCTOR
    public Vendedores(int codigo, String nombre, int caja, int ventas, String genero, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.password = password;
        this.cventas = 0;
        this.ventasv = new Ventas[1000];        
    }
    
    //METODO PARA MOSTRAR LA LISTA DE VENDEDORES
    public void MostrarVendedores(){
        System.out.println("==================================");
        System.out.println("==            VENDEDOR          ==");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Caja: " + caja);
        System.out.println("Ventas: " + ventas);
        System.out.println("Genero: " + genero);
        System.out.println("Contraseña: " + password);
    }
    
    //MOSTRAR LAS VENTAS ASIGNADAS AL VENDEDOR
    public void MostrarInfoV(){
        System.out.println("==================================");
        System.out.println("==            VENDEDOR          ==");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Caja: " + caja);
        System.out.println("Ventas: " + ventas);
        System.out.println("Genero: " + genero);
        System.out.println("Contraseña: " + password);
        System.out.println("Tengo estas ventas: ");
        System.out.println("==================================");
        System.out.println("==  VENTAS DE " + nombre + "  ==");
        for (int i = 0; i < cventas; i++) {
            System.out.println("No. Factura: " + ventasv[i].getNofactura());
            System.out.println("Nombre del Cliente: " + ventasv[i].getNombre());
            System.out.println("Fecha: " + ventasv[i].getFecha());
            System.out.println("NIT: " + ventasv[i].getNit());
            System.out.println("Total: " + ventasv[i].getTotal());
            System.out.println("");
            System.out.println("------------------------------");
        }
    }
    
    //FUNCION PARA ASIGNARLE LA VENTA AL VENDEDOR
    public void AsignarVenta(Ventas venta){
        if (cventas < ventasv.length) {
            ventasv[cventas] = venta;
            cventas++;
        }else{
            System.out.println("YA MUCHO xd");
        }
        
    }
    
    //FUNCION PARA RETORNAR LA MATRIZ DE VENTAS DE LOS VENDEDORES
    public Ventas[] ventasvendedor(int codigo){
        try{
        if (ventasv != null) {
            return ventasv;
        }
        }catch(Exception e){
            
        }
        return null;  
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
     * @return the caja
     */
    public int getCaja() {
        return caja;
    }

    /**
     * @param caja the caja to set
     */
    public void setCaja(int caja) {
        this.caja = caja;
    }

    /**
     * @return the ventas
     */
    public int getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the genero to set
     */
    public void setPassword(String genero) {
        this.password = password;
    }
    /**
     * @return the password
     */
    public int getCventas() {
        return cventas;
    }
}
