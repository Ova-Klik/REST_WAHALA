package GeoPolitics;

import java.util.Scanner;

public class GeoPoliticalMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your state: ");
        String userState = scanner.nextLine();

        GeoPoliticalZones zonefinder = Zone.findZone(userState);

        if (zonefinder != null) {
            System.out.println(userState + " belongs to the " + zonefinder + " zone.");
        } else {
            System.out.println("Sorry, '" + userState + "' was not found. Check spelling and try again.");
        }
    }
}