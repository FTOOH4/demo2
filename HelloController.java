package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelloController {

    @FXML
    protected void onHelloButtonClick() {  // نافذه الموظف//////////


       Stage studentStage = new Stage();
        studentStage.setTitle("نافذة الموظف");


        Button loginButton = new Button(" login");
        Button registerButton = new Button("sign in");


        loginButton.setOnAction(e -> {
            w();
            System.out.println("تم تسجيل الدخول");
        });

        registerButton.setOnAction(e -> {
            w1();
            System.out.println("تم التسجيل");




        });

        VBox subSceneLayout = new VBox(10);
        subSceneLayout.getChildren().addAll(loginButton, registerButton);
        subSceneLayout.setAlignment(Pos.CENTER);


        Scene studentScene = new Scene(subSceneLayout, 200, 150);
        studentStage.setScene(studentScene);

        studentStage.initModality(Modality.APPLICATION_MODAL);

        // عرض نافذة الطالب
        studentStage.showAndWait();


        }


 ///////////////////////// نافذه ادخال بيانات الموظف  =================================


   private void w1() {


       Stage primaryStage = new Stage();
       primaryStage.setTitle("Person Information");

       GridPane grid = new GridPane();
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.setVgap(8);
       grid.setHgap(10);

       // Create labels and text fields
       Label nameLabel = new Label("Name:");
       TextField nameField = new TextField();
       Label idLabel = new Label("National ID:");
       TextField idField = new TextField();
       Label genderLabel = new Label("Gender:");
       TextField genderField = new TextField();
       Label locationLabel = new Label("Location:");
       TextField locationField = new TextField();
       Label ageLabel = new Label("Age:");
       TextField ageField = new TextField();
       Label phoneLabel = new Label("Phone Number:");
       TextField phoneField = new TextField();
       Label jopLabel = new Label("JopTitle:");
       TextField jopfield = new TextField();
       Label emLabel = new Label("employeedate:");
       TextField emfield = new TextField();
       // Labels to display person information
       Label displayLabel = new Label("");
       // Create a button
       Button showButton = new Button("Show Person");
       Button Next = new Button("confirm");
       ComboBox<String> setDepartment = new ComboBox<>();
       Next.setOnAction(event ->

       {
           Database.elogin(nameField.getText(),Integer.parseInt(idField.getText())   /////////////////////////////تخزينها في الداتا بيز
                   ,GENDER.valueOf(genderField.getText().toUpperCase()),
                   locationField.getText(),
                   Integer.parseInt(ageField.getText()),
                   Integer.parseInt(phoneField.getText()),
                   JopTitle.valueOf(jopfield.getText().toUpperCase()),
                   emfield.getText(),CollegeDepartments.valueOf(setDepartment.getValue()));
                   primaryStage.close();

       });

       Label setDepartmentlabel = new Label("Select Department");
       setDepartment.getItems().addAll("CS", "CONTROL", "COMMUNICATION");
       setDepartment.setPromptText("Select Department");

       grid.add(nameLabel, 0, 0);
       grid.add(nameField, 1, 0);
       grid.add(idLabel, 0, 1);
       grid.add(idField, 1, 1);
       grid.add(genderLabel, 0, 2);
       grid.add(genderField, 1, 2);
       grid.add(locationLabel, 0, 3);
       grid.add(locationField, 1, 3);
       grid.add(ageLabel, 0, 4);
       grid.add(ageField, 1, 4);
       grid.add(phoneLabel, 0, 5);
       grid.add(phoneField, 1, 5);
       grid.add(jopLabel, 0, 6);
       grid.add(jopfield, 1, 6);
       grid.add(emLabel, 0, 7);
       grid.add(emfield, 1, 7);
       grid.add(setDepartmentlabel, 0, 8);
       grid.add(setDepartment, 1, 8, 2, 1);
       grid.add(showButton, 0, 9, 2, 1);
       grid.add(Next, 0, 10, 2, 1);
       grid.add(displayLabel, 0, 11, 2, 1);


       showButton.setOnAction(e -> {
           try {
               String name = nameField.getText();
               int nationalId = Integer.parseInt(idField.getText());
               GENDER gender = GENDER.valueOf(genderField.getText().toUpperCase());
               String location = locationField.getText();
               int age = Integer.parseInt(ageField.getText());
               int phoneNumber = Integer.parseInt(phoneField.getText());
               JopTitle jop = JopTitle.valueOf(jopfield.getText());
               String edate = emfield.getText();
               Employee employee = new Employee(name, nationalId, gender, location, age, phoneNumber, jop,
                       edate,CollegeDepartments.valueOf(setDepartment.getValue()));

               displayLabel.setText("Person Information:\n" +
                       "Name: " + employee.getName() + "\n" +
                       "National ID: " + employee.getNationalId() + "\n" +
                       "Gender: " + employee.getType() + "\n" +
                       "Location: " + employee.getLocation() + "\n" +
                       "Age: " + employee.getAge() + "\n" +
                       "Phone Number: " + employee.getPhoneNumber() + "\n" +
                       "Job Title: " + employee.getJobTitle() + "\n" +
                       "Employment Date: " + employee.getEmploymentDate());
           } catch (IllegalArgumentException ex) {
               displayLabel.setText("Error: " + ex.getMessage());
           }
       });

       Scene scene = new Scene(grid, 400, 400);
       primaryStage.setScene(scene);
       primaryStage.show();
   }


    private void w() {
        Stage loginStage = new Stage();
        loginStage.setTitle("نافذة تسجيل الدخول");

        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button confirmButton = new Button("confirm");
        TextField jopfield = new TextField();
        ComboBox<String> setDepartment = new ComboBox<>();
        setDepartment.getItems().addAll("CS", "Control", "Communication");
        setDepartment.setPromptText("Select Department");

        Label displayLabel = new Label("");

        VBox loginLayout = new VBox(10);
        loginLayout.getChildren().addAll(
                new Label("name:"),
                nameField,
                new Label("nationalId:"),
                passwordField,
                new Label("JopTitle:"),
                jopfield,
                new Label("Select Department"),
                setDepartment,

                confirmButton
        );

        confirmButton.setOnAction(e -> {
            if(Database.elogiin(nameField.getText(),
                    Integer.parseInt(passwordField.getText())
                    , JopTitle.valueOf(jopfield.getText().toUpperCase()),
                    CollegeDepartments.valueOf(setDepartment.getValue())
            )) {

                try {
                    String jopTitle = jopfield.getText().toUpperCase();
                    String selectedDepartment = setDepartment.getValue().toUpperCase();

                    if ("DEAN".equalsIgnoreCase(jopTitle)) {
                        startasdean();
                    } else if ("PROFFESOR".equalsIgnoreCase(jopTitle) && "CS".equalsIgnoreCase(selectedDepartment) ||
                            "PROFFESOR".equalsIgnoreCase(jopTitle) && "CONTROL".equalsIgnoreCase(selectedDepartment) ||
                            "PROFFESOR".equalsIgnoreCase(jopTitle) && "COMMUNICATION".equalsIgnoreCase(selectedDepartment)) {
                        startasproff(nameField.getText());
                    } else {
                        Error();
                    }

                } catch (Exception ex) {
                    displayLabel.setText("Error: " + ex.getMessage());
                }
            }
            loginStage.close();
        });

        Scene loginScene = new Scene(loginLayout, 300, 400);
        loginStage.setScene(loginScene);

        loginStage.initModality(Modality.APPLICATION_MODAL);

        loginStage.showAndWait();
    }
    private void Error() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select");
        alert.setHeaderText(null);
        alert.setContentText("Invalid INPUT");
        alert.showAndWait();
    }



    public void startasproff(String name) {      ////////////////////////////////////////////////النافذه التي تحتوي علي صلاحيات الدكتور/

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Department App");

        Button AddAssignmentButton = new Button("Add Assignments");
        AddAssignmentButton.setOnAction(e ->AddAssignment());
        Button showCourseButton = new Button("Show Course");
        showCourseButton.setOnAction(e ->{

            showcourse(name);
        });



        // Create layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(showCourseButton,AddAssignmentButton);

        // Create scene and set stage
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public void AddAssignment() {
        Stage primaryStage =new Stage();
        primaryStage.setTitle("Add Assignment");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create labels and input fields
        Label subjectLabel = new Label("Subject:");
        TextField subjectField = new TextField();

        Label deadlineLabel = new Label("Deadline:");
        TextField deadlineField = new TextField();

        Label descriptionLabel = new Label("Description:");
        TextField description = new TextField();

        Button addButton = new Button("Add Assignment");

        grid.add(subjectLabel, 0, 0);
        grid.add(subjectField, 1, 0);

        grid.add(deadlineLabel, 0, 1);
        grid.add(deadlineField, 1, 1);

        grid.add(descriptionLabel, 0, 2);
        grid.add(description, 1, 2);

        grid.add(addButton, 0, 3, 2, 1);

        addButton.setOnAction(e -> {
                                                                                    //////////////تخزين الواجبات في الداتا بيز
            Database.ADDassigment(subjectField.getText(),
                    Integer.parseInt(deadlineField.getText()),description.getText());


        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);


        primaryStage.show();
    }



    public void showcourse(String name) {
        Stage stage=new Stage();
        // إعداد الجدول
        TableView<Course> tableView = new TableView<>();
        TableColumn<Course, String> column1 = new TableColumn<>("course");
        TableColumn<Course, String> column2 = new TableColumn<>("department");
        TableColumn<Course, String> column3 = new TableColumn<>("grade");
        TableColumn<Course, String> column4 = new TableColumn<>("course teacher");


        column1.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Department"));
        column3.setCellValueFactory(new PropertyValueFactory<>("CourseScore"));
        column4.setCellValueFactory(new PropertyValueFactory<>("courseTeacher"));


        tableView.getColumns().addAll(column1, column2, column3, column4);


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root")) {
            String sql = "SELECT * FROM course Where proffessor=?";



            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,name);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String col1 = resultSet.getString("coursename");
                        CollegeDepartments col2 = CollegeDepartments.valueOf(resultSet.getString("departmentname"));
                        int col3 = resultSet.getInt("grade");
                        String col4 = resultSet.getString("proffessor");
                        tableView.getItems().add(new Course(col1, col2, col3, col4));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // إعداد السمة الرئيسية
        Scene scene = new Scene(tableView, 600, 400);
        stage.setTitle("Database Viewer");
        stage.setScene(scene);
        stage.show();
    }



    ///////////////////////////////////////////////////////////////////////
    //// صلاحيات العميد////////////////


    public void startasdean() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("Course Management App");

        Button addSubjectButton = new Button("Add Subject");
        Button addDepartmentButton = new Button("Add Department");
        Button addEmployeeButton = new Button("Add Employee");
        Button showEmployeesButton = new Button("Show Employees");



        VBox root = new VBox(10, addSubjectButton, addDepartmentButton,addEmployeeButton,showEmployeesButton);

        addSubjectButton.setOnAction(e -> openAddSubjectDialog());
        addDepartmentButton.setOnAction(e -> openAddDepartmentDialog());
        showEmployeesButton.setOnAction(e -> showemployee());
        addEmployeeButton.setOnAction(e -> addnewemployee());

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openAddSubjectDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Add Subject");


        TextField subjectNameField = new TextField();
        TextField departmentField = new TextField();
        TextField gradeField = new TextField();
        TextField professorField = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {

            Database.addsupject(subjectNameField.getText(),CollegeDepartments.valueOf(departmentField.getText().toUpperCase())
                    , Integer.parseInt(gradeField.getText()),professorField.getText());

            System.out.println("Subject Added!");
            dialog.close();
        });

        VBox dialogVBox = new VBox(10, new Label("Subject Name:"), subjectNameField,
                new Label("Department:"), departmentField,
                new Label("Grade:"), gradeField,
                new Label("Professor:"), professorField,
                addButton);

        Scene dialogScene = new Scene(dialogVBox, 350, 300);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }


    private void openAddDepartmentDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Add Department");


        TextField departmentNameField = new TextField();
        TextArea professorsArea = new TextArea();
        TextArea subjectsArea = new TextArea();

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {


            Database.adddepartment(departmentNameField.getText(),professorsArea.getText(),subjectsArea.getText());


            System.out.println("Department Added!");
            dialog.close();
        });

        VBox dialogVBox = new VBox(10, new Label("Department Name:"), departmentNameField,
                new Label("Professors:"), professorsArea,
                new Label("Subjects:"), subjectsArea,
                addButton);

        Scene dialogScene = new Scene(dialogVBox, 350, 300);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }


    public void addnewemployee() {

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Add new employee");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create labels and text fields
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label idLabel = new Label("National ID:");
        TextField idField = new TextField();
        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField();
        Label locationLabel = new Label("Location:");
        TextField locationField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();
        Label jopLabel = new Label("JopTitle:");
        TextField jopfield = new TextField();
        Label emLabel = new Label("employeedate:");
        TextField emfield = new TextField();
        // Labels to display person information
        Label displayLabel = new Label("");
        Button Next = new Button("Next");
        ComboBox<String> setDepartment = new ComboBox<>();
        Next.setOnAction(event ->{

            primaryStage.close();

            Database.elogin(nameField.getText(),Integer.parseInt(idField.getText()),
                    GENDER.valueOf(genderField.getText().toUpperCase()),
                    locationField.getText(),
                    Integer.parseInt(ageField.getText()),
                    Integer.parseInt(phoneField.getText()),
                    JopTitle.valueOf(jopfield.getText().toUpperCase()),
                    emfield.getText(),
                    CollegeDepartments.valueOf(setDepartment.getValue()));


            try {
                String jopInput = jopfield.getText().toUpperCase();

                // التحقق من صحة قيمة الوظيفة
                boolean validJobTitle = false;
                for (JopTitle validTitle : JopTitle.values()) {
                    if (jopInput.equals(validTitle.name())) {
                        validJobTitle = true;
                        break;
                    }
                }

                if (!validJobTitle) {
                    showAlert("Job Title", "Invalid job title.", Alert.AlertType.WARNING);
                } else {

                    showAlert("Registration", "Registration successful.", Alert.AlertType.INFORMATION);
                }
            } catch (Exception e) {
                showAlert("Registration", "Error processing input.", Alert.AlertType.WARNING);

            }
        });


        Label setDepartmentlabel = new Label("Select Department");
        setDepartment.getItems().addAll("CS", "CONTROL", "COMMUNICATION","NONE");
        setDepartment.setPromptText("Select Department");


        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(idLabel, 0, 1);
        grid.add(idField, 1, 1);

        grid.add(genderLabel, 0, 2);
        grid.add(genderField, 1, 2);

        grid.add(locationLabel, 0, 3);
        grid.add(locationField, 1, 3);

        grid.add(ageLabel, 0, 4);
        grid.add(ageField, 1, 4);

        grid.add(phoneLabel, 0, 5);
        grid.add(phoneField, 1, 5);

        grid.add(jopLabel, 0, 6);
        grid.add(jopfield, 1, 6);

        grid.add(emLabel, 0, 7);
        grid.add(emfield, 1, 7);

        grid.add(setDepartmentlabel, 0, 8);
        grid.add(setDepartment, 1, 8, 2, 1);
        grid.add(Next, 0, 10, 2, 1);
        grid.add(displayLabel, 0, 11, 2, 1);
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void showemployee() {
        Stage stage=new Stage();
                                                   /////////////////////استدعاء القيم من الداتا بيز
        TableView<Employee> tableView = new TableView<>();
        TableColumn<Employee, String> column1 = new TableColumn<>("name");
        TableColumn<Employee, String> column2 = new TableColumn<>("NID");
        TableColumn<Employee, String> column3 = new TableColumn<>("gender");
        TableColumn<Employee, String> column4 = new TableColumn<>("location");
        TableColumn<Employee, String> column5 = new TableColumn<>("age");
        TableColumn<Employee, String> column6 = new TableColumn<>("phonenumber");
        TableColumn<Employee, String> column7 = new TableColumn<>("jobtitle");
        TableColumn<Employee, String> column8 = new TableColumn<>("employmentdate");
        TableColumn<Employee, String> column9 = new TableColumn<>("Department");


        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nationalId"));
        column3.setCellValueFactory(new PropertyValueFactory<>("gender"));
        column4.setCellValueFactory(new PropertyValueFactory<>("location"));
        column5.setCellValueFactory(new PropertyValueFactory<>("age"));
        column6.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        column7.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        column8.setCellValueFactory(new PropertyValueFactory<>("employmentDate"));
        column9.setCellValueFactory(new PropertyValueFactory<>("department"));


        tableView.getColumns().addAll(column1, column2, column3, column4,column5, column6, column7, column8, column9);


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root")) {
            String sql = "SELECT * FROM employee ";



            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String col1 = resultSet.getString("name");
                        int col2 = resultSet.getInt("NID");
                        GENDER col3 = GENDER.valueOf(resultSet.getString("gender"));
                        String col4 = resultSet.getString("location");
                        int  col5 = resultSet.getInt("age");
                        int col6 = resultSet.getInt("phonenumber") ;
                        JopTitle col7 = JopTitle.valueOf(resultSet.getString("joptitle"));
                        String col8 = resultSet.getString("employmentdate");
                        CollegeDepartments col9 = CollegeDepartments.valueOf(resultSet.getString("Department"));

                        tableView.getItems().add(new Employee(col1, col2, col3, col4, col5, col6, col7, col8, col9));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Scene scene = new Scene(tableView, 700, 400);
        stage.setTitle("Database Viewer");
        stage.setScene(scene);
        stage.show();
    }





    //-----------------------------------------------------------
          //زرار الطالب =================



    public void startff() {


        Stage studentStage = new Stage();
        studentStage.setTitle("نافذة الطالب");

        Button loginButton = new Button(" login");
        Button registerButton = new Button("sign in");

        loginButton.setOnAction(e -> {
            w2();
        });

        registerButton.setOnAction(e -> {

            student();


        });

        VBox subSceneLayout = new VBox(10);
        subSceneLayout.getChildren().addAll(loginButton, registerButton);
        subSceneLayout.setAlignment(Pos.CENTER);


        Scene studentScene = new Scene(subSceneLayout, 200, 150);
        studentStage.setScene(studentScene);

        studentStage.initModality(Modality.APPLICATION_MODAL);
        studentStage.showAndWait();

}


    private void w2() {
        Stage loginStage = new Stage();
        loginStage.setTitle("نافذة تسجيل الدخول");

        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button confirmButton = new Button("confirm");


        VBox loginLayout = new VBox(10);
        loginLayout.getChildren().addAll(
                new Label("name:"),
                nameField,
                new Label("nationalId:"),
                passwordField,
                confirmButton
        );

        confirmButton.setOnAction(e -> {                ///////////////تسجيل الدخول من خلال التاكد من صحه البيانات في الداتا بيز ===========
            if(Database.logiin(nameField.getText(),
                    Integer.parseInt(passwordField.getText()))){
                loginStage.close();

                window2();


            }


        });

        Scene loginScene = new Scene(loginLayout, 300, 200);
        loginStage.setScene(loginScene);

        loginStage.initModality(Modality.APPLICATION_MODAL);

        loginStage.showAndWait();

    }


    private void student() {            ////////////////////////////تسجيل كطالب جديد
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Person Information");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(12);
        grid.setHgap(10);
        Button showCollegeDetailsButton = new Button("  confirm");
        grid.add(showCollegeDetailsButton, 0, 10, 2, 1); // Span two columns for the button
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label idLabel = new Label("National ID:");
        TextField idField = new TextField();
        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField();
        Label locationLabel = new Label("Location:");
        TextField locationField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();
        Label secSchoolgradeLabel = new Label("secgrade:");
        TextField secSchoolgradeField = new TextField();

        // Labels to display person information
        Label displayLabel = new Label("");
        showCollegeDetailsButton.setOnAction(e -> {
            Database.slogin(nameField.getText(),Integer.parseInt(idField.getText()),
                    GENDER.valueOf(genderField.getText().toUpperCase()),
                    locationField.getText(),Double.parseDouble(secSchoolgradeField.getText()),
                    Integer.parseInt(ageField.getText()),Integer.parseInt(phoneField.getText()));
            primaryStage.close();
        });


        Button showButton = new Button("Show Person");
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(idLabel, 0, 1);
        grid.add(idField, 1, 1);
        grid.add(genderLabel, 0, 2);
        grid.add(genderField, 1, 2);
        grid.add(locationLabel, 0, 3);
        grid.add(locationField, 1, 3);
        grid.add(ageLabel, 0, 4);
        grid.add(ageField, 1, 4);
        grid.add(phoneLabel, 0, 5);
        grid.add(phoneField, 1, 5);
        grid.add(secSchoolgradeLabel, 0, 7);
        grid.add(secSchoolgradeField, 1, 7);
        grid.add(showButton, 0, 8, 2, 1); // Span two columns for the button
        grid.add(displayLabel, 0, 9, 2, 1); // Span two columns for the display label


        showButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                int nationalId = Integer.parseInt(idField.getText());
                GENDER gender = GENDER.valueOf(genderField.getText().toUpperCase());
                String location = locationField.getText();
                int age = Integer.parseInt(ageField.getText());
                int phoneNumber = Integer.parseInt(phoneField.getText());
                Double secschoolgrade =Double.parseDouble(secSchoolgradeField.getText());



                Student student = new Student(name, nationalId, gender, location,secschoolgrade ,age, phoneNumber);

                displayLabel.setText("Person Information:\n" +
                        "Name: " + student.getName() + "\n" +
                        "National ID: " + student.getNationalId() + "\n" +
                        "Gender: " + student.getType() + "\n" +
                        "Location: " + student.getLocation() + "\n" +
                        "Age: " + student.getAge() + "\n" +
                        "Phone Number: " + student.getPhoneNumber() + "\n" +
                        "secSchoolgrade: " + student.getSecondarySchoolGrade());
            } catch (IllegalArgumentException ex) {
                displayLabel.setText("Error: " + ex.getMessage());
            }
        });


        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();

    }


    /////////////////////////////////////////////  نافذه الطالب والصلاحيات
    public void window2() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("student window ");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(12);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);



        // Create buttons for showing services and departments
        Button showServicesButton = new Button("Show Services");
        showServicesButton.setOnAction(event -> showServicesWindow());
        Button showCollegeDetailsWindow = new Button("details ");

        showCollegeDetailsWindow.setOnAction(event -> showCollegeDetailsWindow());
        Button selectDepartment = new Button("select department");
        selectDepartment.setOnAction(event -> selectdepartmentwindow());

        // Create ComboBox for displaying relatives
        Button Famlies=new Button("Famlies");
        Famlies.setOnAction(event -> start());

        // Add buttons and ComboBoxes to the grid
        grid.add(showServicesButton, 1, 10, 2, 1); // Span two columns for the button
        grid.add(showCollegeDetailsWindow, 1, 11, 2, 1); // Span two columns for the button
        grid.add(selectDepartment, 1, 12);
        grid.add(Famlies, 1, 13);



        // Show the primary stage
        Scene scene = new Scene(grid, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




////////////////////////////////////////////////////////////////
   //المعلومات الخاصه بالكليه


    private void showCollegeDetailsWindow() {
        Stage collegeDetailsStage = new Stage();
        collegeDetailsStage.setTitle("College Details");

        // Create a new grid for the college details window
        GridPane collegeDetailsGrid = new GridPane();
        collegeDetailsGrid.setPadding(new Insets(10, 10, 10, 10));
        collegeDetailsGrid.setVgap(12);
        collegeDetailsGrid.setHgap(10);

        // Add labels and text fields for college details
        Label nameLabel = new Label("Name:");
        Label locationLabel = new Label("Location:");
        Label gradeLabel = new Label("Grade:");
        Label deanLabel = new Label("Dean:");

        Label nameValueLabel = new Label(College.NAME);
        Label locationValueLabel = new Label(College.LOCATION);
        Label gradeValueLabel = new Label(String.valueOf(College.COLLEGE_GRADE));
        Label deanValueLabel = new Label(College.COLLEGE_DEAN);

        // Add labels and values to the grid
        collegeDetailsGrid.add(nameLabel, 0, 0);
        collegeDetailsGrid.add(nameValueLabel, 1, 0);

        collegeDetailsGrid.add(locationLabel, 0, 1);
        collegeDetailsGrid.add(locationValueLabel, 1, 1);

        collegeDetailsGrid.add(gradeLabel, 0, 2);
        collegeDetailsGrid.add(gradeValueLabel, 1, 2);

        collegeDetailsGrid.add(deanLabel, 0, 3);
        collegeDetailsGrid.add(deanValueLabel, 1, 3);

        // Show the college details stage
        Scene collegeDetailsScene = new Scene(collegeDetailsGrid, 300, 200);
        collegeDetailsStage.setScene(collegeDetailsScene);
        collegeDetailsStage.show();
    }




  ////////////////////////////////////////////////////////////////////////
    //الخدماااات


    private void showServicesWindow() {

        Stage servicesStage = new Stage();
        servicesStage.setTitle("College Services");

        // Create TextFields for user input
        TextField studentIdField = new TextField();
        TextField graduationYearField = new TextField();
        TextField feesAmountField = new TextField();
        ComboBox<CollegeYears> yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(CollegeYears.values());
        yearComboBox.setPromptText("Select College Year");


        // Create a Button to trigger the services
        Button requestCertificateButton = new Button("Request Graduation Certificate");
        Button payFeesButton = new Button("Pay Fees");

        // Create a TextArea to display the services information
        TextArea servicesTextArea = new TextArea();
        servicesTextArea.setEditable(false);

        // Create an instance of CollegeServices
        CollegeServices collegeServices = new CollegeServices();


        // Set actions for the buttons
        requestCertificateButton.setOnAction(e -> {
            try {
                int studentId = Integer.parseInt(studentIdField.getText());
                int graduationYear = Integer.parseInt(graduationYearField.getText());

                // Call the requestGraduationCertificate method and display the result
                boolean result = collegeServices.requestGraduationCertificate(studentId, graduationYear);
                servicesTextArea.appendText("Request Graduation Certificate: " + result + "\n");
            } catch (NumberFormatException ex) {
                servicesTextArea.appendText("Error: Please enter valid numbers for Student ID and Graduation Year.\n");
            }
        });

        VBox servicesLayout = new VBox(
                new Label("Student ID:"),
                studentIdField,
                new Label("Graduation Year:"),
                graduationYearField,
                requestCertificateButton,
                new Label("Fees Amount:"),
                feesAmountField,yearComboBox,
                payFeesButton,
                servicesTextArea
        );

            payFeesButton.setOnAction(e -> {
                try {
                    CollegeYears selectedYear = yearComboBox.getValue();
                    double feesAmount = Double.parseDouble(feesAmountField.getText());

                    // Call the payFees method and display the result
                    boolean result = collegeServices.payFees(selectedYear, feesAmount);
                    servicesTextArea.appendText("Pay Fees for " + selectedYear + ": " + result + "\n");
                } catch (NumberFormatException ex) {
                    servicesTextArea.appendText("Error: Please enter a valid number for Fees Amount.\n");
                }
            });



        Scene servicesScene = new Scene(servicesLayout, 400, 300);

        // Set the scene and show the services window
        servicesStage.setScene(servicesScene);
        servicesStage.show();
    }



    ///////////////////////////////////////////////////////////////////////////////////////
    ///    الاسر
    public void start() {
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Family App");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(12);
        grid.setHgap(10);

        ComboBox<String> familyTypeComboBox = new ComboBox<>();
        familyTypeComboBox.getItems().addAll("Resala Family", "Fee Life Makers");
        familyTypeComboBox.setPromptText("Select Family Type");

        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Leader", "Student");
        roleComboBox.setPromptText("Select Role");

        Button showServicesButton = new Button("Show Services");
        grid.add(familyTypeComboBox, 0, 0);
        grid.add(roleComboBox, 1, 0);
        grid.add(showServicesButton, 2, 0);

        showServicesButton.setOnAction(e -> {
            String selectedFamilyType = familyTypeComboBox.getValue();
            String selectedRole = roleComboBox.getValue();

            if (selectedFamilyType != null && selectedRole != null) {
                if (selectedRole.equals("Leader")) {
                    showLeaderServices();
                } else if (selectedRole.equals("Student")) {
                    showStudentServices();
                }
            }
            primaryStage.close();
        });

        Scene scene = new Scene(grid, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showLeaderServices() {
        Stage leaderStage = new Stage();
        leaderStage.setTitle("Leader Services");

        GridPane leaderGrid = new GridPane();
        leaderGrid.setPadding(new Insets(10, 10, 10, 10));
        leaderGrid.setVgap(12);
        leaderGrid.setHgap(10);

        Button createTripButton = new Button("Create Trip");
        Button createEventButton = new Button("Create Event");
        Button addMemberButton = new Button("Add Member");

        leaderGrid.add(createTripButton, 0, 0);
        leaderGrid.add(createEventButton, 1, 0);
        leaderGrid.add(addMemberButton, 2, 0);

        createTripButton.setOnAction(e -> {leaderStage.close();
            showCreateTripWindow();});

        createEventButton.setOnAction(e -> {leaderStage.close();
            showCreateEventWindow();});

        addMemberButton.setOnAction(e -> {leaderStage.close();
            showAddMemberWindow();});

        Scene leaderScene = new Scene(leaderGrid, 300, 100);
        leaderStage.setScene(leaderScene);
        leaderStage.show();
    }





    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //عمل رحله جديده  بواسطه الليدر////////////////////////////////
    private void showCreateTripWindow() {
        Stage createTripStage = new Stage();
        createTripStage.setTitle("Create Trip");

        GridPane createTripGrid = new GridPane();
        createTripGrid.setPadding(new Insets(10, 10, 10, 10));
        createTripGrid.setVgap(12);
        createTripGrid.setHgap(10);

        TextField locationField = new TextField();
        TextField titleField = new TextField();
        TextField dateField = new TextField();
        TextField priceField = new TextField();
        TextField DesField=new TextField();

        Button createButton = new Button("Create ");
        createTripGrid.add(new Label("Location:"), 0, 0);
        createTripGrid.add(locationField, 1, 0);
        createTripGrid.add(new Label("Title:"), 0, 1);
        createTripGrid.add(titleField, 1, 1);
        createTripGrid.add(new Label("Date:"), 0, 2);
        createTripGrid.add(dateField, 1, 2);
        createTripGrid.add(new Label("Price:"), 0, 3);
        createTripGrid.add(priceField, 1, 3);
        createTripGrid.add(new Label("Description:"), 0, 4);
        createTripGrid.add(DesField,1,4);
        createTripGrid.add(createButton, 0, 6, 2, 1);



        createButton.setOnAction(e -> {
            try {


                Database.creatTrips(locationField.getText(),
                        titleField.getText(),
                        dateField.getText(),
                        Integer.parseInt(priceField.getText()),DesField.getText());{}

                showAlert("Create Trip", "Trip created successfully.", Alert.AlertType.INFORMATION);
                createTripStage.close();
            } catch (NumberFormatException ex) {
                showAlert("Create Trip", "Please enter a valid price.", Alert.AlertType.WARNING);
            }
        });

        Scene createTripScene = new Scene(createTripGrid, 400, 300);
        createTripStage.setScene(createTripScene);
        createTripStage.show();
    }

    private void showCreateEventWindow() {
        Stage createEventStage = new Stage();
        createEventStage.setTitle("Create Event");

        GridPane createEventGrid = new GridPane();
        createEventGrid.setPadding(new Insets(10, 10, 10, 10));
        createEventGrid.setVgap(12);
        createEventGrid.setHgap(10);

        TextField eventNameField = new TextField();
        TextField descriptionField = new TextField();
        TextField locationField = new TextField();
        TextField startAtField = new TextField();
        TextField endAtField = new TextField();
        TextField eventIdField = new TextField();

        Button createButton = new Button("Create Event");
        createEventGrid.add(new Label("Event Name:"), 0, 0);
        createEventGrid.add(eventNameField, 1, 0);
        createEventGrid.add(new Label("Description:"), 0, 1);
        createEventGrid.add(descriptionField, 1, 1);
        createEventGrid.add(new Label("Location:"), 0, 2);
        createEventGrid.add(locationField, 1, 2);
        createEventGrid.add(new Label("Start At:"), 0, 3);
        createEventGrid.add(startAtField, 1, 3);
        createEventGrid.add(new Label("End At:"), 0, 4);
        createEventGrid.add(endAtField, 1, 4);
        createEventGrid.add(new Label("Event ID:"), 0, 5);
        createEventGrid.add(eventIdField, 1, 5);
        createEventGrid.add(createButton, 0, 6, 2, 1);



        createButton.setOnAction(e -> {

            try {
                Database.creatEvent(eventNameField.getText(),
                        descriptionField.getText(),
                        locationField.getText(),Integer.parseInt(startAtField.getText()),
                        Integer.parseInt(endAtField.getText()),
                        Integer.parseInt(eventIdField.getText()));{

                }

                showAlert("Create Event", "Event created successfully.", Alert.AlertType.INFORMATION);
                createEventStage.close();
            } catch (NumberFormatException ex) {
                showAlert("Create Event", "Please enter valid numeric values.", Alert.AlertType.WARNING);
            }
        });

        Scene createEventScene = new Scene(createEventGrid, 400, 300);
        createEventStage.setScene(createEventScene);
        createEventStage.show();
    }

    private void showAddMemberWindow() {
        Stage addMemberStage = new Stage();
        addMemberStage.setTitle("Add New Member");

        GridPane addMemberGrid = new GridPane();
        addMemberGrid.setPadding(new Insets(10, 10, 10, 10));
        addMemberGrid.setVgap(12);
        addMemberGrid.setHgap(10);

        TextField studentIdField = new TextField();
        TextField nameField = new TextField();
        TextField genderField = new TextField();
        TextField locationField = new TextField();
        TextField ageField = new TextField();
        TextField phoneNumberField = new TextField();
        TextField memberRoleField=new TextField();



        Button addButton = new Button("Add Member");

        addMemberGrid.add(new Label("Name"), 0, 0);
        addMemberGrid.add(nameField, 1, 0);

        addMemberGrid.add(new Label("Student ID:"), 0, 1);
        addMemberGrid.add(studentIdField, 1, 1);

        addMemberGrid.add(new Label("Gender:"), 0, 2);
        addMemberGrid.add(genderField, 1, 2);

        addMemberGrid.add(new Label("Location:"), 0, 3);
        addMemberGrid.add(locationField, 1, 3);

        addMemberGrid.add(new Label("Age:"), 0, 4);
        addMemberGrid.add(ageField, 1, 4);

        addMemberGrid.add(new Label("Phone Number:"), 0, 5);
        addMemberGrid.add(phoneNumberField, 1, 5);

        addMemberGrid.add(new Label("Member Role:"), 0, 6);
        addMemberGrid.add(memberRoleField, 1, 6);
        addMemberGrid.add(addButton, 0, 7, 2, 1);

        addButton.setOnAction(e -> {
            try {
                Database.ADDmember(nameField.getText(),
                        Integer.parseInt(studentIdField.getText()),
                        GENDER.valueOf(genderField.getText().toUpperCase()),
                        locationField.getText(),
                        Integer.parseInt(ageField.getText()),
                        Integer.parseInt(phoneNumberField.getText()),
                        FamilyMemberRole.valueOf(memberRoleField.getText().toUpperCase()));{}

                showAlert("Add Member", "New member added successfully.", Alert.AlertType.INFORMATION);


                addMemberStage.close();
            } catch (Exception ex) {

                showAlert("Add Member", "Invalid input values.", Alert.AlertType.WARNING);

            }
        });

        Scene addMemberScene = new Scene(addMemberGrid, 300, 300);
        addMemberStage.setScene(addMemberScene);
        addMemberStage.show();
    }





    private void showStudentServices() {

        Stage studentStage = new Stage();
        studentStage.setTitle("Student Services");

        GridPane studentGrid = new GridPane();
        studentGrid.setPadding(new Insets(10, 10, 10, 10));
        studentGrid.setVgap(12);
        studentGrid.setHgap(10);

        Button joinFamilyButton = new Button("Join Family");
        Button viewTripsButton = new Button("View Trips");

        studentGrid.add(joinFamilyButton, 0, 0);
        studentGrid.add(viewTripsButton, 1, 0);

        joinFamilyButton.setOnAction(e -> {
            studentStage.close();
            showJoinFamilyWindow();});

        viewTripsButton.setOnAction(e -> {
            studentStage.close();
            showtrip();});

        Scene studentScene = new Scene(studentGrid, 300, 100);
        studentStage.setScene(studentScene);
        studentStage.show();
    }


    public void showtrip() {
        Stage stage=new Stage();
        // إعداد الجدول
        TableView<Trip> tableView = new TableView<>();
        TableColumn<Trip, String> column1 = new TableColumn<>("location");
        TableColumn<Trip, String> column2 = new TableColumn<>("title");
        TableColumn<Trip, String> column3 = new TableColumn<>("date");
        TableColumn<Trip, String> column4 = new TableColumn<>("price");
        TableColumn<Trip, Double> column5 = new TableColumn<>("description");

        // ربط الأعمدة بخصائص الكائن DataRecord
        column1.setCellValueFactory(new PropertyValueFactory<>("location"));
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));
        column3.setCellValueFactory(new PropertyValueFactory<>("description"));
        column4.setCellValueFactory(new PropertyValueFactory<>("date"));
        column4.setCellValueFactory(new PropertyValueFactory<>("price"));

        // إضافة الأعمدة إلى الجدول
        tableView.getColumns().addAll(column1, column2, column3, column4,column5);

        // اتصال بقاعدة البيانات واسترجاع البيانات
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root")) {
            String sql = "SELECT * FROM trips";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String col1 = resultSet.getString("Location");
                        String col2 = resultSet.getString("Title");
                        String col3 = resultSet.getString("Date");
                        Double col4 = resultSet.getDouble("Price");
                        String col5 = resultSet.getString("Description");
                        tableView.getItems().add(new Trip(col1, col2, col3, col4, col5));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // إعداد السمة الرئيسية
        Scene scene = new Scene(tableView, 600, 400);
        stage.setTitle("Database Viewer");
        stage.setScene(scene);
        stage.show();
    }



//*************************************************************************

    ///اشتراك الطالب في الاسره ورؤيه الرحلات




    private void showJoinFamilyWindow() {
        Stage joinFamilyStage = new Stage();
        joinFamilyStage.setTitle("Join Family");

        GridPane joinFamilyGrid = new GridPane();
        joinFamilyGrid.setPadding(new Insets(10, 10, 10, 10));
        joinFamilyGrid.setVgap(12);
        joinFamilyGrid.setHgap(10);

        ComboBox<FamilyMemberRole> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll(FamilyMemberRole.values());
        roleComboBox.setPromptText("Select Family Role");

        Button confirmButton = new Button("Confirm");
        joinFamilyGrid.add(roleComboBox, 0, 0);
        joinFamilyGrid.add(confirmButton, 1, 0);

        confirmButton.setOnAction(e -> {
            FamilyMemberRole selectedRole = roleComboBox.getValue();
            if (selectedRole != null) {
                HashMap<Student, FamilyMemberRole> memberRoleHashMap = new HashMap<>();
                Student s1=new Student("youssef",25,GENDER.MALE,"hggh,",90.0,20,121);
                memberRoleHashMap.put(s1, selectedRole);
                List<String> l1=new ArrayList<>();
                FeeLifeMakers currentFamily =new FeeLifeMakers(s1,l1);
                currentFamily.enrollFamilyMembers(memberRoleHashMap);

                // عرض رسالة تأكيد
                showAlert("Join Family", "You have joined the family.", Alert.AlertType.INFORMATION);
                joinFamilyStage.close();
            }
        });

        Scene joinFamilyScene = new Scene(joinFamilyGrid, 300, 100);
        joinFamilyStage.setScene(joinFamilyScene);
        joinFamilyStage.show();
    }



    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }




