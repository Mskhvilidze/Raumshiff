package game;

import java.awt.*;
import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {
        Point spielerPosition = new Point(10, 9);
        Point schlangePosition = new Point(30, 2);
        Point goldPosition = new Point(6, 6);
        Point tuerPosition = new Point(2, 5);
        int goldsammeln = 0;

        boolean weiter = true;
        //10x40
        while (weiter) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(spielerPosition)) {
                        System.out.print("P");
                    } else if (p.equals(schlangePosition)) {
                        System.out.print("S");
                    } else if (p.equals(goldPosition)) {
                        System.out.print("G");
                    } else if (p.equals(tuerPosition)) {
                        System.out.print("T");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            if (schlangePosition.equals(spielerPosition)) {
                weiter = false;
                System.out.print("Zzz... Schlange hat dich gefressen!");
            }

            if (spielerPosition.equals(goldPosition)) {
                goldsammeln++;
                goldPosition = new Point((int) (Math.random() * (39 - 1)) + 1, (int) (Math.random() * (9 - 1)) + 1);
            }

            if (spielerPosition.equals(tuerPosition) && goldsammeln > 0) {
                weiter = false;
                if (goldsammeln > 4) {
                    System.out.print("Uuu... Neues Rekord... Du hast gewonnen!");
                } else {
                    System.out.print("Spieler hat gewonnen!");
                }
            }
            bewegeSpieler(spielerPosition);
            bewegeSchlange(schlangePosition, spielerPosition);
        }
    }

    private static void bewegeSpieler(Point spielerPosition) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equals("w")) {
            if (spielerPosition.y > 0) {
                spielerPosition.y--;
            }
        } else if (input.equals("s")) {
            if (spielerPosition.y < 9) {
                spielerPosition.y++;
            }
        } else if (input.equals("a")) {
            if (spielerPosition.x > 0) {
                spielerPosition.x--;
            }
        } else if (input.equals("d")) {
            if (spielerPosition.x < 39) {
                spielerPosition.x++;
            }
        }
    }

    private static void bewegeSchlange(Point schlangePosition, Point spielerPosition) {
        if (spielerPosition.y < schlangePosition.y) {
            schlangePosition.y--;
        } else if (spielerPosition.y > schlangePosition.y) {
            schlangePosition.y++;
        }

        if (spielerPosition.x < schlangePosition.x) {
            schlangePosition.x--;
        } else if (spielerPosition.x > schlangePosition.x) {
            schlangePosition.x++;
        }
    }
}
