package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Clases.Sucursales;
import javax.swing.*;
import proy1.Proy1;

public class Formes extends JFrame implements ActionListener{
    
    JLabel titulo, lcod, lnombre, ldireccion, lcorreo, ltelefono;
    JTextField tcod, tnombre, tdireccion, tcorreo, ttelefono;
    JButton eliminar, buscar;
    String codigo, nombre, direccion,correo,telefono;
    public Formes(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Eliminar Sucursal");
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
        
        //LABEL DE DIRECCION
        ldireccion = new JLabel("Dirección:");
        ldireccion.setFont(new Font("Century Gothic", Font.PLAIN,18));
        ldireccion.setBounds(40,260,100,30);
        ldireccion.setVisible(true);
        ldireccion.setForeground(Color.WHITE);
        this.add(ldireccion);
        
        //TEXTFIELD PARA INGRESAR LA DIRECCION
        tdireccion = new JTextField();
        tdireccion.setBounds(140,260,280,30);
        tdireccion.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tdireccion.setVisible(true);
        tdireccion.setEnabled(false);
        this.add(tdireccion);
        
        //LABEL DE CORREO
        lcorreo = new JLabel("Correo:");
        lcorreo.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lcorreo.setBounds(40,340,100,30);
        lcorreo.setVisible(true);
        lcorreo.setForeground(Color.WHITE);
        this.add(lcorreo);
        
        //TEXTFIELD PARA INGRESAR EL CORREO
        tcorreo = new JTextField();
        tcorreo.setBounds(140,340,280,30);
        tcorreo.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tcorreo.setVisible(true);
        tcorreo.setEnabled(false);
        this.add(tcorreo);
        
        //LABEL DE TELEFONO
        ltelefono = new JLabel("Telefono:");
        ltelefono.setFont(new Font("Century Gothic", Font.PLAIN,18));
        ltelefono.setBounds(40,420,100,30);
        ltelefono.setVisible(true);
        ltelefono.setForeground(Color.WHITE);
        this.add(ltelefono);
        
        //TEXTFIELD PARA INGRESAR EL TELEFONO
        ttelefono = new JTextField();
        ttelefono.setBounds(140,420,280,30);
        ttelefono.setFont(new Font("Century Gothic", Font.PLAIN,18));
        ttelefono.setVisible(true);
        ttelefono.setEnabled(false);
        this.add(ttelefono);
        
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
        this.setTitle("Eliminar Sucursal | Blue Mall - POS");
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
        direccion = tdireccion.getText();
        correo = tcorreo.getText();
        telefono = ttelefono.getText();
        boolean opcion = false;
        //BOTON BUSCAR
        if (ae.getSource()==buscar) {            
            for (int i = 0; i < Proy1.sucursales.length; i++) {
                //VALIDAR SI EXISTE LA SUCURSAL
                if (Proy1.sucursales[i] !=null && Proy1.sucursales[i].getCodigo()== Integer.parseInt(codigo)) {                
                    opcion = true;
                    eliminar.setEnabled(true);
                    tnombre.setText(Proy1.sucursales[i].getNombre());
                    tdireccion.setText(Proy1.sucursales[i].getDireccion());
                    tcorreo.setText(Proy1.sucursales[i].getCorreo());
                    ttelefono.setText(String.valueOf(Proy1.sucursales[i].getTelefono())); 
                }
            }
            if (opcion == false) {
                JOptionPane.showMessageDialog(this, "No se encontró la sucursal");
            }else{
                JOptionPane.showMessageDialog(this, "Se encontro la Sucursal");
            }
        }
        //BOTON ELIMINAR
        else if (ae.getSource()==eliminar) {
            //HACE LA OPERACIÓN DE ELIMINAR LOS DATOS DEL OBJETO
            //HACE QUE EL ESPACIO DONDE SE UBICA EL OBJETO SEA NULO
            for (int i = 0; i < Proy1.csucursales; i++) {
                if (Proy1.sucursales[i].getCodigo() == Integer.parseInt(codigo)) {
                    Proy1.sucursales[i] = null;                   
                }                
            }
            //HACE QUE DESDE EL ESPACIO NULO EN ADELANTE SE MUEVAN LAS CASILLAS HACIA ARRIBA
            for (int i = 0; i < Proy1.csucursales -1; i++) {
                if (Proy1.sucursales[i] == null) {
                    for (int j = i; j < Proy1.csucursales-1; j++) {
                        Proy1.sucursales[j] = Proy1.sucursales[j + 1];
                    } 
                }
            }
            Proy1.csucursales --;
            if (Proy1.csucursales == 0) {
                Proy1.sucursales[0] = null;
            }
            repaint();
            Proy1.LeerSucursales();
            JOptionPane.showMessageDialog(this, "Se ha eliminado la Sucursal con éxito");
            this.dispose();
        }
    }
}
