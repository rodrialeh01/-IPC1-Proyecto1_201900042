package Admin;
import Clases.Clientes;
import proy1.Proy1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Formcc extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, lnit, lcorreo, lgenero;
    JTextField tcod, tnombre, tnit, tcorreo, tgenero;
    JButton agregar;
    String codigo, nombre, nit,correo,genero;
    public Formcc(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Crear nuevo Cliente");
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
        lnit = new JLabel("NIT:");
        lnit.setFont(new Font("Arial", Font.PLAIN,18));
        lnit.setBounds(40,260,100,30);
        lnit.setVisible(true);
        lnit.setForeground(Color.WHITE);
        this.add(lnit);
        
        //TEXTFIELD PARA INGRESAR LA DESCRIPCION
        tnit = new JTextField();
        tnit.setBounds(140,260,280,30);
        tnit.setFont(new Font("Arial", Font.PLAIN,18));
        tnit.setVisible(true);
        this.add(tnit);
        
        //LABEL DE CANTIDAD
        lcorreo = new JLabel("Correo:");
        lcorreo.setFont(new Font("Arial", Font.PLAIN,18));
        lcorreo.setBounds(40,340,100,30);
        lcorreo.setVisible(true);
        lcorreo.setForeground(Color.WHITE);
        this.add(lcorreo);
        
        //TEXTFIELD PARA INGRESAR LA CANTIDAD
        tcorreo = new JTextField();
        tcorreo.setBounds(140,340,280,30);
        tcorreo.setFont(new Font("Arial", Font.PLAIN,18));
        tcorreo.setVisible(true);
        this.add(tcorreo);
        
        //LABEL DE PRECIO
        lgenero = new JLabel("Genero:");
        lgenero.setFont(new Font("Arial", Font.PLAIN,18));
        lgenero.setBounds(40,420,100,30);
        lgenero.setVisible(true);
        lgenero.setForeground(Color.WHITE);
        this.add(lgenero);
        
        //TEXTFIELD PARA INGRESAR EL PRECIO
        tgenero = new JTextField();
        tgenero.setBounds(140,420,280,30);
        tgenero.setFont(new Font("Arial", Font.PLAIN,18));
        tgenero.setVisible(true);
        this.add(tgenero);
        
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
        this.setTitle("Crear Cliente | Blue Mall - POS");
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
            nit = tnit.getText();
            correo = tcorreo.getText();
            genero = tgenero.getText();
            if (codigo.equals("") || nombre.equals("") || nit.equals("") || correo.equals("") || genero.equals("")) {
                JOptionPane.showMessageDialog(this, "Llene todos los espacios");
            }else if(genero.equals("F") || genero.equals("M") || genero.equals("m") || genero.equals("f")){
                Clientes nuevo = new Clientes(Integer.parseInt(codigo),nombre,Integer.parseInt(nit),correo,genero.toUpperCase());
                Proy1.AgregarCliente(nuevo);
                JOptionPane.showMessageDialog(this, "Se agregó correctamente el nuevo Cliente");
                this.dispose();                
            }else{                
                JOptionPane.showMessageDialog(this, "Escriba el género unicamente poniendo \"F\" o \"f\" o \"m\" o \"M\"");
            }
        }
    }
}
