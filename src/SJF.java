import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SJF {

    public static void processSJF(HashMap<Integer, Jobs> map){
        List<Jobs> jobTime = new ArrayList<Jobs>(map.values());
        Collections.sort(jobTime);
        System.out.printf("SJF: %.5f",FCFS.handleFCFS(jobTime));
    }
}
