package View;

import ViewModel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class RegisterController {
    @FXML
    private TextField registeredUsername;
    @FXML
    private PasswordField registeredPassword;
    @FXML
    private TextField registeredEmail;
    @FXML
    private Label errorField;

    private Region root;
    private RegisterViewModel registerViewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, RegisterViewModel registerViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.registerViewModel = registerViewModel;
        this.root = root;

        registeredUsername.textProperty().bindBidirectional(registerViewModel.getRegisteredUsername());
        registeredPassword.textProperty().bindBidirectional(registerViewModel.getRegisteredPassword());
        registeredEmail.textProperty().bindBidirectional(registerViewModel.getRegisteredEmail());
        errorField.textProperty().bind(registerViewModel.getErrorField());
    }

    public Region getRoot() {
        return root;
    }


    public void reset() {
        registerViewModel.clear();
    }


    @FXML
    private void RegisterButton() {
        registerViewModel.Register();
        if (errorField.textProperty().get().equals("")) {
            viewHandler.openView("login");
        }
    }
}
