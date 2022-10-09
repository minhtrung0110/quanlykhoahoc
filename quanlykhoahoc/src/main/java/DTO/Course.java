/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trankimphu0609
 */
public class Course {
    
    public int CourseID;
    public String Title;
    public int Credits;
    public int DepartmentID;

    public Course() {
    }

    public Course(int CourseID, String title, int Credits, int DepartmentID) {
        this.CourseID = CourseID;
        this.Title = title;
        this.Credits = Credits;
        this.DepartmentID = DepartmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    
    
    
    
}
