/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: RoundRobin2.java
 * Description: This program will calculate the Average Turnaround Time (ATT) using the Round Robin
 *              scheduling algorithm with a time quantum of 2
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class RoundRobin2 {
    //Our time quantum for RR2
    private static final int RR2SPLIT = 2;

    /**
     * This method will use our RR-2 algorithm to process jobs with 2 instructions at a time
     * @param myMap - input HashMap
     * @return - ATT or 0 if HashMap is not initialized
     */
    public static double processRoundRobin2(HashMap<Integer, Jobs> myMap) {

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

        //Using ArrayList for our stoptimes
        ArrayList<Integer> stopTimes = new ArrayList<>();

        System.out.println("Round Robin Trace Table - Quantum 2");
        System.out.println("--------------------------------");
        System.out.printf("%-9s%-8s%-6s%-9s\r\n","Job ID", "Start", "End", "Completed");
        System.out.println("--------------------------------");

        //while loop to parse over the number of jobs left in our Linked List
        while(numJobsLeft > 0){
            //grab copy of head of our linked list
            currentJob = jobLL.poll();

            //calculate time remaining after deducting 2 instructions from our job
            int timeRemaining = currentJob.processJob(RR2SPLIT);

            //if job comes back complete, output to user, decrement our number of jobs, and add ending time to our arraylist
            if(currentJob.isComplete()){
                System.out.printf("%-9s%-8d%-6d%-9s\r\n",currentJob.getJobNum(),currentTime,currentTime+timeRemaining,currentJob.getJobNum()+" completed");
                currentTime += timeRemaining;
                stopTimes.add(currentTime);
                numJobsLeft--;
            }
            //if job is not complete, offer to tail of our linked list
            else{
                System.out.printf("%-9s%-8d%-6d\r\n",currentJob.getJobNum(),currentTime,currentTime+RR2SPLIT,currentJob.getJobNum());
                currentTime+=RR2SPLIT;
                jobLL.offer(currentJob);
            }
        }

        //calculate ATT using the sum of our stop times then dividing by the size of our input size
        int sum = 0;
        double ATT = 0.0;
        for(int i = 0; i < stopTimes.size(); i++){
            sum += stopTimes.get(i);
        }
        ATT = sum / (float)(stopTimes.size());

        System.out.printf("RR-2 ATT: %.5f\r\n",ATT);

        return ATT;

    }

}
