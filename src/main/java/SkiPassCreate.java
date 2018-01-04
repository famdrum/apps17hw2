import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SkiPassCreate{
    private int[] times = {10,20,50,100};
    private int[] days = {1,2,5};
    private int[] weekends = {1,2};
    private int super_indexer = -1;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String current_data = dateFormat.format(date);
    private Scanner reader = new Scanner(System.in);

    public int get_secret_current_date(){
        int c = 0;
        String var = "";
        for (int i = 0; i < current_data.length(); i++){
            if(current_data.charAt(i) != '-'){
                var += current_data.charAt(i);
            }
            else {
                c += Integer.parseInt(var);
                var = "";
            }
        }
        c += Integer.parseInt(var);
        return c;
    }

    public SkiPass create_skipass() {
        System.out.println("Hello, and welcome to our shop! Our shop offers you two options for ski pass cards. Type '0' for w.d. and '1' for weekends");
        System.out.println("Enter a number: ");
        SkiPass var = null;
        int plan = reader.nextInt();
        if (plan == 0){
            var = working_day_plan();
        }
        if(plan == 1){
            var = weekend_plan();
        }
        return var;
    }

    private SkiPass weekend_plan() {
        System.out.println("You've chosen weekend plan. Do you wanna buy a certain amount of lifts,an unlim or a plan for a season? Type '0','1' or '2'");
        int plan_s = reader.nextInt();
        if (plan_s == 0){
            System.out.println("What quantity do you want? 10,20,50,100? Type '0','1','2' or '3'");
            int quant = reader.nextInt();
            super_indexer += 1;
            return new SkiPass(super_indexer,times[quant], -1, "weekendtimes");
        }
        if (plan_s == 1){
            System.out.println("How many days do you wanna cover? 1 or 2? Type '0' or '1'");
            int day = reader.nextInt();
            super_indexer += 1;
            return new SkiPass(super_indexer,-1, get_secret_current_date() + weekends[day], "weekenddays");
        }
        if(plan_s == 2){
            super_indexer += 1;
            return new SkiPass(super_indexer,-1, get_secret_current_date() + 14, "weekendseason");
        }
        return null;
    }

    private SkiPass working_day_plan() {
        System.out.println("You've chosen working day plan. Do you wanna buy a certain amount of lifts or an unlim? Type '0' or '1'");
        int plan_s = reader.nextInt();
        if (plan_s == 0){
            System.out.println("What quantity do you want? 10,20,50,100? Type '0','1','2' or '3'");
            int quant = reader.nextInt();
            super_indexer += 1;
            return new SkiPass(super_indexer,times[quant], -1, "workdtimes");
        }
        if (plan_s == 1){
            System.out.println("How many days do you wanna cover? 1,2 or 5? Type '0','1' or '2'");
            int day = reader.nextInt();
            super_indexer += 1;
            return new SkiPass(super_indexer,-1, get_secret_current_date() + days[day], "workddays");
        }
        return null;
    }

}
