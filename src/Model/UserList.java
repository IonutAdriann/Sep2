package Model;

import java.util.ArrayList;

public class UserList {
    private ArrayList<UserType> users;


    public UserList(){
        this.users = new ArrayList<>();
    }


    public void addUser(UserType user){
        users.add(user);
    }



    public UserType getUser(int index){
        return users.get(index);
    }


    public int getSize(){
        return users.size();
    }


    public ArrayList<UserType> getUsers(){return users;}



    public void removeUser(String id){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername().equals(id)){
                users.remove(users.get(i));
            }
        }
    }
}
