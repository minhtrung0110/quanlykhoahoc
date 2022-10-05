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
public class KhoaHocServiceImpl implements KhoaHocService {

    private KhoaHocDAO khoaHocnDAO = null;

    public KhoaHocServiceImpl() {
        this.khoaHocnDAO = new KhoaHocDAOImpl();
    }

    @Override
    public List<CourseDTO> getList() {
        return khoaHocnDAO.getList();
    }
    
    @Override
    public int createOrUpdate(CourseDTO khoahoc) {
        return khoaHocnDAO.createOrUpdate(khoahoc);
    }
    @Override
    public int delete(CourseDTO khoahoc) {
        return khoaHocnDAO.delete(khoahoc);
    }
}