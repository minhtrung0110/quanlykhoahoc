/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author LENOVO
 */
import DTO.Course;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel_KhoaHoc {

    public DefaultTableModel setTableHocVien(List<Course> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        Course khoaHoc = null;
        for (int i = 0; i < num; i++) {
            khoaHoc = listItem.get(i);
            obj = new Object[columns];
            obj[1] = khoaHoc.getCourseID();
            obj[0] = (i + 1);
            obj[2] = khoaHoc.getTitle();
            obj[3] = khoaHoc.getDepartmentID();

            dtm.addRow(obj);
        }
        return dtm;
    }

}
