/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trankimphu0609
 */
public class CourseDTO {
    
    public int CourseID;
    public String title;
    public int Credits;
    public int DepartmentID;

    public CourseDTO() {
    }

    public CourseDTO(int CourseID, String title, int Credits, int DepartmentID) {
        this.CourseID = CourseID;
        this.title = title;
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "CourseDTO{" + "CourseID=" + CourseID + ", title=" + title + ", Credits=" + Credits + ", DepartmentID=" + DepartmentID + '}';
    }
    
    
    
}
