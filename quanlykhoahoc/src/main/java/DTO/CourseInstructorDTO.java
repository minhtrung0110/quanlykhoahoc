/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trankimphu0609
 */
public class CourseInstructorDTO {
    
    public int CourseID;
    public int PersonID;

    public CourseInstructorDTO() {
    }

    public CourseInstructorDTO(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
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

    @Override
    public String toString() {
        return "CourseInstructorDTO{" + "CourseID=" + CourseID + ", PersonID=" + PersonID + '}';
    }
    
    
    
}
