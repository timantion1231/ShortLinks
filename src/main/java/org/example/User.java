package org.example;

import java.time.format.DateTimeFormatter;
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

    public String linkTransition(Link link) {
        if (!link.isLinkValid()) {
            removeLink(link);
            return "Invalid link";
        } else {
            link.linkTransition();
            notifications.add("clicks left to link: " + link.getSHORT_LINK() + " : " + link.getClicksLeft() + "\n");
            if (!link.isLinkValid()) removeLink(link);
            return "followed";
        }
    }

    public void removeLink(Link link) {
        for (Link elem : links) {
            if (link.equals(elem)) {
                links.remove(elem);
                notifications.add("The link " + elem.getSHORT_LINK() +
                        " to " + elem.getFULL_LINK() + " was removed.");
                break;
            }
        }
    }

    public void clearInvalidLinks() {
        for (Link link : getLinks()) {
            if (!link.isLinkValid())
                removeLink(link);
        }
    }

    public void changeKillDate(Link link, int days) {
        for (Link elem : links) {
            if (link.equals(elem)) {
                elem.changeLiveDays(days);
                notifications.add("The link " + elem.getSHORT_LINK() +
                        " will be removed in " +
                        elem.getKILL_DATE().format(DateTimeFormatter.ofPattern("dd-MM+yyyy HH:mm")));
                break;
            }
        }
    }

    public void changeClicksCount(Link link, int count) {
        for (Link elem : links) {
            if (link.equals(elem)) {
                elem.changeClicksCount(count);
                notifications.add("for link " + elem.getSHORT_LINK() + " " + elem.getClicksLeft() +
                        " clicks left");
                break;
            }
        }
    }

}
