package Admin;
import Clases.Sucursales;
import proy1.Proy1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Formcs extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, ldireccion, lcorreo, ltelefono;
    JTextField tcod, tnombre, tdireccion, tcorreo, ttelefono;
    JButton agregar;
    String codigo, nombre, direccion,correo,telefono;
    public Formcs(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Crear nueva Sucursal");
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
        this.add(ttelefono);
        
        //BOTON DE AGREGAR
        agregar = new JButton("Agregar");
        agregar.setBounds(100,500,280,40);
        agregar.setFont(new Font("Century Gothic", Font.PLAIN,15));
        agregar.setBackground(Color.BLACK);
        agregar.setForeground(Color.WHITE);
        agregar.addActionListener(this);
        this.add(agregar);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Crear Sucursal | Blue Mall - POS");
        this.setBounds(450,100,500,600);
        this.getContentPane().setBackground(azul);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    //PROGRAMA LAS ACCIONES DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent ae) {
       // BOTON AGREGAR
        if (ae.getSource()==agregar){
            codigo = tcod.getText();
            nombre = tnombre.getText();
            direccion = tdireccion.getText();
            correo = tcorreo.getText();
            telefono = ttelefono.getText();
            if (codigo.equals("") || nombre.equals("") || direccion.equals("") || correo.equals("") || telefono.equals("")) {
                JOptionPane.showMessageDialog(this, "Llene todos los campos");
            }else{
                if (Proy1.csucursales <= Proy1.sucursales.length) {
                    if (verificar(Integer.parseInt(codigo)) == false) {
                        Sucursales nuevo = new Sucursales(Integer.parseInt(codigo), nombre, direccion, correo, Integer.parseInt(telefono));
                        Proy1.AgregarSucursales(nuevo);
                        JOptionPane.showMessageDialog(this, "Se agregó correctamente la nueva Sucursal");
                        Proy1.LeerSucursales();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "El código de Sucursal No." + codigo + " ya esta en uso, pruebe con otro");
                        tcod.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Ya se llegó al limite de Sucursales");
                    this.dispose();
                }                                   
            }
            
        }
        
    }
    //VERIFICA SI YA EXISTE EL OBJETO
    public boolean verificar(int cods) {
        for (int i = 0; i<Proy1.sucursales.length; i++) {
            if (Proy1.sucursales[i]!=null && Proy1.sucursales[i].getCodigo()==cods) {
                return true;
            }
        }
        return false;
    }
}
