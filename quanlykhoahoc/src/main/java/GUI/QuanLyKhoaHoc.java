/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import DTO.Course;
import DTO.CourseOnline;
import DTO.CourseOnsite;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class QuanLyKhoaHoc extends javax.swing.JPanel {

     private int DEFALUT_WIDTH;
    private DefaultTableModel model;
    CourseBLL bll = new CourseBLL();
    public QuanLyKhoaHoc() {
         this.setSize(1090, 750);
        initComponents();
    }
    public QuanLyKhoaHoc(int width) throws Exception {
          DEFALUT_WIDTH = width;
        initComponents();
        this.setSize(this.DEFALUT_WIDTH - 200, 750);
        init();
    }
     private void init() throws Exception {
        ShowDataBase("ASC");
    }

    private void clearInput() {
       // txID.setText("");
       // txCourse.setText("");
        //txTeacher.setText("");
    }

    private void ShowDataBase(String orderby) throws Exception {
        try {
            if (CourseBLL.getListCourse() == null) {
                bll.loadDSCourse(orderby);
            }
            insertHeader();
            outModel(model, CourseBLL.getListCourse());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không Thể Load Database ",
                    "Thông Báo Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

  
    private void insertHeader() {
        Vector header = new Vector();
        header.add("Mã Khoá Học");
        header.add("Tên ");
        header.add("Giá");
        header.add("Phòng");
        header.add("URL");
        header.add("Địa điểm");
        header.add("Ngày");
        header.add("Giờ");

        //if (model.getRowCount()==0)
        model = new DefaultTableModel(header, 0);

    }

    private void outModel(DefaultTableModel model, ArrayList<Course> course) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (Course cs : course) {
            data = new Vector();
            data.add(cs.getCourseID());
            data.add(cs.getTitle());
            data.add(cs.getCredits());
            data.add(cs.getDepartmentID());
            data.add( (cs instanceof CourseOnline)?((CourseOnline) cs).getUrl():null);
            data.add( (cs instanceof CourseOnsite)?((CourseOnsite) cs).getLocation():null);
            data.add( (cs instanceof CourseOnsite)?((CourseOnsite) cs).getDays():null);
            data.add( (cs instanceof CourseOnsite)?((CourseOnsite) cs).getTime():null);
          
            model.addRow(data);
        }
        tbCourse.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHOÁ HỌC");

        tbCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbCourse);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(461, 461, 461))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCourse;
    // End of variables declaration//GEN-END:variables
}
