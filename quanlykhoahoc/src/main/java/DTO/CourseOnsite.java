/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;



/**
 *
 * @author nguyenducminhtrung
 */
public class CourseOnsite extends Course {
    public int CourseID;
    public String Location, Days, Time;

    public CourseOnsite() {
        super();
    }
    public CourseOnsite(int CourseID, String title, int Credits, int DepartmentID,String Location, String Days, String Time) {
        this.CourseID = CourseID;
        this.Title = title;
        this.Credits = Credits;
        this.DepartmentID = DepartmentID;
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }
    public CourseOnsite(int CourseID, String Location, String Days, String Time) {
        super();
        this.CourseID = CourseID;
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
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
    
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    @Override
    public String toString() {
        return "CourseOnsiteDTO{" + "CourseID=" + CourseID + ", Location=" + Location + ", Days=" + Days + ", Time=" + Time + '}';
    }
    
    
}
