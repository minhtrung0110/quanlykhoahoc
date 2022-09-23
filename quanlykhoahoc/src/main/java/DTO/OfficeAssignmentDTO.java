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
public class OfficeAssignmentDTO {
    public int InstructorID;
    public String Location;
    public Date Timestamp;

    public OfficeAssignmentDTO() {
    }

    public OfficeAssignmentDTO(int InstructorID, String Location, Date Timestamp) {
        this.InstructorID = InstructorID;
        this.Location = Location;
        this.Timestamp = Timestamp;
    }

    public int getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(int InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }

    @Override
    public String toString() {
        return "OfficeAssignmentDTO{" + "InstructorID=" + InstructorID + ", Location=" + Location + ", Timestamp=" + Timestamp + '}';
    }
    
    
}
