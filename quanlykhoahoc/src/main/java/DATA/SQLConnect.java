/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author trankimphu0609
 */
public class SQLConnect {

    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/School2?useUnicode=true&characterEncoding=UTF-8";
    Connection conn = null;

    public Connection open() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (java.sql.SQLException e) {
            throw new Exception("không thể kết nối");
        }
        return this.conn;
    }

}
