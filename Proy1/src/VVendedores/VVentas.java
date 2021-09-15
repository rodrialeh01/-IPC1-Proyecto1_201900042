package VVendedores;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import proy1.Proy1;
import Login.Login;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.net.*;

public class VVentas extends JPanel implements ActionListener, MouseListener{
    JPanel generalp;
    JButton lg;
    JLabel filtrar, nfacturaf, nitf, nombref, fechaf, filtra2;
    JTextField nfacturaft, nitft, nombreft,fechaft;
    JButton aplicarf;
    JComboBox clientescb;
    JTable vfiltrados;
    Object[][] ventas;    
    Color azul = new Color(38,36,89);
    Color azulfachero = new Color(97,176,242);
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
        generalp.add(fechaft);
        
        //BOTON DE APLICAR FILTRO
        aplicarf = new JButton("Aplicar Filtro");
        aplicarf.setForeground(Color.BLACK);
        aplicarf.setBounds(190,145,850,25);
        aplicarf.setFont(new Font("Century Gothic", Font.PLAIN,15));
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
        //TABLA
        String [] encabezado = {"No. Factura","Nit","Nombre","Fecha","Total","Acciones"};
        ventas = Proy1.TablaVentas(Login.objv.getCodigo());
        vfiltrados = new JTable();
        DefaultTableModel d = new DefaultTableModel(ventas,encabezado){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        vfiltrados.setModel(d);    
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }    
    
    //METODOS ABSTRACTOS
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
    //METODO PARA ABRIR LA FACTURA
    public void abrirarchivo(String ruta){
        try{
            File factura = new File (ruta);
            Desktop.getDesktop().open(factura);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
