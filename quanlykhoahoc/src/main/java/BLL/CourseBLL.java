/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.Course;
import java.util.ArrayList;

/**
 *
 * @author nguyenducminhtrung
 */
public class CourseBLL {
      static ArrayList<Course> listCourse;
      CourseDAL data =new CourseDAL();
    public CourseBLL() {
    }

    public  ArrayList<Course> getListCourse() {
        return listCourse;
    }
    
    public void setListCourse(ArrayList<Course> listCourse) {
        CourseBLL.listCourse = listCourse;
    }
    
    
    public void  loadDSCourse() throws Exception{
        
        if(listCourse==null) listCourse = new ArrayList<Course>();
        listCourse=data.loadDatabase();// gọi Layer DAL hàm đọc data từ CSDL
    }
    public void addCourse(){
         if(listCourse==null) listCourse = new ArrayList<Course>();
        //listCourse=data.loadDatabase();// gọi Layer DAL hàm đọc data từ CSDL
    }
     public ArrayList<Course> searchCourseWithID(int courseID)
    {
        ArrayList<Course> search = new ArrayList<>();

        for(Course ps : listCourse)
        {
          
             if( ps.getCourseID()==courseID )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
      public ArrayList<Course> searchCourseWithTitle(String title)
    {
        ArrayList<Course> search = new ArrayList<>();
        //courseID=courseID.isEmpty()?courseID="":courseID;

        for(Course ps : listCourse)
        {
          
             if( ps.getTitle().contains(title) )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
       public ArrayList<Course> searchCourseWithDepartmentID(int id)
    {
         ArrayList<Course> search = new ArrayList<>();
        for(Course ps : listCourse)
        {
          
             if( ps.getDepartmentID()==id)
            {
                
                search.add(ps);
            }
        }
        return search;
    }
}
