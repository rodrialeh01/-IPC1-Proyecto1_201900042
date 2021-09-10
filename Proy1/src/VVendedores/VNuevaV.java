package VVendedores;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

//==================PAQUETES================
import proy1.Proy1;

public class VNuevaV extends JPanel implements ActionListener{
    JPanel sc, ap;
    Color azul = new Color(38,36,89);
    Color verde = new Color(10,95,6);
    //PANEL SUPERIOR
    JButton name1, name2, aplicarf, ncliente;    
    JLabel filtrar, nombref, nitf, correof, generof, filtra2, clientef;
    JTextField nombreft, nitft, correoft,generoft;
    JComboBox clientescb;
    String nombre, nit, correo,genero;
    
    //PANEL INFERIOR
    JLabel Fecha, Contador, codigoap, cantidadap, totalap;
    JButton agregar, vender;
    JTextField tcodigoap, tcantidadap, ttotal;
    JTable comproductos;
    Object[][] compras;
    
    public VNuevaV(){
        
        //==============================PANEL SUPERIOR==========================
        //PANEL SUPERIOR DE SELECCIONAR CLIENTE
        sc = new JPanel();
        sc.setLayout(null);
        sc.setBounds(15,10,1240,200);
        sc.setBackground(Color.WHITE);
        this.add(sc);
        
        //NOMBRANDO EL PANEL A LA VISTA DEL USUARIO
        name1 = new JButton("Seleccionar Cliente");
        name1.setBounds(0,0,150,30);
        name1.setBackground(Color.WHITE);
        name1.setForeground(Color.BLACK);
        name1.setEnabled(false);
        sc.add(name1);
        
        //LABEL DE FILTRAR POR: CON SUBRAYADO
        filtrar = new JLabel("Filtrar por:");
        filtrar.setForeground(Color.BLACK);
        filtrar.setBounds(75,40,150,30);
        filtrar.setFont(new Font("Arial", Font.BOLD,15));
        Font subray = filtrar.getFont();
        Map Atributos = subray.getAttributes();
        Atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtrar.setFont(subray.deriveFont(Atributos));
        sc.add(filtrar);
        
        //LABEL DE NOMBRE
        nombref = new JLabel("Nombre:");
        nombref.setForeground(Color.BLACK);
        nombref.setBounds(190,47,100,20);
        nombref.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(nombref);
        
        //TEXTFIELD DE NOMBRE
        nombreft = new JTextField();
        nombreft.setForeground(Color.BLACK);
        nombreft.setBounds(270,45,300,25);
        nombreft.addActionListener(this);
        nombreft.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(nombreft);
        
        //LABEL DE NIT
        nitf = new JLabel("NIT:");
        nitf.setForeground(Color.BLACK);
        nitf.setBounds(670,47,100,20);
        nitf.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(nitf);
        
        //TEXTFIELD DE NIT
        nitft = new JTextField();
        nitft.setForeground(Color.BLACK);
        nitft.setBounds(740,45,300,25);
        nitft.addActionListener(this);
        nitft.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(nitft);
        
        //LABEL DE CORREO
        correof = new JLabel("Correo:");
        correof.setForeground(Color.BLACK);
        correof.setBounds(190,77,300,25);
        correof.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(correof);
        
        //TEXTFIELD DE CORREO
        correoft = new JTextField();
        correoft.setForeground(Color.BLACK);
        correoft.setBounds(270,75,300,25);
        correoft.addActionListener(this);
        correoft.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(correoft);
        
        //LABEL DE GENERO
        generof = new JLabel("Género:");
        generof.setForeground(Color.BLACK);
        generof.setBounds(670,77,300,25);
        generof.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(generof);
        
        //TEXTFIELD DE GENERO
        generoft = new JTextField();
        generoft.setForeground(Color.BLACK);
        generoft.setBounds(740,75,300,25);
        generoft.addActionListener(this);
        generoft.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(generoft);
        
        //BOTON DE APLICAR FILTRO
        aplicarf = new JButton("Aplicar Filtro");
        aplicarf.setForeground(Color.BLACK);
        aplicarf.setBounds(190,115,850,25);
        aplicarf.setFont(new Font("Arial", Font.PLAIN,15));
        aplicarf.addActionListener(this);
        sc.add(aplicarf);
        
        //LABEL DE FILTRADOS CON SUBRAYADO
        filtra2 = new JLabel("Filtrados:");
        filtra2.setForeground(Color.BLACK);
        filtra2.setBounds(75,150,150,30);
        filtra2.setFont(new Font("Arial", Font.BOLD,15));
        Font subray2 = filtra2.getFont();
        Map Atributos2 = subray2.getAttributes();
        Atributos2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtra2.setFont(subray.deriveFont(Atributos));
        sc.add(filtra2);
        
        //LABEL DE CLIENTE
        clientef = new JLabel("Cliente:");
        clientef.setForeground(Color.BLACK);
        clientef.setBounds(190,155,100,25);
        clientef.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(clientef);
        
        //COMBOBOX DE CLIENTE
        clientescb = new JComboBox();
        clientescb.setForeground(Color.BLACK);
        clientescb.setBounds(270,150,500,25);
        clientescb.setFont(new Font("Arial", Font.PLAIN,15));
        llenar();
        sc.add(clientescb);
        
        //BOTON DE NUEVO CLIENTE
        ncliente = new JButton("Nuevo Cliente");
        ncliente.setForeground(Color.BLACK);
        ncliente.setBounds(800,150,240,25);
        ncliente.addActionListener(this);
        ncliente.setFont(new Font("Arial", Font.PLAIN,15));
        sc.add(ncliente);
        
        //========================== PANEL INFERIOR ===============================
        
        //PANEL INFERIOR DE AGREGAR PRODUCTO
        ap = new JPanel();
        ap.setLayout(null);
        ap.setBounds(15,220,1240,370);
        ap.setBackground(Color.WHITE);
        this.add(ap);
        
        //MOSTRANDO EL TITULO DEL PANEL A LA VISTA DEL USUARIO
        name2 = new JButton("Agregar Producto");
        name2.setBounds(0,0,150,30);
        name2.setBackground(Color.WHITE);
        name2.setForeground(Color.BLACK);
        name2.setEnabled(false);
        ap.add(name2);
        
        //LABEL DE FECHA
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Fecha = new JLabel("Fecha: \t  \t" + LocalDate.now().format(dtf));
        Fecha.setBounds(800,5,200,30);
        Fecha.setForeground(Color.BLACK);
        Fecha.setFont(new Font("Arial", Font.BOLD,15));
        ap.add(Fecha);
        
        //JLABEL DE CONTADOR
        Contador = new JLabel("No.");
        Contador.setBounds(1100,5,200,30);
        Contador.setForeground(Color.BLACK);
        Contador.setFont(new Font("Arial", Font.BOLD,15));
        ap.add(Contador);
        
        //LABEL DE CODIGO
        codigoap = new JLabel("Código:");
        codigoap.setBounds(100,50,50,30);
        codigoap.setForeground(Color.BLACK);
        codigoap.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(codigoap);
        
        //TEXTFIELD DE CODIGO
        tcodigoap = new JTextField();
        tcodigoap.setBounds(200,50,300,30);
        tcodigoap.setForeground(Color.BLACK);
        tcodigoap.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(tcodigoap);
        
        //LABEL DE CANTIDAD
        cantidadap = new JLabel("Cantidad:");
        cantidadap.setBounds(600,50,100,30);
        cantidadap.setForeground(Color.BLACK);
        cantidadap.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(cantidadap);
        
        //TEXTFIELD DE CANTIDAD
        tcantidadap = new JTextField();
        tcantidadap.setBounds(700,50,300,30);
        tcantidadap.setForeground(Color.BLACK);
        tcantidadap.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(tcantidadap);
        
        //BOTON DE AGREGAR
        agregar = new JButton("Agregar");
        agregar.setBounds(1050, 50, 150, 30);
        agregar.setForeground(Color.BLACK);
        agregar.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(agregar);
        
        //TABLA
        String [] encabezado = {"Código","Nombre","Cantidad","Precio","Subtotal"};
        Object [][] fila1 = {{"1","Peluche","4","23.00","92.00"}};
        comproductos = new JTable(fila1,encabezado);
        JScrollPane sp= new JScrollPane(comproductos);
        sp.setBounds(50, 100, 1150, 230);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        comproductos.getColumnModel().getColumn(0).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(1).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(2).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(3).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(4).setCellRenderer(renderc);
        comproductos.setEnabled(false);
        ap.add(sp);
        
        //TEXTFIELD DE TOTAL
        ttotal = new JTextField();
        ttotal.setBounds(960,330,240,30);
        ttotal.setForeground(Color.BLACK);
        ttotal.setFont(new Font("Arial", Font.PLAIN,15));
        ttotal.setEnabled(false);
        ap.add(ttotal);
        
        //LABEL DE TOTAL
        totalap = new JLabel("Total:");
        totalap.setBounds(850,330,240,30);
        totalap.setForeground(Color.BLACK);
        totalap.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(totalap);
        
        //BOTON DE VENDER
        vender = new JButton("VENDER");
        vender.setBounds(50,330,700,30);
        vender.setForeground(Color.WHITE);
        vender.setBackground(verde);
        vender.setFont(new Font("Arial", Font.PLAIN,15));
        ap.add(vender);
        
        //DISEÑO DEL PANEL
        this.setBackground(azul);
        this.setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        nombre = nombref.getText();
        nit = nitf.getText();
        correo = correof.getText();
        genero = generof.getText();
        if (ae.getSource() == aplicarf) {       
            this.repaint();            
        }
    }
    public void llenar(){
        if (Proy1.cclientes != 0) {
            try {
                for (int j = 0; j < Proy1.cclientes; j++) {
                    clientescb.addItem(Proy1.clientes[j].getNombre());
                }
            } catch (Exception e) {
            }
        }
    }
}
