import java.util.Scanner;


public class parking_Space extends Parking {

    private double[] width, depth;
    private int number_of_parking_slots;
    private boolean[] is_available;
    private Scanner input;

    public parking_Space(int n, int c) {
        super(n, c);
        input = new Scanner(System.in);
        width = new double[n];
        depth = new double[n];
        is_available = new boolean[n];
        number_of_parking_slots = n;
        for (int i = 0; i < number_of_parking_slots; i++) {
            while (true) {
                try {
                    System.out.println("Enter the width of the parking space " + (i + 1) + ": ");
                    width[i] = input.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("The number you entered is incorrect,try again");
                    input.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.println("Enter the depth of the parking space " + (i + 1) + ": ");
                    depth[i] = input.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("The number you entered is incorrect,try again");
                    input.nextLine();
                }
            }
        }

    }

    public int first_free_slot(double w, double d) {
        for (int i = 0; i < number_of_parking_slots; i++) {
            if (is_available[i] == false) {

                if (w <= width[i] && d <= depth[i]) {
                    System.out.println("The first free slot is " + (i + 1));
                    is_available[i] = true;
                    return i;
                }
            }

        }
        return -1;
    }

    public int best_fit_approach(double w, double d) {
        int index = -1;
        double[] area = new double[number_of_parking_slots];
        for (int i = 0; i < number_of_parking_slots; i++) {
            area[i] = Double.MAX_VALUE;
            if (is_available[i] == false) {
                if (w <= width[i] && d <= depth[i]) {
                    area[i] = (width[i] - w) + (depth[i] - d);
                    index = i;
                }
            }
        }
        if (index == -1) {
            return -1;

        } else {
            double a = area[0];
            for (int i = 0; i < number_of_parking_slots; i++) {
                if (a > area[i]) {
                    a = area[i];
                    index = i;
                }
            }
            System.out.println("the best fit slot is: " + (index + 1));
            is_available[index] = true;
            return index;
        }

    }

    public void available_parking_slots() {
        boolean is_valid = false;
        System.out.println("the available parking slots are: ");
        for (int i = 0; i < number_of_parking_slots; i++) {
            if (is_available[i] == false) {
                System.out.println((i + 1));
                is_valid = true;
            }
        }
        if (is_valid == false) {
            System.out.println("For the moment there are no available parking slots...");
        }
    }

    public void returns_available_parking_slots(int n) {
        is_available[n] = false;
    }


};

