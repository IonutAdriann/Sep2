package View;

import ViewModel.AddAssetViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddAssetController {
    @FXML
    private TextField assetIDField;
    @FXML private TextField assetNameField;
    @FXML private TextField assetTypeField;
    @FXML private TextField assetRatingField;
    @FXML private Label DescriptionTextField;
    @FXML private Label errorLabel;

    private Region root;
    private AddAssetViewModel addAssetViewModel;
    private ViewHandler viewHandler;


    public void init(ViewHandler viewHandler, AddAssetViewModel addAssetViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.addAssetViewModel = addAssetViewModel;
        this.root = root;

        assetIDField.textProperty().bindBidirectional(addAssetViewModel.getAssetIDField());
        assetNameField.textProperty().bindBidirectional(addAssetViewModel.getAssetNameField());
        assetTypeField.textProperty().bindBidirectional(addAssetViewModel.getAssetTypeField());
        assetRatingField.textProperty().bindBidirectional(addAssetViewModel.getAssetRatingField());
        DescriptionTextField.textProperty().bindBidirectional(addAssetViewModel.getAssetDescriptionField());
        errorLabel.textProperty().bind(addAssetViewModel.getErrorField());
    }


    public Region getRoot(){return root;}


    public void reset(){
        addAssetViewModel.clear();
    }


    @FXML private void CancelButton(){viewHandler.openView("managePage");}

    @FXML private void AddButton(){

        if(addAssetViewModel.addAsset()){
            viewHandler.openView("managePage");
        }
    }
}
