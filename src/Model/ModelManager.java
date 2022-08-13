package Model;

import mediator.GymClient;
import mediator.ServerModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model {
    private GymInventory gymInventory;
    private InventoryUser inventoryUser;
    private PropertyChangeSupport property;
    private ArrayList<UserType> userTypes;
    private String username;
    private ServerModel serverModel;
    private UserType client;
    private String ErrorField;
    private UserList userList;


    public ModelManager(){
        property =  new PropertyChangeSupport(this);
        gymInventory = new GymInventory();
        inventoryUser = new InventoryUser();
        userTypes = new ArrayList<>();
        username = "";
        serverModel = new GymClient("localhost", 6789, this);
        client = null;
        ErrorField="";
        userList= new UserList();
    }


    @Override public void addAssetToGym(Asset asset){
        gymInventory.addAsset(asset);
        serverModel.addAssetToGymServer(asset);
    }


    @Override public UserType getUser() {
        return client;
    }


    @Override public void setAdmin(Admin user) {
        this.client = user;
    }


    @Override public void setClient(Client client){
        this.client=client;
    }


    @Override public void borrowAsset(String id){
        inventoryUser.addAsset(GymInventory.getAssetById(id));
        serverModel.borrowAsset(id);
    }


    @Override public void addUser(UserType user){userTypes.add(user);}


    @Override public String getUsername(){return username;}


    @Override public void setUsername(String username){
        this.username=username;
    }


    @Override public boolean Login(String username, String password){
        return serverModel.Login(username, password);
    }


    @Override public void Register(UserType user){
        serverModel.Register(user);
    }


    @Override public String getErrorLabel(){return ErrorField;}


    @Override public void setErrorLabel(String label){ErrorField = label;}


    @Override public boolean isAdmin(){ return client.isAdmin();}


    @Override public ServerModel getServerModel(){return serverModel;}


    @Override public void loadAssetsToGym(Asset asset){
        GymInventory.addAsset(asset);
    }




    @Override
    public int getGymAssetsSize(){
        return GymInventory.getSize();
    }


    @Override public Asset getGymAssetByIndicator(int indicator) {return GymInventory.getAssets(indicator);}


    @Override public GymInventory getGymInventory(){return gymInventory;}


    @Override public Asset getGymAssetById(String id){return inventoryUser.getAssetById(id);}


    @Override public InventoryUser getInventoryUser(){return inventoryUser;}


    @Override public Asset getUserAssetById(String id) {return inventoryUser.getAssetById(id);}


    @Override public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }


    @Override public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }


    @Override public void fireProperty(String event, String message){
        property.firePropertyChange(event, null, message);
    }


    @Override public int getUserListSize()
    {
        return userList.getSize();
    }


    @Override public UserType getUserListByIndicator(int i)
    {
        return userList.getUser(i);
    }


    @Override
    public UserList getUserList()
    {
        return userList;
    }

}
