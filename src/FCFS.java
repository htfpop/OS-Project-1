/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: FCFS.java
 * Description: This program will calculate the Average Turnaround Time (ATT) using the First Come First Serve
 *              scheduling algorithm
 *
 */

import java.util.HashMap;
public class FCFS {

    /**
     * This method will process the HashMap in first come first serve basis
     * @param myMap - input HashMap which was initialized
     * @return - double value which is computed from the ending times of each job or 0 if HashMap is not initialized
     */
    public static double processFCFS(HashMap<Integer,Jobs> myMap){

        //check if HashMap is empty
        if(myMap.size() == 0){
            System.out.println("Input HashMap for FCFS not initialized");
            return 0;
        }

        //using ATT for total time, prev for previous job time, start for displaying output
        double ATT = 0;
        int prev = 0;
        int start = 0;

        System.out.println("First Come First Serve Trace Table");
        System.out.println("--------------------------------");
        System.out.printf("%-9s%-8s%-6s%-9s\r\n","Job ID", "Start", "End", "Completed");
        System.out.println("--------------------------------");

        //main algorithm using HashMap's size as exit condition
        for(int i = 0; i < myMap.size(); i++){
            //prev job time grabbed by Job's method getJobTime()
            prev += myMap.get(i).getJobTime();
            ATT += prev;

            //print out jobID, start time, end time, and status for user
            System.out.printf("%-9s%-8d%-6d%-9s\r\n",myMap.get(i).getJobNum(), start, start+=myMap.get(i).getJobTime(), myMap.get(i).getJobNum()+" completed");
        }

        //print out Avg. turnaround time for user then return ATT based on HashMap size
        System.out.printf("FCFS ATT: %.5f\r\n",ATT/myMap.size());
        return ATT / myMap.size();
    }
}
