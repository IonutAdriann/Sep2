package Model;

import Utility.UnnamedPropertySubject;
import mediator.ServerModel;

public interface Model extends UnnamedPropertySubject {
    void addUser(UserType client);
    String getUsername();
    void setUsername(String username);
    boolean Login(String username, String password);
    void Register(UserType Client);

    UserType getUser();

    boolean isAdmin();

    ServerModel getServerModel();

    void loadAssetsToGym(Asset asset);
    void fireProperty(String event, String message);
    String getErrorField();
    void setErrorLabel(String label);
    int getGymAssetsSize();
    Asset getGymAssetByIndicator(int indicator);
    Asset getGymAssetById(String assetId);
    Asset getUserAssetById(String assetId);
    InventoryUser getInventoryUser();
    GymInventory getGymInventory();
    int getUserAssetSize();
    UserType getUserListByIndicator(int i);
    int getUserListSize();
    UserList getListOfUsers();
    Asset getUserProductsInventory();
    void setAdmin(Admin user);
    void setClient(Client user);
    void borrowAsset(String id);
    void freeAsset(String id);
    void addAssetToGym(Asset asset);
    String getErrorLabel();
    UserList getUserList();

}
