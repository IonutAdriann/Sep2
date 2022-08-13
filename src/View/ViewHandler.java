package View;

import ViewModel.ViewModelBuild;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;
    private ViewModelBuild viewModelBuild;
    private LoginController loginController;
    private ProfileController profileController;
    private MainPageController mainPageController;
    private AddAssetController addAssetController;
    private ManageAssetController manageAssetController;
    private RegisterController registerController;
    private NotificationController notificationController;
    private ListOfUsersController listOfUsersController;
    private InventoryUserController inventoryUserController;
    private ViewState viewState;


    public ViewHandler(ViewModelBuild viewModelBuild){
        this.viewModelBuild = viewModelBuild;
        this.currentScene = new Scene(new Region());
        viewState=new ViewState();
    }


    public void openView(String id){
        Region root = null;

        switch (id){
            case "Main":
                root = loadMainPage("Main.fxml");
                break;
            case "Inventory":
                root = loadInventoryUser("InventoryUser.fxml");
                break;
            case "Profile":
                root = loadProfilePage("ProfilePage.fxml");
                break;
            case "addAsset":
                root = loadAddAsset("AddAsset.fxml");
                break;
            case "manageAsset":
                root = loadManageAsset("ManageAsset.fxml");
                break;
            case "login":
                root = loadLogin("Login.fxml");
                break;
            case "register":
                root = loadRegister("Register.fxml");
                break;

            case "notifications":
                root = loadNotifications("Notification.fxml");
                break;
            case "UserList":
                root= loadListOfUsers("ListOfUsers.fxml");
                break;


        }
        currentScene.setRoot(root);
        String title ="";
        if(root.getUserData() != null){
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        openView("login");

    }


    public void closeView(){primaryStage.close();}


    private Region loadMainPage(String fxmlFile){
        Region root = null;
        if(mainPageController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                mainPageController = loader.getController();
                mainPageController.init(this, viewModelBuild.getMainPageViewModel(), root,viewState);
                mainPageController.setName();
                mainPageController.load();
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            mainPageController.reset();
        }
        return mainPageController.getRoot();

    }


    private Region loadProfilePage(String fxmlFile){
        Region root = null;
        if(profileController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                profileController = loader.getController();
                profileController.init(this, viewModelBuild.getProfileViewModel(), root);
                profileController.setName();
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            profileController.reset();
        }
        return profileController.getRoot();

    }


    private Region loadInventoryUser(String fxmlFile){
        Region root = null;
        if(inventoryUserController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                inventoryUserController = loader.getController();
                inventoryUserController.init(this, viewModelBuild.getInventoryUserViewModel(), root,viewState);
                inventoryUserController.setName();
                inventoryUserController.load();
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            inventoryUserController.reset();
        }
        return inventoryUserController.getRoot();

    }

    private Region loadAddAsset(String fxmlFile){
        Region root = null;
        if(addAssetController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                addAssetController = loader.getController();
                addAssetController.init(this, viewModelBuild.getAddAssetViewModel(), root);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            addAssetController.reset();
        }
        return addAssetController.getRoot();

    }


    private Region loadManageAsset(String fxmlFile){
        Region root = null;
        if(manageAssetController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                manageAssetController = loader.getController();
                manageAssetController.init(this, viewModelBuild.getHandlePageViewModel(), root);
                manageAssetController.setName();
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            manageAssetController.reset();
        }
        return manageAssetController.getRoot();

    }


    private Region loadLogin(String fxmlFile){
        Region root = null;
        if(loginController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                loginController = loader.getController();
                loginController.init(this, viewModelBuild.getLoginViewModel(), root);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            loginController.reset();
        }
        return loginController.getRoot();

    }


    private Region loadRegister(String fxmlFile){
        Region root = null;
        if(registerController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                registerController = loader.getController();
                registerController.init(this, viewModelBuild.getRegisterViewModel(), root);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            registerController.reset();
        }
        return registerController.getRoot();

    }




    private Region loadNotifications(String fxmlFile) {
        Region root = null;
        if (notificationController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                notificationController = loader.getController();
                notificationController.init(this, viewModelBuild.getNotifyViewModel(), root);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            notificationController.reset();
        }
        return notificationController.getRoot();

    }
    private Region loadListOfUsers(String fxmlFile) {
        Region root = null;
        if (listOfUsersController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                listOfUsersController = loader.getController();
                listOfUsersController.init(this, viewModelBuild.getUserListViewModel(), root, viewState);
                listOfUsersController.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            listOfUsersController.reset();
        }
        return listOfUsersController.getRoot();

    }
}
