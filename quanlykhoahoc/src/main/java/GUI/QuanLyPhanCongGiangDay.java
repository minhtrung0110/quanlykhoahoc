/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CourseBUS;
import BUS.CourseInstructorBUS;
import BUS.PersonBUS;
import DTO.CourseDTO;
import DTO.CourseInstructorDTO;
import DTO.PersonDTO;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class QuanLyPhanCongGiangDay extends javax.swing.JPanel {

   private int DEFALUT_WIDTH;
     private DefaultTableModel model;
     private CourseBUS courseBUS=new CourseBUS();
     private PersonBUS personBUS=new PersonBUS();
    public QuanLyPhanCongGiangDay(){
         this.setSize(1090, 750);
         initComponents();
    }
    public QuanLyPhanCongGiangDay (int width) throws Exception
    {
        DEFALUT_WIDTH = width;
        initComponents();
       this.setSize(this.DEFALUT_WIDTH - 200, 750);
       init();
      
  
    }
    private void init() throws Exception{
        ShowDataBase();
        loadComboBox();
    }
    private void loadComboBox() throws Exception{
       // loadComboBoxCourse(txCourse);
//        loadComboBoxTecher(txTeacher);
    }
     private void loadComboBoxCourse(JComboBox cmb) throws Exception
    {
       if(courseBUS.getListCourse()== null) courseBUS.loadDSCourse();
        ArrayList<CourseDTO> cs = courseBUS.getListCourse();
        for(CourseDTO a : cs){
            cmb.addItem(a.getTitle() );
        }
      
    }
     private void loadComboBoxTecher(JComboBox cmb) throws Exception
    {
       if(personBUS.getListPersonLecturers()== null) personBUS.loadDSPersonLecturers();
        ArrayList<PersonDTO> ps = personBUS.getListPersonLecturers();
        for(PersonDTO a : ps){
            cmb.addItem(a.getFirstname()+" "+a.getLastname() );
        }
      
    }
    private void ShowDataBase() throws Exception{       
        try {
            CourseInstructorBUS bus =new CourseInstructorBUS();
        if(CourseInstructorBUS.getListCourseInstructor()==null) bus.loadDSCourseInstructor();
        insertHeader();
        outModel(model,CourseInstructorBUS.getListCourseInstructor());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Không Thể Load Database ", "Thông Báo Lỗi",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void refeshData(){
         try {
         CourseInstructorBUS bus =new CourseInstructorBUS();
         bus.loadDSCourseInstructor();
        insertHeader();
        outModel(model,CourseInstructorBUS.getListCourseInstructor());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Không Thể Load Database ", "Thông Báo Lỗi",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void insertHeader(){
        Vector header = new Vector();
         header.add("STT");
        header.add("Mã Khoá Học");
         header.add("Khoá Học");
        header.add("Mã Giảng Viên");
         header.add("Tên Giảng Viên");
       
        //if (model.getRowCount()==0)
              model=new DefaultTableModel(header,0);
              
           
    }
    private void outModel(DefaultTableModel model ,ArrayList<CourseInstructorDTO> courseinstructor) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(CourseInstructorDTO cs: courseinstructor)
        {
            data = new Vector();
            data.add(cs.getID());
            data.add(cs.getCourseID());
            data.add(cs.getTitleCourse());
            data.add(cs.getPersonID());
            data.add(cs.getTeacherName());
           
            model.addRow(data);
        }
        tbCourseInstructor.setModel(model);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCourseInstructor = new javax.swing.JTable();
        pInput = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txTeacher = new javax.swing.JTextField();
        btnSelectTeacher = new javax.swing.JButton();
        txCourse = new javax.swing.JTextField();
        btnSelectCourse = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        pSearch = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSearchTeacherName = new javax.swing.JTextField();
        txtSearchTeacherID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSearchCourseName = new javax.swing.JTextField();
        txtSearchCourseID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("PHÂN CÔNG GIẢNG DẠY");

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(413, 413, 413))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        tbCourseInstructor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 0, 102), new java.awt.Color(0, 0, 0)));
        tbCourseInstructor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbCourseInstructor.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCourseInstructor.setRowHeight(22);
        tbCourseInstructor.setSelectionBackground(new java.awt.Color(255, 204, 102));
        tbCourseInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCourseInstructorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCourseInstructor);

        pInput.setBackground(new java.awt.Color(255, 255, 255));
        pInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INPUT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("KHOÁ HỌC");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("GIẢNG VIÊN");

        txTeacher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTeacherActionPerformed(evt);
            }
        });

        btnSelectTeacher.setBackground(new java.awt.Color(153, 153, 153));
        btnSelectTeacher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelectTeacher.setText("...");
        btnSelectTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectTeacherActionPerformed(evt);
            }
        });

        txCourse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSelectCourse.setBackground(new java.awt.Color(153, 153, 153));
        btnSelectCourse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelectCourse.setText("...");
        btnSelectCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectCourseActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("MÃ PHÂN CÔNG:");

        txID.setEditable(false);
        txID.setBackground(new java.awt.Color(204, 222, 236));
        txID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pInputLayout = new javax.swing.GroupLayout(pInput);
        pInput.setLayout(pInputLayout);
        pInputLayout.setHorizontalGroup(
            pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pInputLayout.createSequentialGroup()
                                .addComponent(txTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(btnSelectTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pInputLayout.createSequentialGroup()
                                .addComponent(txCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        pInputLayout.setVerticalGroup(
            pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInputLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txID, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSelectTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSelectCourse))
                    .addComponent(txTeacher))
                .addGap(25, 25, 25))
        );

        pSearch.setBackground(new java.awt.Color(255, 255, 255));
        pSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH & FILTER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("MÃ GIẢNG VIÊN");

        txtSearchTeacherName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchTeacherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchTeacherNameActionPerformed(evt);
            }
        });

        txtSearchTeacherID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("TÊN GIẢNG VIÊN");

        txtSearchCourseName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchCourseID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("MÃ KHOÁ HỌC");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("TÊN KHOÁ HỌC");

        btnSearch.setBackground(new java.awt.Color(255, 204, 0));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSearchLayout = new javax.swing.GroupLayout(pSearch);
        pSearch.setLayout(pSearchLayout);
        pSearchLayout.setHorizontalGroup(
            pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pSearchLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearchCourseID))
                        .addGap(44, 44, 44)
                        .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchTeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
            .addGroup(pSearchLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pSearchLayout.setVerticalGroup(
            pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDelete.setBackground(new java.awt.Color(153, 0, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XOÁ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 51, 204));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 153, 0));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("SỬA");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefesh.setBackground(new java.awt.Color(51, 51, 51));
        btnRefesh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefesh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefesh.setText("ReFresh");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefesh)
                        .addGap(18, 18, 18))
                    .addComponent(pInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1)))
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbCourseInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCourseInstructorMouseClicked
       int i = tbCourseInstructor.getSelectedRow();
        if(i>=0)
        {
             if(tbCourseInstructor.getRowSorter() != null)
            {
                i = tbCourseInstructor.getRowSorter().convertRowIndexToModel(i);         
            }
           txID.setText(tbCourseInstructor.getModel().getValueAt(i,0).toString());
           txCourse.setText(tbCourseInstructor.getModel().getValueAt(i, 1).toString());
           txTeacher.setText(tbCourseInstructor.getModel().getValueAt(i, 3).toString());
          
             
        }
    }//GEN-LAST:event_tbCourseInstructorMouseClicked
     private void Search(){
         DefaultTableModel temp=new DefaultTableModel();
         ArrayList<CourseInstructorDTO> search=new ArrayList<>();
        Vector header = new Vector();
         header.add("STT");
        header.add("Mã Khoá Học");
         header.add("Khoá Học");
        header.add("Mã Giảng Viên");
         header.add("Tên Giảng Viên");
       
        try {
            
            int courseID=Integer.parseInt(txtSearchCourseID.getText().equals("")?"5":txtSearchCourseID.getText());
            int teacherID=Integer.parseInt(txtSearchTeacherID.getText().equals("")?"1045":txtSearchTeacherID.getText());
            String courseTitle=txtSearchCourseName.getText().equals("")?"":txtSearchCourseName.getText();
            String teacherName=txtSearchTeacherName.getText().equals("")?"":txtSearchTeacherName.getText();
           // System.out.println(courseID+" "+teacherID+" "+courseTitle+ " "+teacherName);
            CourseInstructorBUS bus =new CourseInstructorBUS();
           search=   bus.searchCourseInstructor(courseID, courseTitle, teacherID, teacherName);
          
 
        } catch (Exception e) {
         JOptionPane.showMessageDialog(this,"Không Thể Tìm Kiếm ", e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        if(search != null && search.size() > 0) {
           // outModel(temp,search);
           if (temp.getRowCount()==0)
                    {temp=new DefaultTableModel(header,0);}
            for(int i=0;i<search.size();i++){
                 Vector row=new Vector();
                    row.add(search.get(i).getID());
                    row.add(search.get(i).getCourseID());
                    row.add(search.get(i).getTitleCourse());
                    row.add(search.get(i).getPersonID());
                    row.add(search.get(i).getTeacherName());     
                 temp.addRow(row);
            }
        }
       
        tbCourseInstructor.setModel(temp);
      
    }
    private void txtSearchTeacherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchTeacherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchTeacherNameActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            int teacherID=Integer.parseInt(txTeacher.getText());
           int courseID=Integer.parseInt(txCourse.getText());
            CourseInstructorBUS bus=new CourseInstructorBUS();
            bus.deleteCourseInstructor(courseID, teacherID);
            refeshData();
       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Can't delete CourseInstructor ", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        try{
            CourseInstructorDTO csin =new CourseInstructorDTO();
            csin.setCourseID((int)Integer.parseInt(txCourse.getText()));
            csin.setPersonID((int)Integer.parseInt(txTeacher.getText()));
           // System.out.println('Bat loi:'+);
            CourseInstructorBUS bus=new CourseInstructorBUS();
            bus.addCourseInstructor(csin);
            refeshData();
       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Can't create CourseInstructor ", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       try{
           int id=Integer.parseInt(txID.getText());
           int teacherID=Integer.parseInt(txTeacher.getText());
           int courseID=Integer.parseInt(txCourse.getText());
            CourseInstructorDTO csin =new CourseInstructorDTO();
            csin.setCourseID((int)courseID);
            csin.setPersonID((int)teacherID);
           // System.out.println('Bat loi:'+);
            CourseInstructorBUS bus=new CourseInstructorBUS();
            bus.updateCourseInstructor(id, csin);
            refeshData();
       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Can't update CourseInstructor ", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSelectTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectTeacherActionPerformed
       JPFormPerson tbps;
       try {
           tbps = new JPFormPerson();     
       int personID = tbps.getPersonID(); 
       txTeacher.setText(String.valueOf(personID));
       } catch (Exception ex) {
           Logger.getLogger(QuanLyPhanCongGiangDay.class.getName()).log(Level.SEVERE, null, ex);
       }
      
    }//GEN-LAST:event_btnSelectTeacherActionPerformed

    private void btnSelectCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectCourseActionPerformed
        JPFormCourse tbcs;
       try {
           tbcs = new JPFormCourse();     
       int courseID=tbcs.getCourseID();
       txCourse.setText(String.valueOf(courseID));
       } catch (Exception ex) {
           Logger.getLogger(QuanLyPhanCongGiangDay.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnSelectCourseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            Search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
       refeshData();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void txTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTeacherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelectCourse;
    private javax.swing.JButton btnSelectTeacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pInput;
    private javax.swing.JPanel pSearch;
    private javax.swing.JTable tbCourseInstructor;
    private javax.swing.JTextField txCourse;
    private javax.swing.JTextField txID;
    private javax.swing.JTextField txTeacher;
    private javax.swing.JTextField txtSearchCourseID;
    private javax.swing.JTextField txtSearchCourseName;
    private javax.swing.JTextField txtSearchTeacherID;
    private javax.swing.JTextField txtSearchTeacherName;
    // End of variables declaration//GEN-END:variables
}