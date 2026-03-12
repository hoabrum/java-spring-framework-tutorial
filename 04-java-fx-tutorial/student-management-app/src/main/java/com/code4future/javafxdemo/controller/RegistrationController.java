package com.code4future.javafxdemo.controller;

import com.code4future.javafxdemo.entity.Student;
import com.code4future.javafxdemo.service.StudentService;
import javafx.collections.FXCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RegistrationController implements Initializable {
    @FXML
    public Button add_btn;
    @FXML
    public Button update_btn;
    @FXML
    public Button delete_btn;
    @FXML
    public TextField name_txtfld;
    @FXML
    public TextField phone_txtfld;
    @FXML
    public TextField course_txtfld;
    @FXML
    public TableView<Student> table;
    @FXML
    public TableColumn<Student, String> ID_column;
    @FXML
    public TableColumn<Student, String> name_column;
    @FXML
    public TableColumn<Student, String> phone_column;
    @FXML
    public TableColumn<Student, String> course_column;

    @Autowired
    StudentService studentService;
    int myIndex;
    int id;

    @FXML
    public void Add() {
        String st_name = name_txtfld.getText();
        String phone = phone_txtfld.getText().replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        String course = course_txtfld.getText();
        course = course.substring(0, 1).toUpperCase() + course.substring(1);

        Student student = new Student();
        student.setName(st_name);
        student.setPhone(phone);
        student.setCourse(course);

        try {
            studentService.insert(student);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registration");
            alert.setHeaderText("Student Registration");
            alert.setContentText("Record Added!");
            alert.showAndWait();

            table();

            name_txtfld.setText("");
            phone_txtfld.setText("");
            course_txtfld.setText("");
            name_txtfld.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void table() {
        try {
            List<Student> students = studentService.findAll();
            ObservableList<Student> observableStudents = FXCollections.observableArrayList(students);

            table.setItems(observableStudents);
            ID_column.setCellValueFactory(f -> f.getValue().idProperty());
            name_column.setCellValueFactory(f -> f.getValue().nameProperty());
            phone_column.setCellValueFactory(f -> f.getValue().phoneProperty());
            course_column.setCellValueFactory(f -> f.getValue().courseProperty());
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory(tv -> {
            TableRow<Student> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = table.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    name_txtfld.setText(table.getItems().get(myIndex).getName());
                    phone_txtfld.setText(table.getItems().get(myIndex).getPhone());
                    course_txtfld.setText(table.getItems().get(myIndex).getCourse());
                }
            });
            return myRow;
        });
    }

    @FXML
    public void Delete(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        try {
            studentService.delete(id);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registration");
            alert.setHeaderText("Student Registration");
            alert.setContentText("Deleted!");
            alert.showAndWait();

            table();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void Update(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        String st_name = name_txtfld.getText();
        String phone = phone_txtfld.getText().replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        String course = course_txtfld.getText();
        course = course.substring(0, 1).toUpperCase() + course.substring(1);

        Student student = new Student();
        student.setId(String.valueOf(id));
        student.setName(st_name);
        student.setPhone(phone);
        student.setCourse(course);

        try {
            studentService.update(student);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registration");
            alert.setHeaderText("Student Registration");
            alert.setContentText("Updated!");
            alert.showAndWait();

            table();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table();
    }
}
