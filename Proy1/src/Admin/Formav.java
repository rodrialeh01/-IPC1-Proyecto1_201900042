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

public class Formav extends JFrame implements ActionListener{
    JLabel titulo, lcod, lnombre, lcaja, lventas, lgenero, lpassword;
    JTextField tcod, tnombre, tcaja, tventas, tgenero, tpassword;
    JButton actualizar, buscar;
    String codigo, nombre, caja,ventas,genero, password;
    public Formav(){
        //COLORES
        Color azul = new Color(38,36,89);
        
        //TITULO
        titulo = new JLabel("Actualizar Vendedor");
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
        lnombre.setBounds(40,150,100,30);
        lnombre.setVisible(true);
        lnombre.setForeground(Color.WHITE);
        this.add(lnombre);
        
        //TEXTFIELD PARA INGRESAR EL NOMBRE
        tnombre = new JTextField();
        tnombre.setBounds(140,150,280,30);
        tnombre.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tnombre.setVisible(true);
        tnombre.setEnabled(false);
        this.add(tnombre);
        
        //LABEL DE CAJA
        lcaja = new JLabel("Caja:");
        lcaja.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lcaja.setBounds(40,220,100,30);
        lcaja.setVisible(true);
        lcaja.setForeground(Color.WHITE);
        this.add(lcaja);
        
        //TEXTFIELD PARA INGRESAR LA CAJA
        tcaja = new JTextField();
        tcaja.setBounds(140,220,280,30);
        tcaja.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tcaja.setVisible(true);
        tcaja.setEnabled(false);
        this.add(tcaja);
        
        //LABEL DE VENTAS
        lventas = new JLabel("Ventas:");
        lventas.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lventas.setBounds(40,290,100,30);
        lventas.setVisible(true);
        lventas.setForeground(Color.WHITE);
        this.add(lventas);
        
        //TEXTFIELD PARA INGRESAR LAS VENTAS
        tventas = new JTextField();
        tventas.setBounds(140,290,280,30);
        tventas.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tventas.setVisible(true);
        tventas.setEnabled(false);
        this.add(tventas);
        
        //LABEL DE GENERO
        lgenero = new JLabel("Genero:");
        lgenero.setFont(new Font("Century Gothic", Font.PLAIN,18));
        lgenero.setBounds(40,360,100,30);
        lgenero.setVisible(true);
        lgenero.setForeground(Color.WHITE);
        this.add(lgenero);
        
        //TEXTFIELD PARA INGRESAR EL GENERO
        tgenero = new JTextField();
        tgenero.setBounds(140,360,280,30);
        tgenero.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tgenero.setVisible(true);
        tgenero.setEnabled(false);
        this.add(tgenero);
        
        //LABEL DE PASSWORD
        lpassword = new JLabel("Contraseña:");
        lpassword.setFont(new Font("Century Gothic", Font.PLAIN,15));
        lpassword.setBounds(40,430,100,30);
        lpassword.setVisible(true);
        lpassword.setForeground(Color.WHITE);
        this.add(lpassword);
        
        //TEXTFIELD PARA INGRESAR EL PASSWORD
        tpassword = new JTextField();
        tpassword.setBounds(140,430,280,30);
        tpassword.setFont(new Font("Century Gothic", Font.PLAIN,18));
        tpassword.setVisible(true);
        tpassword.setEnabled(false);
        this.add(tpassword);
        
        //BOTON DE ACTUALIZAR
        actualizar = new JButton("Actualizar");
        actualizar.setBounds(100,500,280,40);
        actualizar.setFont(new Font("Arial", Font.PLAIN,15));
        actualizar.setBackground(Color.BLACK);
        actualizar.setForeground(Color.WHITE);
        actualizar.addActionListener(this);
        actualizar.setEnabled(false);
        this.add(actualizar);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Actualizar Vendedor | Blue Mall - POS");
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
        caja = tcaja.getText();
        ventas = tventas.getText();
        genero = tgenero.getText();
        password = tpassword.getText();
        boolean opcion = false;
        //BOTON BUSCAR
        if (ae.getSource()==buscar) {            
            for (int i = 0; i < Proy1.vendedores.length; i++) {
                //VALIDAR SI EXISTE EL PRODUCTO
                if (Proy1.vendedores[i] !=null && Proy1.vendedores[i].getCodigo()== Integer.parseInt(codigo)) {                
                    opcion = true;
                    tcod.setEnabled(false);
                    buscar.setEnabled(false);
                    tnombre.setEnabled(true);
                    tcaja.setEnabled(true);
                    tventas.setEnabled(true);
                    tgenero.setEnabled(true);
                    tpassword.setEnabled(true);
                    actualizar.setEnabled(true);
                    tnombre.setText(Proy1.vendedores[i].getNombre());
                    tcaja.setText(String.valueOf(Proy1.vendedores[i].getCaja()));
                    tventas.setText(String.valueOf(Proy1.vendedores[i].getVentas()));
                    tgenero.setText(Proy1.vendedores[i].getGenero());
                    tpassword.setText(Proy1.vendedores[i].getPassword());
                }
            }
            if (opcion == false) {
                JOptionPane.showMessageDialog(this, "No se encontró al Vendedor");
            }else{
                JOptionPane.showMessageDialog(this, "Se encontro al Vendedor");
            }
        }
        //BOTON ACTUALIZAR
        else if (ae.getSource()==actualizar) {
            //HACE LA OPERACIÓN DE ACTUALIZAR LOS DATOS DEL OBJETO
            if(genero.equals("F") || genero.equals("M") || genero.equals("m") || genero.equals("f")){
                for (int i = 0; i < Proy1.cvendedores; i++) {
                    if (Integer.parseInt(codigo) == Proy1.vendedores[i].getCodigo()) {
                        Proy1.vendedores[i].setNombre(nombre);
                        Proy1.vendedores[i].setCaja(Integer.parseInt(caja));
                        Proy1.vendedores[i].setVentas(Integer.parseInt(ventas));
                        Proy1.vendedores[i].setGenero(genero.toUpperCase());
                        Proy1.vendedores[i].setPassword(password);
                    }
                }
                //SERIALIZANDO EL OBJETO ACTUALIZADO
                Proy1.EscribirVendedores(Proy1.vendedores);
                JOptionPane.showMessageDialog(this, "Se ha actualizado el Vendedor con éxito");
                this.dispose();
            }else{                
                JOptionPane.showMessageDialog(this, "Escriba el género unicamente poniendo \"F\" o \"f\" o \"m\" o \"M\"");
            }                       
            Proy1.LeerVendedor();
        }
    }
}
