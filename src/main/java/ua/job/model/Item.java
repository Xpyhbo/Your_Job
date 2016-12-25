package ua.job.model;

/**
 * Created by vasyl on 12/24/16.
 */
public class Item {

    private User user;
    private String name;
    private String desc;

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
