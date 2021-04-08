import java.io.*;
import java.util.*;

public class test {
    private static final int NUMJOBS = 29;
    public static void main(String[] args) throws IOException {

        /*
        HashMap<Integer, Jobs> jobList = getInput("./testFiles/test10/job0.txt");
        HashMap<Integer, Jobs> jobList2 = getInput("./testFiles/test10/job0.txt");
        //System.out.printf("FCFS: %.3f\r\n",FCFS.processFCFS(jobList));
        //System.out.printf("SJF: %f\r\n",SJF.processSJF(jobList));
        RoundRobin2.processRoundRobin2(jobList);
        RoundRobin5.processRoundRobin5(jobList2);
         */

        //HashMap<Integer, Jobs> fcfs = getInput("./testFiles/test15/job3.txt");
        //HashMap<Integer, Jobs> sjf = getInput("./testFiles/test15/job3.txt");
        //HashMap<Integer, Jobs> rr2 = getInput("./testFiles/test15/job3.txt");
        //HashMap<Integer, Jobs> rr5 = getInput("./testFiles/test15/job3.txt");

        //System.out.printf("FCFS ATT: %.3f\r\n",FCFS.processFCFS(fcfs));
        //System.out.printf("SJF ATT: %.3f\r\n",SJF.processSJF(sjf));
        //RoundRobin2.processRoundRobin2(rr2);
        //RoundRobin5.processRoundRobin5(rr5);

        averageAverageTrials();

        //initFiles();
    }

