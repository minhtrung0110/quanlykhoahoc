/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.MyDatabaseManager;
import DTO.PersonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trankimphu0609
 */
public class PersonDAO extends MyConnectUnit{
    ArrayList<PersonDTO> listPersonDTOs;
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

    // Thuan
    public ArrayList<PersonDTO> getALLPerson() throws Exception
    {
        ArrayList<PersonDTO> dssach = new ArrayList<>();
        try {
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
     public ArrayList<PersonDTO> getAllLecturers() throws  Exception {
          ArrayList<PersonDTO> dssach = new ArrayList<>();
        try {
        
            ResultSet rs = this.SelectCustom("person as ps","ps.PersonID,ps.Lastname, ps.Firstname,ps.HireDate,ps.EnrollmentDate","ps.HireDate IS NOT NULL ORDER BY PersonID DESC");
            while(rs.next())
            {
                PersonDTO psDTO=new PersonDTO(
                      rs.getInt("PersonID"),rs.getString("Lastname"),
                                       rs.getString("Firstname"),rs.getDate("HireDate"),rs.getDate("EnrollmentDate")
               );       
                dssach.add(psDTO);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Person: "+ex);
        }

        return dssach;
            
    }

// thêm 
    public void addLecturesDAO(PersonDTO personDTO) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String,Object> objMap =new  HashMap<String,Object>();
           objMap.put("PersonID",personDTO.getPersonID());
           objMap.put("Lastname",  personDTO.getLastname());
           objMap.put("Firstname",personDTO.getFirstname());
           objMap.put("HireDate",dateFormat.format(personDTO.getHireDate()));
          
           try {
             this.Insert("person",objMap);
        } catch (Exception e) {
               System.out.println("Không thể thêm giảng viên mới . Vui lòng kiểm tra lai ");
        }
       
    }
    // Sửa
    public void editLecturesDAO(PersonDTO personDTO) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String,Object> objMap =new  HashMap<String,Object>();
           objMap.put("PersonID",personDTO.getPersonID());
           objMap.put("Lastname",  personDTO.getLastname());
           objMap.put("Firstname",personDTO.getFirstname());
           objMap.put("HireDate",dateFormat.format(personDTO.getHireDate()));
          
           try {
             this.Update("person",objMap,"PersonID='"+personDTO.getPersonID()+"'");
        } catch (Exception e) {
               System.out.println("Không thể thêm giảng viên mới . Vui lòng kiểm tra lai ");
        }
       
    }
    
    // Xóa
     public void deleteLecturesDAO(int PerSonID)
    {
        try {
                    this.Delete("person","PersonID ='"+PerSonID+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa giảng viên !");
                }
        
    }
     
      //     Hoc vien
     public ArrayList<PersonDTO> getAllStudent() throws  Exception {
          ArrayList<PersonDTO> dssach = new ArrayList<>();
        try {
        
            ResultSet rs = this.SelectCustom("person as ps","ps.PersonID,ps.Lastname, ps.Firstname,ps.HireDate,ps.EnrollmentDate","ps.EnrollmentDate IS NOT NULL ORDER BY PersonID DESC");
            while(rs.next())
            {
                PersonDTO psDTO=new PersonDTO(
                      rs.getInt("PersonID"),rs.getString("Lastname"),
                                       rs.getString("Firstname"),rs.getDate("HireDate"),rs.getDate("EnrollmentDate")
               );       
                dssach.add(psDTO);
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Person: "+ex);
        }

        return dssach;
            
    }

// thêm 
    public void addStudentDAO(PersonDTO personDTO) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String,Object> objMap =new  HashMap<String,Object>();
           objMap.put("PersonID",personDTO.getPersonID());
           objMap.put("Lastname",  personDTO.getLastname());
           objMap.put("Firstname",personDTO.getFirstname());
           objMap.put("EnrollmentDate",dateFormat.format(personDTO.getEnrollmentDate()));
          
           try {
             this.Insert("person",objMap);
        } catch (Exception e) {
               System.out.println("Không thể thêm học viên mới . Vui lòng kiểm tra lại ");
        }
       
    }
    // Sửa
    public void editStudentDAO(PersonDTO personDTO) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String,Object> objMap =new  HashMap<String,Object>();
           objMap.put("PersonID",personDTO.getPersonID());
           objMap.put("Lastname",  personDTO.getLastname());
           objMap.put("Firstname",personDTO.getFirstname());
           objMap.put("EnrollmentDate",dateFormat.format(personDTO.getEnrollmentDate()));
          
           try {
             this.Update("person",objMap,"PersonID='"+personDTO.getPersonID()+"'");
        } catch (Exception e) {
               System.out.println("Không thể thêm học viên mới . Vui lòng kiểm tra lai ");
        }
       
    }
    
    // Xóa
     public void deleteStudentDAO(int PerSonID)
    {
        try {
                    this.Delete("person","PersonID ='"+PerSonID+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa học viên !");
                }
        
    }
     
    public static void main(String[] args) throws Exception {
            
            PersonDAO cs=new PersonDAO();
         cs.getAllStudent().forEach( (n) -> { System.out.println(n); } );
          cs.loadDatabase().forEach( (n) -> { System.out.println(n); } );
        
    }
  
}
