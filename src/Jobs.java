public class Jobs implements Comparable<Jobs>{
    private String jobId;
    private int jobTime;
    private boolean jobCompleted;

    public Jobs(){
        this.jobId = "JOB NOT INITIALIZED";
        this.jobTime = -999;
        this.jobCompleted = false;
    }
    public Jobs(String jobId, int jobTime, boolean complete) {
        this.jobId = jobId;
        this.jobTime = jobTime;
        this.jobCompleted = complete;
    }

    public String getJobNum(){return this.jobId;}
    public int getJobTime(){return this.jobTime;}
    public boolean isComplete(){return this.jobCompleted;}

    public int processJob(int splitTime){
        if(this.jobTime <= splitTime){
            int returnTime = this.jobTime;
            this.jobTime = 0;
            jobCompleted = true;
            return returnTime;
        }
        else {
            jobTime -= splitTime;
            return jobTime;
        }
    }

    @Override
    public int compareTo(Jobs o) {
        if(this.getJobTime() < o.getJobTime()) return -1;
        if(this.getJobTime() > o.getJobTime()) return 1;
        else return 0;
    }
}
