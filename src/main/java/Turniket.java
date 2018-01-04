import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Turniket {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String current_data = dateFormat.format(date);
    private int approved = 0;
    private int declined = 0;
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
    public boolean process(SkiPass skiPass){
        if (skiPass.type == "weekendtimes" || skiPass.type == "workdtimes"){
            if(skiPass.times > 0){
                skiPass.times -= 1;
                System.out.println("Have fun!");
                approved += 1;
                return true;
            }else{
                System.out.println("Declined");
                declined += 1;
                return false;
            }
        }
        else if(skiPass.type == "weekenddays" || skiPass.type == "weekendseason" || skiPass.type == "workddays"){
            if(skiPass.deadline > get_secret_current_date()){
                System.out.println("Have fun!");
                approved += 1;
                return true;
            }else{
                System.out.println("Declined");
                declined += 1;
                return false;
            }
        }
        return false;
    }
}
