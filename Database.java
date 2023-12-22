package com.example.demo2;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;

public class Database {


    public static Connection connectDB() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecting");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root"
                    , "root");
            System.out.println("connected");


            return connection;


        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;


    }


      public static void slogin(String name, int nationalId, GENDER gender, String location,
                                Double secondarySchoolGrade, int age, long phoneNumber){
          Connection connection = connectDB();
          PreparedStatement prepared;
          ResultSet result;

          try{

              assert connection != null;
              prepared = connection.prepareStatement("INSERT INTO users (name, NID, GENDER, location, secgrade, " +
                      "age, phone) VALUES (?, ?, ?, ?, ?, ?, ?)");
              prepared.setString(1,name);
              prepared.setInt(2,nationalId);
              prepared.setString(3,gender.toString());
              prepared.setString(4,location);
              prepared.setDouble(5,secondarySchoolGrade);
              prepared.setInt(6,age);
              prepared.setLong(7,phoneNumber);
              prepared.executeUpdate();

          }catch (SQLException e){


              e.printStackTrace();
          }

      }



    public static void elogin(String name, int nationalId, GENDER gender, String location, int age, int phoneNumber,
                              JopTitle jobTitle, String employmentDate ,CollegeDepartments department) {
        Connection connection = connectDB();
        PreparedStatement prepared;
        ResultSet result;

        try {

            assert connection != null;
            prepared = connection.prepareStatement("INSERT INTO employee  (name, NID, GENDER, location, age," +
                    " phonenumber,joptitle,employmentdate,department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            prepared.setString(1, name);
            prepared.setInt(2, nationalId);
            prepared.setString(3, gender.toString());
            prepared.setString(4, location);
            prepared.setDouble(5, age);
            prepared.setLong(6, phoneNumber);
            prepared.setString(7, jobTitle.toString());
            prepared.setString(8, employmentDate);
            prepared.setString(9, department.toString());
            prepared.executeUpdate();


        } catch (SQLException e) {


            e.printStackTrace();
        }
    }

        public static void creatTrips(String Location, String Title, String date, int Price, String Description ){
            Connection connection = connectDB();
            PreparedStatement prepared;
            ResultSet result;

            try {

                assert connection != null;
                prepared = connection.prepareStatement("INSERT INTO trips  (Location,  Title,date, Price, " +
                        " Description ) VALUES (?, ?, ?, ?, ?)");
                prepared.setString(1, Location);
                prepared.setString(2, Title);
                prepared.setString(3, date);
                prepared.setInt(4, Price);
                prepared.setString(5, Description);
                prepared.executeUpdate();


            } catch (SQLException e) {


                e.printStackTrace();
            }


        }




    public static void creatEvent(String eventName, String description,String location,int startAt,int endAt,
                                  int eventId ){
        Connection connection = connectDB();
        PreparedStatement prepared;
        ResultSet result;

        try {

            assert connection != null;
            prepared = connection.prepareStatement("INSERT INTO events  (EventName, Description, Location," +
                    " StartAt," + " EndAt, EventID) VALUES (?, ?, ?, ?, ?, ?)");
            prepared.setString(1, eventName);
            prepared.setString(2, description);
            prepared.setString(3, location);
            prepared.setInt(4, startAt);
            prepared.setInt(5, endAt);
            prepared.setInt(6, eventId);
            prepared.executeUpdate();


        } catch (SQLException e) {


            e.printStackTrace();
        }
    }


    public static void ADDmember(String name, int studentId, GENDER gender,
                                 String location, int age, int phone, FamilyMemberRole memberRole) {
        Connection connection = connectDB();
        PreparedStatement prepared;
        ResultSet result;

        try {
            assert connection != null;
            prepared = connection.prepareStatement("INSERT INTO addmember (Name, StudentID, GENDER," +
                    " Location, Age, Phonenumber, MemberRole) VALUES (?, ?, ?, ?, ?, ?, ?)");
            prepared.setString(1, name);
            prepared.setInt(2, studentId);
            prepared.setString(3, gender.toString());
            prepared.setString(4, location);
            prepared.setInt(5, age);
            prepared.setInt(6, phone);
            prepared.setString(7, memberRole.toString());
            prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void ADDassigment(String name, int deadline,String descripation){
        Connection connection = connectDB();
        PreparedStatement prepared;
        ResultSet result;

        try {
            assert connection!= null;
            prepared = connection.prepareStatement("INSERT INTO assignment (coursename, deadline, descripation) VALUES (?,?,?)");
            prepared.setString(1, name);
            prepared.setInt(2, deadline);
            prepared.setString(3, descripation);
            prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    public static void addsupject(String subname, CollegeDepartments department,int grade,String profname){
        Connection connection = connectDB();
        PreparedStatement prepared;
        ResultSet result;

        try {
            assert connection!= null;
            prepared = connection.prepareStatement("INSERT INTO course (coursename, departmentname,grade, proffessor) VALUES (?,?,?,?)");
            prepared.setString(1, subname);
            prepared.setString(2, department.toString());
            prepared.setInt(3, grade);
            prepared.setString(4, profname.toString());
            prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } }


        public static void adddepartment(String department,String profname,String sub){
            Connection connection = connectDB();
            PreparedStatement prepared;
            ResultSet result;

            try {
                assert connection!= null;
                prepared = connection.prepareStatement("INSERT INTO department (departmentname, proffesor, coursename) VALUES (?,?,?)");
                prepared.setString(1, department);
                prepared.setString(2, profname);
                prepared.setString(3, sub);
                prepared.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    public static void registeratdepartment(String username,String password) {
        Connection connection = connectDB();
        PreparedStatement prepared;
        ResultSet result;

        try {
            assert connection != null;
            prepared = connection.prepareStatement("INSERT INTO registeratdepartment (username,password) VALUES (?,?)");
            prepared.setString(1, username);
            prepared.setString(2, password);
            prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }}


        //////////////////////////////////


        public static boolean logiin (String name,int nationalId){
            PreparedStatement ss;
            ResultSet rs;
            Connection connection = connectDB();

            try {
                ss = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND NID = ?");
                ss.setString(1, name);
                ss.setInt(2, nationalId);

                rs = ss.executeQuery();

                if (rs.next()) {
                    // إذا وجدت نتيجة، يعني تم تحقيق تسجيل الدخول بنجاح
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Login successful", ButtonType.OK);
                    alert.showAndWait();
                    return true;
                } else {
                    // إذا لم تجد نتيجة، يعني خطأ في تسجيل الدخول
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Login error", ButtonType.OK);
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // قم بإغلاق الاتصال بقاعدة البيانات بعد الانتهاء من استخدامه
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return false;
        }


        public static boolean elogiin (String name,int nationalId, JopTitle joptitle, CollegeDepartments department){
            PreparedStatement ss;
            ResultSet rs;
            Connection connection = connectDB();

            try {
                ss = connection.prepareStatement("SELECT * FROM employee WHERE (name = ? AND NID = ? AND joptitle = ? AND Department = ?)");
                ss.setString(1, name);
                ss.setInt(2, nationalId);
                ss.setString(3, joptitle.toString());
                ss.setString(4, department.toString());


                rs = ss.executeQuery();

                if (rs.next()) {
                    // إذا وجدت نتيجة، يعني تم تحقيق تسجيل الدخول بنجاح
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Login successful", ButtonType.OK);
                    alert.showAndWait();
                    return true;
                } else {
                    // إذا لم تجد نتيجة، يعني خطأ في تسجيل الدخول
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Login error", ButtonType.OK);
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                // التعامل مع الأخطاء في قاعدة البيانات
                e.printStackTrace();
            } finally {
                try {
                    // قم بإغلاق الاتصال بقاعدة البيانات بعد الانتهاء من استخدامه
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return false;
        }


    public static boolean entertocourse (String username,String password){
        PreparedStatement ss;
        ResultSet rs;
        Connection connection = connectDB();

        try {
            ss = connection.prepareStatement("SELECT * FROM registeratdepartment WHERE username = ? AND password = ?");
            ss.setString(1, username);
            ss.setString(2, password);

            rs = ss.executeQuery();

            if (rs.next()) {
                // إذا وجدت نتيجة، يعني تم تحقيق تسجيل الدخول بنجاح
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Login successful", ButtonType.OK);
                alert.showAndWait();
                return true;
            } else {
                // إذا لم تجد نتيجة، يعني خطأ في تسجيل الدخول
                Alert alert = new Alert(Alert.AlertType.WARNING, "Login error", ButtonType.OK);
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // قم بإغلاق الاتصال بقاعدة البيانات بعد الانتهاء من استخدامه
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    }









