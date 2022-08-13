package ViewModel;

import Model.UserType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserViewModel {
    private StringProperty userName;
    private StringProperty email;
    private BooleanProperty isAdmin;

    public UserViewModel(UserType userType) {
        userName = new SimpleStringProperty(userType.getUsername());
        email = new SimpleStringProperty(userType.getUsername());
        isAdmin = new SimpleBooleanProperty(userType.isAdmin());
    }

    public StringProperty getUserName() {return userName;}

    public StringProperty getEmail() {return email;}

    public BooleanProperty getIsAdmin() {return isAdmin;}
}
