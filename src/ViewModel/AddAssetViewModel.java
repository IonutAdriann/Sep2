package ViewModel;

import Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.Asset;
import Model.GymInventory;

public class AddAssetViewModel {

    private StringProperty assetIDField;
    private StringProperty assetNameField;
    private StringProperty assetTypeField;
    private StringProperty assetRatingField;
    private StringProperty assetDescriptionField;
    private Model model;
    private StringProperty errorField;

    public AddAssetViewModel(Model model) {
        this.model = model;
        assetIDField = new SimpleStringProperty();
        assetNameField = new SimpleStringProperty();
        assetTypeField = new SimpleStringProperty();
        assetRatingField = new SimpleStringProperty();
        assetDescriptionField = new SimpleStringProperty();
        errorField.set(" ");
    }

    public void clear() {
        assetIDField.set("");
        assetNameField.set("");
        assetTypeField.set("");
        assetRatingField.set("");
        assetDescriptionField.set("");
        errorField.set("");
    }

    public boolean addAsset() {
        try{
            Asset asset = new Asset(assetIDField.get(), assetNameField.get(), assetTypeField.get(), assetDescriptionField.get());

            try {
                boolean IsExisting = false;
                GymInventory gymInventory = model.getGymInventory();
                for(int i = 0; i < gymInventory.getSize(); i++) {
                    if(gymInventory.getAsset(i).getId().equals(asset.getId())) {
                        errorField.set("The asset is in inventory");
                        return IsExisting;
                    }
                }
                model.addAssetToGym(asset);
                errorField.set("");
                IsExisting = true;
                return IsExisting;
            }
            catch (Exception e) {

            }
            errorField.set("");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            errorField.set(illegalArgumentException.getMessage());
        }
        return false;
    }
    public StringProperty getAssetIDField() {return assetIDField;}

    public StringProperty getAssetNameField() {return assetNameField;}

    public StringProperty getAssetTypeField() {return assetTypeField;}

    public StringProperty getAssetRatingField() {return assetRatingField;}

    public StringProperty getAssetDescriptionField() {return assetDescriptionField;}

    public StringProperty getErrorField() {return errorField;}

}
