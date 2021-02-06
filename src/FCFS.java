import java.util.HashMap;
import java.util.List;

public class FCFS {

    public static double handleFCFS(HashMap<Integer,Jobs> myMap){
        double ATT = 0;
        int prev = 0;
        for(int i = 0; i < myMap.size(); i++){
            prev += myMap.get(i).getJobTime();
            ATT += prev;
//            if(i != 0)
//                ATT += prev + myMap.get(i).getJobTime();
//            else
//                ATT += myMap.get(i).getJobTime();
//
//            prev += myMap.get(i).getJobTime();
        }
        return ATT / myMap.size();
    }

    public static double handleFCFS(List<Jobs> myMap){
        double ATT = 0;
        int prev = 0;
        for(int i = 0; i < myMap.size(); i++){
            prev += myMap.get(i).getJobTime();
            ATT += prev;
//            if(i != 0)
//                ATT += prev + myMap.get(i).getJobTime();
//            else
//                ATT += myMap.get(i).getJobTime();
//
//            prev += myMap.get(i).getJobTime();
        }
        return ATT / myMap.size();
    }
}
