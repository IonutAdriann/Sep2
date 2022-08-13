package ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import Model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NotifyViewModel implements PropertyChangeListener {

    private ObservableList<String> notifies;
    private Model model;

    public NotifyViewModel(Model model) {
        model.addListener(this);
        notifies = FXCollections.observableArrayList();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            switch (evt.getPropertyName()) {
                case "notify":
                    notifies.add(0, "Asset is added: " + evt.getNewValue() + " ");
                    break;
            }
        });
    }

    public ObservableList<String> getNotifies() {return notifies;}
}
