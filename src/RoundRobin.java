import java.util.*;

public class RoundRobin {

    public static void handleRR(HashMap<Integer, Jobs> myMap, int split) {
        int numJobsLeft = myMap.size();
        int currentTime = 0;
        Jobs currentJob;
        LinkedList<Jobs> jobLL = new LinkedList<Jobs>(myMap.values());
        ArrayList<Integer> stopTimes = new ArrayList<>();

        System.out.println("Round Robin Trace Table");
        System.out.println("--------------------------------");
        System.out.printf("%-9s%-8s%-6s%-9s\r\n","Job ID", "Start", "End", "Completed");
        System.out.println("--------------------------------");
        while(numJobsLeft > 0){
            currentJob = jobLL.poll();
            int timeRemaining = currentJob.processJob(split);
            if(currentJob.isComplete()){
                System.out.printf("%-9s%-8d%-6d%-9s\r\n",currentJob.getJobNum(),currentTime,currentTime+timeRemaining,currentJob.getJobNum()+" completed");
                currentTime += timeRemaining;
                stopTimes.add(currentTime);
                numJobsLeft--;
            }
            else{
                System.out.printf("%-9s%-8d%-6d\r\n",currentJob.getJobNum(),currentTime,currentTime+split,currentJob.getJobNum());
                currentTime+=split;
                jobLL.offer(currentJob);
            }
        }

        int sum = 0;
        double RTT = 0.0;
        for(int i = 0; i < stopTimes.size(); i++){
            sum += stopTimes.get(i);
        }
        RTT = sum / (float)(stopTimes.size());

        System.out.printf("Average RTT: %.5f\r\n",RTT);

//            if(currentJob.isComplete()) {
//                System.out.printf("%s Completed\r\n",currentJob.getJobNum());
//                numJobsLeft--;
//            }
//            else
//                jobLL.offer(currentJob);
//
//        }
    }

    public static void prettyPrint(Jobs currentJob){

    }
}
