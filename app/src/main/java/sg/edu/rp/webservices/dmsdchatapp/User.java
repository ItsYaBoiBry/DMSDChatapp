package sg.edu.rp.webservices.dmsdchatapp;

/**
 * Created by 15017569 on 8/15/2017.
 */

public class User {
    String id;
    String username;

    public User(String uid, String display_name) {
        this.id = uid;
        this.username = display_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}