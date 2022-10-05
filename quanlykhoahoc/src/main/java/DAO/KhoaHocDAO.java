/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.CourseDTO;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface KhoaHocDAO {
    public List<CourseDTO> getList();
    
    public int createOrUpdate(CourseDTO khoaHoc);
     public int delete(CourseDTO khoaHoc);
}
