package mediator;

import Model.Asset;
import Model.UserType;

public interface ServerModel {
    boolean Login(String username, String password);
    void Register(UserType User);
    void borrowAsset(String id);
    void returnAsset(String id);
    void rateAsset(String id, String username, int rating1);
    void removeAsset(String id);
    void addAssetToGymServer(Asset asset);

}
