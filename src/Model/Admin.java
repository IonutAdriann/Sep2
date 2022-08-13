package Model;

public class Admin extends UserType{
    private boolean isAdmin;

    public Admin(String username, String password, String email) {
        super(username, password, email);
        isAdmin = true;
    }

    @Override public boolean isAdmin() {
        return isAdmin;
    }
}
