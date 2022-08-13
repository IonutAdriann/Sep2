import Model.Model;
import Model.ModelManager;
import View.ViewHandler;
import ViewModel.ViewModelBuild;
import javafx.stage.Stage;

public class MyApplication {

    public void start(Stage primaryStage){
        Model model = new ModelManager();
        ViewModelBuild viewModelBuild = new ViewModelBuild(model);
        ViewHandler view = new ViewHandler(viewModelBuild);
        view.start(primaryStage);

    }
}
