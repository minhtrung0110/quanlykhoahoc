/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class CourseInstructor {
    private int ID;
    private int CourseID;
    private int PersonID;
    private String TitleCourse;
    private String TeacherName;
    public CourseInstructor() {
    }
    public CourseInstructor(int ID,int CourseID,  String TitleCourse,int PersonID, String TeacherName) {
        this.ID=ID;
        this.CourseID = CourseID;
        this.TitleCourse = TitleCourse;
        this.PersonID = PersonID;
        this.TeacherName = TeacherName;
    }
    public int getCourseID() {
        return CourseID;
    }   
    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }
    public int getPersonID() {
        return PersonID;
    }
    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }
    public String getTitleCourse() {
        return TitleCourse;
    }
    public void setTitleCourse(String TitleCourse) {
        this.TitleCourse = TitleCourse;
    }
    public String getTeacherName() {
        return TeacherName;
    }
    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }   
    @Override
    public String toString() {
        return "CourseInstructorDTO{" + "CourseID=" + CourseID + ", PersonID=" + PersonID + '}';
    } 
}
