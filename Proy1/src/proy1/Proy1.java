package proy1;
import Clases.*;
import Admin.*;
import Login.Login;
import javax.swing.*;
public class Proy1 {
    public static Sucursales[] sucursales = new Sucursales[5];
    public static int csucursales = 0;
    //METODO PARA LLAMAR A LA VENTANA
    public static void main(String[] args) {
        Login l = new Login();
//        Formas f = new Formas();
    }
    /**
     * ================================SUCURSALES================================
     * @param sucursal 
     */
    //METODO PARA AÑADIR UN NUEVO OBJETO SUCURSALES
    public static void AgregarSucursales(Sucursales sucursal){
        if (csucursales < sucursales.length) {
            sucursales[csucursales] = sucursal;
            csucursales++;
        }else{
            System.out.println("LLEGÓ A LA CANTIDAD MAXIMA DE SUCURSALES");
            ASucursales as = new ASucursales();
            JOptionPane.showMessageDialog(as, "LLEGÓ A LA CANTIDAD MAXIMA DE SUCURSALES");
        }
    }
    
    //METODO PARA MOSTRAR LOS SUCURSALES
    public static void LeerSucursales(){
        for (int i = 0; i < csucursales; i++) {
            if (sucursales[i] !=null) {
                sucursales[i].MostrarSucursales();
            }            
        }
        if (sucursales == null) {
            System.out.println("NO HAY SUCURSALES");
        }
    }
    
    //ARMA UNA MATRIZ DE OBJETOS DE LAS SUCURSALES PARA MOSTRARLO EN TABLA
    public static Object[][] convertirDSucursales() {
        Object[][] content = new Object[Proy1.csucursales][5];
        for (int i = 0; i < Proy1.csucursales; i++) {
            if (sucursales[i] != null) {
                content[i][0] = Proy1.sucursales[i].getCodigo();
                content[i][1] = Proy1.sucursales[i].getNombre();
                content[i][2] = Proy1.sucursales[i].getDireccion();
                content[i][3] = Proy1.sucursales[i].getCorreo();
                content[i][4] = Proy1.sucursales[i].getTelefono();
            }
        }
        return content;
    }
    
    public static Productos[] productos = new Productos[200];
    public static int cproductos = 0;
    
    //METODO PARA AÑADIR UN PRODUCTO
    public static void AgregarProducto(Productos producto){
        if (cproductos < productos.length) {
            productos[cproductos] = producto;
            cproductos++;
        }else{
            AProductos ap = new AProductos();
            JOptionPane.showMessageDialog(ap, "LLEGÓ A LA CANTIDAD MAXIMA DE PRODUCTOS");
            System.out.println("LLEGÓ A LA CANTIDAD MAXIMA DE PRODUCTOS");
        }
    }
    /**
     * ================================PRODUCTOS================================
     */
    //METODO PARA MOSTRAR LOS PRODUCTOS
    public static void LeerProducto(){
        for (int i = 0; i < cproductos; i++) {
            productos[i].MostrarProductos();
        }
    }
    
    //ARMA UNA MATRIZ DE OBJETOS DE LOS PRODUCTOS PARA MOSTRARLO EN TABLA
    public static Object[][] convertirDProductos(){
        Object[][] contentp = new Object[Proy1.cproductos][5];
        for (int i = 0; i < Proy1.cproductos; i++) {
            contentp[i][0] = Proy1.productos[i].getCodigo();
            contentp[i][1] = Proy1.productos[i].getNombre();
            contentp[i][2] = Proy1.productos[i].getDescripcion();
            contentp[i][3] = Proy1.productos[i].getCantidad();
            contentp[i][4] = Proy1.productos[i].getPrecio();
        }
        return contentp;
    }
    
    /**
     * ================================CLIENTES================================
     */
    
    public static Clientes[] clientes = new Clientes[100];
    public static int cclientes = 0;
    
    //METODO PARA AÑADIR UN CLIENTE
    public static void AgregarCliente(Clientes cliente){
        if (cclientes < clientes.length) {
            clientes[cclientes] = cliente;
            cclientes++;
        }else{
            AClientes ac = new AClientes();
            JOptionPane.showMessageDialog(ac, "LLEGÓ A LA CANTIDAD MAXIMA DE CLIENTES");
            System.out.println("LLEGÓ A LA CANTIDAD MAXIMA DE CLIENTES");
        }
    }
    
    //METODO PARA MOSTRAR LOS CLIENTES
    public static void LeerCliente(){
        for (int i = 0; i < cclientes; i++) {
            clientes[i].MostrarClientes();
        }
    }
    
    //ARMA UNA MATRIZ DE OBJETOS DE LOS CLIENTES PARA MOSTRARLO EN TABLA
    public static Object[][] convertirDClientes(){
        Object[][] contentc = new Object[Proy1.cclientes][5];
        for (int i = 0; i < Proy1.cclientes; i++) {
            contentc[i][0] = Proy1.clientes[i].getCodigo();
            contentc[i][1] = Proy1.clientes[i].getNombre();
            contentc[i][2] = Proy1.clientes[i].getNit();
            contentc[i][3] = Proy1.clientes[i].getCorreo();
            contentc[i][4] = Proy1.clientes[i].getGenero();
        }
        return contentc;
    }
    
    /**
     * ================================VENDEDORES================================
     */
    
    public static Vendedores[] vendedores = new Vendedores[400];
    public static int cvendedores = 0;
    
    //METODO PARA AÑADIR UN VENDEDOR
    public static void AgregarVendedor(Vendedores vendedor){
        if (cvendedores < vendedores.length) {
            vendedores[cvendedores] = vendedor;
            cvendedores++;
        }else{
            AVendedores av = new AVendedores();
            JOptionPane.showMessageDialog(av, "LLEGÓ A LA CANTIDAD MAXIMA DE VENDEDORES");
            System.out.println("LLEGÓ A LA CANTIDAD MAXIMA DE VENDEDORES");
        }
    }
    
    //METODO PARA MOSTRAR LOS VENDEDORES
    public static void LeerVendedor(){
        for (int i = 0; i < cvendedores; i++) {
            vendedores[i].MostrarVendedores();
        }
    }
    
    //ARMA UNA MATRIZ DE OBJETOS DE LOS VENDEDORES PARA MOSTRARLO EN TABLA
    public static Object[][] convertirDVendedores(){
        Object[][] contentv = new Object[Proy1.cvendedores][5];
        for (int i = 0; i < Proy1.cvendedores; i++) {
            contentv[i][0] = Proy1.vendedores[i].getCodigo();
            contentv[i][1] = Proy1.vendedores[i].getNombre();
            contentv[i][2] = Proy1.vendedores[i].getCaja();
            contentv[i][3] = Proy1.vendedores[i].getVentas();
            contentv[i][4] = Proy1.vendedores[i].getGenero();
        }
        return contentv;
    }
}
