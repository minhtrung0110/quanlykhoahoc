/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class CourseOnsiteDAL extends MyDatabaseManager {
    public CourseOnsiteDAL() {
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
    public static void main(String[] args) {
        try {
            new CourseOnsiteDAL().readCourseOnsite();
        } catch (SQLException ex) {
            Logger.getLogger(CourseOnsiteDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
