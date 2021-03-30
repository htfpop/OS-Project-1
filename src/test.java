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

        HashMap<Integer,Jobs> joblist = testFCFS();

        System.out.printf("FCFS: %.3f\r\n",FCFS.handleFCFS((joblist)));

        //initTest1();
        //HashMap jobMap = initTest3();
        //System.out.printf("FCFS: %.3f\r\n",FCFS.handleFCFS(jobMap));

        //SJF.processSJF(jobMap);
        //RoundRobin.handleRR(jobMap, 3);
//        HashMap<Integer, Jobs> myMap = new HashMap();
//        myMap.put(0,new Jobs("Job1",3,false));
//        myMap.put(1,new Jobs("Job2",16,false));
//        myMap.put(2,new Jobs("Job3",2,false));
//        myMap.put(3,new Jobs("Job4",24,false));
//        myMap.put(4,new Jobs("Job5",22, false));
//        RoundRobin.handleRR(myMap,5);
        //SJF.processSJF(myMap);
        //System.out.printf("FCFS: %.3f\r\n",FCFS.handleFCFS(myMap));

        //HashMap<Integer, Jobs> jobList = getInput(args[0]);
        //RoundRobin.handleRR(jobList,5);
    }

    public static HashMap<Integer,Jobs> testFCFS(){
        HashMap<Integer, Jobs> jobList = new HashMap<>();

        jobList.put(0, new Jobs("Job1",3,false));
        jobList.put(1, new Jobs("Job2",16,false));
        jobList.put(2, new Jobs("Job3",2,false));
        jobList.put(3, new Jobs("Job4",24,false));
        jobList.put(4, new Jobs("Job5",22,false));
//        jobList.put(5, new Jobs("Job6",13,false));
//        jobList.put(6, new Jobs("Job7",2,false));
//        jobList.put(7, new Jobs("Job8",25,false));
//        jobList.put(8, new Jobs("Job9",4,false));
//        jobList.put(9, new Jobs("Job10",24,false));

        return jobList;
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
        fileScanner.close();

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
