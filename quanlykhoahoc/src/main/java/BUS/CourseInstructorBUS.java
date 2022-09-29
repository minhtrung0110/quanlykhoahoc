/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CourseInstructorDAO;
import java.util.ArrayList;
import DTO.CourseInstructorDTO;

/**
 *
 * @author nguye
 */
public class CourseInstructorBUS {
     static ArrayList<CourseInstructorDTO> listCourseInstructor;
    public CourseInstructorBUS() {
    }
    
    public void  loadDSCourseInstructor() throws Exception{
        CourseInstructorDAO data =new CourseInstructorDAO();
        if(listCourseInstructor==null) listCourseInstructor = new ArrayList<CourseInstructorDTO>();
        listCourseInstructor=data.loadDatabase();
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
