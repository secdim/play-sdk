package app;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private int threshold = 1000;
    private int surcharge = 10;

    public static void main(String[] args) {

        Main app = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("[?] Enter an amount (e.g. 10, 1000): ");
        String amount = scanner.next();

        if(app.approval(amount)) {
            System.out.println("[i] The amount requires approval");
        } else {
            System.out.println("[i] The amount does not require approval");
        }

    }

    /**
     * Checks if a given ammount requires approval
     * Return true if a given amount is bigger than a given threshold
     * @return boolean
     */
    public boolean approval(String value){
       int amount = Integer.parseInt(value) + surcharge;
       if(amount >= threshold) {
           return true;
       }
       return false;
   }

}
