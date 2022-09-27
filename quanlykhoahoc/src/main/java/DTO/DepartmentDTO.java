/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author trankimphu0609
 */
public class DepartmentDTO {
    
    public int DepartmentID;
    public String Name;
    public int Budget;
    public String StartDate;
    public int Administrator;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int DepartmentID, String Name, int Budget, String StartDate, int Administrator) {
        this.DepartmentID = DepartmentID;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
        this.Administrator = Administrator;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int Budget) {
        this.Budget = Budget;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" + "DepartmentID=" + DepartmentID + ", Name=" + Name + ", Budget=" + Budget + ", StartDate=" + StartDate + ", Administrator=" + Administrator + '}';
    }
    
    
    
    
}
