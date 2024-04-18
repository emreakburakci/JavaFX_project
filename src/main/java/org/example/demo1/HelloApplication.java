package org.example.demo1;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import javafx.scene.input.MouseEvent;

public class HelloApplication extends Application {

    private TableView<Employee> tableView;
    private ObservableList<Employee> employees = FXCollections.observableArrayList(MockDB.getEmployees());

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Person Information");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);





        // Labels for each input field
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        Label surnameLabel = new Label("Surname:");
        GridPane.setConstraints(surnameLabel, 0, 1);

        Label salaryLabel = new Label("Salary:");
        GridPane.setConstraints(salaryLabel, 0, 2);

        Label birthdateLabel = new Label("Birthdate:");
        GridPane.setConstraints(birthdateLabel, 0, 3);

        Label ageLabel = new Label("Age:");
        GridPane.setConstraints(ageLabel, 0, 4);

        Label premiumLabel = new Label("Insurance Premium:");
        GridPane.setConstraints(premiumLabel, 0, 5);

        Label employeeTypeLabel = new Label("Employee Type:");
        GridPane.setConstraints(employeeTypeLabel, 0, 6);

        // ID input field
        Label idLabel = new Label("ID:");
        GridPane.setConstraints(idLabel, 0, 7);

        TextField idField = new TextField();
        idField.setPromptText("Enter ID");
        GridPane.setConstraints(idField, 1, 7);

        // Name and Surname input fields
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");
        GridPane.setConstraints(nameField, 1, 0);

        TextField surnameField = new TextField();
        surnameField.setPromptText("Enter Surname");
        GridPane.setConstraints(surnameField, 1, 1);

        // Salary input field
        TextField salaryField = new TextField();
        salaryField.setPromptText("Enter Salary");
        GridPane.setConstraints(salaryField, 1, 2);

        // Birthdate input field with DatePicker
        DatePicker birthdatePicker = new DatePicker();
        birthdatePicker.setPromptText("Select Birthdate");
        GridPane.setConstraints(birthdatePicker, 1, 3);

        // Age input field
        TextField ageField = new TextField();
        ageField.setPromptText("Enter Age");
        GridPane.setConstraints(ageField, 1, 4);

        // Insurance premium input field
        TextField premiumField = new TextField();
        premiumField.setPromptText("Enter Insurance Premium");
        GridPane.setConstraints(premiumField, 1, 5);

        // Employee Type dropdown
        ComboBox<String> employeeTypeComboBox = new ComboBox<>();
        employeeTypeComboBox.getItems().addAll("Developer", "Tester", "Analyst");
        employeeTypeComboBox.setPromptText("Select Employee Type");
        GridPane.setConstraints(employeeTypeComboBox, 1, 6);

        // Submit button
        Button submitButton = new Button("Save");
        GridPane.setConstraints(submitButton, 0, 8);
        GridPane.setColumnSpan(submitButton, 2);
        submitButton.setOnAction(event -> {


            long id =0;

            try{
                id = Long.parseLong(idField.getText());
            }catch(NumberFormatException e){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid ID");
                alert.setContentText("ID must be a number");
                alert.showAndWait();
                return;
            }


            String name = nameField.getText();

            if(name.isEmpty()){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Name");
                alert.setContentText("Name must not be empty");
                alert.showAndWait();
                return;
            }
            String surname = surnameField.getText();
            if(surname.isEmpty()){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Surname");
                alert.setContentText("Surname must not be empty");
                alert.showAndWait();
                return;
            }
            double salary = 0;
            try{
                salary = Double.parseDouble(salaryField.getText());
            }catch(NumberFormatException e){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Salary");
                alert.setContentText("Salary must be a number");
                alert.showAndWait();
                return;

            }
            LocalDateTime birthdate =null;
            try{
                birthdate = birthdatePicker.getValue().atStartOfDay();
            }catch(NullPointerException e){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Birthdate");
                alert.setContentText("Birthdate must be selected");
                alert.showAndWait();
                return;
            }
            int age = 0;
            try{
                age = Integer.parseInt(ageField.getText());
            }catch(NumberFormatException e){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Age");
                alert.setContentText("Age must be a number");
                alert.showAndWait();
                return;
            }
            float premium = 0;
            try{
                premium = Float.parseFloat(premiumField.getText());
            }catch(NumberFormatException e){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Premium");
                alert.setContentText("Premium must be a number");
                alert.showAndWait();
                return;
            }
            String employeeType = employeeTypeComboBox.getValue();
            if(employeeType == null){
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Employee Type");
                alert.setContentText("Employee Type must be selected");
                alert.showAndWait();
                return;
            }

            // Create an Employee object according to the employee type
            Employee employee;
            switch (employeeType) {
                case "Developer":
                    employee = new Developer(id, name, surname, salary, birthdate, age, premium);
                    break;
                case "Tester":
                    employee = new Tester(id, name, surname, salary, birthdate, age, premium);
                    break;
                case "Analyst":
                    employee = new Analyst(id, name, surname, salary, birthdate, age, premium);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid employee type");
            }
            IEmployeeRepository employeeRepository = new EmployeeRepository();
            boolean isSaved = false;
            try {
                isSaved = employeeRepository.save(employee);
            } catch (InvalidEmployeeIdException e) {
                //show alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid ID. Employee ID's cannot be the same");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                return;

            }


            if (isSaved) {
                System.out.println("Employee saved successfully");
                System.out.println("All employees:");
                for(Employee emp : MockDB.getEmployees()){
                    if(emp != null) {
                        // print fields of the employee
                        System.out.println(emp.toString());

                    }
                }
            } else {
                System.out.println("Failed to save employee");

            }

            updateTableView();
        });

