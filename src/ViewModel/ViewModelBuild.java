package ViewModel;

import Model.Model;

public class ViewModelBuild {
    private MainPageViewModel mainPageViewModel;
    private InventoryUserViewModel inventoryUserViewModel;
    private ProfileViewModel profileViewModel;
    private AddAssetViewModel addAssetViewModel;
    private HandlePageViewModel handlePageViewModel;
    private LoginViewModel loginViewModel;
    private RegisterViewModel registerViewModel;
    private NotifyViewModel notifyViewModel;
    private UserListViewModel userListViewModel;
    private Model model;

    public ViewModelBuild(Model model) {
        mainPageViewModel = new MainPageViewModel(model);
        inventoryUserViewModel = new InventoryUserViewModel(model);
        profileViewModel = new ProfileViewModel(model);
        addAssetViewModel = new AddAssetViewModel(model);
        handlePageViewModel = new HandlePageViewModel(model);
        loginViewModel = new LoginViewModel(model);
        registerViewModel = new RegisterViewModel(model);
        notifyViewModel = new NotifyViewModel(model);
        userListViewModel= new UserListViewModel(model);
        this.model = model;
    }

    public MainPageViewModel getMainPageViewModel(){return mainPageViewModel;}


    public HandlePageViewModel getHandlePageViewModel(){return handlePageViewModel;}


    public InventoryUserViewModel getInventoryUserViewModel(){return inventoryUserViewModel;}


    public ProfileViewModel getProfileViewModel(){return profileViewModel;}


    public AddAssetViewModel getAddAssetViewModel(){return addAssetViewModel;}


    public LoginViewModel getLoginViewModel(){return loginViewModel;}

    public RegisterViewModel getRegisterViewModel(){return registerViewModel;}


    public NotifyViewModel getNotifyViewModel(){return notifyViewModel;}

    public UserListViewModel getUserListViewModel()
    {
        return userListViewModel;
    }
}
