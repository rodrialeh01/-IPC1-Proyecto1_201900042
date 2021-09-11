package VVendedores;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class VVentas extends JPanel implements ActionListener{
    JPanel generalp;
    JButton lg;
    JLabel filtrar, nfacturaf, nitf, nombref, fechaf, filtra2;
    JTextField nfacturaft, nitft, nombreft,fechaft;
    JButton aplicarf;
    JComboBox clientescb;
    JTable vfiltrados;
    Object[][] ventas;    
    Color azul = new Color(38,36,89);
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
        Object [][] fila1 = {{"1","3780998","Juan","09/09/2021","132.00","Visualizar"}};
        vfiltrados = new JTable(fila1,encabezado);
        JScrollPane sp= new JScrollPane(vfiltrados);
        sp.setBounds(50, 220, 1150, 350);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        vfiltrados.getColumnModel().getColumn(0).setCellRenderer(renderc);
        vfiltrados.getColumnModel().getColumn(1).setCellRenderer(renderc);
        vfiltrados.getColumnModel().getColumn(2).setCellRenderer(renderc);
        vfiltrados.getColumnModel().getColumn(3).setCellRenderer(renderc);
        vfiltrados.getColumnModel().getColumn(4).setCellRenderer(renderc);
        vfiltrados.getColumnModel().getColumn(5).setCellRenderer(renderc);
        vfiltrados.setEnabled(false);
        vfiltrados.setFont(new Font("Century Gothic", Font.PLAIN,12));
        generalp.add(sp);
        
        //DISEÑO DEL PANEL
        this.setBackground(azul);
        this.setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }    
}
