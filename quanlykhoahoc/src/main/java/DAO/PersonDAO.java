/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.MyDatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class PersonDAO extends MyDatabaseManager {
    public PersonDAO() {
        super();
        this.connectDB();
    }
    
    public void readPersons() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
//                System.out.print(i + " - ");
                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                i++;
            }
        }
            

    }
    public static void main(String[] args) {
        try {
            new PersonDAO().readPersons();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
