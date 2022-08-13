package Model;

import java.util.ArrayList;

public class InventoryUser {
    private ArrayList<Asset> assets;

    public InventoryUser() {
        this.assets = new ArrayList<>();
    }

    public void addAsset(Asset asset) {
        Asset asset1 = new Asset(asset.getId(), asset.getName(), asset.getType(), asset.getDescription());
        assets.add(asset1);
    }

    public Asset getAsset(int indicator) {
        return assets.get(indicator);
    }

    public int getSize() {return assets.size();}

    public ArrayList<Asset> getAssets() {return assets;}

    public void removeAssetById(String id) {
        for(int i= 0; i< assets.size(); i++) {
            if(assets.get(i).getId().equals(id)) {
                assets.remove(assets.get(i));
            }
        }
    }
    public Asset getAssetById(String id) {
        for(int i = 0; i < assets.size(); i++) {
            if(assets.get(i).getId().equals(id)) {
                return assets.get(i);
            }
        }
        return null;
    }

}
