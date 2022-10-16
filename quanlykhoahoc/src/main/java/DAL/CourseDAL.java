/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import DTO.CourseOnline;
import DTO.CourseOnsite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author trankimphu0609
 */
public class CourseDAL extends MyConnectUnit {

    public CourseDAL() {
        super();

    }

    public ArrayList<Course> loadDatabase(String orderby) throws Exception {
        ArrayList<Course> listCourse = new ArrayList<>();
        try {
            ResultSet rs = this.SelectCustomJoin("course as cs",
                    "cs.CourseID,cs.Title,cs.Credits,cs.DepartmentID, cson.url,cssite.Location, cssite.Days,cssite.Time",
                    "LEFT OUTER JOIN onsitecourse as cssite ON cs.CourseID=cssite.CourseID LEFT OUTER JOIN onlinecourse as cson ON cs.CourseID=cson.CourseID",
                    "cs.CourseID " + orderby
            );
            while (rs.next()) {
                if (rs.getString("url") == null) {
                    Course cssite = new CourseOnsite(
                            rs.getInt("CourseID"), rs.getString("Title"),
                            rs.getInt("Credits"), rs.getInt("DepartmentID"),
                            rs.getString("Location"), rs.getString("Days"), rs.getString("Time")
                    );
                    listCourse.add((Course) cssite);
                } else {
                    Course cson = new CourseOnline(
                            rs.getInt("CourseID"), rs.getString("Title"),
                            rs.getInt("Credits"), rs.getInt("DepartmentID"),
                            rs.getString("url")
                    );
                    listCourse.add((Course) cson);
                }
            }
            rs.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Course");
        }
        return listCourse;
    }

    public ArrayList<Course> loadDatabaseV2() throws Exception {
        ArrayList<Course> listCourse = new ArrayList<>();
        try {
            ResultSet rsOnline = this.Select("onlinecourse");
            while (rsOnline.next()) {
                Course csin = new Course(
                        rsOnline.getInt("CourseID"), rsOnline.getString("Title"),
                        rsOnline.getInt("Credits"), rsOnline.getInt("DepartmentID")
                );
                listCourse.add(csin);
            }
            rsOnline.close();
            this.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Course");
        }
        return listCourse;
    }

    private void addCourseOnline(CourseOnline cs) throws Exception {
        HashMap<String, Object> InsertvaluesCourse = new HashMap<String, Object>();
        HashMap<String, Object> InsertvaluesCourseOnline = new HashMap<String, Object>();

        InsertvaluesCourse.put("CourseID", cs.getCourseID());
        InsertvaluesCourse.put("Title", cs.getTitle());
        InsertvaluesCourse.put("Credits", cs.getCredits());
        InsertvaluesCourse.put("DepartmentID", cs.getDepartmentID());
        InsertvaluesCourseOnline.put("url", cs.getUrl());

        try {
            this.Insert("course", InsertvaluesCourse);
            ResultSet rs = this.SelectCustomOrderby("course", "CourseID", null, "CourseID DESC limit 1");
            while (rs.next()) {
                InsertvaluesCourseOnline.put("CourseID", rs.getInt("CourseID"));
                System.out.print(rs.getInt("CourseID"));
            }

            this.Insert("onlinecourse", InsertvaluesCourseOnline);
        } catch (SQLException ex) {
            System.out.println("Khong the them CourseOnline vao database !!!");
        }
    }

    private int getCourseIDNearly() throws Exception {
        ResultSet rs = this.SelectCustomOrderby("course", "CourseID", null, "CourseID DESC limit 1");
        while (rs.next()) {

            return rs.getInt("CourseID");
        }
        return -1;
    }

    private void addCourseOnSite(CourseOnsite cs) throws Exception {
        HashMap<String, Object> InsertvaluesCourse = new HashMap<String, Object>();
        HashMap<String, Object> InsertvaluesCourseOnsite = new HashMap<String, Object>();

        InsertvaluesCourse.put("CourseID", cs.getCourseID());
        InsertvaluesCourse.put("Title", cs.getTitle());
        InsertvaluesCourse.put("Credits", cs.getCredits());
        InsertvaluesCourse.put("DepartmentID", cs.getDepartmentID());
        InsertvaluesCourseOnsite.put("Location", cs.getLocation());
        InsertvaluesCourseOnsite.put("Days", cs.getDays());
        InsertvaluesCourseOnsite.put("Time", cs.getTime());
        try {
            this.Insert("course", InsertvaluesCourse);
            //  ResultSet rs = this.SelectCustomOrderby("course", "CourseID", null, "CourseID DESC limit 1");
            //  while (rs.next()) {

            InsertvaluesCourseOnsite.put("CourseID", this.getCourseIDNearly());
            // }
            // System.out.println(InsertvaluesCourseOnsite);
            // InsertvaluesCourseOnsite.forEach(action);
            this.Insert("onsitecourse", InsertvaluesCourseOnsite);

        } catch (Exception ex) {
            System.out.println("Khong the them CourseOnsite vao database !!!");
        }
    }

