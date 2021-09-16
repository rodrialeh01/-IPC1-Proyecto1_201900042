package proy1;
//PAQUETES
import Clases.*;
import Admin.*;
import Login.Login;
//LIBRERIA AWT-SWING
import java.awt.Color;
import javax.swing.*;
//DECIMAL FORMAT
import java.text.DecimalFormat;


public class Proy1 {
    static Color azulitofacha = new Color(13,67,162);
    //METODO PARA LLAMAR A LA VENTANA
    public static void main(String[] args) {
        Login l = new Login();
    }
    /**
     * ================================SUCURSALES================================
     */
    
    //SE CREA UN ARREGLO DE SUCURSALES CON UNA CAPACIDAD DE 50 SUCURSALES
    public static Sucursales[] sucursales = new Sucursales[50];
    //SE CREA EL CONTADOR DE SUCURSALES EN EL SISTEMA
    public static int csucursales = 0;
    
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
        System.out.println("=====================================");
        System.out.println("==      LISTADO DE SUCURSALES      ==");
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
    
    /**
     * ================================PRODUCTOS================================
     */
    
    //SE CREA UN ARREGLO DE PRODUCTOS CON UNA CAPACIDAD DE 200 PRODUCTOS
    public static Productos[] productos = new Productos[200];
    //SE CREA UN CONTADOR DE PRODUCTOS EN EL SISTEMA
    public static int cproductos = 0;
    //SE CREA UN CONTADOR DE GENERO FEMENINO PARA LAS GRAFICAS
    public static int contadorf = 0;
    //SE CREA UN CONTADOR DE GENERO MASCULINO PARA LAS GRAFICAS
    public static int contadorm = 0;
    
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
        ordenamientoProductosT(productos);
    }
    
    //METODO PARA MOSTRAR LOS PRODUCTOS
    public static void LeerProducto(){
        System.out.println("=====================================");
        System.out.println("==       LISTADO DE PRODUCTOS      ==");
        for (int i = 0; i < cproductos; i++) {
            productos[i].MostrarProductos();
        }
        if (productos == null) {
            System.out.println("NO HAY PRODUCTOS");
        }
    }
    
    //ARMA UNA MATRIZ DE OBJETOS DE LOS PRODUCTOS PARA MOSTRARLO EN TABLA
    public static Object[][] convertirDProductos(){
        DecimalFormat df = new DecimalFormat("#.00");
        Object[][] contentp = new Object[Proy1.cproductos][5];
        for (int i = 0; i < Proy1.cproductos; i++) {
            contentp[i][0] = Proy1.productos[i].getCodigo();
            contentp[i][1] = Proy1.productos[i].getNombre();
            contentp[i][2] = Proy1.productos[i].getDescripcion();
            contentp[i][3] = Proy1.productos[i].getCantidad();
            contentp[i][4] = df.format(Proy1.productos[i].getPrecio());
        }
        return contentp;
    }
    
    //SE ORDENARAN LOS OBJETOS DE MAYOR CANTIDAD HASTA MENOR CANTIDAD USANDO UN ALGORITMO DE ORDENAMIENTO
    public static void ordenamientoProductos(Productos[] prod){
        try{
            for (int i = 1; i < prod.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (prod[i].getCantidad() > prod[j].getCantidad()) {
                        Productos aux = prod[i];
                        prod[i] = prod[j];
                        prod[j] = aux;
                        i--;
                    }
                }
            }
        }catch(Exception e){            
        }
    }
    //SE ORDENARAN LOS OBJETOS DE MAYOR A MENOR POR MEDIO DEL CODIGO DEL PRODUCTO
    public static void ordenamientoProductosT(Productos[] prod){
        try{
            for (int i = 1; i < prod.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (prod[i].getCodigo() < prod[j].getCodigo()) {
                        Productos aux = prod[i];
                        prod[i] = prod[j];
                        prod[j] = aux;
                        i++;
                    }
                }
            }
        }catch(Exception e){            
        }
    }
    
    //FUNCION PARA RETORNAR EL OBJETO PRODUCTO POR MEDIO DEL CODIGO
    public static Productos ObtenerProducto(int codigo) {
        for (int i = 0; i < cproductos; i++) {
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                return productos[i];
            }
        }
        return null;
    }
    
    /**
     * ================================COMPRAS=================================
     */
    
    /**SE CREO UN ARREGLO DE COMPRAS QUE SERA UTILIZADO COMO UN CARRITO PARA LA VENTA DE PRODUCTOS
     * DONDE SE CREO UN ESPACIO DE 1000 OBJETOS DE FORMA TEMPORAL PARA QUE NO TENGA UN LIMITE EN LA 
     * COMPRA DE PRODUCTOS AL AGREGARLO AL CARRITO.
     */
    public static Compras[] compras = new Compras[1000];
    //CONTADOR DE COMPRAS EN EL SISTEMA
    public static int ccompras = 0;
    
    //METODO PARA AGREGAR UN NUEVO OBJETO AL ARREGLO DE COMPRAS
    public static void AgregarCompra(Compras compra){
        if (ccompras <compras.length) {
            compras[ccompras]= compra;
            ccompras++;
        }
    }
    
    //MOSTRAR EN PANTALLA LA TABLA DE QUE AGREGA PRODUCTOS
    public static Object[][] TableCompras(){
        DecimalFormat df = new DecimalFormat("#.00");
        Object[][] agregarp = new Object[ccompras][5];
        for (int i = 0; i < Proy1.ccompras; i++) {
            agregarp[i][0] = Proy1.compras[i].getCodigo();
            agregarp[i][1] = Proy1.compras[i].getNombre();
            agregarp[i][2] = Proy1.compras[i].getCantidad();
            agregarp[i][3] = df.format(Proy1.compras[i].getPrecio());
            agregarp[i][4] = df.format(Proy1.compras[i].getSubtotal());
        }
        return agregarp;
    }
    
    //SUMA DE LOS SUBTOTALES PARA EL TOTAL
    public static double totals(){
        double comprat = 0;
        if (compras != null) {
            for (int i = 0; i < ccompras; i++) {
                comprat += compras[i].getSubtotal();
            }
        }        
        return comprat;
    }
    
    /**
     * ================================CLIENTES================================
     */
    
    //SE CREA EL ARREGLO DE CLIENTES CON UNA CAPACIDAD MÁXIMA DE 100 CLIENTES
    public static Clientes[] clientes = new Clientes[100];
    //SE CREA EL CONTADOR DE CLIENTES EN EL SISTEMA
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
        System.out.println("=====================================");
        System.out.println("==       LISTADO DE CLIENTES       ==");
        for (int i = 0; i < cclientes; i++) {
            clientes[i].MostrarClientes();
        }
        if (clientes == null) {
            System.out.println("NO HAY CLIENTES");
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
    
    //METODO PARA CONTAR EL GENERO M
    public static int ContadorCM(){        
        for (int i = 0; i < cclientes; i++) {
            if (clientes[i].getGenero().equals("M")) {
                contadorm++;
            }
        }
        return contadorm;
    }
    
    //METODO PARA CONTAR EL GENERO F
    public static int ContadorCF(){        
        for (int i = 0; i < cclientes; i++) {
            if (clientes[i].getGenero().equals("F")) {
                contadorf++;
            }
        }
        return contadorf;
    }
    
    //FUNCION PARA RETORNAR LOS NOMBRES DE LOS CLIENTES BUSCADO POR MEDIO DEL NOMBRE
    public static String[] NombresCN(String nombre){
        String[] nombres = new String[cclientes];
        for (int i = 0; i < cclientes; i++) {
            if (clientes[i] != null && clientes[i].getNombre().equals(nombre)) {
                nombres[i] = clientes[i].getNombre();
            }       
        }
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] != null) {
                return nombres;
            }
        }        
        return null;
    }
    
    //FUNCION PARA RETORNAR EL NOMBRE DEL CLIENTE POR MEDIO DEL NIT
    public static String[] NombresCNIT(int nit){
        String[] nombres = new String[cclientes];
        for (int i = 0; i<cclientes; i++) {
            if (clientes[i]!=null && clientes[i].getNit()==nit) {
                nombres[i] = clientes[i].getNombre();
            }
        }
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] != null) {
                return nombres;
            }
        }        
        return null;
    }
    
    //FUNCION PARA RETORNAR EL NOMBRE DEL CLIENTE POR MEDIO DEL CORREO
    public static String[] NombresCC(String correo){
        String[] nombres = new String[cclientes];
        for (int i = 0; i < cclientes; i++) {
            if (clientes[i] !=null && clientes[i].getCorreo().equals(correo)) {
                nombres[i] = clientes[i].getNombre();
            }            
        }
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] != null) {
                return nombres;
            }
        }        
        return null;
    }
    
    //FUNCION PARA RETORNAR LOS NOMBRES DE LOS CLIENTES POR MEDIO DEL GENERO
    public static String[] NombresCG(String genero){
        String[] nombres = new String[cclientes];
        if (genero.equals("M") || genero.equals("F")) {
            for (int i = 0; i < cclientes; i++) {
                if (clientes[i] != null && clientes[i].getGenero().equals(genero)) {
                    nombres[i] = clientes[i].getNombre();
                }
            }
        }else{
            return null;
        }   
        return nombres;
    }
    
    //SE OBTIENE CUAL ES EL CODIGO MAS GRANDE DE TODO EL LISTADO DE CLIENTES
    public static int CodigoMayor(Clientes[] client){
        int mayor = clientes[0].getCodigo();
        try {
            for (int i = 1; i < clientes.length; i++) {
                if (clientes[i].getCodigo() > mayor) {
                    mayor = clientes[i].getCodigo();
                }
            }
        } catch (Exception e) {

        }
        return mayor;
    }
    
    //FUNCION PARA RETORNAR EL OBJETO CLIENTE
    public static Clientes DevolverCliente(String nombre){
        for (int i = 0; i < cclientes; i++) {
            if (clientes[i].getNombre().equals(nombre)) {
                return clientes[i];
            }
        }
        return null;
    }
    
    /**
     * ================================VENDEDORES================================
     */
    
    //SE CREA EL ARREGLO DE VENDEDORES CON UN MÁXIMO DE 400 VENDEDORES
    public static Vendedores[] vendedores = new Vendedores[400];
    //SE CREA EL CONTADOR DE VENDEDORES EN EL SISTEMA
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
        System.out.println("=====================================");
        System.out.println("==      LISTADO DE VENDEDORES      ==");
        for (int i = 0; i < cvendedores; i++) {
            vendedores[i].MostrarVendedores();
        }
        if (vendedores == null) {
            System.out.println("NO HAY VENDEDORES");
        }
    }
    
    //ARMA UNA MATRIZ DE OBJETOS DE LOS VENDEDORES PARA MOSTRARLO EN TABLA
    public static Object[][] convertirDVendedores(){
        Object[][] contentv = new Object[Proy1.cvendedores][6];
        for (int i = 0; i < Proy1.cvendedores; i++) {
            contentv[i][0] = Proy1.vendedores[i].getCodigo();
            contentv[i][1] = Proy1.vendedores[i].getNombre();
            contentv[i][2] = Proy1.vendedores[i].getCaja();
            contentv[i][3] = Proy1.vendedores[i].getVentas();
            contentv[i][4] = Proy1.vendedores[i].getGenero();
            contentv[i][5] = Proy1.vendedores[i].getPassword();
        }
        return contentv;
    }
    
    //SE ORDENARAN LOS OBJETOS DE MAYOR CANTIDAD DE VENTAS HASTA MENOR CANTIDAD DE VENTAS USANDO UN ALGORITMO DE ORDENAMIENTO
    public static void ordenamientoVendedores(Vendedores[] ventas){
        try{
            for (int i = 1; i < ventas.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (ventas[i].getVentas() > ventas[j].getVentas()) {
                        Vendedores aux = ventas[i];
                        ventas[i] = ventas[j];
                        ventas[j] = aux;
                        i--;
                    }
                }
            }
        }catch(Exception e){            
        }
    }
    
    //LOGIN DE LOS VENDEDORES
    
    //VERIFICA SI EXISTE EL VENDEDOR
    public static boolean verificar(int codv) {
        for (int i = 0; i<vendedores.length; i++) {
            if (vendedores[i]!=null && vendedores[i].getCodigo()==codv) {
                return true;
            }
        }
        return false;
    }
    
    //VERIFICA USUARIO Y CONTRASEÑA ES CORRETA
    public static boolean verificarUPV(int codv,String pv) {
        for (int i = 0; i<vendedores.length; i++) {
            if (vendedores[i]!=null && vendedores[i].getPassword().equals(pv) && vendedores[i].getCodigo()==codv) {
                return true;
            }
        }
        return false;
    }
    
    //FUNCION PARA QUE RETORNE EL NOMBRE DEL VENDEDOR QUE QUIERE LOGUEAR
    public static String nombrev(int codv){
        for (int i = 0; i<cvendedores; i++) {
            if (vendedores[i]!=null && vendedores[i].getCodigo()==codv) {
                return vendedores[i].getNombre();
            }
        }
        return null;
    }
    
    //FUNCION PARA QUE RETORNE EL GENERO DEL VENDEDOR QUE QUIERE LOGUEAR
    public static String generov(int codv){
        for (int i = 0; i<cvendedores; i++) {
            if (vendedores[i]!=null && vendedores[i].getCodigo()==codv) {
                return vendedores[i].getGenero();
            }
        }
        return null;
    }
    
    //FUNCIÓN PARA DEVOLVER EL OBJETO VENDEDORES
    public static Vendedores objvend(int codv){
        for (int i = 0; i<cvendedores; i++) {
            if (vendedores[i]!=null && vendedores[i].getCodigo()==codv) {
                return vendedores[i];
            }
        }
        return null;
    }
    
    
    /**
     * ================================VENTAS================================
     */
    //SE CREA EL ARREGLO DE VENTAS QUE TIENE UNA CAPACIDAD DE REALIZAR 1000 VENTAS
    public static Ventas[] ventas = new Ventas[1000];
    //SE CREA EL CONTADOR DE VENTAS
    public static int cventas = 0;
    
    //METODO PARA AÑADIR UN OBJETO VENTAS AL ARREGLO
    public static void AgregarVenta(Ventas venta){
        if (cventas < ventas.length) {
            ventas[cventas] = venta;
        }
    }
    
    //METODO PARA VISUALIZAR LAS VENTAS EN EL SISTEMA
    public static void LeerVenta(){
        for (int i = 0; i < cventas; i++) {
            if (ventas[i] != null) {
                ventas[i].MostrarVenta();
            }
        }
        if (ventas == null) {
            System.out.println("NO HAY VENTAS");
        }
    }
    
    //FUNCION QUE RETORNA EL OBJETO VENTA 
    public static Ventas DevolverVenta(int codf){
        for (int i = 0; i < cventas; i++) {
            if (ventas[i].getNofactura() == codf) {
                return ventas[i];
            }
        }
        return null;
    }
    
    public static int posicion(int codigo){
        int posicion = -1;
        for (int i = 0; i < cvendedores; i++) {
            if (vendedores[i].getCodigo() == codigo) {
                posicion = i;
            }
        }
        return posicion;
    }
    
    //FUNCION PARA CREAR LA TABLA DE VENTAS DE LOS VENDEDORES
    public static Object[][] TablaVentas(int codigo){
        int filas = vendedores[posicion(codigo)].getCventas();
        Object[][] matriz = new Object[filas][6];
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][0] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura();
            matriz[i][1] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNit();
            matriz[i][2] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNombre();
            matriz[i][3] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getFecha();
            matriz[i][4] = df.format(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getTotal());
            JLabel nuevo = new JLabel("Visualizar");
            nuevo.setForeground(azulitofacha);
            nuevo.setName(String.valueOf(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura()));
            matriz[i][5] = nuevo;
        }
        return matriz; 
    }
    
    //FUNCION PARA RETORNAR LA TABLA SOLO CON LOS NOMBRES SELECCIONADOS
    public static Object[][] TablaNombres(int codigo, String name){
        int filas = vendedores[posicion(codigo)].getCventas();
        Object[][] filtron = new Object[filas][6];
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < filas; i++) {
            if (vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNombre().equals(name)){
                filtron[i][0] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura();
                filtron[i][1] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNit();
                filtron[i][2] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNombre();
                filtron[i][3] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getFecha();
                filtron[i][4] = df.format(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getTotal());
                JLabel nuevo = new JLabel("Visualizar");
                nuevo.setForeground(azulitofacha);
                nuevo.setName(String.valueOf(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura()));
                filtron[i][5] = nuevo;
            }
        }
        return filtron;
    }
    
    //FUNCION PARA RETORNAR LA TABLA SOLO CON LOS NO. DE FACTURA SELECCIONADOS
    public static Object[][] TablaNoFacturas(int codigo, int factura){
        int filas = vendedores[posicion(codigo)].getCventas();
        Object[][] filtronf = new Object[filas][6];
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < filas; i++) {
            if (vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura() == factura){
                filtronf[i][0] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura();
                filtronf[i][1] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNit();
                filtronf[i][2] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNombre();
                filtronf[i][3] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getFecha();
                filtronf[i][4] = df.format(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getTotal());
                JLabel nuevo = new JLabel("Visualizar");
                nuevo.setForeground(azulitofacha);
                nuevo.setName(String.valueOf(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura()));
                filtronf[i][5] = nuevo;
            }
        }
        return filtronf;
    }
    
    //FUNCION PARA RETORNAR LA TABLA SOLO CON LOS NIT SELECCIONADOS
    public static Object[][] TablaNit(int codigo, int nit){
        int filas = vendedores[posicion(codigo)].getCventas();
        Object[][] filtroni = new Object[filas][6];
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < filas; i++) {
            if (vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNit() == nit){
                filtroni[i][0] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura();
                filtroni[i][1] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNit();
                filtroni[i][2] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNombre();
                filtroni[i][3] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getFecha();
                filtroni[i][4] = df.format(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getTotal());
                JLabel nuevo = new JLabel("Visualizar");
                nuevo.setForeground(azulitofacha);
                nuevo.setName(String.valueOf(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura()));
                filtroni[i][5] = nuevo;
            }
        }
        return filtroni;
    }
    
    //FUNCION PARA RETORNAR LA TABLA SOLO CON LAS FECHAS SELECCIONADAS
    public static Object[][] TablaFecha(int codigo, String fecha){
        int filas = vendedores[posicion(codigo)].getCventas();
        Object[][] filtrof = new Object[filas][6];
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < filas; i++) {
            if (vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getFecha().equals(fecha)){
                filtrof[i][0] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura();
                filtrof[i][1] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNit();
                filtrof[i][2] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNombre();
                filtrof[i][3] = vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getFecha();
                filtrof[i][4] = df.format(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getTotal());
                JLabel nuevo = new JLabel("Visualizar");
                nuevo.setForeground(azulitofacha);
                nuevo.setName(String.valueOf(vendedores[posicion(codigo)].ventasvendedor(codigo)[i].getNofactura()));
                filtrof[i][5] = nuevo;
            }
        }
        return filtrof;
    }
}
