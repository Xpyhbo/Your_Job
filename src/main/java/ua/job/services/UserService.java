package ua.job.services;

import ua.job.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by MacBookPro on 12/16/16.
 */

public class UserService {
    private static final UserService instance = new UserService();
    private ArrayList<User> users = new ArrayList<User>();

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
    }


    public ArrayList<User> getAll() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void editUser(String id, String param) {
        for (User user : users){
            if (id.equals(user.getId())){
                user.setName(param);
            }
        }
    }

    public void deleteUser(String id) {
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()){
            User element = iter.next();
            if (element.getId().equalsIgnoreCase(id))
                iter.remove();
        }
        }


    }

