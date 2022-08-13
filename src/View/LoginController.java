package View;

import ViewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class LoginController {
    @FXML
    private TextField LoginUsername;
    @FXML private PasswordField LoginPassword;
    @FXML private Label ErrorLabel;

    private Region root;
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;
    public LoginController(){

    }


    public void init(ViewHandler viewHandler, LoginViewModel loginViewModel, Region root){
        this.viewHandler = viewHandler;
        this.loginViewModel = loginViewModel;
        this.root = root;

        LoginUsername.textProperty().bindBidirectional(loginViewModel.getUsernameLogin());
        LoginPassword.textProperty().bindBidirectional(loginViewModel.getPasswordLogin());
        ErrorLabel.textProperty().bind(loginViewModel.getErrorField());
    }


    public Region getRoot(){return root;}


    public void reset(){
        loginViewModel.clear();
    }


    @FXML private void loginButton(){
        if (loginViewModel.loginVerify()){
            viewHandler.openView("main");
        }

    }

    @FXML private void registerButton(){
        viewHandler.openView("register");
    }
}
