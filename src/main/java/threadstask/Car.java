package threadstask;

public class Car extends Thread{

    private int waitTime;
    private int parkedTime;
    private Parking parking;
    private static int threadCount = 0;
    private int number = ++threadCount;

    public int getWaitTime(){ return waitTime;}

    public Car(int waitTime, int parkedTime, Parking parking){
        this.waitTime= waitTime;
        this.parkedTime = parkedTime;
        this.parking = parking;
        start();
    }


    @Override
    public void run(){
        try{
            boolean isAccepted = parking.park(this);
            if(isAccepted){
                wait(parkedTime);
                parking.release(this);
            } else{
                System.out.println("Thread number: " + number + " can't wait more");
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    public void wait(int miliseconds) throws InterruptedException{
        Thread.sleep(miliseconds);
    }

    @Override
    public String toString(){
        return "Thread number: " + number
                + " waitTime: " + waitTime
                + " parkedTime:" + parkedTime
                + "\n";
    }
}