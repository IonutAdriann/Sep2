package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Model;

public class InventoryUserViewModel {

    private StringProperty searchTextBox;
    private StringProperty usernameField;
    private ObservableList<AssetViewModel> listOfUsers;
    private Model model;

    public InventoryUserViewModel(Model model) {
        searchTextBox = new SimpleStringProperty();
        usernameField = new SimpleStringProperty();
        listOfUsers = FXCollections.observableArrayList();
        this.model = model;
    }

    public void setNameOfUser() {usernameField.set(model.getUsername());}

    public void clear() {
        update();
        searchTextBox.set("");
    }

    public void update() {
        listOfUsers.clear();
        for(int i = 0; i< model.getInventoryUser().getSize(); i++) {
            listOfUsers.add(new AssetViewModel(model.getGymAssetByIndicator(i)));
        }
    }

    public void freeAsset(String id) {
        model.freeAsset(id);
        update();
    }

    public StringProperty getSearchTextBox() {return searchTextBox;}

    public StringProperty getUsernameField() {return usernameField;}

    public ObservableList<AssetViewModel> getListUsers() {return listOfUsers;}
}
