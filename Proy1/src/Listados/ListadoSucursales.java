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
//IO
import java.io.*;
import java.awt.Color;
//AWT-SWING
import javax.swing.JOptionPane;

//============PAQUETES============
import proy1.Proy1;

public class ListadoSucursales {
    Document documentos = new Document(PageSize.LETTER.rotate());
    public static BaseColor azul = new BaseColor(38,36,89);
    public static BaseColor blanco = new BaseColor(234,255,246);
    public static BaseColor negro = new BaseColor(0,0,0);
    public static Font Tgrande = new Font(Font.FontFamily.HELVETICA,18,Font.BOLD,azul);
    public static Font Tmediano = new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,blanco);
    public static Font Tpequeño = new Font(Font.FontFamily.TIMES_ROMAN,13,Font.BOLD,negro);
    public void CrearPDFS(){
        try{
            PdfWriter.getInstance(documentos, new FileOutputStream("ListadosPDF/Sucursales.pdf"));
            documentos.open();
            Contenido(documentos);
            documentos.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hubo un error al exportar la lista");
        }
    }
    
    private static void Contenido(Document doc) throws DocumentException{
        Paragraph titulo = new Paragraph();
        titulo.add(new Paragraph("Listado de Sucursales", Tgrande));
        Espacio(titulo, 1);
        doc.add(titulo);
        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100f);
        
        PdfPCell columna1 = new PdfPCell(new Phrase("Código",Tmediano));
        columna1.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna1.setBackgroundColor(azul);
        columna1.setBorderColor(negro);
        columna1.setPaddingBottom(5);
        columna1.setMinimumHeight(35);
        tabla.addCell(columna1);
        
        PdfPCell columna2 = new PdfPCell(new Phrase("Nombre",Tmediano));
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna2.setBackgroundColor(azul);
        columna2.setBorderColor(negro);
        columna2.setPaddingBottom(5);
        tabla.addCell(columna2);
        
        PdfPCell columna3 = new PdfPCell(new Phrase("Dirección",Tmediano));
        columna3.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna3.setBackgroundColor(azul);
        columna3.setBorderColor(negro);
        columna3.setPaddingBottom(5);
        tabla.addCell(columna3);
        
        PdfPCell columna4 = new PdfPCell(new Phrase("Correo",Tmediano));
        columna4.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna4.setBackgroundColor(azul);
        columna4.setBorderColor(negro);
        columna4.setPaddingBottom(5);
        tabla.addCell(columna4);
        
        PdfPCell columna5 = new PdfPCell(new Phrase("Teléfono",Tmediano));
        columna5.setHorizontalAlignment(Element.ALIGN_CENTER);
        columna5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columna5.setBackgroundColor(azul);
        columna5.setBorderColor(negro);
        columna5.setPaddingBottom(5);
        tabla.addCell(columna5);
        
        tabla.setHeaderRows(1);
        float[] medidaCeldas = {0.25f, 0.45f, 0.7f, 0.45f,0.3f};
        tabla.setWidths(medidaCeldas);
        
        for (int i = 0; i < Proy1.csucursales; i++) {
            if (Proy1.sucursales[i] !=null) {
                columna1 = new PdfPCell(new Phrase(String.valueOf(Proy1.sucursales[i].getCodigo()),Tpequeño));
                columna1.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna1.setBorderColor(negro);
                columna1.setMinimumHeight(25);
                columna1.setPaddingBottom(3);
                tabla.addCell(columna1);
                
                columna2 = new PdfPCell(new Phrase(Proy1.sucursales[i].getNombre(),Tpequeño));
                columna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna2.setBorderColor(negro);
                columna2.setPaddingBottom(3);
                tabla.addCell(columna2);
                
                columna3 = new PdfPCell(new Phrase(Proy1.sucursales[i].getDireccion(),Tpequeño));
                columna3.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna3.setBorderColor(negro);
                columna3.setPaddingBottom(3);
                tabla.addCell(columna3);
                
                columna4 = new PdfPCell(new Phrase(Proy1.sucursales[i].getCorreo(),Tpequeño));
                columna4.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna4.setBorderColor(negro);
                columna4.setPaddingBottom(3);
                tabla.addCell(columna4);
                
                columna5 = new PdfPCell(new Phrase(String.valueOf(Proy1.sucursales[i].getTelefono()),Tpequeño));
                columna5.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                columna5.setBorderColor(negro);
                columna5.setPaddingBottom(3);
                tabla.addCell(columna5);
            }
        }        
        doc.add(tabla);
        doc.newPage();
        JOptionPane.showMessageDialog(null,"Lista exportada con exito");
    }

    private static void Espacio(Paragraph tit, int n) {
       for (int i = 0; i < n; i++) {
            tit.add(new Paragraph(" "));
        }
    }
}
