/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: SJF.java
 * Description: This program will calculate the Average Turnaround Time (ATT) using the Shortest Job First
 *              scheduling algorithm
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SJF {
    /**
     * This method will process the HashMap based on the job length. Will prioritize the shortest job
     * @param map - input HashMap which was initialized
     * @return - double value which is computed from the ending times of each job or 0 if HashMap is not initialized
     */
    public static double processSJF(HashMap<Integer, Jobs> map){

        //check to see if HashMap is empty
        //check if HashMap is empty
        if(map.size() == 0){
            System.out.println("Input HashMap for SJF not initialized");
            return 0;
        }

        //ATT will keep track of total time used, prev is previous job, start is used for output to user
        double ATT = 0;
        int prev = 0;
        int start = 0;

        //Need to instantiate a list since HashMap cannot be sorted using Collections.sort()
        List<Jobs> jobTime = new ArrayList<>(map.values());

        //sort the list to give priority to the shortest job
        Collections.sort(jobTime);

        System.out.println("Shortest Job First Trace Table");
        System.out.println("--------------------------------");
        System.out.printf("%-9s%-8s%-6s%-9s\r\n","Job ID", "Start", "End", "Completed");
        System.out.println("--------------------------------");

        //main algorithm, will use the size of our List to iterate through and calculate our ATT for SJF
        for(int i = 0; i < jobTime.size(); i++){
            prev += jobTime.get(i).getJobTime();
            ATT += prev;
            System.out.printf("%-9s%-8d%-6d%-9s\r\n",jobTime.get(i).getJobNum(), start, start+=jobTime.get(i).getJobTime(), jobTime.get(i).getJobNum()+" completed");
        }

        System.out.printf("SJF ATT: %.5f\r\n",ATT/jobTime.size());

        //return our average time as a double
        return ATT / jobTime.size();
    }
}