package Model;

public class Rating {
    private String username;
    private int rating;
    private String AssetId;

    public Rating(String username, int rating, String AssetId) {
        this.AssetId = AssetId;
        this.username = username;
        this.rating = rating;
    }

    public void setRatings(int rating1) {this.rating = rating1;}

    public int getRatings() {return rating;}

    public String getUsername() {return username;}

    public String getAssetId() {return AssetId;}

    @Override public String toString() {return username + " " + rating;}
}
