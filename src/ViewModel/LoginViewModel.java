package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.Model;

public class LoginViewModel {
    private StringProperty usernameLogin;
    private StringProperty passwordLogin;
    private StringProperty errorField;
    private Model model;

    public LoginViewModel(Model model){
        usernameLogin = new SimpleStringProperty();
        passwordLogin = new SimpleStringProperty();
        errorField = new SimpleStringProperty();
        this.model = model;
    }

    public void clear() {
        usernameLogin.set("");
        passwordLogin.set("");
        errorField.set("");
    }

    public boolean loginVerify() {
        if(model.Login(usernameLogin.get(), passwordLogin.get())) {
            model.setUsername(usernameLogin.get());
            return true;
        }
        errorField.set(model.getErrorField());
        return false;
    }

    public StringProperty getUsernameLogin(){return usernameLogin;}

    public StringProperty getPasswordLogin(){return passwordLogin;}

    public StringProperty getErrorField(){return errorField;}
}
