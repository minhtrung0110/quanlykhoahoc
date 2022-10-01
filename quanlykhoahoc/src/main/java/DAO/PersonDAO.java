/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.MyDatabaseManager;
import DTO.PersonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class PersonDAO extends MyConnectUnit{
    public PersonDAO() {
        super();
        
    }
     public ArrayList<PersonDTO> loadDatabase() throws Exception
    {
        ArrayList<PersonDTO> dssach = new ArrayList<>();
        try {
            //select cs.CourseID,cs.Title, ps.PersonID, ps.Lastname, ps.Firstname from course as cs , person as ps, courseinstructor as csin 
            //where cs.CourseID=csin.CourseID AND ps.PersonID=csin.PersonID;
            ResultSet rs = this.Select("person");
            while(rs.next())
            {
               PersonDTO ps = new  PersonDTO(
                     rs.getInt("PersonID"),rs.getString("Lastname"),
                       rs.getString("Firstname"),rs.getDate("HireDate"),rs.getDate("EnrollmentDate")
               );       
                dssach.add(ps);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Person: "+ex);
        }

        return dssach;
    }
  /*  public void readPersons() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
//                System.out.print(i + " - ");
                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                i++;
            }
        }
            

    }*/
    public static void main(String[] args) throws Exception {
           PersonDAO cs=new PersonDAO();
          cs.loadDatabase().forEach( (n) -> { System.out.println(n); } );
      
    }
}
