/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PersonDAO;
import DTO.PersonDTO;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PersonBUS {
      static ArrayList<PersonDTO> listPerson;
    public PersonBUS() {
    }

    public  ArrayList<PersonDTO> getListPerson() {
        return listPerson;
    }

    public void setListPerson(ArrayList<PersonDTO> listPerson) {
        PersonBUS.listPerson = listPerson;
    }
    
    
    public void  loadDSPerson() throws Exception{
        PersonDAO data =new PersonDAO();
        if(listPerson==null) listPerson = new ArrayList<PersonDTO>();
        listPerson=data.loadDatabase();
    }
    
}
