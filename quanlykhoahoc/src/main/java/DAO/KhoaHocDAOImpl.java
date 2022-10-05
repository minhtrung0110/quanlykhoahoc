/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author LENOVO
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LENOVO
 */

import DTO.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class KhoaHocDAOImpl implements KhoaHocDAO {
    

    @Override
    public List<CourseDTO> getList() {
        Connection cons = MyDatabaseManager.getConnection();
        String sql = "SELECT * FROM course";
        List<CourseDTO> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseDTO khoaHoc = new CourseDTO();
                khoaHoc.setCourseID(rs.getInt("CourseID"));
                khoaHoc.setTitle(rs.getString("Title"));
                khoaHoc.setDepartmentID(rs.getInt("DepartmentID"));
                
                list.add(khoaHoc);
            }
            ps.close();
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
     @Override
    public int createOrUpdate(CourseDTO khoaHoc) {
        try {
            Connection cons = MyDatabaseManager.getConnection();
            String sql = "INSERT INTO course(CourseID, Title, Credits, DepartmentID) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE  Title = VALUES(Title), DepartmentID = VALUES(DepartmentID);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khoaHoc.getCourseID());
            ps.setString(2, khoaHoc.getTitle());
            ps.setInt(3, 2);
            ps.setInt(4, khoaHoc.getDepartmentID());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
                        System.out.print("loi ham update");

        }
        return 0;
    }

    @Override
    public int delete(CourseDTO khoaHoc) {
        try {
            Connection cons = MyDatabaseManager.getConnection();
            PreparedStatement st = cons.prepareStatement("DELETE FROM course WHERE CourseID = ?");
            st.setString(1,String.valueOf(khoaHoc.CourseID));
            st.executeUpdate();
            st.close();
            cons.close();
            return 1;
        } catch (Exception ex) {
                        System.out.print("loi ham delete");
                        return -1;

        }
       
    }
    
}
