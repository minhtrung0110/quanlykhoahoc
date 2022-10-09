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



import DAL.KhoaHocService;
import DAL.KhoaHocServiceImpl;
import DTO.Course;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class KhoaHocController {
    
    private  JButton btnSubmit;
    private  JTextField jtfTenKhoaHoc;
    private  JTextField jtfMaPhong;
    private  JLabel jlbMsg;
    private  JButton btnDelete;

    private Course khoaHoc = null;

    private KhoaHocService khoaHocService = null;

    public KhoaHocController(JButton btnSubmit , JTextField jtfTenKhoaHoc, JTextField jtfMaPhong, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfTenKhoaHoc = jtfTenKhoaHoc;
        this.jtfMaPhong = jtfMaPhong;
        this.jlbMsg = jlbMsg;    
        this.btnDelete=null;
        this.khoaHocService = new KhoaHocServiceImpl();
    }
    
    public KhoaHocController(JButton btnSubmit,JButton btnDelete  , JTextField jtfTenKhoaHoc, JTextField jtfMaPhong, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfTenKhoaHoc = jtfTenKhoaHoc;
        this.jtfMaPhong = jtfMaPhong;
        this.jlbMsg = jlbMsg;
        this.btnDelete=btnDelete;
        this.khoaHocService = new KhoaHocServiceImpl();
    }

    public void setView(Course khoaHoc) {
        this.khoaHoc = khoaHoc;
        // set data
        jtfTenKhoaHoc.setText(khoaHoc.getTitle());
        jtfMaPhong.setText(String.valueOf(khoaHoc.getDepartmentID()));
        // set event
        if(this.khoaHoc!=null){
            setEvent(this.khoaHoc);
        }
        else{
            System.out.print("abc");
        }
        
    }

    public void setEvent(Course course) {
        if(btnDelete!=null){
            btnDelete.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                        khoaHoc.setCourseID(course.CourseID);
                        khoaHoc.setTitle(jtfTenKhoaHoc.getText().trim());
                        khoaHoc.setDepartmentID(Integer.parseInt(jtfMaPhong.getText()));
                            if (showDialog()) {
                            int done =khoaHocService.delete(khoaHoc);
                            if (done == 1) {
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có vẻ khóa học đã có dữ liệu!!");
                            }
                        }
                    
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                btnDelete.setBackground(new Color(0,0,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                btnDelete.setBackground(new Color(102,102,255));
            }
        
        });
        
        
        }
        
        
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        khoaHoc.setTitle(jtfTenKhoaHoc.getText().trim());
                        khoaHoc.setDepartmentID(Integer.parseInt(jtfMaPhong.getText()));
                            if (showDialog()) {
                            int lastId =khoaHocService.createOrUpdate(khoaHoc);
                            if (lastId != 0) {
                                khoaHoc.setCourseID(lastId);
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
                    
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0,0,255));
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(102,102,255));
                
            }
        });
    }

    private boolean checkNotNull() {
        return jtfTenKhoaHoc.getText() != null && !jtfTenKhoaHoc.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}