package Admin;
import Clases.Vendedores;
import proy1.Proy1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Formcv extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, lcaja, lventas, lgenero;
    JTextField tcod, tnombre, tcaja, tventas, tgenero;
    JButton agregar;
    String codigo, nombre, caja,ventas,genero;
    public Formcv(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Crear nuevo Vendedor");
        titulo.setFont(new Font("Arial", Font.PLAIN,25));
        titulo.setBounds(120,30,350,30);
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
        tcod.setBounds(140,100,100,30);
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
        lcaja = new JLabel("Caja:");
        lcaja.setFont(new Font("Arial", Font.PLAIN,18));
        lcaja.setBounds(40,260,100,30);
        lcaja.setVisible(true);
        lcaja.setForeground(Color.WHITE);
        this.add(lcaja);
        
        //TEXTFIELD PARA INGRESAR LA DESCRIPCION
        tcaja = new JTextField();
        tcaja.setBounds(140,260,280,30);
        tcaja.setFont(new Font("Arial", Font.PLAIN,18));
        tcaja.setVisible(true);
        this.add(tcaja);
        
        //LABEL DE CANTIDAD
        lventas = new JLabel("Ventas:");
        lventas.setFont(new Font("Arial", Font.PLAIN,18));
        lventas.setBounds(40,340,100,30);
        lventas.setVisible(true);
        lventas.setForeground(Color.WHITE);
        this.add(lventas);
        
        //TEXTFIELD PARA INGRESAR LA CANTIDAD
        tventas = new JTextField();
        tventas.setBounds(140,340,280,30);
        tventas.setFont(new Font("Arial", Font.PLAIN,18));
        tventas.setVisible(true);
        this.add(tventas);
        
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
        this.setTitle("Crear Vendedor | Blue Mall - POS");
        this.setBounds(450,100,500,600);
        this.getContentPane().setBackground(azul);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    //SE PROGRAMA EL BOTON AGREGAR
    @Override
    public void actionPerformed(ActionEvent ae) {
        // BOTON AGREGAR
        if (ae.getSource()==agregar){
            codigo = tcod.getText();
            nombre = tnombre.getText();
            caja = tcaja.getText();
            ventas = tventas.getText();
            genero = tgenero.getText();
            if (codigo.equals("") || nombre.equals("") || caja.equals("") || ventas.equals("") || genero.equals("")) {
                JOptionPane.showMessageDialog(this, "Llene todos los espacios");
            }else if(genero.equals("F") || genero.equals("M") || genero.equals("m") || genero.equals("f")){
                Vendedores nuevo = new Vendedores(Integer.parseInt(codigo),nombre,Integer.parseInt(caja),Integer.parseInt(ventas),genero.toUpperCase());
                Proy1.AgregarVendedor(nuevo);
                JOptionPane.showMessageDialog(this, "Se agregó correctamente el nuevo Vendedor");
                this.dispose();                
            }else{                
                JOptionPane.showMessageDialog(this, "Escriba el género unicamente poniendo \"F\" o \"f\" o \"m\" o \"M\"");
            }
        }
    }
    
}
