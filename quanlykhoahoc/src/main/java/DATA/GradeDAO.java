/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import DTO.GradeDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class GradeDAO {

    static Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    SQLConnect mySQL = new SQLConnect();

    public GradeDAO() throws Exception {
        if (conn == null) {
            try {
                conn = mySQL.open();
            } catch (SQLException ex) {
                System.out.println("grade error");
            }

        }
    }

    public ArrayList<GradeDTO> list() throws SQLException {
        ArrayList<GradeDTO> dsct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM studentgrade";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int EnrollnmentID = rs.getInt("EnrollmentID");
                int CourseID = rs.getInt("CourseID");
                int StudentID = rs.getInt("StudentID");
                float Grade = rs.getFloat("Grade");

                GradeDTO ct = new GradeDTO(EnrollnmentID, CourseID, StudentID, Grade);
                dsct.add(ct);
            }
            rs.close();
            return dsct;
        } catch (SQLException ex) {
            Logger.getLogger(null, null);
            return null;
        }
    }

    public void add(GradeDTO gra) {
        try {
            String sql = "INSERT INTO studentgrade VALUES (";
            sql += gra.getEnrollmentID();
            sql += "," + gra.getCourseID();
            sql += "," + gra.getStudentID();
            sql += "," + gra.getGrade() + ")";
            System.out.println(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("error add grade");
        }

    }

    public void delete(int EnrollmentID) throws SQLException {
        String sql = "DELETE FROM studentgrade WHERE EnrollmentID=" + EnrollmentID + "";
        st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println(sql);
    }

}
