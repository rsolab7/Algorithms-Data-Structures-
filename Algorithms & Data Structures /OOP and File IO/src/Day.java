/**
 * Created by Roberto on 10/12/16.
 */
public class Day {
    private int day;
    private int year;
    private int month;

    public Day (int day, int month, int year){
        this.day = day;
        this.year = year;
        this.month = month;

    }

    public void printDay() {
        System.out.println(month + "/" + day + "/"+ year);
    }
}
