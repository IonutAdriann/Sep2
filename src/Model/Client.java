package Model;

public class Client extends UserType{
    private boolean isAdmin;

    public Client(String username, String password, String email) {
        super(username, password, email);
        this.isAdmin = false;
    }

    @Override public boolean isAdmin() {return isAdmin;}
}
