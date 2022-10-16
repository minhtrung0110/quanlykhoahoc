/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Department;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class DepartmentDAL extends MyConnectUnit {
    public DepartmentDAL() {
        super();
    }
    
    
        
    public ArrayList<Department> loadDepartment() throws Exception{
        ArrayList<Department> listDepartment = new ArrayList<>();
        try {
            ResultSet rs = this.Select("department");
            while (rs.next()) {                
                Department department = new Department(
                        rs.getInt("DepartmentID"), 
                        rs.getString("Name"),
                        rs.getDouble("Budget"),
                        rs.getDate("StartDate"),
                        rs.getInt("Administrator")
                );
                listDepartment.add(department);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Course");
        }
        return listDepartment;
    }
    
//    public static void main(String[] args) throws Exception {
////        try {
////            new DepartmentDAO().readDepartments();
////        } catch (SQLException ex) {
////            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
////        }
//
//        DepartmentDAL dal = new DepartmentDAL();
//        dal.loadDepartment().forEach(System.out::println);
//        
//    }
}
