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
public class CourseOnlineDAL extends MyDatabaseManager {
    public CourseOnlineDAL() {
        super();
        this.connectDB();
    }
    
    public void readCourseOnline() throws SQLException {
        String query = "SELECT * FROM OnlineCourse";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
//                System.out.print(i + " - ");
                System.out.println(rs.getString("CourseID") + " " + rs.getString("url"));
                i++;
            }
        }
            

    }

    
}
