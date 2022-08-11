import java.util.Scanner;

public  class carInformation  {


    protected  int[] uq_identifier_number, model_year;
    protected  int total_number_of_vehicles, configuration;
    protected  double[] v_width, v_depth;
    protected  String[] model_name;
    protected  boolean[] is_parked;
    protected  Scanner input;

    public carInformation(int n, int c) {
        input = new Scanner(System.in);
        uq_identifier_number = new int[n];
        model_year = new int[n];
        v_width = new double[n];
        v_depth = new double[n];
        model_name = new String[n];
        is_parked = new boolean[n];
        total_number_of_vehicles = 0;
        configuration = c;
    }
    


    public int get_uq_identifier_number() {
        while (true) {
            try {
                System.out.println("Enter the vehicle's unique identifier number: ");
                uq_identifier_number[total_number_of_vehicles] = input.nextInt();
                for (int i = 0; i < total_number_of_vehicles; i++) {
                    if (uq_identifier_number[total_number_of_vehicles] == uq_identifier_number[i]) {
                        throw new IllegalArgumentException();
                    }
                }
                total_number_of_vehicles++;
                is_parked[total_number_of_vehicles - 1] = true;
                return uq_identifier_number[total_number_of_vehicles - 1];
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "The identifier number is already in use. Please enter a new identifier number.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }
        }
    }
    
    public int check_identifier_number()
    {
        int id;
        while (true) {
            try {
                System.out.println("Enter the vehicle's identifier number: ");
                id = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("The number you entered is incorrect,try again");
                input.nextLine();
            }
        }
        for (int i = 0; i < total_number_of_vehicles; i++) {
            if (id == uq_identifier_number[i] && is_parked[i] == true) {
                is_parked[i] = false;
                total_number_of_vehicles--;
                return i;
            }
        }
        return -1;
    }

    public String get_model_name() {
        System.out.println("Enter the vehicle's model name: ");
        model_name[total_number_of_vehicles-1] = input.next();
        return model_name[total_number_of_vehicles-1];
    }
        
    

    public int get_model_year() {
        while (true) {
            try {
                System.out.println("Enter the vehicle's model year: ");
                model_year[total_number_of_vehicles-1] = input.nextInt();
                return model_year[total_number_of_vehicles-1];
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }
        }
    }

    public double get_vehicle_width() {
        while (true) {
            try {
                System.out.println("Enter the vehicle's width: ");
                v_width[total_number_of_vehicles-1] = input.nextDouble();
                return v_width[total_number_of_vehicles-1];
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }
        }
    }

    public double get_vehicle_depth()
    {
        while (true) {
            try {
                System.out.println("Enter the vehicle's depth: ");
                v_depth[total_number_of_vehicles-1] = input.nextDouble();
                return v_depth[total_number_of_vehicles-1];
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }
        }
    }

    public int get_total_number_of_vehicles() {
        return total_number_of_vehicles;
    }

    public void decrement_total_number_of_vehicles() {
        total_number_of_vehicles--;
    }

};
