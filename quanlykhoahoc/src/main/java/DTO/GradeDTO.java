/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trankimphu0609
 */
public class GradeDTO {
    public int EnrollmentID, CourseID, StudentID;
    public float Grade;

    public GradeDTO() {
    }

    public GradeDTO(int EnrollmentID, int CourseID, int StudentID, float Grade) {
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public float getGrade() {
        return Grade;
    }

    public void setGrade(float Grade) {
        this.Grade = Grade;
    }

    @Override
    public String toString() {
        return "GradeDTO{" + "EnrollmentID=" + EnrollmentID + ", CourseID=" + CourseID + ", StudentID=" + StudentID + ", Grade=" + Grade + '}';
    }
    
    

}
