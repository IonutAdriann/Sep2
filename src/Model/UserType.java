package Model;

import java.util.regex.Pattern;

public abstract class  UserType {
    private String username;
    private String password;
    private String email;
    private InventoryUser inventoryUser;

    public UserType(String username, String password, String email) {
        if(username != null && password != null && email != null && !username.equals("") && !password.equals("") && !email.equals("")) {
            if (username.length() < 6) {
                throw new IllegalArgumentException("Username is too short");
            }
            Pattern patternUsername = Pattern.compile("^(?=.*[-+_!@#$%^^&*,.?])");
            if(patternUsername.matcher(username).find()) {
                throw new IllegalArgumentException("Username has special characters");
            }
            if(password.length()<10) {
                throw new IllegalArgumentException("Password is too short");
            }
            Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=." + "*[A-Z])(?=.*\\d)" + "(?=.*[+-_!@#$%^&*,. ?]).+$");
            if(!patternPassword.matcher(password).find()) {
                throw new IllegalArgumentException("Password needs 1 Uppercase, 1 lowercase, 1 number and 1 symbol");
            }
            this.username = username;
            this.password = password;
            this.email = email;
            this.inventoryUser = new InventoryUser();
        }
        else {
            throw new IllegalArgumentException("There are empty fields");
        }
    }

    public String getUsername(){return username;}

    public String getPassword(){return password;}

    public String getEmail(){return email;}

    public abstract boolean isAdmin();

    public InventoryUser getInventoryUser(){return inventoryUser;}
}