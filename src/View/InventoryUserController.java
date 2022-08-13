package View;


import ViewModel.AssetViewModel;
import ViewModel.InventoryUserViewModel;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;



public class InventoryUserController {
    @FXML
    private Label usernameTextBox;
    @FXML private TextField searchTextBox;
    @FXML private TableView<AssetViewModel> mainTable;
    @FXML private TableColumn<AssetViewModel, String> AssetIdCollum;
    @FXML private TableColumn<AssetViewModel, String> AssetNameCollum;
    @FXML private TableColumn<AssetViewModel, String> TypeCollum;
    @FXML private TableColumn<AssetViewModel, String> DescriptionCollum;
    @FXML private TableColumn<AssetViewModel, String> RankingCollum;
    @FXML private TableColumn<AssetViewModel, String> RentedByCollum;

    private Region root;
    private InventoryUserViewModel inventoryUserViewModel;
    private ViewHandler viewHandler;
    private ViewState viewState;

    public InventoryUserController() {

    }

    public void init(ViewHandler viewHandler, InventoryUserViewModel inventoryUserViewModel, Region root, ViewState viewState){
        this.viewHandler = viewHandler;
        this.inventoryUserViewModel = inventoryUserViewModel;
        this.root = root;
        this.viewState=viewState;
        searchTextBox.textProperty().bindBidirectional(InventoryUserViewModel.getSearchTextBox());
        usernameTextBox.textProperty().bind(InventoryUserViewModel.getUsernameField());

        AssetIdCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetId());
        AssetNameCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetName());
        TypeCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetType());
        DescriptionCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetDescription());
        RankingCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetRating());



        FilteredList<AssetViewModel> filteredData = new FilteredList<>(InventoryUserViewModel.getListUsers(), b -> true);

        searchTextBox.textProperty().addListener(((observable, oldValue, newValue) ->{
            filteredData.setPredicate(book -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(book.getAssetName().get().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                } else if (book.getAssetId().get().toLowerCase().equals(lowerCaseFilter)){
                    return true;
                } else if (book.getAssetDescription().get().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }  else {
                    return false;
                }
            });
        } ));

        SortedList<AssetViewModel> sortedList = new SortedList<>(filteredData);

        sortedList.comparatorProperty().bind(mainTable.comparatorProperty());

        mainTable.setItems(sortedList);
    }
    public Region getRoot(){return root;}


    public void reset(){inventoryUserViewModel.clear();}


    public void load(){inventoryUserViewModel.update();}


    public void setName(){
        inventoryUserViewModel.setNameOfUser();
    }


    @FXML private void homeButton(){
        viewHandler.openView("main");
    }


    @FXML private void profileButton(){viewHandler.openView("profile");}


    @FXML private void ReturnButton(){
        AssetViewModel selectedItem = mainTable.getSelectionModel().getSelectedItem();
        inventoryUserViewModel.freeAsset(selectedItem.getAssetId().get());
    }
}
