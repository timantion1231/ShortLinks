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
        this.notifications = new ArrayList<>();
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
        Link link = new Link(fullLink, 1, 1);
        this.links.add(link);
        return link.getSHORT_LINK();
    }

    public void linkTransition(Link link) {
        if (!link.isLinkValid()) {
            removeLink(link);
            System.out.println("Invalid link");
            return;
        }
        link.linkTransition();
        notifications.add("clicks left to link: " + link.getSHORT_LINK() + " : " + link.getClicksLeft());
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

    public void clearInvalidLinks() {
        for (Link link : getLinks()) {
            if (!link.isLinkValid())
                removeLink(link);
        }
    }


}
