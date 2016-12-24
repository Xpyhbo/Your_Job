package ua.job.model;

/**
 * Created by MacBookPro on 12/16/16.
 */
public class User {
    private String id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }




    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }


}
