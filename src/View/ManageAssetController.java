package View;

import ViewModel.HandlePageViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ManageAssetController {
    @FXML
    private Label IdFiled;
    @FXML private Label usernameTextBox;

    private Region root;
    private HandlePageViewModel handlePageViewModel;
    private ViewHandler viewHandler;

    public ManageAssetController() {

    }
    public void init(ViewHandler viewHandler, HandlePageViewModel handlePageViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.handlePageViewModel = handlePageViewModel;
        this.root = root;

        IdFiled.textProperty().bindBidirectional(handlePageViewModel.getIdTextBox());
        usernameTextBox.textProperty().bind(handlePageViewModel.getUsernameTextBox());
    }

    public Region getRoot(){return root;}


    public void reset(){
        handlePageViewModel.clear();
    }


    public void setName(){
        handlePageViewModel.setName();
    }


    @FXML private void AddAssetButton(){viewHandler.openView("add Asset");}


    @FXML private void profileButton(){viewHandler.openView("profile");}


    @FXML private void homeButton(){
        viewHandler.openView("main");
    }


    @FXML private void RemoveButton(){handlePageViewModel.RemoveAsset();
    }


    @FXML private void OpenListOfUsersButton(){
        viewHandler.openView("ListOfUsers");
    }

}
