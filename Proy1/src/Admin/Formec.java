package Admin;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//==================PAQUETES================
import proy1.Proy1;

public class Formec extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, lnit, lcorreo, lgenero;
    JTextField tcod, tnombre, tnit, tcorreo, tgenero;
    JButton eliminar, buscar;
    String codigo, nombre, nit,correo,genero;
    public Formec(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Eliminar Cliente");
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
        
        //LABEL DE DESCRIPCION
        lnit = new JLabel("NIT:");
        lnit.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lnit.setBounds(40,260,100,30);
        lnit.setVisible(true);
        lnit.setForeground(Color.WHITE);
        this.add(lnit);
        
        //TEXTFIELD PARA INGRESAR LA DESCRIPCION
        tnit = new JTextField();
        tnit.setBounds(140,260,280,30);
        tnit.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tnit.setVisible(true);
        tnit.setEnabled(false);
        this.add(tnit);
        
        //LABEL DE CANTIDAD
        lcorreo = new JLabel("Correo:");
        lcorreo.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lcorreo.setBounds(40,340,100,30);
        lcorreo.setVisible(true);
        lcorreo.setForeground(Color.WHITE);
        this.add(lcorreo);
        
        //TEXTFIELD PARA INGRESAR LA CANTIDAD
        tcorreo = new JTextField();
        tcorreo.setBounds(140,340,280,30);
        tcorreo.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tcorreo.setVisible(true);
        tcorreo.setEnabled(false);
        this.add(tcorreo);
        
        //LABEL DE PRECIO
        lgenero = new JLabel("Genero:");
        lgenero.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lgenero.setBounds(40,420,100,30);
        lgenero.setVisible(true);
        lgenero.setForeground(Color.WHITE);
        this.add(lgenero);
        
        //TEXTFIELD PARA INGRESAR EL PRECIO
        tgenero = new JTextField();
        tgenero.setBounds(140,420,280,30);
        tgenero.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tgenero.setVisible(true);
        tgenero.setEnabled(false);
        this.add(tgenero);
        
        //BOTON DE ELIMINAR
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
        this.setTitle("Eliminar Cliente | Blue Mall - POS");
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
        nit = tnit.getText();
        correo = tcorreo.getText();
        genero = tgenero.getText();
        boolean opcion = false;
        //BOTON BUSCAR
        if (ae.getSource()==buscar) {            
            for (int i = 0; i < Proy1.clientes.length; i++) {
                //VALIDAR SI EXISTE EL PRODUCTO
                if (Proy1.clientes[i] !=null && Proy1.clientes[i].getCodigo()== Integer.parseInt(codigo)) {                
                    opcion = true;
                    eliminar.setEnabled(true);
                    tnombre.setText(Proy1.clientes[i].getNombre());
                    tnit.setText(String.valueOf(Proy1.clientes[i].getNit()));
                    tcorreo.setText(Proy1.clientes[i].getCorreo());
                    tgenero.setText(Proy1.clientes[i].getGenero()); 
                }
            }
            if (opcion == false) {
                JOptionPane.showMessageDialog(this, "No se encontró el Cliente");
            }else{
                JOptionPane.showMessageDialog(this, "Se encontro al Cliente");
            }
        }
        //BOTON ELIMINAR
        else if (ae.getSource()==eliminar) {
            //HACE LA OPERACIÓN DE ELIMINAR LOS DATOS DEL OBJETO
            //HACE QUE EL ESPACIO DONDE SE UBICA EL OBJETO SEA NULO
            for (int i = 0; i < Proy1.cclientes; i++) {
                if (Proy1.clientes[i].getCodigo() == Integer.parseInt(codigo)) {
                    Proy1.clientes[i] = null;                   
                }                
            }
            //HACE QUE DESDE EL ESPACIO NULO EN ADELANTE SE MUEVAN LAS CASILLAS HACIA ARRIBA
            for (int i = 0; i < Proy1.cclientes -1; i++) {
                if (Proy1.clientes[i] == null) {
                    for (int j = i; j < Proy1.cclientes-1; j++) {
                        Proy1.clientes[j] = Proy1.clientes[j + 1];
                    } 
                }
            }
            //CONTADOR PARA IR DESCONTANDO LA CANTIDAD DE OBJETOS EN EL VECTOR
            Proy1.cclientes --;
            //SI LA CANTIDAD DE PRODUCTOS ES IGUAL A 0 ENTONCES QUE TOME QUE LA POSICION VA A SER NUL
            if (Proy1.cclientes == 0) {
                Proy1.clientes[0] = null;
            }
            //SERIALIZAR LA ELIMINACION DEL OBJETO
            Proy1.EscribirClientes(Proy1.clientes);
            Proy1.LeerCliente();
            JOptionPane.showMessageDialog(this, "Se ha eliminado al Cliente con éxito");
            this.dispose();
        }
    }
}
