package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class LinkShorter {
    public ArrayList<User> users;
    private User currUser;

    private boolean userLogged = false;

    public LinkShorter() {
        users = new ArrayList<>();
    }

    public UUID createAccount() {
        User newUser = new User();
        users.add(newUser);
        currUser = newUser;
        userLogged = true;
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
                    if (!userLogged) {
                        return "your UUID: " + createAccount().toString();
                    } else return "followed";
                }
            }
        }
        return "Failed to follow the link";
    }

    public String createShortLink(String fullLink) {
        if (userLogged) {
            return "your short link: " + currUser.createLink(fullLink);
        } else {
            UUID user = createAccount();
            return "your uuid: " + user.toString() + "\nyour short link: " + currUser.createLink(fullLink);
        }
    }

    public String showNotifications() {
        if (userLogged) {
            StringBuilder sb = new StringBuilder();
            for (String s : currUser.getNotifications()) {
                sb.append("your notifications: \n");
                sb.append(s);
            }
            if (currUser.getNotifications().isEmpty())
                return "no notifications";
            return sb.toString();
        } else return "log in for see notifications";
    }

    public String getAllLinks() {
        if (userLogged) {
            StringBuilder sb = new StringBuilder();
            if (currUser.getLinks().isEmpty()) sb.append("you have no links\n");
            else sb.append("your links:\n");
            for (Link url : currUser.getLinks()) {
                sb.append(url.getSHORT_LINK());
            }
            return sb.toString();
        }
        return "log in for see all links";
    }

    public void clearInvalidLinks(){
        for(User user: users){
            user.clearInvalidLinks();
        }
    }
}
