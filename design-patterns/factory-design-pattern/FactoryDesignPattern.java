enum JobType{
    BULK_V1, BULK_V2, STANDARD 
}

abstract class Job{
    String jobId;
    abstract void run();
}

class BulkV1 extends Job{

    void run(){
        //BulkV1 specific implementation
        System.out.println("Bulk V1 Job");
    }
}

class BulkV2 extends Job{

    void run(){
        //BulkV2 specific implementation
        System.out.println("Bulk V2 Job");
        
    }
}

class Standard extends Job{

    void run(){
        //Standard specific implementation
        System.out.println("Standard Job");
    }
}


class JobFactory {

    public static Job getInstance(JobType jobType){
        switch(jobType){
            case BULK_V1: return new BulkV1(); 
            case BULK_V2: return new BulkV2();
            case STANDARD: return new Standard();
            default: return null;


        }
    }
}

public class FactoryDesignPattern{
    public static void main(String[] args) {
        Job job = JobFactory.getInstance(JobType.BULK_V1);
        job.run();
        job = JobFactory.getInstance(JobType.BULK_V2);
        job.run();
        job = JobFactory.getInstance(JobType.STANDARD);
        job.run();

    }
}