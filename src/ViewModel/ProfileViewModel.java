package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.Model;

public class ProfileViewModel {
    private StringProperty usernameField;
    private StringProperty assetsNumber;
    private StringProperty usernameTextBox;
    private Model model;

    public ProfileViewModel(Model model) {
        usernameField = new SimpleStringProperty();
        assetsNumber = new SimpleStringProperty();
        usernameTextBox = new SimpleStringProperty();
    }

    public void setNameOfUser() {
       usernameField.set("Set Username: " + model.getUsername());
       assetsNumber.set("Asset Number: " + model.getInventoryUser().getSize());
       usernameTextBox.set(model.getUsername());
    }

    public void clear() {
        assetsNumber.set("Assets Number: " + model.getInventoryUser().getSize());
    }

    public StringProperty getUsernameField() {return usernameField;}

    public StringProperty getAssetsNumber() {return assetsNumber;}

    public StringProperty getUsernameTextBox() {return usernameTextBox;}

    public boolean isAdmin() {return model.isAdmin();}
}