        // TableView setup
        tableView = new TableView<>();
        employees = FXCollections.observableArrayList();
        tableView.setItems(employees);

        TableColumn<Employee, Long> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        // Add all columns to the table

        TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employee, LocalDateTime> birthdateColumn = new TableColumn<>("Birthdate");
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));

        TableColumn<Employee, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Employee, Float> premiumColumn = new TableColumn<>("Insurance Premium");
        premiumColumn.setCellValueFactory(new PropertyValueFactory<>("premium"));

        TableColumn<Employee, String> employeeTypeColumn = new TableColumn<>("Employee Type");
        employeeTypeColumn.setCellValueFactory(new PropertyValueFactory<>("employeeType"));


        tableView.getColumns().addAll(idColumn, nameColumn, surnameColumn, salaryColumn, birthdateColumn, ageColumn, premiumColumn, employeeTypeColumn);

        // set column width according to the column name
        idColumn.setMinWidth(100);
        nameColumn.setMinWidth(100);
        surnameColumn.setMinWidth(100);
        salaryColumn.setMinWidth(100);
        birthdateColumn.setMinWidth(100);
        ageColumn.setMinWidth(100);
        premiumColumn.setMinWidth(150);
        employeeTypeColumn.setMinWidth(100);


        Label tableLabel = new Label("Employees listed below (you can click on a row to see the status of the employee)");
        GridPane.setConstraints(tableLabel, 0, 9);

        VBox tableBox = new VBox(tableView);
        GridPane.setConstraints(tableBox, 0, 10);
        GridPane.setColumnSpan(tableBox, 2);

        grid.getChildren().addAll(
                nameLabel, surnameLabel, salaryLabel, birthdateLabel, ageLabel, premiumLabel,
                employeeTypeLabel, idLabel, nameField, surnameField, salaryField, birthdatePicker, ageField, premiumField,
                employeeTypeComboBox, idField, submitButton, tableBox,tableLabel);

        Scene scene = new Scene(grid, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTableView() {
        // You need to fetch updated data from your repository or wherever it's stored
        // For example:

        Employee[] employeesArray = MockDB.getEmployees();

        tableView.setRowFactory(tv -> {
            TableRow<Employee> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    handleRowClick(event);
                }
            });
            return row;
        });

        employees.clear(); // Clear the existing list
        employees.addAll(employeesArray); // Add the updated list
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void handleRowClick(MouseEvent event) {
        //get selected row
        Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
        String message = "";



        System.out.println("Selected employee: " + selectedEmployee.toString());

        if (selectedEmployee != null) {
            message = selectedEmployee.work() + "\n";
            if(selectedEmployee.getEmployeeType().equals("Developer")) {
                Developer developer = (Developer) selectedEmployee;
                message += developer.developerMessage();
            }
            else if(selectedEmployee.getEmployeeType().equals("Tester")) {
                Tester tester = (Tester) selectedEmployee;
                message += tester.testerMessage();
            }
            else if(selectedEmployee.getEmployeeType().equals("Analyst")) {
                Analyst analyst = (Analyst) selectedEmployee;
                message += analyst.analystMessage();
            }

            //show pop up window with the message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Status Message");
            alert.setHeaderText("Employee Status");
            alert.setContentText(message);
            alert.showAndWait();

        }
    }
}
