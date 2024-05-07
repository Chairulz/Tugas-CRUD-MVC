/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author afriz
 */
public class tabeldatamovie extends AbstractTableModel{

    List<datamovie> d;
    public tabeldatamovie(List<datamovie>d){
        this.d = d;
    }
    @Override
    public int getRowCount() {
        return d.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3: 
                return "Akting";
            case 4: 
                return "Nilai";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return d.get(row).getJudul();
            case 1:
                return d.get(row).getAlur();
            case 2:
                return d.get(row).getPenokohan();
            case 3: 
                return d.get(row).getAkting();
            case 4: 
                return d.get(row).getNilai();
            default:
                return null;
        }
    }
    
}
