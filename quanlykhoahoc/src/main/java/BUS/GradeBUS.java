/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.GradeDAO;
import DTO.GradeDTO;
import java.util.ArrayList;

/**
 *
 * @author trankimphu0609
 */
public class GradeBUS {

    static ArrayList<GradeDTO> listGrade;

    public GradeBUS() {

    }

    public void loadDSGrade() throws Exception {
        GradeDAO data = new GradeDAO();
        if (listGrade == null) {
            listGrade = new ArrayList<GradeDTO>();
        }
        listGrade = data.loadDatabase();
    }

    public void addGrade(GradeDTO g) throws Exception {
        GradeDAO data = new GradeDAO();
        data.addGrade(g);
        listGrade.add(g);
    }

    public void deleteGrade(int enrollmentID) throws Exception {
        for (GradeDTO g : listGrade) {
            if (g.getEnrollmentID() == enrollmentID) {
                try {
                    listGrade.remove(g);
                    GradeDAO data = new GradeDAO();
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
                    GradeDAO data = new GradeDAO();
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
        GradeBUS.listGrade = listGrade;
    }

    public static ArrayList<GradeDTO> getListGrade() {
        return listGrade;
    }

}
