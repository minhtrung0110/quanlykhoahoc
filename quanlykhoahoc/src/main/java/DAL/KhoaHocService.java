/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import DTO.CourseDTO;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface KhoaHocService {
    public List<CourseDTO> getList();
    
    public int createOrUpdate(CourseDTO khoaHoc);
}