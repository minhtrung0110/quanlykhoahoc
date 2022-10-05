/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PersonDAL;
import DTO.PersonDTO;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PersonBLL {

    static ArrayList<PersonDTO> listPerson;
    static ArrayList<PersonDTO> listPersonStudent;
    static ArrayList<PersonDTO> listPersonLecturers;

    public PersonBLL() {
    }

    public ArrayList<PersonDTO> getListPerson() {
        return listPerson;
    }

    public void setListPerson(ArrayList<PersonDTO> listPerson) {
        PersonBLL.listPerson = listPerson;
    }

    public void loadDSPerson() throws Exception {
        PersonDAL data = new PersonDAL();
        if (listPerson == null) {
            listPerson = new ArrayList<PersonDTO>();
        }
        listPerson = data.loadDatabase();
    }

    public ArrayList<PersonDTO> searchPerson(int personID, String firstName, String lastName) {
        ArrayList<PersonDTO> search = new ArrayList<>();
        //personID=personID.isEmpty()?personID="":personID;
        firstName = firstName.isEmpty() ? firstName = "" : firstName;
        lastName = lastName.isEmpty() ? lastName = "" : lastName;

        for (PersonDTO ps : listPerson) {
            /* System.out.println(sach.getMaPerson().contains(masach) );

            System.out.println( sach.getMaNXB().contains(manxb));
            System.out.println( sach.getMaTG().contains(matg)  );
            System.out.println( sach.getMaTL().contains(matl) );
            System.out.println( sach.getTenPerson().contains(tensach));
            System.out.println( sach.getNamXuatBan()>= namxbmin && sach.getNamXuatBan()<= namxbmax );
            System.out.println(sach.getDongia() >= min && sach.getDongia() <= max );*/

            if (ps.getPersonID() == personID
                    && ps.getFirstname().contains(firstName)
                    && ps.getLastname().contains(lastName)) {

                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<PersonDTO> searchPersonWithID(int personID) {
        ArrayList<PersonDTO> search = new ArrayList<>();
        //personID=personID.isEmpty()?personID="":personID;

        for (PersonDTO ps : listPerson) {

            if (ps.getPersonID() == personID) {

                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<PersonDTO> searchPersonWithFirstName(String firstName) {
        ArrayList<PersonDTO> search = new ArrayList<>();
        firstName = firstName.isEmpty() ? firstName = "" : firstName;

        for (PersonDTO ps : listPerson) {

            if (ps.getFirstname().contains(firstName)) {

                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<PersonDTO> searchPersonWithLastName(String lastName) {
        ArrayList<PersonDTO> search = new ArrayList<>();

        lastName = lastName.isEmpty() ? lastName = "" : lastName;

        for (PersonDTO ps : listPerson) {

            if (ps.getLastname().contains(lastName)) {

                search.add(ps);
            }
        }
        return search;
    }

    // Thuan
    public ArrayList<PersonDTO> getALLPerson() throws Exception {
        PersonDAL data = new PersonDAL();
        ArrayList<PersonDTO> listAllPerson = new ArrayList<PersonDTO>();
        listAllPerson = data.getALLPerson();
        return listAllPerson;
    }

    //    Giang vien
    public void loadDSPersonLecturers() throws Exception {
        PersonDAL data = new PersonDAL();
        if (listPersonLecturers == null) {
            listPersonLecturers = new ArrayList<PersonDTO>();
        }
        listPersonLecturers = data.getAllLecturers();
    }

    public static ArrayList<PersonDTO> getListPersonLecturers() {
        return listPersonLecturers;
    }

    public void addLectures(PersonDTO ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.addLecturesDAO(ps);
        listPersonLecturers.add(ps);

    }

    public void editLectures(PersonDTO ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.editLecturesDAO(ps);
        listPersonLecturers.add(ps);

    }

    public void deleteLectures(int PersonID) throws Exception {

        for (PersonDTO ps : listPersonLecturers) {
            if (ps.getPersonID() == PersonID) {
                try {
                    listPersonLecturers.remove(ps);
                    PersonDAL data = new PersonDAL();
                    data.deleteLecturesDAO(PersonID);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa giảng viên !!!");
                }
                return;
            }
        }

    }

    //    Hoc vien
    public void loadDSPersonStudent() throws Exception {
        PersonDAL data = new PersonDAL();
        if (listPersonStudent == null) {
            listPersonStudent = new ArrayList<PersonDTO>();
        }
        listPersonStudent = data.getAllStudent();
    }

    public static ArrayList<PersonDTO> getListPersonStudent() {
        return listPersonStudent;
    }

    public void addStudent(PersonDTO ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.addStudentDAO(ps);
        listPersonStudent.add(ps);

    }

    public void editStudent(PersonDTO ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.editStudentDAO(ps);
        listPersonStudent.add(ps);

    }

    public void deleteStudent(int PersonID) throws Exception {

        for (PersonDTO ps : listPersonStudent) {
            if (ps.getPersonID() == PersonID) {
                try {
                    listPersonStudent.remove(ps);
                    PersonDAL data = new PersonDAL();
                    data.deleteStudentDAO(PersonID);
                } catch (Exception e) {
                    System.out.println("Không the xóa học viên !!!");
                }
                return;
            }
        }

    }
}
