/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: RoundRobin5.java
 * Description: This program will calculate the Average Turnaround Time (ATT) using the Round Robin
 *              scheduling algorithm with a time quantum of 5
 *
 */

import java.util.*;

public class RoundRobin5 {
    //Our time quantum for RR5
    private static final int RR5SPLIT = 5;

    /**
     * This method will use our RR-5 algorithm to process jobs with 5 instructions at a time
     * @param myMap - input HashMap
     * @return - ATT or 0 if HashMap is not initialized
     */
    public static double processRoundRobin5(HashMap<Integer, Jobs> myMap) {

        //check if HM is empty
        if(myMap.size() == 0){
            System.out.println("Input HashMap for RR-2 not initialized");
            return 0;
        }

        int numJobsLeft = myMap.size();
        int currentTime = 0;
        Jobs currentJob;

        //using linked list to offer at the end if job is not completed
        LinkedList<Jobs> jobLL = new LinkedList<Jobs>(myMap.values());

        //Using ArrayList for our stop times. will be summed up after handling jobs
        ArrayList<Integer> stopTimes = new ArrayList<>();

        System.out.println("Round Robin Trace Table - Quantum 5");
        System.out.println("--------------------------------");
        System.out.printf("%-9s%-8s%-6s%-9s\r\n","Job ID", "Start", "End", "Completed");
        System.out.println("--------------------------------");

        //while we still have jobs left in our linked list to process, perform the RR5 algorithm
        while(numJobsLeft > 0){
            //obtain copy of current HEAD of our linked list
            currentJob = jobLL.poll();

            //calculate the time remaining after processing the job for 5 instructions
            int timeRemaining = currentJob.processJob(RR5SPLIT);

            //if current job has a time of 0 then print out to user,obtain its stop time, and decrement the number of jobs left
            if(currentJob.isComplete()){
                System.out.printf("%-9s%-8d%-6d%-9s\r\n",currentJob.getJobNum(),currentTime,currentTime+timeRemaining,currentJob.getJobNum()+" completed");
                currentTime += timeRemaining;
                stopTimes.add(currentTime);
                numJobsLeft--;
            }
            //else add 5 to our total time and offer this job to the back of our linked list
            else{
                System.out.printf("%-9s%-8d%-6d\r\n",currentJob.getJobNum(),currentTime,currentTime+RR5SPLIT,currentJob.getJobNum());
                currentTime+=RR5SPLIT;
                jobLL.offer(currentJob);
            }
        }

        //calculate ATT by summing up all elements in our ArrayList then dividing by the size of our input HashMap
        int sum = 0;
        double ATT = 0.0;
        for(int i = 0; i < stopTimes.size(); i++){
            sum += stopTimes.get(i);
        }
        ATT = sum / (float)(stopTimes.size());

        System.out.printf("RR-5 ATT: %.5f\r\n",ATT);

        return ATT;
    }

}
