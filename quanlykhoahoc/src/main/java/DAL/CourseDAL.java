/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import DTO.CourseOnline;
import DTO.CourseOnsite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
    public void addCourseOnline(CourseOnline cs) throws Exception
    {
         HashMap<String,Object> InsertvaluesCourse =new  HashMap<String,Object>();
         HashMap<String,Object> InsertvaluesCourseOnline =new  HashMap<String,Object>();
         
        InsertvaluesCourse.put("CourseID",cs.getCourseID());
        InsertvaluesCourse.put("Title", cs.getTitle());
        InsertvaluesCourse.put("Credits", cs.getCredits());
        InsertvaluesCourse.put("DepartmentID", cs.getDepartmentID());
        InsertvaluesCourseOnline.put("url", cs.getUrl());
        
         try {
             this.Insert("course", InsertvaluesCourse);
             ResultSet rs=this.SelectCustomOrderby("course","CourseID",null,"CourseID DESC limit 1");
               while(rs.next())
            {
                 InsertvaluesCourseOnline.put("CourseID", rs.getInt("CourseID"));
             System.out.print(rs.getInt("CourseID"));
            }
            
             this.Insert("onlinecourse", InsertvaluesCourseOnline);
        } catch (SQLException ex) {
            System.out.println("Khong the them CourseOnline vao database !!!");
        }
    }
    public void addCourseOnSite(CourseOnsite cs) throws Exception
    {
         HashMap<String,Object> InsertvaluesCourse =new  HashMap<String,Object>();
         HashMap<String,Object> InsertvaluesCourseOnsite =new  HashMap<String,Object>();
         
        InsertvaluesCourse.put("CourseID",cs.getCourseID());
        InsertvaluesCourse.put("Title", cs.getTitle());
        InsertvaluesCourse.put("Credits", cs.getCredits());
        InsertvaluesCourse.put("DepartmentID", cs.getDepartmentID());
        InsertvaluesCourseOnsite.put("Location", cs.getLocation());
        InsertvaluesCourseOnsite.put("Days", cs.getDays());
        InsertvaluesCourseOnsite.put("Time", cs.getTime());
         try {
             this.Insert("course", InsertvaluesCourse);
             ResultSet rs=this.SelectCustomOrderby("course","CourseID",null,"CourseID DESC limit 1");
               while(rs.next())
            {
                 InsertvaluesCourseOnsite.put("CourseID", rs.getInt("CourseID"));
            }
            
             this.Insert("onsitecourse", InsertvaluesCourseOnsite);
        } catch (SQLException ex) {
            System.out.println("Khong the them CourseOnsite vao database !!!");
        }
    }
         public void updateCourse(int id,Course csin) throws Exception
    {
        HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
        Updatevalues.put("CourseID",csin.getCourseID());
      //  Updatevalues.put("PersonID", csin.getPersonID());
       
         try {
           this.Update("courseinstructor", Updatevalues,"ID ='"+id+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat Course vao database !!!");
        }
    }
    public void delete(int courseID,int teacherID)
    {
        try {
                this.Delete("courseinstructor",
                "CourseID ='"+courseID+"'AND PersonID ='"+teacherID+"'");
           } 
        catch (Exception e) {
                    System.out.println("Lỗi không thể xóa courseinstructor item !!");
             }
        
    }
    public static void main(String[] args) throws Exception {
        CourseDAL data=new CourseDAL();
        CourseOnline cson=new CourseOnline();
        cson.setCourseID(0);
        cson.setTitle("A");
        cson.setCredits(250000);
        cson.setDepartmentID(2);
        cson.setUrl("htttp://ggmet-aada-akkl-uoiy");
        CourseOnsite cssite=new CourseOnsite();
         cssite.setCourseID(0);
        cssite.setTitle("A");
        cssite.setCredits(250000);
        cssite.setDepartmentID(2);
        cssite.setLocation("C.E403");
        cssite.setDays(new Date("2022-10-10"));
        cssite.setTime(new Date("2022-10-10"));
        data.addCourseOnSite(cssite);
        //data.addCourseOnline(cson);
    }
}
