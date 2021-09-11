package Admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import proy1.Proy1;
public class Formep extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, ldescripcion, lcantidad, lprecio;
    JTextField tcod, tnombre, tdescripcion, tcantidad, tprecio;
    JButton eliminar, buscar;
    String codigo, nombre, descripcion,cantidad,precio;
    public Formep(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Eliminar Producto");
        titulo.setFont(new Font("Century Gothic", Font.PLAIN,25));
        titulo.setBounds(120,30,250,30);
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
        buscar = new JButton("Century Gothic");
        buscar.setBounds(280,100,100,30);
        buscar.setFont(new Font("Arial", Font.PLAIN,18));
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
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(100,500,280,40);
        eliminar.setFont(new Font("Century Gothic", Font.PLAIN,15));
        eliminar.setBackground(Color.BLACK);
        eliminar.setForeground(Color.WHITE);
        eliminar.addActionListener(this);
        eliminar.setEnabled(false);
        this.add(eliminar);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Eliminar Producto | Blue Mall - POS");
        this.setBounds(450,100,500,600);
        this.getContentPane().setBackground(azul);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    //PROGRAMACION DE BOTONES
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
        if (ae.getSource()==buscar) {            
            for (int i = 0; i < Proy1.productos.length; i++) {
                //VALIDAR SI EXISTE EL PRODUCTO
                if (Proy1.productos[i] !=null && Proy1.productos[i].getCodigo()== Integer.parseInt(codigo)) {                
                    opcion = true;
                    eliminar.setEnabled(true);
                    tnombre.setText(Proy1.productos[i].getNombre());
                    tdescripcion.setText(Proy1.productos[i].getDescripcion());
                    tcantidad.setText(String.valueOf(Proy1.productos[i].getCantidad()));
                    tprecio.setText(String.valueOf(Proy1.productos[i].getPrecio())); 
                }
            }
            if (opcion == false) {
                JOptionPane.showMessageDialog(this, "No se encontró el producto");
            }else{
                JOptionPane.showMessageDialog(this, "Se encontro el producto");
            }
        }
        //BOTON ELIMINAR
        else if (ae.getSource()==eliminar) {
            //HACE LA OPERACIÓN DE ELIMINAR LOS DATOS DEL OBJETO
            //HACE QUE EL ESPACIO DONDE SE UBICA EL OBJETO SEA NULO
            for (int i = 0; i < Proy1.cproductos; i++) {
                if (Proy1.productos[i].getCodigo() == Integer.parseInt(codigo)) {
                    Proy1.productos[i] = null;                   
                }                
            }
            //HACE QUE DESDE EL ESPACIO NULO EN ADELANTE SE MUEVAN LAS CASILLAS HACIA ARRIBA
            for (int i = 0; i < Proy1.cproductos -1; i++) {
                if (Proy1.productos[i] == null) {
                    for (int j = i; j < Proy1.cproductos-1; j++) {
                        Proy1.productos[j] = Proy1.productos[j + 1];
                    } 
                }
            }
            //CONTADOR PARA IR DESCONTANDO LA CANTIDAD DE OBJETOS EN EL VECTOR
            Proy1.cproductos --;
            //SI LA CANTIDAD DE PRODUCTOS ES IGUAL A 0 ENTONCES QUE TOME QUE LA POSICION VA A SER NUL
            if (Proy1.cproductos == 0) {
                Proy1.productos[0] = null;
            }
            //ACTUALIZAR EL VECTOR 
            repaint();
            Proy1.LeerSucursales();
            JOptionPane.showMessageDialog(this, "Se ha eliminado el Producto con éxito");
            this.dispose();
        }
    }
}
