package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Model;

public class UserListViewModel {
    private StringProperty searchTextBox;
    private StringProperty usernameField;
    private ObservableList<UserViewModel> listOfUsers;
    private Model model;

    public UserListViewModel(Model model) {
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
        for(int i = 0; i < model.getUserListSize(); i++) {
            listOfUsers.add(new UserViewModel(model.getUserListByIndicator(i)));
        }
    }

    public StringProperty getSearchTextBox() {return searchTextBox;}

    public StringProperty getUsernameField() {return usernameField;}

    public ObservableList<UserViewModel> getListUsers() {return listOfUsers;}

}
