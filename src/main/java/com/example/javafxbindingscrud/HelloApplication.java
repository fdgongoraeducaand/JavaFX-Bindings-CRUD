package com.example.javafxbindingscrud;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private TableView<Person> table = new TableView<>();
    private ObservableList<Person> data = FXCollections.observableArrayList();


    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private Button addButton = new Button("Add");
    private Button updateButton = new Button("Update");
    private Button deleteButton = new Button("Delete");


    @Override
    public void start(Stage stage) throws IOException {
        // Set up the table
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> lastNameCol = new TableColumn<>("LastName");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        table.getColumns().addAll(firstNameCol, lastNameCol);

        table.setItems(data);

        // Set up the input fields
        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(firstNameField, lastNameField, addButton);

        // Set up the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(updateButton, deleteButton);

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(table, inputBox, buttonBox);

        // Bindings and Properties
        StringProperty firstNameProperty = new SimpleStringProperty();
        StringProperty lastNameProperty = new SimpleStringProperty();
        firstNameField.textProperty().bindBidirectional(firstNameProperty);
        lastNameField.textProperty().bindBidirectional(lastNameProperty);

        addButton.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> firstNameProperty.get() == null || firstNameProperty.get().trim().isEmpty() ||
                                lastNameProperty.get() == null || lastNameProperty.get().trim().isEmpty(),
                        firstNameProperty, lastNameProperty
                )
        );
        addButton.setOnAction(e -> {
            data.add(new Person(firstNameProperty.get(), lastNameProperty.get()));
            firstNameProperty.set("");
            lastNameProperty.set("");
        });


        updateButton.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());

        updateButton.setOnAction(e -> {
            Person selectedPerson = table.getSelectionModel().getSelectedItem();
            selectedPerson.firstNameProperty().set(firstNameProperty.get());
            selectedPerson.lastNameProperty().set(lastNameProperty.get());
        });

        deleteButton.setOnAction(e -> {
            Person selectedPerson = table.getSelectionModel().getSelectedItem();
            data.remove(selectedPerson);
        });

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                firstNameProperty.set(newSelection.getFirstName());
                lastNameProperty.set(newSelection.getLastName());
            }
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CRUD Application");
        stage.show();
    }

    public static class Person {
        private StringProperty firstName = new SimpleStringProperty();
        private StringProperty lastName = new SimpleStringProperty();


        public Person(String firstName, String lastName) {
            this.firstName.set(firstName);
            this.lastName.set(lastName);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public  StringProperty firstNameProperty() {
            return firstName;
        }

        public String getLastName() {
            return lastName.get();
        }

        public StringProperty lastNameProperty()
        {
            return lastName;
        }
    }

}