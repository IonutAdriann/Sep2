package View;

import ViewModel.AssetViewModel;
import ViewModel.MainPageViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;



public class MainPageController {
    @FXML private Label usernameTextBox;
    @FXML private TextField searchTextBox;
    @FXML private TableView<AssetViewModel> mainTable;
    @FXML private TableColumn<AssetViewModel, String> AssetIdCollum;
    @FXML private TableColumn<AssetViewModel, String> AssetNameCollum;
    @FXML private TableColumn<AssetViewModel, String> AssetDescriptionCollum;
    @FXML private TableColumn<AssetViewModel, String> TypeCollum;
    @FXML private TableColumn<AssetViewModel, String> RatingCollum;

    private Region root;
    private MainPageViewModel mainViewModel;
    private ViewHandler viewHandler;
    private ViewState viewState;

    public MainPageController (){

    }

    public void init(ViewHandler viewHandler, MainPageViewModel mainViewModel, Region root, ViewState viewState){
        this.viewHandler = viewHandler;
        this.mainViewModel = mainViewModel;
        this.root = root;
        this.viewState=viewState;
        searchTextBox.textProperty().bindBidirectional(mainViewModel.getSearchTextBox());
        usernameTextBox.textProperty().bind(mainViewModel.getUsernameTextBox());

        AssetIdCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetId());
        AssetNameCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetName());
        AssetDescriptionCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetDescription());
        TypeCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetType());
        RatingCollum.setCellValueFactory(celldata -> celldata.getValue().getAssetRating());



        FilteredList<AssetViewModel> filteredData = new FilteredList<>(MainPageViewModel.getList(), b -> true);
        searchTextBox.textProperty().addListener(((observable, oldValue, newValue) ->{
            filteredData.setPredicate(asset -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(asset.getAssetName().get().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                } else if (asset.getAssetId().get().toLowerCase().equals(lowerCaseFilter)){
                    return true;
                } else if (asset.getAssetDescription().get().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }  else {
                    return false;
                }
            });
        } ));

        SortedList<AssetViewModel> sortedList = new SortedList<>(filteredData);

        sortedList.comparatorProperty().bind(mainTable.comparatorProperty());

        mainTable.setItems(sortedList);



        mainTable.setRowFactory( tv -> {
            TableRow<AssetViewModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (! row.isEmpty())){
                    AssetViewModel rowData = row.getItem();
                    viewState.setSelectedAsset(rowData.getAssetId().get());
                    if(mainViewModel.isAdmin()){
                        viewHandler.openView("edit");
                    } else {
                        viewHandler.openView("inspect");
                    }

                }
            });
            return row;
        });
    }

    public Region getRoot(){return root;}


    public void setName(){
        mainViewModel.setName();
    }


    public void reset(){MainPageViewModel.clear();}


    public void load(){mainViewModel.update();}


    @FXML private void homeButton(){
        viewHandler.openView("main");
    }


    @FXML private void borrowButton(){
        try{
            AssetViewModel selectedItem = mainTable.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                MainPageViewModel.borrowAsset(selectedItem.getAssetId().get());
            } else {
                throw new IllegalArgumentException("No assets are chosen.");
            }
        }catch (IllegalArgumentException e){

        }
    }


    @FXML private void inventoryButton(){
        viewHandler.openView("inventory");
    }


    @FXML private void profileButton(){viewHandler.openView("profile");}




}
