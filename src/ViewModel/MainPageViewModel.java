package ViewModel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Model;
import javafx.scene.control.Alert;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainPageViewModel implements PropertyChangeListener {
    private StringProperty usernameTextBox;
    private StringProperty searchTextBox;
    private ObservableList<AssetViewModel> list;
    private Model model;

    public MainPageViewModel(Model model) {
        usernameTextBox = new SimpleStringProperty();
        searchTextBox = new SimpleStringProperty();
        list = FXCollections.observableArrayList();
        setName();
        model.addListener(this);
        this.model = model;
    }

    public void update() {
        list.clear();
        for(int i = 0; i < model.getGymAssetsSize(); i++) {
            list.add(new AssetViewModel(model.getGymAssetByIndicator(i)));
        }
    }

    public void setName() {usernameTextBox.set(model.getUsername());}

    public void borrowAsset(String id)/*reserveAsset*/ {
        boolean IsExisting = false;
        for(int i = 0; i < model.getInventoryUser().getSize(); i++) {
            if(model.getInventoryUser().getAsset(i).getId().equals(id)) {
                IsExisting = true;
            }
        }
        if (IsExisting) {
            if(model.getInventoryUser().getAssetById(id).getIsReturned()) {
                model.borrowAsset(id);
            }
        } else {
            model.borrowAsset(id);
        }
    }

    public boolean isAdmin() {return model.isAdmin();}

    public ObservableList<AssetViewModel> getList() {return list;}

    public StringProperty getUsernameTextBox(){return usernameTextBox;}

    public StringProperty getSearchTextBox() {return searchTextBox;}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            switch (evt.getPropertyName()) {
                case "Alert information" :
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add asset in the system");
                    alert.setHeaderText("Asset added in the system");
                    alert.setContentText(evt.getNewValue() + " ");
                    alert.show();
                    break;
            }
        });
    }

    public void clear() {
        update();
        searchTextBox.set("");
    }
}
