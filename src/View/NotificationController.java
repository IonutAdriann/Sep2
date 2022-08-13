package View;

import ViewModel.NotifyViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

public class NotificationController {
    @FXML
    private ListView<String> notifyList;
    private NotifyViewModel notifyViewModel;
    private Region root;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, NotifyViewModel notifyViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.notifyViewModel = notifyViewModel;
        this.root = root;
        notifyList.setItems(notifyViewModel.getNotifies());
    }
    public Region getRoot() {
        return root;
    }

    @FXML private void BackButton(){viewHandler.openView("profile");}

    public void reset(){

    }
}
