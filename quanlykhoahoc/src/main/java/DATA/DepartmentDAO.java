/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import DTO.DepartmentDTO;
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
public class DepartmentDAO {

    static Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    SQLConnect mySQL = new SQLConnect();

    public DepartmentDAO() throws Exception {
        if (conn == null) {
            try {
                conn = mySQL.open();
            } catch (SQLException ex) {
                System.out.println("department error");
            }

        }
    }

    public ArrayList<DepartmentDTO> list() throws SQLException {
        ArrayList<DepartmentDTO> dsct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM department";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int DepartmentID = rs.getInt("DepartmentID");
                String Name = rs.getString("Name");
                int Budget = rs.getInt("Budget");
                String StartDate = rs.getString("StartDate");
                int Administrator = rs.getInt("Administrator");

                DepartmentDTO ct = new DepartmentDTO(DepartmentID, Name, Budget, StartDate, Administrator);
                dsct.add(ct);
            }
            rs.close();
            return dsct;
        } catch (SQLException ex) {
            Logger.getLogger(null, null);
            return null;
        }
    }

    public void add(DepartmentDTO de) {
        try {
            String sql = "INSERT INTO department VALUES (";
            sql += de.getDepartmentID();
            sql += ",'" + de.getName() + "'";
            sql += ",'" + de.getBudget() + "'";
            sql += ",'" + de.getStartDate() + "'";
            sql += ",'" + de.getAdministrator() + "')";

            System.out.println(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("error add department");
        }
    }

    public void delete(int DepartmentID) throws SQLException {
        String sql = "DELETE FROM department WHERE DepartmentID=" + DepartmentID + "";
        st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println(sql);
    }

    public void set(DepartmentDTO de) throws SQLException {
        String qry = "UPDATE department SET" + " Name = '" + de.getName() + "',Budget = "
                + de.getBudget() + ",StartDate = '" + de.getStartDate() + "',Administrator=" + de.getAdministrator()
                + " WHERE DepartmentID = " + de.getDepartmentID();
        st = conn.createStatement();
        st.executeUpdate(qry);
    }

}
