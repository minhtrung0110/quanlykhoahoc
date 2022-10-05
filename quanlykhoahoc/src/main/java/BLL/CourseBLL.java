/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.CourseDTO;
import java.util.ArrayList;

/**
 *
 * @author trankimphu0609
 */
public class CourseBLL {
      static ArrayList<CourseDTO> listCourse;
    public CourseBLL() {
    }

    public  ArrayList<CourseDTO> getListCourse() {
        return listCourse;
    }
    
    public void setListCourse(ArrayList<CourseDTO> listCourse) {
        CourseBLL.listCourse = listCourse;
    }
    
    
    public void  loadDSCourse() throws Exception{
        CourseDAL data =new CourseDAL();
        if(listCourse==null) listCourse = new ArrayList<CourseDTO>();
        listCourse=data.loadDatabase();
    }
    
     public ArrayList<CourseDTO> searchCourseWithID(int courseID)
    {
        ArrayList<CourseDTO> search = new ArrayList<>();
        //courseID=courseID.isEmpty()?courseID="":courseID;

        for(CourseDTO ps : listCourse)
        {
          
             if( ps.getCourseID()==courseID )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
      public ArrayList<CourseDTO> searchCourseWithTitle(String title)
    {
        ArrayList<CourseDTO> search = new ArrayList<>();
        //courseID=courseID.isEmpty()?courseID="":courseID;

        for(CourseDTO ps : listCourse)
        {
          
             if( ps.getTitle().contains(title) )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
       public ArrayList<CourseDTO> searchCourseWithDepartmentID(int id)
    {
         ArrayList<CourseDTO> search = new ArrayList<>();
        for(CourseDTO ps : listCourse)
        {
          
             if( ps.getDepartmentID()==id)
            {
                
                search.add(ps);
            }
        }
        return search;
    }
}
