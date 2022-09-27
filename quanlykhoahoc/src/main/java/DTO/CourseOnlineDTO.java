/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trankimphu0609
 */
public class CourseOnlineDTO {
    public int CourseID;
    public String url;

    public CourseOnlineDTO() {
    }
    public CourseOnlineDTO(int CourseID, String url) {

        this.CourseID = CourseID;
        this.url = url;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CourseOnlineDTO{" + "CourseID=" + CourseID + ", url=" + url + '}';
    }
    
    
}
