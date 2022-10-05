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
public class KhoaHocServiceImpl implements KhoaHocService {

    private KhoaHocDAL khoaHocnDAO = null;

    public KhoaHocServiceImpl() {
        this.khoaHocnDAO = new KhoaHocDALImpl();
    }

    @Override
    public List<CourseDTO> getList() {
        return khoaHocnDAO.getList();
    }
    
    @Override
    public int createOrUpdate(CourseDTO khoahoc) {
        return khoaHocnDAO.createOrUpdate(khoahoc);
    }
}