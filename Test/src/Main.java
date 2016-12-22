/**
 * Created by MacBookPro on 12/22/16.
 */
public class Main {
    public static class Counter{
        int count = 0;

        public synchronized int increase(int increment){
            return this.count += increment;
        }

    }

    public static class ThreadCounter extends Thread{
        public Counter counter;

        public ThreadCounter(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increase(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread first = new ThreadCounter(counter);
        Thread second = new ThreadCounter(counter);
        first.start();
        second.start();
        System.out.println(counter.count);


    }

}
