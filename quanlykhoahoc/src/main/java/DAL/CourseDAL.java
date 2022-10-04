/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
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
     public ArrayList<CourseDTO> loadDatabase() throws Exception
    {
        ArrayList<CourseDTO> listCourse = new ArrayList<>();
        try {
            //select cs.CourseID,cs.Title, ps.PersonID, ps.Lastname, ps.Firstname from course as cs , person as ps, courseinstructor as csin 
            //where cs.CourseID=csin.CourseID AND ps.PersonID=csin.PersonID;
            ResultSet rs = this.Select("course");
            while(rs.next())
            {
               CourseDTO csin = new  CourseDTO(
                       rs.getInt("CourseID") , rs.getString("Title"),
                       rs.getInt("Credits"), rs.getInt("DepartmentID"));    
                listCourse.add(csin);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Course: "+ex);
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
