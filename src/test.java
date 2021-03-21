import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class test {
    private static final int NUMJOBS = 29;
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.printf("Hello World!");
        if(args.length < 0){
            System.out.println("IO Error. No program arguments");
            System.exit(-1);
        }
        //initTest1();
        //HashMap jobMap = initTest3();
        //System.out.printf("FCFS: %.3f\r\n",FCFS.handleFCFS(jobMap));

        //SJF.processSJF(jobMap);
        //RoundRobin.handleRR(jobMap, 3);
        //HashMap<Integer, Jobs> myMap = new HashMap();
        //myMap.put(0,new Jobs("Job1",0,false));
        //myMap.put(1,new Jobs("Job2",5,false));
        //myMap.put(2,new Jobs("Job3",8,false));
       // myMap.put(3,new Jobs("Job4",11,false));
        //myMap.put(4,new Jobs("Job5",15, false));
        //RoundRobin.handleRR(myMap,3);
        //SJF.processSJF(myMap);
        //System.out.printf("FCFS: %.3f\r\n",FCFS.handleFCFS(myMap));

        HashMap<Integer, Jobs> jobList = getInput(args[0]);
        RoundRobin.handleRR(jobList,3);
    }

    public static HashMap<Integer, Jobs> getInput(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner fileScanner = new Scanner(file);
        HashMap<Integer, Jobs> jobList = new HashMap<>();
        int counter = 0;
        while(fileScanner.hasNextLine()){
            String name = fileScanner.next();
            int time = fileScanner.nextInt();
            jobList.put(counter++, new Jobs(name,time,false));
        }

        return jobList;
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
        for (Integer integer : arrList) {
            serviceTime += integer + " ";
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
