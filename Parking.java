import java.util.Scanner;
import java.util.Calendar;



public class Parking implements slots {
    
    protected int[]  best, first;
    protected int  configuration;
    protected boolean[] is_parked;
    protected Scanner input;
    carInformation car;
    time time;
    parking_fees parking_fees;

    public Parking(int n, int c) {
        input = new Scanner(System.in);
        is_parked = new boolean[n];
        best = new int[n];
        first = new int[n];
        configuration = c;
        car = new carInformation(n, c);
        time = new time(n);
        parking_fees = new parking_fees(n);
    }

    public void park_In() {
        if (car.get_total_number_of_vehicles() < best.length) 
        {
            int id= car.get_uq_identifier_number();
            String name = car.get_model_name();
            int year = car.get_model_year();
            double width = car.get_vehicle_width();
            double depth = car.get_vehicle_depth();

            if (configuration == 1) {
                first[car.get_total_number_of_vehicles()-1] = first_free_slot(width, depth);
            } else if (configuration == 2) {
                best[car.get_total_number_of_vehicles()-1] = best_fit_approach(width, depth);
            }

            if (best[car.get_total_number_of_vehicles()-1] == -1 || first[car.get_total_number_of_vehicles()-1] == -1) {
                System.out.println("Sorry,for the moment,there is no space for your vehicle.");
                car.decrement_total_number_of_vehicles();
            } else
            {
                time.set_entry_time(car.get_total_number_of_vehicles());
                System.out.println(id + "- " + name + ' ' + year + " is parked in the garage at "
                        + (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":"
                                + Calendar.getInstance().get(Calendar.MINUTE)));                       
            }

        } else {
            System.out.println("The parking garage is full.");
        }

    }

public int best_fit_approach(double w, double d) {
        return 0;
    }

    public int first_free_slot(double w, double d) {
        return 0;
    }

public void park_Out() {
        if (car.get_total_number_of_vehicles() > 0) {
                int index = car.check_identifier_number();

            if (index!=-1)
            {
                time.set_time_leaving(index);
                System.out.println(index+"- a car is leaving the garage at "
                        + (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":"
                                + Calendar.getInstance().get(Calendar.MINUTE)));


                int diff= time.difference(index);
                int fees = parking_fees.get_parking_fees(index);

                System.out.println(index+"- a parking fees = "
                        + fees + " EGP (stay time = " + diff + " minutes)");
                if (configuration == 1) {
                    returns_available_parking_slots(first[index]);
                } else if (configuration == 2) {
                    returns_available_parking_slots(best[index]);
                }

            } else {
                System.out.println("The vehicle is not parked in the garage.");
            }

        } else {
            System.out.println("The parking garage is empty.");
        }
    }

    public void returns_available_parking_slots(int n) {

    }

    

    public int calculate_total_number_of_vehicles() {
        return car.get_total_number_of_vehicles();
    }

    public int get_total_income() {
        return parking_fees.get_total_income();
    }

};