/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.Course;
import DTO.CourseInstructor;

import java.util.ArrayList;

/**
 *
 * @author nguyenducminhtrung
 */
public class CourseBLL {

    static ArrayList<Course> listCourse;
    private CourseDAL data = new CourseDAL();

    public CourseBLL() {
    }

    public static ArrayList<Course> getListCourse() {
        return listCourse;
    }

    public static void setListCourse(ArrayList<Course> listCourse) {
        CourseBLL.listCourse = listCourse;
    }

    public void loadDSCourse(String orderby) throws Exception {

        if (listCourse == null) {
            listCourse = new ArrayList<Course>();
        }
        listCourse = data.loadDatabase(orderby);// gọi Layer DAL hàm đọc data từ CSDL
    }

    public void addCourse(Course cs) throws Exception {
        if (listCourse == null) {
            listCourse = new ArrayList<Course>();
        }
        data.addCourse(cs);// gọi Layer DAL hàm đọc data từ CSDL
    }

    public void deleteCourse(int courseID) throws Exception {
        for (Course csin : listCourse) {
            if (csin.getCourseID() == courseID) {
                try {
                    data.deleteCourse(courseID);
                    listCourse.remove(csin);// xoá trong arraylist
                } catch (Exception e) {
                    System.out.println("Khong the Xoa Course vao database !!!");
                }
                return;
            }
        }
    }

    public void updateCourse(int id, Course cs) throws Exception {
        for (int i = 0; i < listCourse.size(); i++) {
            if (listCourse.get(i).getCourseID() == cs.getCourseID()) {
                try {
                    data.updateCourse(id, cs);
                    listCourse.set(i, cs);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat Course vao database !!!");
                }

                return;
            }
        }
    }

    public ArrayList<Course> searchCourseWithID(int courseID) {
        ArrayList<Course> search = new ArrayList<>();

        for (Course ps : listCourse) {

            if (ps.getCourseID() == courseID) {
                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<Course> searchCourseWithTitle(String title) {
        ArrayList<Course> search = new ArrayList<>();
        //courseID=courseID.isEmpty()?courseID="":courseID;

        for (Course ps : listCourse) {

            if (ps.getTitle().trim().toLowerCase().contains(title.trim().toLowerCase())) {

                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<Course> searchCourseWithDepartmentID(int id) {
        ArrayList<Course> search = new ArrayList<>();
        for (Course ps : listCourse) {

            if (ps.getDepartmentID() == id) {

                search.add(ps);
            }
        }
        return search;
    }
    
    public String remindMaKH() {
        int max = 0;
        String s = "";
        for (Course hd : listCourse) {
            int id = hd.getCourseID();
            if (id > max) {
                max = id;
            }
        }
        return s + (max + 1);
    }
    public static void main(String[] args) throws Exception {
        CourseBLL bll = new CourseBLL();
        bll.loadDSCourse("ASC");
        ArrayList<Course> ar = new ArrayList<>();
        ar = bll.searchCourseWithID(4061);
        getListCourse().forEach(s-> System.out.println(s));
    }
}
