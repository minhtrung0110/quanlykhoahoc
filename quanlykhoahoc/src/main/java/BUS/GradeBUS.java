/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DATA.GradeDAO;
import DTO.GradeDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trankimphu0609
 */
public class GradeBUS {

    public static ArrayList<GradeDTO> ds;

    public GradeBUS() {

    }

    public void ReadGrade() throws SQLException, Exception {
        GradeDAO dao = new GradeDAO();
        if (ds == null) {
            ds = new ArrayList<GradeDTO>();
            ds = dao.list();
        }
    }

    public void AddGrade(GradeDTO gra) throws Exception {
        GradeDAO dao = new GradeDAO();
        dao.add(gra);
        ds.add(gra);

    }

    public void DeleteGrade(int EnrollmentID) throws Exception {
        for (GradeDTO gra : ds) {
            if (gra.getEnrollmentID() == EnrollmentID) {
                ds.remove(gra);
                GradeDAO dao = new GradeDAO();
                dao.delete(EnrollmentID);
                return;
            }
        }
    }

    public GradeDTO SearchGrade(int EnrollmentID) {
        for (GradeDTO gra : ds) {
            if (gra.getEnrollmentID() == EnrollmentID) {
                return gra;
            }
        }
        return null;
    }

    public ArrayList<GradeDTO> SearchCourse(int CourseID) {
        ArrayList<GradeDTO> kq = new ArrayList<GradeDTO>();
        for (GradeDTO gra : ds) {
            if (gra.getCourseID() == CourseID) {
                kq.add(gra);
            }
        }
        return kq;
    }

}
