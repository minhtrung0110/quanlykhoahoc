/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DATA.DepartmentDAO;
import DTO.DepartmentDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trankimphu0609
 */
public class DepartmentBUS {

    public static ArrayList<DepartmentDTO> ds;

    public DepartmentBUS() {

    }

    public void ReadDepartment() throws SQLException, Exception {
        DepartmentDAO dao = new DepartmentDAO();
        if (ds == null) {
            ds = new ArrayList<DepartmentDTO>();
            ds = dao.list();
        }
    }

    public void AddDepartment(DepartmentDTO de) throws Exception {
        DepartmentDAO dao = new DepartmentDAO();
        dao.add(de);
        ds.add(de);

    }

    public void DeleteDepartment(int DepartmentID) throws Exception {
        for (DepartmentDTO de : ds) {
            if (de.getDepartmentID() == DepartmentID) {
                ds.remove(de);
                DepartmentDAO dao = new DepartmentDAO();
                dao.delete(DepartmentID);
                return;
            }
        }
    }

    public void SetDepartment(DepartmentDTO de) throws Exception {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getDepartmentID() == de.getDepartmentID()) {
                ds.set(i, de);
            }
        }
        DepartmentDAO dao = new DepartmentDAO();
        dao.set(de);
    }

    public DepartmentDTO SearchDepartment(int DepartmentID) {
        for (DepartmentDTO de : ds) {
            if (de.getDepartmentID() == DepartmentID) {
                return de;
            }
        }
        return null;
    }

    public ArrayList<DepartmentDTO> SearchDepartmentName(String Name) {
        ArrayList<DepartmentDTO> kq = new ArrayList<DepartmentDTO>();
        for (DepartmentDTO de : ds) {
            if (de.getName().indexOf(Name) >= 0) {
                kq.add(de);
            }
        }
        return kq;
    }

//    public static void main(String[] args) throws Exception {
//        new DepartmentBUS().ReadDepartment();
//    }
}
