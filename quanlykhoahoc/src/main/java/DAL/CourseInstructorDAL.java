/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseInstructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class CourseInstructorDAL extends MyConnectUnit {

    public CourseInstructorDAL() {
        super();

    }

    public ArrayList<CourseInstructor> loadDatabase(String orderby) throws Exception {
        ArrayList<CourseInstructor> list = new ArrayList<>();
        try {
            ResultSet rs = this.SelectCustomOrderby("course as cs , person as ps, courseinstructor as csin",
                    "csin.ID,cs.CourseID,cs.Title, ps.PersonID, ps.Lastname, ps.Firstname",
                    "cs.CourseID=csin.CourseID AND ps.PersonID=csin.PersonID",
                    "csin.ID " + orderby);
            while (rs.next()) {
                CourseInstructor csin = new CourseInstructor(
                        rs.getInt("ID"), rs.getInt("CourseID"),
                        rs.getString("Title"), rs.getInt("PersonID"),
                        rs.getString("Lastname") + " " + rs.getString("Firstname")
                );
                list.add(csin);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database CourseInstructor: " + ex);
        }

        return list;
    }

    public void addCourseInstructor(CourseInstructor csin) throws Exception {
        HashMap<String, Object> Insertvalues = new HashMap<String, Object>();

        Insertvalues.put("CourseID", csin.getCourseID());
        Insertvalues.put("PersonID", csin.getPersonID());
        try {
            this.Insert("courseinstructor", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them CourseInstructor vao database !!!");
        }
    }

    public void updateCourseInstructor(int id, CourseInstructor csin) throws Exception {
        HashMap<String, Object> Updatevalues = new HashMap<String, Object>();

        Updatevalues.put("CourseID", csin.getCourseID());
        Updatevalues.put("PersonID", csin.getPersonID());

        try {
            this.Update("courseinstructor", Updatevalues, "ID ='" + id + "'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");
        }
    }

    public void delete(int courseID, int teacherID) {
        try {
            this.Delete("courseinstructor",
                    "CourseID ='" + courseID + "'AND PersonID ='" + teacherID + "'");
        } catch (Exception e) {
            System.out.println("Lỗi không thể xóa courseinstructor item !!");
        }

    }

}
