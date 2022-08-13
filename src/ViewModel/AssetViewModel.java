package ViewModel;

import Model.Asset;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AssetViewModel {
    private StringProperty assetID;
    private StringProperty assetName;
    private StringProperty assetType;
    private StringProperty assetRating;
    private StringProperty assetDescription;

    public AssetViewModel(Asset asset) {
        assetID = new SimpleStringProperty(asset.getId());
        assetName = new SimpleStringProperty(asset.getName());
        assetType = new SimpleStringProperty(asset.getType());
        assetRating = new SimpleStringProperty(asset.getRatings() + "");
        assetDescription = new SimpleStringProperty(asset.getDescription());
    }

    public StringProperty getAssetId(){return assetID;}

    public StringProperty getAssetName(){return assetName;}

    public StringProperty getAssetType(){return assetType;}

    public StringProperty getAssetRating(){return assetRating;}

    public StringProperty getAssetDescription(){return assetDescription;}
}

