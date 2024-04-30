package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NumberPrinter implements Runnable {
    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Number: " + number + " " + Thread.currentThread().getName());
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i<= 100; i++) {
            if(i == 11 || i == 51 || i == 81){
                System.out.println("Hello"); // add debugger here to understand
            }
            NumberPrinter thread = new NumberPrinter(i);
            executor.submit(thread);
        }
    }
}
