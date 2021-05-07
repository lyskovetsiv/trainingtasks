package threadstask;

import java.util.*;

public class Parking{

    private int carLimit;
    private List<Thread> parkedCars = new ArrayList<>();

    public Parking(int carLimit){
        this.carLimit = carLimit;
    }

    public synchronized boolean park(Car thread) throws InterruptedException{
        while(carLimit == 0) {
            wait(thread.getWaitTime());
            if(carLimit == 0) return false;
            else break;
        }
        carLimit--;
        parkedCars.add(thread);
        notifyAll();
        return true;
    }


    public synchronized void release(Car thread){
        if(parkedCars.contains(thread)){
            carLimit++;
            parkedCars.remove(thread);
        }
    }

}