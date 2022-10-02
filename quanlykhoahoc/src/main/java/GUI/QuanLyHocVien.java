/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.PersonBUS;
import DTO.PersonDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nguye
 */
public class QuanLyHocVien extends javax.swing.JPanel {

   private int DEFALUT_WIDTH;   
   private PersonBUS personBUS=new PersonBUS();
   DefaultTableModel model;
   static ArrayList<PersonDTO> listLecturers = new PersonBUS().getListPerson();
   String formatTime = "yyyy-MM-dd     ";
   DateFormat fm = new SimpleDateFormat(formatTime);
     public QuanLyHocVien(){
         this.setSize(1090, 750);
         initComponents();
    }
    public QuanLyHocVien (int width) throws Exception
    {
        DEFALUT_WIDTH = width;
        initComponents();
       this.setSize(this.DEFALUT_WIDTH - 200, 750);
      init();
  
    }
     private void init() throws Exception{
        ShowStudent();
//        Show dialog
        add_Student.pack();
        add_Student.setLocationRelativeTo(null);
        edit_Student.pack();
        edit_Student.setLocationRelativeTo(null);
    }
    private void ShowStudent() throws Exception{       
       
        
        try {
             PersonBUS bus =new PersonBUS();
        if(PersonBUS.getListPersonStudent()==null) bus.loadDSPersonStudent();
        insertHeader();
        outModel(model,PersonBUS.getListPersonStudent());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Không Thể Load Database ", "Thông Báo Lỗi",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void insertHeader(){
        Vector header = new Vector();
        header.add("STT");
        header.add("Mã học viên");
        header.add("Họ");
        header.add("Tên");
        header.add("Ngày đăng ký");

       
        //if (model.getRowCount()==0)
              model=new DefaultTableModel(header,0);
             
                   
    }
      private void outModel(DefaultTableModel model,ArrayList<PersonDTO> personDTO ) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
          
        int i=1;
        for(PersonDTO cs: personDTO)
        {
            data = new Vector();
            data.add(i);
            data.add(cs.getPersonID());     
            data.add(cs.getFirstname());
            data.add(cs.getLastname());
            data.add(fm.format(cs.getEnrollmentDate()));
           
            model.addRow(data);
            i++;
        }
        tbl_hocvien.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_Student = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        txPositionError2 = new javax.swing.JLabel();
        btnSaveHV = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        lbAddNV5 = new javax.swing.JLabel();
        btnExitThemHV = new javax.swing.JButton();
        btnDelHV = new javax.swing.JButton();
        txtId_Student = new javax.swing.JTextField();
        txtLastNameHV = new javax.swing.JTextField();
        txtFirstNameHV = new javax.swing.JTextField();
        txtEnrollmentDateHV = new com.toedter.calendar.JDateChooser();
        edit_Student = new javax.swing.JDialog();
        jPanel24 = new javax.swing.JPanel();
        txPositionError3 = new javax.swing.JLabel();
        btnSaveEditStudent = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        lbAddNV6 = new javax.swing.JLabel();
        btnExitEditHV = new javax.swing.JButton();
        txtEditId_Student = new javax.swing.JTextField();
        txtEditLastNameHV = new javax.swing.JTextField();
        txtEditFirstNameHV = new javax.swing.JTextField();
        txtEditEnrollmentDateHV = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hocvien = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        txFind_HV = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        btn_editstudent = new javax.swing.JButton();
        btn_deletestudent = new javax.swing.JButton();
        btn_addstudent = new javax.swing.JButton();

        add_Student.setUndecorated(true);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));

        btnSaveHV.setText("Lưu");
        btnSaveHV.setMinimumSize(new java.awt.Dimension(60, 30));
        btnSaveHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHVActionPerformed(evt);
            }
        });

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));

        lbAddNV5.setBackground(new java.awt.Color(0, 0, 0));
        lbAddNV5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbAddNV5.setForeground(new java.awt.Color(255, 255, 255));
        lbAddNV5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAddNV5.setText("Thêm Học viên");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddNV5, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddNV5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        btnExitThemHV.setText("Hủy");
        btnExitThemHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitThemHVActionPerformed(evt);
            }
        });

        btnDelHV.setText("Xóa hết");
        btnDelHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelHVActionPerformed(evt);
            }
        });

        txtId_Student.setEditable(false);
        txtId_Student.setBackground(new java.awt.Color(255, 255, 255));
        txtId_Student.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Học viên"));
        txtId_Student.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtId_Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_StudentActionPerformed(evt);
            }
        });

        txtLastNameHV.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên Học viên"));

        txtFirstNameHV.setBorder(javax.swing.BorderFactory.createTitledBorder("Họ Học viên"));

        txtEnrollmentDateHV.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày Đăng ký"));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(btnSaveHV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnDelHV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txPositionError2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExitThemHV, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(txtFirstNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                        .addComponent(txtLastNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtId_Student)
                                    .addComponent(txtEnrollmentDateHV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtId_Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(txtEnrollmentDateHV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPositionError2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSaveHV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelHV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExitThemHV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout add_StudentLayout = new javax.swing.GroupLayout(add_Student.getContentPane());
        add_Student.getContentPane().setLayout(add_StudentLayout);
        add_StudentLayout.setHorizontalGroup(
            add_StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        add_StudentLayout.setVerticalGroup(
            add_StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        edit_Student.setUndecorated(true);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));

        btnSaveEditStudent.setText("Lưu");
        btnSaveEditStudent.setMinimumSize(new java.awt.Dimension(60, 30));
        btnSaveEditStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditStudentActionPerformed(evt);
            }
        });

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));

        lbAddNV6.setBackground(new java.awt.Color(0, 0, 0));
        lbAddNV6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbAddNV6.setForeground(new java.awt.Color(255, 255, 255));
        lbAddNV6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAddNV6.setText("Sửa Học viên");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddNV6, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddNV6, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        btnExitEditHV.setText("Hủy");
        btnExitEditHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitEditHVActionPerformed(evt);
            }
        });

        txtEditId_Student.setEditable(false);
        txtEditId_Student.setBackground(new java.awt.Color(255, 255, 255));
        txtEditId_Student.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Học viên"));
        txtEditId_Student.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtEditId_Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditId_StudentActionPerformed(evt);
            }
        });

        txtEditLastNameHV.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên Học viên"));

        txtEditFirstNameHV.setBorder(javax.swing.BorderFactory.createTitledBorder("Họ Học viên"));

        txtEditEnrollmentDateHV.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày đăng ký"));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnSaveEditStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txPositionError3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExitEditHV, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addComponent(txtEditFirstNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                        .addComponent(txtEditLastNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEditId_Student)
                                    .addComponent(txtEditEnrollmentDateHV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEditId_Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditFirstNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditLastNameHV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(txtEditEnrollmentDateHV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPositionError3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveEditStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitEditHV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout edit_StudentLayout = new javax.swing.GroupLayout(edit_Student.getContentPane());
        edit_Student.getContentPane().setLayout(edit_StudentLayout);
        edit_StudentLayout.setHorizontalGroup(
            edit_StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        edit_StudentLayout.setVerticalGroup(
            edit_StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1023, 466));

        tbl_hocvien.setAutoCreateRowSorter(true);
        tbl_hocvien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 0, 102), new java.awt.Color(0, 0, 0)));
        tbl_hocvien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbl_hocvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_hocvien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_hocvien.setName(""); // NOI18N
        tbl_hocvien.setRowHeight(40);
        tbl_hocvien.setRowMargin(5);
        tbl_hocvien.setSelectionBackground(new java.awt.Color(255, 204, 51));
        jScrollPane1.setViewportView(tbl_hocvien);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txFind_HV.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txFind_HV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txFind_HVKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txFind_HV, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(txFind_HV, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLayeredPane1.setBackground(new java.awt.Color(0, 153, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("QUẢN LÝ HỌC VIÊN");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(442, 442, 442))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btn_editstudent.setBackground(new java.awt.Color(0, 204, 0));
        btn_editstudent.setForeground(new java.awt.Color(255, 255, 255));
        btn_editstudent.setText("SỬA");
        btn_editstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editstudentActionPerformed(evt);
            }
        });

        btn_deletestudent.setBackground(new java.awt.Color(255, 51, 51));
        btn_deletestudent.setForeground(new java.awt.Color(255, 255, 255));
        btn_deletestudent.setText("XÓA");
        btn_deletestudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletestudentActionPerformed(evt);
            }
        });

        btn_addstudent.setBackground(new java.awt.Color(51, 0, 204));
        btn_addstudent.setForeground(new java.awt.Color(255, 255, 255));
        btn_addstudent.setText("THÊM");
        btn_addstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addstudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLayeredPane1)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_addstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_editstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_deletestudent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btn_addstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_editstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_deletestudent, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txFind_HVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFind_HVKeyPressed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tbl_hocvien.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txFind_HV.getText().trim()));
    }//GEN-LAST:event_txFind_HVKeyPressed

    private void btn_editstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editstudentActionPerformed
        // TODO add your handling code here:
        int i = tbl_hocvien.getSelectedRow();
        //           System.out.println((Date) tbl_giangvien.getValueAt(i, 4));
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa");
        } else {
            txtEditId_Student.setText(String.valueOf(tbl_hocvien.getValueAt(i, 1)));
            txtEditFirstNameHV.setText(String.valueOf(tbl_hocvien.getValueAt(i, 2)));
            txtEditLastNameHV.setText(String.valueOf(tbl_hocvien.getValueAt(i, 3)));

            String date = (String) tbl_hocvien.getValueAt(i, 4);

            try {
                txtEditEnrollmentDateHV.setDate((Date) fm.parse(date));
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
            }

            edit_Student.setVisible(true);

        }
    }//GEN-LAST:event_btn_editstudentActionPerformed

    private void btn_deletestudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletestudentActionPerformed
        // TODO add your handling code here:
        int i = tbl_hocvien.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa");

        } else if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa học viên này? ", "Confirm",
            JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == JOptionPane.YES_OPTION){
        int select = (int) tbl_hocvien.getModel().getValueAt(i, 1);

        PersonDTO studentDTO = new PersonDTO();
        PersonBUS studentBUS =new PersonBUS();
        studentDTO.setPersonID(select);
        try {
     
            studentBUS.deleteStudent(studentDTO.getPersonID());
            showMessageDialog(null, "Xóa thành công");
            studentBUS.loadDSPersonStudent();
            ShowStudent();
        } catch (Exception e) {
            showMessageDialog(null, "Xóa thất bại");
        }

        }
    }//GEN-LAST:event_btn_deletestudentActionPerformed

    private void btn_addstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addstudentActionPerformed
        // TODO add your handling code here:
        String idPerson;
        try {
            idPerson = String.valueOf(personBUS.getALLPerson().get(personBUS.getALLPerson().size() - 1).getPersonID()+ 1);
            txtId_Student.setText(idPerson);
            add_Student.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_addstudentActionPerformed

    private void btnSaveHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHVActionPerformed
        // TODO add your handling code here:

        try {

            PersonDTO studentDTO = new PersonDTO();
            PersonBUS studentBUS =new PersonBUS();

            if (txtId_Student.getText().length() != 0 && txtEnrollmentDateHV.getDate()!= null && txtLastNameHV.getText().length() != 0
                && txtFirstNameHV.getText().length() != 0 )//xem thử đã nhập hay chưa(textflied)
            {
                studentDTO.setPersonID(Integer.valueOf(txtId_Student.getText()));
                studentDTO.setFirstname(txtFirstNameHV.getText());
                studentDTO.setLastname(txtLastNameHV.getText());
                studentDTO.setEnrollmentDate(txtEnrollmentDateHV.getDate());
                studentBUS.addStudent(studentDTO);
                studentBUS.loadDSPersonStudent();
                 JOptionPane.showMessageDialog(null, "Thêm học viên thành công !");
                add_Student.dispose();
                ShowStudent();
                txtFirstNameHV.setText("");
                txtLastNameHV.setText("");
                txtEnrollmentDateHV.setDate(null);

            } else {
                JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveHVActionPerformed

    private void btnExitThemHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitThemHVActionPerformed
        // TODO add your handling code here:
        txtFirstNameHV.setText("");
        txtLastNameHV.setText("");
        txtEnrollmentDateHV.setDate(null);
        add_Student.dispose();
    }//GEN-LAST:event_btnExitThemHVActionPerformed

    private void btnDelHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelHVActionPerformed
        // TODO add your handling code here:
        txtFirstNameHV.setText("");
        txtLastNameHV.setText("");
        txtEnrollmentDateHV.setDate(null);
    }//GEN-LAST:event_btnDelHVActionPerformed

    private void txtId_StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_StudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_StudentActionPerformed

    private void btnSaveEditStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditStudentActionPerformed
        // TODO add your handling code here:
        try {

            PersonDTO studentDTO = new PersonDTO();
            PersonBUS studentBUS =new PersonBUS();

            if (txtEditId_Student.getText().length() != 0 && txtEditEnrollmentDateHV.getDate()!= null && txtEditLastNameHV.getText().length() != 0
                && txtEditFirstNameHV.getText().length() != 0 )//xem thử đã nhập hay chưa(textflied)
            {
                studentDTO.setPersonID(Integer.valueOf(txtEditId_Student.getText()));
                studentDTO.setFirstname(txtEditFirstNameHV.getText());
                studentDTO.setLastname(txtEditLastNameHV.getText());
                studentDTO.setEnrollmentDate(txtEditEnrollmentDateHV.getDate());
                studentBUS.editStudent(studentDTO);
                studentBUS.loadDSPersonStudent();
                JOptionPane.showMessageDialog(null, "Sửa học viên thành công !");
                edit_Student.dispose();
                ShowStudent();

            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveEditStudentActionPerformed

    private void btnExitEditHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitEditHVActionPerformed
        // TODO add your handling code here:
        edit_Student.dispose();
    }//GEN-LAST:event_btnExitEditHVActionPerformed

    private void txtEditId_StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditId_StudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditId_StudentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog add_Student;
    private javax.swing.JButton btnDelHV;
    private javax.swing.JButton btnExitEditHV;
    private javax.swing.JButton btnExitThemHV;
    private javax.swing.JButton btnSaveEditStudent;
    private javax.swing.JButton btnSaveHV;
    private javax.swing.JButton btn_addstudent;
    private javax.swing.JButton btn_deletestudent;
    private javax.swing.JButton btn_editstudent;
    private javax.swing.JDialog edit_Student;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAddNV5;
    private javax.swing.JLabel lbAddNV6;
    private javax.swing.JTable tbl_hocvien;
    private javax.swing.JTextField txFind_HV;
    private javax.swing.JLabel txPositionError2;
    private javax.swing.JLabel txPositionError3;
    private com.toedter.calendar.JDateChooser txtEditEnrollmentDateHV;
    private javax.swing.JTextField txtEditFirstNameHV;
    private javax.swing.JTextField txtEditId_Student;
    private javax.swing.JTextField txtEditLastNameHV;
    private com.toedter.calendar.JDateChooser txtEnrollmentDateHV;
    private javax.swing.JTextField txtFirstNameHV;
    private javax.swing.JTextField txtId_Student;
    private javax.swing.JTextField txtLastNameHV;
    // End of variables declaration//GEN-END:variables
}
