/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class MyDatabaseManager {
    private Connection c;
    private Statement s;
    private PreparedStatement p;
    private String host, port, dbName, dbUser, dbPassword;
    
    MyDatabaseManager() {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "School2";
        dbPassword = "";
    }
    
    public void connectDB() {
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s = c.createStatement();
            System.out.print("Connected \n");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school2", "root", "");
        } catch (Exception e) {
            System.out.print("ko ket noi duoc");
        }
        return cons;
    }
    
    public ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void doUpdateQuery() throws SQLException {
        try {
           p.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new MyDatabaseManager().connectDB();
    }
}
