package org.example;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Random;


public class Link {
    private final String FULL_LINK;
    private final String SHORT_LINK;
    private LocalDateTime KILL_DATE;
    private int clicksLeft;

    public Link(String fullLink, int liveDays, int maxClicks) {
        FULL_LINK = fullLink;
        KILL_DATE = LocalDateTime.now().plusDays(liveDays);
        SHORT_LINK = createShortLink(7);
        clicksLeft = maxClicks;
    }

    private String createShortLink(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) sb.append(chars.charAt(rnd.nextInt(0, chars.length() - 1)));

        return "https://click.ru/" + sb;
    }

    public String getSHORT_LINK() {
        return SHORT_LINK;
    }

    public void changeLiveDays(int days) {
        this.KILL_DATE = LocalDateTime.now().plusDays(days);
    }

    public void changeClicksCount(int clicks) {
        this.clicksLeft = clicks;
    }

    public LocalDateTime getKILL_DATE() {
        return KILL_DATE;
    }

    public int getClicksLeft() {
        return clicksLeft;
    }

    public String getFULL_LINK() {
        return FULL_LINK;
    }

    public boolean linkTransition() {
        if (isLinkValid()) {
            clicksLeft--;
            try {
                Desktop.getDesktop().browse(new URI(FULL_LINK));
            } catch (IOException | URISyntaxException e) {
                System.out.println(e.getMessage());
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean isLinkValid() {
        return (KILL_DATE.isAfter(LocalDateTime.now()) && clicksLeft > 0);
    }

    public boolean equals(Link link) {
        return link.SHORT_LINK.equals(SHORT_LINK);
    }

}
