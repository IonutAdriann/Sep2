package Model;


import java.util.ArrayList;

public class GymInventory {
    private ArrayList<Asset> assets;


    public GymInventory(){
        this.assets = new ArrayList<>();
    }


    public void addAsset(Asset asset){
        assets.add(asset);
    }



    public Asset getAsset(int indicator){
        return assets.get(indicator);
    }


    public int getSize(){
        return assets.size();
    }


    public ArrayList<Asset> getAssets(){return assets;}


    public Asset getAssetById(String id){
        for (int i = 0; i < assets.size(); i++){
            if (assets.get(i).getId().equals(id)){
                return assets.get(i);
            }
        }
        return null;
    }



    public void removeAssetById(String id){
        for (int i = 0; i < assets.size(); i++){
            if (assets.get(i).getId().equals(id)){
                assets.remove(assets.get(i));
            }
        }
    }
}
