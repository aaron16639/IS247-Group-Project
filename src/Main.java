import HumanResources.HRSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the ERP system. Please select a choice:");
        printOptions();
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("You have chosen choice 1");
        } else if (choice == 2) {
            System.out.println("You have chosen choice 2");
        } else if (choice == 3) {
            HRSystem.start();
        } else if (choice == 4) {
            System.out.println("You have chosen choice 4");
        }

        input.close();

    }


    public static void printOptions() {
        System.out.println("1. CRM");
        System.out.println("2. Finance");
        System.out.println("3. Human Resources");
        System.out.println("4. Supply Chain");
    }
}
