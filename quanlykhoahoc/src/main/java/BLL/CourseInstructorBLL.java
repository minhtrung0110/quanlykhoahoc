/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseInstructorDAL;
import java.util.ArrayList;
import DTO.CourseInstructor;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author nguyeD
 */
public class CourseInstructorBLL {
     static ArrayList<CourseInstructor> listCourseInstructor;
     private CourseInstructorDAL dal=new CourseInstructorDAL();
    public CourseInstructorBLL() {
    }
    
    public void  loadDSCourseInstructor(String orderby) throws Exception{
       
        if(listCourseInstructor==null) listCourseInstructor = new ArrayList<CourseInstructor>();
        listCourseInstructor=dal.loadDatabase(orderby);
    }
    
    public void addCourseInstructor(CourseInstructor csin) throws Exception{
        try{
            dal.addCourseInstructor(csin);
            listCourseInstructor.add(csin);
        } 
        catch(Exception ex){
            System.out.println("Khong the them CourseInstructor Item vao database ");
        }
        
    }
    
    public void deleteCourseInstructor(int courseID,int teacherID) throws Exception{
        for(CourseInstructor csin : listCourseInstructor )
        {
            if(csin.getCourseID()==courseID)
            {   
                try {
                    dal.delete(courseID,teacherID); 
                   listCourseInstructor.remove(csin);// xoá trong arraylist 
                } catch (Exception e) {
                    System.out.println("Khong the Xoa CourseInstructor vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateCourseInstructor(int id, CourseInstructor csin) throws Exception{
         for(int i = 0 ; i < listCourseInstructor.size() ; i++)
        {
            if(listCourseInstructor.get(i).getCourseID()==csin.getCourseID())
            {
                try {
                    dal.updateCourseInstructor(id,csin);
                    listCourseInstructor.set(i, csin);               
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");
                   
                }
                
                return;
            }
        }
    }
     public ArrayList<CourseInstructor> searchCourseInstructor(int courseID,String courseTitle, int teacherID, String teacherName)
    {
        ArrayList<CourseInstructor> search = new ArrayList<>();
        
         courseTitle= courseTitle.isEmpty()? courseTitle="": courseTitle;
        teacherName=teacherName.isEmpty()?teacherName="":teacherName;

        for(CourseInstructor csin : listCourseInstructor)
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
     public ArrayList<CourseInstructor> searchCourseID(int courseID)
    {
        ArrayList<CourseInstructor> search = new ArrayList<>();
        for(CourseInstructor csin : listCourseInstructor)
        {
             if(  csin.getCourseID()==courseID  )
                search.add(csin);
        }
        return search;
    }
      public ArrayList<CourseInstructor> searchCourseTitle(String courseTitle)
    {
        ArrayList<CourseInstructor> search = new ArrayList<>();
        for(CourseInstructor csin : listCourseInstructor)
        {
             if(  csin.getTitleCourse().contains(courseTitle)  )
                search.add(csin);
        }
        return search;
    }
    public ArrayList<CourseInstructor> searchTeacherName(String teacherName)
    {
        ArrayList<CourseInstructor> search = new ArrayList<>();
        for(CourseInstructor csin : listCourseInstructor)
        {
             if(  csin.getTeacherName().contains(teacherName)  )
                search.add(csin);
        }
        return search;
    }
     public ArrayList<CourseInstructor> searchTeacherID(int teacherID)
    {
        ArrayList<CourseInstructor> search = new ArrayList<>();
        for(CourseInstructor csin : listCourseInstructor)
        {
             if(  csin.getPersonID()==teacherID  )
                search.add(csin);
        }
        return search;
    }
    
    public static void setListCourseInstructor(ArrayList<CourseInstructor> listCourseInstructor) {
        CourseInstructorBLL.listCourseInstructor = listCourseInstructor;
    }

    public static ArrayList<CourseInstructor> getListCourseInstructor() {
        return listCourseInstructor;
    }
    public  void setlistCourseInstructor(ArrayList<CourseInstructor> listCourseInstructor) {
        CourseInstructorBLL.listCourseInstructor = listCourseInstructor;
    }

    public  ArrayList<CourseInstructor> getlistCourseInstructor() {
        return listCourseInstructor;
    }
    
}
