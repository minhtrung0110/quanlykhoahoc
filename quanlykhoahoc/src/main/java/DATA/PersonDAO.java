/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import DTO.PersonDTO;
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
public class PersonDAO {

    static Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    SQLConnect mySQL = new SQLConnect();

    public PersonDAO() throws Exception {
        if (conn == null) {
            try {
                conn = mySQL.open();
            } catch (SQLException ex) {
                System.out.println("loi1");
            }

        }
    }

    public ArrayList<PersonDTO> list() throws SQLException {
        ArrayList<PersonDTO> dsct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM person";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int PersonID = rs.getInt("PersonID");
                String Lastname = rs.getString("Lastname");
                String Firstname = rs.getString("Firstname");
                String HireDate = rs.getString("HireDate");
                String EnrollmentDate = rs.getString("EnrollmentDate");

                PersonDTO ct = new PersonDTO(PersonID, Firstname, Lastname, HireDate, EnrollmentDate);
                dsct.add(ct);
            }
            rs.close();
            return dsct;
        } catch (SQLException ex) {
            Logger.getLogger(null, null);
            return null;
        }
    }

    public void add(PersonDTO pe) {
        try {
            String sql = "INSERT INTO person VALUES (";
            sql += pe.getPersonID();
            sql += ",'" + pe.getLastname() + "'";
            sql += ",'" + pe.getFirstname() + "'";
            sql += ",'" + pe.getHireDate() + "'";
            sql += ",'" + pe.getEnrollmentDate() + "')";

            System.out.println(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("error add person");
        }
    }

    public void delete(int PersonID) throws SQLException {
        String sql = "DELETE FROM person WHERE PersonID=" + PersonID + "";
        st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println(sql);
    }

}
