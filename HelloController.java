package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

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
            Label emLabel = new Label("emdate:");
            TextField emfield = new TextField();
            // Labels to display person information
            Label displayLabel = new Label("");
            // Create a button
            Button showButton = new Button("Show Person");
            Button Next=new Button("Next");
            //Next.setOnAction(event -> );

           Label setDepartmentlabel = new Label("Select Department");
           ComboBox<String> setDepartment =new ComboBox<>();
           setDepartment.getItems().addAll("CS","Control","Communication");
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

            grid.add(setDepartmentlabel,0,8);
            grid.add(setDepartment,1,8,2,1);

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




        //-----------------------------------------------------------
          //زرار الطالب =================

    public void startff() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Person Information");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(12);
        grid.setHgap(10);

        Button showCollegeDetailsButton = new Button("  Next");


        // Add the new button to the grid
        grid.add(showCollegeDetailsButton, 0, 10, 2, 1); // Span two columns for the button

        // Define action for the new button
        showCollegeDetailsButton.setOnAction(e -> {
            // Call a method to show college details window
            window2();
        });
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
        });

        Scene scene = new Scene(grid, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showLeaderServices(String familyType) {
        Family currentFamily = createFamilyInstance(familyType);
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

        createTripButton.setOnAction(e -> showCreateTripWindow());

        createEventButton.setOnAction(e -> showCreateEventWindow());

        addMemberButton.setOnAction(e -> showAddMemberWindow());

        Scene leaderScene = new Scene(leaderGrid, 300, 100);
        leaderStage.setScene(leaderScene);
        leaderStage.show();
    }


////////////////////////////////////////////////////////////////
    //


    private void showStudentServices(String familyType) {
        Family currentFamily = createFamilyInstance(familyType);
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

        joinFamilyButton.setOnAction(e -> showJoinFamilyWindow());

        viewTripsButton.setOnAction(e -> showViewTripsWindow());

        Scene studentScene = new Scene(studentGrid, 300, 100);
        studentStage.setScene(studentScene);
        studentStage.show();
    }


    private Family createFamilyInstance(String familyType) {
        Family family = null;
        if (familyType.equals("Resala Family")) {
            family = new ResalaFamily(null, null);
        } else if (familyType.equals("Fee Life Makers")) {
            family = new FeeLifeMakers(null, null);
        }
        return family;
    }
//*************************************************************************




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
                memberRoleHashMap.put(null, selectedRole); // يجب استبدال null بالطالب الفعلي
                Family currentFamily = null;
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

        // استخدام جدول لعرض الرحلات

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
            // احجز الرحلة المحددة (يجب استبدالها بالتعليق الفعلي)
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

        Button createButton = new Button("Create Trip");
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
                String location = locationField.getText();
                String title = titleField.getText();
                String date = dateField.getText();
                String description=DesField.getText();
                double price = Double.parseDouble(priceField.getText());

                // إنشاء رحلة وإضافتها إلى العائلة (يجب استبدالها بالتعليق الفعلي)
                Trip trip = new Trip(location, title,description, date, price);
                FeeLifeMakers currentFamily=new FeeLifeMakers(null,null);
                currentFamily.createTrip(trip);

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
                String eventName = eventNameField.getText();
                String description = descriptionField.getText();
                String location = locationField.getText();
                int startAt = Integer.parseInt(startAtField.getText());
                int endAt = Integer.parseInt(endAtField.getText());
                int eventId = Integer.parseInt(eventIdField.getText());

                // إنشاء حدث وإضافته إلى العائلة (يجب استبدالها بالتعليق الفعلي)
                FamilyEvent event = new FamilyEvent(eventName, description, location, startAt, endAt, eventId);
                FeeLifeMakers currentFamily=new FeeLifeMakers(null,null);
                currentFamily.createEvent(event);

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
                int studentId = Integer.parseInt(studentIdField.getText());
                String name= nameField.getText();
                GENDER gender=GENDER.valueOf(genderField.getText().toUpperCase());

                FamilyMemberRole memberRole = FamilyMemberRole.valueOf(memberRoleField.getText().toUpperCase());

                String location = locationField.getText();
                int age = Integer.parseInt(ageField.getText());
                int phoneNumber = Integer.parseInt(phoneNumberField.getText());

                // إضافة عضو جديد إلى العائلة (يجب استبدالها بالتعليق الفعلي)
                Student newMember = new Student(name,studentId,gender,location, 55.0,age,phoneNumber); // يجب استبدالها بالطالب الفعلي
                HashMap<Student, FamilyMemberRole> memberRoleHashMap = new HashMap<>();
                memberRoleHashMap.put(newMember, memberRole);
                FeeLifeMakers currentFamily=new FeeLifeMakers(null,null);
                currentFamily.enrollFamilyMembers(memberRoleHashMap);

                showAlert("Add Member", "New member added successfully.", Alert.AlertType.INFORMATION);
                //addMemberStage.close();
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
            String studentName = nameField.getText();
            String password = passwordField.getText();

            // Add your logic here to check the validity of name and password
            if (isValidInput(studentName, password)) {
                // Logic to register the student

                // Display a confirmation message
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
            String studentName = nameField.getText();
            String password = passwordField.getText();

            // Add your logic here to check the validity of name and password
            if (isValidInput(studentName, password)) {
                view();
                // Logic to view courses

                coursesStage.close();
            } else {
                showAlert("Courses", "Please enter a valid name and password.", Alert.AlertType.WARNING);
            }
        });

        Scene coursesScene = new Scene(coursesLayout, 300, 200);
        coursesStage.setScene(coursesScene);
        coursesStage.show();
    }

    private boolean isValidInput(String name, String password) {
        return !name.isEmpty() && !password.isEmpty();
    }





        /////////////////////////////////////////////////////////////////////////////////

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


    }

