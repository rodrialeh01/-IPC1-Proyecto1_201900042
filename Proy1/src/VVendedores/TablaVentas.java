package VVendedores;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
public class TablaVentas extends DefaultTableCellRenderer{
    //RENDERIZAR LA TABLA PARA QUE PUEDA LEER DE MANERA CORRECTA LOS LABEL
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bin, boolean bin1, int i, int i1){
        if (o instanceof JLabel) {
            JLabel lbl = (JLabel) o;
            return lbl;
        }
        return super.getTableCellRendererComponent(jtable, o, bin, bin1, i, i1);
    }
}
