/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import DTO.CourseDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class CourseDAO {

    static Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    SQLConnect mySQL = new SQLConnect();

    public CourseDAO() throws Exception {
        if (conn == null) {
            try {
                conn = mySQL.open();
            } catch (SQLException ex) {
                System.out.println("course error");
            }

        }
    }

    public ArrayList<CourseDTO> list() {
        ArrayList<CourseDTO> dsct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM course";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int CourseID = rs.getInt("CourseID");
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");

                CourseDTO ct = new CourseDTO(CourseID, Title, Credits, DepartmentID);
                dsct.add(ct);
            }
            rs.close();
            return dsct;
        } catch (SQLException ex) {
            Logger.getLogger(null, null);
            return null;
        }
    }

    public void add(CourseDTO c) {
        try {
            String sql = "INSERT INTO course VALUES (";
            sql += c.getCourseID();
            sql += ",'" + c.getTitle() + "'";
            sql += "," + c.getCredits() + "";
            sql += ",'" + c.getDepartmentID() + ")";

            System.out.println(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("error add course");
        }
    }

    public void delete(int CourseID) throws SQLException {
        String sql = "DELETE FROM course WHERE CourseID=" + CourseID + "";
        st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println(sql);
    }

    public void set(CourseDTO c) throws SQLException {
        String qry = "UPDATE course SET" + " Title = '" + c.getTitle() + "',Credits = "
                + c.getCredits() + ",DepartmentID=" + c.getDepartmentID()
                + " WHERE DepartmentID = " + c.getCourseID();
        st = conn.createStatement();
        st.executeUpdate(qry);
    }
}
