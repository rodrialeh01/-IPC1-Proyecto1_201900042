package Admin;
import Clases.Productos;
import proy1.Proy1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Formcp extends JFrame implements ActionListener{
    
    JLabel titulo, lcod, lnombre, ldescripcion, lcantidad, lprecio;
    JTextField tcod, tnombre, tdescripcion, tcantidad, tprecio;
    JButton agregar;
    String codigo, nombre, descripcion,cantidad,precio;
    public Formcp(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Crear nuevo Producto");
        titulo.setFont(new Font("Arial", Font.PLAIN,25));
        titulo.setBounds(120,30,250,30);
        titulo.setVisible(true);
        titulo.setForeground(Color.WHITE);
        this.add(titulo);
        
        //LABEL DE CODIGO
        lcod = new JLabel("Código:");
        lcod.setFont(new Font("Arial", Font.PLAIN,18));
        lcod.setBounds(40,100,100,30);
        lcod.setVisible(true);
        lcod.setForeground(Color.WHITE);
        this.add(lcod);
        
        //TEXTFIELD PARA INGRESAR EL CODIGO
        tcod = new JTextField();
        tcod.setBounds(140,100,280,30);
        tcod.setFont(new Font("Arial", Font.PLAIN,18));
        tcod.setVisible(true);
        this.add(tcod);
        
        //LABEL DE NOMBRE
        lnombre = new JLabel("Nombre:");
        lnombre.setFont(new Font("Arial", Font.PLAIN,18));
        lnombre.setBounds(40,180,100,30);
        lnombre.setVisible(true);
        lnombre.setForeground(Color.WHITE);
        this.add(lnombre);
        
        //TEXTFIELD PARA INGRESAR EL NOMBRE
        tnombre = new JTextField();
        tnombre.setBounds(140,180,280,30);
        tnombre.setFont(new Font("Arial", Font.PLAIN,18));
        tnombre.setVisible(true);
        this.add(tnombre);
        
        //LABEL DE DESCRIPCION
        ldescripcion = new JLabel("Descripción:");
        ldescripcion.setFont(new Font("Arial", Font.PLAIN,18));
        ldescripcion.setBounds(40,260,100,30);
        ldescripcion.setVisible(true);
        ldescripcion.setForeground(Color.WHITE);
        this.add(ldescripcion);
        
        //TEXTFIELD PARA INGRESAR LA DESCRIPCION
        tdescripcion = new JTextField();
        tdescripcion.setBounds(140,260,280,30);
        tdescripcion.setFont(new Font("Arial", Font.PLAIN,18));
        tdescripcion.setVisible(true);
        this.add(tdescripcion);
        
        //LABEL DE CANTIDAD
        lcantidad = new JLabel("Cantidad:");
        lcantidad.setFont(new Font("Arial", Font.PLAIN,18));
        lcantidad.setBounds(40,340,100,30);
        lcantidad.setVisible(true);
        lcantidad.setForeground(Color.WHITE);
        this.add(lcantidad);
        
        //TEXTFIELD PARA INGRESAR LA CANTIDAD
        tcantidad = new JTextField();
        tcantidad.setBounds(140,340,280,30);
        tcantidad.setFont(new Font("Arial", Font.PLAIN,18));
        tcantidad.setVisible(true);
        this.add(tcantidad);
        
        //LABEL DE PRECIO
        lprecio = new JLabel("Precio:");
        lprecio.setFont(new Font("Arial", Font.PLAIN,18));
        lprecio.setBounds(40,420,100,30);
        lprecio.setVisible(true);
        lprecio.setForeground(Color.WHITE);
        this.add(lprecio);
        
        //TEXTFIELD PARA INGRESAR EL PRECIO
        tprecio = new JTextField();
        tprecio.setBounds(140,420,280,30);
        tprecio.setFont(new Font("Arial", Font.PLAIN,18));
        tprecio.setVisible(true);
        this.add(tprecio);
        
        //BOTON DE AGREGAR
        agregar = new JButton("Agregar");
        agregar.setBounds(100,500,280,40);
        agregar.setFont(new Font("Arial", Font.PLAIN,15));
        agregar.setBackground(Color.BLACK);
        agregar.setForeground(Color.WHITE);
        agregar.addActionListener(this);
        this.add(agregar);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Crear Producto | Blue Mall - POS");
        this.setBounds(450,100,500,600);
        this.getContentPane().setBackground(azul);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    //PROGRAMA LAS ACCIONES DEL BOTON
    @Override
    public void actionPerformed(ActionEvent ae) {
        // BOTON AGREGAR
        if (ae.getSource()==agregar){
            codigo = tcod.getText();
            nombre = tnombre.getText();
            descripcion = tdescripcion.getText();
            cantidad = tcantidad.getText();
            precio = tprecio.getText();
            if (codigo.equals("") || nombre.equals("") || descripcion.equals("") || cantidad.equals("") || precio.equals("")) {
                JOptionPane.showMessageDialog(this, "Llene todos los espacios");
            }else{                
                Productos nuevo = new Productos(Integer.parseInt(codigo),nombre,descripcion,Integer.parseInt(cantidad),Double.parseDouble(precio));
                Proy1.AgregarProducto(nuevo);
                JOptionPane.showMessageDialog(this, "Se agregó correctamente el nuevo Producto");
                this.dispose();
            }
        }
    }
    
}
