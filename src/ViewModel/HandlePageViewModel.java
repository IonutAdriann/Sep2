package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.Model;

public class HandlePageViewModel {
    private StringProperty usernameTextBox;
    private StringProperty idTextBox;
    private StringProperty usernameField;
    private Model model;

    public HandlePageViewModel(Model model) {
        usernameTextBox = new SimpleStringProperty();
        idTextBox = new SimpleStringProperty();
        usernameField = new SimpleStringProperty();
        this.model = model;
    }

    public void RemoveAsset() {
        model.getGymInventory().removeAssetById(idTextBox.get());
        model.getServerModel().removeAsset(idTextBox.get());
    }
    public void setName() {usernameTextBox.set(model.getUsername());}
    public StringProperty getUsernameTextBox() {return usernameTextBox;}

    public void setUsernameTextBox() {usernameTextBox.set(model.getUsername());}

    public StringProperty getUsernameField() {return usernameField;}

    public StringProperty getIdTextBox() {return idTextBox;}

    public void clear() {
        idTextBox.set("");
        usernameField.set("");
    }
}
