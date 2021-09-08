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

public class ListadoProductos {
    //CREACIÓN DEL DOCUMENTO
    Document documentop = new Document(PageSize.LETTER);
    //COLORES PARA ADAPTAR EN EL PDF
    public static BaseColor azul = new BaseColor(38,36,89);
    public static BaseColor blanco = new BaseColor(234,255,246);
    public static BaseColor negro = new BaseColor(0,0,0);
    //TIPOGRAFIA PARA EL PDF
    public static Font Tgrande = new Font(Font.FontFamily.HELVETICA,18,Font.BOLD,azul);
    public static Font Tmediano = new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,blanco);
    public static Font Tpequeño = new Font(Font.FontFamily.COURIER,10,Font.NORMAL,negro);
    //METODO PARA CREAR EL ARCHIVO PDF
    public void CrearPDFP(){
        //SE AÑADE UN TRY CATCH PARA EVITAR ERRORES EN LA CREACION DEL PDF
        try{
            //SE LE AÑADE LA RUTA DEL ARCHIVO
            PdfWriter.getInstance(documentop, new FileOutputStream("ListadosPDF/Productos.pdf"));
            //SE ABRE EL DOCUMENTO
            documentop.open();
            //SE LLAMA AL METODO CONTENIDO PARA ESCRIBIR EL CONTENIDO DEL PDF
            Contenido(documentop);
            //SE CIERRA EL DOCUMENTO
            documentop.close();
        }catch(Exception e){
            //MENSAJE DE ERROR EN LA EJECUCIÓN DE LA EXPORTACION PDF
            JOptionPane.showMessageDialog(null,"Hubo un error al exportar la lista");
            documentop.close();
        }
    }
    
    //METODO CONTENIDO PARA DIBUJAR EL PDF
    private static void Contenido(Document doc) throws DocumentException, IOException{
        //SE AÑADE EL LOGO DEL PROGRAMA AL DOCUMENTO PDF
        try {
            Image logo = Image.getInstance("Imagenes/Logo.png");
            logo.scaleToFit(100, 50);
            doc.add(logo);
        } catch (Exception e) {
        }        
        //SE AÑADE UN PARAGRAPH PARA PONER EL TITULO DEL PDF
        Paragraph titulo = new Paragraph();
        titulo.add(new Paragraph("Listado de Productos", Tgrande));
        
        //SE LLAMA AL METODO ESPACIO PARA AGREGAR ESPACIO ENTRE EL TITULO Y LA TABLA
        Espacio(titulo, 2);
        doc.add(titulo);
        //SE CREA LA TABLA DE 5 COLUMNAS
        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100f);
        
        //======================ENCABEZADO==============================
        //COLUMNA 1 == CODIGO
        PdfPCell columna1 = new PdfPCell(new Phrase("Código",Tmediano));
        columna1.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna1.setBackgroundColor(azul);
        columna1.setBorderColor(negro);
        columna1.setPaddingBottom(5);
        columna1.setMinimumHeight(35);
        tabla.addCell(columna1);
        
        //COLUMNA 2 == NOMBRE
        PdfPCell columna2 = new PdfPCell(new Phrase("Nombre",Tmediano));
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna2.setBackgroundColor(azul);
        columna2.setBorderColor(negro);
        columna2.setPaddingBottom(5);
        tabla.addCell(columna2);
        
        //COLUMNA 3 == DESCRIPCION        
        PdfPCell columna3 = new PdfPCell(new Phrase("Descipción",Tmediano));
        columna3.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna3.setBackgroundColor(azul);
        columna3.setBorderColor(negro);
        columna3.setPaddingBottom(5);
        tabla.addCell(columna3);
        
        //COLUMNA 4 == CANTIDAD
        PdfPCell columna4 = new PdfPCell(new Phrase("Cantidad",Tmediano));
        columna4.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna4.setBackgroundColor(azul);
        columna4.setBorderColor(negro);
        columna4.setPaddingBottom(5);
        tabla.addCell(columna4);
        
        //COLUMNA 5 == PRECIO
        PdfPCell columna5 = new PdfPCell(new Phrase("Precio",Tmediano));
        columna5.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna5.setBackgroundColor(azul);
        columna5.setBorderColor(negro);
        columna5.setPaddingBottom(5);
        tabla.addCell(columna5);
        
        //SE DEFINE EL ENCABEZADO
        tabla.setHeaderRows(1);
        //SE CREA UN ARREGLO DE TIPO FLOAT PARA LOS PORCENTAJES DE TAMAÑO DE CADA COLUMNA
        //{COLUMNA1,COLUMNA2,COLUMNA3,COLUMNA4,COLUMNA5}
        float[] tamañocolumna = {0.10f, 0.20f, 0.40f, 0.15f,0.15f};
        //SE LLAMA AL METODO PARA ADAPTAR EL TAMAÑO DE LAS COLUMNAS DE LA TABLA
        tabla.setWidths(tamañocolumna);
        
        //================================SE LLAMAN A LOS OBJETOS PARA QUE SE IMPRIMAN========================
        for (int i = 0; i < Proy1.cproductos; i++) {
            if (Proy1.productos[i] !=null) {
                //COLUMNA1 = CODIGOS
                columna1 = new PdfPCell(new Phrase(String.valueOf(Proy1.productos[i].getCodigo()),Tpequeño));
                columna1.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna1.setBorderColor(negro);
                columna1.setMinimumHeight(25);
                columna1.setPaddingBottom(3);
                tabla.addCell(columna1);
                
                //COLUMNA2 = NOMBRES
                columna2 = new PdfPCell(new Phrase(Proy1.productos[i].getNombre(),Tpequeño));
                columna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna2.setBorderColor(negro);
                columna2.setPaddingBottom(3);
                tabla.addCell(columna2);
                
                //COLUMNA3 = DESCRIPCIONES
                columna3 = new PdfPCell(new Phrase(Proy1.productos[i].getDescripcion(),Tpequeño));
                columna3.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna3.setBorderColor(negro);
                columna3.setPaddingBottom(3);
                tabla.addCell(columna3);
                
                //COLUMNA4 = CANTIDADES
                columna4 = new PdfPCell(new Phrase(String.valueOf(Proy1.productos[i].getCantidad()),Tpequeño));
                columna4.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna4.setBorderColor(negro);
                columna4.setPaddingBottom(3);
                tabla.addCell(columna4);
                
                //COLUMNA5 = PRECIOS
                columna5 = new PdfPCell(new Phrase(String.valueOf(Proy1.productos[i].getPrecio()),Tpequeño));
                columna5.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna5.setBorderColor(negro);
                columna5.setPaddingBottom(3);
                tabla.addCell(columna5);
            }
        }      
        //SE AÑADE LA TABLA AL DOCUMENTO
        doc.add(tabla);
        //SE LLAMA A ESTE METODO PARA CREAR UNA NUEVA PAGINA SI SUPERA EL TAMAÑO DE LA HOJA
        doc.newPage();
        //MENSAJE DE ÉXITO
        JOptionPane.showMessageDialog(null,"Lista exportada con exito");
    }
    
    //AÑADE ESPACIO EN EL DOCUMENTO
    private static void Espacio(Paragraph tit, int n) {
       for (int i = 0; i < n; i++) {
            tit.add(new Paragraph(" "));
        }
    }
}
