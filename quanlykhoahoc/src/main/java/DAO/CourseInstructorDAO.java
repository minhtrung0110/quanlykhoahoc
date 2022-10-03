/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseInstructorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
            //select cs.CourseID,cs.Title, ps.PersonID, ps.Lastname, ps.Firstname from course as cs , person as ps, courseinstructor as csin 
            //where cs.CourseID=csin.CourseID AND ps.PersonID=csin.PersonID;
            ResultSet rs = this.SelectCustomOrderby("course as cs , person as ps, courseinstructor as csin",
                    "csin.ID,cs.CourseID,cs.Title, ps.PersonID, ps.Lastname, ps.Firstname",
                    "cs.CourseID=csin.CourseID AND ps.PersonID=csin.PersonID","csin.CourseID ASC");
            while(rs.next())
            {
               CourseInstructorDTO csin = new  CourseInstructorDTO(
                       rs.getInt("CourseID"),rs.getInt("CourseID"),rs.getString("Title"),
                       rs.getInt("PersonID"),rs.getString("Lastname")+rs.getString("Firstname")
               );       
                dssach.add(csin);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database CourseInstructor: "+ex);
        }

        return dssach;
    }
      public void addCourseInstructor(CourseInstructorDTO csin) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("CourseID",csin.getCourseID());
        Insertvalues.put("PersonID", csin.getPersonID());
         try {
             this.Insert("courseinstructor", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them CourseInstructor vao database !!!");
        }
    }
         public void updateCourseInstructor(int id,CourseInstructorDTO csin) throws Exception
    {
        HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
        Updatevalues.put("CourseID",csin.getCourseID());
        Updatevalues.put("PersonID", csin.getPersonID());
       
         try {
           this.Update("courseinstructor", Updatevalues,"ID ='"+id+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");
        }
    }
    public void delete(int courseID,int teacherID)
    {
        try {
                    this.Delete("courseinstructor","CourseID ='"+courseID+"'AND PersonID ='"+teacherID+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa courseinstructor item !!");
                }
        
    }
     
 public static void main(String[] args) throws Exception {
     CourseInstructorDAO cs=new CourseInstructorDAO();
     cs.loadDatabase().forEach( (n) -> { System.out.println(n); } );
       
    }
    
}
