package View;

public class ViewState {
    private String selectedAsset;

    public ViewState() {
        selectedAsset = "";
    }

    public void setSelectedAsset(String id) {
        selectedAsset = id;
    }


    public String getSelectedAsset() {
        return selectedAsset;
    }
}
