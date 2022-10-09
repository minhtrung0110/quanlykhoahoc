/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class CourseDAL extends MyConnectUnit {
    public CourseDAL() {
        super();
      
    }
     public ArrayList<Course> loadDatabase() throws Exception
    {
        ArrayList<Course> listCourse = new ArrayList<>();
        try {
            ResultSet rs = this.Select("course");
            while(rs.next())
            {
               Course csin = new  Course(
                       rs.getInt("CourseID") , rs.getString("Title"),
                       rs.getInt("Credits"), rs.getInt("DepartmentID"));    
                listCourse.add(csin);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Course");
        }
        return listCourse;
    }
    /*public static void main(String[] args) {
        try {
            new CourseDAO().readCourse();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
}
