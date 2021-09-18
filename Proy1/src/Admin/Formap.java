package Admin;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//DECIMAL FORMAT
import java.text.DecimalFormat;

//==================PAQUETES================
import proy1.Proy1;

public class Formap extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, ldescripcion, lcantidad, lprecio;
    JTextField tcod, tnombre, tdescripcion, tcantidad, tprecio;
    JButton actualizar, buscar;
    String codigo, nombre, descripcion,cantidad,precio;
    public Formap(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Actualizar Producto");
        titulo.setFont(new Font("Century Gothic", Font.PLAIN,25));
        titulo.setBounds(120,30,350,30);
        titulo.setVisible(true);
        titulo.setForeground(Color.WHITE);
        this.add(titulo);
        
        //LABEL DE CODIGO
        lcod = new JLabel("Código:");
        lcod.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lcod.setBounds(40,100,100,30);
        lcod.setVisible(true);
        lcod.setForeground(Color.WHITE);
        this.add(lcod);
        
        //TEXTFIELD PARA INGRESAR EL CODIGO
        tcod = new JTextField();
        tcod.setBounds(140,100,100,30);
        tcod.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tcod.setVisible(true);
        this.add(tcod);
        
        //BOTON DE BUSCAR
        buscar = new JButton("Buscar");
        buscar.setBounds(280,100,100,30);
        buscar.setFont(new Font("Century Gothic", Font.PLAIN,18));
        buscar.addActionListener(this);
        buscar.setVisible(true);
        this.add(buscar);
        
        //LABEL DE NOMBRE
        lnombre = new JLabel("Nombre:");
        lnombre.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lnombre.setBounds(40,180,100,30);
        lnombre.setVisible(true);
        lnombre.setForeground(Color.WHITE);
        this.add(lnombre);
        
        //TEXTFIELD PARA INGRESAR EL NOMBRE
        tnombre = new JTextField();
        tnombre.setBounds(140,180,280,30);
        tnombre.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tnombre.setVisible(true);
        tnombre.setEnabled(false);
        this.add(tnombre);
        
        //LABEL DE DESCRIPCION
        ldescripcion = new JLabel("Descripción:");
        ldescripcion.setFont(new Font("Century Gothic", Font.PLAIN,18));
        ldescripcion.setBounds(40,260,100,30);
        ldescripcion.setVisible(true);
        ldescripcion.setForeground(Color.WHITE);
        this.add(ldescripcion);
        
        //TEXTFIELD PARA INGRESAR LA DESCRIPCION
        tdescripcion = new JTextField();
        tdescripcion.setBounds(140,260,280,30);
        tdescripcion.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tdescripcion.setVisible(true);
        tdescripcion.setEnabled(false);
        this.add(tdescripcion);
        
        //LABEL DE CANTIDAD
        lcantidad = new JLabel("Cantidad:");
        lcantidad.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lcantidad.setBounds(40,340,100,30);
        lcantidad.setVisible(true);
        lcantidad.setForeground(Color.WHITE);
        this.add(lcantidad);
        
        //TEXTFIELD PARA INGRESAR LA CANTIDAD
        tcantidad = new JTextField();
        tcantidad.setBounds(140,340,280,30);
        tcantidad.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tcantidad.setVisible(true);
        tcantidad.setEnabled(false);
        this.add(tcantidad);
        
        //LABEL DE PRECIO
        lprecio = new JLabel("Precio:");
        lprecio.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lprecio.setBounds(40,420,100,30);
        lprecio.setVisible(true);
        lprecio.setForeground(Color.WHITE);
        this.add(lprecio);
        
        //TEXTFIELD PARA INGRESAR EL PRECIO
        tprecio = new JTextField();
        tprecio.setBounds(140,420,280,30);
        tprecio.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tprecio.setVisible(true);
        tprecio.setEnabled(false);
        this.add(tprecio);
        
        //BOTON DE ACTUALIZAR
        actualizar = new JButton("Actualizar");
        actualizar.setBounds(100,500,280,40);
        actualizar.setFont(new Font("Century Gothic", Font.PLAIN,15));
        actualizar.setBackground(Color.BLACK);
        actualizar.setForeground(Color.WHITE);
        actualizar.addActionListener(this);
        actualizar.setEnabled(false);
        this.add(actualizar);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Actualizar Producto | Blue Mall - POS");
        this.setBounds(450,100,500,600);
        this.getContentPane().setBackground(azul);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    //EVENTOS DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent ae) {
        //SE HACE LA LECTURA DE LOS JTEXTFIELD
        codigo = tcod.getText();
        nombre = tnombre.getText();
        descripcion = tdescripcion.getText();
        cantidad = tcantidad.getText();
        precio = tprecio.getText();
        boolean opcion = false;
        //BOTON BUSCAR
        DecimalFormat df = new DecimalFormat("#.00");
        if (ae.getSource()==buscar) {            
            for (int i = 0; i < Proy1.productos.length; i++) {
                //VALIDAR SI EXISTE EL PRODUCTO
                if (Proy1.productos[i] !=null && Proy1.productos[i].getCodigo()== Integer.parseInt(codigo)) {                
                    opcion = true;
                    tcod.setEnabled(false);
                    buscar.setEnabled(false);
                    tnombre.setEnabled(true);
                    tdescripcion.setEnabled(true);
                    tcantidad.setEnabled(true);
                    tprecio.setEnabled(true);
                    actualizar.setEnabled(true);
                    tnombre.setText(Proy1.productos[i].getNombre());
                    tdescripcion.setText(Proy1.productos[i].getDescripcion());
                    tcantidad.setText(String.valueOf(Proy1.productos[i].getCantidad()));
                    tprecio.setText(String.valueOf(df.format(Proy1.productos[i].getPrecio()))); 
                }
            }
            if (opcion == false) {
                JOptionPane.showMessageDialog(this, "No se encontró el Producto");
            }else{
                JOptionPane.showMessageDialog(this, "Se encontro el Producto");
            }
        }
        //BOTON ACTUALIZAR
        else if (ae.getSource()==actualizar) {
            //HACE LA OPERACIÓN DE ACTUALIZAR LOS DATOS DEL OBJETO
            for (int i = 0; i < Proy1.cproductos; i++) {
                if (Integer.parseInt(codigo) == Proy1.productos[i].getCodigo()) {
                    Proy1.productos[i].setNombre(nombre);
                    Proy1.productos[i].setCantidad(Integer.parseInt(cantidad));
                    Proy1.productos[i].setDescripcion(descripcion);
                    Proy1.productos[i].setPrecio(Float.parseFloat(precio));
                }
            }
            //SERIALIZA LA ACTUALIZACION DEL OBJETO
            Proy1.EscribirProductos(Proy1.productos);
            JOptionPane.showMessageDialog(this, "Se ha actualizado el Producto con éxito");
            this.dispose();
            Proy1.LeerProducto();
        }
    }
}
