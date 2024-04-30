package MultiThreading;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RandomNumberGenerator implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random r = new Random();
        Integer number  = r.nextInt();
        return number;
    }
}

public class CallableExample {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        RandomNumberGenerator rg1 = new RandomNumberGenerator();
        RandomNumberGenerator rg2 = new RandomNumberGenerator();
        Future<Integer> number1 = executorService.submit(rg1);
        Future<Integer> number2 = executorService.submit(rg2);
        System.out.println(number1.get() + number2.get());
    }
}
