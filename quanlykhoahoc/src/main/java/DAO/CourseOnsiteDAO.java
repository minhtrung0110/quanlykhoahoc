/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class CourseOnsiteDAO extends MyDatabaseManager {
    public CourseOnsiteDAO() {
        super();
        this.connectDB();
    }
    
    public void readCourseOnsite() throws SQLException {
        String query = "SELECT * FROM OnsiteCourse";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
//                System.out.print(i + " - ");
                System.out.println(rs.getString("CourseID") + " " + rs.getString("Location"));
                i++;
            }
        }
            

    }
//    public static void main(String[] args) {
//        try {
//            new CourseOnsiteDAO().readCourseOnsite();
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseOnsiteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
}
