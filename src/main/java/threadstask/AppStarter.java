package threadstask;

import java.util.ArrayList;
import java.util.List;

public class AppStarter {
    public static void main (String[] args){
        int carCount = 100, parkingSlots = 20;
        Parking parking = new Parking(parkingSlots);
        waitCars(createCars(carCount, parking));

    }

    public static List<Thread> createCars(int carCount, Parking parking){
        List<Thread> carList = new ArrayList<>();
        for( int carNumber = 0; carNumber < carCount; carNumber++){
            int waitTime = (int) (Math.random() * 25);
            int parkedTime = (int) (Math.random() * 50);
            carList.add(new Car(waitTime, parkedTime, parking));
        }
        return carList;
    }

    public static void waitCars(List<Thread> threads){
        try{
            for(Thread thread: threads) thread.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}

