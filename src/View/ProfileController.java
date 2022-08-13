package View;

import ViewModel.ProfileViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class ProfileController {
    @FXML
    private Label usernameLabel;
    @FXML private Label assetsNumberLabel;
    @FXML private Button manageGymButtonId;
    @FXML private Label usernameTextBox;

    private Region root;
    private ProfileViewModel profileViewModel;
    private ViewHandler viewHandler;

    public ProfileController() {

    }

    public void init(ViewHandler viewHandler, ProfileViewModel profileViewModel, Region root){
        this.viewHandler = viewHandler;
        this.profileViewModel = profileViewModel;
        this.root = root;

        usernameTextBox.textProperty().bind(profileViewModel.getUsernameTextBox());
        usernameLabel.textProperty().bind(profileViewModel.getUsernameField());

        assetsNumberLabel.textProperty().bind(profileViewModel.getAssetsNumber());

        if (!profileViewModel.isAdmin()){
            manageGymButtonId.setOnAction((action) -> {

            });
            manageGymButtonId.setDisable(true);
        }

    }

    public Region getRoot(){return root;}


    public void reset(){
        profileViewModel.clear();
    }


    public void setName(){
        profileViewModel.setNameOfUser();
    }


    @FXML private void profileButton(){viewHandler.openView("profile");}


    @FXML private void homeButton(){
        viewHandler.openView("main");
    }


    @FXML private void ManageButton(){viewHandler.openView("managePage");}


    @FXML private void NotificationButton(){viewHandler.openView("notifications");}
}
