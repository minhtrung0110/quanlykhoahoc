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
    
    public ArrayList<PersonDTO> searchPerson(int personID,String firstName,String lastName)
    {
        ArrayList<PersonDTO> search = new ArrayList<>();
        //personID=personID.isEmpty()?personID="":personID;
        firstName=firstName.isEmpty()?firstName="":firstName;
        lastName=lastName.isEmpty()?lastName="":lastName;

        for(PersonDTO ps : listPerson)
        {
            /* System.out.println(sach.getMaPerson().contains(masach) );

            System.out.println( sach.getMaNXB().contains(manxb));
            System.out.println( sach.getMaTG().contains(matg)  );
            System.out.println( sach.getMaTL().contains(matl) );
            System.out.println( sach.getTenPerson().contains(tensach));
            System.out.println( sach.getNamXuatBan()>= namxbmin && sach.getNamXuatBan()<= namxbmax );
            System.out.println(sach.getDongia() >= min && sach.getDongia() <= max );*/
            
             if( ps.getPersonID()==personID && 
                 ps.getFirstname().contains(firstName) && 
                     ps.getLastname().contains(lastName) )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
    public ArrayList<PersonDTO> searchPersonWithID(int personID)
    {
        ArrayList<PersonDTO> search = new ArrayList<>();
        //personID=personID.isEmpty()?personID="":personID;

        for(PersonDTO ps : listPerson)
        {
          
             if( ps.getPersonID()==personID )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
    
    public ArrayList<PersonDTO> searchPersonWithFirstName(String firstName)
    {
        ArrayList<PersonDTO> search = new ArrayList<>();
        firstName=firstName.isEmpty()?firstName="":firstName;

        for(PersonDTO ps : listPerson)
        {
            
             if( 
                 ps.getFirstname().contains(firstName)  )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
    public ArrayList<PersonDTO> searchPersonWithLastName(String lastName)
    {
        ArrayList<PersonDTO> search = new ArrayList<>();
       
        lastName=lastName.isEmpty()?lastName="":lastName;

        for(PersonDTO ps : listPerson)
        {
         
             if( 
                     ps.getLastname().contains(lastName) )
            {
                
                search.add(ps);
            }
        }
        return search;
    }
    
}
