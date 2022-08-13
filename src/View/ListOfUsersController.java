package View;

import ViewModel.AssetViewModel;
import ViewModel.InventoryUserViewModel;
import ViewModel.UserListViewModel;
import ViewModel.UserViewModel;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;


public class ListOfUsersController {
    @FXML private TextField searchTextBox;
    @FXML private TableView<UserViewModel> mainTable;
    @FXML private TableColumn<UserViewModel, String> userNameCollumn;
    @FXML private TableColumn<UserViewModel, Boolean> IsAdminCollumn;


    private Region root;
    private UserListViewModel userListViewModel;
    private ViewHandler viewHandler;
    private ViewState viewState;

    public ListOfUsersController(){

    }


    public void init(ViewHandler viewHandler, UserListViewModel userListViewModel, Region root, ViewState viewState){
        this.viewHandler = viewHandler;
        this.userListViewModel = userListViewModel;
        this.root = root;
        this.viewState=viewState;
        searchTextBox.textProperty().bindBidirectional(userListViewModel.getSearchTextBox());

        userNameCollumn.setCellValueFactory(celldata -> celldata.getValue().getUserName());
        IsAdminCollumn.setCellValueFactory(celldata -> celldata.getValue().getIsAdmin());



        FilteredList<UserViewModel> filteredData = new FilteredList<>(userListViewModel.getListUsers(), b -> true);

       searchTextBox.textProperty().addListener(((observable, oldValue, newValue) ->{
            filteredData.setPredicate(user -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(user.getUserName().get().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                } else {
                    return false;
                }
            });
        } ));

        SortedList<UserViewModel> sortedList = new SortedList<>(filteredData);

        sortedList.comparatorProperty().bind(mainTable.comparatorProperty());

        mainTable.setItems(sortedList);


        mainTable.setRowFactory( tv -> {
            TableRow<UserViewModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (! row.isEmpty())){
                    UserViewModel rowData = row.getItem();
                    viewState.setSelectedAsset(rowData.getUserName().get());

                    viewHandler.openView("inspect");
                }
            });
            return row;
        });




    }


    public Region getRoot(){return root;}


    public void reset(){userListViewModel.clear();}


    public void load(){userListViewModel.update();}


    public void setName(){
        UserListViewModel.setNameOfUser();
    }


    @FXML private void homeButton(){
        viewHandler.openView("main");
    }


    @FXML private void profileButton(){viewHandler.openView("profile");}



    @FXML private void createUser()
    {
    }

    @FXML private void changeUserRole()
    {
    }

    @FXML private void deleteUser()
    {
    }
}
