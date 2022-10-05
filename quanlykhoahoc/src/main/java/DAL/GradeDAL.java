/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.GradeDTO;
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
public class GradeDAL extends MyConnectUnit {

    public GradeDAL() {
        super();
    }

    public ArrayList<GradeDTO> loadDatabase() throws Exception {
        ArrayList<GradeDTO> dsach = new ArrayList<>();
        try {
            ResultSet rs = this.Select("studentgrade");
            while (rs.next()) {
                GradeDTO g = new GradeDTO(rs.getInt("EnrollmentID"), rs.getInt("CourseID"),
                        rs.getInt("StudentID"), rs.getFloat("Grade"));

                dsach.add(g);
            }
            rs.close();
            this.Close();
        } catch (SQLException ex) {
            System.out.println("Khong the load database StudentGrade: " + ex);

        }
        return dsach;
    }

    public void addGrade(GradeDTO g) throws Exception {
        HashMap<String, Object> Insertvalues = new HashMap<String, Object>();
        Insertvalues.put("EnrollmentID", g.getEnrollmentID());
        Insertvalues.put("CourseID", g.getCourseID());
        Insertvalues.put("StudentID", g.getStudentID());
        Insertvalues.put("Grade", g.getGrade());

        try {
            this.Insert("studentgrade", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them Grade vao database !!!");
        }
    }

    public void updateGrade(int id, GradeDTO g) throws Exception {
        HashMap<String, Object> Updatevalues = new HashMap<String, Object>();
        Updatevalues.put("EnrollmentID", g.getEnrollmentID());
        Updatevalues.put("CourseID", g.getCourseID());
        Updatevalues.put("StudentID", g.getStudentID());
        Updatevalues.put("Grade", g.getGrade());
        try {
            this.Update("studentgrade", Updatevalues, "EnrollmentID='" + id + "'");
        } catch (SQLException ex) {
            System.out.println("Khong the cap nhat Grade vao database !!!");
        }
    }

    public void deleteGrade(int enrollmentID) {
        try {
            this.Delete("studentgrade", "EnrollmentID='" + enrollmentID + "'");
        } catch (Exception e) {
            System.out.println("Khong the xoa Grade vao database !!!");
        }
    }

//    public static void main(String[] args) throws Exception {
//        GradeDAO g = new GradeDAO();
//            g.loadDatabase().forEach((n) -> {System.out.println(n);});
//        g.deleteGrade(26);
//        g.addGrade(new GradeDTO(26, 1061, 26, (float) 4.0));
//        g.updateGrade(26, new GradeDTO(26, 4041, 21, (float) 3.9));
//
//    }

}
