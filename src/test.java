import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class test {
    private static final int NUMJOBS = 29;
    public static void main(String[] args){
        //System.out.printf("Hello World!");

        //initTest1();
        HashMap jobMap = initTest3();
        System.out.printf("FCFS: %.3f\r\n",FCFS.handleFCFS(jobMap));

        SJF.processSJF(jobMap);

    }

    private static void initTest1(){
        HashMap<String, Integer> myMap = new HashMap();
        int[] jobTimes = {7,18,10,4,12};

        for(int i = 0; i < jobTimes.length; i++){
            myMap.put(String.format("Job%d",i+1),jobTimes[i]);
        }

        for(int i = 0; i < myMap.size(); i++){
            System.out.printf("%s,%d\r\n",String.format("Job%d",i+1),myMap.get(String.format("Job%d",i+1)));
        }
    }

    private static HashMap initTest2(){
        HashMap<Integer, Jobs> myMap = new HashMap();
        int[] jobTimes = {5,2,7,4,3,8};

        for(int i = 0; i < jobTimes.length; i++) {
            myMap.put(i, new Jobs(String.format("Job%d", i + 1), jobTimes[i], false));
        }
        return myMap;
    }

    private static HashMap initTest3(){
        HashMap<Integer, Jobs> myMap = new HashMap();
        Random rd = new Random();
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < NUMJOBS; i++){
            arrList.add(rd.nextInt(20) + 1);
        }

        String zeros = "";
        for(int i = 0; i < arrList.size(); i++){
            zeros += "0 ";
        }

        String serviceTime = "";
        for(int i = 0; i < arrList.size(); i++){
            serviceTime += arrList.get(i) + " ";
        }
        System.out.printf("%s\r\n%s\r\n",zeros,serviceTime);


        for(int i = 0; i < arrList.size(); i++) {
            myMap.put(i, new Jobs(String.format("Job%d", i + 1), arrList.get(i), false));
        }
        return myMap;
    }

    private static void printHashMap(HashMap x){
        for(int i = 0; i < x.size(); i++){
            System.out.printf("%d: %s, %d ms, %b\r\n", i, ((Jobs) x.get(i)).getJobNum(), ((Jobs) x.get(i)).getJobTime(), ((Jobs) x.get(i)).isComplete());
        }
    }
}
