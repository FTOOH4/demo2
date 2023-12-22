package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {


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

        // تكوين تخطيط النوافذ الفرعية
        VBox subSceneLayout = new VBox(10);
        subSceneLayout.getChildren().addAll(loginButton, registerButton);
        subSceneLayout.setAlignment(Pos.CENTER);


        Scene studentScene = new Scene(subSceneLayout, 200, 150);
        studentStage.setScene(studentScene);

        studentStage.initModality(Modality.APPLICATION_MODAL);

        // عرض نافذة الطالب
        studentStage.showAndWait();


        }





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
           Database.elogin(nameField.getText(),Integer.parseInt(idField.getText())
                   ,GENDER.valueOf(genderField.getText().toUpperCase()),
                   locationField.getText(),
                   Integer.parseInt(ageField.getText()),
                   Integer.parseInt(phoneField.getText()),
                   JopTitle.valueOf(jopfield.getText().toUpperCase()),
                   emfield.getText(),CollegeDepartments.valueOf(setDepartment.getValue()));
           // Call a method to show college details window

           try {
               String jopTitle = jopfield.getText();
               String selectedDepartment = setDepartment.getValue();

               if ("dean".equalsIgnoreCase(jopTitle) && "CS".equalsIgnoreCase(selectedDepartment)) {
                   start000();
               } else if ("professor".equalsIgnoreCase(jopTitle) && "CS".equalsIgnoreCase(selectedDepartment)) {
                   start123();

               }
           } catch (Exception ex) {
               displayLabel.setText("Error: " + ex.getMessage());
           }
       });

       Label setDepartmentlabel = new Label("Select Department");
       setDepartment.getItems().addAll("CS", "CONTROL", "COMMUNICATION");
       setDepartment.setPromptText("Select Department");
       // setDepartment.setOnAction(event -> );


       // Add labels and text fields to the grid
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

       grid.add(showButton, 0, 9, 2, 1); // Span two columns for the button
       grid.add(Next, 0, 10, 2, 1); // Span two columns for the display label
       grid.add(displayLabel, 0, 11, 2, 1);

       // Define action for the button
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

               // Create an Employee object
               Employee employee = new Employee(name, nationalId, gender, location, age, phoneNumber, jop, edate);

               // Display the person information
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

       // Create a scene and set it to the stage
       Scene scene = new Scene(grid, 400, 400);
       primaryStage.setScene(scene);

       // Show the stage
       primaryStage.show();
   }


    private void w() {
        Stage loginStage = new Stage();
        loginStage.setTitle("نافذة تسجيل الدخول");

        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button confirmButton = new Button("confirm");
        Label jopLabel = new Label("JopTitle:");
        TextField jopfield = new TextField();
        ComboBox<String> setDepartment = new ComboBox<>();
        Label setDepartmentlabel = new Label("Select Department");
        setDepartment.getItems().addAll("CS", "Control", "Communication");
        setDepartment.setPromptText("Select Department");
        //
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
            if( Database.elogiin(nameField.getText(),
                    Integer.parseInt(passwordField.getText())
                    ,JopTitle.valueOf(jopfield.getText().toUpperCase()),
                    CollegeDepartments.valueOf(setDepartment.getValue())
            )==true) {

                try {


                    String jopTitle = jopfield.getText().toUpperCase();
                    String selectedDepartment = setDepartment.getValue().toUpperCase();

                    if ("DEAN".equalsIgnoreCase(jopTitle)) {
                        start000();
                    } else if ("PROFFESOR".equalsIgnoreCase(jopTitle) && "CS".equalsIgnoreCase(selectedDepartment) ||
                            "PROFFESOR".equalsIgnoreCase(jopTitle) && "CONTROL".equalsIgnoreCase(selectedDepartment) ||
                            "PROFFESOR".equalsIgnoreCase(jopTitle) && "COMMUNICATION".equalsIgnoreCase(selectedDepartment)) {
                        start123();
                    } else {
                        Error("Please select", "Invalid INPUT", Alert.AlertType.WARNING);
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
    private void Error(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }




    //-----------------------------------------------------------
          //زرار الطالب =================



    public void startff() {


        Stage studentStage = new Stage();
        studentStage.setTitle("نافذة الطالب");

        // إنشاء زرين في نافذة الطالب
        Button loginButton = new Button(" login");
        Button registerButton = new Button("sign in");

        // تحديد أحداث النقر لكل زر
        loginButton.setOnAction(e -> {
            w2();
        });

        registerButton.setOnAction(e -> {

            student();


        });

        // تكوين تخطيط النوافذ الفرعية
        VBox subSceneLayout = new VBox(10);
        subSceneLayout.getChildren().addAll(loginButton, registerButton);
        subSceneLayout.setAlignment(Pos.CENTER);


        Scene studentScene = new Scene(subSceneLayout, 200, 150);
        studentStage.setScene(studentScene);

        studentStage.initModality(Modality.APPLICATION_MODAL);


        // عرض نافذة الطالب
        studentStage.showAndWait();

}


    private void student() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Person Information");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(12);
        grid.setHgap(10);

        Button showCollegeDetailsButton = new Button("  confirm");
        // Add the new button to the grid
        grid.add(showCollegeDetailsButton, 0, 10, 2, 1); // Span two columns for the button


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


        Label secSchoolgradeLabel = new Label("secgrade:");
        TextField secSchoolgradeField = new TextField();

        // Labels to display person information
        Label displayLabel = new Label("");
        showCollegeDetailsButton.setOnAction(e -> {
            Database.slogin(nameField.getText(),Integer.parseInt(idField.getText()),
                    GENDER.valueOf(genderField.getText().toUpperCase()),
                    locationField.getText(),Double.parseDouble(secSchoolgradeField.getText()),
                    Integer.parseInt(ageField.getText()),Integer.parseInt(phoneField.getText()));
                 window2();
        });

        // Create a button
        Button showButton = new Button("Show Person");

        // Add labels and text fields to the grid
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

        // Define action for the button
        showButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                int nationalId = Integer.parseInt(idField.getText());
                GENDER gender = GENDER.valueOf(genderField.getText().toUpperCase());
                String location = locationField.getText();
                int age = Integer.parseInt(ageField.getText());
                int phoneNumber = Integer.parseInt(phoneField.getText());
                Double secschoolgrade =Double.parseDouble(secSchoolgradeField.getText());

                // Create an Employee object
                Student student = new Student(name, nationalId, gender, location,secschoolgrade ,age, phoneNumber);

                // Display the person information
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

        // Create a scene and set it to the stage
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();

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

        confirmButton.setOnAction(e -> {
          if(Database.logiin(nameField.getText(), Integer.parseInt(passwordField.getText()))==true){

              window2();
          }



        });

        Scene loginScene = new Scene(loginLayout, 300, 200);
        loginStage.setScene(loginScene);

        loginStage.initModality(Modality.APPLICATION_MODAL);

        loginStage.showAndWait();
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



  ////////////////////////////////////////////////////////////////////////
    //الخدماااات


    private void showServicesWindow() {
        // Create a new stage for the services window
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


        // Create a layout for the services window
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



            // Set action for the Pay Fees button
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
                    showLeaderServices(selectedFamilyType);
                } else if (selectedRole.equals("Student")) {
                    showStudentServices(selectedFamilyType);
                }
            }
            primaryStage.close();
        });

        Scene scene = new Scene(grid, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showLeaderServices(String familyType) {
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



    private void showStudentServices(String familyType) {

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
            showViewTripsWindow();});

        Scene studentScene = new Scene(studentGrid, 300, 100);
        studentStage.setScene(studentScene);
        studentStage.show();
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

    private void showViewTripsWindow() {
        Stage viewTripsStage = new Stage();
        viewTripsStage.setTitle("View Trips");



        TableView<Trip> tripsTable = new TableView<>();
        TableColumn<Trip, String> locationColumn = new TableColumn<>("Location");
        TableColumn<Trip, String> titleColumn = new TableColumn<>("Title");
        TableColumn<Trip, String> dateColumn = new TableColumn<>("Date");
        TableColumn<Trip, Double> priceColumn = new TableColumn<>("Price");

        tripsTable.getColumns().addAll(locationColumn, titleColumn, dateColumn, priceColumn);

        // قم بملء الجدول بالبيانات (يجب استبدالها بالبيانات الحقيقية)
        ObservableList<Trip> tripsData = FXCollections.observableArrayList(
                new Trip("Location1", "Title1", "Date1", "12/11",55.0),
                new Trip("Location2", "Title2", "Date2","10/5", 150.0)
        );

        tripsTable.setItems(tripsData);


        Button reserveButton = new Button("Reserve Trip");
        VBox vbox = new VBox(tripsTable, reserveButton);
        vbox.setSpacing(10);

        Scene viewTripsScene = new Scene(vbox, 400, 300);
        viewTripsStage.setScene(viewTripsScene);
        reserveButton.setOnAction(e -> {
            // احجز الرحلة المحددة
            Trip selectedTrip = tripsTable.getSelectionModel().getSelectedItem();
            if (selectedTrip != null) {
                showAlert("Reserve Trip", "Trip reserved successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Reserve Trip", "Please select a trip to reserve.", Alert.AlertType.WARNING);
            }
        });


        viewTripsStage.show();
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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
        TextField secScGradeField = new TextField();
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


/////////////////////////////////////////////////////////////////////////////////////////////////

    //التتسجيل في القسم


    public void selectdepartmentwindow() {
        Stage primaryStage=new Stage();
        primaryStage.setTitle("College Application");

        ComboBox<String> departmentDropdown = new ComboBox<>(FXCollections.observableArrayList(
                "Computer Science", "Control", "Communication"
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

            // Add your logic here to check the validity of name and password
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

    private void showCoursesWindow(String Department) {
        Stage coursesStage = new Stage();
        coursesStage.setTitle("Courses");

        // Create components for the courses window
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


            if(Database.entertocourse(nameField.getText(),passwordField.getText())==true){
                view();
                coursesStage.close();


            }

        });

        Scene coursesScene = new Scene(coursesLayout, 300, 200);
        coursesStage.setScene(coursesScene);
        coursesStage.show();
    }





    public void view() {
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Course Window Demo");

        Button viewCoursesButton = new Button("viewCourses");
        Button viewAssignmentsButton = new Button("viewAssignments");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(viewCoursesButton, viewAssignmentsButton);

        viewCoursesButton.setOnAction(e -> ViewCoursesWindow());
        viewAssignmentsButton.setOnAction(e -> showAssignmentsTable());

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void ViewCoursesWindow() {
        Stage coursesStage = new Stage();
        coursesStage.setTitle("courses");


        List<String> coursesList = Arrays.asList("NETWORK", "JAVA ", "AI ");

        ListView<String> coursesListView = new ListView<>(FXCollections.observableArrayList(coursesList));
        VBox coursesLayout = new VBox(10, coursesListView);

        Scene coursesScene = new Scene(coursesLayout, 300, 200);
        coursesStage.setScene(coursesScene);
        coursesStage.show();
    }

    private void showAssignmentsTable() {
        Stage assignmentsStage = new Stage();
        assignmentsStage.setTitle("ASSIGNMENTS");


        TableView<Assignments> assignmentsTable = new TableView<>();
        TableColumn<Assignments, String> assignmentNameColumn = new TableColumn<>("Name of assignment");
        TableColumn<Assignments, String> descriptionColumn = new TableColumn<>("Description of assignment");
        TableColumn<Assignments, Float> gradeColumn = new TableColumn<>("Score");

        assignmentsTable.getColumns().addAll(assignmentNameColumn, descriptionColumn, gradeColumn);

        VBox assignmentsLayout = new VBox(10, assignmentsTable);

        Scene assignmentsScene = new Scene(assignmentsLayout, 400, 300);
        assignmentsStage.setScene(assignmentsScene);
        assignmentsStage.show();
    }


    //////////////////////////////////////////////////////////////////////////////////




    public void start123() {

        Stage primaryStage = new Stage();
        List<Employee> employees = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        double score = 4.5;


        // Create UI components

        Button AddAssignmentButton = new Button("Add Assignments");
        AddAssignmentButton.setOnAction(e ->AddAssignment());
        Button showCourseButton = new Button("Show Course");
        showCourseButton.setOnAction(e ->showCourse());



        // Create layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(showCourseButton,AddAssignmentButton);

        // Create scene and set stage
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Department App");
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

        // Create a button to add the assignment
        Button addButton = new Button("Add Assignment");

        // Add labels and input fields to the grid
        grid.add(subjectLabel, 0, 0);
        grid.add(subjectField, 1, 0);

        grid.add(deadlineLabel, 0, 1);
        grid.add(deadlineField, 1, 1);

        grid.add(descriptionLabel, 0, 2);
        grid.add(description, 1, 2);

        grid.add(addButton, 0, 3, 2, 1); // Span two columns for the button

        // Define action for the button
        addButton.setOnAction(e -> {

            Database.ADDassigment(subjectField.getText(),Integer.parseInt(deadlineField.getText()),description.getText());
            // Get input values
            String subject = subjectField.getText();
            String deadline = deadlineField.getText();
            String descriptions = description.getText();

            // You can add code here to save the assignment details, e.g., to a database

            // Display a confirmation or take further actions as needed
            System.out.println("Assignment added:\nSubject: " + subject +
                    "\nDeadline: " + deadline +
                    "\nDescription: " + description);
        });

        // Create a scene and set it to the stage
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
    public void showCourse() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Course Information");

        // Sample data for courses
        ObservableList<Course> courseData = FXCollections.observableArrayList();


        // Create a TableView to display course data
        TableView<Course> tableView = new TableView<>();
        tableView.setItems(courseData);

        // Create columns for TableView
        TableColumn<Course, String> nameColumn = new TableColumn<>("Course Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        TableColumn<Course, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));

        TableColumn<Course, Integer> hoursColumn = new TableColumn<>("Hours");
        hoursColumn.setCellValueFactory(new PropertyValueFactory<>("hours"));

        TableColumn<Course, Integer> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TableColumn<Course, Integer> studentsColumn = new TableColumn<>("Students");
        studentsColumn.setCellValueFactory(new PropertyValueFactory<>("students"));

        // Add columns to TableView
        tableView.getColumns().addAll(nameColumn, instructorColumn, hoursColumn, gradeColumn, studentsColumn);

        // Create a VBox layout to hold the TableView
        VBox vbox = new VBox(tableView);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        // Create a scene and set it to the stage
        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
}







     ///////////////////////////////////////////////////////////////////////
    //// صلاحيات العميد////////////////


    public void start000() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("Course Management App");

        Button addSubjectButton = new Button("Add Subject");
        Button addDepartmentButton = new Button("Add Department");
        Button addEmployeeButton = new Button("Add Employee");
        Button showEmployeesButton = new Button("Show Employees");



        VBox root = new VBox(10, addSubjectButton, addDepartmentButton,addEmployeeButton,showEmployeesButton);

        addSubjectButton.setOnAction(e -> openAddSubjectDialog());
        addDepartmentButton.setOnAction(e -> openAddDepartmentDialog());
        showEmployeesButton.setOnAction(e -> showEmployees());
        addEmployeeButton.setOnAction(e -> onHelloButtonClick2());

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

            Database.addsupject(subjectNameField.getText(),CollegeDepartments.valueOf(departmentField.getText().toUpperCase()) , Integer.parseInt(gradeField.getText()),professorField.getText());

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

    public void showEmployees () {
        Stage primaryStage =new Stage();
        primaryStage.setTitle("Employee Information");

        // Sample data for employees
        ObservableList<Employee> employeeData = FXCollections.observableArrayList();

        // Create a TableView to display employee data
        TableView<Employee> tableView = new TableView<>();
        tableView.setItems(employeeData);

        // Create columns for TableView
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, Integer> idColumn = new TableColumn<>("National ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("nationalId"));

        TableColumn<Employee, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Employee, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Employee, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Employee, Integer> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Employee, String> jobColumn = new TableColumn<>("Job Title");
        jobColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        TableColumn<Employee, String> dateColumn = new TableColumn<>("Employment Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("employmentDate"));

        // Add columns to TableView
        tableView.getColumns().addAll(nameColumn, idColumn, genderColumn, locationColumn, ageColumn, phoneColumn, jobColumn, dateColumn);

        // Create a scene and set it to the stage
        Scene scene = new Scene(new ScrollPane(tableView), 800, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
}




    public void onHelloButtonClick2() {

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
        // setDepartment.setOnAction(event -> );


        // Add labels and text fields to the grid
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


        grid.add(Next, 0, 10, 2, 1); // Span two columns for the display label
        grid.add(displayLabel, 0, 11, 2, 1);


        // Create a scene and set it to the stage
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();


    }





    }



