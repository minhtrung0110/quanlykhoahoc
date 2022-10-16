/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.ArrayList;
import DTO.Department;
import DAL.DepartmentDAL;

/**
 *
 * @author vonhu
 */
public class DepartmentBLL {
    static ArrayList<Department> listDepartment;
    private DepartmentDAL data = new DepartmentDAL();

    public DepartmentBLL() {
    }
    
    public static ArrayList<Department> getListDepartment(){
        return listDepartment;
    }
    
    public void loadDepartment() throws Exception {

        if (listDepartment == null) {
            listDepartment = new ArrayList<Department>();
        }
        listDepartment = data.loadDepartment();
    }
    
    public static void main(String[] args) throws Exception {
        DepartmentBLL dll = new DepartmentBLL();
        dll.loadDepartment();
        getListDepartment().forEach(s->System.out.println(s));
    }
}
