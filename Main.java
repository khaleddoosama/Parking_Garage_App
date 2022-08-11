
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        try (var input = new Scanner(System.in)) {
            int number_of_parking_slots, configuration;

            while (true) {
                try {
                    System.out.println("Enter the number of parking slots: ");
                    number_of_parking_slots = input.nextInt();

                    System.out.println("choose the configuration: ");
                    System.out.println("1. first come first served");
                    System.out.println("2. best-fit approach");
                    configuration = input.nextInt();
                    if (configuration == 1 || configuration == 2) {
                        break;
                    } else {
                        System.out.println("Invalid configuration");
                    }
                } catch (Exception e) {
                    System.out.println("The number you entered is incorrect,try again");
                    input.nextLine();
                }
            }

            var y = new parking_Space(number_of_parking_slots, configuration);
            System.out.println("\n------Welcome to the vehicle park------\n"); // welcome message);

            System.out.println("Choose the option: ");
            System.out.println("1. parking a vehicle");
            System.out.println("2. unpark a vehicle");
            System.out.println("3. Display total income and number of vehicles");
            System.out.println("4. Display the available parking slots");
            System.out.println("5. Exit");

            String choice = input.next();

            while (true) {
                switch (choice) {
                    case "1":
                        y.park_In();
                        break;
                    case "2":
                        y.park_Out();
                        break;
                    case "3":
                        System.out.println("Total income = " + y.get_total_income());
                        System.out.println("Total number of vehicles = " + y.calculate_total_number_of_vehicles());
                        break;
                    case "4":
                        y.available_parking_slots();
                        break;
                    case "5":
                        System.out.println("Thank you for using the parking system");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                System.out.println("Choose the other option: ");
                choice = input.next();
            }
        }
    }

}