/////////////////////////////////////////////////////////////////////////////////////////////////

    //التتسجيل للطالب في القسم


    public void selectdepartmentwindow() {
        Stage primaryStage=new Stage();
        primaryStage.setTitle("College Application");

        ComboBox<String> departmentDropdown = new ComboBox<>(FXCollections.observableArrayList(
                "CS", "Control", "Communication"
        ));
        departmentDropdown.setPromptText("Select Department");
        Button registerButton = new Button("Register");
        registerButton.setDisable(true);
        Button viewCoursesButton = new Button("View Courses");
        viewCoursesButton.setDisable(true);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(departmentDropdown, registerButton, viewCoursesButton);
        departmentDropdown.setOnAction(e -> {
            String selectedDepartment = departmentDropdown.getValue();
            if (selectedDepartment != null) {
                registerButton.setDisable(false);
                viewCoursesButton.setDisable(false);
            }
        });

        registerButton.setOnAction(e -> {
            String selectedDepartment = departmentDropdown.getValue();
            if (selectedDepartment != null) {
                showRegistrationWindow(selectedDepartment);
            }
        });

        viewCoursesButton.setOnAction(e -> {
            String selectedDepartment = departmentDropdown.getValue();
            if (selectedDepartment != null) {
                showCoursesWindow(selectedDepartment);
            }
        });

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void showRegistrationWindow(String department) {
        Stage registrationStage = new Stage();
        registrationStage.setTitle("Registration for " + department);

        // Create components for the registration window
        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button confirmButton = new Button("Confirm");

        VBox registrationLayout = new VBox(10);
        registrationLayout.getChildren().addAll(
                new Label("Enter your name:"),
                nameField,
                new Label("Enter your password:"),
                passwordField,
                confirmButton
        );

        confirmButton.setOnAction(e -> {

            Database.registeratdepartment(nameField.getText(), passwordField.getText());
            String studentName = nameField.getText();
            String password = passwordField.getText();

            if (isValidInput(studentName, password)) {

                showAlert("Registration", "Registration successful.", Alert.AlertType.INFORMATION);

                registrationStage.close();
            } else {
                showAlert("Registration", "Please enter a valid name and password.", Alert.AlertType.WARNING);
            }
        });

        Scene registrationScene = new Scene(registrationLayout, 300, 200);
        registrationStage.setScene(registrationScene);
        registrationStage.show();
    }


    private boolean isValidInput(String name, String password) {
        return !name.isEmpty() && !password.isEmpty();
    }
    ///////////////////////////////////////////////////////////////////
    //دخول الطالب لرويه المواد والواجبات

    private void showCoursesWindow(String Department) {
        Stage coursesStage = new Stage();
        coursesStage.setTitle("Courses");

        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button confirmButton = new Button("Confirm");
        VBox coursesLayout = new VBox(10);
        coursesLayout.getChildren().addAll(
                new Label("Enter your name:"),
                nameField,
                new Label("Enter your password:"),
                passwordField,
                confirmButton
        );

        confirmButton.setOnAction(e -> {
            if(Database.entertocourse(nameField.getText(), passwordField.getText())){
                view(Department);
                coursesStage.close();


            }

        });

        Scene coursesScene = new Scene(coursesLayout, 300, 200);
        coursesStage.setScene(coursesScene);
        coursesStage.show();
    }



    public void view(String department) {
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Course Window Demo");

        Button viewCoursesButton = new Button("viewCourses");
        Button viewAssignmentsButton = new Button("viewAssignments");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(viewCoursesButton, viewAssignmentsButton);

        viewCoursesButton.setOnAction(e -> showcourses(department));
        viewAssignmentsButton.setOnAction(e -> showassi());

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }





    //////////////////////////////////////////////////////////////////////////////
    //اكواددددد الاستدعاء من الداتا بيززز






    public void showcourses(String DP) {
        Stage stage=new Stage();
        // إعداد الجدول
        TableView<Course> tableView = new TableView<>();
        TableColumn<Course, String> column1 = new TableColumn<>("course");
        TableColumn<Course, String> column2 = new TableColumn<>("department");
        TableColumn<Course, String> column3 = new TableColumn<>("grade");
        TableColumn<Course, String> column4 = new TableColumn<>("course teacher");

        // ربط الأعمدة بخصائص الكائن DataRecord
        column1.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Department"));
        column3.setCellValueFactory(new PropertyValueFactory<>("CourseScore"));
        column4.setCellValueFactory(new PropertyValueFactory<>("courseTeacher"));

        // إضافة الأعمدة إلى الجدول
        tableView.getColumns().addAll(column1, column2, column3, column4);

        // اتصال بقاعدة البيانات واسترجاع البيانات
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root")) {
            String sql = "SELECT * FROM course Where departmentname=?";



            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setObject(1,DP);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String col1 = resultSet.getString("coursename");
                        CollegeDepartments col2 = CollegeDepartments.valueOf(resultSet.getString("departmentname"));
                        int col3 = resultSet.getInt("grade");
                        String col4 = resultSet.getString("proffessor");
                        tableView.getItems().add(new Course(col1, col2, col3, col4));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // إعداد السمة الرئيسية
        Scene scene = new Scene(tableView, 600, 400);
        stage.setTitle("Database Viewer");
        stage.setScene(scene);
        stage.show();
    }


    public void showassi() {
        Stage stage=new Stage();

        TableView<Assignments> tableView = new TableView<>();
        TableColumn<Assignments, String> column1 = new TableColumn<>("coursename");
        TableColumn<Assignments, String> column2 = new TableColumn<>("deadline");
        TableColumn<Assignments, String> column3 = new TableColumn<>("description");


        column1.setCellValueFactory(new PropertyValueFactory<>("assignmentName"));
        column2.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        column3.setCellValueFactory(new PropertyValueFactory<>("assignmentDescription"));



        // إضافة الأعمدة إلى الجدول
        tableView.getColumns().addAll(column1, column2, column3);

        // اتصال بقاعدة البيانات واسترجاع البيانات
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root")) {
            String sql = "SELECT * FROM assignment";



            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String col1 = resultSet.getString("coursename");
                        String col2 = resultSet.getString("deadline");
                         String col3 = resultSet.getString("descripation");

                        tableView.getItems().add(new Assignments(col1, col2, col3));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(tableView, 700, 400);
        stage.setTitle("Database Viewer");
        stage.setScene(scene);
        stage.show();

    }


}



