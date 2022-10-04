/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CourseInstructorDAO;
import java.util.ArrayList;
import DTO.CourseInstructorDTO;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author nguye
 */
public class CourseInstructorBUS {
     static ArrayList<CourseInstructorDTO> listCourseInstructor;
     static CourseInstructorDAO dal=new CourseInstructorDAO();
    public CourseInstructorBUS() {
    }
    
    public void  loadDSCourseInstructor() throws Exception{
       
        if(listCourseInstructor==null) listCourseInstructor = new ArrayList<CourseInstructorDTO>();
        listCourseInstructor=dal.loadDatabase();
    }
    
    public void addCourseInstructor(CourseInstructorDTO csin) throws Exception{
        // validate data
        //CourseInstructorDAO data =new CourseInstructorDAO();
        dal.addCourseInstructor(csin);
        listCourseInstructor.add(csin);
        
    }
    
    public void deleteCourseInstructor(int courseID,int teacherID) throws Exception{
        
        for(CourseInstructorDTO csin : listCourseInstructor )
        {
            if(csin.getCourseID()==courseID)
            {   
                try {
                   listCourseInstructor.remove(csin);
                   // CourseInstructorDAO data =new CourseInstructorDAO();
                    dal.delete(courseID,teacherID);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa CourseInstructor vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateCourseInstructor(int id, CourseInstructorDTO csin) throws Exception{
         for(int i = 0 ; i < listCourseInstructor.size() ; i++)
        {
            if(listCourseInstructor.get(i).getCourseID()==csin.getCourseID())
            {
                try {
                    listCourseInstructor.set(i, csin);
               // CourseInstructorDAO data =new CourseInstructorDAO();
                dal.updateCourseInstructor(id,csin);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");
                   
                }
                
                return;
            }
        }
    }
     public ArrayList<CourseInstructorDTO> searchCourseInstructor(int courseID,String courseTitle, int teacherID, String teacherName)
    {
        ArrayList<CourseInstructorDTO> search = new ArrayList<>();
        
         courseTitle= courseTitle.isEmpty()? courseTitle="": courseTitle;
        teacherName=teacherName.isEmpty()?teacherName="":teacherName;

        for(CourseInstructorDTO csin : listCourseInstructor)
        {
            //System.out.println(csin.getCourseID()+"--"+courseID );

          //  System.out.println( csin.getPersonID()==teacherID);
          
            
             if( csin.getTitleCourse().contains(courseTitle) &&
                     csin.getTeacherName().contains(teacherName) &&
                 csin.getPersonID()==teacherID &&
                     csin.getCourseID()==courseID 
                 )
            {
                
                search.add(csin);
            }
        }
        return search;
    }
     public ArrayList<CourseInstructorDTO> searchCourseID(int courseID)
    {
        ArrayList<CourseInstructorDTO> search = new ArrayList<>();
        for(CourseInstructorDTO csin : listCourseInstructor)
        {
             if(  csin.getCourseID()==courseID  )
                search.add(csin);
        }
        return search;
    }
      public ArrayList<CourseInstructorDTO> searchCourseTitle(String courseTitle)
    {
        ArrayList<CourseInstructorDTO> search = new ArrayList<>();
        for(CourseInstructorDTO csin : listCourseInstructor)
        {
             if(  csin.getTitleCourse().contains(courseTitle)  )
                search.add(csin);
        }
        return search;
    }
         public ArrayList<CourseInstructorDTO> searchTeacherName(String teacherName)
    {
        ArrayList<CourseInstructorDTO> search = new ArrayList<>();
        for(CourseInstructorDTO csin : listCourseInstructor)
        {
             if(  csin.getTeacherName().contains(teacherName)  )
                search.add(csin);
        }
        return search;
    }
     public ArrayList<CourseInstructorDTO> searchTeacherID(int teacherID)
    {
        ArrayList<CourseInstructorDTO> search = new ArrayList<>();
        for(CourseInstructorDTO csin : listCourseInstructor)
        {
             if(  csin.getPersonID()==teacherID  )
                search.add(csin);
        }
        return search;
    }
    
    public static void setListCourseInstructor(ArrayList<CourseInstructorDTO> listCourseInstructor) {
        CourseInstructorBUS.listCourseInstructor = listCourseInstructor;
    }

    public static ArrayList<CourseInstructorDTO> getListCourseInstructor() {
        return listCourseInstructor;
    }
    public  void setlistCourseInstructor(ArrayList<CourseInstructorDTO> listCourseInstructor) {
        CourseInstructorBUS.listCourseInstructor = listCourseInstructor;
    }

    public  ArrayList<CourseInstructorDTO> getlistCourseInstructor() {
        return listCourseInstructor;
    }
    
}
