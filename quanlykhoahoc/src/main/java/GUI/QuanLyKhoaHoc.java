/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import BLL.DepartmentBLL;
import BLL.GradeBLL;
import DTO.Course;
import DTO.CourseOnline;
import DTO.CourseOnsite;
import DTO.Department;
import DTO.GradeDTO;
import DTO.CourseInstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vonhu
 */
public class QuanLyKhoaHoc extends javax.swing.JPanel {

    private int DEFALUT_WIDTH;
    private DefaultTableModel model;
    CourseBLL bll = new CourseBLL();
    DepartmentBLL dll = new DepartmentBLL();
    GradeBLL gll = new GradeBLL();
    CourseInstructorBLL cill = new CourseInstructorBLL();

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
        loadDepartmentID(cbDepartment);
    }

    private void clearInput() {
        txtCourseId.setText(bll.remindMaKH());
        txtTitle.setText("");
        txtCredits.setText("");
        cbDepartment.setSelectedItem("");
        txtDate.setText("");
        txtTime.setText("");
        txtLocation.setText("");
        txtUrl.setText("");
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

    public void loadDepartmentID(JComboBox cb) throws Exception {
        if (dll.getListDepartment() == null) {
            dll.loadDepartment();
        }
        ArrayList<Department> departmentList = dll.getListDepartment();
        for (Department d : departmentList) {
            cb.addItem(d.getDepartmentID());
        }
    }

    private void RefreshDataBase(String orderby) throws Exception {
        try {
            bll.loadDSCourse(orderby);
            insertHeader();
            outModel(model, CourseBLL.getListCourse());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không Thể Load Database ",
                    "Thông Báo Lỗi", JOptionPane.ERROR_MESSAGE);
        }

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
            data.add((cs instanceof CourseOnline) ? ((CourseOnline) cs).getUrl() : null);
            data.add((cs instanceof CourseOnsite) ? ((CourseOnsite) cs).getLocation() : null);
            data.add((cs instanceof CourseOnsite) ? ((CourseOnsite) cs).getDays() : null);
            data.add((cs instanceof CourseOnsite) ? ((CourseOnsite) cs).getTime() : null);

            model.addRow(data);
        }
        tbCourse.setModel(model);
    }

    private void Search() {
        DefaultTableModel temp = new DefaultTableModel();
        ArrayList<Course> search = new ArrayList<>();
        Vector header = new Vector();
        header.add("Mã Khoá Học");
        header.add("Tên ");
        header.add("Giá");
        header.add("Phòng");
        header.add("URL");
        header.add("Địa điểm");
        header.add("Ngày");
        header.add("Giờ");
        String optionSearch = cbSelectSearch.getSelectedItem().toString();

        try {
            if (!txtSearch.getText().isEmpty()) {
                String inputSearch = txtSearch.getText();

                switch (optionSearch) {
                    case "Mã Khoá Học":
                        search = bll.searchCourseWithID(Integer.parseInt(inputSearch));
                        break;
                    case "Tên Khóa Học":
                        search = bll.searchCourseWithTitle(inputSearch);
                        break;
                    case "Số Phòng":
                        search = bll.searchCourseWithDepartmentID(Integer.parseInt(inputSearch));
                        break;
                    default:
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện tìm ",
                        "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không Thể Tìm Kiếm ",
                    "Thông Báo Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        if (search != null && search.size() > 0) {
            if (temp.getRowCount() == 0) {
                temp = new DefaultTableModel(header, 0);
            }
            for (int i = 0; i < search.size(); i++) {
                Vector row = new Vector();
                row.add(search.get(i).getCourseID());
                row.add(search.get(i).getTitle());
                row.add(search.get(i).getCredits());
                row.add(search.get(i).getDepartmentID());
//                row.add(search.get(i));
                temp.addRow(row);
            }
            tbCourse.setModel(temp);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pInput4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCourseId = new javax.swing.JTextField();
        txtCredits = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        cbDepartment = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOnline = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnOnsite = new javax.swing.JButton();
        pSearch = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbSelectSearch = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel17 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        pInput4.setBackground(new java.awt.Color(255, 255, 255));
        pInput4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 3, true));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("GIÁ");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("MÃ KHÓA HỌC");

        txtCourseId.setEditable(false);
        txtCourseId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseIdActionPerformed(evt);
            }
        });

        txtCredits.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditsActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("NGÀY");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("PHÒNG");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("TÊN KHÓA HỌC");

        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("GIỜ");

        txtTime.setEditable(false);
        txtTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTime.setText("00:00:00");
        txtTime.setName(""); // NOI18N
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("ĐỊA ĐIỂM");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("URL");

        txtUrl.setEditable(false);
        txtUrl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });

        txtLocation.setEditable(false);
        txtLocation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationActionPerformed(evt);
            }
        });

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDate.setText("MTWThF");
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pInput4Layout = new javax.swing.GroupLayout(pInput4);
        pInput4.setLayout(pInput4Layout);
        pInput4Layout.setHorizontalGroup(
            pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInput4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pInput4Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInput4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInput4Layout.createSequentialGroup()
                        .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCredits, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUrl)
                        .addComponent(txtTime)
                        .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        pInput4Layout.setVerticalGroup(
            pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pInput4Layout.createSequentialGroup()
                .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pInput4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTitle)
                        .addGap(18, 18, 18)
                        .addComponent(cbDepartment)
                        .addGap(22, 22, 22)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInput4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pInput4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCourseId)))
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCredits)
                            .addComponent(jLabel20))
                        .addGap(23, 23, 23)
                        .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pInput4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(txtLocation))
                            .addComponent(jLabel23))))
                .addGap(31, 31, 31))
        );

        btnRefesh.setBackground(new java.awt.Color(51, 51, 51));
        btnRefesh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefesh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefesh.setText("ReFresh");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
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

        btnDelete.setBackground(new java.awt.Color(153, 0, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XOÁ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOnline.setBackground(new java.awt.Color(255, 102, 102));
        btnOnline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOnline.setForeground(new java.awt.Color(255, 255, 255));
        btnOnline.setText("ONLINE");
        btnOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnlineActionPerformed(evt);
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

        btnOnsite.setBackground(new java.awt.Color(102, 102, 255));
        btnOnsite.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOnsite.setForeground(new java.awt.Color(255, 255, 255));
        btnOnsite.setText("ONSITE");
        btnOnsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnsiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOnline, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOnline)
                    .addComponent(btnOnsite))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnOnline, btnOnsite, btnRefesh});

        pSearch.setBackground(new java.awt.Color(255, 255, 255));
        pSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH & FILTER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("CHỌN ĐIỀU KIỆN:");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(255, 204, 0));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbSelectSearch.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbSelectSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Khoá Học", "Tên Khóa Học", "Số Phòng" }));
        cbSelectSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSelectSearchActionPerformed(evt);
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
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addComponent(cbSelectSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );
        pSearchLayout.setVerticalGroup(
            pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSelectSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbCourse.setAutoCreateRowSorter(true);
        tbCourse.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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
        tbCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCourse);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pInput4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("QUẢN LÝ KHÓA HỌC");

        jLayeredPane1.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(413, 413, 413))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        try {
            RefreshDataBase("ASC");
            clearInput();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyKhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int CourseID = Integer.parseInt(txtCourseId.getText());
        int DepartmentID = Integer.parseInt(cbDepartment.getSelectedItem().toString());
        int Credits = Integer.parseInt(txtCredits.getText());
        String Title = txtTitle.getText();
        String Url = txtUrl.getText();
        String Location = txtLocation.getText();
        String Days = txtDate.getText();
        String Time = txtTime.getText();

        try {
            if (!txtUrl.getText().isEmpty()) {
                Course courseOnline = new CourseOnline(CourseID, Title, Credits, DepartmentID, Url);

                bll.updateCourse(CourseID, courseOnline);
            } else {
                Course courseOnsite = new CourseOnsite(CourseID, Title, Credits, DepartmentID, Location, Days, Time);

                bll.updateCourse(CourseID, courseOnsite);// gọi Layer Bll Thêm khóa học
            }

            clearInput();
            RefreshDataBase("DESC");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không thể cập nhật CourseInstructor ",
                    "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        int CourseID = Integer.parseInt(txtCourseId.getText());
        int DepartmentID = Integer.parseInt(cbDepartment.getSelectedItem().toString());
        int Credits = Integer.parseInt(txtCredits.getText());
        String Title = txtTitle.getText();
        String Url = txtUrl.getText();
        String Location = txtLocation.getText();
        String Days = txtDate.getText().toString();
        String Time = txtTime.getText();

        try {
            if (!txtUrl.getText().isEmpty()) {
                Course courseOnline = new CourseOnline(CourseID, Title, Credits, DepartmentID, Url);

                bll.addCourse(courseOnline);
            } else {
                Course courseOnsite = new CourseOnsite(CourseID, Title, Credits, DepartmentID, Location, Days, Time);

                bll.addCourse(courseOnsite);// gọi Layer Bll Thêm khóa học
            }

            clearInput();
            RefreshDataBase("DESC");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không thể tạo phân công giảng dạy ",
                    "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        ArrayList<GradeDTO> gradeList = new ArrayList<>();
        ArrayList<CourseInstructor> courseIntructorList = new ArrayList<>();

        int confirm = JOptionPane.showConfirmDialog(null, "Bạn Thực Sự Muốn Xóa Khóa Học Này ?",
                "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (confirm == 0)
        try {
            int courseID = Integer.parseInt(txtCourseId.getText());


            gll.loadDSGrade();
            cill.loadDSCourseInstructor("ASC");
            gradeList = gll.searchGradeWithCourseID(courseID);
            courseIntructorList = cill.searchCourseID(courseID);

            if (!gradeList.isEmpty() || !courseIntructorList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Khóa Học này đang có lịch học hoặc đang được phân công",
                        "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                bll.deleteCourse(courseID);//gọi Layer BLL xoá 
            }

            insertHeader();// chèn header cho table
            outModel(model, CourseBLL.getListCourse());// đổ data vào table
            clearInput();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không thể xoá Khóa Học này ",
                    "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        } else
            return;
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditsActionPerformed

    private void txtCourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DefaultTableModel temp = new DefaultTableModel();
        ArrayList<Course> search = new ArrayList<>();
        Vector header = new Vector();
        header.add("Mã Khoá Học");
        header.add("Tên ");
        header.add("Giá");
        header.add("Phòng");
        header.add("URL");
        header.add("Địa điểm");
        header.add("Ngày");
        header.add("Giờ");
        String optionSearch = cbSelectSearch.getSelectedItem().toString();
        try {
            if (!txtSearch.getText().isEmpty()) {
                String inputSearch = txtSearch.getText();
                switch (optionSearch) {
                    case "Mã Khoá Học":
                        search = bll.searchCourseWithID(Integer.parseInt(inputSearch));
                        break;
                    case "Tên Khoá Học":
                        search = bll.searchCourseWithTitle(inputSearch);
                        break;
                    case "Số Phòng":
                        search = bll.searchCourseWithDepartmentID(Integer.parseInt(inputSearch));
                        break;
                    default:
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện tìm ",
                        "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không Thể Tìm Kiếm ",
                    "Thông Báo Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        if (search != null && search.size() > 0) {
            if (temp.getRowCount() == 0) {
                temp = new DefaultTableModel(header, 0);
            }
            for (int i = 0; i < search.size(); i++) {
                Vector row = new Vector();
                row.add(search.get(i).getCourseID());
                row.add(search.get(i).getTitle());
                row.add(search.get(i).getCredits());
                row.add(search.get(i).getDepartmentID());
//                row.add(search.get(i).get());
                temp.addRow(row);
            }
            tbCourse.setModel(temp);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbSelectSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSelectSearchActionPerformed

    private void tbCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCourseMouseClicked
        int i = tbCourse.getSelectedRow();
        clearInput();
        if (i >= 0) {
            if (tbCourse.getRowSorter() != null) {
                i = tbCourse.getRowSorter().convertRowIndexToModel(i);
            }

            txtCourseId.setText(tbCourse.getModel().getValueAt(i, 0).toString());
            txtTitle.setText(tbCourse.getModel().getValueAt(i, 1).toString());
            txtCredits.setText(tbCourse.getModel().getValueAt(i, 2).toString());
            cbDepartment.setSelectedItem(tbCourse.getModel().getValueAt(i, 3));
            if (tbCourse.getModel().getValueAt(i, 4) == null) {
                txtLocation.setText(tbCourse.getModel().getValueAt(i, 5).toString());
                txtDate.setText(tbCourse.getModel().getValueAt(i, 6).toString());
                txtTime.setText(tbCourse.getModel().getValueAt(i, 7).toString());
            } else {
                txtUrl.setText(tbCourse.getModel().getValueAt(i, 4).toString());
            }
        }
    }//GEN-LAST:event_tbCourseMouseClicked

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrlActionPerformed

    private void btnOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnlineActionPerformed
        clearInput();
        txtDate.setEditable(false);
        txtTime.setEditable(false);
        txtLocation.setEditable(false);
        txtUrl.setEditable(true);
    }//GEN-LAST:event_btnOnlineActionPerformed

    private void btnOnsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnsiteActionPerformed
        clearInput();
        txtDate.setEditable(true);
        txtTime.setEditable(true);
        txtLocation.setEditable(true);
        txtUrl.setEditable(false);
    }//GEN-LAST:event_btnOnsiteActionPerformed

    private void txtLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOnline;
    private javax.swing.JButton btnOnsite;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JComboBox<String> cbSelectSearch;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pInput4;
    private javax.swing.JPanel pSearch;
    private javax.swing.JTable tbCourse;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
