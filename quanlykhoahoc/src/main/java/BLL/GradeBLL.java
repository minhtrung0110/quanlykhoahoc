/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.GradeDAL;
import DTO.GradeDTO;
import java.util.ArrayList;

/**
 *
 * @author trankimphu0609
 */
public class GradeBLL {

    static ArrayList<GradeDTO> listGrade;

    public GradeBLL() {

    }

    public void loadDSGrade() throws Exception {
        GradeDAL data = new GradeDAL();
        if (listGrade == null) {
            listGrade = new ArrayList<GradeDTO>();
        }
        listGrade = data.loadDatabase();
    }

    public void addGrade(GradeDTO g) throws Exception {
        GradeDAL data = new GradeDAL();
        data.addGrade(g);
        listGrade.add(g);
    }

    public void deleteGrade(int enrollmentID) throws Exception {
        for (GradeDTO g : listGrade) {
            if (g.getEnrollmentID() == enrollmentID) {
                try {
                    listGrade.remove(g);
                    GradeDAL data = new GradeDAL();
                    data.deleteGrade(enrollmentID);
                } catch (Exception e) {
                    System.out.println("Khong the xoa Grade vao database");
                }
                return;
            }
        }
    }

    public void updateGrade(int id, GradeDTO g) throws Exception {
        for (int i = 0; i < listGrade.size(); i++) {
            if (listGrade.get(i).getEnrollmentID() == g.getEnrollmentID()) {
                try {
                    listGrade.set(i, g);
                    GradeDAL data = new GradeDAL();
                    data.updateGrade(id, g);
                } catch (Exception e) {
                    System.out.println("Khong the cap nhat Grade vao database !!!");
                }
                return;
            }
        }
    }

    public ArrayList<GradeDTO> searchGrade(int courseID, int studentID) {
        ArrayList<GradeDTO> search = new ArrayList<>();

        for (GradeDTO g : listGrade) {
            if (g.getCourseID() == courseID && g.getStudentID() == studentID) {
                search.add(g);
            }
        }
        return search;
    }

    public ArrayList<GradeDTO> searchGradeWithCourseID(int courseID) {
        ArrayList<GradeDTO> search = new ArrayList<>();

        for (GradeDTO g : listGrade) {
            if (g.getCourseID() == courseID) {
                search.add(g);
            }
        }
        return search;
    }

    public ArrayList<GradeDTO> searchGradeWithStudentID(int studentID) {
        ArrayList<GradeDTO> search = new ArrayList<>();

        for (GradeDTO g : listGrade) {
            if (g.getStudentID() == studentID) {
                search.add(g);
            }
        }
        return search;
    }

    public static void setListGrade(ArrayList<GradeDTO> listGrade) {
        GradeBLL.listGrade = listGrade;
    }

    public static ArrayList<GradeDTO> getListGrade() {
        return listGrade;
    }

    public static void main(String[] args) throws Exception {
        GradeBLL bll = new GradeBLL();
        bll.loadDSGrade();
        ArrayList<GradeDTO> ar = new ArrayList<>();
        ar = bll.searchGradeWithCourseID(4061);
        ar.forEach(s-> System.out.println(s));
    }
}
