package ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.Model;

public class RateAssetViewModel {
    private StringProperty assetIDField;
    private StringProperty assetNameField;
    private StringProperty assetTypeField;
    private StringProperty assetDescription;
    private Model model;

    public RateAssetViewModel(Model model) {
        assetIDField = new SimpleStringProperty();
        assetNameField = new SimpleStringProperty();
        assetTypeField = new SimpleStringProperty();
        assetDescription = new SimpleStringProperty();
        this.model = model;
    }

    public void clear(String assetId) {
        assetIDField.set(model.getGymAssetById(assetId).getId());
        assetNameField.set(model.getGymAssetById(assetId).getName());
        assetTypeField.set(model.getGymAssetById(assetId).getType());
        assetDescription.set(model.getGymAssetById(assetId).getDescription());
    }
    public void rateAsset(String assetId, int rating) {
        model.getGymAssetById(assetId).setRatings(rating, model.getUser().getUsername());
        if(model.getUserAssetById(assetId) != null) {
            model.getInventoryUser().getAssetById(assetId).setRatings(rating, model.getUser().getUsername());
        }
        model.getServerModel().rateAsset(assetId, model.getUser().getUsername(), rating);
    }

    public StringProperty getAssetIDField(){return assetIDField;}

    public StringProperty getAssetNameField(){return assetNameField;}

    public StringProperty getAssetTypeField(){return assetTypeField;}

    public StringProperty getAssetDescriptionField(){return assetDescription;}
}