    public static void averageAverageTrials() throws FileNotFoundException {
        double fcfsTimes = 0;
        double sjfTimes = 0;
        double rr2Times = 0;
        double rr5Times = 0;

        List<Double>fcfsList = new ArrayList<>();
        List<Double>sjfList = new ArrayList<>();
        List<Double>rr2List = new ArrayList<>();
        List<Double>rr5List = new ArrayList<>();

        String currentDir = "./testFiles/";

        for(int i = 0; i < 20; i++) {
            String currFile = currentDir + "test5/job" + i + ".txt";
            HashMap<Integer, Jobs> fcfs = getInput(currFile);
            HashMap<Integer, Jobs> sjf = getInput(currFile);
            HashMap<Integer, Jobs> rr2 = getInput(currFile);
            HashMap<Integer, Jobs> rr5 = getInput(currFile);
            /*
            fcfsTimes += FCFS.processFCFS(fcfs);
            sjfTimes += SJF.processSJF(sjf);
            rr2Times += RoundRobin2.processRoundRobin2(rr2);
            rr5Times += RoundRobin5.processRoundRobin5(rr5);

            fcfsList.add(FCFS.processFCFS(fcfs));
            sjfList.add(SJF.processSJF(sjf));
            rr2List.add(RoundRobin2.processRoundRobin2(rr2));
            rr5List.add(RoundRobin5.processRoundRobin5(rr5));
             */
        }
        /*
        System.out.println("FCFS Times");
        for(double d:fcfsList){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nSJF Times");
        for(double d:sjfList){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nRR2 Times");
        for(double d:rr2List){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nRR5 Times");
        for(double d:rr5List){
            System.out.printf("%f\r\n",d);
        }
         */

        fcfsTimes = 0; sjfTimes = 0; rr2Times = 0; rr5Times = 0;

        for(int i = 0; i < 20; i++) {
            String currFile = currentDir + "test10/job" + i + ".txt";
            HashMap<Integer, Jobs> fcfs = getInput(currFile);
            HashMap<Integer, Jobs> sjf = getInput(currFile);
            HashMap<Integer, Jobs> rr2 = getInput(currFile);
            HashMap<Integer, Jobs> rr5 = getInput(currFile);
            /*
            fcfsTimes += FCFS.processFCFS(fcfs);
            sjfTimes += SJF.processSJF(sjf);
            rr2Times += RoundRobin2.processRoundRobin2(rr2);
            rr5Times += RoundRobin5.processRoundRobin5(rr5);

            fcfsList.add(FCFS.processFCFS(fcfs));
            sjfList.add(SJF.processSJF(sjf));
            rr2List.add(RoundRobin2.processRoundRobin2(rr2));
            rr5List.add(RoundRobin5.processRoundRobin5(rr5));
             */
        }
        /*
        System.out.println("FCFS Times");
        for(double d:fcfsList){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nSJF Times");
        for(double d:sjfList){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nRR2 Times");
        for(double d:rr2List){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nRR5 Times");
        for(double d:rr5List){
            System.out.printf("%f\r\n",d);
        }
         */

        fcfsTimes = 0; sjfTimes = 0; rr2Times = 0; rr5Times = 0;

        for(int i = 0; i < 20; i++) {
            String currFile = currentDir + "test15/job" + i + ".txt";
            HashMap<Integer, Jobs> fcfs = getInput(currFile);
            HashMap<Integer, Jobs> sjf = getInput(currFile);
            HashMap<Integer, Jobs> rr2 = getInput(currFile);
            HashMap<Integer, Jobs> rr5 = getInput(currFile);
            /*
            fcfsTimes += FCFS.processFCFS(fcfs);
            sjfTimes += SJF.processSJF(sjf);
            rr2Times += RoundRobin2.processRoundRobin2(rr2);
            rr5Times += RoundRobin5.processRoundRobin5(rr5);
             */
            fcfsList.add(FCFS.processFCFS(fcfs));
            sjfList.add(SJF.processSJF(sjf));
            rr2List.add(RoundRobin2.processRoundRobin2(rr2));
            rr5List.add(RoundRobin5.processRoundRobin5(rr5));
        }
        System.out.println("FCFS Times");
        for(double d:fcfsList){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nSJF Times");
        for(double d:sjfList){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nRR2 Times");
        for(double d:rr2List){
            System.out.printf("%f\r\n",d);
        }
        System.out.println("\nRR5 Times");
        for(double d:rr5List){
            System.out.printf("%f\r\n",d);
        }
    }

    public static HashMap<Integer,Jobs> testFCFS(){
        HashMap<Integer, Jobs> jobList = new HashMap<>();

        jobList.put(0, new Jobs("Job1",3,false));
        jobList.put(1, new Jobs("Job2",16,false));
        jobList.put(2, new Jobs("Job3",2,false));
        jobList.put(3, new Jobs("Job4",24,false));
        jobList.put(4, new Jobs("Job5",22,false));

        return jobList;
    }

    public static HashMap<Integer, Jobs> getInput(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner fileScanner = new Scanner(file);
        HashMap<Integer, Jobs> jobList = new HashMap<>();
        int counter = 0;
        String name= "";
        int time = 0;
        while(fileScanner.hasNextLine()){
            try {
                name = fileScanner.next();
                time = fileScanner.nextInt();
            }catch(NoSuchElementException e){
                fileScanner.close();
                return jobList;
            }
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

    private static void initFiles() throws IOException {
        Random rd = new Random();
        String head = ".\\testFiles";

        for(int i = 0; i < 20; i++){
            String currFile = head+"\\test5\\job"+ i +".txt";
            FileWriter fw = new FileWriter(currFile);
            PrintWriter pw = new PrintWriter(fw);

            for(int j = 0; j < 5; j++){
                String outText = "Job"+ (j+1) +"\n" + (rd.nextInt(20)+1) + "\n";
                pw.write(outText);
            }
            pw.close();
        }

        for(int i = 0; i < 20; i++){
            String currFile = head+"\\test10\\job"+ i +".txt";
            FileWriter fw = new FileWriter(currFile);
            PrintWriter pw = new PrintWriter(fw);

            for(int j = 0; j < 10; j++){
                String outText = "Job"+ (j+1) +"\n" + (rd.nextInt(20)+1) + "\n";
                pw.write(outText);
            }
            pw.close();
        }

        for(int i = 0; i < 20; i++){
            String currFile = head+"\\test15\\job"+ i +".txt";
            FileWriter fw = new FileWriter(currFile);
            PrintWriter pw = new PrintWriter(fw);

            for(int j = 0; j < 15; j++){
                String outText = "Job"+ (j+1) +"\n" + (rd.nextInt(20)+1) + "\n";
                pw.write(outText);
            }
            pw.close();
        }
    }
}
