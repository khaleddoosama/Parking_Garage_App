import java.util.Date;

public class time {
    protected int[] entry_time, time_leaving;

    public time(int n) {
        entry_time = new int[n];
        time_leaving = new int[n];
    }

    public int set_entry_time(int i) {
        entry_time[i - 1] = (int) (new Date().getTime() / 1000 / 60);
        return entry_time[i-1];
    }

    public int set_time_leaving(int i) {
        time_leaving[i] = (int) (new Date().getTime() / 1000 / 60);
        return time_leaving[i];
    }
    
    public int difference(int i) {
        //calculate the difference between the entry time and the time leaving.
        int difference = time_leaving[i] - entry_time[i];
        return difference;
    }
}
