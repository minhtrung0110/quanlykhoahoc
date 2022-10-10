/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PersonDAL;
import DTO.Person;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PersonBLL {

    static ArrayList<Person> listPerson;
    static ArrayList<Person> listPersonStudent;
    static ArrayList<Person> listPersonLecturers;
    private PersonDAL data = new PersonDAL();
    public PersonBLL() {
    }

    public ArrayList<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(ArrayList<Person> listPerson) {
        PersonBLL.listPerson = listPerson;
    }

    public void loadDSPerson() throws Exception {
        if (listPerson == null) {
            listPerson = new ArrayList<Person>();
        }
        listPerson = data.loadDatabase();
    }

    public ArrayList<Person> searchPerson(int personID, String firstName, String lastName) {
        ArrayList<Person> search = new ArrayList<>();
        //personID=personID.isEmpty()?personID="":personID;
        firstName = firstName.isEmpty() ? firstName = "" : firstName;
        lastName = lastName.isEmpty() ? lastName = "" : lastName;

        for (Person ps : listPerson) {
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

    public ArrayList<Person> searchPersonWithID(int personID) {
        ArrayList<Person> search = new ArrayList<>();
        //personID=personID.isEmpty()?personID="":personID;

        for (Person ps : listPerson) {

            if (ps.getPersonID() == personID) {

                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<Person> searchPersonWithFirstName(String firstName) {
        ArrayList<Person> search = new ArrayList<>();
        firstName = firstName.isEmpty() ? firstName = "" : firstName;

        for (Person ps : listPerson) {

            if (ps.getFirstname().contains(firstName)) {

                search.add(ps);
            }
        }
        return search;
    }

    public ArrayList<Person> searchPersonWithLastName(String lastName) {
        ArrayList<Person> search = new ArrayList<>();

        lastName = lastName.isEmpty() ? lastName = "" : lastName;

        for (Person ps : listPerson) {

            if (ps.getLastname().contains(lastName)) {

                search.add(ps);
            }
        }
        return search;
    }

    // Thuan
    public ArrayList<Person> getALLPerson() throws Exception {
        PersonDAL data = new PersonDAL();
        ArrayList<Person> listAllPerson = new ArrayList<Person>();
        listAllPerson = data.getALLPerson();
        return listAllPerson;
    }

    //    Giang vien
    public void loadDSPersonLecturers() throws Exception {
        if (listPersonLecturers == null) {
            listPersonLecturers = new ArrayList<Person>();
        }
        listPersonLecturers = data.getAllLecturers();// goi layer DAL đọc Database
    }

    public static ArrayList<Person> getListPersonLecturers() {
        return listPersonLecturers;
    }

    public void addLectures(Person ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.addLecturesDAO(ps);
        listPersonLecturers.add(ps);

    }

    public void editLectures(Person ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.editLecturesDAO(ps);
        listPersonLecturers.add(ps);

    }

    public void deleteLectures(int PersonID) throws Exception {

        for (Person ps : listPersonLecturers) {
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
            listPersonStudent = new ArrayList<Person>();
        }
        listPersonStudent = data.getAllStudent();
    }

    public static ArrayList<Person> getListPersonStudent() {
        return listPersonStudent;
    }

    public void addStudent(Person ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.addStudentDAO(ps);
        listPersonStudent.add(ps);

    }

    public void editStudent(Person ps) throws Exception {
        // validate data
        PersonDAL data = new PersonDAL();
        data.editStudentDAO(ps);
        listPersonStudent.add(ps);

    }

    public void deleteStudent(int PersonID) throws Exception {

        for (Person ps : listPersonStudent) {
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
