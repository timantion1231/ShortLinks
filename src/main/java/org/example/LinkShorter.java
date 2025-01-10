package org.example;

import java.util.ArrayList;
import java.util.UUID;

public class LinkShorter {
    public ArrayList<User> users;
    private User currUser;

    private boolean userLogged = false;

    public UUID createAccount() {
        users.add(new User());
        currUser = users.get(users.size() - 1);
        return currUser.getUUID();
    }

    public boolean logIn(UUID uuid) {
        for (User user : users) {
            if (user.getUUID().equals(uuid)) {
                currUser = user;
                userLogged = true;
                return true;
            }
        }
        return false;
    }

    public boolean logOut() {
        if (userLogged) {
            userLogged = false;
            currUser = null;
            return true;
        }
        return false;
    }

    public String linkTransition(String link) {
        for (User users : this.users) {
            for (Link links : users.getLinks()) {
                if (link.equals(links.getSHORT_LINK())) {
                    users.linkTransition(links);
                    return "";
                }
            }
        }
        return "Failed to follow the link";
    }

}
