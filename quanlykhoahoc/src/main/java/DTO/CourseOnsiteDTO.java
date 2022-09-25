/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author trankimphu0609
 */
public class CourseOnsiteDTO {
    public int CourseID;
    public String Location;
    public Date Days, Time;

    public CourseOnsiteDTO() {
    }

    public CourseOnsiteDTO(int CourseID, String Location, Date Days, Date Time) {
        this.CourseID = CourseID;
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
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

    public Date getDays() {
        return Days;
    }

    public void setDays(Date Days) {
        this.Days = Days;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date Time) {
        this.Time = Time;
    }

    @Override
    public String toString() {
        return "CourseOnsiteDTO{" + "CourseID=" + CourseID + ", Location=" + Location + ", Days=" + Days + ", Time=" + Time + '}';
    }
    
    
}
