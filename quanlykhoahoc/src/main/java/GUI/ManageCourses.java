/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.model.header;
import GUI.model.navItem;
import GUI.QuanLyKetQuaKhoaHoc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author nguye
 */
public class ManageCourses extends JFrame implements MouseListener{
     
    private boolean flag = true;
    private JPanel header,nav,main;
    private int DEFAULT_HEIGHT = 800,DEFALUT_WIDTH = 1280 ;
    private ArrayList<String> navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm
    private ArrayList<navItem> navObj = new ArrayList<>();  //Chứa cái button trên thanh menu
    public  ManageCourses() throws Exception{
         
 
        Toolkit screen = Toolkit.getDefaultToolkit();
        init();
         
    }
    
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                   ManageCourses app=new ManageCourses();
                   app.setVisible(true);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ManageCourses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void init() throws Exception
    {
        Font font = new Font("Segoe UI",Font.BOLD,14);
        setTitle("Quản Lý Khoá Học ");
        ImageIcon logo = new ImageIcon("./src/main/java/img/icons8-course-64.png");
        setIconImage(logo.getImage());
        setLayout(new BorderLayout());
        setSize(DEFALUT_WIDTH,DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        //setShape(new RoundRectangle2D.Double(0, 0, DEFALUT_WIDTH, DEFAULT_HEIGHT, 30, 30)); //Bo khung Frame
        
/************ PHẦN HEADER *************************************/      
        header = new JPanel(null);
        header.setBackground(new Color(27, 27, 30));
        header.setPreferredSize(new Dimension(DEFALUT_WIDTH,40));
        
        header hmain = new header(DEFALUT_WIDTH,40);
        
      
        //Tạo btn EXIT & MINIMIZE
        navItem exit = new navItem("", new Rectangle(DEFALUT_WIDTH-50, -8, 50, 50), "exit_25px.png", "exit_25px.png", "exit_hover_25px.png", new Color(240, 71, 74));
        navItem minimize = new navItem("", new Rectangle(DEFALUT_WIDTH-100, -8, 50, 50), "minimize_25px.png", "minimize_25px.png", "minimize_hover_25px.png" ,new Color(80,80,80));
        
        hmain.add(exit.isButton());
        hmain.add(minimize.isButton());
        
        exit.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
              System.exit(0);
           }
        });
        
        minimize.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
              setState(Frame.ICONIFIED);
           }
        });
        
        header.add(hmain);
        
/****************************************************************/    


/************ PHẦN NAVIGATION ( MENU ) **************************/  
        nav = new JPanel(null);
        nav.setBackground(new Color(55, 63, 81));
        nav.setPreferredSize(new Dimension(210,DEFAULT_HEIGHT));
        
        JScrollPane scroll = new JScrollPane(nav);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1,100));
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
     
        
        //Thêm item vào thanh menu (Tên item : icon : icon hover)
        navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm ( Tên btn : icon : icon hover )
            navItem.add("Quản Lý Khoá Học:manage-course.png:manage-course.png");
            navItem.add("Quản Lý Giảng Viên:KhachHang_20px.png:KhachHang_20px_active.png");
            navItem.add("Quản Lý Học Viên:manage-student.png:manage-student.png");
            navItem.add("Phân Công Giảng Dạy:QLSP_20px.png:QLSP_20px_active.png");
             navItem.add("Kết Quả Khoá Học:manage-result.png:manage-result.png");
      
        outNav();
        
/************ PHẦN MAIN ( HIỂN THỊ ) **************************/        
        main = new JPanel(null);
        main.setBackground(Color.WHITE);
        navObj.get(0).doActive();
        changeMainInfo(0);
/**************************************************************/   

        add(header,BorderLayout.NORTH);
        add(scroll,BorderLayout.WEST);
        add(main,BorderLayout.CENTER);
      
        setVisible(true);
    }
     public void changeMainInfo(int i) throws Exception //Đổi Phần hiển thị khi bấm btn trên menu
    {
     /*if(flag && i>4 && i<9) // Thay đổi nếu Thông kế đang dropdown
        {
            i = i + 2;
        }*/
        switch(i)
        {
            case 0: // Course
                main.removeAll();
                main.add(new QuanLyKhoaHoc(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
            break;
            case 1: // Course
                main.removeAll();
                main.add(new QuanLyGiaoVien(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
            break;
            case 2: // Course
                main.removeAll();
                main.add(new QuanLyHocVien(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
            break;
            case 3: // Course
                main.removeAll();
                main.add(new QuanLyPhanCongGiangDay(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
            break;
            case 4: // Course
                main.removeAll();
                main.add(new QuanLyKetQuaKhoaHoc(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
            break;
         
      
            default:
            break;
        }
    }
      
    public void outNav()
    {
        //Gắn cái NavItem vào NavOBJ
        navObj.clear();
        for(int i = 0 ; i < navItem.size() ; i++)
        {
            String s = navItem.get(i).split(":")[0];
            String icon = navItem.get(i).split(":")[1];
            String iconActive = navItem.get(i).split(":")[2];
            navObj.add(new navItem(s, new Rectangle(0,200+50*i,210,50),icon,iconActive));
            navObj.get(i).addMouseListener(this);
        }
        if(!flag && navObj.size() > 8) //Đổi màu phần DropDown của thống kê
        {
            navObj.get(5).setColorNormal(new Color(86, 94, 127));
            navObj.get(6).setColorNormal(new Color(86, 94, 127));
        }
        
        //Xuất ra Naigation
        nav.removeAll();
        JLabel profile = new JLabel(new ImageIcon("./src/main/java/img/icons8-courses-96.png"));
        profile.setBounds(0,0,210,200);
        nav.add(profile);
        for(navItem n : navObj)
        {
            nav.add(n); 
        }
        repaint();
        revalidate();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
          for(int i  = 0 ; i<navObj.size();i++)
        {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if(e.getSource()== item)
            {
               
                item.doActive(); // Active NavItem đc chọn 
                try {
                  changeMainInfo(i); // Hiển thị ra phần main
                } catch (Exception ex) {
                    Logger.getLogger(ManageCourses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                item.noActive();
            }
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
