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
import Clases.Clientes;
import Clases.Compras;
import Clases.Ventas;
import Listados.Factura;
import Login.Login;
import java.text.DecimalFormat;

public class VNuevaV extends JPanel implements ActionListener {

    JPanel sc, ap;
    Color azul = new Color(38, 36, 89);
    Color verde = new Color(10, 95, 6);
    Color azulfachero = new Color(97, 176, 242);
    //PANEL SUPERIOR
    JButton name1, name2, aplicarf, ncliente;
    JLabel filtrar, nombref, nitf, correof, generof, filtra2, clientef;
    JTextField nombreft, nitft, correoft, generoft;
    JComboBox clientescb;
    String nombre, nit, correo, genero;

    //PANEL INFERIOR
    JLabel Fecha, Contador, codigoap, cantidadap, totalap;
    JButton agregar, vender;
    JTextField tcodigoap, tcantidadap, ttotal;
    JTable comproductos;
    static Object[][] comprasp;
    String fecha, total, codigo, cantidad;
    int ccompras = 0;

    public VNuevaV() {

        //==============================PANEL SUPERIOR==========================
        //PANEL SUPERIOR DE SELECCIONAR CLIENTE
        sc = new JPanel();
        sc.setLayout(null);
        sc.setBounds(15, 10, 1240, 200);
        sc.setBackground(Color.WHITE);
        this.add(sc);

        //NOMBRANDO EL PANEL A LA VISTA DEL USUARIO
        name1 = new JButton("Seleccionar Cliente");
        name1.setFont(new Font("Century Gothic", Font.BOLD, 15));
        name1.setBounds(0, 0, 300, 30);
        name1.setBackground(Color.WHITE);
        name1.setForeground(Color.BLACK);
        name1.setEnabled(false);
        sc.add(name1);

        //LABEL DE FILTRAR POR: CON SUBRAYADO
        filtrar = new JLabel("Filtrar por:");
        filtrar.setForeground(Color.BLACK);
        filtrar.setBounds(75, 40, 150, 30);
        filtrar.setFont(new Font("Century Gothic", Font.BOLD, 15));
        Font subray = filtrar.getFont();
        Map Atributos = subray.getAttributes();
        Atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtrar.setFont(subray.deriveFont(Atributos));
        sc.add(filtrar);

        //LABEL DE NOMBRE
        nombref = new JLabel("Nombre:");
        nombref.setForeground(Color.BLACK);
        nombref.setBounds(190, 47, 100, 20);
        nombref.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(nombref);

        //TEXTFIELD DE NOMBRE
        nombreft = new JTextField();
        nombreft.setForeground(Color.BLACK);
        nombreft.setBounds(270, 45, 300, 25);
        nombreft.addActionListener(this);
        nombreft.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(nombreft);

        //LABEL DE NIT
        nitf = new JLabel("NIT:");
        nitf.setForeground(Color.BLACK);
        nitf.setBounds(670, 47, 100, 20);
        nitf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(nitf);

        //TEXTFIELD DE NIT
        nitft = new JTextField();
        nitft.setForeground(Color.BLACK);
        nitft.setBounds(740, 45, 300, 25);
        nitft.addActionListener(this);
        nitft.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(nitft);

        //LABEL DE CORREO
        correof = new JLabel("Correo:");
        correof.setForeground(Color.BLACK);
        correof.setBounds(190, 77, 300, 25);
        correof.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(correof);

        //TEXTFIELD DE CORREO
        correoft = new JTextField();
        correoft.setForeground(Color.BLACK);
        correoft.setBounds(270, 75, 300, 25);
        correoft.addActionListener(this);
        correoft.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(correoft);

        //LABEL DE GENERO
        generof = new JLabel("Género:");
        generof.setForeground(Color.BLACK);
        generof.setBounds(670, 77, 300, 25);
        generof.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(generof);

        //TEXTFIELD DE GENERO
        generoft = new JTextField();
        generoft.setForeground(Color.BLACK);
        generoft.setBounds(740, 75, 300, 25);
        generoft.addActionListener(this);
        generoft.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(generoft);

        //BOTON DE APLICAR FILTRO
        aplicarf = new JButton("Aplicar Filtro");
        aplicarf.setForeground(Color.BLACK);
        aplicarf.setBounds(190, 115, 850, 25);
        aplicarf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        aplicarf.addActionListener(this);
        sc.add(aplicarf);

        //LABEL DE FILTRADOS CON SUBRAYADO
        filtra2 = new JLabel("Filtrados:");
        filtra2.setForeground(Color.BLACK);
        filtra2.setBounds(75, 150, 150, 30);
        filtra2.setFont(new Font("Century Gothic", Font.BOLD, 15));
        Font subray2 = filtra2.getFont();
        Map Atributos2 = subray2.getAttributes();
        Atributos2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtra2.setFont(subray.deriveFont(Atributos));
        sc.add(filtra2);

        //LABEL DE CLIENTE
        clientef = new JLabel("Cliente:");
        clientef.setForeground(Color.BLACK);
        clientef.setBounds(190, 155, 100, 25);
        clientef.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(clientef);

        //COMBOBOX DE CLIENTE
        clientescb = new JComboBox();
        clientescb.setForeground(Color.BLACK);
        clientescb.setBounds(270, 150, 500, 25);
        clientescb.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        if (Proy1.cclientes != 0) {
            try {
                for (int j = 0; j < Proy1.cclientes; j++) {
                    clientescb.addItem(Proy1.clientes[j].getNombre());
                }
            } catch (Exception e) {
            }
        }
        clientescb.addActionListener(this);
        sc.add(clientescb);

        //BOTON DE NUEVO CLIENTE
        ncliente = new JButton("Nuevo Cliente");
        ncliente.setForeground(Color.BLACK);
        ncliente.setBounds(800, 150, 240, 25);
        ncliente.addActionListener(this);
        ncliente.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        sc.add(ncliente);

        //========================== PANEL INFERIOR ===============================
        //PANEL INFERIOR DE AGREGAR PRODUCTO
        ap = new JPanel();
        ap.setLayout(null);
        ap.setBounds(15, 220, 1240, 370);
        ap.setBackground(Color.WHITE);
        this.add(ap);

        //MOSTRANDO EL TITULO DEL PANEL A LA VISTA DEL USUARIO
        name2 = new JButton("Agregar Producto");
        name2.setFont(new Font("Century Gothic", Font.BOLD, 15));
        name2.setBounds(0, 0, 300, 30);
        name2.setBackground(Color.WHITE);
        name2.setForeground(Color.BLACK);
        name2.setEnabled(false);
        ap.add(name2);

        //LABEL DE FECHA
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Fecha = new JLabel("Fecha: \t  \t" + LocalDate.now().format(dtf));
        Fecha.setBounds(800, 5, 200, 30);
        Fecha.setForeground(Color.BLACK);
        Fecha.setFont(new Font("Century Gothic", Font.BOLD, 15));
        ap.add(Fecha);

        //JLABEL DE CONTADOR
        Contador = new JLabel("No. \t" + (Proy1.cventas + 1));
        Contador.setBounds(1100, 5, 200, 30);
        Contador.setForeground(Color.BLACK);
        Contador.setFont(new Font("Century Gothic", Font.BOLD, 15));
        ap.add(Contador);

        //LABEL DE CODIGO
        codigoap = new JLabel("Código:");
        codigoap.setBounds(100, 50, 90, 30);
        codigoap.setForeground(Color.BLACK);
        codigoap.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ap.add(codigoap);

        //TEXTFIELD DE CODIGO
        tcodigoap = new JTextField();
        tcodigoap.setBounds(200, 50, 300, 30);
        tcodigoap.setForeground(Color.BLACK);
        tcodigoap.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ap.add(tcodigoap);

        //LABEL DE CANTIDAD
        cantidadap = new JLabel("Cantidad:");
        cantidadap.setBounds(600, 50, 100, 30);
        cantidadap.setForeground(Color.BLACK);
        cantidadap.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ap.add(cantidadap);

        //TEXTFIELD DE CANTIDAD
        tcantidadap = new JTextField();
        tcantidadap.setBounds(700, 50, 300, 30);
        tcantidadap.setForeground(Color.BLACK);
        tcantidadap.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ap.add(tcantidadap);

        //BOTON DE AGREGAR
        agregar = new JButton("Agregar");
        agregar.setBounds(1050, 50, 150, 30);
        agregar.setForeground(Color.BLACK);
        agregar.addActionListener(this);
        agregar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ap.add(agregar);

        //TABLA
        String[] encabezado = {"Código", "Nombre", "Cantidad", "Precio", "Subtotal"};
        comprasp = Proy1.TableCompras();
        comproductos = new JTable(comprasp, encabezado);
        JScrollPane sp = new JScrollPane(comproductos);
        sp.setBounds(50, 100, 1150, 230);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        comproductos.getColumnModel().getColumn(0).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(1).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(2).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(3).setCellRenderer(renderc);
        comproductos.getColumnModel().getColumn(4).setCellRenderer(renderc);
        comproductos.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN, 15));
        comproductos.getTableHeader().setBackground(azulfachero);
        comproductos.getTableHeader().setForeground(Color.BLACK);
        comproductos.setEnabled(false);
        comproductos.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        ap.add(sp);

        //TEXTFIELD DE TOTAL
        DecimalFormat df = new DecimalFormat("#.00");
        ttotal = new JTextField(String.valueOf(df.format(Proy1.totals())));
        ttotal.setBounds(960, 330, 240, 30);
        ttotal.setForeground(Color.BLACK);
        ttotal.setFont(new Font("Century Gothic", Font.BOLD, 15));
        ttotal.addActionListener(this);
        ttotal.setEnabled(false);
        ap.add(ttotal);

        //LABEL DE TOTAL
        totalap = new JLabel("Total:");
        totalap.setBounds(850, 330, 240, 30);
        totalap.setForeground(Color.BLACK);
        totalap.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ap.add(totalap);

        //BOTON DE VENDER
        vender = new JButton("VENDER");
        vender.setBounds(50, 330, 700, 30);
        vender.setForeground(Color.WHITE);
        vender.setBackground(verde);
        vender.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        vender.addActionListener(this);
        ap.add(vender);

        //DISEÑO DEL PANEL
        this.setBackground(azul);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //PANEL SUPERIOR
        nombre = nombreft.getText();
        nit = nitft.getText();
        correo = correoft.getText();
        genero = generoft.getText();
        
        //PANEL INFERIOR
        codigo = tcodigoap.getText();
        cantidad = tcantidadap.getText();
        fecha = Fecha.getText();
        total = ttotal.getText();
        
        //BOTON APLICAR FILTRO
        if (ae.getSource() == aplicarf) {
            //SE LIMPIA EL COMBOBOX
            clientescb.removeAllItems();
            //SI TIENE TODOS LOS CAMPOS VACIO ENTONCES QUE MUESTRE TODOS LOS NOMBRES
            if (nombre.equals("") && nit.equals("") && correo.equals("") && genero.equals("")) {
                llenar();
            }
            //SI SE LLENA EL TEXTFIELD DE NOMBRE ENTONCES QUE VERIFIQUE SI EXISTE O NO
            else if (!nombre.equals("") && nit.equals("") && correo.equals("") && genero.equals("")) {
                if (Proy1.NombresCN(nombre) != null) {
                    for (int i = 0; i < Proy1.NombresCN(nombre).length; i++) {
                        if (Proy1.NombresCN(nombre)[i] != null) {
                            clientescb.addItem(Proy1.NombresCN(nombre)[i]);
                            clientescb.setSelectedItem(Proy1.NombresCN(nombre)[i]);
                        }                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese nombre");
                }
            }
            //SI SE LLENA EL TEXTFIELD DE NIT ENTONCES QUE VERIFIQUE SI EXISTE O NO
            else if (nombre.equals("") && !nit.equals("") && correo.equals("") && genero.equals("")) {
                if (Proy1.NombresCNIT(Integer.parseInt(nit)) != null) {
                    for (int i = 0; i < Proy1.NombresCNIT(Integer.parseInt(nit)).length; i++) {
                        if (Proy1.NombresCNIT(Integer.parseInt(nit))[i] !=null) {
                            clientescb.addItem(Proy1.NombresCNIT(Integer.parseInt(nit))[i]);
                            clientescb.setSelectedItem(Proy1.NombresCNIT(Integer.parseInt(nit)));
                        }                        
                    }                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese nit");
                }
            }
            //SI SE LLENA EL TEXTFIELD DE CORREO ENTONCES VERIFIQUE SI EXISTE O NO
            else if (nombre.equals("") && nit.equals("") && !correo.equals("") && genero.equals("")) {
                if (Proy1.NombresCC(correo) != null) {
                    for (int i = 0; i < Proy1.NombresCC(correo).length; i++) {
                        if (Proy1.NombresCC(correo)[i] !=null) {
                            clientescb.addItem(Proy1.NombresCC(correo)[i]);
                            clientescb.setSelectedItem(Proy1.NombresCC(correo));
                        }                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese correo");
                }
            }
            //SI SE LLENA EL TEXTFIELD DE GENERO ENTONCES VERIFIQUE SI EXISTE O NO
            else if (nombre.equals("") && nit.equals("") && correo.equals("") && !genero.equals("")) {
                if (Proy1.NombresCG(genero.toUpperCase()) != null) {
                    for (int i = 0; i < Proy1.NombresCG(genero.toUpperCase()).length; i++) {
                        if (Proy1.NombresCG(genero.toUpperCase())[i] !=null) {
                            clientescb.addItem(Proy1.NombresCG(genero.toUpperCase())[i]);
                        }                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron clientes con ese género");
                }
            }
            clientescb.repaint();
        }
        //BOTON NUEVO CLIENTE
        else if (ae.getSource()==ncliente) {
            if (nombre.equals("") && nit.equals("") && correo.equals("") && genero.equals("")) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos por favor");
            }else if (nombre.equals("") || nit.equals("") || correo.equals("") || genero.equals("")) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos por favor");
            }else {
                if (genero.equals("M") || genero.equals("F") || genero.equals("m") || genero.equals("f")) {
                    //SU CODIGO SE AÑADE AUTOMATICAMENTE POR MEDIO DE LA FUNCION CODIGO MAYOR Y SUMANDOLE 1 PARA QUE NO SE TRASLAPEN ESOS CODIGOS
                    Clientes nuevo = new Clientes((Proy1.CodigoMayor(Proy1.clientes) + 1), nombre,Integer.parseInt(nit),correo, genero.toUpperCase());
                    Proy1.AgregarCliente(nuevo);
                    JOptionPane.showMessageDialog(null, "Se agregó al cliente con éxito");
                    nombreft.setText("");
                    nitft.setText("");
                    correoft.setText("");
                    generoft.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor en el campo de Género ingrese \"m\", \"f\", \"M\", \"F\"");
                }
            }
            clientescb.repaint();
        }
        //BOTON AGREGAR
        else if (ae.getSource()==agregar) {
            DecimalFormat df = new DecimalFormat("#.00");
            if (cantidad.equals("") && codigo.equals("")) {
                JOptionPane.showMessageDialog(null, "Llene todos lo campos requeridos");
            }else{
                Double subtotal = Proy1.ObtenerProducto(Integer.parseInt(codigo)).getPrecio() * Float.parseFloat(cantidad);
                Compras nuevo = new Compras(Integer.parseInt(codigo),Proy1.ObtenerProducto(Integer.parseInt(codigo)).getNombre(),Integer.parseInt(cantidad), (float) Proy1.ObtenerProducto(Integer.parseInt(codigo)).getPrecio(),subtotal);
                Proy1.AgregarCompra(nuevo);
                tcodigoap.setText("");
                tcantidadap.setText("");
                ttotal.setText("");
                Proy1.ObtenerProducto(Integer.parseInt(codigo)).setCantidad(Proy1.ObtenerProducto(Integer.parseInt(codigo)).getCantidad() - Integer.parseInt(cantidad));
                ttotal.setText(String.valueOf(df.format(Proy1.totals())));
            }
            JFrame f = (JFrame) SwingUtilities.getWindowAncestor(this);
            f.dispose();
            VPrincipal vp = new VPrincipal();
        }else if (ae.getSource()== vender) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (clientescb.getSelectedItem().equals("") || Double.parseDouble(total) == 0) {
                JOptionPane.showMessageDialog(null, "Tiene que existir un cliente y un total mayor a 0");
            }else if (clientescb.getSelectedItem().equals("") && Integer.parseInt(total) == 0) {
                JOptionPane.showMessageDialog(null, "Tiene que existir un cliente y un total mayor a 0");
            }else{
                Ventas nueva = new Ventas((Proy1.cventas+1),Proy1.DevolverCliente((String) clientescb.getSelectedItem()).getNit(),Proy1.DevolverCliente((String) clientescb.getSelectedItem()).getNombre(),String.valueOf(LocalDate.now().format(dtf)),Double.parseDouble(total));
                Proy1.AgregarVenta(nueva);
                Proy1.cventas++;
                Proy1.LeerVenta();
                int caja = Login.objv.getCaja();
                Login.objv.setVentas(Login.objv.getVentas() + 1);
                Login.objv.AsignarVenta(nueva);
                Login.objv.MostrarInfoV();
                Factura factura = new Factura();
                factura.CrearPDFF(Proy1.cventas);
                JFrame f = (JFrame) SwingUtilities.getWindowAncestor(this);
                f.dispose();
                VPrincipal vp = new VPrincipal();
            }
        }
    }
    
    //METODO PARA LLENAR EL COMBOBOX CON TODA LA LISTA DE LOS NOMBRES DE LOS CLIENTES
    public void llenar() {
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
