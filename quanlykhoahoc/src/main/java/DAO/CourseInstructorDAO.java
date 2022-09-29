/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseInstructorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class CourseInstructorDAO extends MyConnectUnit {
    public CourseInstructorDAO() {
        super();
      
    }
     public ArrayList<CourseInstructorDTO> loadDatabase() throws Exception
    {
        ArrayList<CourseInstructorDTO> dssach = new ArrayList<>();
        try {
            ResultSet rs = this.Select("courseinstructor");
            while(rs.next())
            {
               CourseInstructorDTO csin = new  CourseInstructorDTO(rs.getInt("CourseID"),rs.getInt("PersonID"));       
                dssach.add(csin);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database CourseInstructor: "+ex);
        }

        return dssach;
    }
    /*
    public void readCourseInstructor() throws SQLException {
        String query = "SELECT * FROM CourseInstructor";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
//                System.out.print(i + " - ");
                System.out.println(rs.getString("CourseID") + " " + rs.getString("PersonID"));
                i++;
            }
        }
            

    }*/
 public static void main(String[] args) throws Exception {
     CourseInstructorDAO cs=new CourseInstructorDAO();
     cs.loadDatabase().forEach( (n) -> { System.out.println(n); } );
       
    }
    
}
