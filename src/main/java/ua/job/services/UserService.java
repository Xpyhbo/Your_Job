package ua.job.services;

import ua.job.model.User;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by MacBookPro on 12/16/16.
 */

public class UserService {
    private static final UserService instance = new UserService();
    private CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();
    private int index;

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
    }


    public CopyOnWriteArrayList<User> getAll() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
        user.setId(index);
    }

    public void editUser(String oldSurname) {
        for (User user : getInstance().getAll()) {
            if (oldSurname.toLowerCase().equals(user.getSurName().toLowerCase())) {

            }
        }
    }

    public void deleteUser(String surName) {
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()){
            User element = (User) iter.next();
            if (element.getSurName().equalsIgnoreCase(surName))
                iter.remove();

        }
        }


    }

