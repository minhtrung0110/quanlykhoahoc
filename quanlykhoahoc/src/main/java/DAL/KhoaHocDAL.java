/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import DTO.Course;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface KhoaHocDAL {
    public List<Course> getList();
    
    public int createOrUpdate(Course khoaHoc);
     public int delete(Course khoaHoc);

}
