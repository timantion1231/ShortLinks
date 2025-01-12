package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        int key = 0;
        String mainMenu = "register: 1\nlog in: 2\nlog out: 3\ncreate short link: 4\n" +
                "follow to short link: 5\nshow all links: 6\nedit your links: 7\nexit: -1";
        String editMenu = "remove: 1\nchange count of clicks: 2\nchange live days: 3\nback: 0";
        LinkShorter ls = new LinkShorter();
        Scanner in = new Scanner(System.in);
        ls.clearInvalidLinks();

        while (key != -1) {
            System.out.println("choose an option:");
            System.out.println(mainMenu);
            try {
                key = in.nextInt();
            } catch (Exception ex) {
                key = 0;
            }
            in.nextLine();

            switch (key) {
                case 1 -> {
                    System.out.println(ls.createAccount());
                    System.out.println(ls.showNotifications());
                }
                case 2 -> {
                    System.out.println("enter your UUID:");
                    String uuid = in.nextLine();
                    ls.logIn(UUID.fromString(uuid));
                    System.out.println(ls.showNotifications());
                }
                case 3 -> {
                    boolean loggedOut = ls.logOut();
                    if (loggedOut) System.out.println("logged out");
                    else System.out.println("err");
                    System.out.println(ls.showNotifications());
                }
                case 4 -> {
                    System.out.println("Paste your full URL:");
                    String fullUrl = in.nextLine();
                    System.out.println(ls.createShortLink(fullUrl));
                    System.out.println(ls.showNotifications());
                }
                case 5 -> {
                    System.out.println("Paste your short link:");
                    String shortUrl = in.nextLine();
                    System.out.println(ls.linkTransition(shortUrl));
                    System.out.println(ls.showNotifications());
                }
                case 6 -> {
                    System.out.println(ls.getAllLinks());
                }
                case 7 -> {
                    int editkey = 0;
                    System.out.println(ls.getAllLinks());
                    System.out.println("choose an option:\n" + editMenu);
                    editkey = in.nextInt();
                    in.nextLine();
                    switch (editkey) {
                        case 1 -> {
                            System.out.println("paste your link to remove");
                            String shortUrl = in.nextLine();
                            System.out.println(ls.removeLink(shortUrl));
                        }
                        case 3 -> {
                            System.out.println("paste your link to change live days");
                            String shortUrl = in.nextLine();
                            System.out.println("enter new live days");
                            int days = in.nextInt();
                            System.out.println(ls.changeLiveDays(shortUrl, days));
                        }
                        case 2 -> {
                            System.out.println("paste your link to change clicks count");
                            String shortUrl = in.nextLine();
                            System.out.println("enter new click count");
                            int clicks = in.nextInt();
                            System.out.println(ls.changeClicksCount(shortUrl, clicks));
                        }
                    }
                }
                default -> {
                    if (key != -1) {
                        System.out.println("Wrong key " + key);
                    } else {
                        System.out.println("Quit");
                    }
                }
            }
        }
    }
}
/*
TODO:

 */
