package Listados;
//=============LIBRERIAS==============
//PDF
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Image;
//IO
import java.io.*;
//AWT-SWING
import javax.swing.JOptionPane;

//============PAQUETES============
import proy1.Proy1;
import Clases.Ventas;
import Login.Login;
import java.awt.Color;
import java.text.DecimalFormat;
public class Factura {
    //CREACION DEL DOCUMENTO
    Document facturacli = new Document(PageSize.LETTER);
    //COLORES PARA ADAPTAR EN EL PDF
    public static BaseColor azul = new BaseColor(38,36,89);
    public static BaseColor blanco = new BaseColor(234,255,246);
    public static BaseColor negro = new BaseColor(0,0,0);
    public static BaseColor blancofull = new BaseColor(255,255,255);
    //TIPOGRAFIA PARA EL PDF
    public static Font Tgrande = new Font(Font.FontFamily.HELVETICA,18,Font.BOLD,azul);
    public static Font Tmediano = new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,blanco);
    public static Font Tpequeño = new Font(Font.FontFamily.COURIER,13,Font.NORMAL,negro);
    //METODO PARA CREAR LA FACTURA EN PDF
    //SE AÑADE UN PARAMETRO PARA IDENTIFICARLO CON LA VENTA REALIZADA EN EL NOMBRE DEL PDF
    public void CrearPDFF(int correlativo){
        //SE AÑADE UN TRY CATCH PARA EVITAR ERRORES EN LA CREACION DEL PDF
        try{
            //SE LE AÑADE LA RUTA DEL ARCHIVO
            PdfWriter.getInstance(facturacli, new FileOutputStream("Facturas/Factura" + correlativo + ".pdf"));
            //SE ABRE EL DOCUMENTO
            facturacli.open();
            //SE LLAMA AL METODO CONTENIDO PARA ESCRIBIR EL CONTENIDO DEL PDF
            ContenidoF(facturacli, correlativo);
            //SE CIERRA EL DOCUMENTO
            facturacli.close();
        }catch(Exception e){
            //MENSAJE DE ERROR EN LA EJECUCIÓN DE LA EXPORTACION PDF
            JOptionPane.showMessageDialog(null,"Hubo un error al crear la factura");
            facturacli.close();
        }
    }
    
    //METODO CONTENIDO PARA DIBUJAR LA FACTURA EN EL PDF
    public void ContenidoF(Document doc, int correlativo) throws DocumentException, IOException{
        Paragraph titulo = new Paragraph();
        titulo.add(new Paragraph("BLUE MALL", Tgrande));
        //SE AÑADE EL LOGO DEL PROGRAMA AL DOCUMENTO PDF
        try {
            Image logo = Image.getInstance("Imagenes/Logo.png");
            logo.scaleToFit(100, 50);
            doc.add(logo);
        } catch (Exception e) {
        }        
        //SE AÑADE UN PARAGRAPH PARA PONER EL TITULO DEL PDF        
        titulo.add(new Paragraph("                                              FACTURA", Tgrande));
        //SE LLAMA AL METODO ESPACIO PARA AGREGAR ESPACIO ENTRE EL TITULO Y LA TABLA
        Espacio(titulo, 2);
        doc.add(titulo);
        
        //===============================================================================================
        //==============================       ENCABEZADO DE LA FACTURA      ============================        
        
        //SE CREA LA TABLA PARA POSICIONAR EL NO. DE FACTURA Y NO. DE CAJA (DE 2 COLUMNAS)
        PdfPTable tablanof = new PdfPTable(2);
        tablanof.setWidthPercentage(40f);
        tablanof.setHorizontalAlignment(Element.ALIGN_LEFT);
        
        //NO. DE FACTURA
        PdfPCell columna1 = new PdfPCell(new Phrase("No. de Factura",Tmediano));
        columna1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
        columna1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna1.setBackgroundColor(azul);
        columna1.setBorderColor(negro);
        columna1.setPaddingBottom(5);
        columna1.setMinimumHeight(35);
        tablanof.addCell(columna1);
        
        //NO. DE FACTURA
        PdfPCell columna2 = new PdfPCell(new Phrase("No. Caja",Tmediano));
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna2.setVerticalAlignment(Element.ALIGN_MIDDLE);        
        columna2.setBorderColor(negro);        
        columna2.setBackgroundColor(azul);
        columna2.setPaddingBottom(5);
        columna2.setMinimumHeight(35);
        tablanof.addCell(columna2);
        
        //EL NO. DE LA FACTURA
        columna1 = new PdfPCell(new Phrase(String.valueOf(Proy1.DevolverVenta(correlativo).getNofactura()), Tpequeño));
        columna1.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna1.setBorderColor(negro);
        columna1.setMinimumHeight(35);
        columna1.setPaddingBottom(3);
        tablanof.addCell(columna1);        
        
        //EL NO. DE LA CAJA
        columna2 = new PdfPCell(new Phrase(String.valueOf(Login.objv.getCaja()), Tpequeño));
//        columna2 = new PdfPCell(new Phrase("100", Tpequeño));
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna2.setBorderColor(negro);
        columna2.setMinimumHeight(25);
        columna2.setPaddingBottom(3);
        tablanof.addCell(columna2);
        float[] tamañocolumna = {0.50f, 0.50f};
        tablanof.setWidths(tamañocolumna);
        doc.add(tablanof);
        
        Paragraph separacion = new Paragraph();
//        separacion.add(new Paragraph("", Tgrande));
        //SE LLAMA AL METODO ESPACIO PARA AGREGAR ESPACIO ENTRE LA PRIMER TABLA Y LA OTRA TABLA
        Espacio(separacion, 1);
        doc.add(separacion);
        //====================================================================================
        //SE CREA LA TABLA PARA POSICIONAR DATOS DEL CLIENTE (DE 2 COLUMNAS)
        PdfPTable tabladc = new PdfPTable(2);
        tabladc.setWidthPercentage(100f);
        tabladc.setHorizontalAlignment(Element.ALIGN_LEFT);
        
        //DATOS DEL CLIENTE
        //NOMBRE
        PdfPCell columnaLC = new PdfPCell(new Phrase("Nombre: ",Tmediano));
        columnaLC.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnaLC.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaLC.setBackgroundColor(azul);
        columnaLC.setBorderColor(negro);
        columnaLC.setPaddingBottom(5);
        columnaLC.setMinimumHeight(35);
        tabladc.addCell(columnaLC);
        
        //nombre
        columnaLC = new PdfPCell(new Phrase(Proy1.DevolverVenta(correlativo).getNombre(),Tpequeño));
        columnaLC.setHorizontalAlignment(Element.ALIGN_LEFT);
        columnaLC.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaLC.setBorderColor(negro);
        columnaLC.setMinimumHeight(35);
        columnaLC.setPaddingBottom(5);
        tabladc.addCell(columnaLC);
        
        //NIT
        PdfPCell columnaDC = new PdfPCell(new Phrase("NIT:",Tmediano));
        columnaDC.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnaDC.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaDC.setBorderColor(negro);
        columnaDC.setBackgroundColor(azul);
        columnaDC.setPaddingBottom(5);
        columnaDC.setMinimumHeight(35);
        tabladc.addCell(columnaDC);
        
        //nit
        columnaDC = new PdfPCell(new Phrase(String.valueOf(Proy1.DevolverVenta(correlativo).getNit()), Tpequeño));
        columnaDC.setHorizontalAlignment(Element.ALIGN_LEFT);
        columnaDC.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaDC.setBorderColor(negro);
        columnaDC.setMinimumHeight(35);
        columnaDC.setPaddingBottom(5);
        tabladc.addCell(columnaDC);
        
        //FECHA
        PdfPCell columnaDF = new PdfPCell(new Phrase("Fecha",Tmediano));
        columnaDF.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnaDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaDF.setBorderColor(negro);
        columnaDF.setBackgroundColor(azul);
        columnaDF.setPaddingBottom(5);
        columnaDF.setMinimumHeight(35);
        tabladc.addCell(columnaDF);
        
        //nit
        columnaDF = new PdfPCell(new Phrase(String.valueOf(Proy1.DevolverVenta(correlativo).getFecha()), Tpequeño));
        columnaDF.setHorizontalAlignment(Element.ALIGN_LEFT);
        columnaDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaDF.setBorderColor(negro);
        columnaDF.setMinimumHeight(35);
        columnaDF.setPaddingBottom(5);
        tabladc.addCell(columnaDF);
        float[] tamañocolumnas = {0.20f, 0.80f};
        tabladc.setWidths(tamañocolumnas);
        doc.add(tabladc);
        
        //SE LLAMA AL METODO ESPACIO PARA AGREGAR ESPACIO ENTRE LA PRIMER TABLA Y LA OTRA TABLA
        Paragraph separacion2 = new Paragraph();
        Espacio(separacion2, 2);
        doc.add(separacion2);
        //==============================================================================================
        //=====================         CONTENIDO DE LOS PRODUCTOS           ===========================
        //SE CREA LA TABLA PARA DETALLAR LA COMPRA EN LA FACTURA
        PdfPTable tablaprod = new PdfPTable(5);
        tablaprod.setWidthPercentage(100f);
        //======================ENCABEZADO==============================
        //COLUMNA 1 == CODIGO
        PdfPCell columnac = new PdfPCell(new Phrase("Código",Tmediano));
        columnac.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnac.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnac.setBackgroundColor(azul);
        columnac.setBorderColor(negro);
        columnac.setPaddingBottom(5);
        columnac.setMinimumHeight(35);
        tablaprod.addCell(columnac);
        
        //COLUMNA 2 == NOMBRE
        PdfPCell columnan = new PdfPCell(new Phrase("Nombre",Tmediano));
        columnan.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnan.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnan.setBackgroundColor(azul);
        columnan.setBorderColor(negro);
        columnan.setPaddingBottom(5);
        tablaprod.addCell(columnan);
        
        //COLUMNA 3 == CANTIDAD        
        PdfPCell columnaca = new PdfPCell(new Phrase("Cantidad",Tmediano));
        columnaca.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnaca.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnaca.setBackgroundColor(azul);
        columnaca.setBorderColor(negro);
        columnaca.setPaddingBottom(5);
        tablaprod.addCell(columnaca);
        
        //COLUMNA 4 == PRECIO
        PdfPCell columnap = new PdfPCell(new Phrase("Precio",Tmediano));
        columnap.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnap.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnap.setBackgroundColor(azul);
        columnap.setBorderColor(negro);
        columnap.setPaddingBottom(5);
        tablaprod.addCell(columnap);
        
        //COLUMNA 5 == SUBTOTAL
        PdfPCell columnast = new PdfPCell(new Phrase("Subtotal",Tmediano));
        columnast.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnast.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnast.setBackgroundColor(azul);
        columnast.setBorderColor(negro);
        columnast.setPaddingBottom(5);
        tablaprod.addCell(columnast);
        
        //SE DEFINE EL ENCABEZADO
        tablaprod.setHeaderRows(1);
        //SE CREA UN ARREGLO DE TIPO FLOAT PARA LOS PORCENTAJES DE TAMAÑO DE CADA COLUMNA
        //{COLUMNA1,COLUMNA2,COLUMNA3,COLUMNA4,COLUMNA5}
        float[] tamañocolumnasp = {0.10f, 0.30f, 0.10f, 0.20f,0.30f};
        //SE LLAMA AL METODO PARA ADAPTAR EL TAMAÑO DE LAS COLUMNAS DE LA TABLA
        tablaprod.setWidths(tamañocolumnasp);
        
        //================================SE LLAMAN A LOS OBJETOS PARA QUE SE IMPRIMAN========================
        for (int i = 0; i < Proy1.compras.length; i++) {
            if (Proy1.compras[i] !=null) {
                //COLUMNA1 = CODIGOS
                columnac = new PdfPCell(new Phrase(String.valueOf(Proy1.compras[i].getCodigo()),Tpequeño));
                columnac.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnac.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columnac.setBorderColor(negro);
                columnac.setMinimumHeight(25);
                columnac.setPaddingBottom(3);
                tablaprod.addCell(columnac);
                
                //COLUMNA2 = NOMBRES
                columnan = new PdfPCell(new Phrase(Proy1.compras[i].getNombre(),Tpequeño));
                columnan.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnan.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columnan.setBorderColor(negro);
                columnan.setPaddingBottom(3);
                tablaprod.addCell(columnan);
                
                //COLUMNA3 = CANTIDADES
                columnaca = new PdfPCell(new Phrase(String.valueOf(Proy1.compras[i].getCantidad()),Tpequeño));
                columnaca.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnaca.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columnaca.setBorderColor(negro);
                columnaca.setBorderColorLeft(blancofull);
                columnaca.setBorderColorRight(blancofull);
                columnaca.setPaddingBottom(3);
                tablaprod.addCell(columnaca);
                
                //DECIMAL FORMAT
                DecimalFormat df = new DecimalFormat("#.00");
                
                //COLUMNA4 = PRECIOS
                columnap = new PdfPCell(new Phrase(String.valueOf(df.format(Proy1.compras[i].getPrecio())),Tpequeño));
                columnap.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnap.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columnap.setBorderColor(negro);
                columnap.setPaddingBottom(3);
                tablaprod.addCell(columnap);
                
                //COLUMNA5 = SUBTOTALES
                columnast = new PdfPCell(new Phrase(String.valueOf(df.format(Proy1.compras[i].getSubtotal())),Tpequeño));
                columnast.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnast.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columnast.setBorderColor(negro);
                columnast.setPaddingBottom(3);
                tablaprod.addCell(columnast);
            }
        }
        doc.add(tablaprod);
        
        //COLUMNA TOTAL
        PdfPTable tablatotal = new PdfPTable(3);
        tablatotal.setWidthPercentage(100f);
        float[] tamañocolumnatotal = {0.50F,0.20f, 0.30f};
        
        //SE LLAMA AL METODO PARA ADAPTAR EL TAMAÑO DE LAS COLUMNAS DE LA TABLA
        tablatotal.setWidths(tamañocolumnatotal);
        
        PdfPCell columnavac = new PdfPCell(new Phrase("",Tpequeño));
        columnavac.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnavac.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnavac.setBorderColor(negro);
        columnavac.setPaddingBottom(5);
        tablatotal.addCell(columnavac);
        
        PdfPCell columnat = new PdfPCell(new Phrase("Total :",Tmediano));
        columnat.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnat.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnat.setBackgroundColor(azul);
        columnat.setBorderColor(negro);
        columnat.setPaddingBottom(5);
        tablatotal.addCell(columnat);
        
        DecimalFormat df = new DecimalFormat("#.00");
        PdfPCell columnatr = new PdfPCell(new Phrase(String.valueOf(df.format(Proy1.DevolverVenta(correlativo).getTotal())),Tpequeño));
        columnatr.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnatr.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnatr.setBorderColor(negro);
        columnatr.setPaddingBottom(5);
        tablatotal.addCell(columnatr);
        
        doc.add(tablatotal);
        doc.newPage();
        //MENSAJE DE ÉXITO
        JOptionPane.showMessageDialog(null,"Factura creada con éxito");        
    }
    //AÑADE ESPACIO EN EL DOCUMENTO
    private static void Espacio(Paragraph tit, int n) {
       for (int i = 0; i < n; i++) {
            tit.add(new Paragraph(" "));
        }
    }
}
