
public class parking_fees implements hourly_price {
    protected int[] parking_fees;
    protected int total_income,index;
    
    public parking_fees(int n) {
        parking_fees = new int[n];
        total_income = 0;
        index = 0;
    }

    public int get_parking_fees(int diff) {
        while (true) {
            try {
                parking_fees[index] = (diff / 60 * 5) + 5;
                total_income += parking_fees[index];
                index++;
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return parking_fees[(index-1)];
    }

    public int get_total_income()
    {
        return total_income;
    }

}
