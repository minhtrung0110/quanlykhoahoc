/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trankimphu0609
 */
public class PersonDTO {

    public int PersonID;
    public String Lastname, Firstname;
    public String HireDate, EnrollmentDate;

    public PersonDTO() {
    }

    public PersonDTO(int PersonID, String Lastname, String Firstname, String HireDate, String EnrollmentDate) {
        this.PersonID = PersonID;
        this.Lastname = Lastname;
        this.Firstname = Firstname;
        this.HireDate = HireDate;
        this.EnrollmentDate = EnrollmentDate;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
    }

    public String getEnrollmentDate() {
        return EnrollmentDate;
    }

    public void setEnrollmentDate(String EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
    }

    @Override
    public String toString() {
        return "\nPersonDTO{" + "PersonID=" + PersonID + ", Lastname=" + Lastname + ", Firstname=" + Firstname + ", HireDate=" + HireDate + ", EnrollmentDate=" + EnrollmentDate + '}';
    }

}
