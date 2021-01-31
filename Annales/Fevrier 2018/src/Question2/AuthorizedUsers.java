package Question2;

import java.util.*;


final public class AuthorizedUsers {

    private static AuthorizedUsers instance;

    private AuthorizedUsers(){}

    public static AuthorizedUsers getInstance(){
        if (instance == null){
            instance = new AuthorizedUsers();
        }
        return instance;
    }

    public List<String> users(){
        return Collections.unmodifiableList(usersList);
    }
    private static List<String> usersList;

    static{
        usersList = new ArrayList<String>(); // e1, e2, e3, e4
        usersList.add("e1");
        usersList.add("e2");
        usersList.add("e3");
        usersList.add("e4");
    }
}