    public void addCourse(Course cs) {
        try {
            if (cs instanceof CourseOnline) {
                this.addCourseOnline((CourseOnline) cs);
            } else {

                this.addCourseOnSite((CourseOnsite) cs);
            }
        } catch (Exception ex) {
            System.out.println("Khong the them Courses vao database !!!");
        }
    }

    private void updateCourseOnline(int id, CourseOnline cs) throws Exception {

        HashMap<String, Object> UpdatevaluesCourseOnline = new HashMap<String, Object>();
        UpdatevaluesCourseOnline.put("url", cs.getUrl());
        try {
            this.Update("onlinecourse", UpdatevaluesCourseOnline, "CourseID ='" + id + "'");
        } catch (SQLException ex) {
            System.out.println("Khong the cap nhat CourseOnline !!!");
        }
    }

    private void updateCourseOnsite(int id, CourseOnsite cs) throws Exception {

        HashMap<String, Object> UpdatevaluesCourseOnsite = new HashMap<String, Object>();
        UpdatevaluesCourseOnsite.put("Location", cs.getLocation());
        UpdatevaluesCourseOnsite.put("Days", cs.getDays());
        UpdatevaluesCourseOnsite.put("Time", cs.getTime());

        try {
            this.Update("onsitecourse", UpdatevaluesCourseOnsite, "CourseID ='" + id + "'");
        } catch (SQLException ex) {
            System.out.println("Khong the cap nhat CourseOnline !!!");
        }
    }

    public void updateCourse(int id, Course cs) throws Exception {
        HashMap<String, Object> UpdatevaluesCourse = new HashMap<String, Object>();
        UpdatevaluesCourse.put("CourseID", cs.getCourseID());
        UpdatevaluesCourse.put("Title", cs.getTitle());
        UpdatevaluesCourse.put("Credits", cs.getCredits());
        UpdatevaluesCourse.put("DepartmentID", cs.getDepartmentID());
        try {

            this.Update("course", UpdatevaluesCourse, "CourseID ='" + id + "'");
            ResultSet rs = this.Select("onlinecourse", "CourseID ='" + id + "'");
            if (cs instanceof CourseOnsite) {
                this.updateCourseOnsite(id, (CourseOnsite) cs);
            } else {
                this.updateCourseOnline(id, (CourseOnline) cs);
            }

        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat Course vao database !!!");
        }
    }

    public void deleteCourse(int courseID) {

        try {
            ResultSet rs = this.Select("onlinecourse", "CourseID ='" + courseID + "'");
            int check = -1;
            while (rs.next()) {
                check = rs.getInt("CourseID");
            }
            System.out.println("check: " + check);
            if (check == -1) {
                this.Delete("onsitecourse", "CourseID ='" + courseID + "'");
                this.Delete("course", "CourseID ='" + courseID + "'");
            } else {
                this.Delete("onlinecourse", "CourseID ='" + courseID + "'");
                this.Delete("course", "CourseID ='" + courseID + "'");
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể xóa course item !!");
        }
    }

    public static void main(String[] args) throws Exception {
        CourseDAL data = new CourseDAL();
        data.deleteCourse(4061);
//        System.out.println("delte: " + data.deleteCourse(4061));
//        CourseOnline cson = new CourseOnline();
//        //  cson.setCourseID(0);
//        cson.setTitle("Da Update");
//        cson.setCredits(250000);
//        cson.setDepartmentID(2);
//        cson.setUrl("htttp://ggmet-cucu-akkl-uoiy");
//        CourseOnsite cssite = new CourseOnsite();
//        //  cssite.setCourseID(0);
//        cssite.setTitle("A");
//        cssite.setCredits(250000);
//        cssite.setDepartmentID(2);
//        cssite.setLocation("C.E403");
        // cssite.setDays(new Date("2022-10-10"));
        //   cssite.setTime(new Date("2022-10-10"));
        // data.addCourseOnSite(cssite);
        //data.addCourseOnline(cson);
        //  data.update(4068,cson);

    }
}
