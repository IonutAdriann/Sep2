package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.Model;
import Model.UserType;
import Model.Client;

public class RegisterViewModel {
    private StringProperty RegisteredUsername;
    private StringProperty RegisteredPassword;
    private StringProperty RegisteredEmail;
    private StringProperty errorField;
    private Model model;

    public RegisterViewModel(Model model) {
        RegisteredUsername = new SimpleStringProperty();
        RegisteredPassword = new SimpleStringProperty();
        RegisteredEmail = new SimpleStringProperty();
        errorField = new SimpleStringProperty();
        this.model = model;
    }

    public void Register() {
        try{
            UserType userType = new Client(RegisteredUsername.get(), RegisteredPassword.get(), RegisteredEmail.get());
            model.Register(userType);
            errorField.set("");
        } catch (IllegalArgumentException e) {
            errorField.set(e.getMessage());
        }
    }

    public StringProperty getRegisteredUsername() {return RegisteredUsername;}

    public StringProperty getRegisteredPassword() {return RegisteredPassword;}

    public StringProperty getRegisteredEmail() {return RegisteredPassword;}

    public StringProperty getErrorField() {return errorField;}
    public void clear() {
        RegisteredEmail.set("");
        RegisteredPassword.set("");
        RegisteredUsername.set("");
        errorField.set("");
    }
}
