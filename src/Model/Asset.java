package Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Asset {
    private String id;
    private String name;
    private String type;
    private ArrayList<Rating> ratings;
    private String description;
    private boolean returned;

    public Asset(String id, String name, String type, String description) {
        if(id != null && !id.equals("") && name != null && !name.equals("") && type != null && !type.equals("") && description != null && !description.equals("")){
            Pattern patternID  = Pattern.compile("[^0-9]");
            if(patternID.matcher(id).find()) {
                throw new IllegalArgumentException("Id for asset contains characters or symbols.");

            }
            Pattern patternName = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
            if(patternName.matcher(name).find()) {
                throw new IllegalArgumentException("Name contains symbols or numbers.");
            }
            Pattern patternType = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
            if(patternType.matcher(type).find()) {
                throw new IllegalArgumentException("Type contains symbols or numbers.");
            }
            if(description.length() > 1500) {
                throw new IllegalArgumentException("Description exceeds 1500 characters.");
            }
            this.id = id;
            this.name = name;
            this.type = type;
            this.description = description;
            ratings = new ArrayList<>();
        }
        else {
            throw new IllegalArgumentException("Existing empty fields must be filled.");
        }
    }

    public String getId() {return id;}

    public String getName() {return name;}

    public String getType() {return type;}

    public String getDescription(){return description;}

    public double getRatings() {
        int grade = 0;
        int votes = 0;
        if(ratings == null || ratings.isEmpty()) {
            return 0.0;
        }
        else {
            for (int i = 0; i < ratings.size(); i++)
            {
                if(ratings.get(i) != null) {
                    grade += ratings.get(i).getRatings();
                    votes++;
                }
            }
            return(double) grade/votes;
        }
    }
    public void setRatings(int ratings1, String username) {
        boolean IsRatedBy = false;
        if(ratings1 >=0 && ratings1 <= 10){
            if(ratings != null) {
                for(int i = 0; i<ratings.size(); i++) {
                    if(ratings.get(i).getUsername().equals(username)) {
                        IsRatedBy = true;
                        ratings.get(i).setRatings(ratings1);
                    }
                }
                if(!IsRatedBy) {
                    ratings.add(new Rating(username, ratings1, id));
                }
            }
        }
        else {
            throw new IllegalArgumentException("Rating is out of bounds.");
        }
    }
    @Override public boolean equals(Object obj) {
        if(!(obj instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) obj;
        return id.equals(other.id) && name.equals(other.name) && type.equals(other.type) && description.equals(other.description);
    }

    public void setId(String id) {
        if(id!=null && !id.equals("")) {
            Pattern patternId =Pattern.compile("[^0-9]");
            if(patternId.matcher(id).find()) {
                throw new IllegalArgumentException("Asset id contains characters or symbols.");
            }
            this.id = id;
        } else {
            throw new IllegalArgumentException("Empty field.");
        }
    }

    public void setName(String name) {
        if(name!=null && !name.equals("")){
            Pattern patternName = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
            if(patternName.matcher(name).find()) {
                throw new IllegalArgumentException("Name contains numbers or symbols");
            }
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Empty field.");
        }
    }
    public void setType(String type) {
        if(type!=null && !type.equals("")){
            Pattern patternType = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
            if(patternType.matcher(type).find()) {
                throw new IllegalArgumentException("Name contains numbers or symbols");
            }
            this.type = type;
        }
        else{
            throw new IllegalArgumentException("Empty field.");
        }
    }
    public void setDescription(String description) {
        if(description != null && !description.equals("")){
            if(description.length() <= 1500) {
                this.description = description;
            }
            else{
                throw new IllegalArgumentException("Description exceeds 1500 characters");
            }
        }
        else {
            throw new IllegalArgumentException("Empty field");
        }
    }

    @Override public String toString() {
        return "Id: " +id + "Name: " + name + "Type: " + type;
    }

    public boolean getIsReturned() {
        return returned;
    }
}
