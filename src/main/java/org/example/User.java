package org.example;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private final UUID uuid;
    private final ArrayList<Link> links;

    private ArrayList<String> notifications;

    public User() {
        this.uuid = UUID.randomUUID();
        this.links = new ArrayList<>();
    }

    public UUID getUUID() {
        return uuid;
    }

    public ArrayList<Link> getLinks() {
        return this.links;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public String createLink(String fullLink) {
        Link link = new Link(fullLink, 1, 10);
        this.links.add(link);
        return link.getSHORT_LINK();
    }

    public boolean linkTransition(Link link) {
        if (link.isLinkValid()) {
            removeLink(link);
            return link.linkTransition();
        }
        System.out.println("Invalid link");
        return false;
    }

    public boolean removeLink(Link link) {
        for (Link elem : links) {
            if (link.equals(elem)) {
                links.remove(elem);
                notifications.add("The link " + elem.getSHORT_LINK() +
                        " to " + elem.getFULL_LINK() + " was removed.");
                return true;
            }
        }
        return false;
    }


}
