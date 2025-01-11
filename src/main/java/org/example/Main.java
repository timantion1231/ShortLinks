package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        int key = 0;
        String menu = "register: 1\nlog in: 2\nlog out: 3\ncreate short link: 4\n" +
                "follow to short link: 5\nshow all links: 6";
        LinkShorter ls = new LinkShorter();
        Scanner in = new Scanner(System.in);
        ls.clearInvalidLinks();

        while (key != -1) {
            System.out.println("choose an option:");
            System.out.println(menu);
            try {
                key = in.nextInt();
            }
            catch (Exception ex){
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
                case 6 ->{
                    System.out.println(ls.getAllLinks());
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
 исправить удаление неактивных коротких ссылок
 исправить уведомления (при каждом уведомлении пишет your notifications, исправить добавление удаленных ссылок)
 можно добавить при переходе в пользователе в конце еще один иф чтобы удалить ссылку если она более не активна
*/
