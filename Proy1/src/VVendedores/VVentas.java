package VVendedores;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
//UTIL
import java.util.Map;
//IO
import java.io.File;
import java.io.IOException;

//===================PAQUETES================
import proy1.Proy1;
import Login.Login;

public class VVentas extends JPanel implements ActionListener, MouseListener{
    JPanel generalp;
    JButton lg;
    JLabel filtrar, nfacturaf, nitf, nombref, fechaf, filtra2;
    JTextField nfacturaft, nitft, nombreft,fechaft;
    String factura, nit, nombre,fecha;
    JButton aplicarf;
    JComboBox clientescb;
    JTable vfiltrados;
    Object[][] ventas;    
    Color azul = new Color(38,36,89);
    Color azulfachero = new Color(97,176,242);
    String [] encabezado = {"No. Factura","Nit","Nombre","Fecha","Total","Acciones"};
    public VVentas(){
        //PANEL BLANCO
        generalp = new JPanel();
        generalp.setLayout(null);
        generalp.setBounds(15,10,1240,590);
        generalp.setBackground(Color.WHITE);
        this.add(generalp);
        
        //BOTON DE TITULO
        lg = new JButton("Listado General");
        lg.setFont(new Font("Century Gothic", Font.BOLD,15));
        lg.setBounds(0,0,150,30);
        lg.setBackground(Color.WHITE);
        lg.setForeground(Color.BLACK);
        lg.setEnabled(false);
        generalp.add(lg);
        
        //LABEL DE FILTRAR POR: CON SUBRAYADO
        filtrar = new JLabel("Filtrar por:");
        filtrar.setForeground(Color.BLACK);
        filtrar.setBounds(75,40,150,30);
        filtrar.setFont(new Font("Century Gothic", Font.BOLD,15));
        Font subray = filtrar.getFont();
        Map Atributos = subray.getAttributes();
        Atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtrar.setFont(subray.deriveFont(Atributos));
        generalp.add(filtrar);
        
        //LABEL DE NO. FACTURA
        nfacturaf = new JLabel("No. Factura:");
        nfacturaf.setForeground(Color.BLACK);
        nfacturaf.setBounds(190,47,100,20);
        nfacturaf.setFont(new Font("Century Gothic", Font.PLAIN,15));
        generalp.add(nfacturaf);
        
        //TEXTFIELD DE NO. FACTURA
        nfacturaft = new JTextField();
        nfacturaft.setForeground(Color.BLACK);
        nfacturaft.setBounds(290,45,300,25);
        nfacturaft.setFont(new Font("Century Gothic", Font.PLAIN,15));
        nfacturaft.addActionListener(this);
        generalp.add(nfacturaft);
        
        //LABEL DE NIT
        nitf = new JLabel("NIT:");
        nitf.setForeground(Color.BLACK);
        nitf.setBounds(670,47,100,20);
        nitf.setFont(new Font("Century Gothic", Font.PLAIN,15));
        generalp.add(nitf);
        
        //TEXTFIELD DE NIT
        nitft = new JTextField();
        nitft.setForeground(Color.BLACK);
        nitft.setBounds(740,45,300,25);
        nitft.setFont(new Font("Century Gothic", Font.PLAIN,15));
        nitft.addActionListener(this);
        generalp.add(nitft);
        
        //LABEL DE NOMBRE
        nombref = new JLabel("Nombre:");
        nombref.setForeground(Color.BLACK);
        nombref.setBounds(190,97,300,25);
        nombref.setFont(new Font("Century Gothic", Font.PLAIN,15));
        generalp.add(nombref);
        
        //TEXTFIELD DE NOMBRE
        nombreft = new JTextField();
        nombreft.setForeground(Color.BLACK);
        nombreft.setBounds(290,95,300,25);
        nombreft.setFont(new Font("Century Gothic", Font.PLAIN,15));
        nombreft.addActionListener(this);
        generalp.add(nombreft);
        
        //LABEL DE FECHA
        fechaf = new JLabel("Fecha:");
        fechaf.setForeground(Color.BLACK);
        fechaf.setBounds(670,97,300,25);
        fechaf.setFont(new Font("Century Gothic", Font.PLAIN,15));
        generalp.add(fechaf);
        
        //TEXTFIELD DE FECHA
        fechaft = new JTextField();
        fechaft.setForeground(Color.BLACK);
        fechaft.setBounds(740,95,300,25);
        fechaft.setFont(new Font("Century Gothic", Font.PLAIN,15));
        fechaft.addActionListener(this);
        generalp.add(fechaft);
        
        //BOTON DE APLICAR FILTRO
        aplicarf = new JButton("Aplicar Filtro");
        aplicarf.setForeground(Color.BLACK);
        aplicarf.setBounds(190,145,850,25);
        aplicarf.setFont(new Font("Century Gothic", Font.PLAIN,15));
        aplicarf.addActionListener(this);
        generalp.add(aplicarf);
        
        //LABEL DE FILTRADOS CON SUBRAYADO
        filtra2 = new JLabel("Filtrados:");
        filtra2.setForeground(Color.BLACK);
        filtra2.setBounds(75,170,150,30);
        filtra2.setFont(new Font("Century Gothic", Font.PLAIN,15));
        Font subray2 = filtra2.getFont();
        Map Atributos2 = subray2.getAttributes();
        Atributos2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtra2.setFont(subray.deriveFont(Atributos));
        generalp.add(filtra2);
        
        //TABLA
        ventas = Proy1.TablaVentas(Login.objv.getCodigo());
        vfiltrados = new JTable();
        llenar();
        vfiltrados.setDefaultRenderer(Object.class, new TablaVentas());        
        JScrollPane sp= new JScrollPane(vfiltrados);
        sp.setBounds(50, 220, 1150, 350);       
        vfiltrados.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN,15));
        vfiltrados.getTableHeader().setBackground(azulfachero);
        vfiltrados.getTableHeader().setForeground(Color.BLACK);
        vfiltrados.setFont(new Font("Century Gothic", Font.PLAIN,15));
        vfiltrados.addMouseListener(this);
        generalp.add(sp);
        
        //DISEÑO DEL PANEL
        this.setBackground(azul);
        this.setLayout(null);
    }
    
    //METODOS ABSTRACTOS
    //ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent ae) {
        factura = nfacturaft.getText();
        nombre = nombreft.getText();
        nit = nitft.getText();
        fecha = fechaft.getText();
        if (ae.getSource() == aplicarf) {
            limpiar();
            if (factura.equals("") && nombre.equals("") && nit.equals("") && fecha.equals("")) {
                llenar();
            }else if (!nombre.equals("") && factura.equals("")  && nit.equals("") && fecha.equals("")) {
                llenarnombre(nombre);
            }else if (nombre.equals("") && !factura.equals("")  && nit.equals("") && fecha.equals("")) {
                llenarnofactura(Integer.parseInt(factura));
            }else if (nombre.equals("") && factura.equals("")  && !nit.equals("") && fecha.equals("")) {
                llenarnit(Integer.parseInt(nit));
            }else if (nombre.equals("") && factura.equals("")  && nit.equals("") && !fecha.equals("")) {
                llenarfecha(fecha);
            }
        }
    }    
    
    //MOUSELISTENER
    @Override
    //METODO PARA DAR CLICK EN EL LABEL QUE SE ENCUENTRA EN LA TABLA
    public void mouseClicked(MouseEvent me) {
        //SE OBTIENEN LAS COORDENADAS DE LA TABLA
        int posy = vfiltrados.getColumnModel().getColumnIndexAtX(me.getX());
        int posx = me.getY()/vfiltrados.getRowHeight();
        //VERIFICA SI LAS COORDENADAS ESTAN DENTRO DE LA TABLA
        if (posx < vfiltrados.getRowCount() && posx >= 0&& posy < vfiltrados.getColumnCount() && posy >=0) {
            //OBTIENE EL OBJETO SELECCIONADO
            Object objeto = vfiltrados.getValueAt(posx, posy);
            //SI EL USUARIO DA CLICK EN EL LABEL ENTONCES ABRE EL ARCHIVO
            if (objeto instanceof JLabel) {
                JLabel lbl = (JLabel) objeto;
                abrirarchivo("Facturas/Factura" + Proy1.DevolverVenta(Integer.parseInt(lbl.getName())).getNofactura() + ".pdf");
            }            
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    //METODO PARA ABRIR LA FACTURA EN PDF
    public void abrirarchivo(String ruta){
        try{
            File factura = new File (ruta);
            Desktop.getDesktop().open(factura);
        }catch(IOException ex){
        }
    }
    
    //METODO PARA LIMPIAR LAS CELDAS
    public void limpiar(){
            DefaultTableModel tabla = (DefaultTableModel) vfiltrados.getModel();
            for (int i = vfiltrados.getRowCount(); i > 0; i--) {
                tabla.removeRow(tabla.getRowCount() - 1);
            }
    }
    
    //METODO PARA MOSTRAR TODOS LOS DATOS DE LA TABLA
    public void llenar(){
        DefaultTableModel d = new DefaultTableModel(ventas,encabezado){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        vfiltrados.setModel(d);
    }
    
    //METODO PARA FILTRAR POR NOMBRE
    public void llenarnombre(String nombre){
        Object[][] ventasn = Proy1.TablaNombres(Login.objv.getCodigo(), nombre);
        DefaultTableModel n = new DefaultTableModel(ventasn, encabezado) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vfiltrados.setModel(n);
//        DefaultTableModel tabla = (DefaultTableModel) vfiltrados.getModel();
        if (n == null) {
            for (int i = vfiltrados.getRowCount(); i > 0; i--) {
                n.removeRow(n.getRowCount() - 1);
            }
        }
        
    }
    
    //METODO PARA FILTRAR POR NO. DE FACTURA
    public void llenarnofactura(int factura){
        Object[][] ventasf = Proy1.TablaNoFacturas(Login.objv.getCodigo(), factura);
        DefaultTableModel f = new DefaultTableModel(ventasf, encabezado) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vfiltrados.setModel(f);
//        DefaultTableModel tabla = (DefaultTableModel) vfiltrados.getModel();
//        if (ventasn == null) {
//            for (int i = vfiltrados.getRowCount(); i > 0; i--) {
//                tabla.removeRow(tabla.getRowCount() - 1);
//            }
//        }
        
    }
    
    //METODO PARA FILTRAR POR FECHA
    public void llenarfecha(String fecha){
        Object[][] ventasfe = Proy1.TablaFecha(Login.objv.getCodigo(), fecha);
        DefaultTableModel fe = new DefaultTableModel(ventasfe, encabezado) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vfiltrados.setModel(fe);
//        DefaultTableModel tabla = (DefaultTableModel) vfiltrados.getModel();
//        if (ventasn == null) {
//            for (int i = vfiltrados.getRowCount(); i > 0; i--) {
//                tabla.removeRow(tabla.getRowCount() - 1);
//            }
//        }
        
    }
    
    //METODO PARA FILTRAR POR NOMBRE
    public void llenarnit(int nit){
        Object[][] ventasni = Proy1.TablaNit(Login.objv.getCodigo(), nit);
        DefaultTableModel ni = new DefaultTableModel(ventasni, encabezado) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vfiltrados.setModel(ni);
//        DefaultTableModel tabla = (DefaultTableModel) vfiltrados.getModel();
//        if (ventasn == null) {
//            for (int i = vfiltrados.getRowCount(); i > 0; i--) {
//                tabla.removeRow(tabla.getRowCount() - 1);
//            }
//        }
        
    }
}
